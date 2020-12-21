package PathPlanning;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 汪一江
 * @Destriction
 * @Date 2020/12/16
 */
public class Node {
    KdTree tree;
    int level;
    Node root;
    Node father;
    List<Node> sons;
    Point point;

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

    public void setTree(KdTree tree) {
        this.tree = tree;
    }
}
