package com.example.cm2115.model;

import com.example.cm2115.CSVHandler;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

abstract class BankAccount {
    private static String filePath = "src/main/resources/com/example/cm2115/customer.csv";
    private static String filePath1 = "src/main/resources/com/example/cm2115/account.csv";
    private static int index;
    int accountNumber;
    int sortcode;
    int balance;
    public static List<String[]> accounts = customer.accounts;
    public static List<String[]> customers = new ArrayList<>();
    String accountName;
    public static String withdraw (int amount,int balance,String thisaza) throws IOException{
        int balupdate = 0;
        if (amount <= balance) {
            balupdate = balance - amount;
            for (int j = 0; j < accounts.size(); j++) {
                String[] row = accounts.get(j);
                for (int i = 0; i < row.length; i++) {
                    String value = row[i];
                    if (value.equals(thisaza)) {
                        row[3] = String.valueOf(balupdate);
                        index = j;
                        accounts.set(index,row);// Return the index when acctname is found
                }
            }
        }try {
                CSVHandler.writeCSV(filePath1, accounts);
                System.out.println("Data written to CSV file successfully.");
            } catch (IOException e) {
                e.printStackTrace();
                // Handle the exception appropriately (e.g., show an error message)
            }
        }

        if (amount <= balance)
        {return String.valueOf(balupdate);}else{
            return "insufficent funds";}

    }
    public static String deposit(int amount,int balance,String thisaza) throws IOException {
        int balupdate = amount + balance;
        String.valueOf(balupdate);
        for (int j = 0; j < accounts.size(); j++) {
            String[] row = accounts.get(j);
            for (int i = 0; i < row.length; i++) {
                String value = row[i];
                if (value.equals(thisaza)) {
                    row[3] = String.valueOf(balupdate);
                    int rowindex = j;
                    accounts.set(rowindex,row);// Return the index when acctname is found
                }
            }
        }
        try {
            CSVHandler.writeCSV(filePath1, accounts);
            System.out.println("Data written to CSV file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately (e.g., show an error message)
        }


        return String.valueOf(balupdate);
    }

}
