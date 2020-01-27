import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseDragEvent;

import java.awt.dnd.MouseDragGestureRecognizer;
import java.awt.event.MouseListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.xml.bind.Marshaller;
import javafx.scene.input.MouseDragEvent;

public class Viewer extends JFrame {

    private String str = "0";
    private Axes O;
    private cube c;
    private Integer[] CubeN;
    public int height,width;

    public Viewer(Axes O,int width1 ,int height1) {
        this.height = height1;
        this.width  = width1;
        this.setBounds(15,15,width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.O = O;

        //Container pane = this.getContentPane();
        //pane.setLayout(new GridLayout(12, 12));
        Panel panel= new Panel(O,width, height);
        JPanel panel2 = new JPanel();
        Button button1 = new Button(O, panel, this); //обьект контроллера(наш контроллер)
        Button button2 = new Button(O, panel, this); //обьект контроллера(наш контроллер)

        Scroll scroll  = new Scroll(O, panel);
        Scroll scroll2 = new Scroll(O, panel);

        O.addObserver(button1);  //закрепление за нашей моделью наблюдателя
        O.addObserver(button2);  //закрепление за нашей моделью наблюдателя

        scroll2.setOrientation(Scrollbar.HORIZONTAL);

        this.getContentPane().add(scroll, BorderLayout.EAST);
        this.getContentPane().add(scroll2, BorderLayout.SOUTH);
        this.getContentPane().add(panel2, BorderLayout.NORTH);
        this.getContentPane().add(panel, BorderLayout.CENTER);

        panel2.add(button1);
        panel2.add(button2);
        button1.setText("Orthogonal");
        button2.setText("Perspective");

        this.setVisible(true);

    }


        //c.PerspDraw(g2d);
    /*
    public void Listener(Axes O,double Sensa) {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                //int x=me.getXOnScreen();
                //int y=me.getYOnScreen();
                System.out.println(me.getXOnScreen());
                //if (me.getXOnScreen()>width/2){
                    //rotate();
                }
                else{
                    O.rotateAxe(0, -Sensa, 0);
                }
            }
        });
    }*/



}
