package PathPlanning;

/**
 * @author 汪一江
 * @Destriction
 * @Date 2020/12/16
 */
public class Point {
    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    private   String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double x;
    public double y;
    public double z;

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        Point p=(Point)obj;
        return p.x==x&&p.y==y&&p.z==z;
    }

}
