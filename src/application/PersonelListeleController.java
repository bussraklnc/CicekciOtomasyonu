package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.cicekciMysql.util.VeritabaniUtil;


import Models.PersonelD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class PersonelListeleController {

	
	ObservableList<PersonelD> list=FXCollections.observableArrayList();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<PersonelD, String> padicol;

    @FXML
    private TableColumn<PersonelD, String> pkulcol;

    @FXML
    private TableView<PersonelD> plist;

    @FXML
    private TableColumn<PersonelD, String> pmailcol;

    @FXML
    private TableColumn<PersonelD, String> psifrecol;

    @FXML
    private TableColumn<PersonelD, String> psoyadcol;

    @FXML
    private TableColumn<PersonelD, String> ptelcol;

    @FXML
    private TableColumn<PersonelD, String> pıdcol;
    
    Connection baglanti=null;

   

    @FXML
    void initialize() {
    	baglanti=VeritabaniUtil.Baglan();
        if(baglanti==null)
        {
        	System.out.println("Bağlantı Kurulamadı");
        	
        }
        loadData();
       

    }
    
private void initCol() throws Exception{
    	
    	
    	
    	
        padicol.setCellValueFactory(new PropertyValueFactory<>("padi"));
        psoyadcol.setCellValueFactory(new PropertyValueFactory<>("psoyad"));
        ptelcol.setCellValueFactory(new PropertyValueFactory<>("ptelefon"));
        pmailcol.setCellValueFactory(new PropertyValueFactory<>("pmail"));
        pkulcol.setCellValueFactory(new PropertyValueFactory<>("pkulad"));
        psifrecol.setCellValueFactory(new PropertyValueFactory<>("psifre"));
        pıdcol.setCellValueFactory(new PropertyValueFactory<>("pid"));
    }

private void loadData() 
{
	PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
             
	
    String sql="SELECT * FROM personelduzenle";
try
	{
		sorguIfadesi=baglanti.prepareStatement(sql);
		getirilen=sorguIfadesi.executeQuery();
while(getirilen.next())
		{initCol() ;
		String padix=getirilen.getString("pAdi");//getString içinde yazanlar veritabanındaki kolon adları
		String psoyadx=getirilen.getString("pSoyadi");
		String ptelefonx=getirilen.getString("pTelefon");
		String pmailx=getirilen.getString("pMail");
		String pkuladx=getirilen.getString("pKulad");
        String psifrex=getirilen.getString("pSifre");
        String pidx=getirilen.getString("pID");

		
		list.add(new PersonelD(padix,psoyadx,ptelefonx,pmailx,pkuladx,psifrex,pidx));
	}
	} 
catch (Exception e)
{
	e.printStackTrace();
}
plist.getItems().addAll(list);
}
    
    @FXML
    void plist_click(MouseEvent event) {

    }

}
