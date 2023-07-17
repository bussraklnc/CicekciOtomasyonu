package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.cicekciMysql.util.VeritabaniUtil;

import Models.MudurPersonel2;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class MudurlerListeleController {

	
	ObservableList<MudurPersonel2> list=FXCollections.observableArrayList();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<MudurPersonel2, String> adicol;

    @FXML
    private TableColumn<MudurPersonel2, String> kulcol;

    @FXML
    private TableColumn<MudurPersonel2, String> mailcol;

    @FXML
    private TableView<MudurPersonel2> mlist;
    
    @FXML
    private TableColumn<MudurPersonel2, String> sifrecol;

    @FXML
    private TableColumn<MudurPersonel2, String> soyadcol;

    @FXML
    private TableColumn<MudurPersonel2, String> telcol;

    @FXML
    private TableColumn<MudurPersonel2, String> ıdcol;
    
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
    	
    	
    	
    	
        adicol.setCellValueFactory(new PropertyValueFactory<>("adi"));
        soyadcol.setCellValueFactory(new PropertyValueFactory<>("soyad"));
        telcol.setCellValueFactory(new PropertyValueFactory<>("telefon"));
        mailcol.setCellValueFactory(new PropertyValueFactory<>("mail"));
        kulcol.setCellValueFactory(new PropertyValueFactory<>("kulad"));
        sifrecol.setCellValueFactory(new PropertyValueFactory<>("sifre"));
        ıdcol.setCellValueFactory(new PropertyValueFactory<>("mid"));
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

				
				list.add(new MudurPersonel2(adix,soyadx,telefonx,mailx,kuladx,sifrex,midx));
			}
			} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		mlist.getItems().addAll(list);
//mlist.setItems(list);
			
		} 

@FXML
void mlist_click(MouseEvent event) {

}


}

