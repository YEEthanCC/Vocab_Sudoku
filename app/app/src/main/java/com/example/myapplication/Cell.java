package com.example.myapplication;

import android.widget.Button;

public class Cell {
    private String word;
    private String answer;
    private Button btn; //get the btn so we can change it's text

    public Cell(String word, String answer) {
        this.word = word;
        this.answer = answer;
    }
    public Cell() {
        this.word = "";
        this.answer = "";
    }
    public String getWord() {
        return word;
    }

    public String getAnswer() {
        return answer;
    }
    public Button getBtn() {
        return btn;
    }
    public void setBtn(Button btn) {
        this.btn = btn;
    }
    public void setWord(String word) {
        this.word = word;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public void setValue(String value1, String value2){
        this.word = value1;
        this.answer = value2;
    }
}
