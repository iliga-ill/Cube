import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class Button extends JButton implements Observer {

    private Axes O;
    private Viewer V;
    private Panel panel;
    public static int ButtonN=0,i;
    private int k;

    public Button(Axes O, Panel panel, Viewer V){
        ButtonN++;
        k=ButtonN;
        MyButtonListener1 listener1 = new MyButtonListener1();
        MyButtonListener2 listener2 = new MyButtonListener2();
        this.addActionListener(listener1);
        this.addActionListener(listener2);
        this.setSize(100,100);
        this.O = O;
        this.V = V;
        this.panel = panel;

    }

    @Override
    public void update(Observable o, Object arg) {
        //c = (Axes) o;

        if ((int)arg==0){
            //panel.setStr(counter.getCounter());
            i=1;
            //panel.repaint();
            V.repaint();
            System.out.println(k);
        }

        if ((int)arg==1) {
            i=2;
            //panel.setStr(counter.getCounter());
            //panel.repaint();
            V.repaint();
            System.out.println(k);
        }
        //System.out.println((int) arg);
    }
/*
    private class MyButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if (number == 1) panel.setNumber(number);
            else if (number == 2) panel.setNumber(number);
            panel.repaint();
        }
    }*/

    private class MyButtonListener1 implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if (k==1) {
                O.r0();
                //counter.increment1(); - действие слушаемого обьекта
            }//вызывает изменение счетчика и сигналит об этом
        }
    }

    private class MyButtonListener2 implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if (k==2) {
                O.r1();
                //counter.increment2();
            }//вызывает изменение счетчика и сигналит об этом
        }
    }
}
/*
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class MyButton extends JButton implements Observer{ //наследует обсервер
    private Counter counter;
    private MyPanel panel;
    public static int ButtonN=0;
    public int k;

    public MyButton(Counter counter, MyPanel panel, String str){
        ButtonN++;
        k=ButtonN;
        //System.out.println(ButtonN);
        System.out.println(k);
        this.setText(str);
        MyButtonListener1 listener1 = new MyButtonListener1();
        MyButtonListener2 listener2 = new MyButtonListener2();
        this.addActionListener(listener1);
        this.addActionListener(listener2);

        this.counter = counter;
        this.panel = panel;
    }

    @Override
    public void update(Observable o, Object arg) {
        counter = (Counter) o;

        if (((int)arg==0)&(k==1)){
        panel.setStr(counter.getCounter());
        panel.repaint();
        System.out.println(k);
        }

        if (((int)arg==1)&(k==2)) {
            if (counter.getCounter() % 2 == 0) {
                panel.setBackground(Color.GREEN);
            } else {
                panel.setBackground(Color.YELLOW);
            }
            panel.setStr(counter.getCounter());
            panel.repaint();
            System.out.println(k);
        }
        //System.out.println((int) arg);
    }

    private class MyButtonListener1 implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if (k==1) {
                counter.increment1();
            }//вызывает изменение счетчика и сигналит об этом
        }
    }

    private class MyButtonListener2 implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if (k==2) {
                counter.increment2();
            }//вызывает изменение счетчика и сигналит об этом
        }
    }
}
*/