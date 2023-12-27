package com.example.myapplication;

import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Sudoku {
    private Cell[][] grid;
    private String[] vocab_word_lst;
    private String[] vocab_answer_lst;
    public Sudoku() {
        this.grid = new Cell[9][9];
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                grid[i][j]=new Cell(null,null);
            }
        }

        // Needs to be refactored to contain both questions and answers
        this.vocab_word_lst = new String[]{"Apple","Banana","Carrot","Dates","Orange","Pear","Tomato","Spinach","Broccoli"};
        this.vocab_answer_lst = new String[]{"Pomme","Banane","carotte","dattes","orange","poire","Tomate","epinard","Brocoli"};
    }

    public void fill_diagonal(){
        Cell cell = new Cell();
        List<Cell> lst = new ArrayList<Cell>();
        int[] index_lst={0,1,2,3,4,5,6,7,8};
        for(int i=0; i<9; i+=3){
            randomize(index_lst, 9);
            int r=0;
            for(int j=i; j<i+3; j++){
                for(int k=i; k<i+3; k++){
                    grid[j][k].setWord(vocab_word_lst[index_lst[r]]);
                    grid[j][k].setAnswer(vocab_answer_lst[index_lst[r]]);
                    r++;
                }
            }
        }
    }

    public void randomize(int[]arr, int len){
        int i=len-1;
        while(i>0){
            int index=(int)(Math.random()*(i-0+1)+0);
            int temp=arr[i];
            arr[i]=arr[index];
            arr[index]=temp;
            i--;
        }
    }

    public boolean is_safe(int row, int col, String val){
        for(int i=0; i<9; i++){
            if(grid[row][i].getWord()==val && i != col){
                return false;
            }
        }
        for(int j=0; j<9; j++){
            if(grid[j][col].getWord()==val && j != row){
                return false;
            }
        }
        int temp_row=3*(row/3);
        int temp_col=3*(col/3);
        for(int k=temp_row; k<temp_row+3; k++){
            for(int r=temp_col; r<temp_col+3; r++){
                if(grid[k][r].getWord()==val && k != row && r!=col){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean fill_remain(int row, int col){
        // check still in grid
        if(row>8){
            return true;
        }
        // check empty cell
        if(grid[row][col].getWord()!=null){
            if(col==8){
                return fill_remain(row+1,0);
            }
            else{
                return fill_remain(row,col+1);
            }
        }
        for(int i=0; i<9; i++){
            if(is_safe(row, col, vocab_word_lst[i])){
                grid[row][col].setValue(vocab_word_lst[i], vocab_answer_lst[i]);
                if(col==8){
                    if(fill_remain(row+1,0)){
                        return true;
                    }
                }
                else{
                    if(fill_remain(row,col+1)){
                        return true;
                    }
                }
            }
        }
        grid[row][col].setValue(null,null);
        return false;
    }

    public Cell[][] getGrid(){
        return grid;
    }
}




