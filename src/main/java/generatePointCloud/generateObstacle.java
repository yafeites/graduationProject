package generatePointCloud;

import PathPlanning.Obb;
import PathPlanning.Point;
import PathPlanning.Vector;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author 汪一江
 * @Destriction
 * @Date 2020/12/25
 */
public class generateObstacle {
    public static void main(String[] args) {
        generateObstacle o=new generateObstacle();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String str = df.format(new Date());
        Vector vectorX = new Vector(1, 0, 0);
        Vector vectorY = new Vector(0, 1, 0);
        Vector vectorZ = new Vector(0, 0, 1);
        Vector[] vectors = new Vector[]{vectorX, vectorY, vectorZ};
        Obb obbA = new Obb("obstacle1", new Point(1890.0, 0.0, 65.0), vectors, new double[]{50, 50, 50});
        o.generate(obbA,str);
    }
    public   List generate(Obb obb, String str) {
        List<Point>list=new ArrayList<>();
        double x = obb.halfLength[0];
        double y = obb.halfLength[1];
        double z = obb.halfLength[2];
        for (int i = (int) -x; i <= x; i++) {
            double pointX = 0;
            for (int i1 = 0; i1 < 1000; i1++) {
                pointX = i + (i1 - 1) * 0.001;
            }
            for (int j = (int) -y; j <= y; j++) {
                double pointY = 0;
                for (int j1 = 0; j1 < 1000; j1++) {
                    pointY = j + (j1 - 1) * 0.001;
                }
                if (Math.random() > 0.2) {
                    Point point = create(obb, pointX, pointY, z + (Math.random() > 0.5 ? 1 : -1) * 5 * Math.random());
                    list.add(point);
                }
                if (Math.random() > 0.2) {
                    Point point = create(obb, pointX, pointY, -z +(Math.random() > 0.5 ? 1 : -1) * 5 * Math.random());
                    list.add(point);
                }
            }
        }
        for (int i = (int) -y; i <= y; i++) {
            double pointY = 0;
            for (int i1 = 0; i1 < 1000; i1++) {
                pointY = i + (i1 - 1) * 0.001;
            }
            for (int j = (int) -z; j <= z; j++) {
                double pointZ = 0;
                for (int j1 = 0; j1 < 1000; j1++) {
                    pointZ = j + (j1 - 1) * 0.001;
                }
                if (Math.random() > 0.2) {
                    Point point = create(obb,x+ (Math.random() > 0.5 ? 1 : -1) * 5 * Math.random() , pointY, pointZ );
                    list.add(point);
                }
                if (Math.random() > 0.2) {
                    Point point = create(obb, -x+ (Math.random() > 0.5 ? 1 : -1) * 5 * Math.random() , pointY, pointZ );
                    list.add(point);
                }
            }
        }
        for (int i = (int) -x; i <= x; i++) {
            double pointX = 0;
            for (int i1 = 0; i1 < 1000; i1++) {
                pointX = i + (i1 - 1) * 0.001;
            }
            for (int j = (int) -z; j <= z; j++) {
                double pointZ = 0;
                for (int j1 = 0; j1 < 1000; j1++) {
                    pointZ = j + (j1 - 1) * 0.001;
                }
                if (Math.random() > 0.2) {
                    Point point = create(obb,pointX , y+ (Math.random() > 0.5 ? 1 : -1) * 5 * Math.random(), pointZ );
                    list.add(point);
                }
                if (Math.random() > 0.2) {
                    Point point = create(obb, pointX , -y+ (Math.random() > 0.5 ? 1 : -1) * 5 * Math.random(), pointZ );
                    list.add(point);
                }
            }
        }

        return list;
    }

    private Point create(Obb obb, double pointX, double pointY, double pointZ) {
        double arr[][] = new double[3][3];
        arr[0][0] = obb.vectors[0].vextorX;
        arr[0][1] = obb.vectors[0].vextorY;
        arr[0][2] = obb.vectors[0].vextorZ;
        arr[1][0] = obb.vectors[1].vextorX;
        arr[1][1] = obb.vectors[1].vextorY;
        arr[1][2] = obb.vectors[1].vextorZ;
        arr[2][0] = obb.vectors[2].vextorX;
        arr[2][1] = obb.vectors[2].vextorY;
        arr[2][2] = obb.vectors[2].vextorZ;
        double x = arr[0][0] * pointX + arr[0][1] * pointY + arr[0][2] * pointZ+obb.point.x;
        double y = arr[1][0] * pointX + arr[1][1] * pointY + arr[1][2] * pointZ+obb.point.y;
        double z = arr[2][0] * pointX + arr[2][1] * pointY + arr[2][2] * pointZ+obb.point.z;

        return  new Point(x,y,z);

    }





}
