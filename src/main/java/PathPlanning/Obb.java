package PathPlanning;

import java.util.Arrays;

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

    @Override
    public String toString() {
        return "Obb{" +
                "name='" + name + '\'' +
                ", point=" + point +
                ", vectors=" + Arrays.toString(vectors) +
                ", halfLength=" + Arrays.toString(halfLength) +
                '}';
    }

    public String name;
    public Point point;
    public  Vector[] vectors;
    public double[] halfLength;
}
