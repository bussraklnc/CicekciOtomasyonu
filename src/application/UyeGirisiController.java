package application;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.cicekciMysql.util.VeritabaniUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.*;

public class UyeGirisiController {
	public UyeGirisiController() {
		baglanti=VeritabaniUtil.Baglan();
		
	}

	 @FXML
	 private Button btn_mesaj;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField btn_sıfre;

    @FXML
    private Button cancel_btn;

    @FXML
    private Button girisbtn;

    @FXML
    private RadioButton hatirlatxt;

    @FXML
    private TextField kuladtxt;

    @FXML
    private Button kytolbtn;
    
    @FXML
    private Label lbl_mesaj;
    @FXML
    private AnchorPane uyegrs;

    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;
    
    
    @FXML
    void butonlar_Click(ActionEvent event) throws Exception  {
    	if(event.getSource()==girisbtn)
    	{
    		try
    		{

    	    	 baglanti();
    	    	String sql="select * from kayitol where kullaniciadi=? and sifre=?";
    	    	sorguIfadesi=baglanti.prepareStatement(sql);
    	    	sorguIfadesi.setString(1, kuladtxt.getText().trim());
    	    	sorguIfadesi.setString(2, btn_sıfre.getText().trim());
    	    	ResultSet getirilen=sorguIfadesi.executeQuery();
    	    	getirilen.next();
    	    	if (kuladtxt.getText().equals(getirilen.getString("kullaniciadi")) && btn_sıfre.getText().equals(getirilen.getString("sifre")));
    	    			{
    	    				Stage window= new Stage();
    	    				Parent root = FXMLLoader.load(getClass().getResource("/application/KullaniciAnasayfa.fxml"));
    	    				window.setTitle("Cicekci");
    	    				window.initStyle(StageStyle.UNDECORATED);
    	    				window.setScene(new Scene(root));
    	    				window.show();
    	    				Stage stage = (Stage) uyegrs.getScene().getWindow();
    	    				stage.close();
    	    				 	    				
    		} //JOptionPane.showMessageDialog(null,"hatalı giriş yaptınız!!!");
    		  //baglanti.close();//
    	    			
    		} catch (Exception hata)
    		{
    			JOptionPane.showMessageDialog(null,"bilinmeyen bir hata: "+hata);
    		}
    		
    	
    	}

    }

    @FXML
    void btn_sıfre_Action(ActionEvent event) {

    }

    @FXML
    void cancel_btn_Action(ActionEvent event) {

    }

    @FXML
    void girisbtn_Click(ActionEvent event)  {
    	
    	
    			
    	} 
  

    
    
   
    
  

    private void baglanti() {
		
		
	}

	@FXML
    void hatirlatxt_Action(ActionEvent event) {

    }

    @FXML
    void kuladtxt_Action(ActionEvent event) {

    }

    @FXML
    void kytolbtn_Action(ActionEvent event) throws Exception {
    	Stage window= new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/KayitOl.fxml"));
		window.setTitle("Cicekci");
		window.initStyle(StageStyle.UNDECORATED);
		window.setScene(new Scene(root));
		window.show();
		Stage stage = (Stage) uyegrs.getScene().getWindow();
		stage.close();
    }

    @FXML
    void initialize() {
       

    }

}
