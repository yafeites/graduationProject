package PathPlanning;

/**
 * @author 汪一江
 * @Destriction
 * @Date 2020/12/16
 */
public class BaseHandInfo {
    public static void main(String[] args) {
        System.out.println(Utils.acos((L1_AB*L1_AB+ L1*L1 - L1_BC*L1_BC)/(2*L1_AB*L1)));
    }
    //铲斗与水平方向夹角
    static final double thetaPoint =-90.0;
    //todo
    //基本信息
    static final double L1=1350;
    //大臂三角形前杆长
    static final double L1_AB=1000;
    //大臂三角形上赶长
    static final double L1_BC=850;
    static final double L2=700;
    static final double L3=390;
    //大臂关节与旋转平台水平距离
    static final double a0 =440;
    //旋转平台与基坐标高度差
    static final double d0=320;
    static final double arm1_x=1000;
    static final double arm1_y=200;
    static final double arm1_z=200;
    static final double arm2_x=850;
    static final double arm2_y=200;
    static final double arm2_z=200;
    static final double dipper_x=700;
    static final double dipper_y=200;
    static final double dipper_z=200;
    static final double bucket_x=390;
    static final double bucket_y=200;
    static final double bucket_z=200;
    static final double theta2e =Utils.acos((L1_AB*L1_AB+ L1*L1 - L1_BC*L1_BC)/(2*L1_AB*L1));
    static Obb arm1 = new Obb("arm1",
            new Point(0,0,0)
            ,new Vector[]{
            new Vector(0,0,0)
            ,new Vector(0,0,0)
            ,new Vector(0,0,0)}
            ,new double[]{BaseHandInfo.arm1_x/2,BaseHandInfo.arm1_y/2,BaseHandInfo.arm1_z/2});
    static Obb arm2 = new Obb("arm2",
            new Point(0,0,0),
            new Vector[]{new Vector(0,0,0)
                    ,new Vector(0,0,0)
                    ,new Vector(0,0,0)},
            new double[]{arm2_x/2,arm2_y/2,arm2_z/2});
    static Obb dipper = new Obb("dipper",
            new Point(0,0,0),
            new Vector[]{new Vector(0,0,0)
        ,new Vector(0,0,0)
            ,new Vector(0,0,0)},
            new double[]{dipper_x/2,dipper_y/2,dipper_z/2});
    static Obb bucket = new Obb("bucket",
            new Point(0,0,0),
            new Vector[]{new Vector(0,0,0)
                    ,new Vector(0,0,0)
                    ,new Vector(0,0,0)},
            new double[]{bucket_x/2,bucket_y/2,bucket_z/2});
    static Obb[] hands = new Obb[]{
            arm1,
            arm2,
            dipper,
            bucket};

    static  Point pb=new Point(0,0,0);
    static  Point pc=new Point(0,0,0);
    static  Point pd=new Point(0,0,0);

    static  double getTheta2f(double theta2,double theta2t)
    {
        return Utils.acos((L1*Utils.cos(theta2)-L1_AB*Utils.cos(theta2t))/L1_BC);
    }


    public static  void  changehand(handJointInfo  currentHandJointInfo) {
        double theta1=currentHandJointInfo.theta1;
        double theta2=currentHandJointInfo.theta2;
        double theta3=currentHandJointInfo.theta3;
        double theta4=currentHandJointInfo.theta4;
        double theta2t=currentHandJointInfo.theta2+theta2e;
        double theta2f=getTheta2f(theta2,theta2t);
        double x=currentHandJointInfo.point.x;
        double y=currentHandJointInfo.point.y;
        double z=currentHandJointInfo.point.z;
        arm1.point.x = L1_AB
                * Utils.cos(theta1)
                *Utils.cos(theta2t)/2
                + a0
                * Utils.cos(theta1);
        arm1.point.y = L1_AB
                * Utils.cos(theta2t)
                * Utils.sin(theta1)/ 2
                + a0 * Utils.sin(theta1);
        arm1.point.z =  L1_AB
                *Utils.sin(theta2t)/2
                +d0;
        arm1.vectors[0].vextorX=  Utils.cos(theta1) *Utils.cos(theta2t);
        arm1.vectors[0].vextorY =   Utils.sin(theta1)*Utils.cos(theta2t);
        arm1.vectors[0].vextorZ =  Utils.sin(theta2t);
        arm1.vectors[1].vextorX =   -Utils.cos(theta1) *Utils.sin(theta2t);
        arm1.vectors[1].vextorY =   -Utils.sin(theta1) *Utils.sin(theta2t);
        arm1.vectors[1].vextorZ =  Utils.cos(theta2t);
        arm1.vectors[2].vextorX =   Utils.sin(theta1);
        arm1.vectors[2].vextorY =   -Utils.cos(theta1);
        arm1.vectors[2].vextorZ =   0;
        pb.x=L1_AB*Utils.cos(theta1)*Utils.cos(theta2t)+a0*Utils.cos(theta1);
        pb.y=L1_AB*Utils.cos(theta2t)*Utils.sin(theta1)+a0*Utils.sin(theta1);
        pb.z=L1_AB*Utils.sin(theta2t)+d0;
        pc.x=L1*Utils.cos(theta1)*Utils.cos(theta2)+a0*Utils.cos(theta1);
        pc.y=L1*Utils.cos(theta2)*Utils.sin(theta1)+a0*Utils.sin(theta1);
        pc.z=L1*Utils.sin(theta2)+d0;
        arm2.point.x=(pb.x+pc.x)/2;
        arm2.point.y=(pb.y+pc.y)/2;
        arm2.point.z=(pb.z+pc.z)/2;
        arm2.vectors[0].vextorX=Utils.cos(theta1)*Utils.cos(theta2f);
        arm2.vectors[0].vextorY=Utils.sin(theta1)*Utils.cos(theta2f);
        arm2.vectors[0].vextorZ=Utils.sin(theta2f);
        arm2.vectors[1].vextorX=-Utils.cos(theta1)*Utils.sin(theta2f);
        arm2.vectors[1].vextorY=-Utils.sin(theta1)*Utils.sin(theta2f);
        arm2.vectors[1].vextorZ=Utils.cos(theta2f);
        arm2.vectors[2].vextorX=Utils.sin(theta1);
        arm2.vectors[2].vextorY=-Utils.cos(theta1);
        arm2.vectors[2].vextorZ=0;

        pd.x=pc.x+L2*Utils.cos(theta1)*Utils.cos(theta2+theta3);
        pd.y=pc.y+L2*Utils.cos(theta2+theta3)*Utils.sin(theta1);
        pd.z=pc.z+L2*Utils.sin(theta2+theta3);
        dipper.point.x=(pc.x+pd.x)/2;
        dipper.point.y=(pc.y+pd.y)/2;
        dipper.point.z=(pc.z+pd.z)/2;
        dipper.vectors[0].vextorX=Utils.cos(theta1)*Utils.cos(theta2+theta3);
        dipper.vectors[0].vextorY=Utils.sin(theta1)*Utils.cos(theta2+theta3);
        dipper.vectors[0].vextorZ=Utils.sin(theta2+theta3);
        dipper.vectors[1].vextorX=-Utils.cos(theta1)*Utils.sin(theta2+theta3);
        dipper.vectors[1].vextorY=-Utils.sin(theta1)*Utils.sin(theta2+theta3);
        dipper.vectors[1].vextorZ=Utils.cos(theta2+theta3);
        dipper.vectors[2].vextorX=Utils.sin(theta1);
        dipper.vectors[2].vextorY=-Utils.cos(theta1);
        dipper.vectors[2].vextorZ=0;

        bucket.vectors[0].vextorX=Utils.cos(theta1)*Utils.cos(thetaPoint);
        bucket.vectors[0].vextorY=Utils.sin(theta1)*Utils.cos(thetaPoint);
        bucket.vectors[0].vextorZ=Utils.sin(thetaPoint);
        bucket.vectors[1].vextorX=-Utils.cos(theta1)*Utils.sin(thetaPoint);
        bucket.vectors[1].vextorY=-Utils.sin(theta1)*Utils.sin(thetaPoint);
        bucket.vectors[1].vextorZ=Utils.cos(thetaPoint);
        bucket.vectors[2].vextorX=Utils.sin(theta1);
        bucket.vectors[2].vextorY=-Utils.cos(theta1);
        bucket.vectors[2].vextorZ=0;
        bucket.point.x=(x+pd.x)/2+bucket_y/2*Utils.cos(theta1)*Utils.sin(thetaPoint);
        bucket.point.y=(y+pd.y)/2+bucket_y/2*Utils.sin(theta1)*Utils.sin(thetaPoint);
        bucket.point.z=(z+pd.z)/2+bucket_y/2*Utils.cos(thetaPoint);

    }

}
