package lab;


import javafx.scene.canvas.GraphicsContext;

public abstract class GameObject {
    protected double x, y;
    protected double speedX, speedY;

    public GameObject(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public abstract void draw(GraphicsContext gc);
    public abstract void move();
}
