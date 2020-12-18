package PathPlanning;

/**
 * @author 汪一江
 * @Destriction
 * @Date 2020/12/16
 */
public class BaseHandInfo {

    //铲斗与水平方向夹角
    static final double thetaPoint =-180;
    //todo
    //基本信息
    static final double L1=1350;
    //大臂三角形前杆长
    static final double L1_AB=0;
    //大臂三角形上赶长
    static final double L1_BC=0;
    static final double L2=700;
    static final double L3=390;
    //大臂关节与旋转平台水平距离
    static final double a0 =440;
    //旋转平台与基坐标高度差
    static final double d0=320;
    static final double arm1_x=0;
    static final double arm1_y=0;
    static final double arm1_z=0;
    static final double arm2_x=0;
    static final double arm2_y=0;
    static final double arm2_z=0;
    static final double dipper_x=0;
    static final double dipper_y=0;
    static final double dipper_z=0;
    static final double bucket_x=0;
    static final double bucket_y=0;
    static final double bucket_z=0;
    static final double diffTheta2Theta2t =Math.toDegrees(Math.acos((L1_AB*L1_AB+
            L1*L1 -
            L1_BC*L1_BC)/(2*L1_BC*L1)));

    static  double getTheta2f(double theta2,double theta2t)
    {
        return Math.toDegrees((L1*Math.cos(theta2)-L1_AB*theta2t)/L1_BC);
    }


}
