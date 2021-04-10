package com.sparta.golam.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class FileReader {

    private static String FilePath = "C:\\Users\\Rahi\\Desktop\\Sparta\\Projects\\DataMigrationProject\\employees.csv";

    public static ArrayList<String[]> readCSV() {

        BufferedReader fileReader;
        ArrayList<String[]> data = new ArrayList<>();
        String row;
        try {
            fileReader = new BufferedReader(new java.io.FileReader(FilePath));
            while((row = fileReader.readLine()) != null) {
                String[] info = row.split(",");
                data.add(info);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void threading() {

    }
}
