module com.example.cm2115 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires org.kordamp.bootstrapfx.core;
    requires com.opencsv;
    requires org.apache.commons.csv;

    opens com.example.cm2115 to javafx.fxml;
    exports com.example.cm2115;
    exports com.example.cm2115.model;
    opens com.example.cm2115.model to javafx.fxml;
}