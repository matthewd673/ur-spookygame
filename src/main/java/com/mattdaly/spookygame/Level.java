/**
 * Level.java
 * 10/28/20
 * takes inputs from text files and stores them in arrays for specific levels
 */
package com.mattdaly.spookygame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
public class Level {

    ArrayList<String[]> rows;


    public Level(String lev){
        rows = new ArrayList<>();
        split(lev);

    }

    //takes input from a text file and splits it into an ArrayList
    public void split(String lev){

        String filePath = lev;
        try { BufferedReader br = new BufferedReader(new FileReader(filePath));

            File myObj = new File(lev);

            String line;

            while ((line = br.readLine()) != null) {
                rows.add(line.split(" "));

            }

        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }


}
