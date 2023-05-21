module asu.onlinebankinggui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens asu.onlinebankinggui to javafx.fxml;
    opens asu.onlinebankinggui.source.src to javafx.base;
    exports asu.onlinebankinggui;
}