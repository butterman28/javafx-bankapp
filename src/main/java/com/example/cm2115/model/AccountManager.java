package com.example.cm2115.model;

import com.example.cm2115.CSVHandler;

import java.io.IOException;
import java.util.List;

public class AccountManager {
    private static String filePath = "src/main/resources/com/example/cm2115/customer.csv";
    private static String filePath1 = "src/main/resources/com/example/cm2115/account.csv";
    public static void addcustomer(List<String[]> customerToWrite, List<String[]> accountToWrite) {

        try {
            CSVHandler.appendtoCSV(filePath, customerToWrite);
            CSVHandler.appendtoCSV(filePath1, accountToWrite);
            System.out.println("Data written to CSV file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately (e.g., show an error message)
        }
    }




}
