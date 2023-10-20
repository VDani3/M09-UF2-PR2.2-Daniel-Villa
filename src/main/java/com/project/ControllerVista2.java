package com.project;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class ControllerVista2 implements Initializable {
    @FXML
    Button vista0 = new Button();

    @FXML
    AnchorPane anchor1;

    @FXML
    HBox hb, hb2, hb3 = new HBox();

    List<ImageView> list = new ArrayList<ImageView>();
    int num;

    @FXML
    public void firstView(ActionEvent event) {
        UtilsViews.setViewAnimating("Normal");
    }

    @FXML
    public void carregarImg(ActionEvent event) {
        for (int i = 0; i < list.size(); i++) {
            num = i;
            final int pos = i;
            loadImageBackground((image) -> {
                System.out.println("Image loaded");
                list.get(pos).setImage(image);
            });
        }
    }

    @FXML
    public void aturarImg(ActionEvent event) {
        
    }

    public void loadImageBackground(Consumer<Image> callBack) {
        CompletableFuture<Image> futureImage = CompletableFuture.supplyAsync(() -> {
            try {
                // Wait a second to simulate a long loading time
                Thread.sleep(1000);

                // Load the data from the assets file
                Image image = new Image(getClass().getResource("/assets/img/img"+Integer.toString(num)).toString());
                return image;

            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        })
        .exceptionally(ex -> {
            ex.printStackTrace();
            return null;
        });

        futureImage.thenAcceptAsync(result -> {
            callBack.accept(result);
        }, Platform::runLater);
    }
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 1; i <= 3; i++) {
            for (int e = 1; e <= 8; e++) {
            // Crear ImageView y asignar la imagen
            ImageView img1 = new ImageView();
            img1.setFitHeight(15);
            img1.setFitWidth(15);
            list.add(img1);
            // Agregar el ImageView al HBox
            if (i == 1){

                hb.getChildren().add(img1);
            } else if (i == 2) {
                hb2.getChildren().add(img1);
            } else if (i == 3) {
                hb3.getChildren().add(img1);
            }
            }
        }

    }
}
