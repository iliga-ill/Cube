public class R3Vector {
    double x, y, z;

    public R3Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void out() {
        System.out.println("(" + x + ";" + y + ";" + z + ")");
    }  //Вывод значения вектора

    public R3Vector sum(R3Vector a) {
        return new R3Vector(x + a.x, y + a.y, z + a.z);
    }//Суммирование двух векторов в данный

    public static R3Vector sum(R3Vector a, R3Vector b) {
        return new R3Vector(a.x + b.x, a.y + b.y, a.z + b.z);
    }//Суммирование двух векторов V2

    public R3Vector sumX3(R3Vector a, R3Vector b) {
        return new R3Vector(x + a.x + b.x, y + a.y + b.y, z + a.z + b.z);
    }//Суммирование трех векторов в данный

    public void scale(double k) {
        this.x *= k;
        this.y *= k;
        this.z *= k;
    }//Умножение вектора на число(увеличение)

    public void translate(double dx, double dy, double dz) {
        this.x += dx;
        this.y -= dy;
        this.z += dz;
    }//перемещение вектора на dx,dy,dz (умножение вектора на число)

    public double OpredelitV(R3Vector a) {
        return Math.sqrt(Math.pow(a.x, 2) + Math.pow(a.y, 2) + Math.pow(a.z, 2));
    } //определитель вектора

    public double ScaleV(R3Vector a, R3Vector b, int ugol) {
        return OpredelitV(a) * OpredelitV(b) * Math.cos(ugol);
    }//скалярное произведение векторов через угол (a*b=число)

    public double ScaleV(R3Vector a, R3Vector b) {
        return a.x * b.x + a.y * b.y + a.z * b.z;
    }//скалярное произведение векторов через координаты (a*b=число)

    public R3Vector VectorV(R3Vector b) {
        return new R3Vector(y * b.z - z * b.y, x * b.z - z * b.y, x * b.y - y * b.x);
    }//векторное произведение векторов (a х b=вектор) от вектора

    public double Ugol(R3Vector a, R3Vector b) {
        return Math.acos((ScaleV(a, b) * 180) / (OpredelitV(a) * OpredelitV(b) * 3.1415));
    }//угол между двумя векторами

    public double sin(double U) {

        return Math.sin(U);
    }//синус от угла U

    public double cos(double U) {
        return Math.cos(U);
    }//косинус от угла U

    public void VRound(double ux, double uy, double uz) {

        R3Vector Ox = new R3Vector(1, 0, 0);
        R3Vector Oy = new R3Vector(0, 1, 0);
        R3Vector Oz = new R3Vector(0, 0, 1);

        if (ux >= 0) {
            VRound(Ox, ux);
        } else {
            VRound(Ox, 360 + ux);
        }

        if (uy >= 0) {
            VRound(Oy, uy);
        } else {
            VRound(Oy, 360 + uy);
        }

        if (uz >= 0) {
            VRound(Oz, uz);
        } else {
            VRound(Oz, 360 + uz);
        }
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return z;
    }

    public void VRound(R3Vector O, double U) {
        U = U * (3.1415 / 180);
        double M1 = (1 - cos(U)) * O.x * O.x + cos(U);
        double M2 = (1 - cos(U)) * O.x * O.y - sin(U) * O.z;
        double M3 = (1 - cos(U)) * O.x * O.z + sin(U) * O.y;

        double M4 = (1 - cos(U)) * O.y * O.x + sin(U) * O.z;
        double M5 = (1 - cos(U)) * O.y * O.y + cos(U);
        double M6 = (1 - cos(U)) * O.y * O.z - sin(U) * O.x;

        double M7 = (1 - cos(U)) * O.z * O.x - sin(U) * O.y;
        double M8 = (1 - cos(U)) * O.z * O.y + sin(U) * O.x;
        double M9 = (1 - cos(U)) * O.z * O.z + cos(U);

        double C1 = M1 * x + M2 * y + M3 * z;
        double C2 = M4 * x + M5 * y + M6 * z;
        double C3 = M7 * x + M8 * y + M9 * z;

            x = C1;
            y = C2;
            z = C3;

    }//вращение вектора а вокруг единичного вектора O на угол U от вектора
    //-------------------------------------------------------------------------------------метод от нынешнего
/*
    public double getXP(double c) {
        double t = -c / (z - c);
        return x * t;
    }

    public double getYP(double c) {
        double t = -c / (z - c);
        return y * t;
    }

    public double getZP(double c) {
        double t = -c / (z - c);
        return z * t;
    }
*/
    public void Perspektiva(double c){
        double t = -c / (z - c);
        x=x*t;
        y=y*t;
        z=z*t;
    }
}
