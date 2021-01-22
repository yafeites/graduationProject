package PathPlanning;

/**
 * @author 汪一江
 * @Destriction
 * @Date 2020/12/16
 */
public class handJointInfo {

    double theta1;
    double theta2;
    double theta3;
    double theta4;
    double degree;
    Point point;

    public handJointInfo(double theta1, double theta2, double theta3, double theta4, double degree, Point point) {
        this.theta1 = theta1;
        this.theta2 = theta2;
        this.theta3 = theta3;
        this.theta4 = theta4;
        this.degree = degree;
        this.point = point;
    }

    @Override
    public String toString() {
        return "handJointInfo{" +
                "theta1=" + theta1 +
                ", theta2=" + theta2 +
                ", theta3=" + theta3 +
                ", theta4=" + theta4 +
                ", degree=" + degree +
                ", point=" + point +
                '}';
    }
}
