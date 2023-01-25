// Quoc Viet Phan
// 220364926
// Grade D
// Excercise 4
// Thu 6 Oct

// The program will initiate a loop that will asking users the same questions for 7 times (7days)
// Each iteration, it will ask users to input following 2 questions
// First is how many visitors and second is how much money taken, it'll then add to the total for each input
// At the end of iteration, it'll use the total of visitors and moneyTaken, divided by 7 to get the average

import java.util.Scanner;
import java.lang.Math;

public class Main {

    public static float calculateAverage(int totalVisitors, float nDay){
        float averageVisitors = totalVisitors/nDay;
        averageVisitors = Math.round(averageVisitors); // Round up
        return averageVisitors;
    }

    public static void calculatingTicketEarns() {
        int visitors;
        int totalVisitors;
        float averageVisitors;
        float moneyTaken;
        float totalMoneyTaken;
        float nDay = 7;

        totalVisitors = 0;
        totalMoneyTaken = 0;

        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 7; i = i + 1) {
            System.out.println("Day " + i + ". How many visitors were there?");
            visitors = sc.nextInt(); // Getting input
            totalVisitors = totalVisitors + visitors; // Adding the number of visitor to the total
            System.out.println("How much money was taken (in pounds)?");
            moneyTaken = sc.nextFloat();
            totalMoneyTaken = totalMoneyTaken + moneyTaken;
            // Incremented next day
        }
        sc.close();

        averageVisitors = calculateAverage(totalVisitors, nDay);

        System.out.println("The average number of visitors per day was: " + averageVisitors);
        System.out.println("The total proceeds this week was (in pounds): " + totalMoneyTaken);
    }

    public static void main(String[] args) {
        calculatingTicketEarns();
    }
}
