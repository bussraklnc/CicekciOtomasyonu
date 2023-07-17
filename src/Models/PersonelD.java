package Models;

import javafx.beans.property.SimpleStringProperty;

public class PersonelD {
	private SimpleStringProperty padi;
	private SimpleStringProperty psoyad;
	private SimpleStringProperty ptelefon;
	private SimpleStringProperty pmail;
	private SimpleStringProperty pkulad;
	private SimpleStringProperty psifre;
	private SimpleStringProperty pid;
	
	public PersonelD(String padi,String psoyad,String ptelefon,String pmail,String pkulad,String psifre,String pid)
	{
		this.padi=new SimpleStringProperty(padi);
		this.psoyad=new SimpleStringProperty(psoyad);
		this.ptelefon=new SimpleStringProperty(ptelefon);
		this.pmail=new SimpleStringProperty(pmail);
		this.pkulad=new SimpleStringProperty(pkulad);
		this.psifre=new SimpleStringProperty(psifre);
		this.pid=new SimpleStringProperty(pid);
	}
	
	
	public String getPadi() {
		return padi.get();
	}

	

	public String getPsoyad() {
		return psoyad.get();
	}

	

	public String getPtelefon() {
		return ptelefon.get();
	}

	

	public String getPmail() {
		return pmail.get();
	}

	

	public String getPkulad() {
		return pkulad.get();
	}

	

	public String getPsifre() {
		return psifre.get();
	}

	

	public String getPid() {
		return pid.get();
	}

}
