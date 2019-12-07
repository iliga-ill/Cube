public class Main {

    public static void main(String[] args) {
        R3Vector a = new R3Vector(10,10,10);
        R3Vector Ox  = new R3Vector(1,0,0);
        R3Vector Oy  = new R3Vector(0,1,0);
        R3Vector Oz  = new R3Vector(0,0,1);

        //a.VRound(a.VRound(a.VRound(a.VRound(a,Ox,90),Oy,90),Oz,90),Ox,90).out();
        System.out.println("\nx");
        a.VRoundX(a,90).out();
        a.VRound(a,Ox,90).out();
        System.out.println("\ny");
        a.VRoundY(a,90).out();
        a.VRound(a,Oy,90).out();
        System.out.println("\nz");
        a.VRoundZ(a,90).out();
        a.VRound(a,Oz,90).out();
    }

}
