package com.project;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class ControllerVista2 implements Initializable {
    @FXML
    Button vista0 = new Button();

    @FXML
    Pane img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12 = new Pane();

    @FXML
    Pane img13, img14, img15, img16, img17, img18, img19, img20, img21, img22, img23, img24 = new Pane();

    List<Pane> list = new ArrayList<Pane>();

    @FXML
    public void firstView(ActionEvent event) {
        UtilsViews.setViewAnimating("Normal");
    }

    @FXML
    public void carregarImg(ActionEvent event) {
        
    }

    @FXML
    public void aturarImg(ActionEvent event) {
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.add(img1);
        list.add(img2);
        list.add(img3);
        list.add(img4);
        list.add(img5);
        list.add(img6);
        list.add(img7);
        list.add(img8);
        list.add(img9);
        list.add(img10);
        list.add(img11);
        list.add(img12);
        list.add(img13);
        list.add(img14);
        list.add(img15);
        list.add(img16);
        list.add(img17);
        list.add(img18);
        list.add(img19);
        list.add(img20);
        list.add(img21);
        list.add(img22);
        list.add(img23);
        list.add(img24);
    }
}
