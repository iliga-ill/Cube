import java.awt.*;
import java.awt.geom.Path2D;

public class Facet{

    public R3Vector[] vertex;

    public Facet(R3Vector v1, R3Vector v2, R3Vector v3, R3Vector v4) {
        vertex = new R3Vector[4];
        vertex[0] = v1;
        vertex[1] = v2;
        vertex[2] = v3;
        vertex[3] = v4;
    }

    public void show() {
        for (int i = 0; i < vertex.length; i++) {
            vertex[i].out();
        }
    }

    public void rotate(double x, double y, double z) {
        for (int i = 0; i < vertex.length; i++) {
            vertex[i].VRound(x, y, z);
        }
    }

    public double normal(R3Vector a, R3Vector b, R3Vector c, R3Vector d, R3Vector PointO) {
        return light(new R3Vector(a.getX() + b.getX() + c.getX() + d.getX(), a.getY() + b.getY() + c.getY() + d.getY(), a.getZ() + b.getZ() + c.getZ() + d.getZ()),PointO);
    }

    public double light(R3Vector n,R3Vector PointO) {
        R3Vector O = PointO;
        double Rad = (n.getX() * O.x + n.getY() * O.y + n.getZ() * O.z) / (Math.sqrt(n.x * n.x + n.y * n.y + n.z * n.z) * Math.sqrt(O.x * O.x + O.y * O.y + O.z * O.z));
        //System.out.println(Rad);
        return Rad;
    }

    public void translate(double dx, double dy, double dz) {
        for (int i = 0; i < vertex.length; i++) {
            vertex[i].translate(dx, dy, dz);
        }
    }

    public void scale(double k) {
        for (int i = 0; i < vertex.length; i++) {
            vertex[i].scale(k);
        }
    }

    public void Perspektiva(double c){
        for (int i = 0; i < vertex.length; i++) {
            vertex[i].Perspektiva(c);
        }
    }

    public void draw(Graphics2D g, Color color) {
            Path2D p = new Path2D.Double();

            p.moveTo(vertex[0].getX(), vertex[0].getY());
            p.lineTo(vertex[1].getX(), vertex[1].getY());
            p.lineTo(vertex[2].getX(), vertex[2].getY());
            p.lineTo(vertex[3].getX(), vertex[3].getY());
            p.lineTo(vertex[0].getX(), vertex[0].getY());

            p.closePath();
            g.setColor(color);
            g.fill(p);
            g.setColor(Color.black);
            g.draw(p);
    }
/*
    public void PerspDraw(Graphics2D g, Color color) {
        if (normal(vertex[0], vertex[1], vertex[2], vertex[3])) {
            Path2D p = new Path2D.Double();

            double c = -1000;

            p.moveTo(vertex[0].getXP(c), -vertex[0].getYP(c));
            p.lineTo(vertex[1].getXP(c), -vertex[1].getYP(c));
            p.lineTo(vertex[2].getXP(c), -vertex[2].getYP(c));
            p.lineTo(vertex[3].getXP(c), -vertex[3].getYP(c));
            p.lineTo(vertex[0].getXP(c), -vertex[0].getYP(c));

            p.closePath();
            g.setColor(color);
            //g.draw(p);
            g.fill(p);
        }

    }
*/

}
