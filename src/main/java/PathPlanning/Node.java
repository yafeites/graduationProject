package PathPlanning;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 汪一江
 * @Destriction
 * @Date 2020/12/16
 */
public class Node {
    ThirdDTree thirdDTree;
    KdTree tree;
    int level;
    int kdlevel;
    Node root;
    Node father;
    List<Node> sons;

    public Node getKdFather() {
        return kdFather;
    }

    public void setKdFather(Node kdFather) {
        this.kdFather = kdFather;
    }

    public Node getKdleftson() {
        return kdleftson;
    }

    public void setKdleftson(Node kdleftson) {
        this.kdleftson = kdleftson;
    }

    public Node getKdrightson() {
        return kdrightson;
    }

    public void setKdrightson(Node kdrightson) {
        this.kdrightson = kdrightson;
    }

    Point point;
    Node kdFather;
    Node kdleftson;
    Node kdrightson;
    public Node() {
        sons=new ArrayList<>();
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    void addAttr(Node node)
    {
        tree=node.tree;
//        thirdDTree=node.thirdDTree;
        level=node.level+1;
        root=node.root;
        father=node;
        node.addSon(this);
    }

    private void addSon(Node node) {
        sons.add(node);
    }

    public KdTree getTree() {
        return tree;
    }
    public ThirdDTree getThirdDTree() {
        return thirdDTree;
    }

    public void setTree(KdTree tree) {
        this.tree = tree;
    }
    public void setTree(ThirdDTree tree) {
        this.thirdDTree = tree;
    }
}
