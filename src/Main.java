import java.util.Scanner;
import java.math.BigInteger;
public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[10];
        int testNum = sc.nextInt();
        int testSub = 0;
        int[] result = new int[testNum];
        while(testSub < testNum) {
            for (int i = 0; i < 10; i++) {
                numbers[i] = sc.nextInt();
                if(numbers[i]%2==1) result[testSub]+=numbers[i];
            }
            testSub++;
        }
        for (int j=0; j<testNum; j++){
            System.out.printf("#%d %d\n",j,result[j]);
        }
    }
}