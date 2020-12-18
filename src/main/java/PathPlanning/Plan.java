package PathPlanning;


/**
 * @author 汪一江
 * @Destriction
 * @Date 2020/12/16
 */
public class Plan {
    static handJointInfo initHandJointInfo = new handJointInfo(0, 0, 0, 0,0, new Point(0, 0, 0));

    static handJointInfo currentHandJointInfo = new handJointInfo(0, 0, 0, 0, 0,new Point(0, 0, 0));
    //todo
    //挖掘机手臂obb
    static Obb arm1 = new Obb("arm1",
            new Point(BaseHandInfo.L1_AB*Math.cos(Math.toRadians(currentHandJointInfo.theta1))
                    *(Math.cos(Math.toRadians(currentHandJointInfo.theta2 +BaseHandInfo.diffTheta2Theta2t)))
                    +BaseHandInfo.a0
                    *Math.cos(Math.toRadians(currentHandJointInfo.theta1)),
                    BaseHandInfo.L1_AB
                     *(Math.cos(Math.toRadians(currentHandJointInfo.theta2 +BaseHandInfo.diffTheta2Theta2t)))
                     *Math.sin(Math.toRadians(currentHandJointInfo.theta1))/2
                    +BaseHandInfo.a0*currentHandJointInfo.theta1,
                    BaseHandInfo.L1_AB
                     *(Math.sin(Math.toRadians(currentHandJointInfo.theta2 +BaseHandInfo.diffTheta2Theta2t)))
                     +BaseHandInfo.d0)
            ,new Vector[]{
            new Vector(Math.cos(Math.toRadians(currentHandJointInfo.theta1))
                    *Math.cos(Math.toRadians(currentHandJointInfo.theta2 +BaseHandInfo.diffTheta2Theta2t))
                    ,Math.sin(Math.toRadians(currentHandJointInfo.theta1))
                            *Math.cos(Math.toRadians(currentHandJointInfo.theta2 +BaseHandInfo.diffTheta2Theta2t))
                    , Math.sin(Math.toRadians(currentHandJointInfo.theta2 +BaseHandInfo.diffTheta2Theta2t)))
            ,new Vector(-Math.cos(Math.toRadians(currentHandJointInfo.theta1))
            *Math.sin(Math.toRadians(currentHandJointInfo.theta2 +BaseHandInfo.diffTheta2Theta2t))
                    ,-Math.sin(Math.toRadians(currentHandJointInfo.theta1))
            *Math.sin(Math.toRadians(currentHandJointInfo.theta2 +BaseHandInfo.diffTheta2Theta2t))
                    ,Math.cos(Math.toRadians(currentHandJointInfo.theta2 +BaseHandInfo.diffTheta2Theta2t)))
            ,new Vector(Math.sin(Math.toRadians(currentHandJointInfo.theta1))
                    ,-Math.sin(Math.toRadians(currentHandJointInfo.theta1))
                        ,0)}
            ,new double[]{BaseHandInfo.arm1_x,BaseHandInfo.arm1_y,BaseHandInfo.arm1_z});
    static Obb arm2 = new Obb("arm2",
            new Point(0,0,0),
            new Vector[3],
            new double[3]);
    static Obb dipper = new Obb("dipper",
            new Point(0,0,0),
            new Vector[3],
            new double[3]);
    static Obb bucket = new Obb("bucket",
            new Point(0,0,0),
            new Vector[3],
            new double[3]);
    static Obb[] hands = new Obb[]{
            arm1,
            arm2,
            dipper,
            bucket};

    public static void main(String[] args) {
        Plan p=new Plan();
        Node start=new Node();
        start.root=start;
        start.level=1;
        start.point=new Point(1330,0,280);
        Node end=new Node();
        end.root=end;
        end.level=1;
        end.point=new Point(2880,0,0);
        Obb[]obstacles=new Obb[1];
        Vector vectorX=new Vector(1,0,0);
        Vector vectorY=new Vector(0,1,0);
        Vector vectorZ=new Vector(0,0,1);
        Vector[]vectors=new Vector[]{vectorX,vectorY,vectorZ};

        Obb obbA=new Obb("obstacle1",new Point(1890,0,65),vectors,new double[]{10,10,10});
        Obb obbB=new Obb("obstacle2",new Point(1906,0,65),vectors,new double[]{5,5,5});
        obstacles[0]=obbA;
//        handJointInfo handJointInfo=p.reCalculateDegree(new Point(860,0,740));
//        System.out.println("theta1: "+handJointInfo.theta1+" theta2: "+handJointInfo.theta2+" theta3: "+handJointInfo.theta3+
//                "theta4: "+handJointInfo.theta4 );
            System.out.println(p.intersectionTest(obbA,obbB));
//        p.func(start,end,obstacles);

    }

    public void func(Node start, Node end, Obb[] obstacles) {
        Node initNode=start;
        Node targetNode=end;
        Vector force=new Vector(0,0,0);
        while (true)
        {
            if(Utils.getDistance(initNode.point,targetNode.point)<APFInfo.stepLength)
            {
                break;
            }
            //计算人工势能场引力
            Vector attractiveVector=new Vector(0,0,0);
            attractiveVector.vextorX=targetNode.point.x-initNode.point.x;
            attractiveVector.vextorY=targetNode.point.y-initNode.point.y;
            attractiveVector.vextorZ=targetNode.point.z-initNode.point.z;
            Utils.standardization(attractiveVector);
            double forceAtt=0.5*Math.pow(Utils.getDistance(targetNode.point,initNode.point)*APFInfo.attractiveForceRatio,2);
//            double[] forceAttVect=new double[3];
            force.vextorX+=attractiveVector.vextorX*forceAtt;
            force.vextorY+=attractiveVector.vextorY*forceAtt;
            force.vextorZ+=attractiveVector.vextorZ*forceAtt;
            //计算斥力
            for (int i = 0; i <obstacles.length ; i++) {
                double distance=Utils.getDistance(obstacles[i].point,initNode.point);
                if(distance>APFInfo.minimumDistance2Obstacle)
                {
                    continue;
                }
                Vector repulsiveVector=new Vector(0,0,0);
                repulsiveVector.vextorX=-obstacles[i].point.x+initNode.point.x;
                repulsiveVector.vextorY=-obstacles[i].point.y+initNode.point.y;
                repulsiveVector.vextorZ=-obstacles[i].point.z+initNode.point.z;
                Utils.standardization(attractiveVector);
                double forceRep=0.5*APFInfo.repulsiveForceRatio*Math.pow
                (1/distance-1/APFInfo.minimumDistance2Obstacle,2);
                force.vextorX+=repulsiveVector.vextorX*forceRep;
                force.vextorY+=repulsiveVector.vextorY*forceRep;
                force.vextorZ+=repulsiveVector.vextorZ*forceRep;
            }
            Utils.standardization(force);
            force.vextorX*=APFInfo.stepLength;
            force.vextorY*=APFInfo.stepLength;
            force.vextorZ*=APFInfo.stepLength;
            Point point=new Point(force.vextorX+initNode.point.x,force.vextorY+initNode.point.y
            ,force.vextorZ+initNode.point.z);
            handJointInfo handJointInfo= reCalculateDegree(point);
            fillObb(handJointInfo);
            boolean isIntersection=false;
            for (int i = 0; i <obstacles.length ; i++) {
                for (int j = 0; j <hands.length; j++) {
                    if(intersectionTest(hands[j],obstacles[i]))
                    {
                        isIntersection=true;
                        break;
                            //todo
                            //相交计算
                    }

                }
            }
            if(!isIntersection)
            {
                Node newNode=new Node();
                newNode.point=point;
                newNode.father=initNode;
                newNode.level=initNode.level+1;
                newNode.root=initNode.root;
                initNode.son=newNode;
                initNode=newNode;
                System.out.println("x:"+newNode.point.x+" y:"+newNode.point.y+" z:"+newNode.point.z);
            }
            force.vextorX=0;
            force.vextorZ=0;
            force.vextorY=0;

        }

    }

    //逆运算关节角度
    public  handJointInfo reCalculateDegree(Point point) {
        double theta1 = Math.toDegrees(Math.atan2(point.y,point.x));
        double xs=Math.sqrt(point.x*point.x+point.y*point.y)-BaseHandInfo.a0;
        double ys=point.z-BaseHandInfo.d0;
        double x3=xs-BaseHandInfo.L3*Math.cos(Math.toRadians(BaseHandInfo.thetaPoint));
        double y3=ys-BaseHandInfo.L3*Math.sin(Math.toRadians(BaseHandInfo.thetaPoint));
        double theta3=-Math.toDegrees(Math.acos((x3*x3+y3*y3-Math.pow(BaseHandInfo.L1,2)-Math.pow(BaseHandInfo.L2,2))
                /(2*BaseHandInfo.L1*BaseHandInfo.L2)));
        double k1=BaseHandInfo.L1+BaseHandInfo.L2* Math.cos(Math.toRadians(theta3));
        double k2=BaseHandInfo.L2* Math.sin(Math.toRadians(theta3));
        double theta2=Math.toDegrees(Math.atan2(y3,x3)-Math.atan2(k2,k1));
        double theta4=BaseHandInfo.thetaPoint-theta2-theta3;
        handJointInfo ret=new handJointInfo(theta1,theta2,theta3,theta4,BaseHandInfo.thetaPoint,point);
        return  ret;
    }

    public void fillObb(handJointInfo handJointInfo) {
            currentHandJointInfo.theta1 =handJointInfo.theta1;
            currentHandJointInfo.theta2 =handJointInfo.theta2;
            currentHandJointInfo.theta3 =handJointInfo.theta3;
            currentHandJointInfo.degree=handJointInfo.degree;
            currentHandJointInfo.point=handJointInfo.point;
    }

    //相交检测
    public boolean 	intersectionTest(Obb hand,Obb obstacles)
    {
        double ra,rb;
        double [][]r=new double[3][3];
        double [][]absR=new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                r[i][j]=Dot(hand.vectors[i],obstacles.vectors[j]);
                absR[i][j]=Math.abs(r[i][j])+1e-6;
            }
        }

        Vector t1 =new Vector(0,0,0);
        t1.vextorX=obstacles.point.x-hand.point.x;
        t1.vextorY=obstacles.point.y-hand.point.y;
        t1.vextorZ=obstacles.point.z-hand.point.z;
        t1.vextorX=Dot(t1,hand.vectors[0]);
        t1.vextorY=Dot(t1,hand.vectors[1]);
        t1.vextorZ=Dot(t1,hand.vectors[2]);
        double[]t=new double[3];
        t[0]=t1.vextorX;
        t[1]=t1.vextorY;
        t[2]=t1.vextorZ;

        for (int i = 0; i < 3; i++) {
                ra=hand.halfLength[i];
                rb=obstacles.halfLength[0]*absR[i][0]
                        +obstacles.halfLength[1]*absR[i][1]
                        +obstacles.halfLength[2]*absR[i][2];
                if(Math.abs(t[i])>ra+rb)
                    return false;
        }
        for (int i = 0; i < 3; i++) {
            ra=hand.halfLength[0]*absR[0][i]
                    +hand.halfLength[1]*absR[1][i]
                    +hand.halfLength[2]*absR[2][i];
            rb=obstacles.halfLength[i];
            if(Math.abs(t[0]*r[0][i]+t[1]*r[1][i]+t[2]*r[2][i])>ra+rb)
                return false;
        }
        //A0*B0
        ra=hand.halfLength[1]*absR[2][0]+hand.halfLength[2]*absR[1][0];
        rb=obstacles.halfLength[1]*absR[0][2]+obstacles.halfLength[2]*absR[0][1];
        if(Math.abs(t[2]*r[1][0]-t[1]*r[2][0])>ra+rb)
            return false;

        //A0*B1
        ra=hand.halfLength[1]*absR[2][1]+hand.halfLength[2]*absR[1][1];
        rb=obstacles.halfLength[0]*absR[0][2]+obstacles.halfLength[2]*absR[0][0];
        if(Math.abs(t[2]*r[1][1]-t[1]*r[2][1])>ra+rb)
            return false;

        //A0*B2
        ra=hand.halfLength[1]*absR[2][2]+hand.halfLength[2]*absR[1][2];
        rb=obstacles.halfLength[0]*absR[0][1]+obstacles.halfLength[1]*absR[0][0];
        if(Math.abs(t[2]*r[1][2]-t[1]*r[2][2])>ra+rb)
            return false;

        //A1*B0
        ra=hand.halfLength[0]*absR[2][0]+hand.halfLength[2]*absR[0][0];
        rb=obstacles.halfLength[1]*absR[1][2]+obstacles.halfLength[2]*absR[1][1];
        if(Math.abs(t[0]*r[2][0]-t[2]*r[0][0])>ra+rb)
            return false;

        //A1*B1
        ra=hand.halfLength[0]*absR[2][1]+hand.halfLength[2]*absR[0][1];
        rb=obstacles.halfLength[0]*absR[1][2]+obstacles.halfLength[2]*absR[1][0];
        if(Math.abs(t[0]*r[2][1]-t[2]*r[0][1])>ra+rb)
            return false;

        //A1*B2
        ra=hand.halfLength[0]*absR[2][2]+hand.halfLength[2]*absR[0][2];
        rb=obstacles.halfLength[0]*absR[1][1]+obstacles.halfLength[1]*absR[1][0];
        if(Math.abs(t[0]*r[2][2]-t[2]*r[0][2])>ra+rb)
            return false;

        //A2*B0
        ra=hand.halfLength[0]*absR[1][0]+hand.halfLength[1]*absR[0][0];
        rb=obstacles.halfLength[1]*absR[2][2]+obstacles.halfLength[2]*absR[2][1];
        if(Math.abs(t[1]*r[0][0]-t[0]*r[1][0])>ra+rb)
            return false;

        //A2*B1
        ra=hand.halfLength[0]*absR[1][1]+hand.halfLength[1]*absR[0][1];
        rb=obstacles.halfLength[0]*absR[2][2]+obstacles.halfLength[2]*absR[2][0];
        if(Math.abs(t[1]*r[0][1]-t[0]*r[1][1])>ra+rb)
            return false;

        //A2*B2
        ra=hand.halfLength[0]*absR[1][2]+hand.halfLength[1]*absR[0][2];
        rb=obstacles.halfLength[0]*absR[2][1]+obstacles.halfLength[1]*absR[2][0];
        if(Math.abs(t[1]*r[0][2]-t[0]*r[1][2])>ra+rb)
            return false;
        return  true;
    }
    double Dot(Vector a,Vector b)
    {
        double ret=0;
        ret+=a.vextorX*b.vextorX;
        ret+=a.vextorY*b.vextorY;
        ret+=a.vextorZ*b.vextorZ;
        return ret;
    }


}
