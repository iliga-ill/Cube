import java.awt.*;

public class cube {

    public Facet[] facets;
    public Integer[] facetsN;
    public Color[] color;
    double L;

    public cube() {
        facets = new Facet[6];
        facets[0] = new Facet(new R3Vector(0, 0, 0), new R3Vector(1, 0, 0), new R3Vector(1, 1, 0), new R3Vector(0, 1, 0));
        facets[1] = new Facet(new R3Vector(0, 0, 0), new R3Vector(0, 1, 0), new R3Vector(0, 1, 1), new R3Vector(0, 0, 1));
        facets[2] = new Facet(new R3Vector(0, 0, 0), new R3Vector(0, 0, 1), new R3Vector(1, 0, 1), new R3Vector(1, 0, 0));

        facets[3] = new Facet(new R3Vector(1, 1, 1), new R3Vector(0, 1, 1), new R3Vector(0, 1, 0), new R3Vector(1, 1, 0));
        facets[4] = new Facet(new R3Vector(1, 1, 1), new R3Vector(1, 0, 1), new R3Vector(0, 0, 1), new R3Vector(0, 1, 1));
        facets[5] = new Facet(new R3Vector(1, 1, 1), new R3Vector(1, 1, 0), new R3Vector(1, 0, 0), new R3Vector(1, 0, 1));

        color = new Color[6];
        color[0] = Color.green;
        color[1] = Color.yellow;
        color[2] = Color.red;
        color[3] = Color.blue;
        color[4] = Color.darkGray;
        color[5] = Color.lightGray;
    }

    public void show() {
        for (int i = 0; i < facets.length; i++) {
            facets[i].show();
        }
    }

    public void scale(double k) {
        for (int i = 0; i < facets.length; i++) {
            facets[i].scale(k);
        }
    }

    public void translate(double dx, double dy, double dz) {
        for (int i = 0; i < facets.length; i++) {
            facets[i].translate(dx, dy, dz);
        }
    }

    public void rotate(double x, double y, double z) {
        for (int i = 0; i < facets.length; i++) {
            facets[i].rotate(x, y, z);
        }
    }

    public void Perspektiva(double c){
        for (int i = 0; i < facets.length; i++) {
            facets[i].Perspektiva(c);
        }
    }

    int jC,Numb;
    double minC;
    public void draw(Graphics2D g,Axes Axe) {

        facetsN = new Integer[6];
        for (int i = 0; i < facetsN.length; i++) {
            facetsN[i]=1;
        }
        //Numb=0;
        for (int i = 0; i < facets.length; i++) {
            minC=-1000;
            //minC(Axe);
            //if (Axe.CornY<0){minC=-minC;}
            for (int j = 0; j < facetsN.length; j++) {  //нахождение грани с минимальным углом
                if ( (facetsN[j]==1) & (Corner(j,Axe.Screen)>=minC) ){
                    minC=Corner(j,Axe.Screen);
                    jC=j;
                }
            }
            facetsN[jC]=0;
            System.out.println(jC);
            System.out.println(minC+"\n");
            //if (Numb<3){
                facets[jC].draw(g, color[jC]);
                Numb++;
            //}
        }

/*
        for (int i = 0; i < facets.length; i++) {
            if ((Corner(i, Axe.Screen)>0)){
                System.out.println(i);
                System.out.println(Corner(i, Axe.Screen)+"\n");
                facets[i].draw(g, color[i]);
            }
        }
*/
    }
/*
    public double minC(Axes Axe){
        if (Axe.CornY<=0){return -1000;}
        else if (Axe.CornY>0){
            if (Axe.CornY<0){return -1000;}
            return -1000;}
    }
*/
    public double Corner(int i, R3Vector Screen){
        return facets[i].normal(facets[i].vertex[0], facets[i].vertex[1], facets[i].vertex[2], facets[i].vertex[3], Center(Screen));
    }


    public R3Vector Center(R3Vector Screen){
        double x0=(facets[0].vertex[1].x-facets[0].vertex[0].x)/2+facets[0].vertex[0].x;
        double y0=(facets[0].vertex[2].y-facets[0].vertex[1].y)/2+facets[0].vertex[1].y;
        double z0=(facets[1].vertex[2].z-facets[1].vertex[1].z)/2+facets[1].vertex[1].z;
/*
        double x=(facets[0].vertex[1].x-facets[0].vertex[0].x)/2+facets[0].vertex[0].x;
        double y=(facets[0].vertex[2].y-facets[0].vertex[1].y)/2+facets[0].vertex[1].y;
        double z=0;
*/
        double x=Screen.x;
        double y=Screen.y;
        double z=Screen.z;

        double xV=x-x0;
        double yV=y-y0;
        double zV=z-z0;

        return new R3Vector(xV,yV,zV);
    }
/*
    public void PerspDraw(Graphics2D g) {
        for (int i = 0; i < facets.length; i++) {
            facets[i].PerspDraw(g, color[i]);
        }
    }
*/
}
