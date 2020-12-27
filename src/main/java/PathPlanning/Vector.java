package PathPlanning;

/**
 * @author 汪一江
 * @Destriction
 * @Date 2020/12/16
 */
public class Vector {
    public double vextorX;
    public double vextorY;
    public double vextorZ;

    public Vector(double vextorX, double vextorY, double vextorZ) {
        this.vextorX = vextorX;
        this.vextorY = vextorY;
        this.vextorZ = vextorZ;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "vextorX=" + vextorX +
                ", vextorY=" + vextorY +
                ", vextorZ=" + vextorZ +
                '}';
    }
    void  clean()
    {
        vextorX=0;
        vextorY=0;
        vextorZ=0;
    }
}
