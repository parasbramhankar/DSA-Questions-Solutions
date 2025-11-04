package Recursion.Easy.AddDigits258;

import java.util.Scanner;

public class RecursiveSolution {

    static int findSum(int num){
        if(num<10){
            return num;
        }

        return num%10+findSum(num/10);
    }
    static int solution(int num){
        int sum=findSum(num);

        if(sum<10){
            return sum;
        }

        return solution(sum);
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int num=scanner.nextInt();

        int sumOfDigits=solution(num);

        System.out.println("Sum: "+sumOfDigits);
    }
}
