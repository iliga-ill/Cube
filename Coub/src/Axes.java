import java.awt.*;
import java.awt.geom.Path2D;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class Axes  extends Observable{

        public R3Vector[] axeVector;
        public cube[] CubeN;
        public R3Vector Ox;
        public R3Vector Oy;
        public R3Vector Oz;
        int i=-1;
        double CornX=0,CornY=0,CornZ=0;
        R3Vector Screen = new R3Vector(0,0,1);

        public Axes(double L,int n) {
            CubeN = new cube[n];
            axeVector = new R3Vector[6];
            axeVector[0] = new R3Vector(-1*L,0   ,0   );
            axeVector[1] = new R3Vector(1*L ,0   ,0   );
            axeVector[2] = new R3Vector(0   ,-1*L,0   );
            axeVector[3] = new R3Vector(0   ,1*L ,0   );
            axeVector[4] = new R3Vector(0   ,0   ,-1*L);
            axeVector[5] = new R3Vector(0   ,0   ,1*L );

            Ox = new R3Vector(1*L,0   ,0   );
            Oy = new R3Vector(0  ,1*L ,0   );
            Oz = new R3Vector(0  ,0   ,1*L );

            Screen.x=Screen.x*L;
            Screen.y=Screen.y*L;
            Screen.z=Screen.z*L;
        }

    public void r0() {
        i=-1;
        this.BuildCube(100);
        this.setChanged();  //оповещение наблюдателя
        this.notifyObservers(0);
    }
    public void r1() {
        i=-1;
        this.BuildCube(100);
        this.setChanged();  //оповещение наблюдателя
        this.notifyObservers(1);
    }


    public void rotateAxe(double x, double y, double z) {
        for (int i = 0; i < axeVector.length; i++) {
            axeVector[i].VRound(x, y, z);
        }
        for (int i = 0; i < CubeN.length; i++) {
            CubeN[i].rotate(x, y, z);
        }
        Ox.VRound(x, y, z);
        Oy.VRound(x, y, z);
        Oz.VRound(x, y, z);
        //Screen.VRound(x, y, z);
        CornX+=x;
        CornY+=y;
        CornZ+=z;
    }

    public void BuildCube(double L){
        i++;
        cube c = new cube();
        c.L=L;
        c.scale(L);
        c.translate(-L / 2, L / 2, -L / 2);
        c.rotate(180,0,0);
        c.rotate(CornX,CornY,CornZ);
        //c.rotate(30,30,0);
        CubeN[i] = c;

    }

    public void Zoom(double z){


    }

    public void RotateCubeN(int i,double x, double y, double z){
        CubeN[i].rotate(x,y,z);
    }

    public void ScaleCubeN(int i,double k){
            CubeN[i].L=CubeN[i].L*k;
            CubeN[i].scale(k);
    }

    public void TranslateCubeN(int i,double x, double y, double z){
        if (CubeN[i].L/2==Math.abs(z)){z=z+1;}
        CubeN[i].translate(x,y,z);
    }

    public void PerspektivaCubeN(int i, double c){
        CubeN[i].Perspektiva(c);
        }


    public void drawX(Graphics2D g) {
        Path2D p = new Path2D.Double();

        g.setColor(Color.black);
        p.moveTo(axeVector[0].getX(), axeVector[0].getY());
        p.lineTo(axeVector[1].getX(), axeVector[1].getY());

        p.closePath();
        g.draw(p);
    }

    public void drawY(Graphics2D g) {
        Path2D p = new Path2D.Double();

        g.setColor(Color.MAGENTA);
        p.moveTo(axeVector[2].getX(), axeVector[2].getY());
        p.lineTo(axeVector[3].getX(), axeVector[3].getY());

        p.closePath();
        g.draw(p);
    }

    public void drawZ(Graphics2D g) {
        Path2D p = new Path2D.Double();

        g.setColor(Color.CYAN);
        p.moveTo( axeVector[4].getX(), axeVector[4].getY());
        p.lineTo( axeVector[5].getX(), axeVector[5].getY());

        p.closePath();
        g.draw(p);
    }


}
