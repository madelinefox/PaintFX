

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
public class Controller {
        private class ShapeSet<E> implements Set<E> {
            private ArrayList<E> backing;

            /**
             *
             * @return size of array
             */
            @Override
            public int size() {
                return backing.size();
            }

            /**
             *
             * @return emptyness
             */
            @Override
            public boolean isEmpty() {
                return backing.isEmpty();
            }

            /**
             *
             * @param o
             * @return if contains
             */
            @Override
            public boolean contains(Object o) {
                return backing.contains(o);
            }

            /**
             *
             * @return iterator
             */
            @Override
            public Iterator<E> iterator() {
                return backing.iterator();
            }

            /**
             *
             * @return Object array
             */
            @Override
            public Object[] toArray() {
                return backing.toArray();
            }

            /**
             *
             * @param a
             * @param <T>
             * @return Generic array
             */
            @Override
            public <T> T[] toArray(T[] a) {
                return backing.toArray(a);
            }

            /**
             *
             * @param e
             * @return happened
             */
            @Override
            public boolean add(E e) {

                return backing.add(e);
            }

            /**
             *
             * @param o
             * @return sucess
             */
            @Override
            public boolean remove(Object o) {
                return backing.remove(o);
            }

            /**
             *
             * @param c
             * @return if contained
             */
            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            /**
             *
             * @param c
             * @return sucess
             */
            @Override
            public boolean addAll(Collection<? extends E> c) {
                return false;
            }

            /**
             *
             * @param c
             * @return sucess
             */
            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            /**
             *
             * @param c
             * @return sucess
             */
            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            /**
             * clears the backing array
             */
            @Override
            public void clear() {
                backing.clear();
            }

            /**
             *
             * @param o
             * @return equality
             */
            @Override
            public boolean equals(Object o) {
                return false;
            }

            /**
             *  @return hashcode
             */
            @Override
            public int hashCode() {
                return 0;
            }

        }

        /**
         *
         * @param e
         */
        public void mousePress(MouseEvent e) {

            Main.currentTool.onPress(e, Main.canoshapes.getGraphicsContext2D());

        }

        /**
         *
         * @param e
         */
        public void mouseDrag(MouseEvent e) {
            Main.currentTool.onDrag(e, Main.canoshapes.getGraphicsContext2D());
        }

        /**
         *
         * @param e
         */
        public void mouseRelease(MouseEvent e) {
            Main.currentTool.onRelease(e, 
                Main.canoshapes.getGraphicsContext2D());
        }
    }