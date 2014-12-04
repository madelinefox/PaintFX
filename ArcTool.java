
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

public class ArcTool implements Tool {
        private double xcoordA, xcoordB, ycoordA, ycoordB;

        /**
         *
         * @param e The mouseevent that fired this onPress.
         * @param g The current graphics context.
         */
        public void onPress(MouseEvent e, GraphicsContext g) {
            xcoordA = e.getX();
            ycoordA = e.getY();

        }

        /**
         *
         * @param e The mouseevent that fired this onDrag.
         * @param g The current graphics context.
         */
        public void onDrag(MouseEvent e, GraphicsContext g) {
            xcoordB = e.getX();
            ycoordB = e.getY();
        }

        /**
         *
         * @param e The mouseevent that fired this onRelease.
         * @param g The current graphics context.
         */
        public void onRelease(MouseEvent e, GraphicsContext g) {
            g.arcTo((double) Math.min(xcoordA, xcoordB),
                    Math.min(ycoordA, ycoordB),
                    Math.abs(xcoordB - xcoordA),
                    Math.abs(ycoordB - ycoordA),
                    Math.sqrt(
                            (Math.abs(xcoordB - xcoordA) * Math.abs
                                    (xcoordB -
                                            xcoordA))
                                    + (Math.abs(ycoordB - ycoordA) * Math
                                    .abs
                                            (ycoordB - ycoordA))));
            Arc arc = new Arc();
        }

        /**
         *
         * @return name
         */
        public String getName() {
            return "Arc Tool";
        }
    }