package PathPlanning;

/**
 * @author 汪一江
 * @Destriction
 * @Date 2021/1/14
 */
public class hydraulicJointInfo {
    double lamba1=0;
    double lamba2=0;
    double lamba3=0;
    double o1a=232;
    double o1b=640;
    double o1c=1085;
    double x1=200;
    double x2=118;
    double bc=445;
    double bo2=1105;
    double co2=853;
    double do2=235;
    double eo2=142;
    double de=185;
    double o2g=750;
    double ge=798;
    double fg=240;
    double fh=180;
    double go3=100;
    double ho3=180;
    double o3o4=415;
    double ho4=485;
    double o1o2=1620;
    public static void main(String[] args) {

    }
    public void switchDegree(handJointInfo handJointInfo)
    {
        double theta1=handJointInfo.theta2;
        double theta2=180-handJointInfo.theta3;
        double theta3=180-handJointInfo.theta4;
        double bo1o2=Utils.acos((Math.pow(o1b,2)+Math.pow(o1o2,2)-Math.pow(bo2,2))/(2*o1b*o1o2));
        double ao1b=Utils.atan2(x1,x2)+theta1+bo1o2;
        lamba1=Math.sqrt(Math.pow(o1a,2)+Math.pow(o1b,2)-2*o1a*o1b*Utils.cos(ao1b));
        double do2e=Utils.acos((Math.pow(do2,2)+Math.pow(eo2,2)-Math.pow(de,2))/(2*do2*eo2));
        double eo2g=Utils.acos((Math.pow(eo2,2)+Math.pow(o2g,2)-Math.pow(ge,2))/(2*eo2*o2g));
        double o1o2b=Utils.acos((Math.pow(o1o2,2)+Math.pow(bo2,2)-Math.pow(o1b,2)/(2*o1o2*bo2)));
        double bo2c=Utils.acos((Math.pow(bo2,2)+Math.pow(co2,2)-Math.pow(o1b,2))/(2*bo2*co2));
        double co2d=360-do2e-eo2g-o1o2b-bo2c-theta2;
        lamba2=Math.sqrt(Math.pow(co2,2)+Math.pow(do2,2)-2*co2*do2*Utils.cos(co2d));
//        double fo3=?;
//        double ego2=?
//        double o2go3=?
        double ho3o4=Utils.cos((Math.pow(ho3,2)+Math.pow(o3o4,2)-Math.pow(ho4,2))/(2*o3o4*ho3));

//        double o3gf=Utils.acos((Math.pow(go3,2)+Math.pow(fg,2)-Math.pow(fo3,2))/(2*go3*fg));
//        double egf=360-ego2-o2go3-o3gf;
//        lamba3=Math.sqrt(Math.pow(ge,2)+Math.pow(fg,2)-2*ge*fg*Utils.cos(egf));

    }

}
