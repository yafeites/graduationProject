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
    public static Vector[] multiplicationcross(Vector[]vectors1,Vector[]vectors2)
    {
        double [][]arr1=transfrom(vectors1);
        double [][]arr2=transfrom(vectors2);
        double [][]ret=new double[3][3];
        Vector[]vectors=new Vector[3];
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j < 3; j++) {
              ret[i][j]=  cross(arr1,arr2,i,j);
            }
        }
        return  retransfrom(ret);

    }

    private static double cross(double[][] arr1, double[][] arr2, int i, int j) {
        double ret=0;
        ret+=arr1[i][0]*arr2[0][j];
        ret+=arr1[i][1]*arr2[1][j];
        ret+=arr1[i][2]*arr2[2][j];
        return ret;

    }
    private static Vector[] retransfrom(double[][]ret) {
        Vector[]vectors=new Vector[3];
        vectors[0]=new Vector(ret[0][0],ret[1][0],ret[2][0]);
        vectors[1]=new Vector(ret[0][1],ret[1][1],ret[2][1]);
        vectors[2]=new Vector(ret[0][2],ret[1][2],ret[2][2]);


        return  vectors;

    }

    private static double[][] transfrom(Vector[] vectors) {
        double ret[][]=new double[3][3];
        ret[0][0]=vectors[0].vextorX;
        ret[1][0]=vectors[0].vextorY;
        ret[2][0]=vectors[0].vextorZ;
        ret[0][1]=vectors[1].vextorX;
        ret[1][1]=vectors[1].vextorY;
        ret[2][1]=vectors[1].vextorZ;
        ret[0][2]=vectors[2].vextorX;
        ret[1][2]=vectors[2].vextorY;
        ret[2][2]=vectors[2].vextorZ;
        return  ret;

    }
    public  static  Vector[] revolvexy(double degree)
    {
       Vector[]vectors=new Vector[3];
        vectors[0] = new Vector(Utils.cos(degree), Utils.sin(degree), 0);
        vectors[1] = new Vector(-Utils.sin(degree), Utils.cos(degree), 0);
        vectors[2] = new Vector(0, 0, 1);
        return vectors;
    }
    public  static  Vector[] revolveyz(double degree)
    {
        Vector[]vectors=new Vector[3];
        vectors[0] = new Vector(1, 0, 0);
        vectors[1] = new Vector(0, Utils.cos(degree), Utils.sin(degree));
        vectors[2] = new Vector(0, -Utils.sin(degree), Utils.cos(degree));
        return vectors;
    }
    public  static  Vector[] revolvexz(double degree)
    {
        Vector[]vectors=new Vector[3];
        vectors[0] = new Vector(Utils.cos(degree), 0, Utils.sin(degree));
        vectors[1] = new Vector(0,1, 0);
        vectors[2] = new Vector(-Utils.sin(degree), 0, Utils.cos(degree));
        return vectors;
    }



}
