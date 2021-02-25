package PathPlanning;

import javax.swing.plaf.IconUIResource;
import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

public class ThirdDTree {
    Stack<Node>stack=new Stack<>();
    public static void main(String[] args) {
        ThirdDTree thirdDTree = new ThirdDTree();
        KdTree kdTree = new KdTree();
        long time = System.currentTimeMillis();

        for (int i = 0; i < 30000; i++) {
            Node node = new Node();
            Point point = new Point(Math.random(), Math.random(), Math.random());
            node.setPoint(point);
            kdTree.insert(node);
        }
        for (int i = 0; i < 20000; i++) {
            Point point = new Point(Math.random(), Math.random(), Math.random());
//            System.out.println(kdTree.getNearestNode(point));
            kdTree.getNearestNode(point);
        }
        System.out.println(System.currentTimeMillis() - time);
        time = System.currentTimeMillis();
        for (int i = 0; i < 30000; i++) {
            Node node = new Node();
            Point point = new Point(Math.random(), Math.random(), Math.random());
            node.setPoint(point);
//            kdTree.insert(node);
            thirdDTree.insert(node);
        }
        for (int i = 0; i < 20000; i++) {
            Point point = new Point(Math.random(), Math.random(), Math.random());
            thirdDTree.getNearestNode(point);
//            kdTree.getNearestNode(point);
//            if (thirdDTree.getNearestNode(point).point.equals(kdTree.getNearestNode(point).point)) {
//                System.out.println(true);
//            }
//            System.out.println(thirdDTree.getNearestNode(point));
            thirdDTree.getNearestNode(point);


        }
        System.out.println(System.currentTimeMillis() - time);
    }

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Node root;
    List<Node> list = new ArrayList<>();

    public Node getRandNode() {
        int val = list.size();
        Random rand = new Random();
        return list.get(rand.nextInt(val));
    }

    public void insert(Node node) {
        list.add(node);
        if (root == null) {
            root = node;
            node.kdlevel = 0;
            return;
        }

        Node temp = root;
//        double nodearr[] = new double[3];
//        nodearr[0] = node.point.x;
//        nodearr[1] = node.point.y;
//        nodearr[2] = node.point.z;
        while (true) {
//            double arr[] = new double[3];
//            arr[0] = temp.point.x;
//            arr[1] = temp.point.y;
//            arr[2] = temp.point.z;
            int i = temp.kdlevel;
            double dif = 0;
            if (i == 0) {
                dif = node.point.x - temp.point.x;
            } else if (i == 1) {
                dif = node.point.y - temp.point.y;
            } else {
                dif = node.point.z - temp.point.z;
            }
            if (dif>=0) {
                if (temp.getKdrightson() != null) {
                    temp = temp.getKdrightson();
                    continue;
                } else {
                    temp.setKdrightson(node);
                    node.setKdFather(temp);
                    node.kdlevel = (temp.kdlevel + 1) % 3;
                    break;
                }
            } else {
                if (temp.getKdleftson() != null) {
                    temp = temp.getKdleftson();
                    continue;

                } else {
                    temp.setKdleftson(node);
                    node.setKdFather(temp);
                    node.kdlevel = (temp.kdlevel + 1) % 3;
                    break;

                }
            }
        }
    }


    public void setRoot(Node node) {
        root = node;
    }

    public Node getNearestNode(Node node) {
        return dfs(stack, root, node.point, null);
    }

    public Node getNearestNode(Point point) {
        Node node = new Node();
        node.setPoint(point);
        return dfs(stack, root, point, null);
    }

    public Node dfs(Stack<Node>stack, Node curNode, Point point, Node minNode) {
//        double nodearr[] = new double[3];
//        nodearr[0] = node.point.x;
//        nodearr[1] = node.point.y;
//        nodearr[2] = node.point.z;
//        boolean flag;
        int size =stack.size();
        double minDis;
        if (minNode == null) {
            minDis = Integer.MAX_VALUE;
        } else {
            minDis = Utils.getFakeDistance(point, minNode.point);
        }
        while (true) {
            stack.add(curNode);
//            double arr[] = new double[3];
//            arr[0] = curNode.point.x;
//            arr[1] = curNode.point.y;
//            arr[2] = curNode.point.z;
            int i = curNode.kdlevel;
            double dif = 0;
            if (i == 0) {
                dif = point.x - curNode.point.x;
            } else if (i == 1) {
                dif = point.y - curNode.point.y;
            } else {
                dif = point.z - curNode.point.z;
            }
//            if (nodearr[i] >= arr[i]) {
            if (dif >= 0) {
                if (curNode.getKdrightson() != null) {
                    curNode = curNode.getKdrightson();
                } else {
                    double dis = Utils.getFakeDistance(point, curNode.point);
                    if (dis < minDis) {
                        minNode = curNode;
                    }
                    return backTracking(point, stack, minNode, curNode, stack.size() - size);
//                    return backTracking(node, queue, minNode, curNode);

                }
            } else {
                if (curNode.getKdleftson() != null) {
                    curNode = curNode.getKdleftson();
                } else {
                    double dis = Utils.getFakeDistance(point, curNode.point);
                    if (dis < minDis) {
                        minNode = curNode;
                    }
                    return backTracking(point, stack, minNode, curNode, stack.size() - size);
//                    return backTracking(node, queue, minNode, curNode);

                }
            }
        }
    }

    //node为寻求最邻近结点
    //queue为回溯队列
    //minNode 为目前最邻近结点
    //leafNode 为当前搜寻的叶子结点
    public Node backTracking(Point point, Stack<Node>stack, Node minNode, Node leafNode, int size) {
//        public Node backTracking(Node node, LinkedList<Node> queue, Node minNode, Node leafNode) {

//        while (!queue.isEmpty()) {
            while (size!=0) {
//            double nodearr[] = new double[3];
//            nodearr[0] = node.point.x;
//            nodearr[1] = node.point.y;
//            nodearr[2] = node.point.z;
            Node cur = stack.pop();
            size--;
//            double arr[] = new double[3];
//            arr[0] = cur.point.x;
//            arr[1] = cur.point.y;
//            arr[2] = cur.point.z;
            int i = cur.kdlevel;
            double dif = 0;
            if (i == 0) {
                dif = cur.point.x - point.x;
            } else if (i == 1) {
                dif = cur.point.y - point.y;
            } else {
                dif = cur.point.z - point.z;
            }
            double dis = Utils.getFakeDistance(minNode.point, point);
//            if (Math.abs(arr[i] - nodearr[i]) >dis) {
            if (Math.pow(dif, 2) > dis) {
                continue;
            } else {
                if (Utils.getFakeDistance(cur.point, point) < dis) {
                    minNode = cur;
                }

                if (cur == leafNode) {
                    if (cur.getKdleftson() == null) {
                        cur = cur.getKdrightson();
                        if (cur != null) {
//                            minNode = dfs(new LinkedList<Node>(), cur, node, minNode);
                            minNode = dfs(stack, cur, point, minNode);

                        }
                    } else {
                        cur = cur.getKdleftson();
                        if (cur != null) {
//                            minNode = dfs(new LinkedList<Node>(), cur, node, minNode);
                            minNode = dfs(stack, cur, point, minNode);
                        }
                    }
                } else if (isLeft(cur, leafNode)) {
                    cur = cur.getKdrightson();
                    if (cur != null) {
//                        minNode = dfs(new LinkedList<Node>(), cur, node, minNode);
                        minNode = dfs(stack, cur, point, minNode);

                    }
                } else {
                    cur = cur.getKdleftson();
                    if (cur != null) {
//                        minNode = dfs(new LinkedList<Node>(), cur, node, minNode);
                        minNode = dfs(stack, cur, point, minNode);
                    }
                }
            }
        }
        return minNode;
    }

    private boolean isLeft(Node father, Node son) {
        Node temp = son;
        while (true) {
            try{
                if (temp.getKdFather() == father) {
                    if (father.getKdleftson() == temp) {
                        return true;
                    }
                    return false;
                } else {
                    temp = temp.getKdFather();
                }
            }
            catch (NullPointerException e)
            {
                System.out.println("i am here");
            }

        }
    }
}
