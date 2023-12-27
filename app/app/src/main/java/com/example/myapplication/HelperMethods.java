package com.example.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class HelperMethods {
    public boolean checkBoardCompletion(Cell[][] puzzle){
        boolean flag = true;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                // The non empty squares are null. We need to look past those.
                if(puzzle[i][j].getBtn() != null){
                    //we can be sure it is now a btn
                    if(String.valueOf(puzzle[i][j].getBtn().getText()).equals("")){
                        flag = false;
                    }
                }
            }
        }
        return flag;
    }

    public int[] empty_cell(int num){
        ArrayList<Integer> arr=new ArrayList<Integer>(num);
        int[] rtn = new int[num];
        int i=0;
        while(i<num){
            int max = 99, min = 11, range = max - min + 1;
            int val=(int)(Math.random() * range) + min;
            if(arr.contains(val)==false){
                arr.add(val);
                rtn[i]=val;
                i++;
            }
        }
        return rtn;
    }

    public String getTimerText(double time) {
        int rounded = (int) Math.round(time);
        int seconds = ((rounded % 86400) % 3600) % 60;
        int minutes = ((rounded % 86400) % 3600) / 60;
        int hours = ((rounded % 86400) / 3600);

        return formatTime(seconds, minutes, hours);
    }

    public String formatTime(int seconds, int minutes, int hours) {
        return String.format("%02d", hours) + " : " + String.format("%02d", minutes)
                + " : " + String.format("%02d", seconds);
    }

    public Button[][] fillButton(TableLayout tableLayout, Context t){
        Button[][] buttons=new Button[9][9];
//        tableLayout = (TableLayout)findViewById(R.id.sudoku_table);
        for (int i = 0; i<9; i++){
            TableRow tableRow = new TableRow(t);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT
            ));
            if(i % 3 == 0){
                TableLayout.LayoutParams params = new TableLayout.LayoutParams(
                        TableLayout.LayoutParams.WRAP_CONTENT,
                        TableLayout.LayoutParams.WRAP_CONTENT
                );
                params.setMargins(0, 15, 0, 0);
                tableRow.setLayoutParams(params);
            }
            tableLayout.addView(tableRow);
            //puts button in the row
            for (int j = 0; j<9; j++){
                Button button = new Button(t);
                button.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1.0f));
                GradientDrawable drawable = new GradientDrawable();
                drawable.setShape(GradientDrawable.RECTANGLE);
                drawable.setStroke(5, 354,0,0);
                drawable.setColor(Color.parseColor("#354F52"));
                button.setBackgroundDrawable(drawable);
                button.setTextColor(Color.WHITE);
                tableRow.addView(button);
                buttons[i][j] = button;
            }
        }
        return buttons;
    }



    Sudoku buildSudoku(){
        Sudoku puzzle=new Sudoku();
        puzzle.fill_diagonal();
        puzzle.fill_remain(0,0);
        return puzzle;
    }
}
