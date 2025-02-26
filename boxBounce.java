import java.awt.*;
import java.util.ArrayList;

/**
 * Write a description of class boxBounce here.
 *
 * @author (Arif reyhan)
 * @version (2/26/2025)
 */
public class boxBounce
{
    private Canvas myCanvas;
    private ArrayList<BoxBall> balls;
    private final int boxX = 50, boxY = 50, boxWidth = 400, boxHeight = 300;


 public boxBounce()
     {
        myCanvas = new Canvas("Box Bounce", 500, 400);
        balls = new ArrayList<>();
     }


 public void boxBounce(int numBalls) {
        myCanvas.setVisible(true);

        // Draw the box
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(boxX, boxY, boxX + boxWidth, boxY); // Top
        myCanvas.drawLine(boxX, boxY + boxHeight, boxX + boxWidth, boxY + boxHeight); // Bottom
        myCanvas.drawLine(boxX, boxY, boxX, boxY + boxHeight); // Left
        myCanvas.drawLine(boxX + boxWidth, boxY, boxX + boxWidth, boxY + boxHeight); // Right

        // Create balls inside the box
        for (int i = 0; i < numBalls; i++) {
            balls.add(new BoxBall(boxX, boxY, boxWidth, boxHeight, myCanvas));
        }

        // Animate the balls
        while (true) {
            myCanvas.wait(20); // Small delay
            for (BoxBall ball : balls) {
                ball.move();
            }
        }
    }

    public static void main(String[] args) {
        boxBounce demo = new boxBounce();
        demo.boxBounce(5); // Run the simulation with 5 balls
    }
}


