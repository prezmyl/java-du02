package lab;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Enemy extends GameObject {
    private static final double WIDTH = 30;
    private static final double HEIGHT = 20;

    public Enemy(double x, double y) {
        super(x, y);
        this.speedY = 2; // Rychlost pohybu nepřítele
    }

    @Override
    public void move() {
        this.y += speedY; // Nepřítel se pohybuje směrem dolů
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.RED);
        gc.fillRect(x, y, WIDTH, HEIGHT); // Vykreslení nepřítele
    }
}