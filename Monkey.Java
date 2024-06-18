public class Monkey extends Animal {

    // Constructor for the Monkey class
    public Monkey(String name){
        super(name, "Monkey");
    }

    // Method to give food to the monkey, adjusting hunger, thirst, boredom and cost as necessary
    @Override
    public void giveFood() {
        hunger = Math.max(0, hunger - 30);
        thirst = thirst + 10;
        boredom = boredom +10;
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost()+5);
        previousItem = "food";
    }

    // Method to give water to the monkey, adjusting hunger, thirst, boredom and cost as necessary
    @Override
    public void giveWater() {
        hunger = hunger + 10;
        thirst = Math.max(0, thirst - 40);
        boredom = boredom + 10;
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost()+5);
        previousItem = "water";
    }

    // Method to give a toy to the monkey, adjusting hunger, thirst, boredom and cost as necessary
    @Override
    public void giveToy() {
        hunger = hunger + 10;
        thirst = thirst + 10;
        boredom = Math.max(0, boredom - 15);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost()+15);
        previousItem = "toy";
    }
}