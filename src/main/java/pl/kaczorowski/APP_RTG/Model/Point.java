package main.java.pl.kaczorowski.APP_RTG.Model;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;

public class Point {

    private String name;
    private Circle circle1;
    private Circle circle2;
    private Circle circle3;
    private Circle circle4;
    private Label labelName, labelX, labelY;
    private TextField textFieldX, textFieldY;

    public String getName() {
        return name;
    }

    public Circle getCircle1() {
        return circle1;
    }

    public Circle getCircle2() {
        return circle2;
    }

    public Circle getCircle3() {
        return circle3;
    }

    public Circle getCircle4() {
        return circle4;
    }

    public Point(String name, Label labelName, Label labelX, TextField textFieldX, Label labelY, TextField textFieldY, Circle circle1,
                 Circle circle2, Circle circle3, Circle circle4) {
        this.name = name;
        this.labelName = labelName;
        this.labelX = labelX;
        this.textFieldX = textFieldX;
        this.labelY = labelY;
        this.textFieldY = textFieldY;
        this.circle1 = circle1;
        this.circle2 = circle2;
        this.circle3 = circle3;
        this.circle4 = circle4;
    }

    public Point(Label labelName, Label labelX, TextField textFieldX, Label labelY, TextField textFieldY, Circle circle1,
                 Circle circle2, Circle circle3, Circle circle4) {
        this.labelName = labelName;
        this.labelX = labelX;
        this.textFieldX = textFieldX;
        this.labelY = labelY;
        this.textFieldY = textFieldY;
        this.circle1 = circle1;
        this.circle2 = circle2;
        this.circle3 = circle3;
        this.circle4 = circle4;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCircle1(Circle circle1) {
        this.circle1 = circle1;
    }

    public void setCircle2(Circle circle2) {
        this.circle2 = circle2;
    }

    public void setCircle3(Circle circle3) {
        this.circle3 = circle3;
    }

    public void setCircle4(Circle circle4) {
        this.circle4 = circle4;
    }

    public Label getLabelName() {
        return labelName;
    }

    public Label getLabelX() {
        return labelX;
    }

    public Label getLabelY() {
        return labelY;
    }

    public TextField getTextFieldX() {
        return textFieldX;
    }

    public TextField getTextFieldY() {
        return textFieldY;
    }

    public void setLabelX(Label labelX) {
        this.labelX = labelX;
    }

    public void setLabelY(Label labelY) {
        this.labelY = labelY;
    }

    @Override
    public String toString() {
        return "Point{" +
                "name='" + name + '\'' +
                ", circle1=" + circle1 +
                ", circle2=" + circle2 +
                ", circle3=" + circle3 +
                ", circle4=" + circle4 +
                ", labelName=" + labelName +
                ", labelX=" + labelX +
                ", labelY=" + labelY +
                ", textFieldX=" + textFieldX +
                ", textFieldY=" + textFieldY +
                '}';
    }
}
