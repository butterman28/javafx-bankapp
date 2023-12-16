package com.example.cm2115;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.cm2115.model.ISA;
import com.example.cm2115.model.customer;
import com.example.cm2115.model.BasicAccount;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class AccountManagerController {
    private List<String> customerList = new ArrayList<>();
    private String acctnumbliist;
    private List<String> accountsList = new ArrayList<>();
    private List<String[]> accounts = new ArrayList<>();
    private List<String[]> customers = new ArrayList<>();
    private Stage stage;
    private Scene scene;
    private Parent root;
    public String acctname;
    private String cid;
    public String acctype;
    private int rowindex;
    private String name;
    private String address;
    private String custype;
    private String balupdate;
    private String id;
    private String bid;
    private String actnums;
    private String rate;
    private String balance;
    private String acctnumber;
    @FXML
    TextField acctnamelabel;
    @FXML
    Label namelabel;
    @FXML
    Label acctnumberlabel;
    @FXML
    Label balancevalue;
    @FXML
    Label custotype;
    @FXML
    Label addresslabel;
    @FXML
    TextField withdraw;
    @FXML
    TextField depositlabel;
    @FXML
    TextField acctfocus;
    @FXML
    TextField changerate;
    @FXML
    Label sortid;
    @FXML
    Label intratelabel;

    public void changerate(ActionEvent event) throws IOException {
        rate=changerate.getText();
        ISA.setinterestRate(Integer.parseInt(rate));
        intratelabel.setText("Current Rate:" + ISA.getinterestRate()+"%");
    }
    // this helps you query csv  for the account name
    public void retrieve(ActionEvent event) throws IOException {
        //Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        //System.out.println("Enter username");

        String acctname = acctnamelabel.getText().toLowerCase(); // Read user input
        customerList = customer.getcustomer(acctname);
        accountsList = customer.getaccount(acctname);
        acctnumbliist = customer.getaccountlist(acctname);

        System.out.println("Username is: " + acctname);
        System.out.print(acctname.length());
        name = customerList.get(1);
        cid = customerList.get(0);
        address = customerList.get(2);
        custype = customerList.get(3);
        //acctnumber =accountsList.get(1);
        balance = accountsList.get(3);
        displayCutomers(name,address,custype,acctnumbliist,balance);
    }

        //index = balance.indexOf(acctnum);

//allows you go to the user registration page to add new customer
    public void gotoreg(ActionEvent event)throws IOException{
        root = FXMLLoader.load(getClass().getResource("AddCustomer.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    // to go to page that processes card transfer and all does not work since i was not giving much and deadlines were encroacgging fast
    public void gotocard(ActionEvent event)throws IOException{
        root = FXMLLoader.load(getClass().getResource("card.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    // function takes you to transfer page which i have not properly tested yet
    public void gototransfer(ActionEvent event)throws IOException{
        root = FXMLLoader.load(getClass().getResource("transfer.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    // this handles withdrawl and calls functions from the BasicAccount class which
    // can also be called from the isa class since the abstract thee BankAccount class
    public void withdrawal(ActionEvent event)throws IOException {
        String num = withdraw.getText();
        String thisaza = acctfocus.getText().toLowerCase();
        int bal = Integer.parseInt(balance);
        int withdraw = Integer.parseInt(num);
        balupdate=BasicAccount.withdraw(withdraw,bal,thisaza);
        displayCutomers(name,address,custype,acctnumber,balupdate);
    }
    // takes you to the costumer page your working with
    public void update(ActionEvent event)throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Customer.fxml"));
        root = loader.load();
        CustomerController scene3Controller = loader.getController();
        scene3Controller.displayCust(name,address,custype,acctnumbliist);
        //root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    // this handles deposital and calls functions from the BasicAccount class which
    // can also be called from the isa class since the abstract thee BankAccount class
    public void deposital(ActionEvent event)throws IOException {
        String thisaza = acctfocus.getText().toLowerCase();
        String num1 = depositlabel.getText();
        int deposit = Integer.parseInt(num1);
        int bal = Integer.parseInt(balance);
        balupdate=BasicAccount.deposit(deposit,bal,thisaza);
        displayCutomers(name,address,custype,thisaza,balupdate);
    }
    // this called in most function on this page becaus e it displays user data
    public void displayCutomers(String actname, String address, String cusType, String acctNumber,String bal) {
        namelabel.setText("Account Name :" + actname);
        acctnumberlabel.setText("Account Numbers :" + acctNumber);
        addresslabel.setText("Address :" + address);
        custotype.setText("Customer Type :" + cusType);
        balancevalue.setText("Balance :" + bal);
    }

}




