// Quoc Viet Phan
// 220364926
// Grade G
// Excercise 2
// Thu 6 Oct

import java.util.Scanner;

// The program will ask for the users' inputs by asking them a serial of questions.
// It will then use the input data to calculate the numbers of seats left

public class Main
{
    public static int calculate(int carriageNumbers, int hundred, int adultTickets, int childTickets, int bikeTickets){
        int seatsLeft = (carriageNumbers*hundred)-adultTickets-childTickets-(2*bikeTickets);
        return seatsLeft;
    }

    public static void askAQuestion(String question){
        System.out.println(question);
    }

    public static void calculatingSeats () 
    {
            int carriageNumbers; // Declare variable
            int adultTickets; // Declare variable
            int childTickets; // Declare variable
            int bikeTickets; // Declare variable
            int seatsLeft;
            final int hundred = 100;
            
            Scanner sc = new Scanner(System.in);
            askAQuestion("How many carriages are there on the train?");
            carriageNumbers = sc.nextInt(); // Getting input
            askAQuestion("How many adult tickets have been sold?");
            adultTickets = sc.nextInt(); // Getting input
            askAQuestion("How many child tickets have been sold?");
            childTickets = sc.nextInt(); // Getting input
            askAQuestion("How many bike tickets have been sold?");
            bikeTickets = sc.nextInt(); // Getting input
            sc.close();
            
            seatsLeft = calculate(carriageNumbers, hundred, adultTickets, childTickets, bikeTickets); // Calculating number of seats available

            System.out.println("Calculation performed: (" + carriageNumbers + "*"+hundred+")-" + adultTickets + "-" + childTickets + "-(2*" + bikeTickets +")");
            
            System.out.println("There are " + seatsLeft + " seats left.");    
    }
    
    public static void main (String[] args)
    {
        calculatingSeats ();
    }

}