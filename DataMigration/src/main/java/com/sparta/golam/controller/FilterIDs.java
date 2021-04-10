package com.sparta.golam.controller;

import com.sparta.golam.controller.FileReader;

import java.util.ArrayList;

public class FilterIDs {
    private static ArrayList<String[]> withDuplicates = FileReader.readCSV();

    public static ArrayList<String[]> findOriginalIDs() {
        int totalRows = withDuplicates.size();

        ArrayList<String> originalIDs = new ArrayList<>();
        ArrayList<String[]> originalRows = new ArrayList<>();

        originalIDs.add(withDuplicates.get(1)[0]);
        originalRows.add(withDuplicates.get(1));

        for(int i = 1; i < totalRows; i++) {
            int counter = 0;
            for (String ID: originalIDs) {
                if (withDuplicates.get(i)[0].equals(ID)){
                    counter++;
                }
            }
            if (counter == 0) {
                originalIDs.add(withDuplicates.get(i)[0]);
                originalRows.add(withDuplicates.get(i));
            }
        }
        return originalRows;
    }
}
