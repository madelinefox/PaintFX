
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.util.*;
import java.util.concurrent.ExecutionException;

public class Main extends Application{
    private static Slider redSlide;
    private static Slider greenSlide;
    private static Slider blueSlide;
    private static Slider oSlide;
    private static Button colorChange;
    private static Button pencilButton;
    private static Button rectangleButton;
    private static Button ovalButton;
    private static Button emptyScreen;
    public static Canvas canoshapes;
    public static Color currentColor;
    public static Stack shapes = new Stack<Shape>();
    public static Tool currentTool;



        /**
         *
         * @param primaryStage
         * @throws Exception
         */
        public void start(Stage primaryStage) throws Exception {



            BorderPane bPane = new BorderPane();


            canoshapes = new Canvas(1000, 1000);
            bPane.setCenter(canoshapes);
            redSlide = new Slider();
            greenSlide = new Slider();
            blueSlide = new Slider();
            oSlide = new Slider();
            colorChange = new Button("Change Color");
            
            redSlide.setMin(0.0);
            redSlide.setMax(1.0);
            redSlide.setShowTickMarks(true);

            blueSlide.setMin(0.0);
            blueSlide.setMax(1.0);
            blueSlide.setShowTickMarks(true);

            greenSlide.setMin(0.0);
            greenSlide.setMax(1.0);
            greenSlide.setShowTickMarks(true);

            oSlide.setMin(0.0);
            oSlide.setMax(1.0);
            oSlide.setShowTickMarks(true);

            redSlide.setValue(0.5);
            blueSlide.setValue(0.5);
            greenSlide.setValue(0.5);
            oSlide.setValue(0.5);

            colorChange.setOnAction(e -> {currentColor = new Color
                (redSlide.getValue(),
                        greenSlide.getValue(),
                        blueSlide.getValue(), oSlide.getValue());return;});
            VBox sliders = new VBox(5);
            sliders.getChildren().addAll(redSlide, greenSlide, blueSlide, 
                oSlide, colorChange);
            bPane.setLeft(sliders);


            ovalButton = new Button ("Oval Tool");
            ovalButton.setOnAction(e -> currentTool = new OvalTool());

            rectangleButton = new Button("Rectangle Button");
            rectangleButton.setOnAction(e -> currentTool = new RectangleTool());

            pencilButton = new Button("Pencil Tool");
            pencilButton.setOnAction(e -> currentTool = new Pencil());

            emptyScreen = new Button("Empty Screen");
            emptyScreen.setOnAction(e -> {canoshapes.getGraphicsContext2D
                ().setFill(Color.WHITE); canoshapes.getGraphicsContext2D
                ().fillRect(0.0, 0.0, canoshapes.getWidth(), 
                    canoshapes.getHeight());});

            HBox toolBox = new HBox(4);
            toolBox.getChildren().addAll(ovalButton, rectangleButton, 
                pencilButton, emptyScreen);

            bPane.setTop(toolBox);
            canoshapes.setOnMousePressed(e -> currentTool.onPress(e, 
                canoshapes.getGraphicsContext2D()));
            canoshapes.setOnMouseDragged(e -> currentTool.onDrag(e, 
                canoshapes.getGraphicsContext2D()));
            canoshapes.setOnMouseReleased(e -> currentTool.onRelease(e, 
                canoshapes.getGraphicsContext2D()));
            Scene setscene = new Scene(bPane);
            primaryStage.setScene(setscene);
            primaryStage.show();


        }

        /**
         *
         * @param args
         */
        public static void main(String[] args) {
            try {
                launch(args);
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    

    

    

    
