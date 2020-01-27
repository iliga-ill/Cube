import javax.swing.*;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Observable;
import java.util.Observer;

public class Scroll extends JScrollBar implements Observer {

    private Axes O;
    private Panel P;
    public static int ButtonN=0,i;
    private int k;

    public Scroll(Axes O , Panel P){
        ScrollListener listener = new ScrollListener();
        this.addAdjustmentListener( listener);
        this.O = O;
        this.P = P;
        ButtonN++;
        k = ButtonN;
        setValue(0);
        setMinimum(-1);
        setMaximum(49);
    }

    @Override
    public void update(Observable o, Object arg) {
        O = (Axes) o;
    }
    int temp = 0;
    static int fooX = 0, fooY = 0;
    private class ScrollListener implements AdjustmentListener {
        public void adjustmentValueChanged(AdjustmentEvent e){
            if ( temp <= getValue()){
                temp++;
                System.out.println(getValue());
                if (k == 1){ O.rotateAxe(10,0,0);
                    fooY = temp*10;
                }
                else if (k == 2){ O.rotateAxe(0,10,0);
                    fooX = temp*10;
                }
                P.repaint();
            }
            else {
                temp--;
                if (k == 1){ O.rotateAxe(-10,0,0);
                    fooY = temp*10;
                }
                else if (k == 2){ O.rotateAxe(0,-10,0);
                    fooX = temp*10;
                }
                P.repaint();
            }
        }
    }
}