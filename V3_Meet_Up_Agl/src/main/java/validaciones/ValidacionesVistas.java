/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validaciones;

import java.time.LocalDate;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Usuario
 */
public class ValidacionesVistas {
      
    /**
     * Comprubea si algun campo esta vacio y devuelve un bolleano
     * @param <T> Objeto que extienda de la clase TextInputControl
     * @param campos Los objetos se convierten en un arrayList para trabajar dentro del metodo
     * @return devuelve false si se cumple la condicion isBlank, en caso contrario true
     */
    public static <T extends TextInputControl> boolean comprobarCamposVacios (T... campos){
        for(T campo : campos){
            if (campo.getText().isBlank()) {
                alertasWarning("Error, campo vacio", null, "Debe rellenar el campo " + campo.getId());
                return false;
            }
        }
        return true;
    }
    
    /**
     * Lanza una ventana emergente de tipo Warning
     * @param titulo Titulo de la ventana emergente
     * @param header Header de la ventana emergente
     * @param contenido Mensaje a mostrar en la ventana emergente
     */
    public static void alertasWarning(String titulo, String header, String contenido) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle(titulo);
        alerta.setHeaderText(header);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }
    
    /**
     * Valida el formato de un correo electronico
     * @param email textfield donde se escribira el email
     * @return devuelve true o false, si es false tambien muestra un warning
     */
    public static boolean validarEmail(TextField email) {
        if (!email.getText().matches("[a-zA-Z0-9.\\-_]+@[a-z]+\\.[a-z]{2,4}")) {
            alertasWarning("Error de  formato", null, "Formato de email no valido");
            return false;
        }
        return true;
    }
    
    /**
     * Valida que se a seleccionado una opcion del comboBox
     * @param comboBox comboBox a validar
     * @return devuelve true o false, si es false tambien muestra un warning
     */
    private static boolean validarComboBox(ComboBox<String> comboBox) {
        // Verificar si se ha seleccionado un elemento en el ComboBox
        if (comboBox.getSelectionModel().isEmpty()) {
            alertasWarning("Error", null, "Debe seleccionar un objeto de la lista " + comboBox.getId());
            return false;
        }
        return true;
    }
    
    /**
     * Valida que se a seleccionado una fecha del datePicker
     * @param datePicker datePicker a validar
     * @return devuelve true o false, si es false tambien muestra un warning
     */
    private static boolean  validarDatePicker (DatePicker datePicker) {
        // Verificar si se ha seleccionado una fecha en el DatePicker
        LocalDate selectedDate = datePicker.getValue();
        if (selectedDate == null) {
            alertasWarning("Error", null, "Debe seleccionar una fecha de nacimiento");
            return false;
        } 
        return true;
    }
    
    public static boolean validarContraseña (TextField password, TextField confirmacion){
        if (!password.getText().equals(confirmacion.getText())) {
            alertasWarning("Error", null, "Las contraseñas no coinciden");
            return false;
        }
        return true;
    }
    
    public static boolean comprobarformulario(TextField alias, TextField email, TextField password, TextField confirmacion, ComboBox<String> nacionalidad, ComboBox<String> rol, DatePicker datePicker) {
        return comprobarUsuario(alias) && validarEmail(email) && validarContraseña(password,confirmacion) && validarComboBox(nacionalidad) && validarComboBox(rol) && validarDatePicker(datePicker);
    }
    
    public static boolean comprobarlogin(TextField alias, PasswordField password) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppPersistence");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Long> query = em.createQuery("SELECT COUNT(u) FROM Usuarios u WHERE u.alias = :alias AND u.password = :password", Long.class);
        query.setParameter("alias", alias.getText());
        query.setParameter("password", password.getText());

        Long resultado = query.getSingleResult();

        em.close();
        emf.close();

        if (resultado > 0) {
            return true;
        } else {
            alertasWarning("Error de autentificacion", null, "El usuario o la contraseña no son válidos.");
        }
        return false;
    }
    
    public static  boolean comprobarUsuario(TextField alias) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppPersistence");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Long> query = em.createQuery("SELECT COUNT(u) FROM Usuarios u WHERE u.alias = :alias", Long.class);
        query.setParameter("alias", alias.getText());
        Long resultado = query.getSingleResult();

        em.close();
        emf.close();

        if (resultado > 0) {
            alertasWarning("Error de creacion de cuenta", null, "El usuario ya existe");
            return false;
        }
        return true;
    }
    
     public static int obtenerPosicionSeleccion(ComboBox<String> comboBox) {
        // Obtiene la posición del ítem seleccionado en el ComboBox
        int posicion = comboBox.getSelectionModel().getSelectedIndex() + 1;
        System.out.println("el indice es " + posicion);

        // Retorna la posición
        return posicion;
    }
}
