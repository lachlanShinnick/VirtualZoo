public class Hippo extends Animal {

    // Constructor for the Hippo class
    public Hippo(String name){
        super(name, "Hippo");
    }

    // Method to give food to the Hippo, adjusting hunger, thirst, boredom and cost as necessary
    @Override
    public void giveFood() {
        hunger = Math.max(0, hunger - 25);
        thirst = thirst + 5;
        boredom = boredom + 25;
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost()+50);
        previousItem = "food";
    }

    // Method to give water to the Hippo, adjusting hunger, thirst, boredom and cost as necessary
    @Override
    public void giveWater() {
        hunger = hunger + 5;
        thirst = Math.max(0, thirst - 25);
        boredom = boredom + 25;
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost()+50);
        previousItem = "water";
    }

    // Method to give a toy to the Hippo, adjusting hunger, thirst, boredom and cost as necessary
    @Override
    public void giveToy() {
        hunger = hunger + 20;
        thirst = thirst + 20;
        boredom = Math.max(0, boredom - 50);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost()+20);
        previousItem = "toy";
    }
}