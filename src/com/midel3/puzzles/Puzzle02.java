package com.midel3.puzzles;

import com.midel3.Puzzle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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


    public ArrayList<Integer> readInput(){
        char[] a = new char[4000];
        ArrayList<Integer> finalArray = new ArrayList<>();
        try {
            reader.read(a);
            StringBuilder sb  = new StringBuilder();
            for(int i = 0; i < a.length; i++){
                char c = a[i];
                if ((c >= '0' && c <= '9') || c == '-') {
                    sb.append(c);
                } else {
                    try {
                        if (Integer.parseInt(sb.toString()) == 0) {
                            break;
                        } else {
                            finalArray.add(Integer.parseInt(sb.toString()));
                        }

                    } catch (NumberFormatException e) {
                        // System.out.println(e);
                    }
                    sb = new StringBuilder();
                }
            }
            reader.close();
        } catch (IOException e){
            System.out.println("IOException");
        }
        return finalArray;
    }

    public int getDoubleFreq(ArrayList<Integer> input){
        Integer freq = 0;
        ArrayList<Integer> tempStack = new ArrayList<>();
        tempStack.add(freq);
        int i = 0;
        do {
            freq += input.get(i);
            if (tempStack.contains(freq)){
                return freq;
            } else {
                tempStack.add(freq);
                i++;
            }
            if (i >= input.size()){
                i = 0;
            }
        } while (true);
    }

    @Override
    public void solve() {
        System.out.println(this.getDoubleFreq(this.readInput()));
    }
}
