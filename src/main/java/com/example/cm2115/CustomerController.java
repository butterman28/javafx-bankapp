package com.example.cm2115;

import com.example.cm2115.model.ISA;
import com.example.cm2115.model.customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CustomerController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label name;
    @FXML
    private Label addresslabel;
    private List<String> customerList = new ArrayList<>();
    private List<String> acctnumbliist = new ArrayList<>();
    private List<String> accountsList = new ArrayList<>();
    private List<String[]> account = new ArrayList<>();
    private List<String[]> customers = new ArrayList<>();
    private List<String> fetchedacct = new ArrayList<>();
    @FXML
    private Label custype;
    private String index;
    private String savingsrate;
    @FXML
    private Label blabel;
    @FXML
    private Label sort;
    @FXML
    private Label atype;
    @FXML
    private Label acctnumb;
    @FXML
    private Label hiddensavings;
    @FXML
    private TextField acctget;
    @FXML
    private TextField changename;
    @FXML
    private TextField addresschange;
    @FXML
    private TextField typechange;
    public void getaccounts(ActionEvent event) throws IOException {
        String aza = acctget.getText().toLowerCase();
        fetchedacct = customer.getaccountdetails(aza);
        blabel.setText("Account Name :" + fetchedacct.get(3));
        sort.setText("Sort Number :" + fetchedacct.get(0) );
        atype.setText("Address :" + fetchedacct.get(4));


    }
    public void updatecustomer(ActionEvent event) throws IOException {
        String filePath = "src/main/resources/com/example/cm2115/customer.csv";
        String filePath1 = "src/main/resources/com/example/cm2115/account.csv";
        String name1 = changename.getText().toLowerCase();
        String newadd  = addresschange.getText().toLowerCase();
        String newtype = typechange.getText().toLowerCase();
        for (int j = 0; j < customers.size(); j++) {
            String[] row = customers.get(j);
            for (int i = 0; i < row.length; i++) {
                String value = row[i];
                if (value.equals(index)) {
                    row[1]= name1;
                    row[2]=newadd;
                    row[3]=newtype;
                    // Return the index when acctname is found
                }
            }
        }

        addresslabel.setText("Address :" + newadd);
        custype.setText("Customer Type :" + newtype);
        name.setText("Account Name :" + name1);


    }

    public void backtomanager(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AccountManager.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void displayCust(String actname, String address, String cusType, String acctNumber) throws IOException {
        savingsrate= ISA.getinterestRate();
        name.setText("Account Name :" + actname);
        acctnumb.setText("Account Number :" + acctNumber);
        addresslabel.setText("Address :" + address);
        custype.setText("Customer Type :" + cusType);


        // Implement initialization logic and other methods as needed

    }
}