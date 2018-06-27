import java.awt.*;
import java.util.ArrayList;

public class TestDrive0 {
    public static void main(String[] args) {
        String testString1 = "2x^2+10x+7";
        String testString2 = "4x^3+10x^2+2x+8";
        String testString3 = "x+1";
        String testString4 = "x^2";
        String testString5 = "5x";

        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add(testString1);
        stringArrayList.add(testString2);
        stringArrayList.add(testString3);
        stringArrayList.add(testString4);
        stringArrayList.add(testString5);

//        String[] strings = testString1.split("[+,-]",10);
//        for (String str : strings) {
//            System.out.println(str);
//        }

//        System.out.println(Math.pow(10,0));

        int[][] poly;
        int[][] poly_test_1 = {{3,2},{2,1},{3,0}};
        int[][] poly_test_2 = {{4,3},{-2,2},{1,1},{-1,0}};

        poly = poly_test_1;

        for (int[] ints : poly) {
            for (int i : ints) {
                System.out.println(i);
            }
        }

    }
}
