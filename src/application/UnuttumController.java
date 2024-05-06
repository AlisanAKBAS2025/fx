package application;

import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.util.ResourceBundle;


import Fonksiyonlar.Fonksiyonlarr;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class UnuttumController {

	 Connection baglanti=null;  
   	 PreparedStatement sorguifadesi=null;
   	 ResultSet getirilen=null;
   	 String sql;
   	 
   	 
   	 public UnuttumController()
   	 {
   		 baglanti=Fonksiyonlarr.baglan();
   	 }
   	 
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnKaydet;

    @FXML
    private Label lblCevap;

    @FXML
    private TextField txtCevap;

    @FXML
    private TextField txtPersonel;

    @FXML
    private PasswordField txtSifre;

    @FXML
    private TextField txtTc;

    @FXML
    private PasswordField txtTekrar;

    @FXML
    void btnKaydet(ActionEvent event) {
    	
    	if (txtSifre.getText().trim().equals(txtTekrar.getText().trim())) {
    	    String sorgu = "UPDATE personel SET sifre=? WHERE PersenolNo=? AND Tcno=?";
    	    try {
    	        sorguifadesi = baglanti.prepareStatement(sorgu);
    	        sorguifadesi.setString(1,MD5Sifreleme(txtTekrar.getText()));
    	        sorguifadesi.setString(2, txtPersonel.getText());
    	        sorguifadesi.setString(3, txtTc.getText());

    	        int affectedRows = sorguifadesi.executeUpdate();

    	        if (affectedRows > 0) {
    	            // Güncelleme başarılı oldu
    	            Alert alert = new Alert(AlertType.INFORMATION);
    	            alert.setTitle("Bilgi");
    	            alert.setHeaderText(null);
    	            alert.setContentText("Güncelleme başarıyla yapıldı.");
    	            alert.showAndWait();
    	        } else {
    	            // Güncelleme yapılamadı
    	            Alert alert = new Alert(AlertType.ERROR);
    	            alert.setTitle("Hata");
    	            alert.setHeaderText(null);
    	            alert.setContentText("Güncelleme sırasında bir hata oluştu.");
    	            alert.showAndWait();
    	        }

    	    } catch (Exception e) {
    	        System.out.println(e.getMessage().toString());
    	    }
    	} else {
    		Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Hata");
            alert.setHeaderText(null);
            alert.setContentText("Şfreler uyusmuyor");
            alert.showAndWait();
    	}
    }


	public static String MD5Sifreleme(String sifre)
	{
		try {
			MessageDigest md= MessageDigest.getInstance("MD5");
			byte[] sifrelenmis=md.digest(sifre.getBytes());	
			BigInteger no= new BigInteger(1,sifrelenmis);
			String hashSifre=no.toString(16);
			while(hashSifre.length()<32)
			{
				hashSifre="0"+hashSifre;
			}
		return hashSifre;		
		}catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		
	}
    
    
    @FXML
    void initialize() {
        assert btnKaydet != null : "fx:id=\"btnKaydet\" was not injected: check your FXML file 'Unuttum.fxml'.";
        assert lblCevap != null : "fx:id=\"lblCevap\" was not injected: check your FXML file 'Unuttum.fxml'.";
        assert txtCevap != null : "fx:id=\"txtCevap\" was not injected: check your FXML file 'Unuttum.fxml'.";
        assert txtPersonel != null : "fx:id=\"txtPersonel\" was not injected: check your FXML file 'Unuttum.fxml'.";
        assert txtSifre != null : "fx:id=\"txtSifre\" was not injected: check your FXML file 'Unuttum.fxml'.";
        assert txtTc != null : "fx:id=\"txtTc\" was not injected: check your FXML file 'Unuttum.fxml'.";
        assert txtTekrar != null : "fx:id=\"txtTekrar\" was not injected: check your FXML file 'Unuttum.fxml'.";
        int a ,b,cevap;
        Random random =  new Random();
        a=random.nextInt(100);
        b=random.nextInt(50);
        cevap=a+b;
        lblCevap.setText(Integer.toString(a)+"+"+Integer.toString(b));

    }

}
