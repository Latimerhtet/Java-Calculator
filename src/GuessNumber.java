import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Random ran = new Random();
        int randomNum = ran.nextInt(51);
        System.out.println("Game to guess the number from 1 to 50 !");
        int i = 0;
        while(i <= 5){
            if(i==5){
                System.out.println("You have reached the maximum times to guess! Try new one!");
                System.out.println("The number is " + randomNum);
                break;
            }
            Scanner scanner = new Scanner(System.in);
            System.out.print("Guess number : ");
            int inputNum = scanner.nextInt();

            if(inputNum < randomNum) {
                System.out.println("The number is greater than " + inputNum );
            }else if(inputNum == randomNum){
                System.out.println("Congratulations!! You have guessed the correct number!");
                break;
            }else {
                System.out.println("The number is less than " + inputNum);
            }
            i++;
        }


    }




}
