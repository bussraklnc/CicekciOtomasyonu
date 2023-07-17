package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.cicekciMysql.util.VeritabaniUtil;

import Models.PersonelD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PersonelDuzenleController {
	
	ObservableList<PersonelD> list3=FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField paditxt;

    @FXML
    private Button pduzenlebtn;
    
    @FXML
    private AnchorPane pekle;

    @FXML
    private Button peklebtn;

    @FXML
    private Button plist;

    @FXML
    private TextField pmailtxt;

    @FXML
    private Button psilbtn;

    @FXML
    private TextField psoyadtxt;

    @FXML
    private TextField ptelnotxt;

    @FXML
    private Button ptemizbtn;
    
    @FXML
    private Button kapat;

    @FXML
    private TextField pusersifretxt;

    @FXML
    private TextField pusertxt;

    @FXML
    private TextField pıdtxt;
    
    @FXML
    private TableColumn<PersonelD, String> padicol2;
    
    @FXML
    private TableColumn<PersonelD, String> pkulcol2;
    
    @FXML
    private TableView<PersonelD> plist2;

    @FXML
    private TableColumn<PersonelD, String> pmailcol2;
    
    @FXML
    private TableColumn<PersonelD, String> psifrecol2;
    
    @FXML
    private TableColumn<PersonelD, String> psoyadcol2;
    
    @FXML
    private TableColumn<PersonelD, String> ptelcol2;

    @FXML
    private TableColumn<PersonelD, String> pıdcol2;
    
    
    
    Connection baglanti;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;

    @FXML
    void pduzenbtn_Click(ActionEvent event) {
    	
    	try{

    		baglanti();
    		String sql = "update personelduzenle set pAdi=?,pSoyadi=?,pTelefon=?,pMail=?,pKulad=?,pSifre=? where pID=?";
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		sorguIfadesi.setString(1,paditxt.getText());
    		sorguIfadesi.setString(2,psoyadtxt.getText());
    		sorguIfadesi.setString(3,ptelnotxt.getText());
    		sorguIfadesi.setString(4,pmailtxt.getText());
    		sorguIfadesi.setString(5,pusertxt.getText());
    		sorguIfadesi.setString(6,pusersifretxt.getText());
    		sorguIfadesi.setString(7,pıdtxt.getText());
    		sorguIfadesi.executeUpdate();
    		JOptionPane.showMessageDialog(null,"kayit başarıyla güncellendi");
    		
    		
    		} catch (Exception hata)
    		{
    		JOptionPane.showMessageDialog(null,"eklenemedi: "+hata);
    		}


    }
    
    @FXML
    void kapat_Click(ActionEvent event) throws Exception {
    	Stage window= new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/MudurAnasayfa.fxml"));
		window.setTitle("Cicekci");
		window.initStyle(StageStyle.UNDECORATED);
		window.setScene(new Scene(root));
		window.show();
		Stage stage = (Stage) pekle.getScene().getWindow();
		stage.close();

    }

    @FXML
    void peklebtn_Click(ActionEvent event) throws Exception{
PreparedStatement sorguIfadesi=null;
    	


    	String personeldPadi=paditxt.getText();
    	String personeldPsoyad=psoyadtxt.getText();
    	String personeldPtelefon=ptelnotxt.getText();
    	String personeldPmail=pmailtxt.getText();
    	String personeldPkulad=pusertxt.getText();
    	String personeldPsifre=pusersifretxt.getText();
    	String personeldPid=pıdtxt.getText();
    	
    	if (personeldPadi.isEmpty() || personeldPsoyad.isEmpty() || personeldPtelefon.isEmpty() || personeldPmail.isEmpty() || personeldPkulad.isEmpty() || personeldPsifre.isEmpty() || personeldPid.isEmpty()) 
    	{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Tüm alanları doldurunuz");
            alert.showAndWait();
            return;
        }
    	
    	
    	String sql="insert into personelduzenle(pAdi,pSoyadi,pTelefon,pMail,pKulad,pSifre,pID) values(?,?,?,?,?,?,?)";
    	try 
    			{
    				sorguIfadesi=baglanti.prepareStatement(sql);
    	                        sorguIfadesi.setString(1,paditxt.getText().trim());
    	                        sorguIfadesi.setString(2,psoyadtxt.getText().trim());
    	                        sorguIfadesi.setString(3,ptelnotxt.getText().trim());
    	                        sorguIfadesi.setString(4,pmailtxt.getText().trim());
    	                        sorguIfadesi.setString(5,pusertxt.getText().trim());
    	                        sorguIfadesi.setString(6,pusersifretxt.getText().trim());
    	                        sorguIfadesi.setString(7,pıdtxt.getText().trim());
    	                        
    	                        sorguIfadesi.execute();
    	                        JOptionPane.showMessageDialog(null,"kayit başarıyla eklendi");
    	                           				
  
    			}catch (Exception hata) 
    			{
    			
    				JOptionPane.showMessageDialog(null,"eklenemedi: "+hata);
    			}
    	
    	finally
		{
			
	        sorguIfadesi.close();
			
			paditxt.setText("");
			psoyadtxt.setText("");
			ptelnotxt.setText("");
			pmailtxt.setText("");
            pusertxt.setText("");
            pusersifretxt.setText("");
            pıdtxt.setText("");
			
		}
    }

    @FXML
    void plist_Click(ActionEvent event) throws Exception {
    	Stage window= new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/PersonelListele.fxml"));
		window.setTitle("Cicekci");
		window.initStyle(StageStyle.UNDECORATED);
		window.setScene(new Scene(root));
		window.show();
		Stage stage = (Stage) pekle.getScene().getWindow();
		stage.close();


    }

    @FXML
    void ptemizbtn_Click(ActionEvent event) {

    }

    @FXML
    void silbtn_Click(ActionEvent event) {
    	try {
    		baglanti();
    		String sql = "delete from personelduzenle where pID=?";
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		sorguIfadesi.setString(1,pıdtxt.getText());
    		sorguIfadesi.executeUpdate();
    		JOptionPane.showMessageDialog(null,"kayit başarıyla silindi");
    		} catch (Exception hata)
    		{
    		JOptionPane.showMessageDialog(null,"eklenemedi: "+hata);
    		}

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
        loadData();
    
       
    }
    
private void initCol() throws Exception{
    	
    	
    	
    	
        padicol2.setCellValueFactory(new PropertyValueFactory<>("padi"));
        psoyadcol2.setCellValueFactory(new PropertyValueFactory<>("psoyad"));
        ptelcol2.setCellValueFactory(new PropertyValueFactory<>("ptelefon"));
        pmailcol2.setCellValueFactory(new PropertyValueFactory<>("pmail"));
        pkulcol2.setCellValueFactory(new PropertyValueFactory<>("pkulad"));
        psifrecol2.setCellValueFactory(new PropertyValueFactory<>("psifre"));
        pıdcol2.setCellValueFactory(new PropertyValueFactory<>("pid"));
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

		
		list3.add(new PersonelD(padix,psoyadx,ptelefonx,pmailx,pkuladx,psifrex,pidx));
	}
	} 
catch (Exception e)
{
	e.printStackTrace();
}
plist2.getItems().addAll(list3);
}

@FXML
void plist2_click(MouseEvent event) {

}




}
