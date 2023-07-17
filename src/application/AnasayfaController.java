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

public class AnasayfaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anasyfa;

    @FXML
    private Button kulgrs;

    @FXML
    private Button mgrs;

    @FXML
    private Button pgrs;
    
    @FXML
    private Button kapatbtn;

    @FXML
    void kulgrs_Click(ActionEvent event) throws Exception {
    	Stage window= new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/UyeGirisi.fxml"));
		window.setTitle("Cicekci");
		window.initStyle(StageStyle.UNDECORATED);
		window.setScene(new Scene(root));
		window.show();
		Stage stage = (Stage) anasyfa.getScene().getWindow();
		stage.close();

    }

    @FXML
    void mgrs_Click(ActionEvent event) throws Exception {
    	Stage window= new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/MudurGiris.fxml"));
		window.setTitle("Cicekci");
		window.initStyle(StageStyle.UNDECORATED);
		window.setScene(new Scene(root));
		window.show();
		Stage stage = (Stage) anasyfa.getScene().getWindow();
		stage.close();

    }

    @FXML
    void pgrs_Click(ActionEvent event) throws Exception {
    	Stage window= new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/PersonelGiris.fxml"));
		window.setTitle("Cicekci");
		window.initStyle(StageStyle.UNDECORATED);
		window.setScene(new Scene(root));
		window.show();
		Stage stage = (Stage) anasyfa.getScene().getWindow();
		stage.close();

    }
    
    @FXML
    void kapatbtn_Click(ActionEvent event) {
    	Platform.exit();

    }

    @FXML
    void initialize() {
        

    }

}
