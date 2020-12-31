package PathPlanning;

/**
 * @author 汪一江
 * @Destriction
 * @Date 2020/12/16
 */
public class Utils {
    public static  double getDistance(Point point1,Point point2)
    {
        return Math.sqrt(Math.pow(point1.x-point2.x,2)
                +Math.pow(point1.y-point2.y,2)
                + Math.pow(point1.z-point2.z,2));
    }
    public  static void standardization(Vector vector)
    {
        double val=Math.sqrt(vector.vextorX*vector.vextorX+vector.vextorY*vector.vextorY
                +vector.vextorZ*vector.vextorZ);
        vector.vextorX/=val;
        vector.vextorY/=val;
        vector.vextorZ/=val;
    }
    public static double sin(double degree)
    {
        return  Math.sin(Math.toRadians(degree));
    }
    public static double cos(double degree)
    {
        return  Math.cos(Math.toRadians(degree));
    }
    public static double tan(double degree)
    {
        return  Math.tan(Math.toRadians(degree));
    }
    public static double asin(double val)
    {
        return  Math.toDegrees(Math.asin(val));
    }
    public static double acos(double val)
    {
        return  Math.toDegrees(Math.acos(val));
    }
    public static double atan2(double val1,double val2)
    {
        return  Math.toDegrees(Math.atan2(val1,val2));
    }


}
