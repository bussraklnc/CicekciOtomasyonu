package Models;

import javafx.beans.property.SimpleStringProperty;

public class MudurPersonel2 {
	private SimpleStringProperty adi;
	private SimpleStringProperty soyad;
	private SimpleStringProperty telefon;
	private SimpleStringProperty mail;
	private SimpleStringProperty kulad;
	private SimpleStringProperty sifre;
	private SimpleStringProperty mid;
	
	
	public MudurPersonel2(String adi,String soyad,String telefon,String mail,String kulad,String sifre,String mid)
	{
		this.adi=new SimpleStringProperty(adi);
		this.soyad=new SimpleStringProperty(soyad);
		this.telefon=new SimpleStringProperty(telefon);
		this.mail=new SimpleStringProperty(mail);
		this.kulad=new SimpleStringProperty(kulad);
		this.sifre=new SimpleStringProperty(sifre);
		this.mid=new SimpleStringProperty(mid);
	}

	public String getAdi() {
		return adi.get();
	}

	

	public String getSoyad() {
		return soyad.get();
	}

	

	public String getTelefon() {
		return telefon.get();
	}

	

	public String getMail() {
		return mail.get();
	}

	

	public String getKulad() {
		return kulad.get();
	}

	

	public String getSifre() {
		return sifre.get();
	}

	

	public String getMid() {
		return mid.get();
	}


	
	


}
