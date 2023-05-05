package com.superdupermarket.app;

import java.util.ArrayList;

public class ArrayListTable {
    public static void printTable(ArrayList<String[]> table) {
        int[] maxLengths = new int[table.get(0).length];
        for (String[] row : table) {
            for (int col = 0; col < row.length; col++) {
                maxLengths[col] = Math.max(maxLengths[col], row[col].length());
            }
        }

        for (int rowIdx = 0; rowIdx < table.size(); rowIdx++) {
            String[] row = table.get(rowIdx);
            for (int col = 0; col < row.length; col++) {
                System.out.printf("%-" + maxLengths[col] + "s", row[col]);
                if (col < row.length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();

            if (rowIdx == 0) {
                for (int col = 0; col < row.length; col++) {
                    for (int i = 0; i < maxLengths[col]; i++) {
                        System.out.print("-");
                    }
                    if (col < row.length - 1) {
                        System.out.print("-+-");
                    }
                }
                System.out.println();
            }
        }
    }
}
