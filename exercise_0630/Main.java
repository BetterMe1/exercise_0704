package exercise.exercise_0630;


/*
数字分类 (20)

给定一系列正整数，请按要求对数字进行分类，并输出以下5个数字：
A1 = 能被5整除的数字中所有偶数的和；
A2 = 将被5除后余1的数字按给出顺序进行交错求和，即计算n1-n2+n3-n4...；
A3 = 被5除后余2的数字的个数；
A4 = 被5除后余3的数字的平均数，精确到小数点后1位；
A5 = 被5除后余4的数字中最大数字。
输入描述:
每个输入包含1个测试用例。每个测试用例先给出一个不超过1000的正整数N，
随后给出N个不超过1000的待分类的正整数。数字间以空格分隔。
输出描述:
对给定的N个正整数，按题目要求计算A1~A5并在一行中顺序输出。数字间以空格分隔，但行末不得有多余空格。
若其中某一类数字不存在，则在相应位置输出“N”。
示例1
输入
13 1 2 3 4 5 6 7 8 9 10 20 16 18
输出
30 11 2 9.7 9
 */
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean[] A = new boolean[6];
        int n = sc.nextInt();
        int[] a = new int[6];
        boolean a2_f = true;
        int a4_count = 0;
        for(int i=0; i<n; i++){
            int num = sc.nextInt();
            if(num%10==0){
                a[1]+=num;
                A[1]=true;
            }else if(num%5==1){
                if(a2_f){
                    a[2] += num;
                    a2_f = false;
                }else{
                    a[2] -= num;
                    a2_f = true;
                }
                A[2] = true;
            }else if(num%5==2){
                a[3]++;
                A[3] = true;
            }else if(num%5==3){
                a[4] += num;
                a4_count++;
                A[4] = true;
            }else if(num%5==4){
                a[5] = Math.max(num,a[5]);
                A[5] = true;
            }
        }
        for(int i=1; i<6;i++){
            if(A[i] == false){
                System.out.print("N");
            }else{
                if(i!=4){
                    System.out.print(a[i]);
                }else{
                    double tmp =((double)a[i])/a4_count;
                    System.out.print(String.format("%.1f",tmp));
                }
            }
            if(i!=5){
                System.out.print(" ");
            }else{
                System.out.println();
            }
        }
    }
}
