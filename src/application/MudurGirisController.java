package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.cicekciMysql.util.VeritabaniUtil;

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

public class MudurGirisController {
	
	public MudurGirisController() {
		baglanti=VeritabaniUtil.Baglan();
		
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane manasyfa;

    @FXML
    private Button mgrsyp;

    @FXML
    private TextField mkuladi;

    @FXML
    private PasswordField msfre;
    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;

    @FXML
    void mgrsyp_Click(ActionEvent event) {
    	
    	if(event.getSource()==mgrsyp)
    	{
    		try
    		{

    	    	 baglanti();
    	    	String sql="select * from müdürekledüzenle where Kullanıcı_Adı=? and Şifre=?";
    	    	sorguIfadesi=baglanti.prepareStatement(sql);
    	    	sorguIfadesi.setString(1, mkuladi.getText().trim());
    	    	sorguIfadesi.setString(2, msfre.getText().trim());
    	    	ResultSet getirilen=sorguIfadesi.executeQuery();
    	    	getirilen.next();
    	    	
    	    	if (mkuladi.getText().equals(getirilen.getString("Kullanıcı_Adı")) && msfre.getText().equals(getirilen.getString("Şifre")));
    			{
    				Stage window= new Stage();
    				Parent root = FXMLLoader.load(getClass().getResource("/application/MudurAnasayfa.fxml"));
    				window.setTitle("Cicekci");
    				window.initStyle(StageStyle.UNDECORATED);
    				window.setScene(new Scene(root));
    				window.show();
    				Stage stage = (Stage) manasyfa.getScene().getWindow();
    				stage.close();
    				
    			}
    		}catch (Exception hata)
        		{
        			JOptionPane.showMessageDialog(null,"bilinmeyen bir hata: "+hata);
        		}
    		}
    	}
    				 	    				
    	

    			
    	 			
        		

    

    private void baglanti() {
    	baglanti=VeritabaniUtil.Baglan();
        if(baglanti==null)
        {
        	System.out.println("Bağlantı Kurulamadı");
        }
		
		
	}









	@FXML
    void initialize() {
       

    }

}
