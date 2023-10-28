module com.example.arcadeplatformer {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens com.example.arcadeplatformer to javafx.fxml;
    exports com.example.arcadeplatformer;
}