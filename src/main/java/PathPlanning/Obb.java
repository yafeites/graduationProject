package PathPlanning;

/**
 * @author 汪一江
 * @Destriction
 * @Date 2020/12/16
 */
public class Obb {

    public Obb(String name, Point point, Vector[] vectors, double[]  halfLength) {
        this.name = name;
        this.point = point;
        this.vectors = vectors;
        this.halfLength = halfLength;
    }

    public String name;
    public Point point;
    public  Vector[] vectors;
    public double[] halfLength;
}
