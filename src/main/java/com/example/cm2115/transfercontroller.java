package com.example.cm2115;

import com.example.cm2115.model.BasicAccount;
import com.example.cm2115.model.ISA;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class transfercontroller {
    @FXML
    TextField creditlabel;
    @FXML
    TextField debitlabel;
    @FXML
    TextField amountlabel;
    public void transfer(ActionEvent event) throws IOException {
        //Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        //System.out.println("Enter username");

        String senderacct = debitlabel.getText().toLowerCase();
        String receiveacct = creditlabel.getText().toLowerCase();
        int amount = Integer.parseInt(amountlabel.getText().toLowerCase());
        int bal1 = Integer.parseInt(ISA.getbalance(senderacct));
        int bal2 = Integer.parseInt(ISA.getbalance(receiveacct));
        BasicAccount.transfer(receiveacct,senderacct,amount,bal1,bal2);


    }
}
