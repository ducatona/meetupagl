module com.netgenius.v3_meet_up_agl {
   
    
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.sql;
    requires java.base;
    
    
    
    
    opens recursos;
    opens controladores;
    opens estilos to javafx.fxml, javafx.graphics;
    opens principal to javafx.fxml;
    exports principal;
   
}
 