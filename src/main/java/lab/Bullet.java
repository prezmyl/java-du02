package lab;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Bullet extends GameObject {
    private static final double WIDTH = 5;
    private static final double HEIGHT = 10;

    public Bullet(double x, double y) {
        super(x, y);
        this.speedY = 3; // Rychlost pohybu střely
    }

    @Override
    public void move() {
        this.y -= speedY; // Střela se pohybuje nahoru
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.fillRect(x, y, WIDTH, HEIGHT); // Vykreslení střely
    }
}