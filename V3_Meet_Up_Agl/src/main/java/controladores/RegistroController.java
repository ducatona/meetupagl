/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class RegistroController implements Initializable {


    @FXML
    private VBox root;
    @FXML
    private TextField nombre;
    @FXML
    private TextField alias;
    @FXML
    private TextField contraseña;
    @FXML
    private ComboBox<?> nacionalidad;
    @FXML
    private TextField apellidos;
    @FXML
    private TextField e_mail;
    @FXML
    private TextField confirmacion;
    @FXML
    private ComboBox<?> rol;
    @FXML
    private DatePicker fechNac;
    @FXML
    private Button registrarse;
    @FXML
    private Button volver;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void registro(ActionEvent event) {
    }

    @FXML
    private void volverLogin(ActionEvent event) {
    }

}
