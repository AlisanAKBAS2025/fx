package application;

import java.sql.ResultSet;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class projemKayitlar {

	private SimpleStringProperty TCProperty;
	private SimpleStringProperty markaProperty;
	private SimpleStringProperty modelProperty;
	private SimpleStringProperty arizaPoProperty;
	private SimpleStringProperty aciklamaProperty;
	private SimpleStringProperty durumProperty;
	private SimpleIntegerProperty fiyatIntegerProperty;
	
	
	

	public projemKayitlar(String tc,String model,String ariza,String aciklama,String durum)
	{ 
		this.TCProperty=new SimpleStringProperty(tc);
		//this.markaProperty=new SimpleStringProperty(marka);
		this.modelProperty=new SimpleStringProperty(model);
		this.arizaPoProperty=new SimpleStringProperty(ariza);
		this.aciklamaProperty=new SimpleStringProperty(aciklama);
		this.durumProperty=new SimpleStringProperty(durum);

	}

	
	

	
	
	public projemKayitlar(String tc, String model, String ariza, String durum, int ucret) {
	    this.TCProperty = new SimpleStringProperty(tc);
	    this.modelProperty = new SimpleStringProperty(model);
	    this.arizaPoProperty = new SimpleStringProperty(ariza);
	    this.durumProperty = new SimpleStringProperty(durum);
	    this.fiyatIntegerProperty = new SimpleIntegerProperty(ucret);
	    
	}
	
	
	
	
	
	public SimpleStringProperty getTCProperty() {
		return TCProperty;
	}

	public void setTCProperty(SimpleStringProperty tCProperty) {
		TCProperty = tCProperty;
	}

	

	public SimpleStringProperty getArizaPoProperty() {
		return arizaPoProperty;
	}

	public void setArizaPoProperty(SimpleStringProperty arizaPoProperty) {
		this.arizaPoProperty = arizaPoProperty;
	}

	public SimpleStringProperty getAciklamaProperty() {
		return aciklamaProperty;
	}

	public void setAciklamaProperty(SimpleStringProperty aciklamaProperty) {
		this.aciklamaProperty = aciklamaProperty;
	}

	public SimpleStringProperty getDurumProperty() {
		return durumProperty;
	}

	public void setDurumProperty(SimpleStringProperty durumProperty) {
		this.durumProperty = durumProperty;
	}

	public SimpleStringProperty getMarkaProperty() {
		return markaProperty;
	}

	public void setMarkaProperty(SimpleStringProperty markaProperty) {
		this.markaProperty = markaProperty;
	}

	public SimpleStringProperty getModelProperty() {
		return modelProperty;
	}

	public void setModelProperty(SimpleStringProperty modelProperty) {
		this.modelProperty = modelProperty;
	}
	
	public SimpleIntegerProperty getFiyatIntegerProperty() {
		 if (fiyatIntegerProperty == null) {
		        return new SimpleIntegerProperty();
		    } else {
		        return fiyatIntegerProperty;
		    }
	}




	public void setFiyatIntegerProperty(SimpleIntegerProperty fiyatIntegerProperty) {
		this.fiyatIntegerProperty = fiyatIntegerProperty;
	}



	
	    
	
}
