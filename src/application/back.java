package application;
import java.sql.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
public class back {

	String sorguString;
	
public void sahneAC(String sahneadi,int boy,int en )
	{
		try {
			Stage stage = new Stage();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource(sahneadi));
			// calisirsa sahne boyutlarinidas girmem lazim
			
			Scene scene = new Scene(root,en,boy);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			System.out.println(e.getMessage().toString());
								}
	}
	
    public void fillMarkaChoice(String sorgu, ChoiceBox box,String isim) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/projemdb", "root", "mysql");
            String markaQuery = sorgu;
            PreparedStatement markaStatement = connection.prepareStatement(markaQuery);
            ResultSet markaResultSet = markaStatement.executeQuery();

            while (markaResultSet.next()) {
                String marka = markaResultSet.getString(isim);
                box.getItems().add(marka);
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
}
    
    public int getMarkaID(String marka, String sorgu ,String sutun) {
        int markaID = 0;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/projemdb", "root", "mysql");
            String markaIDQuery = sorgu;
            PreparedStatement markaIDStatement = connection.prepareStatement(markaIDQuery);
            markaIDStatement.setString(1, marka);
            ResultSet markaIDResultSet = markaIDStatement.executeQuery();

            if (markaIDResultSet.next()) {
                markaID = markaIDResultSet.getInt(sutun);
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return markaID;
 }
    
   //textfield arama 
    
    public void Arama(TextField txtarama,TextField txt) {
    	
    	String degiskenString=txtarama.getText();
 	   String degisken2=txt.getText();
 	   if(degiskenString.length()==0 && degisken2.length()==0) {
 		   sorguString= "SELECT TC,marka,model,ariza,sikayet,durum FROM cihazkayit";
 	   }
 	   else {
 	   sorguString="SELECT TC,marka,model,ariza,sikayet,durum FROM cihazkayit WHERE TC like '"+txtarama.getText()+"%'";
 	   }
 }
	
}
