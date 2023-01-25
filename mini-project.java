// Quoc Viet Phan
// 220364926
// Mini-coursework
// Sun 9 Oct
// Jurassic Park game

import java.util.Scanner;
import java.util.Random;

// The program will start to ask users to put the number of dinosaurs wished to be played in the game
// It'll then ask the users to input the name following the previous input of number of dinosaurs
// Everytime the users put the name, the program will automatically generate the random value from 1-5 for anger level and hunger level
// After that it'll randomly select 1 of the dinosaurs from the list and calculate the danger level
// Danger level classified as 4 level (0-4, 5-6, 7-9 and 10 which is highest)
// As the level reached highest, the game will be ended
// Otherwise, the users will have an option to play with the dinosaurs includes feed etc...
// The anger level can increase or decrease following the option chose

// Create and define new record
class Dinosaur
{
    int position;
    String currentDinosaur; // The Students full name
    int currentAnger;   // Their unique ID number
    int currentHunger;    // their coursework mark /50
    int dangerLvl;         // their exam mark /50
    String favouriteFood;
    String favouritePlay;
    String favouriteExcersie;
}

public class Main {
    // Getter methods for Dinosaur
    // Return the list of attributes from dinosaur record
    // Return Name
    public static String getName (Dinosaur d)
    {
     return d.currentDinosaur;
    }
    // Return FavFood
    public static String getFavFood (Dinosaur d)
    {
     return d.favouriteFood;
    }
    // Return FavPlay
    public static String getFavPlay (Dinosaur d)
    {
     return d.favouritePlay;
    }
    // Return FavExcerise
    public static String getFavExcersie (Dinosaur d)
    {
     return d.favouriteExcersie;
    }
    // Return position of dinosaurs from original array
    public static int getPosition (Dinosaur d)
    {
     return d.position;
    }
     // Return hunger level
    public static int getHungerLvl (Dinosaur d)
    {
     return d.currentHunger;
    }
    // Return anger level
    public static int getAngerLvl (Dinosaur d)
    {
     return d.currentAnger;
    }
    // This is the danger level
    public static int getDangerLvl (Dinosaur d)
    {
     return d.dangerLvl;
    }
    // To create a student BOTH a name and position from OG array must be presented
    // The list of any other attributes rather than position and name of the dinasaur will be set to either N/A for String or 0 for Int
    public static Dinosaur createDinosaur (int position, String currentDinosaur, int currentAnger, int currentHunger, int dangerLvl, String favouriteFood, String favouritePlay, String favouriteExcersie)
    {
       Dinosaur d = new Dinosaur();
       d.position = position;
       d.currentDinosaur = currentDinosaur;
       d.currentAnger = currentAnger;
       d.currentHunger = currentHunger;
       d.dangerLvl = dangerLvl;
       d.favouriteFood = favouriteFood;
       d.favouritePlay = favouritePlay;
       d.favouriteExcersie = favouriteExcersie;
       return (d); 
    }
    // Set the level of Anger/ Hunger/ Danger whenever neccessarily
    // returning the updated record
    public static Dinosaur updateLevel (Dinosaur d, int currentAnger, int currentHunger, int dangerLvl)
    {
        d.currentAnger = currentAnger;
        d.currentHunger = currentHunger;
        d.dangerLvl = dangerLvl;
        return (d);
    }
    
    ////////---------- METHODS FOR RECORD FINISHED --------///////////
    
    
    
    
    // Method generate the level of anger and hunger
    public static int getExpressionLvl() {
        int max = 4; // Maxium level (Ensure the danger level not 10 at the start)
        int min = 1; // Minium level
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min; // Randomly generated number between 1 and 5
        return randomNum;
    }
    
    // Method of getting random adjective for display
    public static String getRandom(String[] args) {
        int rnd = new Random().nextInt(args.length); // Random get the position in the array
        return args[rnd]; // Get the corresponding adjectives from the position
    }
    
    // Method of getting the position from a list by randomly selected
    public static int getPosition(String[] dinosaursList) {
        int rnd = new Random().nextInt(dinosaursList.length); // Random selecting the position in the array
        return rnd;
    }
    
    // Method of adding new elements into the array (dinosaurs name)
    public static String[] addNewDinosaur(String[] dinosaursList, String dinosaurName) {
        String[] returnArray = new String[dinosaursList.length+1]; // Create a dummy array 

        for(int i = 0; i < dinosaursList.length; i++) {
            returnArray[i] = dinosaursList[i];
        }

        returnArray[returnArray.length - 1] = dinosaurName; // Add the new element to dummy array
        return returnArray;
    }
    
    // Method adding new elements into the array (Hunger/ Anger)
    public static int[] addExpressionList(int[] args) {
        int expressionLvl = 0;
        expressionLvl = getExpressionLvl(); // Generate an value for hunger/ anger
        int[] returnArray = new int[args.length+1]; // Create dummy array

        for(int i = 0; i < args.length; i++) {
            returnArray[i] = args[i];
        }

        returnArray[returnArray.length - 1] = expressionLvl; // Add new value to dummy array
        return returnArray;
    }    
    
    // Method of calculating the dangerous level from anger and hunger level
    public static int calculateDangerousLvl (int currentAnger, int currentHunger) {
        int dangerLvl = 0;
        dangerLvl = currentAnger + currentHunger; // Add both hunger and anger level
        return dangerLvl;
    }
    
    // Main program
    public static void Main(String[] args) {
        
        String username;
        int numberOfDinosaurs;
        String dinosaurName;

        // An array of adjective
        String[] describeAdj = {"small", "carnivorous", "old", "giant", "huge", "largest", "armored", "horned", "herbivorous", "bipedal", "feathered", "biggest", "oldest", "primitive", "parochial", "gigantic", "ornithischian", "predatory", "ceratopsian", "enormous", "plated", "cretaceous", "stuffed", "armoured", "saurischian", "legged", "headed", "famous", "friendly", "longest", "ostrich", "mighty", "crested", "necked", "intelligent", "lumbering"};
            
        Scanner sc = new Scanner(System.in);
        
        System.out.println("What's your name? ");
        username = sc.nextLine(); // Collecting input
        System.out.println("Welcome to Jurassic Park Game, " + username);
        System.out.println("Please select from number of dinosaurs you wished to take care (2-10): ");
        numberOfDinosaurs = sc.nextInt();
        sc.close();
        
        // Create an array
        String[] dinosaursList = new String[numberOfDinosaurs];
        int[] angryLvlList = new int[numberOfDinosaurs];
        int[] hungryLvlList = new int[numberOfDinosaurs];
        
        // Looping to ask for users the dinosaurs name and generate anger/hunger level
        for (int i = 1; i <= numberOfDinosaurs; i++) {
            System.out.println("Please enter your number " + i + " dinosaur: ");
            dinosaurName = sc.nextLine();
            angryLvlList = addExpressionList(angryLvlList);
            hungryLvlList = addExpressionList(hungryLvlList);
            dinosaursList = addNewDinosaur(dinosaursList, dinosaurName);
            System.out.println(dinosaurName + " are " + getRandom(describeAdj));
        }
        sc.close();
        
        Dinosaur[] dinosaursRecordArray = new Dinosaur[2]; // Create a new array for Dinosaurs with Dinosaur type
        
        
        // While loop to play the game
        // Declare variables
        int dangerLvl;
        int option;
        String dinosaurOption;
        String currentDinosaur = "None";
        int position = 0;
        int currentAnger = 0;
        int currentHunger = 0;
        int activitiesOption;
        String favouriteFood;
        String favouritePlay;
        String favouriteExcersie;
            
        
        // Declare and initialised the array of values such as food/ activities that will later be used randomly assigned to each dinosaur
        String[] foodList = {"Meat", "Insects", "Vegetable", "Bird", "Fish", "tree", "Fruit"};
        String[] playList = {"Play game", "Play ball", "Play with water", "Play with others", "Listen to Music", "Watch movie"};
        String[] exerciseList = {"Run", "Walk", "Jump", "Swim"};
            
            
        // Loop to choose 2 dinosaurs each round
        for (int i = 1; i <= 2; i++) {
            
            position = getPosition(dinosaursList); // Randomly getting the position of a random dinosour in the array
            currentDinosaur = dinosaursList[position]; // Get the current Dinosour name
            currentAnger = angryLvlList[position]; // Get the current Anger level
            currentHunger = hungryLvlList[position]; // Get the current Hunger level
            System.out.println(i + ". The dinosaur is: " + currentDinosaur + ". It current anger level is " + currentAnger + " and hunger is " + currentHunger);
            dangerLvl = calculateDangerousLvl(currentAnger, currentHunger); // Recalculate dangerous level
            favouriteFood = getRandom(foodList);
            favouritePlay = getRandom(playList);
            favouriteExcersie = getRandom(exerciseList);
            Dinosaur d = createDinosaur(position, currentDinosaur, currentAnger, currentHunger, dangerLvl, favouriteFood, favouritePlay, favouriteExcersie); // Create new records
        
            dinosaursRecordArray[i-1] = d;
        }
            
        while (true) 
        {   
            System.out.println("Please type name of the dinosaur you want to take care: "); // Only 1 dinosaur will be displayed at a time, it'll ask to choose one of them
            dinosaurOption = sc.nextLine();
            sc.close();
            // Looping through an array declared before to find the dinosaur selected from Record Array
            Dinosaur selectedDinosaur = null;
            for (int i = 1; i <= 2; i++) {
                Dinosaur d = dinosaursRecordArray[i-1];
                if(getName(d) == dinosaurOption)
                {
                    selectedDinosaur = d;
                }
            } 
            
            // Return the record of selected Dinosaur
            Dinosaur d = selectedDinosaur;
            
            // Get attributes from the record of the dinosaur selected
            currentDinosaur = getName(d); // d.currentDinosaur
            favouriteFood = getFavFood(d); // d.favouriteFood
            favouritePlay = getFavPlay(d); // d.favouritePlay
            favouriteExcersie = getFavExcersie(d); // d.favouriteExcersie
            position = getPosition(d); // d.position
            currentHunger = getHungerLvl(d); // d.currentHunger
            dangerLvl = getDangerLvl(d); // d.dangerLvl
            currentAnger = getAngerLvl(d); // d.currentAnger
            
            // Checking for the danger level and prompted the users for different scenarios depends on the level
            if (dangerLvl <= 3) {
                System.out.println("Your dinosaur is calm! You do not need to do anything."); // First level (CALM)
            }
            else if (dangerLvl <= 6 && dangerLvl >= 4){
                System.out.println("Your dinosaur is miffed! What you want to do?"); // Second level (MIFFLED)
                System.out.println("1. Feed, 2. Play, 3. Exercise, 4. Nothing");
                option = sc.nextInt();
                // List of options to play game
                if (option==1)  {
                    for (int i = 0; i <= foodList.length; i++) {
                        System.out.println(i + ". " + foodList[i]);
                    }
                    System.out.println("Please select an option: ");
                    activitiesOption = sc.nextInt();
                    // It will check whether the food selected by user is fav or not, fav will reduce the hunger by twice 
                    if (foodList[activitiesOption] == favouriteFood){
                        if (currentHunger > 1) {
                            currentHunger = currentHunger - 2;
                        }
                        else if (currentHunger > 0){
                            currentHunger = currentHunger -1; // Ensure the value is not negative
                        }
                        if (currentAnger > 0) {
                            currentHunger = currentHunger - 1; // ^^
                        }
                    }
                    else{
                        if (currentHunger > 0) {
                        currentHunger = currentHunger - 1;
                        }
                    }
                }
                else if (option == 2) {
                    for (int i = 0; i <= playList.length; i++) {
                        System.out.println(i + ". " + playList[i]);
                    }
                    System.out.println("Please select an option: ");
                    activitiesOption = sc.nextInt();
                    // Checking whether the activities is fav which if fav the anger will reduce twice
                    if (playList[activitiesOption] == favouritePlay){
                        if (currentAnger > 1) {
                            currentAnger = currentAnger - 2; // Perform simple checking to ensure the value is not negative
                        }
                        else if (currentAnger > 0){
                            currentAnger = currentAnger -1;
                        }
                    }
                    else{
                        if (currentAnger > 0) {
                            currentAnger = currentAnger - 1;
                        }
                    }
                } 
                else if (option == 3) {
                    for (int i = 0; i <= exerciseList.length; i++) {
                        System.out.println(i + ". " + exerciseList[i]);
                    }
                    System.out.println("Please select an option: ");
                    activitiesOption = sc.nextInt();
                    // Checking favExcersie
                    if (exerciseList[activitiesOption] == favouriteExcersie){
                        if (currentAnger > 1) {
                            currentAnger = currentAnger - 2;
                        }
                        else if (currentAnger > 0){
                            currentAnger = currentAnger -1;
                        }
                        if (currentHunger < 5) {
                            currentHunger = currentHunger + 1;
                        }
                    }
                    else{
                        if (currentAnger > 0) {
                            currentAnger = currentAnger - 1;
                        }
                        if (currentHunger < 5) {
                        currentHunger = currentHunger + 1;
                        }
                    }
                }
            }
            else if (dangerLvl <= 9 && dangerLvl >= 7) {
                System.out.print("Your dinosaur is dangerous! Try make it happier!!!"); // Third level (Dangerous)
                System.out.println("1. Feed, 2. Play, 3. Exercise, 4. Nothing");
                option = sc.nextInt();
                // List of options to play game
                if (option==1) {
                    if (currentHunger > 0) {
                        currentHunger = currentHunger - 1;
                    }
                }
                else if (option == 2) {
                    if (currentAnger > 0) {
                        currentAnger = currentAnger - 1;
                    }
                }
                else if (option == 3) {
                    if (currentHunger > 0) {
                        currentHunger = currentHunger - 1;
                    }
                    if (currentAnger < 5) {
                        currentAnger = currentAnger + 1;
                    }
                }
            }
            else if (dangerLvl ==10) {
                System.out.print("Your dinosaur is a KILLER! RUNNNNNNNN!!!"); // Final level (KILLER) Game ended
                break;
            }
            angryLvlList[position] = currentAnger; // Rechecking the current Anger level
            hungryLvlList[position] = currentHunger; // Rechecking the current Hunger level
            // Loop to access an array checking for the dinosaur and display the new danger level value
            for (int i = 1; i <= 2; i++) {
                if (getName(d) == currentDinosaur){
                    dangerLvl = calculateDangerousLvl(currentAnger, currentHunger); // Calculating danger level
                    updateLevel(d, currentAnger, currentHunger, dangerLvl); // Updating list of attributes includes currentDanger/ currentHunger and Dangerlvl (update the record)
                    System.out.println("Your dinosaur " + currentDinosaur + " has current danger level is " + dangerLvl); // Return current danger lvl and display corresponding name
                }
            }
        } 
    }
}

// Program ends //