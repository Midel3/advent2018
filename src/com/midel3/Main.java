package com.midel3;

import com.midel3.puzzles.Puzzle01;
import com.midel3.puzzles.Puzzle02;
import com.midel3.puzzles.Puzzle03;

public class Main {

    /**
     * Executer for puzzle classes
     * @param args
     */
    public static void main(String[] args) {
        Puzzle puzzle = new Puzzle03();

        puzzle.solve();
    }
}
