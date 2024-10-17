package lab;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import java.util.ArrayList;
import java.util.Iterator;

public class DrawingThread extends AnimationTimer {
	private final GraphicsContext gc;
	private final ArrayList<GameObject> gameObjects = new ArrayList<>();
	private final Player player;
	private long lastBulletTime = 0; // Čas poslední střelby (v nanosekundách)
	private static final long BULLET_INTERVAL = 1000000000;

	public DrawingThread(Canvas canvas) {
		this.gc = canvas.getGraphicsContext2D();
		this.player = new Player(100, 350); // Vytvoření hráče
		gameObjects.add(player);
		gameObjects.add(new Enemy(100, 50)); // Přidání nepřítele
			}

	@Override
	public void handle(long now) {
		gc.clearRect(0, 0, 800, 400); // Vymazání obrazovky
		if (now - lastBulletTime > BULLET_INTERVAL) {
			System.out.println("Střela přidána na pozici: " + player.x + ", " + player.y);
			addBullet(player.x + 20, player.y - 10); // Přidání střely nad hráčem
			lastBulletTime = now; // Aktualizace času poslední střelby
		}
		// Aktualizace a vykreslení herních objektů
		Iterator<GameObject> iterator = gameObjects.iterator();
		while (iterator.hasNext()) {
			GameObject obj = iterator.next();
			obj.move(); // Pohyb objektu
			obj.draw(gc); // Vykreslení objektu

			// Kontrola, zda objekt není mimo obrazovku
			if (obj instanceof Bullet && obj.y < 0) {
				iterator.remove(); // Odstranění střel mimo obrazovku
			}
		}
	}

	// Přidání nové střely do hry (například při střelbě hráče)
	public void addBullet(double x, double y) {
		gameObjects.add(new Bullet(x, y));
	}
}
