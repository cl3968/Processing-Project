package processingproject;

public class Bullet {
	int x, y;

    Bullet(int xpos, int ypos) {
        x = xpos + gridsize/2 - 4;
        y = ypos;
    }

    void draw() {
        rect(x, y, pixelsize, pixelsize);
        y -= pixelsize;
    }
}
