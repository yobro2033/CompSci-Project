// Quoc Viet Phan
// 220364926
// Grade B
// Excercise 6
// Fri 7 Oct

import java.util.Scanner;
import java.lang.Math;

public class Main {
    // Getting data input
    public static int[] collectingData() {
        int numberOfVehicals = 0;
        int totalNumberOfVehicals = 0;
        int bridgeRaiseTime = 0;

        System.out.println("RIVER BRIDGE SURVEY");
        Scanner sc = new Scanner(System.in);
        boolean noSpecialCode = true;
        while (noSpecialCode) // Looping the question how many vehicals waiting until the user input the
                              // string to break it.
        {
            try {
                System.out.println("How many vehicles are waiting?");
                String vehicalsCheck = sc.nextLine();
                if (vehicalsCheck == "ABC") {
                    totalNumberOfVehicals = totalNumberOfVehicals + numberOfVehicals;
                    bridgeRaiseTime = bridgeRaiseTime + 1;
                    noSpecialCode = false;
                } else {
                    numberOfVehicals = Integer.parseInt(vehicalsCheck);
                }
                totalNumberOfVehicals = totalNumberOfVehicals + numberOfVehicals;
                bridgeRaiseTime = bridgeRaiseTime + 1;
            } catch (Exception e) {
                System.out.println("ERROR INPUT");
            }
        }
        // Return the value in list included number of vehicals and bridgeRaiseTime
        int[] Object = { totalNumberOfVehicals, bridgeRaiseTime };
        return Object;
    }

    // Taking value to calculate average waiting time using Maths expression
    public static int calculatingAverageNumber(int totalNumberOfVehicals, int bridgeRaiseTime) {
        int averageWaiting;
        float calcNumber;

        calcNumber = totalNumberOfVehicals / (float) bridgeRaiseTime;
        averageWaiting = Math.round(calcNumber);
        return averageWaiting;
    }

    public static void main(String[] args) {
        int[] objectNew;
        int totalNumberOfVehicals;
        int bridgeRaiseTime;
        int averageWaiting;

        objectNew = collectingData();
        totalNumberOfVehicals = objectNew[0];
        bridgeRaiseTime = objectNew[1];

        averageWaiting = calculatingAverageNumber(totalNumberOfVehicals, bridgeRaiseTime);

        System.out.println("The bridge was raised " + bridgeRaiseTime + " times");
        System.out.println("A total of " + totalNumberOfVehicals + " vehicles had to wait.");
        System.out.println("An average of " + averageWaiting + " vehicles had to wait each time.");

    }

}
