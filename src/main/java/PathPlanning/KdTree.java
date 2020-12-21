package PathPlanning;

import java.util.*;

/**
 * @author 汪一江
 * @Destriction
 * @Date 2020/12/16
 */
public class KdTree {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    List<Node>list=new ArrayList<>();
    Node getNearestNode (Node node)
    {
        double distance=Double.MAX_VALUE;
        Node ret=null;
        for (Node n :list) {
            double dis=Utils.getDistance(n.point,node.point);
            if(dis<distance)
            {
                distance=dis;
                ret=n;
            }

        }
        return ret;

    }
    void insert(Node node)
    {
        list.add(node);
    }

    Node getRandNode()
    {
        int val=list.size();
        Random rand=new Random();
        return list.get(rand.nextInt(val));
    }


}
