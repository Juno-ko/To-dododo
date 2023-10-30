module com.todododogui.todododogui {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
                    requires org.kordamp.bootstrapfx.core;
            
    opens com.todododogui.todododogui to javafx.fxml;
    exports com.todododogui.todododogui;
}