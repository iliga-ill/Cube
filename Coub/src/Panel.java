import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel{

    private String str = "0";
    private Axes O;
    private cube c;


    public Panel(Axes axes,int width, int height){
        this.setSize(width,height);
        this.O = axes;
    }
int a=0;
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.clearRect(0, 0, 2000, 2000);
        g2d.translate(this.getWidth() / 2, this.getHeight() / 2);
        //g2d.drawLine(-this.getWidth() / 2, 0, this.getWidth() / 2, 0);
        //g2d.drawLine(0, getHeight() / 2, 0, -this.getHeight() / 2);

        O.drawX(g2d);
        O.drawY(g2d);
        O.drawZ(g2d);

        //CubeN = new Integer[O.n];

        if (Button.i == 1) {
            for (int i = 0; i < O.CubeN.length; i++) {
                this.c = O.CubeN[i];
                c.draw(g2d, O);
                a=0;
            }
        } else if (Button.i == 2) {
            for (int i = 0; i < O.CubeN.length; i++) {
                this.c = O.CubeN[i];
                if (a==0){
                c.Perspektiva(1000);
                a++;
                }
                c.draw(g2d, O);
            }
        }
    }
}