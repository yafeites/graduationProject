package generatePointCloud;

import PathPlanning.BaseHandInfo;
import PathPlanning.Point;
import PathPlanning.Utils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author 汪一江
 * @Destriction
 * @Date 2020/12/26
 */
public class LaserHelper {

    static Map<Double,Point>laserPointMap=new HashMap<>();
    //根据激光雷达位置确定不同回转平台角度下的点位p,再根据当前回转位置确定当前平面可以扫描到的点(根据y/x大小)放入点集C,
    // 在C中再根据(z/Math.sqrt((px-x)^2+(px-x)^2))关系确定同平面下不同角度下的点到激光雷达的距离,距离小的留下,大的扔掉。

    public void laserBydegree(List<Point>points,String name)
    {
        generateObstacle o=new generateObstacle();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String str = df.format(new Date());
        String prepath = "E:\\file\\点云\\";
        String path = prepath  +str+ name+".txt";
        File file = new File(path);
        System.out.println(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        List<Point>list1=laser(points,60);
        List<Point>list2=laser(points,30);

        BufferedWriter out = null;
        try {
            out = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(path, true)));
            write(out,list1);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public List<Point> laser(List<Point>points,double revDegree)
    {
        Map<Double,surface>map=new HashMap<>();
        for (Point point:points) {
            double theta= Utils.atan2(point.y,point.x);
            int ratio =(int) (theta/2.5);
            double degree=ratio*2.5;
            double degree1=degree+2.5>180?-177.5:degree+2.5;
            double degree2=degree-2.5<-180?177.5:degree-2.5;
            if(testput(map,theta,degree,point,revDegree)&&testput(map,theta,degree1,point,revDegree)&&testput(map,theta,degree2,point,revDegree))
            {

            }

        }

    }

    private boolean testput(Map<Double, surface> map, double theta, double d,Point point,double revDegree) {
        Point c;
        if(!laserPointMap.containsKey(d))
        {
            laserPointMap.put(d,BaseHandInfo.getLaserPoint(revDegree,d)) ;
        }
        c=laserPointMap.get(d);
        if(Math.abs(theta-d)<=0.5)
        {
            surface surface;
            if(!map.containsKey(d))
            {
                map.put(d,new surface());
            }
            surface=map.get(d);
            Map<Double, PriorityQueue<Point>> sMap=surface.getMap();
            PriorityQueue<Point> queue;
            double surfaceTheta=Utils.atan2(point.z-c.z,
                    Math.sqrt(Math.pow(point.y,2)+Math.pow(point.x,2))-Math.sqrt(Math.pow(c.y,2)+Math.pow(c.x,2)));
            int ratio =(int) (theta/0.36);
            double degree=ratio*0.36;
            double degree1=degree+0.36>180?-179.64:degree+2.5;
            double degree2=degree-2.5<-180?179.64:degree-2.5;
            double nearest=Math.min(Math.abs(surfaceTheta-degree),
                    Math.min(Math.abs(surfaceTheta-degree1),Math.abs(surfaceTheta-degree2)));
            if(!sMap.containsKey(nearest))
            {
                sMap.put(nearest,new PriorityQueue<Point>(new Comparator<Point>() {
                    @Override
                    public int compare(Point p1, Point p2) {
                        return (int)(-Utils.getDistance(c,p1)+Utils.getDistance(c,p2));
                    }
                }) );
            }
            queue=sMap.get(d);
            queue.add(point);
            return true;
        }
        return false;
    }
    private void write(BufferedWriter out, List<Point> points) throws IOException {
        for (Point point:points) {
            write(out,point);
        }

    }
    private void write(BufferedWriter out, Point point) throws IOException {
        out.write(point.x + "," + point.y + "," + point.z + "\r\n");
    }

}
