package generatePointCloud;

import PathPlanning.BaseHandInfo;
import PathPlanning.Point;
import PathPlanning.Utils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * @author 汪一江
 * @Destriction
 * @Date 2020/12/26
 */
public class LaserHelper {

    //不同角度下的激光雷达位置
    static Map<Double, Point> laserPointMap[] = new HashMap[]
            {new HashMap<>(), new HashMap<>(), new HashMap<>(), new HashMap<>()};
//    static Map<Double,Point>laserPointMap1=new HashMap<>();
    //根据激光雷达位置确定不同回转平台角度下的点位p,再根据当前回转位置确定当前平面可以扫描到的点(根据y/x大小)放入点集C,
    // 在C中再根据(z/Math.sqrt((px-x)^2+(px-x)^2))关系确定同平面下不同角度下的点到激光雷达的距离,距离小的留下,大的扔掉。

    public static void main(String[] args) {
        fillLaserPointMap(60, 0);
        System.out.println(0);
    }

    public static void printNode(List<Point> points, String name) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String str = df.format(new Date());
        String prepath = "E:\\file\\点云\\";
        String path = prepath + str + name + ".txt";
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
            write(out, points);


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

    public static void printPointCloud(List<Point> points, String name) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String str = df.format(new Date());
        String prepath = "E:\\graduateDesignTxt\\点云\\";
        String path = prepath + str + name + ".txt";
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
            write(out, points);

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
        System.out.println(name + "打印已结束");
    }
    public static void printPointCloud(List<Double>[] points, String name) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String str = df.format(new Date());
        String prepath = "E:\\file\\点云\\";
        String path = prepath + str + name + ".txt";
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
            write(out, points,name);

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
        System.out.println(name + "打印已结束");
    }

    private static void write(BufferedWriter out, List<Double>[] points,String name) throws IOException {
        for(int i=0;i<points[0].size();i++)
        {
            out.write(points[0].get(i) + "," + points[1].get(i)  + "," + points[2].get(i)  + "\r\n");
        }
    }

    public  static  void printRandPoint(String name)
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String str = df.format(new Date());
        String prepath = "E:\\graduateDesignTxt\\点云\\";
        String path = prepath + str + name + ".txt";
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
            writeRand(out);

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
        System.out.println(name + "打印已结束");
    }
    public static List laserBydegree(List<Point> points) {
//        fillLaserPointMap(60,0);
//        fillLaserPointMap(60,1);
//        fillLaserPointMap(30,2);
//        fillLaserPointMap(30,3);

        CopyOnWriteArrayList<Point> ret = new CopyOnWriteArrayList<>();
//        CountDownLatch countDownLatch = new CountDownLatch(4);
                CountDownLatch countDownLatch = new CountDownLatch(2);

        laser(points, 60, 0, ret, countDownLatch);
        laser(points, 60, 1, ret, countDownLatch);
//        laser(points, 30, 2, ret, countDownLatch);
//        laser(points, 30, 3, ret, countDownLatch);
        try {
            countDownLatch.await();
            laserPointMap[0].clear();
            laserPointMap[1].clear();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("扫描完成");
        return ret;
    }

    private static void writeRand(BufferedWriter out) throws IOException {
        Random random = new Random();
        int i = 0;
        while (i < 5 ){
            double x = random.nextInt(1500);
            x += 1000;
            double y = random.nextInt(2000);
            y -= 1000;
            double z = random.nextInt(800);
            out.write(x + "," + y + "," + z + "\r\n");
            i++;
        }

    }

    public static void laser(List<Point> points, double revDegree, int i, List<Point> ret, CountDownLatch countDownLatch) {
//        fillLaserPointMap(revDegree, i);
        fillLaserPointMapRevolving(i);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                List<Point> points1 = new ArrayList<>(points);
                System.out.println("启动");
                Map<Double, surface> map = new HashMap<>();
                for (Map.Entry<Double, Point> entry : laserPointMap[i].entrySet()) {
                    Double degree = entry.getKey();
                    Point c = entry.getValue();
                    Iterator<Point> iterator = points1.iterator();
                    while (iterator.hasNext()) {
                        Point point = iterator.next();
                        double theta = Utils.atan2(point.y - c.y, point.x - c.x);
                        if (Math.abs(theta - degree) <= 0.5) {
                            put(map, c, degree, point, revDegree);
                            iterator.remove();
                        }
                        if (degree >= 0) {

                            if (Math.abs(theta - degree + 180) <= 0.5) {
                                iterator.remove();
                                put(map, c, degree, point, revDegree);
                            }
                        } else {
                            if (Math.abs(theta - degree - 180) <= 0.5) {
                                iterator.remove();
                                put(map, c, degree, point, revDegree);
                            }
                        }

                    }
                    System.out.println("激光雷达" + i + " 平面:" + revDegree + " 角度" + degree + "已完成");


                }

                for (Map.Entry<Double, surface> entry : map.entrySet()) {
                    surface s = entry.getValue();
                    for (Map.Entry<Double, PriorityQueue<Point>> entry1 : s.getMap().entrySet()) {
                        PriorityQueue<Point> queue = entry1.getValue();
                        Point point = queue.peek();
                        ret.add(queue.peek());
                    }
                }
                System.out.println("角度" + revDegree + "激光雷达" + i + "扫描完成");
//        laserPointMap.clear();
                countDownLatch.countDown();
            }
        });

        thread.start();
        System.out.println("over");


    }
    private static void fillLaserPointMapRevolving(int i)
    {
        double degree = -90;

        while (degree <= 90) {
            if (i % 2 == 0) {
                laserPointMap[i].put(degree, BaseHandInfo.getLaserPointOneRevolving(degree));
            } else {
                laserPointMap[i].put(degree, BaseHandInfo.getLaserPointTwoRevolving(degree));
            }
//                        degree += 1;
            degree += BaseHandInfo.LaserGap;
//                        degree += 1;


//            degree += 1.5;
        }
    }
    private static void fillLaserPointMap(double revDegree, int i) {
        double degree = -90;
        while (degree <= 90) {
            if (i % 2 == 0) {
                laserPointMap[i].put(degree, BaseHandInfo.getLaserPointOne(degree, revDegree));
            } else {
                laserPointMap[i].put(degree, BaseHandInfo.getLaserPointTwo(degree, revDegree));
            }
            degree += 3;
        }
    }

    private static void put(Map<Double, surface> map, Point c, double d, Point point, double revDegree) {


        surface surface;
        if (!map.containsKey(d)) {
            map.put(d, new surface());
        }
        surface = map.get(d);
        Map<Double, PriorityQueue<Point>> sMap = surface.getMap();
        PriorityQueue<Point> queue;

        double surfaceTheta = Utils.atan2(point.z - c.z,
                Math.sqrt((point.x > 0 ? 1 : -1) * (Math.pow(point.y, 2) + Math.pow(point.x, 2))) - Math.sqrt(Math.pow(c.y, 2) + Math.pow(c.x, 2)));
        int ratio = (int) ((surfaceTheta) / 0.5);
        double degree = ratio * 0.5;
        double degree1 = degree + 0.5 > 180 ? -179.5 : degree + 0.5;
        double degree2 = degree - 0.5 < -180 ? 179.5 : degree - 0.5;
        double dis1 = Math.abs(surfaceTheta - degree);
        double dis2 = Math.abs(surfaceTheta - degree1);
        double dis3 = Math.abs(surfaceTheta - degree2);
        double nearestDis = Math.min(dis1,
                Math.min(dis2, Math.abs(dis3)));
        double nearestDegree;
        if (nearestDis == dis1) {
            nearestDegree = degree;
        } else if (nearestDis == dis2) {
            nearestDegree = degree1;
        } else {
            nearestDegree = degree2;
        }
        if (!sMap.containsKey(nearestDegree)) {
            sMap.put(nearestDegree, new PriorityQueue<Point>(new Comparator<Point>() {
                @Override
                public int compare(Point p1, Point p2) {
                    return (int) (Utils.getDistance(c, p1) - Utils.getDistance(c, p2));
                }
            }));
        }
        queue = sMap.get(nearestDegree);

        queue.add(point);

    }

    private static void write(BufferedWriter out, List<Point> points) throws IOException {
        for (Point point : points) {
            write(out, point);
        }

    }

    private static void write(BufferedWriter out, Point point) throws IOException {
        out.write(point.x + "," + point.y + "," + point.z +","+point.getName()+ "\r\n");
    }

    public static List subsample(List<Point> list) {
        List<Point> ret = new ArrayList<>();
        List<Point> list1 = new ArrayList<>(list);
//        Set<Point> set[][][] = new Set[1501][2001][1501];
//        for (Point point : list) {
//            int x = (int) point.x - 1000;
//            int y = (int) point.y + 1000;
//            int z = (int) point.z - 500;
//            if (set[x][y][z] == null) {
//                set[x][y][z] = new HashSet<>();
//            }
//            set[x][y][z].add(point);
//        }
        BitSet bitSet=new BitSet();
              for (Point point : list) {
            int x = (int) point.x - 1000;
            int y = (int) point.y + 1000;
            int z = (int) point.z + 500;

           bitSet.set(1501*2001*x+1501*y+z);
        }
        for (int i = 0; i < 1501; i++)
            for (int j = 0; j < 2001; j++)
                for (int k = 0; k < 1501; k++) {
                    if(bitSet.get(1501*2001*i+1501*j+k))
                    {
                        continue;
                    }
                    Map<String, Integer> map = new HashMap<>();
                    int cnt = 0;
                    Iterator<Point> iterator = list1.iterator();

                    while (iterator.hasNext()) {
                        Point point = iterator.next();
                        int x = (int) point.x - 1000;
                        int y = (int) point.y + 1000;
                        int z = (int) point.z - 500;
                        if (x == i && y == j && z == k) {
                            iterator.remove();
                            double px = 0;
                            double py = 0;
                            double pz = 0;
                            if (!map.containsKey(point.getName())) {
                                map.put(point.getName(), 1);
                            } else {
                                map.put(point.getName(), map.get(point.getName()) + 1);
                            }
                            px += point.x;
                            py += point.y;
                            pz += point.z;
                            String name = "";
                            int val = Integer.MIN_VALUE;
                            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                                if (entry.getValue() > val) {
                                    name = entry.getKey();
                                    val = entry.getValue();
                                }
                            }
                            if (cnt != 0) {
                                Point point1 = new Point(px / cnt, py / cnt, pz / cnt);
                                point1.setName(name);
                                ret.add(point1);
                            }

                        }
                    }
                    System.out.println("i" + i + " j" + j + " k" + k + "结束");
//                    if(set[i][j][k]!=null)
//                    {
//                        double px=0;
//                        double py=0;
//                        double pz=0;
//                        for(Point point:set[i][j][k])
//                        {
//                            if(!map.containsKey(point.getName()))
//                            {
//                                map.put(point.getName(),1);
//                            }
//                            else {
//                                map.put(point.getName(),map.get(point.getName())+1);
//                            }
//                            px+=point.x;
//                            py+=point.y;
//                            pz+=point.z;
//                        }
//                        String name="";
//                        int val=Integer.MIN_VALUE;
//                        for (Map.Entry<String,Integer>entry:map.entrySet())
//                        {
//                            if(entry.getValue()>val)
//                            {
//                                name=entry.getKey();
//                                val=entry.getValue();
//                            }
//                        }
//                        int size=set[i][j][k].size();
//                        Point point=new Point(px/size,py/size,pz/size);
//                        point.setName(name);
//                        ret.add(point);
//                    }
//
//                }
                }

        System.out.println("下采样完成");
        return ret;

    }

    public static void printDividPointCloud(List list, String name) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String str = df.format(new Date());
        String prepath = "E:\\graduateDesignTxt\\点云\\";
        Map<String ,BufferedWriter>map=new HashMap<>();
        BufferedWriter out = null;
        Iterator<Point> iterator = list.iterator();
        try {
        while (iterator.hasNext())
        {
            Point point=iterator.next();
            if(!map.containsKey(point.getName()))
            {
                String path = prepath + str + name +point.getName()+".txt";
                File file = new File(path);
                System.out.println(path);
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

                    map.put(point.getName(),out = new BufferedWriter(
                            new OutputStreamWriter(new FileOutputStream(path, true))));
            }
            out=map.get(point.getName());
            write(out,point);

        }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            for(Map.Entry<String,BufferedWriter>entry:map.entrySet())
            {
                BufferedWriter bw=entry.getValue();
                if (out != null) {
                    try {
                        bw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }




        System.out.println(name + "打印已结束");
    }

    public static void printNonGround(List list, String name) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String str = df.format(new Date());
        String prepath = "E:\\graduateDesignTxt\\点云\\";
        String path = prepath + str + name +".txt";
        File file = new File(path);
        System.out.println(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        BufferedWriter out = null ;
        try {
            out = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(path, true)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } ;

        Iterator<Point> iterator = list.iterator();
        try {
            while (iterator.hasNext())
            {
                Point point=iterator.next();
                if(!point.getName().equals("ground"))
                {
                    write(out,point);

                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
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




        System.out.println(name + "打印已结束");
    }
    public static void printNonRand(List list, String name) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String str = df.format(new Date());
        String prepath = "E:\\graduateDesignTxt\\点云\\";
        String path = prepath + str + name +".txt";
        File file = new File(path);
        System.out.println(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        BufferedWriter out = null ;
        try {
            out = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(path, true)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } ;

        Iterator<Point> iterator = list.iterator();
        try {
            while (iterator.hasNext())
            {
                Point point=iterator.next();
                if(!point.getName().equals("随机点")&&!point.getName().equals("ground"))
                {
                    write(out,point);

                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
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




        System.out.println(name + "打印已结束");
    }
    public  static  void cluster(List<Point>list,String name)
    {
        Map<Point,Set<Point>>map=new HashMap<>();
        boolean help[]=new boolean[list.size()];
        for (int i = 0; i <list.size() ; i++) {
            if()
        }

    }

}
