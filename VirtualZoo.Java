import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Lachlan Shinnick, 2310582 and FAN shin0203
 */
public class VirtualZoo {

    // List to keep track of animal names
    private final ArrayList<String> animalNames;

    // scanner used to get input from the user
    Scanner scan = new Scanner(System.in);

    // variable totalCost keeping track of accumulated cost
    private static int totalCost;


    // getter and setter methods for total cost
    public static int getTotalCost() {
        return totalCost;
    }

    public static void setTotalCost(int cost) {
        totalCost = cost;
    }

    // Constructor for virtual zoo class
    public VirtualZoo() {
        // Array list of animal names
        animalNames = new ArrayList<>();
    }

    // method to begin the zoo simulation
    public void beginSimulation() {
        displayWelcome(); // display welcome message
        ArrayList<Animal> zooAnimals = animalSelection(); // get the list of animals

        // Call the weekCycle method to simulate a week in the zoo
        weekCycle(zooAnimals);
    }

    //-------------------------operational methods------------------------------

    /**
     * Defines the Welcome Message text
     */
    public void displayWelcome() {
        System.out.println("+----------------------------------------------------------------------+");
        System.out.println("|                     Welcome to the Virtual Zoo!                      |");
        System.out.println("|     Use this application to simulate running a zoo over one week     |");
        System.out.println("|           This program is intended for zoo employees only!           |");
        System.out.println("+----------------------------------------------------------------------+");
    }

    // asks how many animals within someone's zoo, ensuring input is a positive integer
    public int askNumberAnimals() {
        System.out.println("How many animals are at your zoo?");
        while (true) {
            try {
                int number = Integer.parseInt(scan.nextLine());
                if (number <= 0) {
                    System.out.println("Please enter a positive number of animals");
                    System.out.println("How many animals are at your zoo?");
                } else {
                    return number;
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid number of animals");
                System.out.println("How many animals are at your zoo?");
            }
        }
    }

    // method to ask for the name of an animal, ensuring the name is unique
    public String askAnimalName(int id) {
        boolean nameWithin = true;
        String name = null;
        while (nameWithin) {
            System.out.println("What is the name of animal #" + id + "?");
            name = scan.nextLine();
            nameWithin = false; // assume the name is unique until found otherwise
            for (int i = 0; i < animalNames.size(); i++) {
                if (animalNames.get(i).equals(name)) {
                    System.out.println("That name is already taken");
                    nameWithin = true;
                    break;
                }
            }
        }
        animalNames.add(name);
        return name;
    }

    // method to ask for the species of an animal
    public Animal askAnimalSpecies(String name) {
        while (true) {
            System.out.println("What is the species of " + name + "?");
            String species = scan.nextLine().toLowerCase();
            if (species.equals("tiger") || species.equals("giraffe") || species.equals("hippo") || species.equals("panda") || species.equals("monkey")) {
                species = species.substring(0, 1).toUpperCase() + species.substring(1).toLowerCase(); //Capitalising first character whilst the rest is lowercase

                // create and return the appropriate animal object based on the species
                if (species.equals("Tiger")) {
                    return new Tiger(name);
                }
                if (species.equals("Giraffe")) {
                    return new Giraffe(name);
                }
                if (species.equals("Hippo")) {
                    return new Hippo(name);
                }
                if (species.equals("Panda")) {
                    return new Panda(name);
                }
                if (species.equals("Monkey")) {
                    return new Monkey(name);
                }
            }
            System.out.println("That is not a valid species");
        }
    }

    // method to ask the user how many animals are present in the zoo, as well as the name and species of each animal
    public ArrayList<Animal> animalSelection() {
        ArrayList<Animal> allZooAnimals = new ArrayList<>();
        int numberOfAnimals = askNumberAnimals();
        System.out.print("\n");
        for (int i = 0; i < numberOfAnimals; i++) {
            String name = askAnimalName(i + 1);
            Animal animal = askAnimalSpecies(name);
            allZooAnimals.add(animal);
        }
        return allZooAnimals;
    }

    // Asks the user which item they would like to give to the animal
    public void askItem(Animal animal) {
        try {
            while (true) {
                System.out.println("What item would you like to give to " + animal.getName() + "?"); // Prompt the user for the item to give to the animal
                String userItem = scan.nextLine().toLowerCase(); // Read the user's input and convert it to lowercase

                // Check if the user's input is a valid item (food, water, or toy)
                if (userItem.equals("food") || userItem.equals("water") || userItem.equals("toy")) {
                    // Check if the same item was given to the animal yesterday
                    if (animal.getPreviousItem() != null && animal.getPreviousItem().equals(userItem)) {
                        System.out.println("You cannot give the same item as yesterday"); // Notify the user that the same item cannot be given as yesterday
                        continue; // Continue the loop to prompt the user for a different item
                    }
                    // Based on the user's input, call the appropriate method on the animal (giveFood, giveWater, or giveToy)
                    if (userItem.equals("food")) {
                        animal.giveFood();
                    } else if (userItem.equals("water")) {
                        animal.giveWater();
                    } else if (userItem.equals("toy")) {
                        animal.giveToy();
                    }
                    // Check if the animal has died, and if so, update the total cost and print a message
                    if (animal.isDead()) {
                        setTotalCost(getTotalCost() + 1000);
                        System.out.println(animal.getName() + " has died");
                    }
                    // Set the current item as the previous item for the animal
                    animal.setPreviousItem(userItem);
                    break; // Exit the loop
                } else {
                    System.out.println("That is not a valid item"); // Notify the user that the input is not a valid item
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("No input found. Please provide valid input."); // Handle the case where no input is found and prompt the user to provide valid input
        }
    }

    // Simulates a week in the virtual zoo, iterating through each day of the week
    public void weekCycle(ArrayList<Animal> zooAnimals) {
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"}; // Array representing the days of the week
        for (int i = 0; i < 7; i++) { // Iterate through each day of the week
            System.out.println("\nThe current day is " + days[i]+"\n"); // Print the current day

            // Display the status of each animal in the zoo for the current day
            for (Animal animal : zooAnimals) {
                System.out.println(animal.toString());
            }

            // For each animal in the zoo, if it's not dead, prompt the user to give an item to the animal
            for (Animal animal : zooAnimals){
                if (!animal.isDead()) {
                    askItem(animal);
                }
            }
        }
        System.out.println("\nTotal week cost = $" + getTotalCost()); // Print the total cost for the week
    }
}