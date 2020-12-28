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
    //不同角度下的激光雷达位置
    static Map<Double,Point>laserPointMap=new HashMap<>();
//    static Map<Double,Point>laserPointMap1=new HashMap<>();
    //根据激光雷达位置确定不同回转平台角度下的点位p,再根据当前回转位置确定当前平面可以扫描到的点(根据y/x大小)放入点集C,
    // 在C中再根据(z/Math.sqrt((px-x)^2+(px-x)^2))关系确定同平面下不同角度下的点到激光雷达的距离,距离小的留下,大的扔掉。

    public static void main(String[] args) {

    }
    public  static  void  printNode(List<Point>points,String name)
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String str = df.format(new Date());
        String prepath = "D:\\file\\点云\\";
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
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(path, true)));
            write(out,points);


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
    public static void laserBydegree(List<Point>points,String name)
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String str = df.format(new Date());
        String prepath = "D:\\file\\点云\\";
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
//        System.out.println(list1.size());
        List<Point>list2=laser(points,30);

        BufferedWriter out = null;
        try {
            out = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(path, true)));
            write(out,list1);
            write(out,list2);


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
    public static List<Point> laser(List<Point>points,double revDegree)
    {
        List<Point>ret=new ArrayList<>();
        fillLaserPointMap(revDegree);
        Map<Double,surface>map=new HashMap<>();
        for (Map.Entry<Double,Point>entry:laserPointMap.entrySet()){
            Double degree=entry.getKey();
            Point c=entry.getValue();
            for (Point point:points) {
                double theta= Utils.atan2(point.y-c.y,point.x-c.x);
                if(Math.abs(theta-degree)<=0.5)
                {
                    put(map,c,degree,point,revDegree);
                }
                if(degree>=0)
                {
                    if(Math.abs(theta-degree+180)<=0.5)
                    {
                        put(map,c,degree,point,revDegree);
                    }
                }
                else
                {
                    if(Math.abs(theta-degree-180)<=0.5)
                    {
                        put(map,c,degree,point,revDegree);
                    }
                }



            }
        }

        for(Map.Entry<Double,surface>entry:map.entrySet())
        {
            surface s=entry.getValue();
            for(Map.Entry<Double,PriorityQueue<Point>>entry1:s.getMap().entrySet())
            {
                PriorityQueue<Point> queue=entry1.getValue();
                ret.add(queue.peek());
            }
        }
        laserPointMap.clear();
        return ret;

    }

    private static void fillLaserPointMap(double revDegree) {
        double degree=-90;
        while (degree<90)
        {
            laserPointMap.put(degree,BaseHandInfo.getLaserPoint(degree,revDegree));
            degree+=2;
        }
    }

    private static void put(Map<Double, surface> map, Point c, double d,Point point,double revDegree) {


            surface surface;
            if(!map.containsKey(d))
            {
                map.put(d,new surface());
            }
            surface=map.get(d);
            Map<Double, PriorityQueue<Point>> sMap=surface.getMap();
            PriorityQueue<Point> queue;
            double surfaceTheta=Utils.atan2(point.z-c.z,
                    Math.sqrt((point.x>0?1:-1)*(Math.pow(point.y,2)+Math.pow(point.x,2)))-Math.sqrt(Math.pow(c.y,2)+Math.pow(c.x,2)));
            int ratio =(int) (surfaceTheta/0.36);
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
                        return (int)(Utils.getDistance(c,p1)-Utils.getDistance(c,p2));
                    }
                }) );
            }
            queue=sMap.get(nearest);
            queue.add(point);

    }
    private static void write(BufferedWriter out, List<Point> points) throws IOException {
        for (Point point:points) {
            write(out,point);
        }

    }
    private static void write(BufferedWriter out, Point point) throws IOException {
        out.write(point.x + "," + point.y + "," + point.z + "\r\n");
    }

}
