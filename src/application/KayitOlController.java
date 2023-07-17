package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class KayitOlController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField adtxt1;

    @FXML
    private TextField kuladtxt1;

    @FXML
    private Button kytbtn1;
    
    @FXML
    private Button back;
    
    @FXML
    private Button kapatt;

    @FXML
    private TextField sifretxt1;

    @FXML
    private TextField soyadtxt1;

    @FXML
    private TextField teltxt1;
    
    @FXML
    private TextField kmail;
    
    @FXML
    private AnchorPane kytol;
    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    

    @FXML
    void adtxt_Action(ActionEvent event) {

    }

    @FXML
    void kuladtxt_Action(ActionEvent event) {

    }
    
    @FXML
    void back_Click(ActionEvent event) throws Exception{

    	Stage window= new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/UyeGirisi.fxml"));
		window.setTitle("Cicekci");
		window.initStyle(StageStyle.UNDECORATED);
		window.setScene(new Scene(root));
		window.show();
		Stage stage = (Stage) kytol.getScene().getWindow();
		stage.close();

    }

    @FXML
    void kytbtn_Click(ActionEvent event) throws Exception {
    	if(event.getSource()==kytbtn1)
    	{
    	
    	String sql ="insert into kayitol (adi,soyadi,telefon,kmail,kullaniciadi,sifre) values (?,?,?,?,?,?)";
    	 try {
			sorguIfadesi=baglanti.prepareStatement(sql);
			sorguIfadesi.setString(1,adtxt1.getText().trim());
	        sorguIfadesi.setString(2,soyadtxt1.getText().trim());
	        sorguIfadesi.setString(3,teltxt1.getText().trim());
	        sorguIfadesi.setString(4,kmail.getText().trim());
	        sorguIfadesi.setString(5,kuladtxt1.getText().trim());
	        sorguIfadesi.setString(6,sifretxt1.getText().trim());
	        sorguIfadesi.executeUpdate();
            JOptionPane.showMessageDialog(null,"kayit başarıyla eklendi");
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null,"eklenemedi: "+e);
			
		}
    	 finally
			{
				
		        sorguIfadesi.close();
				
		        adtxt1.setText("");
		        soyadtxt1.setText("");
		        teltxt1.setText("");
		        kmail.setText("");
		        kuladtxt1.setText("");
		        sifretxt1.setText("");
	            
				
			}
    	}
    	

    }
    
    @FXML
    void kmail_Click(ActionEvent event) {

    }
    
    @FXML
    void kapatt_Click(ActionEvent event) {
    	Platform.exit();

    }

    @FXML
    void sifretxt_Action(ActionEvent event) {

    }

    @FXML
    void soyadtxt_Action(ActionEvent event) {

    }

    @FXML
    void teltxt_Action(ActionEvent event) {

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
