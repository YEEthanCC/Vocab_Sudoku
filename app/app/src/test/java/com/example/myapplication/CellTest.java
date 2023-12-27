package com.example.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;

import android.widget.Button;

import java.util.HashSet;

import java.util.Set;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CellTest {
    Cell TEST_CELL = new Cell("Test_word", "Test_answer");

    @Test
    // expect the function to correctly return the input word
    public void getWord() {
        assertEquals("Test_word", TEST_CELL.getWord());
    }

    @Test
    // expect the function to correctly return the input answer
    public void getAnswer() {
        assertEquals("Test_answer", TEST_CELL.getAnswer());
    }

    @Test
    // expect the function to set the input word correctly
    public void setWord() {
        TEST_CELL.setWord("setWord_example");
        assertEquals("setWord_example", TEST_CELL.getWord());
    }

    @Test
    // expect the function to set the answer correctly
    public void setAnswer() {
        TEST_CELL.setAnswer("setAnswer_example");
        assertEquals("setAnswer_example", TEST_CELL.getAnswer());
    }

    @Test
    // expect the function to set the word and answer correctly
    public void setValue() {
        TEST_CELL.setValue("setValue_Word", "setValue_Answer");
        assertEquals("setValue_Word",TEST_CELL.getWord());
        assertEquals("setValue_Word", TEST_CELL.getWord());
    }
}
