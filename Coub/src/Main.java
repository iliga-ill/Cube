import javax.swing.*;
import java.awt.*;
import java.security.acl.Group;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.event.EventHandler;
import javax.swing.JFrame;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseDragEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class Main{

    //поворот влево  -
    //повотор вправо +
    static double C=1;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Axes O = new Axes(1000,1);
        O.BuildCube(100);
        //O.PerspektivaCubeN(0,1000);
        //O.RotateCubeN(0,10,-10,0);
        //O.TranslateCubeN(0,0,0,0);
        //O.rotateAxe(10, 10, 0);
        Viewer window = new Viewer(O,1200,700);
        //window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



/*
        int d=0;
        while (C!=0) {
            System.out.println("Введите угол поворота Z:");
            C =in.nextInt();
            O.rotateAxe(0, C, 0);
            window.repaint();
        }
*/
/*
        while (true) {
            C = 0.0001;
            O.rotateAxe(0, C, 0);
            window.repaint();
        }
*/
    }

}
