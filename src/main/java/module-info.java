module com.example.pcaccess {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires org.postgresql.jdbc;
    requires java.sql;

    opens com.example.pcaccess to javafx.fxml;
    exports com.example.pcaccess;
    exports com.example.pcaccess.controller;
    opens com.example.pcaccess.controller to javafx.fxml;
}