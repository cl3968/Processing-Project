package processingproject;

import processing.core.PApplet;

public class SpaceInvaders extends PApplet{
	int pixelsize = 4;
	int gridsize  = pixelsize * 7 + 5;
	Player player;
	ArrayList enemies = new ArrayList();
	ArrayList bullets = new ArrayList();
	int direction = 1;
	boolean incy = false;
	
	public static void main(String[] args) {
		PApplet.main("processing.netID");
		}

	void setup() {
	    background(0);
	    noStroke();
	    fill(255);
	    size(500, 400);
	    player = new Player();
	    createEnemies();
	}

	void draw() {
	    background(0);

	    player.draw();

	    for (int i = 0; i < bullets.size(); i++) {
	        Bullet bullet = (Bullet) bullets.get(i);
	        bullet.draw();
	    }

	    for (int i = 0; i < enemies.size(); i++) {
	        Enemy enemy = (Enemy) enemies.get(i);
	        if (enemy.outside() == true) {
	            direction *= (-1);
	            incy = true;
	            break;
	        }
	    }

	    for (int i = 0; i < enemies.size(); i++) {
	        Enemy enemy = (Enemy) enemies.get(i);
	        if (!enemy.alive()) {
	            enemies.remove(i);
	        } 
	        else {
	            enemy.draw();
	        }
	    }

	    incy = false;
	}

	void createEnemies() {
	    for (int i = 0; i < width/gridsize/2; i++) {
	        for (int j = 0; j <= 5; j++) {
	            enemies.add(new Enemy(i*gridsize, j*gridsize));
	        }
	    }
	}

}
