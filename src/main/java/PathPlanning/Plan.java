package PathPlanning;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author 汪一江
 * @Destriction
 * @Date 2020/12/16
 */
public class Plan {
    String prepath = "E:\\graduateDesignTxt\\";

    static List<Obb> obstacles = new ArrayList<>();

    public static void main(String[] args) {
        Plan p = new Plan();
        Node start = new Node();
        start.root = start;
        start.level = 1;
        start.point = new Point(1200.0, 0.0, 280.0);
        Node end = new Node();
        end.root = end;
        end.level = 1;
        end.point = new Point(2480, 0.0, 0);
        Vector vectorX1 = new Vector(1, 0, 0);
        Vector vectorY1 = new Vector(0, 1, 0);
        Vector vectorZ1 = new Vector(0, 0, 1);
        Vector[] vectors1 = new Vector[]{vectorX1, vectorY1, vectorZ1};
        Vector vectorX2 = new Vector(Utils.sin(30), -Utils.cos(30), 0);
        Vector vectorY = new Vector(0, Utils.sin(30), 1);
        Vector vectorZ = new Vector(Utils.cos(30), 0, 0);
        Vector[] vectors2 = new Vector[]{vectorX1, vectorY, vectorZ};
        //最老的obb
        Obb obbA = new Obb("obstacle1", new Point(1890.0, 0.0, 65.0), vectors1, new double[]{50, 50, 50});
        Obb obbB = new Obb("obstacle2", new Point(1600, 50, 400), vectors1, new double[]{50, 50, 50});
        Obb obbC = new Obb("obstacle3", new Point(1700.0, -50, 65.0), vectors1, new double[]{50, 50, 50});
        Obb obbD = new Obb("obstacle4", new Point(1500.0, 0.0, 65.0), vectors1, new double[]{50, 50, 50});
        Obb obbE = new Obb("obstacle5", new Point(850,0.0,800 ), vectors1, new double[]{50, 50, 50});

//        Obb obbA=new Obb("obstacle1",new Point(1890.0,0.0,65.0),vectors1,new double[]{50,50,50});
//        Obb obbB=new Obb("obstacle2",new Point(1800,500,1300),vectors1,new double[]{150,500,150});
//                Obb obbB=new Obb("obstacle2",new Point(1380,0.0,800),vectors1,new double[]{50,50,50});
//
//        Obb obbC=new Obb("obstacle3",new Point(1600,50,300),vectors2,new double[]{50,50,50});
//        Obb obbD=new Obb("obstacle4",new Point(1500.0,0.0,65.0),vectors1,new double[]{50,50,50});
//        Obb obbE=new Obb("obstacle5",new Point(1700.0,-50,65.0),vectors1,new double[]{50,50,50});
        obstacles.add(obbA);
//        obstacles.add(obbB);
//        obstacles.add(obbC);
        obstacles.add(obbD);
        obstacles.add(obbE);
        //实验1
//        BaseHandInfo.thetaPoint = -90;
//        start.point = new Point(1200.0, 0.0, 280.0);
//        end.point = new Point(2280, 0.0, -200);
//        Obb obb1=new Obb("obstacle1",new Point(1890.0,0.0,-170),vectors1,new double[]{150,55,110});
//                        obstacles.add(obb1);
//        Vector vectorE1X1 = new Vector(0.9999917896676187, 0.004052233625149753, 0);
//        Vector vectorE1Y1 = new Vector(-0.004052233625149753, 0.9999917896676187, 0);
//        Vector vectorE1Z1 = new Vector(0, 0,1 );
//        Vector[] vectorsE1O1 = new Vector[]{vectorX1, vectorY1, vectorZ1};
//        Obb obb1 = new Obb("obstacle1", new Point(1878.8424834265804, -0.0043320454585780155, -160.0017074511839),
//                vectorsE1O1, new double[]{168.9698656966724, 85.44732829925721, 129.9982925488161});
//        obstacles.add(obb1);

//        实验2
//        start.point = new Point(1770, 0.0, 630);
//        end.point = new Point(2600, 0.0, -280);

//        角度-30
//        BaseHandInfo.thetaPoint = -30;
        ////        Obb obb1 = new Obb("obstacle1", new Point(1130,600,985), vectorsE2O1, new double[]{140,600,65});
////        Obb obb2 = new Obb("obstacle2", new Point(1890,0,-225), vectorsE2O2, new double[]{150,110,55});
////        Vector vectorE2X1 = new Vector(-0.9999661492160795, 0.008228026614298273, 0);
////        Vector vectorE2Y1 = new Vector(-0.008228026614298273, -0.9999661492160795, 0);
////        Vector vectorE2Z1 = new Vector(0, 0, 1);
////        Vector[] vectorsE2O1 = new Vector[]{vectorE2X1, vectorE2Y1, vectorE2Z1};
////        Vector vectorE2X2 = new Vector(0.9999925866549344, 0.0038505369980848334, 0);
////        Vector vectorE2Y2 = new Vector(-0.0038505369980848334, 0.9999925866549344, 0);
////        Vector vectorE2Z2 = new Vector(0, 0, 1);
////        Vector[] vectorsE2O2 = new Vector[]{vectorE2X2, vectorE2Y2, vectorE2Z2};
////        Obb obb1 = new Obb("obstacle1", new Point(1122.2443997948117, 591.8190900456055, 985.0317098103676), vectorsE2O1, new double[]{167.10996413595126, 622.8374185878532, 94.96770075139898});
////        Obb obb2 = new Obb("obstacle2", new Point(1880.4613915109232, 0.18929223345776958, -217.0048951484784), vectorsE2O2, new double[]{170.76005769684195, 140.13471487588748, 76.9951048515216});
////        obstacles.add(obb1);
////        obstacles.add(obb2);
        //实验3
//        BaseHandInfo.thetaPoint = -90;
//        start.point = new Point(1090, 0.0, 340);
//        end.point = new Point(2280, 0.0, -280);
//        Obb obb1=new Obb("obstacle1",new Point(1890.0,0.0,-170),vectors1,new double[]{150,55,110});
//        Obb obb2=new Obb("obstacle1",new Point(1650.0,600,330),vectors1,new double[]{140,600,65});
//        Obb obb3=new Obb("obstacle1",new Point(1650.0,-355,-95),vectors1,new double[]{150,105,175});
//        Vector vectorE3X1 = new Vector(0.987467177036046, 0.15782450467675121, 0);
//        Vector vectorE3Y1 = new Vector(-0.15782450467675121, 0.987467177036046, 0);
//        Vector vectorE3Z1 = new Vector(0, 0, 1);
//        Vector[] vectorsE3O1 = new Vector[]{vectorE3X1, vectorE3Y1, vectorE3Z1};
//        Vector vectorE3X2 = new Vector(-0.9999970729800213, 0.002419510568241216, 0);
//        Vector vectorE3Y2 = new Vector(-0.002419510568241216, -0.9999970729800213, 0);
//        Vector vectorE3Z2 = new Vector(0, 0, 1);
//        Vector[] vectorsE3O2 = new Vector[]{vectorE3X2, vectorE3Y2, vectorE3Z2};
//        Vector vectorE3X3 = new Vector(0.9804835073705236, -0.19660135242260204, 0);
//        Vector vectorE3Y3 = new Vector(0.19660135242260204, 0.9804835073705236, 0);
//        Vector vectorE3Z3 = new Vector(0, 0, 1);
//        Vector[] vectorsE3O3 = new Vector[]{vectorE3X3, vectorE3Y3, vectorE3Z3};
//        Obb obb1 = new Obb("obstacle1", new Point(1875.167714805176, 0.6627199221402975, -162.5049839944751), vectorsE3O1, new double[]{171.97168355146755, 104.51532823318954, 132.4950160055249});
//        Obb obb2 = new Obb("obstacle2", new Point(1642.2829841554785, 599.0209976102934, 330.6484956657735), vectorsE3O2, new double[]{163.5900775929398, 629.201819753647, 94.35145489411593});
//        Obb obb3 = new Obb("obstacle3", new Point(1635.929073871934, -350.2882430107377, -87.00022023874618), vectorsE3O3, new double[]{182.69573873137233, 160.23344321311694, 196.99977976125382});
//        obstacles.add(obb1);
//        obstacles.add(obb2);
//        obstacles.add(obb3);
        handJointInfo handJointInfo = p.reCalculateDegree(end.point);
        BaseHandInfo.changehand(handJointInfo);
        System.out.println(p.intersection(end.point));
        long time = System.currentTimeMillis();
//        for (int i=0;i<10;i++)
//        {
//        p.rrt(start,end);
        p.union(start, end);
//        }
        System.out.println(System.currentTimeMillis() - time);

    }

    public void rrt(Node start, Node end) {
        Node lastInitOneNode = null;
        Node lastInitTwoNode = null;
        KdTree kdTreeS = new KdTree();
        kdTreeS.setName("初始树");
        kdTreeS.insert(start);
        KdTree kdTreeE = new KdTree();
        kdTreeE.setName("目标树");
        kdTreeE.insert(end);
        KdTree kdTreeMe = kdTreeS;
        KdTree kdTreeYou = kdTreeE;

        Node initNode = start;
        start.setTree(kdTreeS);
        end.setTree(kdTreeE);
        Node targetNode = end;
        Vector force = new Vector(0, 0, 0);
        while (true) {
            if (Utils.getDistance(initNode.point, targetNode.point) < APFInfo.stepLength) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
                String str = df.format(new Date());
                str = str.replace(' ', '_');
                str = str + "rrt";
                printTree(start, end, str);
                printNode(initNode, targetNode, str);
                printObstacles(obstacles, str);
                opt(initNode);
                opt(targetNode);
                printNode(initNode, targetNode, str + "opt");
                printPoint(initNode, targetNode, str);
                break;
            }
            Node near = kdTreeYou.getNearestNode(initNode);
            if (Utils.getDistance(initNode.point, near.point) < APFInfo.stepLength) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
                String str = df.format(new Date());
                str = str.replace(' ', '_');
                printTree(start, end, str);
                printNode(initNode, near, str);
                printObstacles(obstacles, str);
                opt(initNode);
                opt(near);
                printNode(initNode, near, str + "opt");
                printPoint(initNode, near, str);
                break;
            }
            //计算rrt引力
            force.vextorX = targetNode.point.x - initNode.point.x;
            force.vextorY = targetNode.point.y - initNode.point.y;
            force.vextorZ = targetNode.point.z - initNode.point.z;
            Utils.standardization(force);
            force.vextorX *= APFInfo.stepLength;
            force.vextorY *= APFInfo.stepLength;
            force.vextorZ *= APFInfo.stepLength;

            Point point = new Point(force.vextorX + initNode.point.x, force.vextorY + initNode.point.y
                    , force.vextorZ + initNode.point.z);

            //相交检测
            if (intersection(point)) {
                Node node = generateByRRT(initNode);
                initNode = kdTreeYou.getNearestNode(node);
                targetNode = node;
                kdTreeMe.insert(node);
                System.out.println(node.tree.name);
                System.out.println("x:" + node.point.x + " y:" + node.point.y + " z:" + node.point.z);


                KdTree temp = kdTreeMe;
                kdTreeMe = kdTreeYou;
                kdTreeYou = temp;
                force.clean();

                continue;
            }

            Node newNode = createNode(point, initNode);
            initNode = newNode;
            kdTreeMe.insert(newNode);
            System.out.println(newNode.tree.name);
            System.out.println("x:" + newNode.point.x + " y:" + newNode.point.y + " z:" + newNode.point.z);

            force.clean();

        }

    }


    public void union(Node start, Node end) {
        Node lastNewNode = null;
        Node lastInitOneNode = null;
        Node lastInitTwoNode = null;
        KdTree kdTreeS = new KdTree();
        kdTreeS.setName("初始树");
        kdTreeS.insert(start);
        KdTree kdTreeE = new KdTree();
        kdTreeE.setName("目标树");
        kdTreeE.insert(end);
        KdTree kdTreeMe = kdTreeS;
        KdTree kdTreeYou = kdTreeE;

        Node initNode = start;
        start.setTree(kdTreeS);
        end.setTree(kdTreeE);
        Node targetNode = end;
        Vector force = new Vector(0, 0, 0);
        while (true) {
            lastInitTwoNode = lastInitOneNode;
            lastInitOneNode = initNode;
            if (Utils.getDistance(initNode.point, targetNode.point) < APFInfo.stepLength) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
                String str = df.format(new Date());
                str = str.replace(' ', '_');
                printTree(start, end, str);
                printNode(initNode, targetNode, str);
                printObstacles(obstacles, str);
                opt(initNode);
                opt(targetNode);
                printNode(initNode, targetNode, str + "opt");
                printPoint(initNode, targetNode, str);
                break;
            }
            Node near = kdTreeYou.getNearestNode(initNode);
            if (Utils.getDistance(initNode.point, near.point) < APFInfo.stepLength) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
                String str = df.format(new Date());
                str = str.replace(' ', '_');
                printTree(start, end, str);
                printNode(initNode, near, str);
                printObstacles(obstacles, str);
                opt(initNode);
                opt(near);
                printNode(initNode, near, str + "opt");
                printPoint(initNode, near, str);
                break;
            }
            //计算人工势能场引力
            Vector attractiveVector = new Vector(0, 0, 0);
            attractiveVector.vextorX = targetNode.point.x - initNode.point.x;
            attractiveVector.vextorY = targetNode.point.y - initNode.point.y;
            attractiveVector.vextorZ = targetNode.point.z - initNode.point.z;
            Utils.standardization(attractiveVector);
            double forceAtt = 0.5 * Math.pow(Utils.getDistance(targetNode.point, initNode.point) * APFInfo.attractiveForceRatio, 2);
            force.vextorX += attractiveVector.vextorX * forceAtt;
            force.vextorY += attractiveVector.vextorY * forceAtt;
            force.vextorZ += attractiveVector.vextorZ * forceAtt;
            //计算斥力
            for (int i = 0; i < obstacles.size(); i++) {
                double distance = Utils.getDistance(obstacles.get(i).point, initNode.point);
//                if(distance>APFInfo.minimumDistance2Obstacle)
//                {
//                    continue;
//                }
                if (!inRange(initNode.point, obstacles.get(i))) {
                    continue;
                }
                Vector repulsiveVector = new Vector(0, 0, 0);
                repulsiveVector.vextorX = -obstacles.get(i).point.x + initNode.point.x;
                repulsiveVector.vextorY = -obstacles.get(i).point.y + initNode.point.y;
                repulsiveVector.vextorZ = -obstacles.get(i).point.z + initNode.point.z;
                Utils.standardization(attractiveVector);
                double forceRep = 0.5 * APFInfo.repulsiveForceRatio * Math.pow
                        (1 / distance - 1 / APFInfo.minimumDistance2Obstacle, 2);
                force.vextorX += repulsiveVector.vextorX * forceRep;
                force.vextorY += repulsiveVector.vextorY * forceRep;
                force.vextorZ += repulsiveVector.vextorZ * forceRep;
            }
            Utils.standardization(force);
            force.vextorX *= APFInfo.stepLength;
            force.vextorY *= APFInfo.stepLength;
            force.vextorZ *= APFInfo.stepLength;
            Point point = new Point(force.vextorX + initNode.point.x, force.vextorY + initNode.point.y
                    , force.vextorZ + initNode.point.z);
            //相交检测

            if (intersection(point)) {
                Node preNode = initNode;
                initNode = kdTreeYou.getNearestNode(initNode);
                targetNode = kdTreeMe.getNearestNode(initNode);
                if (targetNode == lastInitOneNode && initNode == lastInitTwoNode) {
                    Node node = generateByRand(preNode);
                    initNode = kdTreeYou.getNearestNode(node);
                    targetNode = kdTreeMe.getNearestNode(initNode);
                    kdTreeMe.insert(node);
                    kdTreeMe.getLastTenList().add(node);
                    lastNewNode = node;
                    System.out.println(node.tree.name);
                    System.out.println("x:" + node.point.x + " y:" + node.point.y + " z:" + node.point.z);

                }
                KdTree temp = kdTreeMe;
                kdTreeMe = kdTreeYou;
                kdTreeYou = temp;
                force.clean();

                continue;
            }
            Node nearestNode = kdTreeMe.getNearestNode(point);
            if (nearestNode.point.equals(point) || islocalOptimum(kdTreeMe, point)) {
                Node node = generateByRand(initNode);
                initNode = kdTreeYou.getNearestNode(node);
                targetNode = kdTreeMe.getNearestNode(initNode);
                kdTreeMe.insert(node);
                kdTreeMe.getLastTenList().add(node);
                KdTree temp = kdTreeMe;
                kdTreeMe = kdTreeYou;
                kdTreeYou = temp;
                force.clean();
                continue;
            }
            Node newNode = createNode(point, initNode);
            initNode = newNode;
            kdTreeMe.insert(newNode);
            kdTreeMe.getLastTenList().add(newNode);
            lastNewNode = newNode;
            System.out.println(newNode.tree.name);
            System.out.println("x:" + newNode.point.x + " y:" + newNode.point.y + " z:" + newNode.point.z);

            force.clean();


        }

    }


    private boolean islocalOptimum(KdTree kdTreeMe, Point point) {
        List<Node> list = kdTreeMe.getLastTenList();
        if (list.size() < 10) {
            return false;
        }
        for (int i = list.size() - 1; i > list.size() - 10; i--) {
            if (Utils.getDistance(point, list.get(i).point) >= 50) {
                return false;
            }
        }
        return true;
    }

    private void printPoint(Node initNode, Node targetNode, String str) {
        String path = prepath + str + "point.txt";
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
                writePoint(path, initNode, targetNode);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void writePoint(String path, Node initNode, Node targetNode) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(path, true)));
            if (initNode.tree.name.equals("初始树")) {
                writePointFromRoot(out, initNode);
                writePointFromPoint(out, targetNode);
            } else {
                writePointFromRoot(out, targetNode);
                writePointFromPoint(out, initNode);
            }
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

    private void writePointFromRoot(BufferedWriter out, Node node) throws IOException {
        List<Node> list = new ArrayList<>();
        while (node != null) {
            list.add(node);
            node = node.father;
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            node = list.get(i);
//            if(i==list.size()-1)
//            {
//                for (int j = 0; j <4 ; j++) {
//                    out.write(node.point.x+","+node.point.y+","+node.point.z+"\r\n");
//                }
//                continue;
//            }
            out.write(node.point.x + "," + node.point.y + "," + node.point.z + "\r\n");
        }

    }

    private void writePointFromPoint(BufferedWriter out, Node node) throws IOException {
        while (node != null) {
//                if(node.root==node)
//                {
//                    for (int i = 0; i < 4; i++) {
//                        out.write(node.point.x+","+node.point.y+","+node.point.z+"\r\n");
//                    }
//                    return;
//                }
            out.write(node.point.x + "," + node.point.y + "," + node.point.z + "\r\n");
            node = node.father;
        }
    }

    private boolean inRange(Point point, Obb obb) {
        Vector vector = new Vector(point.x - obb.point.x, point.y - obb.point.y, point.z - obb.point.z);
        if ((Math.abs(Dot(obb.vectors[0], vector)) < 1.5 * APFInfo.stepLength + obb.halfLength[0])
                && (Math.abs(Dot(obb.vectors[1], vector)) < 1.5 * APFInfo.stepLength + obb.halfLength[1])
                && (Math.abs(Dot(obb.vectors[2], vector)) < 1.5 * APFInfo.stepLength + obb.halfLength[2])) {
            return true;
        }
        return false;
    }

    private void opt(Node node) {
        List<Node> list = new ArrayList<>();
        while (node != node.root) {
            for (Node n : node.tree.list) {
                if (Utils.getDistance(n.point, node.point) < 5 * APFInfo.stepLength) {
                    list.add(n);
                }
            }
            Collections.sort(list, new Comparator<Node>() {
                @Override
                public int compare(Node node1, Node node2) {
                    if (node1.level != node2.level) {
                        return -node1.level + node2.level;
                    } else {
                        double dis1 = Utils.getDistance(node1.point, node1.root.point);
                        double dis2 = Utils.getDistance(node2.point, node1.root.point);
                        return -Double.compare(dis1, dis2);
                    }

//                         return (-Utils.getDistance(node1.point,node1.root.point)+
//                            Utils.getDistance(node2.point,node1.root.point));


                }
            });
            for (int i = list.size() - 1; i >= 0; i--) {
                Node node1 = list.get(i);
                if (node1.level < node.level) {
                    if (intersectionLine(node, node1)) {
                        node.father = node1;
                        node.level = node.father.level + 1;
                        System.out.println(node.point);
                        break;
                    }
                }
            }
            node = node.father;
        }
    }

    private boolean intersectionLine(Node node, Node node1) {
        Point point = node1.point;
        while (Utils.getDistance(node.point, point) > 1.5 * APFInfo.stepLength) {
            Point midP = new Point((node.point.x + point.x) / 2, (node.point.y + point.y) / 2,
                    (node.point.z + point.z) / 2);
            if (intersection(midP)) {
                return false;
            }
            point = midP;

        }
        return true;
    }

    private void printObstacles(List<Obb> obstacles, String str) {
        String path = prepath + str + "obstacles.txt";
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
                writeObs(path, obstacles);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void writeObs(String path, List<Obb> obstacles) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(path, true)));
            for (Obb obb : obstacles) {
                out.write(obb.toString() + "\r\n");
            }
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

    private void printNode(Node initNode, Node targetNode, String str) {
        String path = prepath + str + "node.txt";
        File file = new File(path);
        System.out.println(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
                writeNode(path, initNode, targetNode);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void writeNode(String path, Node initNode, Node targetNode) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(path, true)));
            write(out, initNode, targetNode);
            while (initNode.father != null) {
                write(out, initNode.father, initNode);
                initNode = initNode.father;
            }
            while (targetNode.father != null) {
                write(out, targetNode.father, targetNode);
                targetNode = targetNode.father;
            }
        } catch (FileNotFoundException e) {
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
    }


    private void printTree(Node start, Node end, String str) {

        String path = prepath + str + "tree.txt";
        System.out.println(path);
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
                writeTree(path, start, end);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void writeTree(String path, Node start, Node end) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(path, true)));
            out.write("起始树" + "\r\n");
            write(out, start);
            out.write("目标树" + "\r\n");
            write(out, end);
        } catch (FileNotFoundException e) {
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
    }

    private void write(BufferedWriter out, Node node) {
        if (node.sons.size() > 0) {
            for (Node n : node.sons) {
                try {
                    write(out, node, n);
                    write(out, n);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    private void write(BufferedWriter out, Node node1, Node node2) throws IOException {
        out.write(node1.point.x + "," + node1.point.y + "," + node1.point.z + " " +
                node2.point.x + "," + node2.point.y + "," + node2.point.z + "\r\n");
    }

    private Node generateByRRT(Node preNode) {
        Node node = null;
        while (true) {
            double a = Math.random();
            if (Math.random() < 0.5) {
                a = -a;
            }
            double b = Math.random();
            if (Math.random() < 0.5) {
                b = -b;
            }
            double c = Math.random();
            if (Math.random() < 0.5) {
                c = -c;
            }
            Vector vector = new Vector(a, b, c);
            Utils.standardization(vector);
            node = extendTree(preNode.getTree().getRandNode(), vector);
            if (node == null) {
                continue;
            }

            return node;

        }

    }

    private Node generateByRandByLongStep(Node preNode) {
        Node node = null;
        while (true) {
            double a = Math.random();
            if (Math.random() < 0.5) {
                a = -a;
            }
            double b = Math.random();
            if (Math.random() < 0.5) {
                b = -b;
            }
            double c = Math.random();
            if (Math.random() < 0.5) {
                c = -c;
            }
            Vector vector = new Vector(a, b, c);
            Utils.standardization(vector);
            double rand = Math.random();
            if (rand > RRTInfo.p0 && preNode.father != null && preNode.father.father != null) {
                Node grandfather = preNode.father.father;
                node = extendTreeLongStep(grandfather, vector);
            } else if (rand > RRTInfo.p1 && rand <= RRTInfo.p0 && preNode.father != null) {
                Node father = preNode.father;
                node = extendTreeLongStep(father, vector);
            } else if (rand > RRTInfo.p2 && rand <= RRTInfo.p1) {
                node = extendTreeLongStep(preNode, vector);
            } else {
                node = extendTree(preNode.getTree().getRandNode(), vector);
            }
            if (node == null) {
                continue;
            }

            return node;

        }
    }

    private Node generateByRand(Node preNode) {
        Node node = null;
        while (true) {
            double a = Math.random();
            if (Math.random() < 0.5) {
                a = -a;
            }
            double b = Math.random();
            if (Math.random() < 0.5) {
                b = -b;
            }
            double c = Math.random();
            if (Math.random() < 0.5) {
                c = -c;
            }
            Vector vector = new Vector(a, b, c);
            Utils.standardization(vector);
            double rand = Math.random();
            if (rand > RRTInfo.p0 && preNode.father != null && preNode.father.father != null) {
                Node grandfather = preNode.father.father;
                node = extendTree(grandfather, vector);
            } else if (rand > RRTInfo.p1 && rand <= RRTInfo.p0 && preNode.father != null) {
                Node father = preNode.father;
                node = extendTree(father, vector);
            } else if (rand > RRTInfo.p2 && rand <= RRTInfo.p1) {
                node = extendTree(preNode, vector);
            } else {
                node = extendTree(preNode.getTree().getRandNode(), vector);
            }
            if (node == null) {
                continue;
            }

            return node;

        }

    }

    private Node extendTree(Node node, Vector vector) {

        Point point = new Point(node.point.x + APFInfo.stepLength * vector.vextorX,
                node.point.y + APFInfo.stepLength * vector.vextorY,
                node.point.z + APFInfo.stepLength * vector.vextorZ);
        if (intersection(point)) {
            return null;
        } else {
            return createNode(point, node);
        }


    }

    private Node extendTreeLongStep(Node node, Vector vector) {

        Point point = new Point(node.point.x + 1.5 * APFInfo.stepLength * vector.vextorX,
                node.point.y + 1.5 * APFInfo.stepLength * vector.vextorY,
                node.point.z + 1.5 * APFInfo.stepLength * vector.vextorZ);
        if (intersection(point)) {
            return null;
        } else {
            return createNode(point, node);
        }


    }

    private Node createNode(Point point, Node node) {
        Node newNode = new Node();
        newNode.setPoint(point);
        newNode.addAttr(node);
        return newNode;
    }


    //逆运算关节角度
    public static handJointInfo reCalculateDegree(Point point) {
        double theta1 = Math.toDegrees(Math.atan2(point.y, point.x));
        double xs = Math.sqrt(point.x * point.x + point.y * point.y) - BaseHandInfo.a0;
        double ys = point.z - BaseHandInfo.d0;
        double x3 = xs - BaseHandInfo.L3 * Math.cos(Math.toRadians(BaseHandInfo.thetaPoint));
        double y3 = ys - BaseHandInfo.L3 * Math.sin(Math.toRadians(BaseHandInfo.thetaPoint));
        double theta3 = -Math.toDegrees(Math.acos((x3 * x3 + y3 * y3 - Math.pow(BaseHandInfo.L1, 2) - Math.pow(BaseHandInfo.L2, 2))
                / (2 * BaseHandInfo.L1 * BaseHandInfo.L2)));
        double k1 = BaseHandInfo.L1 + BaseHandInfo.L2 * Math.cos(Math.toRadians(theta3));
        double k2 = BaseHandInfo.L2 * Math.sin(Math.toRadians(theta3));
        double theta2 = Math.toDegrees(Math.atan2(y3, x3) - Math.atan2(k2, k1));
        double theta4 = BaseHandInfo.thetaPoint - theta2 - theta3;
        handJointInfo ret = new handJointInfo(theta1, theta2, theta3, theta4, BaseHandInfo.thetaPoint, point);
        return ret;
    }

    public boolean intersection(Point point) {
        handJointInfo handJointInfo = reCalculateDegree(point);
        BaseHandInfo.changehand(handJointInfo);
        for (int i = 0; i < obstacles.size(); i++) {
            for (int j = 0; j < BaseHandInfo.hands.length; j++) {
                if (intersectionTest(BaseHandInfo.hands[j], obstacles.get(i))) {
                    return true;
                }

            }
        }
        return false;

    }

    //相交检测
    public boolean intersectionTest(Obb hand, Obb obstacles) {
        double ra, rb;
        double[][] r = new double[3][3];
        double[][] absR = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                r[i][j] = Dot(hand.vectors[i], obstacles.vectors[j]);
                absR[i][j] = Math.abs(r[i][j]) + 1e-6;
            }
        }

        Vector t1 = new Vector(0, 0, 0);
        t1.vextorX = obstacles.point.x - hand.point.x;
        t1.vextorY = obstacles.point.y - hand.point.y;
        t1.vextorZ = obstacles.point.z - hand.point.z;
        double vextorX = Dot(t1, hand.vectors[0]);
        double vextorY = Dot(t1, hand.vectors[1]);
        double vextorZ = Dot(t1, hand.vectors[2]);
        double[] t = new double[3];
        t[0] = vextorX;
        t[1] = vextorY;
        t[2] = vextorZ;

        for (int i = 0; i < 3; i++) {
            ra = hand.halfLength[i];
            rb = obstacles.halfLength[0] * absR[i][0]
                    + obstacles.halfLength[1] * absR[i][1]
                    + obstacles.halfLength[2] * absR[i][2];
            if (Math.abs(t[i]) > ra + rb)
                return false;
        }
        for (int i = 0; i < 3; i++) {
            ra = hand.halfLength[0] * absR[0][i]
                    + hand.halfLength[1] * absR[1][i]
                    + hand.halfLength[2] * absR[2][i];
            rb = obstacles.halfLength[i];
            if (Math.abs(t[0] * r[0][i] + t[1] * r[1][i] + t[2] * r[2][i]) > ra + rb)
                return false;
        }
        //A0*B0
        ra = hand.halfLength[1] * absR[2][0] + hand.halfLength[2] * absR[1][0];
        rb = obstacles.halfLength[1] * absR[0][2] + obstacles.halfLength[2] * absR[0][1];
        if (Math.abs(t[2] * r[1][0] - t[1] * r[2][0]) > ra + rb)
            return false;

        //A0*B1
        ra = hand.halfLength[1] * absR[2][1] + hand.halfLength[2] * absR[1][1];
        rb = obstacles.halfLength[0] * absR[0][2] + obstacles.halfLength[2] * absR[0][0];
        if (Math.abs(t[2] * r[1][1] - t[1] * r[2][1]) > ra + rb)
            return false;

        //A0*B2
        ra = hand.halfLength[1] * absR[2][2] + hand.halfLength[2] * absR[1][2];
        rb = obstacles.halfLength[0] * absR[0][1] + obstacles.halfLength[1] * absR[0][0];
        if (Math.abs(t[2] * r[1][2] - t[1] * r[2][2]) > ra + rb)
            return false;

        //A1*B0
        ra = hand.halfLength[0] * absR[2][0] + hand.halfLength[2] * absR[0][0];
        rb = obstacles.halfLength[1] * absR[1][2] + obstacles.halfLength[2] * absR[1][1];
        if (Math.abs(t[0] * r[2][0] - t[2] * r[0][0]) > ra + rb)
            return false;

        //A1*B1
        ra = hand.halfLength[0] * absR[2][1] + hand.halfLength[2] * absR[0][1];
        rb = obstacles.halfLength[0] * absR[1][2] + obstacles.halfLength[2] * absR[1][0];
        if (Math.abs(t[0] * r[2][1] - t[2] * r[0][1]) > ra + rb)
            return false;

        //A1*B2
        ra = hand.halfLength[0] * absR[2][2] + hand.halfLength[2] * absR[0][2];
        rb = obstacles.halfLength[0] * absR[1][1] + obstacles.halfLength[1] * absR[1][0];
        if (Math.abs(t[0] * r[2][2] - t[2] * r[0][2]) > ra + rb)
            return false;

        //A2*B0
        ra = hand.halfLength[0] * absR[1][0] + hand.halfLength[1] * absR[0][0];
        rb = obstacles.halfLength[1] * absR[2][2] + obstacles.halfLength[2] * absR[2][1];
        if (Math.abs(t[1] * r[0][0] - t[0] * r[1][0]) > ra + rb)
            return false;

        //A2*B1
        ra = hand.halfLength[0] * absR[1][1] + hand.halfLength[1] * absR[0][1];
        rb = obstacles.halfLength[0] * absR[2][2] + obstacles.halfLength[2] * absR[2][0];
        if (Math.abs(t[1] * r[0][1] - t[0] * r[1][1]) > ra + rb)
            return false;

        //A2*B2
        ra = hand.halfLength[0] * absR[1][2] + hand.halfLength[1] * absR[0][2];
        rb = obstacles.halfLength[0] * absR[2][1] + obstacles.halfLength[1] * absR[2][0];
        if (Math.abs(t[1] * r[0][2] - t[0] * r[1][2]) > ra + rb)
            return false;
        return true;
    }

    double Dot(Vector a, Vector b) {
        double ret = 0;
        ret += a.vextorX * b.vextorX;
        ret += a.vextorY * b.vextorY;
        ret += a.vextorZ * b.vextorZ;
        return ret;
    }


}
