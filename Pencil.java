
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

public class Pencil implements Tool {
        private Stack<double[]> pixels;

        /**
         *
         * @param e The mouseevent that fired this onPress.
         * @param g The current graphics context.
         */
        public void onPress(MouseEvent e, GraphicsContext g) {
            pixels = new Stack<double[]>();
            g.getPixelWriter().setColor((int) e.getX(), (int) e.getY(),
                    Main.currentColor);
       /* double[] temp = {e.getSceneX(), e.getSceneY()};
        pixels.add(temp);
        boolean bb = true;
        temp = pixels.pop();
        while (bb) {
            g.getPixelWriter().setColor((int) temp[0], (int) temp[1],
            Controller.currentColor);
            temp = pixels.pop();
            bb = pixels.empty();
        }*/
        }

        /**
         *
         * @param e The mouseevent that fired this onDrag.
         * @param g The current graphics context.
         */
        public void onDrag(MouseEvent e, GraphicsContext g) {
            g.getPixelWriter().setColor((int) e.getX(), (int) e.getY(),
                    Main.currentColor);
            //double[] temp = {e.getSceneX(), e.getSceneY()};
        /*pixels.add(temp);
        boolean bb = true;
        temp = pixels.pop();
        while (bb) {
            g.getPixelWriter().setColor((int) temp[0], (int) temp[1],
            Controller.currentColor);
            temp = pixels.pop();
            bb = pixels.empty();
        }*/
        }

        /**
         *
         * @param e The mouseevent that fired this onRelease.
         * @param g The current graphics context.
         */
        public void onRelease(MouseEvent e, GraphicsContext g) {
            g.getPixelWriter().setColor((int) e.getX(), (int) e.getY(),
                    Main.currentColor);
        /*double[] temp = {e.getSceneX(), e.getSceneY()};
        System.out.print(Controller.currentColor);
        pixels.add(temp);
        boolean bb = true;
        temp = pixels.pop();
        while (bb) {
            g.getPixelWriter().setColor((int) temp[0], (int) temp[1],
            Controller.currentColor);
            temp = pixels.pop();
            bb = pixels.empty();
        }*/


        }

        /**
         *
         * @return name
         */
        public String getName() {
            return "Pencil";
        }
    }