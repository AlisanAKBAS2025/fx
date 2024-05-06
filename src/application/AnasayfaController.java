package application;
import Fonksiyonlar.Fonksiyonlarr;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.beans.property.SimpleStringProperty;
import java.sql.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;


import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class AnasayfaController {

	 Connection baglanti=null;  
   	 PreparedStatement sorguifadesi=null;
   	 ResultSet getirilen=null;
   	 String sql;
   	 
   	 Fonksiyonlarr fonksiyonlarr1 = new Fonksiyonlarr();
   	 
public AnasayfaController(){
     	baglanti=fonksiyonlarr1.baglan();
     }
     
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<projemKayitlar, String> aramaDurumCOL;

    @FXML
    private TableColumn<projemKayitlar, String> aramaMODELCOL;

    @FXML
    private TableColumn<projemKayitlar, String> aramaTCCOL;

    @FXML
    private TableColumn<projemKayitlar, String> aranaARIZACOL;

    @FXML
    private TableColumn<projemKayitlar, String> aranaURUNCOL;

    @FXML
    private ChoiceBox<String> arizaChoice;

   

    @FXML
    private Button btnCikis;

    @FXML
    private Button btnKaydet;

    @FXML
    private Button btnMusteriKaydet;

    @FXML
    private Button btnUrunCikis;

    @FXML
    private ChoiceBox<String> choiceArizaDurum;

    @FXML
    private TableView<projemKayitlar> cikis;

    @FXML
    private TableColumn<projemKayitlar, String> cikisArizaCOL;

    @FXML
    private TableColumn<projemKayitlar, String> cikisDurumCOL;

    @FXML
    private TableColumn<projemKayitlar, Integer> cikisFiyatCOL;

    @FXML
    private TableColumn<projemKayitlar, String> cikisTCCOL;

    @FXML
    private TableColumn<projemKayitlar, String> cikisUrunCOL;

    @FXML
    private Label lblKullanıcıAd;

    @FXML
    private Label lblKullanıcıSoyad;

    @FXML
    private Label lblPersonelNo;

    @FXML
    private Label lblTC;

    @FXML
    private ChoiceBox<String> markaChoice;

    @FXML
    private ChoiceBox<String> modelChoice;

    @FXML
    private ChoiceBox<?> seriChoice;

    @FXML
    private TableView<projemKayitlar> tabloArama;

    @FXML
    private TableView<projemKayitlar> tabloUrunDurum;

    @FXML
    private TextArea txtAdres;

    @FXML
    private TextField txtAramaTC;

   

    @FXML
    private TextField txtCihazTC;

    @FXML
    private TextField txtCihazUcret;

    @FXML
    private TextField txtCikisTC;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtMusteriAd;

    @FXML
    private TextField txtMusteriSoyad;

    @FXML
    private TextArea txtSikayet;

    @FXML
    private TextField txtTCNO;

    @FXML
    private TextField txtTEL;

    @FXML
    private TableColumn<projemKayitlar, String> urunAciklamaCOL;

    @FXML
    private TableColumn<projemKayitlar, String> urunArizaCOL;

    @FXML
    private TableColumn<projemKayitlar, String> urunDurumCOL;

    @FXML
    private TableColumn<projemKayitlar, String> urunTCCOL;

    @FXML
    private TableColumn<projemKayitlar, String> urunUrunCOL;
    
    
    
    
    @FXML
    void cikisTcPressed(KeyEvent event) {
    	 String degiskenString=txtCikisTC.getText();
  	   if(degiskenString.length()==0) {
  		   sql= "SELECT TC,model,ariza,durum,ucret FROM cihazkayit";
  	   }
  	   else {
  	   sql="SELECT TC,model,ariza,durum,ucret FROM cihazkayit WHERE TC like '"+txtCikisTC.getText()+"%'";
  	   }
  	   DegerleriGetirCikis(cikis,sql);
    }
    
   @FXML
    void tcnoKeyPressed(KeyEvent event) {
	   
	   String degiskenString=txtAramaTC.getText();
	   if(degiskenString.length()==0) {
		   sql= "SELECT TC,marka,model,ariza,sikayet,durum FROM cihazkayit";
	   }
	   else {
	   sql="SELECT TC,marka,model,ariza,sikayet,durum FROM cihazkayit WHERE TC like '"+txtAramaTC.getText()+"%'";
	   }
	   DegerleriGetirArama(tabloArama,sql);
	   
}
    @FXML
    void tcnoKeyPressed2(InputMethodEvent event) {
    	 if(txtAramaTC.getText().equals("")) {
  		 sql="SELECT TC,marka,model,ariza,sikayet,durum FROM cihazkayit WHERE TC"+txtAramaTC.getText()+"%'";
  	   }
  	   else {
  		   sql= "SELECT TC,marka,model,ariza,sikayet,durum FROM cihazkayit";
  	  	   DegerleriGetirArama(tabloArama,sql);

  	   }
  	   DegerleriGetirArama(tabloArama,sql);
    }
    
    
    
    
@FXML
    void telnoPressed(KeyEvent event) {
	  
}
    
     
    @FXML
    void araClick(ActionEvent event) {

    }

    @FXML
    void cihazKaydetClick(ActionEvent event) {
    
    	String sql = "INSERT INTO cihazkayit (id, ariza, ucret, sikayet, durum, marka, model, `TC`) " +
                "VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)";
        try {
        	Fonksiyonlarr.Ekle(sql, txtCihazTC.getText(),markaChoice.getSelectionModel().getSelectedItem() ,modelChoice.getSelectionModel().getSelectedItem()
            		, arizaChoice.getSelectionModel().getSelectedItem(),Integer.parseInt(txtCihazUcret.getText()),txtSikayet.getText(),"yapilmadi");
            
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Bilgi");
            alert.setHeaderText(null);
            alert.setContentText("Cihaz başarıyla kaydedildi.");
            alert.showAndWait();
            
            txtSikayet.clear();
            txtCihazUcret.clear();
            arizaChoice.getSelectionModel().clearSelection();
            markaChoice.getSelectionModel().clearSelection();
            modelChoice.getSelectionModel().clearSelection();
            txtCihazTC.clear();
            
            DegerleriGetirUrun(tabloUrunDurum);  
            DegerleriGetirArama(tabloArama, "SELECT TC, marka, model, ariza, sikayet, durum FROM cihazkayit");
            DegerleriGetirCikis(cikis, "SELECT TC, model, ariza, durum, ucret FROM cihazkayit");
        } catch (Exception e) {
            System.out.println(e.getMessage().toString());
        }

    	
    	
    }
    
    

    @FXML
    void btnCikis(ActionEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Bilgi");
        alert.setHeaderText(null);
        alert.setContentText("Çıkış yapıldı.");
        alert.showAndWait();
        
        System.exit(0);
    }

    @FXML
    void musteriKaydetClick(ActionEvent event) {
    	
    	   String sql = "INSERT INTO musterikayit (TC, Ad, soyad, tel, email, adres) VALUES (?,?,?,?,?,?)";
    	    try {
    	        Fonksiyonlarr.Ekle(sql, txtTCNO.getText(), txtMusteriAd.getText(), txtMusteriSoyad.getText(), txtTEL.getText(), txtEmail.getText(), txtAdres.getText());
    	        
    	        Alert alert = new Alert(AlertType.INFORMATION);
    	        alert.setTitle("Bilgi");
    	        alert.setHeaderText(null);
    	        alert.setContentText("Müşteri başarıyla eklendi.");
    	        alert.showAndWait();
    	        
    	        txtTCNO.clear();
    	        txtMusteriAd.clear();
    	        txtMusteriSoyad.clear();
    	        txtTEL.clear();
    	        txtEmail.clear();
    	        txtAdres.clear();
    	    } catch (Exception e) {
    	        System.out.println(e.getMessage().toString());
    	    }
    }

    @FXML
    void urunCikisClick(ActionEvent event) {
    
    	   if (choiceArizaDurum.getSelectionModel().getSelectedIndex() < 0 || cikis.getSelectionModel().getSelectedIndex() < 0) {
    	        System.out.println("Secim yapmalisin");
    	    } else {
    	        projemKayitlar selectedKayit = cikis.getSelectionModel().getSelectedItem(); 
    	        String sql = "UPDATE cihazkayit SET durum=? WHERE durum=?";
    	        try {
    	            sorguifadesi = baglanti.prepareStatement(sql);
    	            sorguifadesi.setString(1, "yapildi"); 
    	            sorguifadesi.setString(2, selectedKayit.getDurumProperty().get()); 
    	            int affectedRows = sorguifadesi.executeUpdate();
    	            if (affectedRows > 0) {
    	                System.out.println("Güncelleme başarılı.");
    	            } else {
    	                System.out.println("Güncelleme yapılmadı.");
    	            }
    	        } catch (Exception e) {
    	            System.out.println(e.getMessage());
    	        }
    	    }
    	   DegerleriGetirCikis(cikis,"SELECT TC,model,ariza,durum,ucret FROM cihazkayit");
           DegerleriGetirUrun(tabloUrunDurum);  
           DegerleriGetirArama(tabloArama,"SELECT TC,marka,model,ariza,sikayet,durum FROM cihazkayit");
    	   
    }

    @FXML
    void initialize() {
          
        String arizabox[] = {"Klavye","LCD EKRAN","Disket surucu","anakart","islemci","ekran karti","usb port","ses karti","ethernet karti","guc adapteri","toucped"};
        arizaChoice.getItems().addAll(arizabox);
        String arizaDurum[] = {"NAKIT","TEK CEKIM" ,"EFT HAVELE"};
        choiceArizaDurum.getItems().addAll(arizaDurum);
        
       
        
       fillMarkaChoice(); 
        markaChoice.setOnAction(e -> {
            modelChoice.getItems().clear();
            String selectedMarka = markaChoice.getValue();
            int markaID = getMarkaID(selectedMarka);
            fillModelChoice(markaID);
        });
         
        markaChoice.setOnAction(event -> {
            String selectedMarka = markaChoice.getValue();
            fillModelChoice(selectedMarka);
        });
        
       
        lblKullanıcıAd.setText("admin");
        lblKullanıcıSoyad.setText("root");
       
        
        
        
        DegerleriGetirUrun(tabloUrunDurum);  
        DegerleriGetirArama(tabloArama,"SELECT TC,marka,model,ariza,sikayet,durum FROM cihazkayit");
        DegerleriGetirCikis(cikis,"SELECT TC,model,ariza,durum,ucret FROM cihazkayit");
        
       
}
   
    
private void fillModelChoice(String selectedMarka) {
        int markaID = getMarkaID(selectedMarka);
        modelChoice.getItems().clear(); // Önceki verileri temizle

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/projemdb", "root", "mysql");
            String modelQuery = "SELECT model FROM modelTablo WHERE markaID = ?";
            PreparedStatement modelStatement = connection.prepareStatement(modelQuery);
            modelStatement.setInt(1, markaID);
            ResultSet modelResultSet = modelStatement.executeQuery();

            while (modelResultSet.next()) {
                String model = modelResultSet.getString("model");
                modelChoice.getItems().add(model);
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
private void fillMarkaChoice() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/projemdb", "root", "mysql");
            String markaQuery = "SELECT marka FROM markaTablo";
            PreparedStatement markaStatement = connection.prepareStatement(markaQuery);
            ResultSet markaResultSet = markaStatement.executeQuery();

            while (markaResultSet.next()) {
                String marka = markaResultSet.getString("marka");
                markaChoice.getItems().add(marka);
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
private int getMarkaID(String marka) {
        int markaID = 0;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/projemdb", "root", "mysql");
            String markaIDQuery = "SELECT markaID FROM markaTablo WHERE marka = ?";
            PreparedStatement markaIDStatement = connection.prepareStatement(markaIDQuery);
            markaIDStatement.setString(1, marka);
            ResultSet markaIDResultSet = markaIDStatement.executeQuery();

            if (markaIDResultSet.next()) {
                markaID = markaIDResultSet.getInt("markaID");
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return markaID;
    }
    
private void fillModelChoice(int markaID) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/projemdb", "root", "mysql");
            String modelQuery = "SELECT model FROM modelTablo WHERE markaID = ?";
            PreparedStatement modelStatement = connection.prepareStatement(modelQuery);
            modelStatement.setInt(1, markaID);
            ResultSet modelResultSet = modelStatement.executeQuery();

            while (modelResultSet.next()) {
                String model = modelResultSet.getString("model");
                modelChoice.getItems().add(model);
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    
    
  //TABLO DOLDURMA 	  
public void DegerleriGetirUrun(TableView tablo) {
           
    		sql= "SELECT TC,marka,model,ariza,sikayet,durum FROM cihazkayit";
            ObservableList<projemKayitlar> kayitlar = FXCollections.observableArrayList();
            try {
                sorguifadesi = baglanti.prepareStatement(sql);
                ResultSet getirilen = sorguifadesi.executeQuery();
                while (getirilen.next()) {
                    kayitlar.add(new projemKayitlar(getirilen.getString("TC"),getirilen.getString("model"),
                            getirilen.getString("ariza"), getirilen.getString("sikayet"), getirilen.getString("durum")));
                }
                
                urunTCCOL.setCellValueFactory(CellData -> CellData.getValue().getTCProperty());
                urunUrunCOL.setCellValueFactory(CellData -> CellData.getValue().getModelProperty());
                urunArizaCOL.setCellValueFactory(CellData -> CellData.getValue().getArizaPoProperty());
                urunAciklamaCOL.setCellValueFactory(CellData -> CellData.getValue().getAciklamaProperty());
                urunDurumCOL.setCellValueFactory(CellData -> CellData.getValue().getDurumProperty());
                tabloUrunDurum.setItems(kayitlar);
            } catch (Exception e) {
                System.out.println(e.getMessage().toString());
            }
        } 
    
    
public void DegerleriGetirArama(TableView tablo,String sorgu) {
        
        ObservableList<projemKayitlar> kayitlar = FXCollections.observableArrayList();
        try {
            sorguifadesi = baglanti.prepareStatement(sorgu);
            ResultSet getirilen = sorguifadesi.executeQuery();
            while (getirilen.next()) {
                kayitlar.add(new projemKayitlar(getirilen.getString("TC"),getirilen.getString("model"),
                        getirilen.getString("ariza"), getirilen.getString("sikayet"), getirilen.getString("durum")));
            }
            aramaTCCOL.setCellValueFactory(CellData -> CellData.getValue().getTCProperty());
            aranaURUNCOL.setCellValueFactory(CellData -> CellData.getValue().getModelProperty());
            aramaMODELCOL.setCellValueFactory(CellData -> CellData.getValue().getArizaPoProperty());
            aranaARIZACOL.setCellValueFactory(CellData -> CellData.getValue().getAciklamaProperty());
            aramaDurumCOL.setCellValueFactory(CellData -> CellData.getValue().getDurumProperty());
            tabloArama.setItems(kayitlar);
        } catch (Exception e) {
            System.out.println(e.getMessage().toString());
        }
} 
    
    
    
    
	public void DegerleriGetirCikis(TableView tablo,String sorgu) {
        
        ObservableList<projemKayitlar> kayitlar = FXCollections.observableArrayList();
        try {
            sorguifadesi = baglanti.prepareStatement(sorgu);
            ResultSet getirilen = sorguifadesi.executeQuery();
            
            
           // public projemKayitlar(String tc,String model,String ariza,String durum,int ucret)
            while (getirilen.next()) {
                kayitlar.add(new projemKayitlar(getirilen.getString("TC"),getirilen.getString("model"),
                        getirilen.getString("ariza"), getirilen.getString("durum"), getirilen.getInt("ucret")));
            }   
            cikisTCCOL.setCellValueFactory(CellData -> CellData.getValue().getTCProperty());
            cikisUrunCOL.setCellValueFactory(CellData -> CellData.getValue().getModelProperty());
            cikisArizaCOL.setCellValueFactory(CellData -> CellData.getValue().getArizaPoProperty());
            cikisDurumCOL.setCellValueFactory(CellData -> CellData.getValue().getDurumProperty());
            cikisFiyatCOL.setCellValueFactory(CellData -> CellData.getValue().getFiyatIntegerProperty().asObject());

            
    
            cikisFiyatCOL.setCellValueFactory(CellData -> CellData.getValue().getFiyatIntegerProperty().asObject());
            cikis.setItems(kayitlar);
        } catch (Exception e) {
            System.out.println(e.getMessage().toString());
        }
    } 
    

	

    

        
}
    
    

    


