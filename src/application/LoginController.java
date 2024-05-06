package application;

import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import Fonksiyonlar.Fonksiyonlarr;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import Fonksiyonlar.Fonksiyonlarr;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class LoginController {
	
	
	public LoginController()
	{
     	baglanti=fonksiyonlarr.baglan();

	}
 Fonksiyonlarr fonksiyonlarr = new Fonksiyonlarr();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnGiris;

    @FXML
    private Button btnUnuttum;

    @FXML
    private ImageView foto;

    @FXML
    private TextField txtKullanici;

    
    Connection baglanti=null;
    //sorgu ifadesi yapmamiz lazim
  	 PreparedStatement sorguifadesi=null;
  	 //data set ayniu seyi yapan resultset
  	 ResultSet getirilen=null;
  	 String sql;
    
    @FXML
    private PasswordField txtSifre;
    back back = new back();
    
    @FXML
    void girisClick(ActionEvent event) {
    
    	sql = "SELECT * FROM personel WHERE kullanici=? AND sifre=?";
    	try {
    	    sorguifadesi = baglanti.prepareStatement(sql);
    	    sorguifadesi.setString(1, txtKullanici.getText());
    	    sorguifadesi.setString(2,MD5Sifreleme(txtSifre.getText()));

    	    ResultSet getirilen = sorguifadesi.executeQuery();

    	    if (getirilen.next()) {
    	        back.sahneAC("Anasayfa.fxml", 450, 800);
    	    } else {
    	        
    	        Alert alert = new Alert(AlertType.ERROR);
    	        alert.setTitle("Hata");
    	        alert.setHeaderText(null);
    	        alert.setContentText("Hatalı kullanıcı adı veya şifre!");
    	        alert.showAndWait();
    	    }
    	} catch (Exception e) {
    	    System.out.println(e.getMessage().toString());
    	}
}

    @FXML
    void unuttumClıck(ActionEvent event) {
    	back.sahneAC("Unuttum.fxml", 300, 300);
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
        assert btnGiris != null : "fx:id=\"btnGiris\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnUnuttum != null : "fx:id=\"btnUnuttum\" was not injected: check your FXML file 'Login.fxml'.";
        assert foto != null : "fx:id=\"foto\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtKullanici != null : "fx:id=\"txtKullanici\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtSifre != null : "fx:id=\"txtSifre\" was not injected: check your FXML file 'Login.fxml'.";
        Image image = new Image(getClass().getResourceAsStream("iste.png"));
        foto.setImage(image);
    }

}