package com.midel3.puzzles;

import com.midel3.Puzzle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Puzzle03 extends Puzzle {

    private int sumTwos = 0;
    private int sumThrees = 0;


    File file = new File("C:\\Users\\Mitchel\\Documents\\Codes\\Advent 2018\\input02.txt");
    FileReader reader;

    {
        try {
            reader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> readInput(){
        char[] a = new char[7000];
        ArrayList<String> finalArray = new ArrayList<>();
        try {
            reader.read(a);
            StringBuilder sb  = new StringBuilder();
            for(int i = 0; i < a.length; i++){
                char c = a[i];
                if (c >= 'a' && c <= 'z') {
                    sb.append(c);
                } else {
                    if (sb.toString() != ""){
                        finalArray.add(sb.toString());
                        sb = new StringBuilder();
                    }
                }
            }
            reader.close();
        } catch (IOException e){
            System.out.println("IOException");
        }
        return finalArray;
    }

    public void getSumTwosThrees(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            boolean gotTwo = false;
            boolean gotThree = false;
            for (int j = 0; j < list.get(i).length(); j++) {
                String currentChar = Character.toString(list.get(i).charAt(j));
                int count = list.get(i).length() - list.get(i).replaceAll(currentChar,"").length();
                if (count == 3 && !gotThree) {
                    // System.out.println("word: " + list.get(i) + ", has three: " + currentChar);
                    this.sumThrees++;
                    gotThree = true;
                } else if (count == 2 && !gotTwo) {
                    // System.out.println("word: " + list.get(i) + ", has two: " + currentChar);
                    this.sumTwos++;
                    gotTwo = true;
                }
            }
        }
    }

    public int getCheckSum(int a, int b){
        return a*b;
    }


    @Override
    public void solve() {
        ArrayList<String> words = this.readInput();
        this.getSumTwosThrees(words);
        for (int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i));
        }

        System.out.println("Two's: " + this.sumTwos);
        System.out.println("Three's: " + this.sumThrees);
        System.out.println(this.getCheckSum(this.sumTwos, this.sumThrees));
    }
}
