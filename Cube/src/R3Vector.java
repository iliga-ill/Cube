

public class R3Vector {

    public double x, y, z;
    public R3Vector(double x,double y,double z){
        this.x =x;
        this.y =y;
        this.z =z;
    }

    public void out(){
        System.out.println("("+x+";"+y+";"+z+")");
    }

    public R3Vector sum(R3Vector a){
        return new R3Vector(x+a.x,y+a.y,z+a.z);
    }

    public static R3Vector sum(R3Vector a,R3Vector b){
        return new R3Vector(a.x+b.x,a.y+b.y,a.z+b.z);
    }

    public void scale(double k){
        this.x*=k;
        this.y*=k;
        this.z*=k;
    }

    public void translate(double dx,double dy,double dz){
        this.x+=dx;
        this.y+=dy;
        this.z+=dz;
    }

    public double ScaleOp(R3Vector a,R3Vector b, int ugol){
        return OpredelitOp(a)*OpredelitOp(b)*Math.cos(ugol);
    }

    public R3Vector VectorOp(R3Vector a,R3Vector b){
        return new R3Vector(a.y*b.z-a.z*b.y,a.x*b.z-a.z*b.y,a.x*b.y-a.y*b.x);
    }

    public double OpredelitOp(R3Vector a){
        return Math.sqrt(Math.pow(a.x,2)+Math.pow(a.y,2)+Math.pow(a.z,2));
    }

    public double Ugol(R3Vector a,R3Vector b){
        return Math.acos((Op(a,b)*180)/(OpredelitOp(a)*OpredelitOp(b)*3.1415));
    }

    public double Op(R3Vector a,R3Vector b){
        return a.x*b.x+a.y*b.y+a.z*b.z;
    }

    public R3Vector VSumV(R3Vector a,R3Vector b){
        return new R3Vector(a.x+b.x,a.y+b.y,a.z+b.z);
    }

    public R3Vector VonN(R3Vector a,double n){
        return new R3Vector(a.x,a.y,a.z);
    }

    public R3Vector VRound(R3Vector a,R3Vector x, double U){
        R3Vector dr = new R3Vector(0,0,0);

        return VSumV((VSumV(VonN(x,(Op(a,x)*(1-Math.cos(U)))),VonN(VectorOp(x,a), Math.sin(U)))),VonN(a, Math.cos(U)));
    }
}
