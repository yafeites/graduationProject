package generatePointCloud;

import PathPlanning.Point;

import java.util.List;
import java.util.Scanner;

/**
 * @author 汪一江
 * @Destriction
 * @Date 2021/1/5
 */
public class ObbEnvelope {
    public static void main(String[] args) {

    }
    public  static  void printeigenvector()
    {
        double arr[][]=new double[3][3];
        Scanner scanner=new Scanner(System.in);
        for(int i=0;i<3;i++)
        {
            String s=scanner.nextLine();
            String []strings=s.split(" ");
            for (int j = 0; j <strings.length ; j++) {
                arr[i][j]=Double.parseDouble(strings[j]);
            }
        }

    }

    public  static  void generateEnvelopObb(List<Point>points)
    {
        int size=points.size();
        double[] []pointsarr=new double[3][size];
        for (int i = 0; i <points.size() ; i++) {
            Point point = points.get(i);
            pointsarr[0][i]=point.x;
            pointsarr[1][i]=point.y;
            pointsarr[2][i]=point.z;

        }
        double avg[]=new double[3];
        avg[0]=0;
        avg[1]=0;
        avg[2]=0;

        for(int i=0;i<points.size();i++) {
            Point point = points.get(i);

            avg[0] += point.x;
            avg[1] += point.y;
            avg[2] += point.z;
        }
        avg[0]/=size;
        avg[1]/=size;
        avg[2]/=size;
        double [][]arr=new double[3][3];
        for(int i=0;i<arr.length;i++)
        {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j]=cov(i,j,pointsarr,avg);

            }
        }
            printArr(arr);
    }

    private static void printArr(double[][] arr) {
        String s="A=[";
        for(int i=0;i<arr.length;i++)
        {

            for (int j = 0; j <arr[0].length ; j++) {
                if(j==arr[0].length-1)
                {
                    s+=arr[i][j]+";";
                }
                else
                s+=arr[i][j]+",";
            }
        }
        s+="]";
        System.out.println(s);

    }

    private static double cov(int i, int j, double[][] points, double[] avg) {
        double ret=0;
        int size=points[0].length-1;
        for (int k = 0; k <size+1 ; k++) {
            ret+=(points[i][k]-avg[i])*(points[j][k]-avg[j]);
        }
        ret/=size;
        return ret;
    }

}
