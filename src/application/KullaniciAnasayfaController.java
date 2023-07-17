package application;

import java.io.IOException;
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

public class KullaniciAnasayfaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button akuba_btn;

    @FXML
    private Button arneca_btn;

    @FXML
    private Button baris_btn;

    @FXML
    private Button begonvil_btn;

    @FXML
    private Button berberis_btn;

    @FXML
    private Button bon_btn;

    @FXML
    private Button cicek_btn;

    @FXML
    private Button cikis_btn;

    @FXML
    private Button deve_btn;

    @FXML
    private Button gbre_btn;

    @FXML
    private AnchorPane ilkgrs;

    @FXML
    private AnchorPane ilkgrs1;

    @FXML
    private AnchorPane ilkgrs2;

    @FXML
    private AnchorPane ilkgrs3;

   

    @FXML
    private Button kaktus_btnn;

    @FXML
    private Button kapat_btn;

    @FXML
    private Button kar_btn;

    @FXML
    private Button kltya_btn;

    @FXML
    private AnchorPane kuladanasyfa;

    @FXML
    private Button orkide_btn;

    @FXML
    private Button para_btn;

    @FXML
    private Button saksi_btn;

    @FXML
    private Button sknt_btn;

    @FXML
    void akuba_btn_Click(ActionEvent event) {

    }

    @FXML
    void arneca_btn_Click(ActionEvent event) {

    }

    @FXML
    void baris_btn_Click(ActionEvent event) {

    }

    @FXML
    void begonvil_btn_Click(ActionEvent event) {

    }

    @FXML
    void berberis_btn_Click(ActionEvent event) {

    }

    @FXML
    void bon_btn_Click(ActionEvent event) {

    }

    @FXML
    void cicek_btn_Click(ActionEvent event) {

    }

    @FXML
    void cikis_btn_click(ActionEvent event) {
    	cikis_btn.getScene().getWindow().hide();
    	Stage login = new Stage();
    	Parent root;
    	try {
    	root = FXMLLoader.load(getClass().getResource("/application/UyeGirisi.fxml"));

    	Scene scene = new Scene(root);
    	login.setScene(scene);
    	login.show();
    	login.setResizable(false);
    	} catch (IOException e) 
    	{
    	e.printStackTrace();
    	}
    	
    	

    }

    @FXML
    void deve_btn_Click(ActionEvent event) {

    }

    @FXML
    void gbre_btn_Click(ActionEvent event) {

    }

    @FXML
    void kaktusbtnn_Click(ActionEvent event) {

    }

    @FXML
    void kapat_btn_Click(ActionEvent event) {
    	Platform.exit();

    }

    @FXML
    void kar_btn_Click(ActionEvent event) {

    }

    @FXML
    void kltya_btn_Click(ActionEvent event) {

    }

    @FXML
    void orkide_btn_Click(ActionEvent event) {

    }

    @FXML
    void para_btn_Click(ActionEvent event) {

    }

    @FXML
    void saksi_btn_Click(ActionEvent event) {

    }

    @FXML
    void sknt_btn_Click(ActionEvent event) {

    }

    @FXML
    void initialize() {
        

    }

}
