package com.midel3.puzzles;

import com.midel3.Puzzle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Puzzle02 extends Puzzle {

    File file = new File("C:\\Users\\Mitchel\\Desktop\\input.txt");
    FileReader reader;

    {
        try {
            reader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Puzzle02() {

    }

    @Override
    public void solve() {
        char[] a = new char[4000];
        try {
            int charInt = reader.read(a);
            for(char c: a){
                System.out.print(c);
            }

        } catch (IOException e){
            System.out.println("IOException");
        } /*catch (FileNotFoundException e){
            System.out.println("file not found");
        }*/
    }
}
