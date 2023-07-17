package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.cicekciMysql.util.VeritabaniUtil;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PersonelGirisController {
	
	public PersonelGirisController() {
		baglanti=VeritabaniUtil.Baglan();
		
	}
	
	@FXML
    private AnchorPane panasyfa;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button pgrsyp;

    @FXML
    private TextField pkuladi;

    @FXML
    private PasswordField psfre;
    
    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;

    @FXML
    void pgrsyp_Click(ActionEvent event) {
    	if(event.getSource()==pgrsyp)
    	{
    		try
    		{

    	    	 baglanti();
    	    	String sql="select * from personelduzenle where pKulad=? and pSifre=?";
    	    	sorguIfadesi=baglanti.prepareStatement(sql);
    	    	sorguIfadesi.setString(1, pkuladi.getText().trim());
    	    	sorguIfadesi.setString(2, psfre.getText().trim());
    	    	ResultSet getirilen=sorguIfadesi.executeQuery();
    	    	getirilen.next();
    	    	
    	    	if (pkuladi.getText().equals(getirilen.getString("pKulad")) && psfre.getText().equals(getirilen.getString("pSifre")));
    			{
    				Stage window= new Stage();
    				Parent root = FXMLLoader.load(getClass().getResource("/application/PersonelDuzenle.fxml"));
    				window.setTitle("Cicekci");
    				window.initStyle(StageStyle.UNDECORATED);
    				window.setScene(new Scene(root));
    				window.show();
    				Stage stage = (Stage) panasyfa.getScene().getWindow();
    				stage.close();
    			
    	 			
        		} 
    		}catch (Exception hata)
        		{
        			JOptionPane.showMessageDialog(null,"bilinmeyen bir hata: "+hata);
        		}
    				 	    				
    	}

    }
    @FXML
    void kpat_Click(ActionEvent event) {
    	Platform.exit();

    }
    
    @FXML
    void backbtn3_Click(ActionEvent event) throws Exception {
    	Stage window= new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/PersonelDuzenle.fxml"));
		window.setTitle("Cicekci");
		window.initStyle(StageStyle.UNDECORATED);
		window.setScene(new Scene(root));
		window.show();
		Stage stage = (Stage) panasyfa.getScene().getWindow();
		stage.close();

    }
    	
    	
    

    private void baglanti() {
		
		
	}

	@FXML
    void initialize() {
       
		baglanti=VeritabaniUtil.Baglan();
        if(baglanti==null)
        {
        	System.out.println("Bağlantı Kurulamadı");
        }
    }

}
