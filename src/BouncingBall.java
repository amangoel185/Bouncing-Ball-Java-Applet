
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author aman_goel9
 */
class Ball {

    int x, y, radius, dx, dy;
    Color BallColor;

    public Ball(int x, int y, int radius, int dx, int dy, Color ballColor) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.dx = dx;
        this.dy = dy;
        BallColor = ballColor;
    }
}

public class BouncingBall extends Applet implements Runnable {

    Ball pinkBall, blackBallLine;

    public void init() {
        pinkBall = new Ball(40, 70, 30, 5, 5, Color.pink);
        blackBallLine = new Ball(40, 70, 30, 5, 5, Color.black);
        Thread t = new Thread(this);
        t.start();
    }

    public void paint(Graphics g) {
        g.setColor(pinkBall.BallColor);
        g.fillOval(pinkBall.x, pinkBall.y, pinkBall.radius, pinkBall.radius);
        g.setColor(blackBallLine.BallColor);
        g.drawOval(blackBallLine.x, blackBallLine.y, blackBallLine.radius, blackBallLine.radius);
    }

    public void run() {
        while (true) {
            try {
                displacementOperation(pinkBall);
                displacementOperation(blackBallLine);
                Thread.sleep(45);
                repaint();
            } catch (Exception e) {
            }
        }
    }

    public void displacementOperation(Ball ball) {
        if (ball.y >= 150 || ball.y <= 0) {
            ball.dy = -ball.dy;
        }

        if (ball.x >= 150 || ball.x <= 0) {
            ball.dx = -ball.dx;
        }

        ball.y = ball.y - ball.dy;
        ball.x = ball.x - ball.dx;
    }
}
