package com.project;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


public class ControllerVista1 implements initialize{
    
    @FXML
    Button vista1 = new Button();

    @FXML
    Button action1 = new Button();

    private cambiarVista1() {
        vista1.setOnAction(event -> {
            UtilsViews.setViewAnimating(null);
        });
    }
    

}
