

public class R3Vector {

    public double x, y, z;
    public R3Vector(double x,double y,double z){
        this.x =x;
        this.y =y;
        this.z =z;
    }

    public void out(){
        System.out.println("("+x+";"+y+";"+z+")");
    }  //Вывод значения вектора

    public R3Vector sum(R3Vector a){
        return new R3Vector(x+a.x,y+a.y,z+a.z);
    }//Суммирование двух векторов в данный

    public static R3Vector sum(R3Vector a,R3Vector b){
        return new R3Vector(a.x+b.x,a.y+b.y,a.z+b.z);
    }//Суммирование двух векторов V2

    public R3Vector sumX3(R3Vector a,R3Vector b){
        return new R3Vector(x+a.x+b.x,y+a.y+b.y,z+a.z+b.z);
    }//Суммирование трех векторов в данный

    public void scale(double k){
        this.x*=k;
        this.y*=k;
        this.z*=k;
    }//Умножение вектора на число(увеличение)

    public void translate(double dx,double dy,double dz){
        this.x+=dx;
        this.y+=dy;
        this.z+=dz;
    }//перемещение вектора на dx,dy,dz (умножение вектора на число)

    public double OpredelitV(R3Vector a){
        return Math.sqrt(Math.pow(a.x,2)+Math.pow(a.y,2)+Math.pow(a.z,2));
    } //определитель вектора

    public double ScaleV(R3Vector a,R3Vector b, int ugol){
        return OpredelitV(a)*OpredelitV(b)*Math.cos(ugol);
    }//скалярное произведение векторов через угол (a*b=число)

    public double ScaleV(R3Vector a,R3Vector b){
        return a.x*b.x+a.y*b.y+a.z*b.z;
    }//скалярное произведение векторов через координаты (a*b=число)

    public R3Vector VectorV(R3Vector a,R3Vector b){
        return new R3Vector(a.y*b.z-a.z*b.y,a.x*b.z-a.z*b.y,a.x*b.y-a.y*b.x);
    }//векторное произведение векторов (a х b=вектор)

    public R3Vector VectorV(R3Vector b){
        return new R3Vector(y*b.z-z*b.y,x*b.z-z*b.y,x*b.y-y*b.x);
    }//векторное произведение векторов (a х b=вектор) от вектора

    public double Ugol(R3Vector a,R3Vector b){
        return Math.acos((ScaleV(a,b)*180)/(OpredelitV(a)*OpredelitV(b)*3.1415));
    }//угол между двумя векторами

    public double sin(double U){

        return Math.sin(U);
    }//синус от угла U
    public double cos(double U){

        return Math.cos(U);
    }//косинус от угла U

    //-------------------------------------------------------------------------------------
    public R3Vector VRound(R3Vector a,R3Vector O, double U){


        double M1=(1-cos(U))*O.x*O.x+cos(U);    double M2=(1-cos(U))*O.x*O.y-sin(U)*O.z;double M3=(1-cos(U))*O.x*O.z+sin(U)*O.y;
        double M4=(1-cos(U))*O.y*O.x+sin(U)*O.z;double M5=(1-cos(U))*O.y*O.y+cos(U);    double M6=(1-cos(U))*O.y*O.z-sin(U)*O.x;
        double M7=(1-cos(U))*O.z*O.x-sin(U)*O.y;double M8=(1-cos(U))*O.z*O.y+sin(U)*O.x;double M9=(1-cos(U))*O.z*O.z+cos(U);

        double C1=M1*a.x + M2*a.y + M3*a.z;
        double C2=M4*a.x + M5*a.y + M6*a.z;
        double C3=M7*a.x + M8*a.y + M9*a.z;

        if (O.x==1){
            return new R3Vector(C1,C3,C2);
        }
        else if (O.y==1){
            return new R3Vector(C1,C2,C3);
        }
        else{
            return new R3Vector(C2,C1,C3);
        }
    }//вращение вектора а вокруг единичного вектора O на угол U от вводимого
    public R3Vector VRound(R3Vector O, double U){
        //R3Vector t= new R3Vector();
        double M1=(1-cos(U))*O.x*O.x+cos(U);    double M2=(1-cos(U))*O.x*O.y-sin(U)*O.z;double M3=(1-cos(U))*O.x*O.z+sin(U)*O.y;
        double M4=(1-cos(U))*O.y*O.x+sin(U)*O.z;double M5=(1-cos(U))*O.y*O.y+cos(U);    double M6=(1-cos(U))*O.y*O.z-sin(U)*O.x;
        double M7=(1-cos(U))*O.z*O.x-sin(U)*O.y;double M8=(1-cos(U))*O.z*O.y+sin(U)*O.x;double M9=(1-cos(U))*O.z*O.z+cos(U);

        double C1=M1*x + M2*y + M3*z;
        double C2=M4*x + M5*y + M6*z;
        double C3=M7*x + M8*y + M9*z;

        if (O.x==1){
            return new R3Vector(C1,C3,C2);
        }
        else if (O.y==1){
            return new R3Vector(C1,C2,C3);
        }
        else{
            return new R3Vector(C2,C1,C3);
        }
    }//вращение вектора а вокруг единичного вектора O на угол U от вектора
    //------------------------------------------------------------------------------------- метод от вводимого
    public R3Vector VRoundX(R3Vector a, double U){
        return new R3Vector(a.x,a.y*cos(U)+a.z*sin(U),-a.y*sin(U)+a.z*cos(U));
    }
    public R3Vector VRoundY(R3Vector a, double U){
        return new R3Vector(a.x*cos(U)+a.z*sin(U),a.y,-a.x*sin(U)+a.z*cos(U));
    }
    public R3Vector VRoundZ(R3Vector a, double U){
        return new R3Vector(a.x*cos(U)+a.y*sin(U),-a.x*sin(U)+a.y*cos(U),a.z);
    }
//-------------------------------------------------------------------------------------метод от нынешнего
    public R3Vector VRoundX(double U){
        return new R3Vector(x,y*cos(U)+z*sin(U),-y*sin(U)+z*cos(U));
    }
    public R3Vector VRoundY(double U){
        return new R3Vector(x*cos(U)+z*sin(U),y,-x*sin(U)+z*cos(U));
    }
    public R3Vector VRoundZ(double U){
        return new R3Vector(x*cos(U)+y*sin(U),-x*sin(U)+y*cos(U),z);
    }
    //-------------------------------------------------------------------------------------
}
