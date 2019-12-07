public class Main {

    public static void main(String[] args) {
        R3Vector a = new R3Vector(10,0,0);
        R3Vector x  = new R3Vector(1,0,0);
        R3Vector y  = new R3Vector(0,1,0);
        R3Vector z  = new R3Vector(0,0,1);
        //a.out();
        //a.sum(a.sum(a));
        //a.sum(a,a).out();
        //a.scale(5);
        //a.out();
        //System.out.println(a.ScaleOp(a,a,90));
        //a.VectorOp(a,a).out();
        a.VRound(a,x,180).out();
        a.VRound(a.VRound(a.VRound(a.VRound(a,x,90), y, 90), z, 90), x, 90).out();
    }

}
