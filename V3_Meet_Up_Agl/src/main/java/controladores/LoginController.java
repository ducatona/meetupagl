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

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import metodos.Metodos;
import recursos.Rutas;
/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class LoginController implements Initializable {

    boolean mostrarPass = false;
    @FXML
    private VBox root;    @FXML
    private Label titulo;
    @FXML
    private TextField usuario;
    @FXML
    private PasswordField contraseña;
    @FXML
    private ImageView mostrarOcultar;
    @FXML
    private ImageView logo;
    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//       Image nuevaImagen = new Image("/imagenes/ocultarPass.png");
//        mostrarOcultar.setImage(nuevaImagen);

 Image imagenContraseña = new Image(getClass().getResourceAsStream(Rutas.rutaHidePass));
 mostrarOcultar.setImage(imagenContraseña);
        
 Image imagenLogo = new Image(getClass().getResourceAsStream(Rutas.rutaImgLogo));
 logo.setImage(imagenLogo);
    }    
    
    @FXML
    private void mostrarContraseña(MouseEvent event) {
         mostrarPass = !mostrarPass;
        Metodos.interruptorPass(mostrarPass, mostrarOcultar, contraseña, Rutas.rutaShowPass, Rutas.rutaHidePass);
    }

    @FXML
    private void ingresarRegistro(MouseEvent event) {
    }

    @FXML
    private void ingresarApp(ActionEvent event) {
    }

}
