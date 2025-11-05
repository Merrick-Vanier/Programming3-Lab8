package lab08;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author 6237800
 */
public class Lab08FXMLController implements Initializable {

    @FXML
    private ToggleGroup colorToggleGroup;
    @FXML
    private ToggleGroup sizeToggleGroup;
    @FXML
    private Pane drawingAreaPane;
    @FXML
    private RadioButton blackRadioButton;
    @FXML
    private RadioButton redRadioButton;
    @FXML
    private RadioButton greenRadioButton;
    @FXML
    private RadioButton blueRadioButton;
    @FXML
    private RadioButton smallRadioButton;
    @FXML
    private RadioButton mediumRadioButton;
    @FXML
    private RadioButton largeRadioButton;

    //instance variables for managing painter state
    private PenSize radius = PenSize.Medium;
    private Paint brushColor = Color.BLACK;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        blackRadioButton.setUserData(Color.BLACK);
        redRadioButton.setUserData(Color.RED);
        greenRadioButton.setUserData(Color.GREEN);
        blueRadioButton.setUserData(Color.BLUE);
        smallRadioButton.setUserData(PenSize.Small);
        mediumRadioButton.setUserData(PenSize.Medium);
        largeRadioButton.setUserData(PenSize.Large);
    }    
    

    @FXML
    private void colorRadioButtonSelected(ActionEvent event) {
        brushColor = (Color) colorToggleGroup.getSelectedToggle().getUserData();
    }

    @FXML
    private void sizeRadioButtonSelected(ActionEvent event) {
        radius = (PenSize) sizeToggleGroup.getSelectedToggle().getUserData();
    }

    @FXML
    private void undoButtonPressed(ActionEvent event) {
        if (!drawingAreaPane.getChildren().isEmpty()) {
            drawingAreaPane.getChildren().removeLast();
        }
    }

    @FXML
    private void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().removeAll(drawingAreaPane.getChildren());
    }

    @FXML
    private void drawingAreaMouseDragged(MouseEvent event) {
        Circle circle = new Circle(event.getX(), event.getY(), radius.getRadius());
        circle.setFill(brushColor);
        drawingAreaPane.getChildren().add(circle);
    }
    
    private enum PenSize {
        Small(2),
        Medium(4),
        Large(6);
        
        private final int radius;
        
        PenSize(int radius) {this.radius = radius;}
        
        public int getRadius() {return radius;}
    }
}
