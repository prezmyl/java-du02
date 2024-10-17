package lab;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Player extends GameObject {

    private static final double WIDTH = 40;
    private static final double HEIGHT = 20;

    public Player(double x, double y) {
        super(x, y);
        this.speedX = 1;
    }

    @Override
    public void move(){
        if (x + speedX < 800 - WIDTH && x + speedX > 0) {
            x += speedX;
        }
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        gc.fillRect(x, y, WIDTH, HEIGHT);
    }
}
