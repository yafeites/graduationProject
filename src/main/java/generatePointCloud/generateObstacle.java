package generatePointCloud;

import PathPlanning.*;
import PathPlanning.Vector;

import java.io.*;
import java.util.*;

/**
 * @author 汪一江
 * @Destriction
 * @Date 2020/12/25
 */
public class generateObstacle {
    public static void main(String[] args) {
        generateObstacle o = new generateObstacle();
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
//        String str = df.format(new Date());
        Vector vectorX = new Vector(1, 0, 0);
        Vector vectorY = new Vector(0, 1, 0);
        Vector vectorZ = new Vector(0, 0, 1);
        Vector vectorX30 = new Vector(Utils.cos(30), Utils.cos(60), 0);
        Vector vectorY30 = new Vector(Utils.cos(60), -Utils.cos(30), 0);
        Vector vectorZ30 = new Vector(0, 0, 1);
        Vector[] vectors30 = new Vector[]{vectorX30, vectorY30, vectorZ30};

        Vector[] vectors = new Vector[]{vectorX, vectorY, vectorZ};
        Vector vectorX60 = new Vector(Utils.cos(60), -Utils.cos(30), 0);
        Vector vectorY60 = new Vector(-Utils.cos(60), -Utils.cos(30), 0);
        Vector vectorZ60 = new Vector(0, 0, 1);
        Vector[] vectors60 = new Vector[]{vectorX60, vectorY60, vectorZ60};
        Vector vectorpX30 = new Vector(Utils.cos(30), -Utils.cos(60), 0);
        Vector vectorpY30 = new Vector(Utils.cos(60), Utils.cos(30), 0);
        Vector vectorpZ30 = new Vector(0, 0, 1);
        Vector[] vectorsp30 = new Vector[]{vectorpX30, vectorpY30, vectorpZ30};

        //常规盒
//        Obb obbA = new Obb("obstacle1", new Point(1950.0, 0.0, 65.0), vectors30, new double[]{200, 100, 100});
//        Obb obbB = new Obb("obstacle2", new Point(1900, 500, 800), vectors, new double[]{150, 500, 150});
//        Obb obbC = new Obb("obstacle3", new Point(1900, 0, 65), vectors, new double[]{50, 50, 150});
//        Obb obbD = new Obb("obstacle4", new Point(1300.0, 300, 65.0), vectors60, new double[]{50, 150, 150});
//        Obb obbE = new Obb("obstacle5", new Point(1600.0, -300, 65.0), vectors, new double[]{150, 150, 150});
        //测试盒
//        Obb obbA = new Obb("obstacle1", new Point(1890.0, 0.0, 65.0), vectors30, new double[]{100, 75, 100});
//        Obb obbB = new Obb("obstacle2", new Point(1900, 500, 750), vectors, new double[]{150, 500, 100});
//        Obb obbD = new Obb("obstacle4", new Point(1300.0, 300, 65.0), vectors60, new double[]{100, 75, 100});
//        Obb obbE = new Obb("obstacle5", new Point(1600.0, -300, 65.0), vectors, new double[]{100, 75, 100});
        List<Point> list = new ArrayList();
//        testDis(o.getPointFromFile("2021-01-20-09-57-05El球体","球体"));
//        testShortestPoint(o.getPointFromFile("2021-01-19-16-28-51点云分离El球体","球体"));
        //   list.addAll(o.getPointFromFile("2021-01-19-16-28-51点云分离El球体","球体"));
//        List list1 = LaserHelper.laserBydegree(list);

        //实验1障碍物
        Obb obbE1o1 = new Obb("E1obstacle1", new Point(1890.0, 0.0, -170), Utils.revolvexz(-3), new double[]{150, 55, 110});
//        LaserHelper.printPointCloud(LaserHelper.laserBydegree(o.generateObb(obbE1o1,"E1obstacle1")),"E1obstacle1");
//        list.addAll(o.getPointFromFile("2021-01-18-20-09-05处理后地面点云", "ground"));
////
//        list.addAll(o.getPointFromFile("2021-01-28-14-17-06E1obstacle1","E1obstacle1"));
//        List list1 = LaserHelper.laserBydegree(list);
//        LaserHelper.printPointCloud(list1, "所有点云");
//        LaserHelper.printDividPointCloud(list1,"点云分离");
//        LaserHelper.printNonGround(list1,"障碍物");
//        LaserHelper.printNonRand(list1,"过滤随机剩下障碍物");
        //实验2障碍物`
        Obb obbE2o1 = new Obb("E2obstacle1", new Point(1130, 600, 985), Utils.revolveyz(1), new double[]{140, 600, 65});
        Obb obbE2o2 = new Obb("E2obstacle2", new Point(1890, 0, -225), Utils.revolvexz(-0.5), new double[]{150, 110, 55});
//        LaserHelper.printPointCloud(LaserHelper.laserBydegree(o.generateObb(obbE2o1,"E2obstacle1")),"E2obstacle1");
//        LaserHelper.printPointCloud(LaserHelper.laserBydegree(o.generateObb(obbE2o2,"E2obstacle2")),"E2obstacle2");
//        list.addAll(o.getPointFromFile("2021-01-28-14-33-00E2obstacle1","E2obstacle1"));
//        list.addAll(o.getPointFromFile("2021-01-28-14-33-07E2obstacle2","E2obstacle2"));
//        list.addAll(o.getPointFromFile("2021-01-18-20-09-05处理后地面点云", "ground"));
//        List list1 = LaserHelper.laserBydegree(list);
//        LaserHelper.printPointCloud(list1, "所有点云");
//
//        LaserHelper.printDividPointCloud(list1, "点云分离");
//        LaserHelper.printNonGround(list1, "障碍物");
//        LaserHelper.printNonRand(list1, "过滤随机剩下障碍物");
//
        //实验三障碍物
        Obb obbE3o1 = new Obb("E3obstacle1", new Point(1890.0, 0.0, -170), Utils.revolvexz(-3), new double[]{150, 55, 110});
        Obb obbE3o2 = new Obb("E3obstacle2", new Point(1650.0, 600, 330), Utils.revolveyz(1), new double[]{140, 600, 65});
        Obb obbE3o3 = new Obb("E3obstacle3", new Point(1650.0, -355, -95), Utils.revolveyz(10), new double[]{150, 105, 175});
        LaserHelper.printPointCloud(LaserHelper.laserBydegree(o.generateObb(obbE3o1,"E3obstacle1")),"E3obstacle1");
//        LaserHelper.printPointCloud(LaserHelper.laserBydegree(o.generateObb(obbE3o2,"E3obstacle2")),"E3obstacle2");
//        LaserHelper.printPointCloud(LaserHelper.laserBydegree(o.generateObb(obbE3o3,"E3obstacle3")),"E3obstacle3");
//        list.addAll(o.getPointFromFile("2021-01-28-14-39-36E3obstacle1", "E3obstacle1"));
//        list.addAll(o.getPointFromFile("2021-01-28-14-42-21E3obstacle2", "E3obstacle2"));
//        list.addAll(o.getPointFromFile("2021-01-28-14-42-50E3obstacle3", "E3obstacle3"));
//        list.addAll(o.getPointFromFile("2021-01-18-20-09-05处理后地面点云", "ground"));
//        List list1 = LaserHelper.laserBydegree(list);
//        LaserHelper.printPointCloud(list1, "所有点云");
//                LaserHelper.printRandPoint("随机点");
//        LaserHelper.printDividPointCloud(list1,"点云分离");
//        LaserHelper.printNonGround(list1,"障碍物");
//        LaserHelper.printNonRand(list1,"过滤随机剩下障碍物");

        //第三章例
//        Obb obbELo1 = new Obb("Elobstacle1", new Point(1590, 600, 330), Utils.revolveyz(0.75), new double[]{140, 600, 65});
//        Obb obbELo2 = new Obb("Elobstacle2", new Point(1890.0, 0.0, -170), vectors, new double[]{150, 55, 110});
//        LaserHelper.printPointCloud(LaserHelper.laserBydegree(o.generateObb(obbELo1,"Elobstacle1")),"Elobstacle1");
//        LaserHelper.printPointCloud(LaserHelper.laserBydegree(o.generateObb(obbELo2,"Elobstacle2")),"Elobstacle2");
//        list.addAll(o.getPointFromFile("2021-01-19-16-16-05处理后地面点云", "ground"));
//        list.addAll(o.getPointFromFile("2021-01-27-11-30-12Elobstacle1", "Elobstacle1"));
//        list.addAll(o.getPointFromFile("2021-01-27-11-30-16Elobstacle2", "Elobstacle2"));
//        List list1 = LaserHelper.laserBydegree(list);
//        LaserHelper.printPointCloud(list1, "所有点云");
//        LaserHelper.printDividPointCloud(list1, "点云分离");
//        LaserHelper.printNonGround(list1, "障碍物");
//        LaserHelper.printNonRand(list1, "过滤随机剩下障碍物");
        //激光雷达实验
        //z轴向y轴负方向偏移10度
        Vector vectorzy10x = new Vector(1, 0, 0);
        Vector vectorzy10y = new Vector(0, Utils.cos(10), Utils.sin(10));
        Vector vectorzy10z = new Vector(0, -Utils.sin(10), Utils.cos(10));
        Vector[] vectorzyp10 = new Vector[]{vectorzy10x, vectorzy10y, vectorzy10z};
        Obb obbELo1 = new Obb("Elobstacle1", new Point(1650, -355, -95), Utils.multiplicationcross(Utils.revolvexy(-30), Utils.revolveyz(10)), new double[]{150, 105, 175});
        Obb obbELo2 = new Obb("Elobstacle2", new Point(1390, 600, 330), Utils.revolveyz(0.5), new double[]{140, 600, 65});
        Obb obbELo3 = new Obb("Elobstacle3", new Point(1890.0, 0.0, -170), vectors, new double[]{150, 55, 110});
        Obb obbELo4 = new Obb("Elobstacle4", new Point(1290, 450, -205), Utils.multiplicationcross(Utils.revolvexy(-30), Utils.revolveyz(5)), new double[]{100, 75, 75});
//        BaseHandInfo.LaserGap=3;
//        LaserHelper.printPointCloud(LaserHelper.laserBydegree(o.generateSphere(new Point(1230, -500, -210), 123, "El球体")), "El球体");
//        LaserHelper.printPointCloud(LaserHelper.laserBydegree(o.generateObb(obbELo1,"Elobstacle1")),"Elobstacle1");
//        LaserHelper.printPointCloud(LaserHelper.laserBydegree(o.generateObb(obbELo2,"Elobstacle2")),"Elobstacle2");
//        LaserHelper.printPointCloud(LaserHelper.laserBydegree(o.generateObb(obbELo3,"Elobstacle3")),"Elobstacle3");
//        LaserHelper.printPointCloud(LaserHelper.laserBydegree(o.generateObb(obbELo4,"Elobstacle4")),"Elobstacle4");
//        list.addAll(o.getPointFromFile("2021-01-19-16-16-05处理后地面点云", "ground"));
//        list.addAll(o.getPointFromFile("2021-01-28-10-32-35El球体", "El球体"));
//        list.addAll(o.getPointFromFile("2021-01-28-10-27-42Elobstacle1", "Elobstacle1"));
//        list.addAll(o.getPointFromFile("2021-01-28-10-29-06Elobstacle2", "Elobstacle2"));
//        list.addAll(o.getPointFromFile("2021-01-28-10-29-10Elobstacle3", "Elobstacle3"));
//        list.addAll(o.getPointFromFile("2021-01-28-10-29-13Elobstacle4", "Elobstacle4"));
//        List list1 = LaserHelper.laserBydegree(list);
//        LaserHelper.printPointCloud(list1, "所有点云");
//        LaserHelper.printDividPointCloud(list1, "点云分离");
//        LaserHelper.printNonGround(list1, "障碍物");
//        LaserHelper.printNonRand(list1, "过滤随机剩下障碍物");
//        测试
//        Obb test=new Obb("Elobstacle1", new Point(1650, -355, -95), vectorsp30, new double[]{300, 50, 50});
//                LaserHelper.printPointCloud(LaserHelper.laserBydegree(o.generateObb(test,"Elobstacle1")),"Elobstacle1");

        //生成带圆沙地
//        LaserHelper.printPointCloud(LaserHelper.laserBydegree(o.generateGroundBound("groundBound", 690, 1750, 600)), "边界点云");
//        LaserHelper.printPointCloud(LaserHelper.laserBydegree(o.generateGroundWithRound("ground", 690, 1750, 600)), "地面点云");

//        LaserHelper.printPointCloud(o.generateGroundWithRound("ground", 690, 1800, 1200),"地面点云");
//        BaseHandInfo.LaserGap=1;
//        LaserHelper.printPointCloud(LaserHelper.laserBydegree(o.getPointFromFile("2021-01-18-12-56-07地面点云",BaseHandInfo.LaserGap+"未处理ground")),"未处理地面ground");
//        LaserHelper.printPointCloud(LaserHelper.laserBydegree(o.generateGroundBound(BaseHandInfo.LaserGap+"groundBound", 690, 1800, 1200)), "边界点云");
//        BaseHandInfo.LaserGap=1.5;
//        LaserHelper.printPointCloud(LaserHelper.laserBydegree(o.getPointFromFile("2021-01-18-12-56-07地面点云",BaseHandInfo.LaserGap+"未处理ground")),"未处理地面ground");
//        LaserHelper.printPointCloud(LaserHelper.laserBydegree(o.generateGroundBound(BaseHandInfo.LaserGap+"groundBound", 690, 1800, 1200)), "边界点云");
//        BaseHandInfo.LaserGap=2;
//        LaserHelper.printPointCloud(LaserHelper.laserBydegree(o.getPointFromFile("2021-01-18-12-56-07地面点云",BaseHandInfo.LaserGap+"未处理ground")),"未处理地面ground");
//        LaserHelper.printPointCloud(LaserHelper.laserBydegree(o.generateGroundBound(BaseHandInfo.LaserGap+"groundBound", 690, 1800, 1200)), "边界点云");
//        BaseHandInfo.LaserGap=3;
//        LaserHelper.printPointCloud(LaserHelper.laserBydegree(o.getPointFromFile("2021-01-18-12-56-07地面点云",BaseHandInfo.LaserGap+"未处理ground")),"未处理地面ground");
//        LaserHelper.printPointCloud(LaserHelper.laserBydegree(o.generateGroundBound(BaseHandInfo.LaserGap+"groundBound", 690, 1800, 1200)), "边界点云");
//        BaseHandInfo.LaserGap=3;
//        list.addAll(o.getPointFromFile("2021-01-19-07-23-45边界点云", "groundBound"));
//        list.addAll(o.getPointFromFile("2021-01-19-06-57-18未处理地面ground", "ground"));
//        List list2 = new ArrayList(LaserHelper.laserBydegree(list));
//        deleteBound(list2);
//        LaserHelper.printPointCloud(list2, "处理后地面点云");
//            LaserHelper.printPointCloud(LaserHelper.laserBydegengree(o.generateGroundWithRound("ground",700,1750,750)),"地面点云");


        //生成测试点云数据
//        LaserHelper.printPointCloud(LaserHelper.laserBydegree(o.generateGround("ground")),"地面点云");
//        LaserHelper.printPointCloud(LaserHelper.laserBydegree(o.generateSphere(new Point(1200, -300, 65),122,"球体")),"球形");
//        LaserHelper.printPointCloud(LaserHelper.laserBydegree(o.generateObb(obbA,"obbA")),"obbA");
//        LaserHelper.printPointCloud(LaserHelper.laserBydegree(o.generateObb(obbB, "obbB")),"obbB");
//        LaserHelper.printPointCloud(LaserHelper.laserBydegree(o.generateObb(obbD, "obbD")),"obbD");
//        LaserHelper.printPointCloud(LaserHelper.laserBydegree(o.generateObb(obbE, "obbE")),"obbE");
        //生成所有点云合在一起照片
//        list.addAll(o.getPointFromFile("2021-01-05-20-45-26地面点云","ground"));
//        list.addAll(o.getPointFromFile("2021-01-07-10-17-10obbA","obbA"));
//        list.addAll(o.getPointFromFile("2021-01-07-10-18-18obbB","obbB"));
//        list.addAll(o.getPointFromFile("2021-01-07-10-18-21obbD","obbD"));
//        list.addAll(o.getPointFromFile("2021-01-07-10-18-23obbE","obbE"));
//        list.addAll(o.getPointFromFile("2020-12-30-11-55-21随机点","随机点"));
//        list.addAll(o.getPointFromFile("2021-01-07-10-17-08球形","球体"));
//        List list1=LaserHelper.laserBydegree(list);
//        LaserHelper.printPointCloud(list1,"所有点云");
//        LaserHelper.printRandPoint("随机点");
//        LaserHelper.printDividPointCloud(list1,"点云分离");
//        LaserHelper.printNonGround(list1,"障碍物");
//        LaserHelper.printNonRand(list1,"过滤随机剩下障碍物");


//        点云修复
//       LaserHelper.printPointCloud(o.fix(o.getPointFromFile("2021-01-06-22-11-25点云分离obbA","obbA")),"修复obbA") ;
//        LaserHelper.printPointCloud(o.fix(o.getPointFromFile("2021-01-06-22-11-25点云分离obbB","obbB")),"修复obbB") ;
//        LaserHelper.printPointCloud(o.fix(o.getPointFromFile("2021-01-06-22-11-25点云分离obbD","obbD")),"修复obbD") ;
//        LaserHelper.printPointCloud(o.fix(o.getPointFromFile("2021-01-06-22-11-25点云分离obbE","obbE")),"修复obbE") ;
//        LaserHelper.printPointCloud(o.fix(o.getPointFromFile("2021-01-06-22-11-25点云分离球体","球体")),"修复球体") ;
//        //生成包络


//        ObbEnvelope.generateEnvelopObb(
//                o.getPointFromFile("2021-01-05-21-45-06修复obbA","obbA"));
//        聚类
//        LaserHelper.cluster(o.getPointFromFile("20210128 104326分离地面","聚类"),110,40);
//                LaserHelper.cluster(o.getPointFromFile("2021-01-21-16-25-34Elobstacle3","聚类"),50);

    }

    private static void testShortestPoint(List<Point> list) {
        Point p = new Point(1390.0, -420.0, -180.0);
        Point p2 = null;
        double min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            Point p1 = list.get(i);
            if (Utils.getDistance(p1, p) != 0) {
                if (Utils.getDistance(p1, p) < min) {
                    min = Utils.getDistance(p1, p);
                    p2 = p1;
                }
            }
        }
        System.out.println(p2);
    }

    private static void testDis(List<Point> list) {
        double max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            double min = Integer.MAX_VALUE;
            Point p1 = list.get(i);
            PriorityQueue<Point> queue = new PriorityQueue<Point>(new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    return (int) (Utils.getDistance(p1, o1) - Utils.getDistance(p1, o2));
                }
            });
            for (int j = 0; j < list.size(); j++) {
                if (j != i)
                    queue.add(list.get(j));
            }

//            queue.poll();
            if (queue.isEmpty()) {
                continue;
            }
            Point point1 = queue.peek();
//            if(Utils.getDistance(point1,p1)<10)
//            {
//                continue;
//            }
            max = Math.max(max, Utils.getDistance(point1, p1));
        }
        System.out.println(max);
    }

    private static void deleteBound(List<Point> list) {
        Iterator<Point> iterator;
        iterator = list.iterator();
        while (iterator.hasNext()) {
            Point p = iterator.next();
            if (p.getName().equals("groundBound")) {
                iterator.remove();
            }
        }

    }

    public List<Point> fix(List<Point> points) {
        List<Point> ret = new ArrayList<>();

        double minHeight = Integer.MAX_VALUE;
        double maxX = Integer.MIN_VALUE;
        double minX = Integer.MAX_VALUE;
        double maxY = Integer.MIN_VALUE;
        double minY = Integer.MAX_VALUE;
        System.out.println(points.size());
        for (Point point : points) {
            minHeight = Math.min(point.z, minHeight);
        }
        for (Point point : points) {
            maxX = Math.max(maxX, point.x);
            minX = Math.min(minX, point.x);
            maxY = Math.max(maxY, point.y);
            minY = Math.min(minY, point.y);
            ret.add(point);
            ret.add(new Point(point.x, point.y, minHeight));


        }
        Set<Point> set = new HashSet<>();
        List<Point> points1 = new ArrayList<>(points);
        double max = Integer.MIN_VALUE;
        Point maxP = null;
        Point minP = null;
        double min = Integer.MAX_VALUE;
        Iterator<Point> iterator;
        for (double i = minX; i < maxX; i++) {
            iterator = points1.iterator();
            while (iterator.hasNext()) {
                Point point = iterator.next();
                if (point.x >= i && point.x <= i + 1) {
                    max = Math.max(max, point.y);
                    if (point.y == max) {
                        maxP = point;
                    }
                    min = Math.min(min, point.y);
                    if (point.y == min) {
                        minP = point;
                    }
                    iterator.remove();
                }
            }
            if (maxP != null) {
                set.add(maxP);

            }
            if (minP != null) {
                set.add(minP);
            }
            max = Integer.MIN_VALUE;
            maxP = null;
            minP = null;
            min = Integer.MAX_VALUE;
        }
        List<Point> points2 = new ArrayList<>(points);


        for (double i = minY; i < maxY; i++) {
            iterator = points2.iterator();
            while (iterator.hasNext()) {
                Point point = iterator.next();
                if (point.y >= i && point.y <= i + 1) {
                    max = Math.max(max, point.x);
                    if (point.x == max) {
                        maxP = point;
                    }
                    min = Math.min(min, point.x);
                    if (point.x == min) {
                        minP = point;
                    }
                    iterator.remove();
                }
            }
            if (maxP != null) {
                set.add(maxP);

            }
            if (minP != null) {
                set.add(minP);

            }
            max = Integer.MIN_VALUE;
            maxP = null;
            minP = null;
            min = Integer.MAX_VALUE;
        }
        for (Point point : set) {
            for (double i = point.z; i >= minHeight; i--) {
                System.out.println(i);
                ret.add(new Point(point.x, point.y, i));
            }
            System.out.println(ret.size());
        }
        return ret;
    }

    private void add(List<Double>[] ret, Point point) {
        ret[0].add(point.x);
        ret[1].add(point.y);
        ret[2].add(point.z);
    }


    public List<Point> getPointFromFile(String path, String name) {
        List<Point> ret = new ArrayList<>();

        String prepath = "E:\\graduateDesignTxt\\点云\\";
        String path1 = prepath + path + ".txt";
        String line = "";
        BufferedReader in = null;
        try {
            in = new BufferedReader(
                    new InputStreamReader(new FileInputStream(path1)));
            while ((line = in.readLine()) != null) {
                String arr[] = line.split(",");
                double x = Double.parseDouble(arr[0]);
                double y = Double.parseDouble(arr[1]);
                double z = Double.parseDouble(arr[2]);
                Point point = new Point(x, y, z);
                point.setName(name);
                ret.add(point);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(path + "打印已结束");
        return ret;
    }

    public List<Point> generateSphere(Point point, double radius, String name) {
        List<Point> list = new ArrayList<>();
        for (int i = (int) (point.x - radius); i <= point.x + radius; i++) {
            double r = radius - Math.abs(point.x - i);
            for (int j = 0; j < 360; j++) {
                Point point1 = new Point(i + 1 * (Math.random() > 0.5 ? 1 : -1) * (15 + 35 * Math.random()), point.y + r * Utils.cos(j) + 1 * (Math.random() > 0.5 ? 1 : -1) * (15 + 35 * Math.random()), point.z + r * Utils.sin(j) + 1 * (Math.random() > 0.5 ? 1 : -1) * (15 + 35 * Math.random()));
                point1.setName(name);
                list.add(point1);
            }
        }
        return list;
    }

    public List<Point> generateSubSampleGround(String name) {
        List<Point> points = new ArrayList<>();
        double maxHeight = -50;
        double minHeight = -250;
        double help[][] = new double[1501][2001];
        help[0][0] = -100;
        for (int i = 1000; i <= 2500; i += 2) {

            for (int j = -1000; j <= 1000; j += 2) {
                double val1 = -100;
                Random random = new Random();
//                    System.out.println("i:"+i+"j:"+j);
                while (true) {
                    double val = 0;
                    if (i == 1000 && j == -1000) {
                        break;
                    }
                    if (i == 1000) {
                        val = help[i - 1000][j + 998];
                    } else if (j == -1000) {
                        val = help[i - 1002][j + 1000];
                    } else {
                        val = (help[i - 1000][j + 998] + help[i - 1002][j + 1000]) / 2;
                    }
                    val1 = val + (Math.random() > 0.5 ? 1 : -1) * (Math.random() + random.nextInt(20));
                    if (val1 >= maxHeight || val1 <= minHeight) {
                        continue;
                    }

                    help[i - 1000][j + 1000] = val1;
                    break;
                }
//                for (int i1 = 0; i1 < 2; i1++) {
//                    double x = i + i1 * 0.5;
//                    for (int j1 = 0; j1 < 2; j1++) {
//                        double y = i + i1 * 0.5;
//                        Point point = new Point(x,
//                                y, val1 + (Math.random() > 0.5 ? 1 : -1) * (Math.random() + random.nextInt(5)));
//                        point.setName(name);
//                        points.add(point);
//                    }
//                }
            }
        }
        for (int i = 1000; i <= 2500; i += 2) {
            for (int j = -1000; j <= 1000; j += 2) {
                Point point = new Point(i, j, help[i - 1000][j + 1000]);
                point.setName(name);
                points.add(point);
            }

        }
        System.out.println(name + "生成已完成");

        return points;

    }

    public List<Point> generateGroundBound(String name, double startX, double xlength, double yradius) {
        List<Point> points = new ArrayList<>();
        double minHeight = -380;
        double maxHeight = 40;
        //生成横向bound
        for (int i = -(int) yradius; i < yradius; i++) {
            for (int j = (int) minHeight; j <= maxHeight; j++) {
                points.add(new Point(startX, i, j));
            }
        }
        //生成竖向bound
        for (int i = (int) startX; i <= xlength + startX; i++) {
            for (int j = (int) minHeight; j <= maxHeight; j++) {
                points.add(new Point(i, yradius, j));
                points.add(new Point(i, -yradius, j));
            }
        }
        for (int i = (int) (startX + xlength); i <= xlength + startX + yradius; i++) {

            double y = Math.sqrt(Math.pow(yradius, 2) - Math.pow(i - startX - xlength, 2));
            for (int j = (int) minHeight; j <= maxHeight; j++) {
                points.add(new Point(i, y, j));
                points.add(new Point(i, -y, j));

            }
        }
        return points;

//
    }

    public List<Point> generateGroundWithRound(String name, double startX, double xlength, double yradius) {
        List<Point> points = new ArrayList<>();
        double maxHeight = -280;
        double minHeight = -380;
        double help[][] = new double[(int) xlength + 1][2 * (int) yradius + 1];
        //生成长方形
        help[0][0] = -330;
        for (int i = (int) startX; i <= startX + xlength; i += 1) {
            for (int j = (int) -yradius; j <= yradius; j += 1) {
                double val1 = -100;
                Random random = new Random();
                while (true) {
                    double val = 0;
                    if (i == startX && j == (int) -yradius) {
                        break;
                    }
                    if (i == startX) {
                        val = help[i - (int) startX][j + (int) yradius - 1];
                    } else if (j == -(int) yradius) {
                        val = help[i - (int) startX - 1][j + (int) yradius];
                    } else {
                        val = (help[i - (int) startX][j + (int) yradius - 1] + help[i - (int) startX - 1][j + (int) yradius]) / 2;
                    }
                    val1 = val + (Math.random() > 0.5 ? 1 : -1) * (Math.random() + random.nextInt(5));
                    if (val1 >= maxHeight || val1 <= minHeight) {
                        continue;
                    }

                    help[i - (int) startX][j + (int) yradius] = val1;
                    break;
                }

            }
        }
        //打印长方形
        for (int i = (int) startX; i <= startX + xlength; i += 1) {
            for (int j = -(int) yradius; j <= yradius; j += 1) {
                Point point = new Point(i, j, help[i - (int) startX][j + (int) yradius]);
                point.setName(name);
//                System.out.println("i:"+i+"j:"+j+help[i - (int) startX][j + (int) yradius]);
                points.add(point);
            }

        }
        double help2[][] = new double[(int) yradius + 1][2 * (int) yradius + 1];
        //为圆形初始化
        for (int i = 0; i < 2 * (int) yradius + 1; i++) {
            help2[0][i] = help[help.length - 1][i];
        }
        //生成圆形
        boolean flag = false;

        for (int i = (int) (startX + xlength) + 1; i <= startX + xlength + yradius; i += 1) {
            for (int j = (int) -yradius; j <= yradius; j += 1) {
                if (Math.pow(i - (startX + xlength), 2) + Math.pow(j, 2) >= Math.pow(yradius, 2)) {
                    flag = true;
                    continue;
                }
                double val1 = -100;
                Random random = new Random();
                while (true) {
                    if (i == 2452 && j == -749) {
                        System.out.println("i:" + i + "j:" + j);

                    }
                    double val = 0;
                    if (i == startX + xlength && j == (int) -yradius) {
                        break;
                    }
                    if (i == startX + xlength) {
                        val = help2[i - (int) (startX + xlength)][j + (int) yradius - 1];
                    } else if (j == -(int) yradius) {
                        val = help2[i - (int) (startX + xlength) - 1][j + (int) yradius];
                    } else {
                        if (flag) {
                            val = help2[i - (int) (startX + xlength) - 1][j + (int) yradius];
                        } else {
                            double var1 = help2[i - (int) (startX + xlength)][j + (int) yradius - 1];
                            double var2 = help2[i - (int) (startX + xlength) - 1][j + (int) yradius];
                            val = (help2[i - (int) (startX + xlength)][j + (int) yradius - 1] + help2[i - (int) (startX + xlength) - 1][j + (int) yradius]) / 2;
                        }
                    }
                    val1 = val + (Math.random() > 0.5 ? 1 : -1) * (Math.random() + random.nextInt(5));
                    if (val1 >= maxHeight || val1 <= minHeight) {
                        continue;
                    }
                    help2[i - (int) (startX + xlength)][j + (int) yradius] = val1;
                    flag = false;
                    break;
                }
            }
        }
        //打印圆形
        for (int i = (int) (startX + xlength) + 1; i <= startX + xlength + yradius; i += 1) {
            for (int j = (int) -yradius; j <= yradius; j += 1) {
                if (Math.pow(i - (startX + xlength), 2) + Math.pow(j, 2) >= Math.pow(yradius, 2)) {
                    continue;
                }
                Point point = new Point(i, j, help2[i - (int) (startX + xlength)][j + (int) yradius]);
                point.setName(name);
                points.add(point);
            }

        }
        System.out.println(name + "生成已完成");

        return points;

    }

    public List<Point> generateGround(String name) {
        List<Point> points = new ArrayList<>();
        double maxHeight = -50;
        double minHeight = -250;
        double help[][] = new double[1501][2001];
        help[0][0] = -100;
        for (int i = 1000; i <= 2500; i += 1) {

            for (int j = -1000; j <= 1000; j += 1) {
                double val1 = -100;
                Random random = new Random();
//                    System.out.println("i:"+i+"j:"+j);
                while (true) {
                    double val = 0;
                    if (i == 1000 && j == -1000) {
                        break;
                    }
                    if (i == 1000) {
                        val = help[i - 1000][j + 999];
                    } else if (j == -1000) {
                        val = help[i - 1001][j + 1000];
                    } else {
                        val = (help[i - 1000][j + 999] + help[i - 1001][j + 1000]) / 2;
                    }
                    val1 = val + (Math.random() > 0.5 ? 1 : -1) * (Math.random() + random.nextInt(20));
                    if (val1 >= maxHeight || val1 <= minHeight) {
                        continue;
                    }

                    help[i - 1000][j + 1000] = val1;
                    break;
                }
//                for (int i1 = 0; i1 < 2; i1++) {
//                    double x = i + i1 * 0.5;
//                    for (int j1 = 0; j1 < 2; j1++) {
//                        double y = i + i1 * 0.5;
//                        Point point = new Point(x,
//                                y, val1 + (Math.random() > 0.5 ? 1 : -1) * (Math.random() + random.nextInt(5)));
//                        point.setName(name);
//                        points.add(point);
//                    }
//                }
            }
        }
        for (int i = 1000; i <= 2500; i += 1) {
            for (int j = -1000; j <= 1000; j += 1) {
                Point point = new Point(i, j, help[i - 1000][j + 1000]);
                point.setName(name);
                points.add(point);
            }

        }
        System.out.println(name + "生成已完成");

        return points;

    }

    public List generateObbWithRand(Obb obb, String name) {
        List<Point> list = new ArrayList<>();
        double x = obb.halfLength[0];
        double y = obb.halfLength[1];
        double z = obb.halfLength[2];
        for (int i = (int) -x; i <= x; i += 1) {
            double pointX = i;
//            for (int i1 = 0; i1 < 2; i1++) {
//                pointX = i + i1 * 0.5;

            for (int j = (int) -y; j <= y; j += 1) {
                double pointY = j;
//                    for (int j1 = 0; j1 < 2; j1++) {
//                        pointY = j + j1 * 0.5;

                Point point = create(obb, pointX, pointY, z + 1 * (Math.random() > 0.5 ? 1 : -1) * 10 * Math.random(), name);
                list.add(point);

                point = create(obb, pointX, pointY, -z + 1 * (Math.random() > 0.5 ? 1 : -1) * 10 * Math.random(), name);
                list.add(point);
            }
//                }
//            }
        }
        for (int i = (int) -y; i <= y; i += 1) {
            double pointY = i;
//            for (int i1 = 0; i1 < 2; i1++) {
//                pointY = i + i1 * 0.5;

            for (int j = (int) -z; j <= z; j += 1) {
                double pointZ = j;
//                    for (int j1 = 0; j1 < 2; j1++) {
//                        pointZ = j + j1 * 0.5;

                Point point = create(obb, x + 1 * (Math.random() > 0.5 ? 1 : -1) * 10 * Math.random(), pointY, pointZ, name);
                list.add(point);

                point = create(obb, -x + 1 * (Math.random() > 0.5 ? 1 : -1) * 10 * Math.random(), pointY, pointZ, name);
                list.add(point);
            }
//                }
//            }
        }
        for (int i = (int) -x; i <= x; i += 1) {
            double pointX = i;
//            for (int i1 = 0; i1 < 2; i1++) {
//                pointX = i + i1 * 0.5;

            for (int j = (int) -z; j <= z; j += 1) {
                double pointZ = j;
//                    for (int j1 = 0; j1 < 2; j1++) {
//                        pointZ = j + j1 * 0.5;

                Point point = create(obb, pointX, y + 1 * (Math.random() > 0.5 ? 1 : -1) * 10 * Math.random(), pointZ, name);
                list.add(point);

                point = create(obb, pointX, -y + 1 * (Math.random() > 0.5 ? 1 : -1) * 10 * Math.random(), pointZ, name);
                list.add(point);
            }
//                }
//            }
        }
        System.out.println(name + "生成已完成");
        System.out.println(list.size());
        return list;
    }

    public List generateObb(Obb obb, String name) {
        List<Point> list = new ArrayList<>();
        double x = obb.halfLength[0];
        double y = obb.halfLength[1];
        double z = obb.halfLength[2];
        for (int i = (int) -x; i <= x; i += 1) {
            double pointX = i;
//            for (int i1 = 0; i1 < 2; i1++) {
//                pointX = i + i1 * 0.5;

            for (int j = (int) -y; j <= y; j += 1) {
                double pointY = j;
//                    for (int j1 = 0; j1 < 2; j1++) {
//                        pointY = j + j1 * 0.5;

                Point point = create(obb, pointX + 1 * (Math.random() > 0.5 ? 1 : -1) * (20 + 35 * Math.random()), pointY + 1 * (Math.random() > 0.5 ? 1 : -1) * (20 + 35 * Math.random()), z + 1 * (Math.random() > 0.5 ? 1 : -1) * (20 + 35 * Math.random()), name);
                list.add(point);

                point = create(obb, pointX + 1 * (Math.random() > 0.5 ? 1 : -1) * (20 + 35 * Math.random()), pointY + 1 * (Math.random() > 0.5 ? 1 : -1) * (20 + 35 * Math.random()), -z + 1 * (Math.random() > 0.5 ? 1 : -1) * (20 + 35 * Math.random()), name);
                list.add(point);
            }
//                }
//            }
        }
        for (int i = (int) -y; i <= y; i += 1) {
            double pointY = i;
//            for (int i1 = 0; i1 < 2; i1++) {
//                pointY = i + i1 * 0.5;

            for (int j = (int) -z; j <= z; j += 1) {
                double pointZ = j;
//                    for (int j1 = 0; j1 < 2; j1++) {
//                        pointZ = j + j1 * 0.5;

                Point point = create(obb, x + 1 * (Math.random() > 0.5 ? 1 : -1) * (20 + 35 * Math.random()), pointY + 1 * (Math.random() > 0.5 ? 1 : -1) * (20 + 35 * Math.random()), pointZ + 1 * (Math.random() > 0.5 ? 1 : -1) * (20 + 35 * Math.random()), name);
                list.add(point);

                point = create(obb, -x + 1 * (Math.random() > 0.5 ? 1 : -1) * (20 + 35 * Math.random()), pointY + 1 * (Math.random() > 0.5 ? 1 : -1) * (20 + 35 * Math.random()), pointZ + 1 * (Math.random() > 0.5 ? 1 : -1) * (20 + 35 * Math.random()), name);
                list.add(point);
            }
//                }
//            }
        }
        for (int i = (int) -x; i <= x; i += 1) {
            double pointX = i;
//            for (int i1 = 0; i1 < 2; i1++) {
//                pointX = i + i1 * 0.5;

            for (int j = (int) -z; j <= z; j += 1) {
                double pointZ = j;
//                    for (int j1 = 0; j1 < 2; j1++) {
//                        pointZ = j + j1 * 0.5;

                Point point = create(obb, pointX + 1 * (Math.random() > 0.5 ? 1 : -1) * (20 + 35 * Math.random()), y + 1 * (Math.random() > 0.5 ? 1 : -1) * (20 + 35 * Math.random()), pointZ + 1 * (Math.random() > 0.5 ? 1 : -1) * (20 + 35 * Math.random()), name);
                list.add(point);

                point = create(obb, pointX + 1 * (Math.random() > 0.5 ? 1 : -1) * (20 + 35 * Math.random()), -y + 1 * (Math.random() > 0.5 ? 1 : -1) * (20 + 35 * Math.random()), pointZ + 1 * (Math.random() > 0.5 ? 1 : -1) * (20 + 35 * Math.random()), name);
                list.add(point);
            }
//                }
//            }
        }
        System.out.println(name + "生成已完成");
        System.out.println(list.size());
        return list;
    }

    public List generateSubSampleObb(Obb obb, String name) {
        List<Point> list = new ArrayList<>();
        double x = obb.halfLength[0];
        double y = obb.halfLength[1];
        double z = obb.halfLength[2];
        for (int i = (int) -x; i <= x; i += 2) {
            double pointX = i;
//            for (int i1 = 0; i1 < 2; i1++) {
//                pointX = i + i1 * 0.5;

            for (int j = (int) -y; j <= y; j += 2) {
                double pointY = j;
//                    for (int j1 = 0; j1 < 2; j1++) {
//                        pointY = j + j1 * 0.5;

                Point point = create(obb, pointX + 1 * (Math.random() > 0.5 ? 1 : -1) * (10 + 35 * Math.random()), pointY + 1 * (Math.random() > 0.5 ? 1 : -1) * (10 + 35 * Math.random()), z + 0 * (Math.random() > 0.5 ? 1 : -1) * 5 * Math.random(), name);
                list.add(point);

                point = create(obb, pointX + 1 * (Math.random() > 0.5 ? 1 : -1) * (10 + 35 * Math.random()), pointY + 1 * (Math.random() > 0.5 ? 1 : -1) * (10 + 35 * Math.random()), -z + 0 * (Math.random() > 0.5 ? 1 : -1) * 5 * Math.random(), name);
                list.add(point);
            }
//                }
//            }
        }
        for (int i = (int) -y; i <= y; i += 2) {
            double pointY = i;
//            for (int i1 = 0; i1 < 2; i1++) {
//                pointY = i + i1 * 0.5;

            for (int j = (int) -z; j <= z; j += 2) {
                double pointZ = j;
//                    for (int j1 = 0; j1 < 2; j1++) {
//                        pointZ = j + j1 * 0.5;

                Point point = create(obb, x + 0 * (Math.random() > 0.5 ? 1 : -1) * 5 * Math.random(), pointY, pointZ, name);
                list.add(point);

                point = create(obb, -x + 0 * (Math.random() > 0.5 ? 1 : -1) * 5 * Math.random(), pointY, pointZ, name);
                list.add(point);
            }
//                }
//            }
        }
        for (int i = (int) -x; i <= x; i += 2) {
            double pointX = i;
//            for (int i1 = 0; i1 < 2; i1++) {
//                pointX = i + i1 * 0.5;

            for (int j = (int) -z; j <= z; j += 2) {
                double pointZ = j;
//                    for (int j1 = 0; j1 < 2; j1++) {
//                        pointZ = j + j1 * 0.5;

                Point point = create(obb, pointX, y + 0 * (Math.random() > 0.5 ? 1 : -1) * 5 * Math.random(), pointZ, name);
                list.add(point);

                point = create(obb, pointX, -y + 0 * (Math.random() > 0.5 ? 1 : -1) * 5 * Math.random(), pointZ, name);
                list.add(point);
            }
//                }
//            }
        }
        System.out.println(name + "生成已完成");

        return list;
    }

    private Point create(Obb obb, double pointX, double pointY, double pointZ, String name) {
        double arr[][] = new double[3][3];
//        arr[0][0] = obb.vectors[0].vextorX;
//        arr[0][1] = obb.vectors[0].vextorY;
//        arr[0][2] = obb.vectors[0].vextorZ;
//        arr[1][0] = obb.vectors[1].vextorX;
//        arr[1][1] = obb.vectors[1].vextorY;
//        arr[1][2] = obb.vectors[1].vextorZ;
//        arr[2][0] = obb.vectors[2].vextorX;
//        arr[2][1] = obb.vectors[2].vextorY;
//        arr[2][2] = obb.vectors[2].vextorZ;
        arr[0][0] = obb.vectors[0].vextorX;
        arr[1][0] = obb.vectors[0].vextorY;
        arr[2][0] = obb.vectors[0].vextorZ;
        arr[0][1] = obb.vectors[1].vextorX;
        arr[1][1] = obb.vectors[1].vextorY;
        arr[2][1] = obb.vectors[1].vextorZ;
        arr[0][2] = obb.vectors[2].vextorX;
        arr[1][2] = obb.vectors[2].vextorY;
        arr[2][2] = obb.vectors[2].vextorZ;
        double x = arr[0][0] * pointX + arr[0][1] * pointY + arr[0][2] * pointZ + obb.point.x;
        double y = arr[1][0] * pointX + arr[1][1] * pointY + arr[1][2] * pointZ + obb.point.y;
        double z = arr[2][0] * pointX + arr[2][1] * pointY + arr[2][2] * pointZ + obb.point.z;
        Point point = new Point(x, y, z);
        point.setName(name);
        return point;

    }

}
