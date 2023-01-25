// Quoc Viet Phan
// 220364926
// Excersie 7
// Tue 11 Oct

import java.util.Scanner;

// Create and define new record
class TheatreRecord {
    String name;
    boolean disabledAccess;
    int wheelchairSeats;
}

public class Main {
    // Getter methods for Dinosaur
    // Return the list of attributes from dinosaur record
    // Return Name
    public static String getName(TheatreRecord d) {
        return d.name;
    }

    public static int getWheelchairSeats(TheatreRecord d) {
        return d.wheelchairSeats;
    }

    // Return anger level
    public static boolean getAccessabilityStatus(TheatreRecord d) {
        return d.disabledAccess;
    }

    // To create a student BOTH a name and position from OG array must be presented
    // The list of any other attributes rather than position and name of the
    // dinasaur will be set to either N/A for String or 0 for Int
    public static TheatreRecord createTheatre(String name, boolean disabledAccess, int wheelchairSeats) {
        TheatreRecord d = new TheatreRecord();
        d.name = name;
        d.disabledAccess = disabledAccess;
        d.wheelchairSeats = wheelchairSeats;
        return (d);
    }

    //////// ---------- METHODS FOR RECORD FINISHED --------///////////

    // Main program
    public static void main(String[] args) {

        String name;
        int wheelchairSeats;
        int numberTheatres;

        Scanner sc = new Scanner(System.in);

        System.out.println("How many theatres do you wish to ask about? ");
        numberTheatres = sc.nextInt(); // Collecting input

        TheatreRecord crucibleTheatre = createTheatre("Crucible", true, 30); // Create new records
        TheatreRecord baneTheatre = createTheatre("Bane", false, 0);
        TheatreRecord apolloTheatre = createTheatre("Apollo", true, 2);

        for (int i = 0; i < numberTheatres; i = i + 1) {
            System.out.println("What theatre do you need to know about? ");
            name = sc.next(); // Collecting input
            if (name.equals(getName(crucibleTheatre))) {
                if (getAccessabilityStatus(crucibleTheatre) == true) {
                    System.out.println("The " + name + " theatre has disabled access.");
                } else {
                    System.out.println("The " + name + " theatre does not have disabled access.");
                }
                wheelchairSeats = getWheelchairSeats(crucibleTheatre);
                System.out.println("It has " + wheelchairSeats + " wheelchair seats.");
            } else if (name.equals(getName(baneTheatre))) {
                if (getAccessabilityStatus(baneTheatre) == true) {
                    System.out.println("The " + name + " theatre has disabled access.");
                } else {
                    System.out.println("The " + name + " theatre does not have disabled access.");
                }
                wheelchairSeats = getWheelchairSeats(baneTheatre);
                System.out.println("It has " + wheelchairSeats + " wheelchair seats.");
            } else if (name.equals(getName(apolloTheatre))) {
                if (getAccessabilityStatus(apolloTheatre) == true) {
                    System.out.println("The " + name + " theatre has disabled access.");
                } else {
                    System.out.println("The " + name + " theatre does not have disabled access.");
                }
                wheelchairSeats = getWheelchairSeats(apolloTheatre);
                System.out.println("It has " + wheelchairSeats + " wheelchair seats.");
            } else {
                System.out.println("I have not heard of the " + name + " theatre.");
            }
        }
        sc.close();
    }
}

// Program ends //