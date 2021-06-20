package main.java.pl.kaczorowski.APP_RTG.Controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

public class DragController {

    private double coordinateX, coordinateY, orgTranslateX, orgTranslateY;

    EventHandler<MouseEvent> circleOnMousePressedHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            coordinateX = event.getSceneX();
            coordinateY = event.getSceneY();
            orgTranslateX = ((Circle) (event.getSource())).getTranslateX();
            orgTranslateY = ((Circle) (event.getSource())).getTranslateY();
        }
    };

    EventHandler<MouseEvent> circleOnMouseDraggedHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            double offsetX = event.getSceneX() - coordinateX;
            double offsetY = event.getSceneY() - coordinateY;
            double newTranslateX = orgTranslateX + offsetX;
            double newTranslateY = orgTranslateY + offsetY;
            ((Circle) (event.getSource())).setTranslateX(newTranslateX);
            ((Circle) (event.getSource())).setTranslateY(newTranslateY);
        }
    };
}
