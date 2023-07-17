package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.cicekciMysql.util.VeritabaniUtil;

import Models.MudurPersonel2;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class MudurEkleDuzenle2Controller {
	
	ObservableList<MudurPersonel2> list2=FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField aditxt;

    @FXML
    private Button duzenlebtn;

    @FXML
    private Button eklebtn;
    
    @FXML
    private Button kpt_btn;

    @FXML
    private Label lbl_sonuc;

    @FXML
    private TextField mailtxt;
    
    @FXML
    private AnchorPane mekle2;
    
    @FXML
    private Button back3;

    @FXML
    private Button mliste;

    @FXML
    private Button silbtn;

    @FXML
    private TextField soyadtxt;

    @FXML
    private TextField telnotxt;

    @FXML
    private Button temizbtn;

    @FXML
    private TextField usersifretxt;

    @FXML
    private TextField usertxt;

    @FXML
    private TextField ıdtxt;
    
    @FXML
    private TableColumn<MudurPersonel2, String> adicol2;
    
    @FXML
    private TableColumn<MudurPersonel2, String> kulcol2;

    @FXML
    private TableColumn<MudurPersonel2, String> mailcol2;
    
    @FXML
    private TableView<MudurPersonel2> mlist2;
    
    @FXML
    private TableColumn<MudurPersonel2, String> sifrecol2;
    
    @FXML
    private TableColumn<MudurPersonel2, String> soyadcol2;
    
    @FXML
    private TableColumn<MudurPersonel2, String> telcol2;
    
    @FXML
    private TableColumn<MudurPersonel2, String> ıdcol2;
    
    @FXML
    void click2(MouseEvent event) {

    }
    
    
    Connection baglanti;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;

   

    @FXML
    void duzenbtn_Click(ActionEvent event) {
    	try{

    		baglanti();
    		String sql = "update müdürekledüzenle set Adı=?,Soyadı=?,Telefon=?,Mail=?,Kullanıcı_Adı=?,Şifre=? where MudurID=?";
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		sorguIfadesi.setString(1,aditxt.getText());
    		sorguIfadesi.setString(2,soyadtxt.getText());
    		sorguIfadesi.setString(3,telnotxt.getText());
    		sorguIfadesi.setString(4,mailtxt.getText());
    		sorguIfadesi.setString(5,usertxt.getText());
    		sorguIfadesi.setString(6,usersifretxt.getText());
    		sorguIfadesi.setString(7,ıdtxt.getText());
    		sorguIfadesi.executeUpdate();
    		JOptionPane.showMessageDialog(null,"kayit başarıyla güncellendi");
    		
    		
    		} catch (Exception hata)
    		{
    		JOptionPane.showMessageDialog(null,"eklenemedi: "+hata);
    		}


    }

    

	private void baglanti() {
		
		
	}

	@FXML
    void eklebtn_Click(ActionEvent event) throws Exception {
    	PreparedStatement sorguIfadesi=null;
    	


    	String mudurpersonel2Adi=aditxt.getText();
    	String mudurpersonel2Soyad=soyadtxt.getText();
    	String mudurpersonel2Telefon=telnotxt.getText();
    	String mudurpersonel2Mail=mailtxt.getText();
    	String mudurpersonel2Kulad=usertxt.getText();
    	String mudurpersonel2Sifre=usersifretxt.getText();
    	String mudurpersonel2Mid=ıdtxt.getText();

    	if (mudurpersonel2Adi.isEmpty() || mudurpersonel2Soyad.isEmpty() || mudurpersonel2Telefon.isEmpty() || mudurpersonel2Mail.isEmpty() || mudurpersonel2Kulad.isEmpty() || mudurpersonel2Sifre.isEmpty() || mudurpersonel2Mid.isEmpty()) 
    	    	{
    	            Alert alert = new Alert(Alert.AlertType.ERROR);
    	            alert.setHeaderText(null);
    	            alert.setContentText("Tüm alanları doldurunuz");
    	            alert.showAndWait();
    	            return;
    	        }

    	String sql="insert into müdürekledüzenle(Adı,Soyadı,Telefon,Mail,Kullanıcı_Adı,Şifre,MudurID) values(?,?,?,?,?,?,?)";
    	try 
    			{
    				            sorguIfadesi=baglanti.prepareStatement(sql);
    	                        sorguIfadesi.setString(1,aditxt.getText().trim());
    	                        sorguIfadesi.setString(2,soyadtxt.getText().trim());
    	                        sorguIfadesi.setString(3,telnotxt.getText().trim());
    	                        sorguIfadesi.setString(4,mailtxt.getText().trim());
    	                        sorguIfadesi.setString(5,usertxt.getText().trim());
    	                        sorguIfadesi.setString(6,usersifretxt.getText().trim());
    	                        sorguIfadesi.setString(7,ıdtxt.getText().trim());
    	                        
    	                        sorguIfadesi.execute();
    	                        JOptionPane.showMessageDialog(null,"kayit başarıyla eklendi");
    	                           				
  
    			}catch (Exception hata) 
    			{
    			
    				JOptionPane.showMessageDialog(null,"eklenemedi: "+hata);
    			}
    	finally
    			{
    				
    		        sorguIfadesi.close();
    				
    				aditxt.setText("");
    				soyadtxt.setText("");
    				telnotxt.setText("");
    				mailtxt.setText("");
    	            usertxt.setText("");
    	            usersifretxt.setText("");
    	            ıdtxt.setText("");
    				
    			}
    			
    }

    @FXML
    void mlist_Click(ActionEvent event) throws Exception {
    	Stage window= new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/MudurlerListele.fxml"));
		window.setTitle("Cicekci");
		window.initStyle(StageStyle.UNDECORATED);
		window.setScene(new Scene(root));
		window.show();
		Stage stage = (Stage) mekle2.getScene().getWindow();
		stage.close();

    }

    @FXML
    void silbtn_Click(ActionEvent event) {
    	try {
    		baglanti();
    		String sql = "delete from müdürekledüzenle where MudurID=?";
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		sorguIfadesi.setString(1,ıdtxt.getText());
    		sorguIfadesi.executeUpdate();
    		JOptionPane.showMessageDialog(null,"kayit başarıyla silindi");
    		} catch (Exception hata)
    		{
    		JOptionPane.showMessageDialog(null,"eklenemedi: "+hata);
    		}

    	

    }

    @FXML
    void temizbtn_Click(ActionEvent event) {

    }
    
    @FXML
    void back3_Click(ActionEvent event) throws Exception {
    	Stage window= new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/MudurAnasayfa.fxml"));
		window.setTitle("Cicekci");
		window.initStyle(StageStyle.UNDECORATED);
		window.setScene(new Scene(root));
		window.show();
		Stage stage = (Stage) mekle2.getScene().getWindow();
		stage.close();
    	
    	
    }
    
    @FXML
    void kpt_btn_Click(ActionEvent event) throws Exception {
    	
    	Platform.exit();

    }

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
    	
    	
    	
    	
        adicol2.setCellValueFactory(new PropertyValueFactory<>("adi"));
        soyadcol2.setCellValueFactory(new PropertyValueFactory<>("soyad"));
        telcol2.setCellValueFactory(new PropertyValueFactory<>("telefon"));
        mailcol2.setCellValueFactory(new PropertyValueFactory<>("mail"));
        kulcol2.setCellValueFactory(new PropertyValueFactory<>("kulad"));
        sifrecol2.setCellValueFactory(new PropertyValueFactory<>("sifre"));
        ıdcol2.setCellValueFactory(new PropertyValueFactory<>("mid"));
    }
 


private void loadData() 
	{
		PreparedStatement sorguIfadesi=null;
        ResultSet getirilen=null;
              
		
     String sql="SELECT * FROM müdürekledüzenle";
try
		{
			sorguIfadesi=baglanti.prepareStatement(sql);
			getirilen=sorguIfadesi.executeQuery();
while(getirilen.next())
			{
	initCol() ;
				String adix=getirilen.getString("Adı");//getString içinde yazanlar veritabanındaki kolon adları
				String soyadx=getirilen.getString("Soyadı");
				String telefonx=getirilen.getString("Telefon");
				String mailx=getirilen.getString("Mail");
				String kuladx=getirilen.getString("Kullanıcı_Adı");
             String sifrex=getirilen.getString("Şifre");
             String midx=getirilen.getString("MudurID");

				
				list2.add(new MudurPersonel2(adix,soyadx,telefonx,mailx,kuladx,sifrex,midx));
			}
			} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		mlist2.getItems().addAll(list2);
//mlist.setItems(list);
			
		} 

}



