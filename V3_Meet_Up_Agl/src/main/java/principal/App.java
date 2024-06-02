package principal;

import recursos.Rutas;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.image.Image;
import metodos.Metodos;
import recursos.AtributosVistas;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        
        
      scene = new Scene(loadFXML(Rutas.rutaLogin));
        stage.setScene(scene);
        Image icon = new Image(getClass().getResourceAsStream(Rutas.rutaImgLogo));
        stage.getIcons().add(icon);
        stage.setTitle("Meet Up Agl");
        Metodos.opcionesStage(stage, false, AtributosVistas.loginPrefWidht, AtributosVistas.loginPrefHeight);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
      
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}