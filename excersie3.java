// Quoc Viet Phan
// 220364926
// Grade F
// Excercise 3
// Thu 6 Oct

import java.util.Scanner;

// The program promts users to input an answer for 2 questions
// The first one is age and the second is disability status
// It will then check whether the age meet criteria for child or elderly
// price will be halve if under 18 and price -3 pounds original price if elderly (65+)
// It will then calculate the currentPrice, afterward it will check for disability input prior
// It'll then use the current Price to verify whether users qualified for another 4 pounds discount
// Output the price

public class Main {
    public static int priceCalculation(int age, int fullPrice) {
        int calculatingPrice;
        if (age <= 18) // Checking age
        {
            calculatingPrice = fullPrice / 2;
        } else if (age >= 65) {
            calculatingPrice = fullPrice - 3;
        } else {
            calculatingPrice = fullPrice;
        }
        return calculatingPrice;
    }
    public static void calculatingCharges() {
        int fullPrice; // Declare variable
        int age; // Declare variable
        boolean isDisabled; // Declare variable
        int finalPrice; // Declare variable

        fullPrice = 10;

        Scanner sc = new Scanner(System.in);
        System.out.println("How old are you?");
        age = sc.nextInt(); // Getting input
        System.out.println("Are you registered disabled (Yes / No)?");
        sc.nextLine();
        String inputForBoolean = sc.nextLine(); // Getting input
        if (inputForBoolean.equals("Yes")) {
            isDisabled = true;
        } else {
            isDisabled = false;
        }
        sc.close();
        int calculatingPrice = priceCalculation(age, fullPrice);
        if (isDisabled) // Checking disability for further discount
        {
            finalPrice = calculatingPrice - 4;
        } else {
            finalPrice = calculatingPrice;
        }

        if (finalPrice == 1) // Output the price
        {
            System.out.println("The swimming pool charge for you is " + finalPrice + " pound.");
        } else {
            System.out.println("The swimming pool charge for you is " + finalPrice + " pounds.");
        }

    }

    public static void main(String[] args) {
        calculatingCharges();
    }

}
