package com.project;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class ControllerVista2 implements Initializable {
    boolean isCharging = false;
    int completed = 0;

    @FXML
    Button vista0 = new Button();

    @FXML
    ProgressBar pb1 = new ProgressBar();

    @FXML
    AnchorPane anchor1;

    @FXML
    HBox hb, hb2, hb3 = new HBox();

    @FXML
    Label progres = new Label();

    List<ImageView> list = new ArrayList<ImageView>();
    List<CompletableFuture<Image>> list2 = new ArrayList<CompletableFuture<Image>>();
    int num = 0;

    @FXML
    public void firstView(ActionEvent event) {
        UtilsViews.setViewAnimating("Normal");
    }

    @FXML
    public void carregarImg(ActionEvent event) {
        reiniciar();
        progres.setText(String.format("Progres, %s de 24:", completed));
        isCharging = true;
        for (int i = 0; i < list.size(); i++) {
            num = i+1;
            final int pos = i;
            loadImageBackground((image) -> {
                list.get(pos).setImage(image);
                progres.setText("Progres, "+Integer.toString(completed)+" de 24: "); 
            });
        }
    }

    @FXML
    public void aturarImg(ActionEvent event) {
        reiniciar();
    }

    public void loadImageBackground(Consumer<Image> callBack) {
        Random r = new Random();
        int esperar = r.nextInt(45000)+5000;
        int imgNum = num;
        CompletableFuture<Image> futureImage = CompletableFuture.supplyAsync(() -> {
            try {
                // Wait a second to simulate a long loading time
                Thread.sleep(esperar);

                if (isCharging == false) {
                    //System.out.println("kakak");
                    return null;
                }
                // Load the data from the assets file
                Image image = new Image(getClass().getResource("/img/img"+Integer.toString(imgNum)+".jpg").toString());
                completed += 1;
                pb1.setProgress((double) (((completed+1)*100)/24)/100); //Regla de tres to guapa
                if (pb1.getProgress() >= 1 && completed == 24) {
                    pb1.setStyle("-fx-accent: green");
                    isCharging = false;
                }
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
            img1.setFitHeight(40);
            img1.setFitWidth(40);
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

    public void reiniciar() {
        isCharging = false;
        progres.setText("Progres");
        for (int i = 0; i < list.size(); i++) {
            num = i+1;
            final int pos = i;
            list.get(pos).setImage(null);
        }
        pb1.setProgress(0);
        completed = 0;
    }
}
