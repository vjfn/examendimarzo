module com.example.examendimarzo {
    requires javafx.controls;
    requires javafx.fxml;

    //Imprescindible para sql y jaspereports

    requires java.sql;
    requires jasperreports;
    requires javafx.swing;

    //abrir todos los paquetes
    opens utils;
    opens clase;

    opens com.example.examendimarzo to javafx.fxml;
    exports com.example.examendimarzo;
}