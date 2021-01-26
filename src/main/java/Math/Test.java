package Math;

import PathPlanning.Point;
import PathPlanning.Utils;

/**
 * @author 汪一江
 * @Destriction
 * @Date 2020/12/3
 */
public class Test {

    public static void main(String[] args) {
//        System.out.println(650.0/1250);
//        System.out.println(Math.pow(1.3,0.33));0.008726535498373935
        Point  point=new Point(-300,399,1420);
        Point point1=new Point(1390,-420,-180);
            System.out.println(Utils.getDistance(point1,point));
            System.out.println(3000*Utils.sin(0.25));

    }
}
