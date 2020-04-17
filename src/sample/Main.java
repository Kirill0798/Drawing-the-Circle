package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.canvas.*;

public class Main extends Application {

    final private String filename = "my.xml";
    int heightCanvas = 594;
    int widthCanvas = 766;
    double axesPosX = heightCanvas / 2;
    double axesPosY = widthCanvas / 2;
    GraphicsContext gc;
    public TextField tfx, tfy, tfr;
    public Button btn;
    public Canvas canvas;
    public Label mainLabel;
    Circle circle = new Circle();

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Drawing the circle");


        primaryStage.setScene(new Scene(root, 1000, 700));
        primaryStage.show();
    }
    public void initialize(){
        gc = canvas.getGraphicsContext2D();
        checkStatement();
        drawCircle();
        btn.setOnAction(event -> {
            try {
                calculate();
            } catch (Exception e) {

            }
        });
    }
     private void calculate(){
         double x = Double.parseDouble(tfx.getText());
         double y = Double.parseDouble(tfy.getText());
         double r = Double.parseDouble(tfr.getText());
         if (x != 0 || y != 0) circle.movingVector(x,-y);
         if (r != 0) circle.increaseRadius(r);
         JAXBHelper.saveStatement(filename, circle);
         drawCircle();
     }
     private void drawCircle(){
         gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
         gc.strokeLine(Integer.MIN_VALUE, axesPosX, Integer.MAX_VALUE, axesPosX);
         gc.strokeLine(axesPosY, Integer.MIN_VALUE, axesPosY, Integer.MAX_VALUE);
         double ovalRad = circle.getRadius();
         double ovalPosX = circle.getCoordX() - (ovalRad/2) + widthCanvas/2;
         double ovalPosY = circle.getCoordY() - (ovalRad/2) + heightCanvas/2;
         gc.strokeOval(ovalPosX, ovalPosY, ovalRad,ovalRad);
         setIntoMainLabel(ovalPosY, ovalRad);
     }
     private void checkStatement(){
         circle = JAXBHelper.getStatement(filename, circle);
         if (circle == null) circle = new Circle();
     }
     private void setIntoMainLabel(double ovalPosY, double ovalRad){
         double y = -circle.getCoordY();
         mainLabel.setText(" Окружность с центром в точке: ("+circle.getCoordX() + ", "+y+") и радиусом: "+ovalRad);
     }


    public static void main(String[] args) {
        launch(args);
    }
}
