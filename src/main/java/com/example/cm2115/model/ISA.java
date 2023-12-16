package com.example.cm2115.model;

import com.example.cm2115.CSVHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ISA extends BankAccount implements SavingsAccount{
    private static int index;
    public static List<String[]> irate = new ArrayList<>();
    private static String ratefilePath = "src/main/resources/com/example/cm2115/rate.csv";
    public static void applyInterest(String thisaza1) throws IOException {
        String[] row1 = irate.get(0);
        int intrate = Integer.parseInt(row1[0]);
        String inibalance;
        float ir =intrate/100;
        for (int j = 0; j < accounts.size(); j++) {
            String[] row = accounts.get(j);
            for (int i = 0; i < row.length; i++) {
                String value = row[i];
                if (value.equals(thisaza1)) {
                    inibalance = row[3];
                    row[3] = String.valueOf(ir *Integer.parseInt(inibalance));
                    index = j;
                    accounts.set(index,row);// Return the index when acctname is found
                }
            }
        }
    }
    public static String getinterestRate() throws IOException {
        try {
             irate= CSVHandler.readCSV(ratefilePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        };
        String[] row1 = irate.get(0);
        return row1[0];
    }
    public static void setinterestRate(int rate) throws IOException {
        irate.add(new String[]{String.valueOf(rate)});
        try {
            CSVHandler.writeCSV(ratefilePath, irate);
            System.out.println("Data written to CSV file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately (e.g., show an error message)
        }
    }
    public static String getbalance(String account) throws IOException{
        String balance = null;
        for (int j = 0; j < accounts.size(); j++) {
            String[] row = accounts.get(j);
            for (int i = 0; i < row.length; i++) {
                String value = row[i];
                if (value.equals(account)) {
                    balance= row[3];
                }
            }
        }

        return balance;
    }

}
