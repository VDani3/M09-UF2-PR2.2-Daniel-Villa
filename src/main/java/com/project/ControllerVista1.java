//Fet per Daniel Villa
package com.project;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


public class ControllerVista1{

    @FXML
    Button vista1 = new Button();

    @FXML
    Button action1 = new Button();

    @FXML
    Button action2 = new Button();

    @FXML
    Button action3 = new Button();

    @FXML
    ProgressBar progress1 = new ProgressBar();

    @FXML
    ProgressBar progress2 = new ProgressBar();

    @FXML
    ProgressBar progress3 = new ProgressBar();

    @FXML
    Label tasca1 = new Label();

    @FXML
    Label tasca2 = new Label();

    @FXML
    Label tasca3 = new Label();

    @FXML
    private void nextView(ActionEvent event) {
        try{ 
            UtilsViews.addView(getClass(), "Normal1", "/assets/view1.fxml");
            UtilsViews.setViewAnimating("Normal1");
        } catch (Exception e) {}
    }

      //Nous Threads
    private ExecutorService executor = Executors.newFixedThreadPool(1);
    private ExecutorService executor2 = Executors.newFixedThreadPool(1);
    private ExecutorService executor3 = Executors.newFixedThreadPool(1);

      //Verificar si esta en ejecucion
    private boolean tareaEnEjecucion = false;
    private boolean tareaEnEjecucion2 = false;
    private boolean tareaEnEjecucion3 = false;

    @FXML
    private void execute1(ActionEvent event) {
         //Comprobamos si ya se esta ejecutando, en caso afirmativo la paramos
        if (tareaEnEjecucion) {
            // Detén la tarea
            tareaEnEjecucion = false;
            action1.setText("Iniciar");
            tasca1.setText("Tasca1 - Pause");
            return; // Sale del método
        }

          //Si no pues la iniciamos
        tasca1.setText("Tasca1");
        action1.setText("Aturar");
        tareaEnEjecucion = true;
        executor.submit(() -> {
            try{
                progress1.setProgress(0);
                for (float i = 0; i <= 100 && tareaEnEjecucion; i++) {
                    final float progress = i/100;
                      //Actualitzar la barra de progres
                    //Colorines
                    Platform.runLater(() -> {
                        progress1.setProgress(progress);
                          //Rojito
                        if (progress < 0.1) {
                            progress1.setStyle("-fx-accent: #a84632;");

                        } else if (progress > 0.1 && progress < 0.3) {
                              //Naranjita
                            progress1.setStyle("-fx-accent: #a86932;");
                        
                        } else if (progress > 0.3 && progress < 0.4) {
                              //Naranjita
                            progress1.setStyle("-fx-accent: #a88132;");
                        
                        } else if (progress > 0.4 && progress < 0.5) {
                              //Amarillito
                            progress1.setStyle("-fx-accent: #a89332;");
                        
                        } else if (progress > 0.5 && progress < 0.6) {
                              //Amarillo
                            progress1.setStyle("-fx-accent: #a8a832;");
                        
                        } else if (progress > 0.7 && progress < 0.8) {
                              //Verdoso
                            progress1.setStyle("-fx-accent: #8da832;");
                        
                        } else if (progress > 0.8 && progress < 0.9) {
                              //Verde
                            progress1.setStyle("-fx-accent: #64a832;");
                        
                        } else if (progress > 0.9) {
                              //Verde Potente
                            progress1.setStyle("-fx-accent: #17731c;");
                        }
                        tasca1.setText("Tasca1, "+Float.toString(progress*100)+"%:");

                        if (progress >= 1) {
                            action1.setText("Recargar");
                            tasca1.setText("Tasca1 - Done");
                            tareaEnEjecucion = false;
                        }
                    });
                    Thread.sleep(1000);
                }
            } catch (Exception e) {e.printStackTrace();}
        });
    }

    @FXML
    private void execute2(ActionEvent event) {

         //Comprobamos si ya se esta ejecutando, en caso afirmativo la paramos
        if (tareaEnEjecucion2) {
            // Detén la tarea
            tareaEnEjecucion2 = false;
            action2.setText("Iniciar");
            tasca2.setText("Tasca2 - Pause");
            return; // Sale del método
        }
          //Si no pues la iniciamos
        Random r = new Random();
        tareaEnEjecucion2 = true;
        tasca2.setText("Tasca2");
        action2.setText("Aturar");

        executor2.submit(() -> {
            try{
                progress2.setProgress(0);
                for (float i = 0; i <= 100 && tareaEnEjecucion2; i++) {
                    int p = r.nextInt(3) + 2;
                    i += p;
                    final float progress = i/100;
                      //Actualitzar la barra de progres
                    //Colorines
                    Platform.runLater(() -> {
                        progress2.setProgress(progress);
                          //Lila
                        if (progress < 0.1) {
                            progress2.setStyle("-fx-accent: #542496;");

                        } else if (progress > 0.1 && progress < 0.3) {
                              //Azul mar
                            progress2.setStyle("-fx-accent: #242496;");
                        
                        } else if (progress > 0.3 && progress < 0.4) {
                              //Azul maroso
                            progress2.setStyle("-fx-accent: #245296;");
                        
                        } else if (progress > 0.4 && progress < 0.5) {
                              //Azul
                            progress2.setStyle("-fx-accent: #247c96;");
                        
                        } else if (progress > 0.5 && progress < 0.6) {
                              //Azulico
                            progress2.setStyle("-fx-accent: #249687;");
                        
                        } else if (progress > 0.7 && progress < 0.8) {
                              //Verdoso
                            progress2.setStyle("-fx-accent: #17734d;");
                        
                        } else if (progress > 0.8 && progress < 0.9) {
                              //Verde
                            progress2.setStyle("-fx-accent: #64a832;");
                        
                        } else if (progress > 0.9) {
                              //Verde Potente
                            progress2.setStyle("-fx-accent: #17731c;");
                        }
                        tasca2.setText("Tasca2, "+Float.toString(progress*100)+"%:");
                        if (progress >= 1) {
                            action2.setText("Iniciar");
                            tasca2.setText("Tasca2 - Done");
                            tareaEnEjecucion2 = false;
                        }
                    });
                    
                    Thread.sleep((r.nextInt(3) + 3)*1000);
                }
            } catch (Exception e) {e.printStackTrace();}
        });
    }

    @FXML
    private void execute3(ActionEvent event) {

        if (tareaEnEjecucion3 == true) {
            tasca3.setText("Tasca3 - Pause");
            action3.setText("Iniciar");
            tareaEnEjecucion3 = false;
            return;
        }

        Random r = new Random();
        action3.setText("Aturar");
        tasca3.setText("Tasca3");
        tareaEnEjecucion3 = true;
        executor3.submit(() -> {
            try{
                progress3.setProgress(0);
                for (float i = 0; i <= 100 && tareaEnEjecucion3; i++) {
                    int p = r.nextInt(3) + 4;
                    i += p;
                    final float progress = i/100;
                      //Actualitzar la barra de progres
                    //Colorines
                    Platform.runLater(() -> {
                        progress3.setProgress(progress);
                          //Randoms
                        if (progress < 0.1) {
                            progress3.setStyle("-fx-accent: #859624;");

                        } else if (progress > 0.1 && progress < 0.3) {
                            progress3.setStyle("-fx-accent: #962424;");
                        
                        } else if (progress > 0.3 && progress < 0.4) {
                            progress3.setStyle("-fx-accent: #a88132;");
                        
                        } else if (progress > 0.4 && progress < 0.5) {
                            progress3.setStyle("-fx-accent: #839624;");
                        
                        } else if (progress > 0.5 && progress < 0.6) {
                            progress3.setStyle("-fx-accent: #452496;");
                        
                        } else if (progress > 0.7 && progress < 0.8) {
                            progress3.setStyle("-fx-accent: #24962e;");
                        
                        } else if (progress > 0.8 && progress < 0.9) {
                            progress3.setStyle("-fx-accent: #332496;");
                        
                        } else if (progress > 0.9) {
                              //Verde Potente
                            progress3.setStyle("-fx-accent: #17731c;");
                        }
                        tasca3.setText("Tasca3, "+Float.toString(progress*100)+"%:");
                        if (progress >= 1) {
                            action3.setText("Iniciar");
                            tasca3.setText("Tasca3 - Done");
                            tareaEnEjecucion3 = false;
                        }
                    });
                    Thread.sleep((r.nextInt(6) + 3)*1000);
                }
            } catch (Exception e) {e.printStackTrace();}
        });
    }
}
