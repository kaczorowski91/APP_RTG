package main.java.pl.kaczorowski.APP_RTG.Service;


import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import main.java.pl.kaczorowski.APP_RTG.Model.Point;

public class PointService {

    public PointService() {
    }

    public Point createPointProperty() {
        Color color = Color.color(Math.random(), Math.random(), Math.random());
        Label labelName = new Label();
        labelName.setTextFill(color);
        Label labelX = new Label("X=");
        labelX.setTextFill(color);
        TextField textFieldX = new TextField();
        Label labelY = new Label("Y=");
        labelY.setTextFill(color);
        TextField textFieldY = new TextField();
        Circle circle1 = new Circle();
        Circle circle2 = new Circle();
        Circle circle3 = new Circle();
        Circle circle4 = new Circle();
        circle1.setRadius(15);
        circle2.setRadius(15);
        circle3.setRadius(15);
        circle4.setRadius(15);
        circle1.setFill(color);
        circle2.setFill(color);
        circle3.setFill(color);
        circle4.setFill(color);

        Point point = new Point(labelName, labelX, textFieldX, labelY, textFieldY, circle1, circle2, circle3, circle4);
        return point;
    }

}
