package com.example.myapplication;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.HashSet;

import java.util.Set;


import com.example.myapplication.HelperMethods;



public class SudokuTest {


    @Test
    // expected no empty cell found after the the function is implemented on a partially filled sudoku
    public void fill_diagonal() {
        Sudoku TEST_SUDOKU = new Sudoku();
        Cell[][] TEST_GRID = TEST_SUDOKU.getGrid();
        TEST_SUDOKU.fill_diagonal();
        boolean isEmpty = false;
        for(int i=0; i<9; i+=3){

            for(int j=i; j<i+3; j++){
                for(int k=i; k<i+3; k++){
                    // fail if empty cell is found in the diagonal blocks
                    assertEquals(false,TEST_GRID[j][k].equals(null));
                }
            }
        }
    }

    @Test
    // expected the integer arrays have no repeated order after undergo the randomize() function
    public void randomize() {
        Sudoku TEST_SUDOKU = new Sudoku();
        boolean isEqual = false;
        int[] TEST_ARR = {1,2,3,4,5,6,7,8,9};
        int[] PREV_TEST_ARR = {1,2,3,4,5,6,7,8,9};
        for (int i = 0; i < 5; i++){
            TEST_SUDOKU.randomize(TEST_ARR, 9);
            // fail if two arrays has the same orders
            assertEquals(false,TEST_SUDOKU.equals(PREV_TEST_ARR));
        }
    }

    @Test
    // expected every value input the is_safe method found to be safe will only have one occurrence in the cell's block, row, and column
    public void is_safe() {
        Sudoku TEST_SUDOKU=new Sudoku();
        TEST_SUDOKU.fill_diagonal();
        TEST_SUDOKU.fill_remain(0,0);
        Cell[][]TEST_GRID=TEST_SUDOKU.getGrid();
        for(int row = 0; row<9; row++){
            for(int col = 0; col<9; col++){
                int temp_row=3*(row/3);
                int temp_col=3*(col/3);
                // test block
                for(int k=temp_row; k<temp_row+3; k++){
                    for(int r=temp_col; r<temp_col+3; r++){
                        assertEquals(false,TEST_GRID[k][r].getWord().equals(TEST_GRID[row][col]) && k != row && r != col);

                    }
                }
                // test column
                for(int i=0; i<9; i++){
                    // fail if same word is found in the same column while is_safe did not detect it
                    assertEquals(TEST_GRID[row][i].getWord().equals(TEST_GRID[row][i].getWord()),
                            TEST_SUDOKU.is_safe(row, col, TEST_GRID[row][col].getWord()));
                }
                // test row
                for(int j=0; j<9; j++){
                    // fail if same word is found in the same row while is_safe did not detect it
                    assertEquals(TEST_GRID[j][col].getWord().equals(TEST_GRID[j][col].getWord()),
                            TEST_SUDOKU.is_safe(row, col, TEST_GRID[row][col].getWord()));
                }

            }
        }
    }

    @Test
    // expected every cell is filled and each value of the cell would only have one occurrence in the cell's block, column, and row
    public void fill_remain() {
        Sudoku TEST_SUDOKU=new Sudoku();
        TEST_SUDOKU.fill_diagonal();
        TEST_SUDOKU.fill_remain(0,0);
        Cell[][]TEST_GRID=TEST_SUDOKU.getGrid();
        for(int i = 0; i<9; i++) {
            for (int j = 0; j < 9; j++) {
                assertEquals(false,TEST_GRID[i][j].getWord().equals(null));
                assertEquals(true, TEST_SUDOKU.is_safe(i, j, TEST_GRID[i][j].getWord()));
            }
        }
    }

    @Test
    // expect no the getGrid method would return 9*9 cell array with no empty cell
    public void getGrid() {
        Sudoku TEST_SUDOKU=new Sudoku();
        TEST_SUDOKU.fill_diagonal();
        TEST_SUDOKU.fill_remain(0,0);
        Cell[][]TEST_GRID=TEST_SUDOKU.getGrid();
        for(int i = 0; i<9; i++) {
            for (int j = 0; j < 9; j++) {
                assertEquals(false,TEST_GRID[i][j].getWord().equals(null));
            }
        }
    }
}