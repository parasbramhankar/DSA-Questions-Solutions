package Mathematics.Medium.PrimeFactor2521;


//If we remove the multiple of the 2 and 3, we reduce the numbers of the iterations,
//i.e., we need it to not compare with the 4 6, 9 etc. we already play with that number using the 2 or 3 ,
// same as we did in prime number check
//Then we start a loop from 5 up to the sqrt(n) with increment of +6,
//Now we find the i and (i+2) prime factor


import java.util.Scanner;



public class OptimizeSolution {
    static void printPrimeFactor(int num){
        while(num%2==0){
            System.out.print(2+" ");
            num/=2;
        }

        while(num%3==0){
            System.out.print(3+" ");
            num/=3;
        }

        for(int i=5;i<=Math.sqrt(num);i+=6){

            while(num%i==0){
                System.out.print(i+" ");
                num/=i;
            }

            while(num%(i+2)==0){
                System.out.print((i+2)+" ");
                num/=(i+2);
            }

        }

        if(num>3){
            System.out.print(num);
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int num= scanner.nextInt();

        printPrimeFactor(num);

        scanner.close();
    }

}
