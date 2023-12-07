module com.example.arcadeplatformer {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens com.example.arcadeplatformer to javafx.fxml;
    exports com.example.arcadeplatformer;
    exports com.example.arcadeplatformer.masking;
    opens com.example.arcadeplatformer.masking to javafx.fxml;
    exports com.example.arcadeplatformer.aabb_collision;
    opens com.example.arcadeplatformer.aabb_collision to javafx.fxml;
}