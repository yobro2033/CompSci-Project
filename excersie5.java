// Quoc Viet Phan
// 220364926
// Grade C
// Excercise 5
// Thu 6 Oct

import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void creatingArray() {
        String playerName;
        int goals;
        int minutesPlay;
        double averageScore;
        int highestPosition;
        double ratioPerMinute;
        // int arrayPosition;

        String[] playerNameArray = new String[4];
        int[] goalsArray = new int[4];
        int[] minutesPlayArray = new int[4];
        double[] averageScoreArray = new double[4];

        System.out.println("Please name 4 footballers who played in Euro 22.");
        Scanner sc = new Scanner(System.in);

        int count = 0;
        for (int i = 0; i < 4; i = i + 1) {
            count = count + 1;
            // arrayPosition = i-1;
            System.out.println("Name a footballer (" + count + " / 4)?");
            playerName = sc.nextLine(); // Getting input
            System.out.println("How many goals did she score?");
            goals = sc.nextInt();
            System.out.println("How many minutes did she play for?");
            minutesPlay = sc.nextInt();
            float ninetyMinute = 90;
            ratioPerMinute = minutesPlay / ninetyMinute;
            averageScore = Math.round((goals / ratioPerMinute) * 10.0) / 10.0;
            playerNameArray[i] = playerName;
            goalsArray[i] = goals;
            minutesPlayArray[i] = minutesPlay;
            averageScoreArray[i] = averageScore;
            sc.nextLine();
            // Incremented next player
        }

        sc.close();

        highestPosition = getHighestScore(averageScoreArray);

        System.out.println("The highest scorer was " + playerNameArray[highestPosition] + " with "
                + averageScoreArray[highestPosition] + " goals per 90 minutes played");
        System.out.println("The details of the players are:");
        for (int i = 0; i < 4; i = i + 1) {
            System.out.println(playerNameArray[i] + ", " + goalsArray[i] + ", " + minutesPlayArray[i] + ", "
                    + averageScoreArray[i]);
        }

    }

    public static int getHighestScore(double[] averagesScoreArray) {
        double currentHighest;
        double currentScore;
        int highestPosition;

        highestPosition = 0;
        currentHighest = 0;

        for (int i = 0; i < 4; i = i + 1) {
            currentScore = averagesScoreArray[i];
            if (currentScore > currentHighest) {
                highestPosition = i;
                currentHighest =  averagesScoreArray[i];
            }
        }
        return highestPosition;
    }

    public static void main(String[] args) {
        creatingArray();
    }

}
