package generatePointCloud;

import PathPlanning.Point;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author 汪一江
 * @Destriction
 * @Date 2020/12/26
 */
public class surface {

    Map<Double, PriorityQueue<Point>>map;

    public surface() {
        this.map =new HashMap<>();

    }

    public Map<Double, PriorityQueue<Point>> getMap() {
        return map;
    }

    public void setMap(Map<Double, PriorityQueue<Point>> map) {
        this.map = map;
    }
}
