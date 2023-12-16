package com.example.cm2115.model;

import com.example.cm2115.CSVHandler;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class customer {

    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty address = new SimpleStringProperty();
    private final StringProperty customerType = new SimpleStringProperty();
    private List<String> customerList = new ArrayList<>();
    private List<String> acctnumbliist = new ArrayList<>();
    private List<String> accountsList = new ArrayList<>();
    public static List<String[]> accounts = new ArrayList<>();
    public static List<String[]> customers = new ArrayList<>();
    private static String filePath = "src/main/resources/com/example/cm2115/customer.csv";
    private static String filePath1 = "src/main/resources/com/example/cm2115/account.csv";
    private static String cid;

    // Constructor

    public static List<String>getcustomer(String acctname) {
        List<String> customerList = new ArrayList<>();
        try {
            customers = CSVHandler.readCSV(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Check in customer CSV
        for (String[] row : customers) {
            for (String value : row) {
                if (value.toLowerCase().equals(acctname)) {
                    // Matching value found in customer CSV
                    //System.out.println("Found matching value in customer CSV: " + value);
                    for (String value1 : row) {
                        //System.out.println("Processing value: " + value1);
                        customerList.add(value1);
                    }
                    // Add your logic here for further processing
                }
            }
            
        }
        cid = customerList.get(0);
        return customerList;
    }
    public static List<String> getaccountdetails(String accountnumber){
        List<String> fetchedaccount = new ArrayList<>();
        for (String[] row : accounts) {
            for (String value : row) {
                if (value.toLowerCase().equals(accountnumber)) {
                    // Matching value found in account CSV
                    //System.out.println("Found matching value in account CSV: " + value);
                    for (String value1 : row) {
                        System.out.println("Processing value: " + value1);
                        fetchedaccount.add(value1);
                    }
                    // Add your logic here for further processing
                }
            }
        }

        return fetchedaccount;
    }
    public static List<String> getaccount(String acctname){
        try {
            accounts = CSVHandler.readCSV(filePath1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<String> accountsList = new ArrayList<>();
            // Check in account CSV
        for (String[] row : accounts) {
            for (String value : row) {
                if (value.toLowerCase().equals(cid)) {
                        // Matching value found in account CSV
                    //System.out.println("Found matching value in account CSV: " + value);
                    for (String value1 : row) {
                        System.out.println("Processing value: " + value1);
                        accountsList.add(value1);
                    }
                        // Add your logic here for further processing
                }
            }
        }
        return accountsList;
    }
    public static String getaccountlist (String acctname){
        List<String> acctnumbliist = new ArrayList<>();
        // Check in account CSV
        for (int j = 0; j < customers.size(); j++) {
            String[] row = accounts.get(j);
            String[] row1 = customers.get(j);
            for (int i = 0; i < row1.length; i++) {
                if (row1[i].toLowerCase().equals(acctname)) {
                    acctnumbliist.add(row[1]);
                    // Matching value found in account CSV
                    //System.out.println("Found matching value in account CSV: ");
                }
            }
        }
        String out = String.join(", ", acctnumbliist);
        System.out.println(acctnumbliist);
        return out;
    }
}
