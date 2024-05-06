package Fonksiyonlar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Fonksiyonlarr {

	
	static Connection  conn=null;
 	 static PreparedStatement sorguifadesi=null;
 	 static ResultSet getirilen=null;
 	 
 	 
 	 
/*
	public void sahneAc(String sahneadi)
	{
		try {
			Stage stage = new Stage();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource(sahneadi));
			// calisirsa sahne boyutlarinidas girmem lazim
			
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			System.out.println(e.getMessage().toString());
								}
	}
	*/
	
	
	

	public void fillChoice(String query, ChoiceBox<String> choiceBox, String columnName) {
    try {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/projemdb", "root", "mysql");
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String item = resultSet.getString(columnName);
            choiceBox.getItems().add(item);
        }

        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
	
	public int getChoice(String marka, String query, String columnName) {
	    int markaID = 0;
	    try {
	        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/projemdb", "root", "mysql");
	        PreparedStatement statement = connection.prepareStatement(query);
	        statement.setString(1, marka);
	        ResultSet resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            markaID = resultSet.getInt(columnName);
	        }

	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return markaID;
	}

	public static Connection baglan()
	{
		try {
			//"jdbc:mysql://localhost/projemdb,"root","mysql"
			conn=DriverManager.getConnection("jdbc:mysql://localhost/projemdb","root","mysql");
			return conn;
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
			return null;
		}
	}
	
	//String sql= "INSERT INTO `musterikayit` (TC, Ad, soyad, tel, email, adres) VALUES (?,?,?,?,?,?)";
	//Musteri
	public static void Ekle(String sorgu,String TC,String ad,String soyad,String tel, String mail, String adres){	 
		
    	try {
    		sorguifadesi=conn.prepareStatement(sorgu);
    		sorguifadesi.setString(1, TC);
    		sorguifadesi.setString(2, ad);
    		sorguifadesi.setString(3, soyad);
    		sorguifadesi.setString(4, tel);
    		sorguifadesi.setString(5, mail);
    		sorguifadesi.setString(6, adres);
			sorguifadesi.executeUpdate();
		
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
			}
 }

//cihaz 
	
	
	public static void Ekle(String sorgu,String TC,String marka,String model,String ariza, int ucret,String sikayet,String durum){	 
		
		
		
		//id, ariza, ucret, sikayet, durum, marka, model, `TC`
    	try {
			sorguifadesi=conn.prepareStatement(sorgu); 
			sorguifadesi.setString(1, ariza);
			sorguifadesi.setInt(2, ucret);
			sorguifadesi.setString(3, sikayet);
			sorguifadesi.setString(4, durum);
			sorguifadesi.setString(5, marka);
			sorguifadesi.setString(6, model);
			sorguifadesi.setString(7, TC);
			sorguifadesi.executeUpdate();
			
			System.out.println(TC);
		
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
			}
    	
    	
    	
 }

	    /*
	    public int getChoice(String marka, String sorgu ,String sutun) {
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
	    */
	
	
}
