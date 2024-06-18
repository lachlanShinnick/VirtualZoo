public class Giraffe extends Animal {

    // Constructor for the Giraffe class
    public Giraffe(String name){
        super(name, "Giraffe");
    }

    // Method to give food to the giraffe, adjusting hunger, thirst, boredom and cost as necessary
    @Override
    public void giveFood() {
        hunger = Math.max(0, hunger - 50);
        thirst = thirst + 30;
        boredom = boredom + 20;
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost()+100);
        previousItem = "food";
    }

    // Method to give water to the giraffe, adjusting hunger, thirst, boredom and cost as necessary
    @Override
    public void giveWater() {
        hunger = hunger + 20;
        thirst = Math.max(0, thirst - 50);
        boredom = boredom + 30;
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost()+40);
        previousItem = "water";
    }

    // Method to give toy to the giraffe, adjusting hunger, thirst, boredom and cost as necessary
    @Override
    public void giveToy() {
        hunger = hunger + 30;
        thirst = thirst + 10;
        boredom = Math.max(0, boredom - 40);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost()+75);
        previousItem = "toy";
    }
}