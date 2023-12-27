package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    // Dialog
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private TextView givenWordText;
    private EditText answerInputField;
    private Button confirm, cancel;
    private ImageButton add_btn;

    // Timer
    TextView timerText;
    boolean timerStarted = false;
    Button startBtn;
    Timer timer;
    TimerTask timerTask;
    Double time = 0.0;

    HelperMethods hm = new HelperMethods();

    //Sudoku
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        //Timer
        startBtn = (Button)findViewById(R.id.playbtn);
        timerText = (TextView)findViewById(R.id.timer);
        timer = new Timer();

        //Add Btn
        add_btn = (ImageButton) findViewById(R.id.add_btn);
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!timerText.getText().equals("00 : 00 : 00")){
                    add_new_vocab_dialog();
                } else {
                    Intent intent = new Intent(MainActivity.this, VocabEntryActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    // Timer
    public void startOrEndGame(View view){
        if(timerStarted == false){
            timerStarted = true;
            setButtonUI("Stop", R.color.white);
            TableLayout tableLayout = (TableLayout)findViewById(R.id.sudoku_table);
            Button[][] buttons = hm.fillButton(tableLayout, this);
            start_game(buttons);
            startTimer();
        }
        else{
            resetTimer();
        }
    }

    private void setButtonUI(String start, int color) {
        startBtn.setText(start);
        startBtn.setTextColor(ContextCompat.getColor(this, color));
    }

    private void startTimer() {
        timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        time++;
                        timerText.setText(hm.getTimerText(time));
                    }
                });
            }
        };
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }

    void start_game(Button[][] buttons){
        Cell[][] puzzle = hm.buildSudoku().getGrid();
        int[] emptyCell = hm.empty_cell(5);
        boolean isEmpty = false;
        for (int i = 0; i<9; i++){
            for (int j = 0; j<9; j++){
                for(int k=0; k < emptyCell.length; k++) {
                    int row = (emptyCell[k] / 10) -1;
                    int col = (emptyCell[k] % 10) -1;
                    if(col < 0){
                        col = 1;
                    }
                    if (i == row && j == col) {
                        isEmpty = true;
                    }
                }
                if (isEmpty == false){
                    String word = puzzle[i][j].getWord();
                    buttons[i][j].setText(puzzle[i][j].getWord().substring(0,3));
                    buttons[i][j].setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View view){
                            createGivenDialog(word);
                        }
                    });
                }
                else{
                    puzzle[i][j].setBtn(buttons[i][j]);
                    Button btn = puzzle[i][j].getBtn();
                    String word = puzzle[i][j].getWord();
                    String answer = puzzle[i][j].getAnswer();

                    buttons[i][j].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            createInputDialog(btn, word, answer, puzzle);
                        }
                    });
                }
                isEmpty = false;
            }
        }
    }

    // Dialogs
    public void resetTimer() {
        AlertDialog.Builder resetAlert = new AlertDialog.Builder(this);
        resetAlert.setTitle(("Reset"));
        resetAlert.setMessage("Are you sure? The board will reset.");
        resetAlert.setPositiveButton("Reset", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(timerTask != null){
                    timerStarted = false;
                    timerTask.cancel();
                    TableLayout sudoku = (TableLayout) findViewById(R.id.sudoku_table);
                    sudoku.removeAllViews();
                    setButtonUI("Play", R.color.white);
                    time = 0.0;
                    timerStarted = false;
                    timerText.setText(hm.formatTime(0,0,0));
                }
            }
        });
        resetAlert.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // do nothing
            }
        });
        resetAlert.show();
    }

    private void add_new_vocab_dialog() {
        AlertDialog.Builder resetAlert = new AlertDialog.Builder(this);
        resetAlert.setTitle(("Add New Vocab"));
        resetAlert.setMessage("Current game running. Board will reset if you continue.");
        resetAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(timerTask != null){
                    timerStarted = false;
                    timerTask.cancel();
                    TableLayout sudoku = (TableLayout) findViewById(R.id.sudoku_table);
                    sudoku.removeAllViews();
                    setButtonUI("Play", R.color.white);
                    time = 0.0;
                    timerStarted = false;
                    timerText.setText(hm.formatTime(0,0,0));
                    Intent intent = new Intent(MainActivity.this, VocabEntryActivity.class);
                    startActivity(intent);
                }
            }
        });
        resetAlert.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        resetAlert.show();
    }

    public void createInputDialog(Button btn, String word, String answer, Cell[][] puzzle){
        dialogBuilder = new AlertDialog.Builder(this);
        final View popupView = getLayoutInflater().inflate(R.layout.activity_dialog, null);
        givenWordText = (TextView) popupView.findViewById(R.id.givenWordText);
        answerInputField = (EditText) popupView.findViewById(R.id.answerInputField);
        confirm = (Button)popupView.findViewById(R.id.confirm);
        cancel = (Button)popupView.findViewById(R.id.cancel);
        givenWordText.setText(word);
        dialogBuilder.setView(popupView);
        dialog = dialogBuilder.create();
        dialog.show();
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String givenAnswer = answerInputField.getText().toString().toUpperCase();
                if(givenAnswer.equals(answer.toUpperCase())){
                    btn.setText(answer.substring(0,3));
                    Toast t = Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT);
                    t.show();
                    boolean isComplete = hm.checkBoardCompletion(puzzle);
                    if(isComplete){
                        Toast x = Toast.makeText(getApplicationContext(), "Game is complete. Your score is " + timerText.getText(), Toast.LENGTH_SHORT);
                        timerTask.cancel();
                        x.show();
                    }
                    dialog.dismiss();
                } else {
                    Toast t = Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT);
                    t.show();
                    dialog.dismiss();
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    private void createGivenDialog(String word) {
        dialogBuilder = new AlertDialog.Builder(this);
        final View popupView = getLayoutInflater().inflate(R.layout.activity_given_dialog, null);
        givenWordText = (TextView) popupView.findViewById(R.id.givenWordText);
        givenWordText.setText(word);
        dialogBuilder.setView(popupView);
        dialog = dialogBuilder.create();
        dialog.show();
        cancel = (Button)popupView.findViewById(R.id.cancel_given_dialog);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

}