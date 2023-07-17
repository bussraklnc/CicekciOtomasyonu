package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MudurAnasayfaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane manasayfa;

    @FXML
    private Button mdznle;
    

    @FXML
    private Button back3;

    @FXML
    private Button mlistele;

    @FXML
    private Button pdznle;

    @FXML
    private Button plistele;
    
    @FXML
    private Button back2;

    @FXML
    private Button kapatt2;

    @FXML
    void mdznle_Click(ActionEvent event) throws Exception {
    	Stage window= new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/MudurEkleDuzenle2.fxml"));
		window.setTitle("Cicekci");
		window.initStyle(StageStyle.UNDECORATED);
		window.setScene(new Scene(root));
		window.show();
		//Stage stage = (Stage) manasayfa.getScene().getWindow();
		//stage.close();


    }

    @FXML
    void mlistele_Click(ActionEvent event) throws Exception {
    	Stage window= new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/MudurlerListele.fxml"));
		window.setTitle("Cicekci");
		window.initStyle(StageStyle.UNDECORATED);
		window.setScene(new Scene(root));
		window.show();
		Stage stage = (Stage) manasayfa.getScene().getWindow();
		stage.close();


    }

    @FXML
    void pdznle_Click(ActionEvent event) throws Exception {
    	Stage window= new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/PersonelDuzenle.fxml"));
		window.setTitle("Cicekci");
		window.initStyle(StageStyle.UNDECORATED);
		window.setScene(new Scene(root));
		window.show();
		Stage stage = (Stage) manasayfa.getScene().getWindow();
		stage.close();


    }

    @FXML
    void plistele_Click(ActionEvent event) throws Exception {
    	Stage window= new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/PersonelListele.fxml"));
		window.setTitle("Cicekci");
		window.initStyle(StageStyle.UNDECORATED);
		window.setScene(new Scene(root));
		window.show();
		Stage stage = (Stage) manasayfa.getScene().getWindow();
		stage.close();


    }
    
    @FXML
    void back2_Click(ActionEvent event) throws Exception
    {
    	Stage window= new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/MudurGiris.fxml"));
		window.setTitle("Cicekci");
		window.initStyle(StageStyle.UNDECORATED);
		window.setScene(new Scene(root));
		window.show();
		Stage stage = (Stage) manasayfa.getScene().getWindow();
		stage.close();

    }

    @FXML
    void kapatt2_Click(ActionEvent event) {
    	Platform.exit();

    }

    @FXML
    void initialize() {
        

    }

}
