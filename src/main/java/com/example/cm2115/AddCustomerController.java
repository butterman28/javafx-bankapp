package com.example.cm2115;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.cm2115.AccountManagerController;
import com.example.cm2115.model.AccountManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class AddCustomerController {
     @FXML
     private RadioButton bus,ind,cha,save,current;
     @FXML
     private ChoiceBox<String> custotypelabel;
     ArrayList<String> Acctname = new ArrayList<>();
     List<Integer> sortid= new ArrayList<>();

     ArrayList<String> addresslist = new ArrayList<>();
     @FXML
     TextField acctnamelabel;
     @FXML
     TextField addresstag;
     @FXML
     TextField customertypelabel;
     @FXML
     TextField accounttypelabel;
     private Stage stage;
     private Scene scene;
     private Parent root;
     public String accname;

     public int autoGeneratedID;
     public String Address;
     private String ctype;
     private String acctype;
     public String  CID;
     public String  SID;
     private int acctNumber;
     private String actno;

     public static int getRandomNumberInRange(int min, int max) {
          if (min >= max) {
               throw new IllegalArgumentException("Max must be greater than min");
          }

          Random random = new Random();
          return random.nextInt(max - min + 1) + min;
     }
     public static String[] appendString(String[] array, String strToAppend) {
          // Convert the array to a StringBuilder
          StringBuilder stringBuilder = new StringBuilder();
          for (String s : array) {
               stringBuilder.append(s).append(" ");
          }

          // Append the new string
          stringBuilder.append(strToAppend);

          // Convert the StringBuilder back to a string array
          String[] newArray = stringBuilder.toString().split(" ");

          return newArray;
     }

     public void Backtoreg(ActionEvent event)throws IOException{
          root = FXMLLoader.load(getClass().getResource("AccountManager.fxml"));
          stage = (Stage)((Node)event.getSource()).getScene().getWindow();
          scene = new Scene(root);
          stage.setScene(scene);
          stage.show();
     }
     public void reg(ActionEvent event)throws IOException{
          accname = acctnamelabel.getText().toLowerCase();
          ctype = customertypelabel.getText();
          acctype= accounttypelabel.getText();
          acctNumber=getRandomNumberInRange(1,10000);
          int cid=getRandomNumberInRange(1,10000);
          int sid = getRandomNumberInRange(1,10000);
          System.out.println("The value of myNumber is: " + cid +ctype+sid);
          CID = String.valueOf(cid);
          SID = String.valueOf(sid);
          actno = String.valueOf(acctNumber);
          Address = addresstag.getText();
          String filePath = "src/main/resources/com/example/cm2115/customer.csv";
          String filePath1 = "src/main/resources/com/example/cm2115/account.csv";
          // Example data to write to the CSV file
          List<String[]> customerToWrite = new ArrayList<>();
          List<String[]> accountToWrite = new ArrayList<>();
          customerToWrite.add(new String[]{CID,accname, Address, ctype});
          accountToWrite.add(new String[]{SID,actno, CID, "0",acctype});
          AccountManager.addcustomer(customerToWrite,accountToWrite);
          FXMLLoader loader = new FXMLLoader(getClass().getResource("AccountManager.fxml"));
          root = loader.load();

          AccountManagerController scene2Controller = loader.getController();
          scene2Controller.displayCutomers(accname,Address,ctype,actno, "0");

          //root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
          stage = (Stage)((Node)event.getSource()).getScene().getWindow();
          scene = new Scene(root);
          stage.setScene(scene);
          stage.show();
     }






}
