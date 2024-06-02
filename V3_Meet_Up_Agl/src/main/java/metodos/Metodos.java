/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author Usuario
 */
public class Metodos {
     /**
     * Interruptor para mostrar/ocultar un passWordField
     *
     * @param interruptor booleano que se esta usando como interruptor en el
     * evento donde se llama este metodo (ej. interruptor = !interruptor)
     * @param imageView ImagenView donde se mostrara las imagenes de mostrar y
     * ocultar contraseña
     * @param pass PasswordField que se desea mostrar y ocultar su contenido
     * @param rutaImagenTrue String de la ruta de la imagen a mostrar cuando
     * mostrar es true
     * @param rutaImagenFalse String de la ruta de la imagen a mostrar cuando
     * mostrar es false
     */
    public static void interruptorPass(boolean interruptor, ImageView imageView, PasswordField pass, String rutaImagenTrue, String rutaImagenFalse) {
        imageView.requestFocus();
        if (interruptor) {
            Image nuevaImagen = new Image(rutaImagenTrue);
            imageView.setImage(nuevaImagen);
            pass.setPromptText(pass.getText());
            pass.setText("");
        } else {
            Image nuevaImagen = new Image(rutaImagenFalse);
            imageView.setImage(nuevaImagen);
            pass.setText(pass.getPromptText());
            pass.setPromptText("");
        }
    }
    
     public static void opcionesStage(Stage stage, boolean resizable, double width, double height) {
        stage.setResizable(resizable);
        stage.setWidth(width);
        stage.setHeight(height);
        stage.centerOnScreen();
    }
}
