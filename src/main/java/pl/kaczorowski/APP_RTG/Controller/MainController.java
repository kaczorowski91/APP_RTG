package main.java.pl.kaczorowski.APP_RTG.Controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import main.java.pl.kaczorowski.APP_RTG.Model.Point;
import main.java.pl.kaczorowski.APP_RTG.Service.PointService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainController {

    private final DragController dragController;
    private final PointService pointService;

    public MainController() {
        dragController = new DragController();
        pointService = new PointService();
    }

    @FXML
    private VBox vBox;

    @FXML
    private BorderPane borderPane;

    @FXML
    private GridPane gridPane;

    @FXML
    private void createPointPicture1(MouseEvent event) {
        Point point = pointService.createPointProperty();
        String name = String.valueOf(point.hashCode());
        Label labelName = point.getLabelName();
        labelName.setText("Point name= " + name);
        Label labelX = point.getLabelX();
        TextField textFieldX = point.getTextFieldX();
        Label labelY = point.getLabelY();
        TextField textFieldY = point.getTextFieldY();
        Circle circle1 = point.getCircle1();
        Circle circle2 = point.getCircle2();
        Circle circle3 = point.getCircle3();
        Circle circle4 = point.getCircle4();
        circle1.setCenterX(event.getSceneX());
        circle1.setCenterY(event.getSceneY());

        circle2.setCenterX(circle1.getCenterX() + gridPane.getWidth() / 2);
        circle2.setCenterY(circle1.getCenterY());
        circle3.setCenterX(circle1.getCenterX());
        circle3.setCenterY(circle1.getCenterY() + gridPane.getHeight() / 2);
        circle4.setCenterX(circle1.getCenterX() + gridPane.getWidth() / 2);
        circle4.setCenterY(circle1.getCenterY() + gridPane.getHeight() / 2);

        textFieldX.setText(String.valueOf(circle1.getCenterX()));
        textFieldY.setText(String.valueOf(circle1.getCenterY()));

        List<Circle> circleList = new ArrayList<>(Arrays.asList(circle1, circle2, circle3, circle4));

        circle1.translateXProperty().addListener((observable, oldValue, newValue) -> {
            double tX = Double.parseDouble(textFieldX.textProperty().get());
            double oV = Double.parseDouble(oldValue.toString());
            double nV = Double.parseDouble(newValue.toString());
            double offsetX = tX + nV - oV;
            textFieldX.textProperty().setValue(String.valueOf(offsetX));
            circle2.setTranslateX(newValue.doubleValue());
            circle3.setTranslateX(newValue.doubleValue());
            circle4.setTranslateX(newValue.doubleValue());
        });
        circle1.translateYProperty().addListener((observable, oldValue, newValue) -> {
            double tY = Double.parseDouble(textFieldY.textProperty().get());
            double oV = Double.parseDouble(oldValue.toString());
            double nV = Double.parseDouble(newValue.toString());
            double offsetY = tY + nV - oV;
            textFieldY.textProperty().setValue(String.valueOf(offsetY));
            circle2.setTranslateY(newValue.doubleValue());
            circle3.setTranslateY(newValue.doubleValue());
            circle4.setTranslateY(newValue.doubleValue());
        });
        circle2.translateXProperty().addListener((observable, oldValue, newValue) -> {
            circle1.setTranslateX(newValue.doubleValue());
            circle3.setTranslateX(newValue.doubleValue());
            circle4.setTranslateX(newValue.doubleValue());
        });
        circle2.translateYProperty().addListener((observable, oldValue, newValue) -> {
            circle1.setTranslateY(newValue.doubleValue());
            circle3.setTranslateY(newValue.doubleValue());
            circle4.setTranslateY(newValue.doubleValue());
        });
        circle3.translateXProperty().addListener((observable, oldValue, newValue) -> {
            circle1.setTranslateX(newValue.doubleValue());
            circle2.setTranslateX(newValue.doubleValue());
            circle4.setTranslateX(newValue.doubleValue());
        });
        circle3.translateYProperty().addListener((observable, oldValue, newValue) -> {
            circle1.setTranslateY(newValue.doubleValue());
            circle2.setTranslateY(newValue.doubleValue());
            circle3.setTranslateY(newValue.doubleValue());
        });
        circle4.translateXProperty().addListener((observable, oldValue, newValue) -> {
            circle1.setTranslateX(newValue.doubleValue());
            circle2.setTranslateX(newValue.doubleValue());
            circle3.setTranslateX(newValue.doubleValue());
        });
        circle4.translateYProperty().addListener((observable, oldValue, newValue) -> {
            circle1.setTranslateY(newValue.doubleValue());
            circle2.setTranslateY(newValue.doubleValue());
            circle3.setTranslateY(newValue.doubleValue());
        });

        textFieldX.addEventHandler(MouseEvent.MOUSE_CLICKED, t -> {
            try {
                double value = Double.parseDouble(textFieldX.getText());
                if (value > 400 || value < 0) {
                    AlertBox.display("Error Message", "Incorrect value, should be between 0-400");
                } else {
                    circle1.setCenterX(Double.parseDouble(textFieldX.getText()));
                    circle2.setCenterX(Double.parseDouble(textFieldX.getText()) + gridPane.getWidth() / 2);
                    circle3.setCenterX(Double.parseDouble(textFieldX.getText()));
                    circle4.setCenterX(Double.parseDouble(textFieldX.getText()) + gridPane.getWidth() / 2);
                    for (Circle circle : circleList) {
                        circle.setTranslateX(0);
                    }
                    textFieldX.setText(String.valueOf(value));
                }
            } catch (NumberFormatException e) {
                AlertBox.display("Error Message", "Incorrect text, it should be number between 0-400");
            }

        });
        textFieldY.addEventHandler(MouseEvent.MOUSE_CLICKED, t -> {
            try {
                double value = Double.parseDouble(textFieldY.getText());
                if (value > 400 || value < 0) {
                    AlertBox.display("Error Message", "Incorrect value, should be between 0-400");
                } else {
                    circle1.setCenterY(Double.parseDouble(textFieldY.getText()));
                    circle2.setCenterY(Double.parseDouble(textFieldY.getText()));
                    circle3.setCenterY(Double.parseDouble(textFieldY.getText()) + gridPane.getHeight() / 2);
                    circle4.setCenterY(Double.parseDouble(textFieldY.getText()) + gridPane.getHeight() / 2);
                    for (Circle circle : circleList) {
                        circle.setTranslateY(0);
                    }
                    textFieldY.setText(String.valueOf(value));
                }
            } catch (NumberFormatException e) {
                AlertBox.display("Error Message", "Incorrect text, it should be number between 0-400");
            }
        });

        this.addObjectToBorderPane(circle1, circle2, circle3, circle4, labelName, labelX, textFieldX, labelY, textFieldY);

        for (Circle circle : circleList) {
            circle.setOnMousePressed(dragController.circleOnMousePressedHandler);
            circle.setOnMouseDragged(dragController.circleOnMouseDraggedHandler);
        }

    }

    @FXML
    private void createPointPicture2(MouseEvent event) {
        Point point = pointService.createPointProperty();
        String name = String.valueOf(point.hashCode());
        Label labelName = point.getLabelName();
        labelName.setText("Point name= " + name);
        Label labelX = point.getLabelX();
        TextField textFieldX = point.getTextFieldX();
        Label labelY = point.getLabelY();
        TextField textFieldY = point.getTextFieldY();
        Circle circle1 = point.getCircle1();
        Circle circle2 = point.getCircle2();
        Circle circle3 = point.getCircle3();
        Circle circle4 = point.getCircle4();
        circle2.setCenterX(event.getSceneX());
        circle2.setCenterY(event.getSceneY());

        circle1.setCenterX(circle2.getCenterX() - gridPane.getWidth() / 2);
        circle1.setCenterY(circle2.getCenterY());
        circle3.setCenterX(circle2.getCenterX() - gridPane.getWidth() / 2);
        circle3.setCenterY(circle2.getCenterY() + gridPane.getHeight() / 2);
        circle4.setCenterX(circle2.getCenterX());
        circle4.setCenterY(circle2.getCenterY() + gridPane.getHeight() / 2);

        textFieldX.setText(String.valueOf(circle1.getCenterX()));
        textFieldY.setText(String.valueOf(circle1.getCenterY()));

        List<Circle> circleList = new ArrayList<>(Arrays.asList(circle1, circle2, circle3, circle4));

        circle1.translateXProperty().addListener((observable, oldValue, newValue) -> {
            double tX = Double.parseDouble(textFieldX.textProperty().get());
            double oV = Double.parseDouble(oldValue.toString());
            double nV = Double.parseDouble(newValue.toString());
            double offsetX = tX + nV - oV;
            textFieldX.textProperty().setValue(String.valueOf(offsetX));
            circle2.setTranslateX(newValue.doubleValue());
            circle3.setTranslateX(newValue.doubleValue());
            circle4.setTranslateX(newValue.doubleValue());
        });
        circle1.translateYProperty().addListener((observable, oldValue, newValue) -> {
            double tY = Double.parseDouble(textFieldY.textProperty().get());
            double oV = Double.parseDouble(oldValue.toString());
            double nV = Double.parseDouble(newValue.toString());
            double offsetY = tY + nV - oV;
            textFieldY.textProperty().setValue(String.valueOf(offsetY));
            circle2.setTranslateY(newValue.doubleValue());
            circle3.setTranslateY(newValue.doubleValue());
            circle4.setTranslateY(newValue.doubleValue());
        });
        circle2.translateXProperty().addListener((observable, oldValue, newValue) -> {
            circle1.setTranslateX(newValue.doubleValue());
            circle3.setTranslateX(newValue.doubleValue());
            circle4.setTranslateX(newValue.doubleValue());
        });
        circle2.translateYProperty().addListener((observable, oldValue, newValue) -> {
            circle1.setTranslateY(newValue.doubleValue());
            circle3.setTranslateY(newValue.doubleValue());
            circle4.setTranslateY(newValue.doubleValue());
        });
        circle3.translateXProperty().addListener((observable, oldValue, newValue) -> {
            circle1.setTranslateX(newValue.doubleValue());
            circle2.setTranslateX(newValue.doubleValue());
            circle4.setTranslateX(newValue.doubleValue());
        });
        circle3.translateYProperty().addListener((observable, oldValue, newValue) -> {
            circle1.setTranslateY(newValue.doubleValue());
            circle2.setTranslateY(newValue.doubleValue());
            circle3.setTranslateY(newValue.doubleValue());
        });
        circle4.translateXProperty().addListener((observable, oldValue, newValue) -> {
            circle1.setTranslateX(newValue.doubleValue());
            circle2.setTranslateX(newValue.doubleValue());
            circle3.setTranslateX(newValue.doubleValue());
        });
        circle4.translateYProperty().addListener((observable, oldValue, newValue) -> {
            circle1.setTranslateY(newValue.doubleValue());
            circle2.setTranslateY(newValue.doubleValue());
            circle3.setTranslateY(newValue.doubleValue());
        });

        textFieldX.addEventHandler(MouseEvent.MOUSE_CLICKED, t -> {
            try {
                double value = Double.parseDouble(textFieldX.getText());
                if (value > 400 || value < 0) {
                    AlertBox.display("Error Message", "Incorrect value, should be between 0-400");
                } else {
                    circle1.setCenterX(Double.parseDouble(textFieldX.getText()));
                    circle2.setCenterX(Double.parseDouble(textFieldX.getText()) + gridPane.getWidth() / 2);
                    circle3.setCenterX(Double.parseDouble(textFieldX.getText()));
                    circle4.setCenterX(Double.parseDouble(textFieldX.getText()) + gridPane.getWidth() / 2);
                    for (Circle circle : circleList) {
                        circle.setTranslateX(0);
                    }
                }
            } catch (NumberFormatException e) {
                AlertBox.display("Error Message", "Incorrect text, it should be number between 0-400");
            }

        });
        textFieldY.addEventHandler(MouseEvent.MOUSE_CLICKED, t -> {
            try {
                double value = Double.parseDouble(textFieldY.getText());
                if (value > 400 || value < 0) {
                    AlertBox.display("Error Message", "Incorrect value, should be between 0-400");
                } else {
                    circle1.setCenterY(Double.parseDouble(textFieldY.getText()));
                    circle2.setCenterY(Double.parseDouble(textFieldY.getText()));
                    circle3.setCenterY(Double.parseDouble(textFieldY.getText()) + gridPane.getHeight() / 2);
                    circle4.setCenterY(Double.parseDouble(textFieldY.getText()) + gridPane.getHeight() / 2);
                    for (Circle circle : circleList) {
                        circle.setTranslateY(0);
                    }
                }
            } catch (NumberFormatException e) {
                AlertBox.display("Error Message", "Incorrect text, it should be number between 0-400");
            }
        });

        this.addObjectToBorderPane(circle1, circle2, circle3, circle4, labelName, labelX, textFieldX, labelY, textFieldY);

        for (Circle circle : circleList) {
            circle.setOnMousePressed(dragController.circleOnMousePressedHandler);
            circle.setOnMouseDragged(dragController.circleOnMouseDraggedHandler);
        }

    }

    @FXML
    private void createPointPicture3(MouseEvent event) {
        Point point = pointService.createPointProperty();
        String name = String.valueOf(point.hashCode());
        Label labelName = point.getLabelName();
        labelName.setText("Point name= " + name);
        Label labelX = point.getLabelX();
        TextField textFieldX = point.getTextFieldX();
        Label labelY = point.getLabelY();
        TextField textFieldY = point.getTextFieldY();
        Circle circle1 = point.getCircle1();
        Circle circle2 = point.getCircle2();
        Circle circle3 = point.getCircle3();
        Circle circle4 = point.getCircle4();
        circle3.setCenterX(event.getSceneX());
        circle3.setCenterY(event.getSceneY());

        circle1.setCenterX(circle3.getCenterX());
        circle1.setCenterY(circle3.getCenterY() - gridPane.getHeight() / 2);
        circle2.setCenterX(circle3.getCenterX() + gridPane.getWidth() / 2);
        circle2.setCenterY(circle3.getCenterY() - gridPane.getHeight() / 2);
        circle4.setCenterX(circle3.getCenterX() + gridPane.getWidth() / 2);
        circle4.setCenterY(circle3.getCenterY());

        textFieldX.setText(String.valueOf(circle1.getCenterX()));
        textFieldY.setText(String.valueOf(circle1.getCenterY()));

        List<Circle> circleList = new ArrayList<>(Arrays.asList(circle1, circle2, circle3, circle4));

        circle1.translateXProperty().addListener((observable, oldValue, newValue) -> {
            double tX = Double.parseDouble(textFieldX.textProperty().get());
            double oV = Double.parseDouble(oldValue.toString());
            double nV = Double.parseDouble(newValue.toString());
            double offsetX = tX + nV - oV;
            textFieldX.textProperty().setValue(String.valueOf(offsetX));
            circle2.setTranslateX(newValue.doubleValue());
            circle3.setTranslateX(newValue.doubleValue());
            circle4.setTranslateX(newValue.doubleValue());
        });
        circle1.translateYProperty().addListener((observable, oldValue, newValue) -> {
            double tY = Double.parseDouble(textFieldY.textProperty().get());
            double oV = Double.parseDouble(oldValue.toString());
            double nV = Double.parseDouble(newValue.toString());
            double offsetY = tY + nV - oV;
            textFieldY.textProperty().setValue(String.valueOf(offsetY));
            circle2.setTranslateY(newValue.doubleValue());
            circle3.setTranslateY(newValue.doubleValue());
            circle4.setTranslateY(newValue.doubleValue());
        });
        circle2.translateXProperty().addListener((observable, oldValue, newValue) -> {
            circle1.setTranslateX(newValue.doubleValue());
            circle3.setTranslateX(newValue.doubleValue());
            circle4.setTranslateX(newValue.doubleValue());
        });
        circle2.translateYProperty().addListener((observable, oldValue, newValue) -> {
            circle1.setTranslateY(newValue.doubleValue());
            circle3.setTranslateY(newValue.doubleValue());
            circle4.setTranslateY(newValue.doubleValue());
        });
        circle3.translateXProperty().addListener((observable, oldValue, newValue) -> {
            circle1.setTranslateX(newValue.doubleValue());
            circle2.setTranslateX(newValue.doubleValue());
            circle4.setTranslateX(newValue.doubleValue());
        });
        circle3.translateYProperty().addListener((observable, oldValue, newValue) -> {
            circle1.setTranslateY(newValue.doubleValue());
            circle2.setTranslateY(newValue.doubleValue());
            circle3.setTranslateY(newValue.doubleValue());
        });
        circle4.translateXProperty().addListener((observable, oldValue, newValue) -> {
            circle1.setTranslateX(newValue.doubleValue());
            circle2.setTranslateX(newValue.doubleValue());
            circle3.setTranslateX(newValue.doubleValue());
        });
        circle4.translateYProperty().addListener((observable, oldValue, newValue) -> {
            circle1.setTranslateY(newValue.doubleValue());
            circle2.setTranslateY(newValue.doubleValue());
            circle3.setTranslateY(newValue.doubleValue());
        });

        textFieldX.addEventHandler(MouseEvent.MOUSE_CLICKED, t -> {
            try {
                double value = Double.parseDouble(textFieldX.getText());
                if (value > 400 || value < 0) {
                    AlertBox.display("Error Message", "Incorrect value, should be between 0-400");
                } else {
                    circle1.setCenterX(Double.parseDouble(textFieldX.getText()));
                    circle2.setCenterX(Double.parseDouble(textFieldX.getText()) + gridPane.getWidth() / 2);
                    circle3.setCenterX(Double.parseDouble(textFieldX.getText()));
                    circle4.setCenterX(Double.parseDouble(textFieldX.getText()) + gridPane.getWidth() / 2);
                    for (Circle circle : circleList) {
                        circle.setTranslateX(0);
                    }
                }
            } catch (NumberFormatException e) {
                AlertBox.display("Error Message", "Incorrect text, it should be number between 0-400");
            }

        });
        textFieldY.addEventHandler(MouseEvent.MOUSE_CLICKED, t -> {
            try {
                double value = Double.parseDouble(textFieldY.getText());
                if (value > 400 || value < 0) {
                    AlertBox.display("Error Message", "Incorrect value, should be between 0-400");
                } else {
                    circle1.setCenterY(Double.parseDouble(textFieldY.getText()));
                    circle2.setCenterY(Double.parseDouble(textFieldY.getText()));
                    circle3.setCenterY(Double.parseDouble(textFieldY.getText()) + gridPane.getHeight() / 2);
                    circle4.setCenterY(Double.parseDouble(textFieldY.getText()) + gridPane.getHeight() / 2);
                    for (Circle circle : circleList) {
                        circle.setTranslateY(0);
                    }
                }
            } catch (NumberFormatException e) {
                AlertBox.display("Error Message", "Incorrect text, it should be number between 0-400");
            }
        });

        this.addObjectToBorderPane(circle1, circle2, circle3, circle4, labelName, labelX, textFieldX, labelY, textFieldY);

        for (Circle circle : circleList) {
            circle.setOnMousePressed(dragController.circleOnMousePressedHandler);
            circle.setOnMouseDragged(dragController.circleOnMouseDraggedHandler);
        }

    }

    @FXML
    private void createPointPicture4(MouseEvent event) {
        Point point = pointService.createPointProperty();
        String name = String.valueOf(point.hashCode());
        Label labelName = point.getLabelName();
        labelName.setText("Point name= " + name);
        Label labelX = point.getLabelX();
        TextField textFieldX = point.getTextFieldX();
        Label labelY = point.getLabelY();
        TextField textFieldY = point.getTextFieldY();
        Circle circle1 = point.getCircle1();
        Circle circle2 = point.getCircle2();
        Circle circle3 = point.getCircle3();
        Circle circle4 = point.getCircle4();
        circle4.setCenterX(event.getSceneX());
        circle4.setCenterY(event.getSceneY());

        circle1.setCenterX(circle4.getCenterX() - gridPane.getWidth() / 2);
        circle1.setCenterY(circle4.getCenterY() - gridPane.getHeight() / 2);
        circle2.setCenterX(circle4.getCenterX());
        circle2.setCenterY(circle4.getCenterY() - gridPane.getHeight() / 2);
        circle3.setCenterX(circle4.getCenterX() - gridPane.getWidth() / 2);
        circle3.setCenterY(circle4.getCenterY());

        textFieldX.setText(String.valueOf(circle1.getCenterX()));
        textFieldY.setText(String.valueOf(circle1.getCenterY()));

        List<Circle> circleList = new ArrayList<>(Arrays.asList(circle1, circle2, circle3, circle4));

        circle1.translateXProperty().addListener((observable, oldValue, newValue) -> {
            double tX = Double.parseDouble(textFieldX.textProperty().get());
            double oV = Double.parseDouble(oldValue.toString());
            double nV = Double.parseDouble(newValue.toString());
            double offsetX = tX + nV - oV;
            textFieldX.textProperty().setValue(String.valueOf(offsetX));
            circle2.setTranslateX(newValue.doubleValue());
            circle3.setTranslateX(newValue.doubleValue());
            circle4.setTranslateX(newValue.doubleValue());
        });
        circle1.translateYProperty().addListener((observable, oldValue, newValue) -> {
            double tY = Double.parseDouble(textFieldY.textProperty().get());
            double oV = Double.parseDouble(oldValue.toString());
            double nV = Double.parseDouble(newValue.toString());
            double offsetY = tY + nV - oV;
            textFieldY.textProperty().setValue(String.valueOf(offsetY));
            circle2.setTranslateY(newValue.doubleValue());
            circle3.setTranslateY(newValue.doubleValue());
            circle4.setTranslateY(newValue.doubleValue());
        });
        circle2.translateXProperty().addListener((observable, oldValue, newValue) -> {
            circle1.setTranslateX(newValue.doubleValue());
            circle3.setTranslateX(newValue.doubleValue());
            circle4.setTranslateX(newValue.doubleValue());
        });
        circle2.translateYProperty().addListener((observable, oldValue, newValue) -> {
            circle1.setTranslateY(newValue.doubleValue());
            circle3.setTranslateY(newValue.doubleValue());
            circle4.setTranslateY(newValue.doubleValue());
        });
        circle3.translateXProperty().addListener((observable, oldValue, newValue) -> {
            circle1.setTranslateX(newValue.doubleValue());
            circle2.setTranslateX(newValue.doubleValue());
            circle4.setTranslateX(newValue.doubleValue());
        });
        circle3.translateYProperty().addListener((observable, oldValue, newValue) -> {
            circle1.setTranslateY(newValue.doubleValue());
            circle2.setTranslateY(newValue.doubleValue());
            circle3.setTranslateY(newValue.doubleValue());
        });
        circle4.translateXProperty().addListener((observable, oldValue, newValue) -> {
            circle1.setTranslateX(newValue.doubleValue());
            circle2.setTranslateX(newValue.doubleValue());
            circle3.setTranslateX(newValue.doubleValue());
        });
        circle4.translateYProperty().addListener((observable, oldValue, newValue) -> {
            circle1.setTranslateY(newValue.doubleValue());
            circle2.setTranslateY(newValue.doubleValue());
            circle3.setTranslateY(newValue.doubleValue());
        });

        textFieldX.addEventHandler(MouseEvent.MOUSE_CLICKED, t -> {
            try {
                double value = Double.parseDouble(textFieldX.getText());
                if (value > 400 || value < 0) {
                    AlertBox.display("Error Message", "Incorrect value, should be between 0-400");
                } else {
                    circle1.setCenterX(Double.parseDouble(textFieldX.getText()));
                    circle2.setCenterX(Double.parseDouble(textFieldX.getText()) + gridPane.getWidth() / 2);
                    circle3.setCenterX(Double.parseDouble(textFieldX.getText()));
                    circle4.setCenterX(Double.parseDouble(textFieldX.getText()) + gridPane.getWidth() / 2);
                    for (Circle circle : circleList) {
                        circle.setTranslateX(0);
                    }
                }
            } catch (NumberFormatException e) {
                AlertBox.display("Error Message", "Incorrect text, it should be number between 0-400");
            }

        });
        textFieldY.addEventHandler(MouseEvent.MOUSE_CLICKED, t -> {
            try {
                double value = Double.parseDouble(textFieldY.getText());
                if (value > 400 || value < 0) {
                    AlertBox.display("Error Message", "Incorrect value, should be between 0-400");
                } else {
                    circle1.setCenterY(Double.parseDouble(textFieldY.getText()));
                    circle2.setCenterY(Double.parseDouble(textFieldY.getText()));
                    circle3.setCenterY(Double.parseDouble(textFieldY.getText()) + gridPane.getHeight() / 2);
                    circle4.setCenterY(Double.parseDouble(textFieldY.getText()) + gridPane.getHeight() / 2);
                    for (Circle circle : circleList) {
                        circle.setTranslateY(0);
                    }
                }
            } catch (NumberFormatException e) {
                AlertBox.display("Error Message", "Incorrect text, it should be number between 0-400");
            }
        });

        this.addObjectToBorderPane(circle1, circle2, circle3, circle4, labelName, labelX, textFieldX, labelY, textFieldY);

        for (Circle circle : circleList) {
            circle.setOnMousePressed(dragController.circleOnMousePressedHandler);
            circle.setOnMouseDragged(dragController.circleOnMouseDraggedHandler);
        }

    }

    private void addObjectToBorderPane(Circle circle1, Circle circle2, Circle circle3, Circle circle4, Label labelName, Label labelX, TextField textFieldX,
                                       Label labelY, TextField textFieldY) {
        borderPane.getChildren().add(circle1);
        borderPane.getChildren().add(circle2);
        borderPane.getChildren().add(circle3);
        borderPane.getChildren().add(circle4);
        vBox.getChildren().add(labelName);
        vBox.getChildren().add(labelX);
        vBox.getChildren().add(textFieldX);
        vBox.getChildren().add(labelY);
        vBox.getChildren().add(textFieldY);
    }
}