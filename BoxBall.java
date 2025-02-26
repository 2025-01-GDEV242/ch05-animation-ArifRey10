import java.awt.*;
import java.util.Random;
/**
 * Write a description of class BoxBall here.
 *
 * @author (Arif Reyhan)
 * @version (2/26/2025)
 */
public class BoxBall
{
    private int x, y, dx, dy, diameter;
    private final Color color;
    private final int boxX, boxY, boxWidth, boxHeight;
    private Canvas canvas; 
    
     public BoxBall(int boxX, int boxY, int boxWidth, int boxHeight, 
     Canvas canvas)
     {
        Random rand = new Random();
        this.diameter = 15;
        this.x = rand.nextInt(boxWidth - diameter) + boxX;
        this.y = rand.nextInt(boxHeight - diameter) + boxY;
        this.dx = rand.nextInt(5) + 1;
        this.dy = rand.nextInt(5) + 1;
        this.color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        this.boxX = boxX;
        this.boxY = boxY;
        this.boxWidth = boxWidth;
        this.boxHeight = boxHeight;
        this.canvas = canvas;
}
      public void move() {
        canvas.eraseCircle(x, y, diameter);
       
        if (x + dx < boxX || x + dx + diameter > boxX + boxWidth) {
            dx = -dx;
        }
        if (y + dy < boxY || y + dy + diameter > boxY + boxHeight) {
            dy = -dy;
        }
       
        x += dx;
        y += dy;

       
        draw();
}
      public void draw() {
        canvas.setForegroundColor(color);
        canvas.fillCircle(x, y, diameter);
}
}
