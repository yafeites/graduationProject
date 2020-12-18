package PathPlanning;

/**
 * @author 汪一江
 * @Destriction
 * @Date 2020/12/16
 */
public class Utils {
    static  double getDistance(Point point1,Point point2)
    {
        return Math.sqrt(Math.pow(point1.x-point2.x,2)
                +Math.pow(point1.y-point2.y,2)
                + Math.pow(point1.z-point2.z,2));
    }
    static void standardization(Vector vector)
    {
        double val=Math.sqrt(vector.vextorX*vector.vextorX+vector.vextorY*vector.vextorY
                +vector.vextorZ*vector.vextorZ);
        vector.vextorX/=val;
        vector.vextorY/=val;
        vector.vextorZ/=val;
    }
}
