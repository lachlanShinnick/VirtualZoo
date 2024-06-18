public class Tiger extends Animal {

    // Constructor for the Tiger class
    public Tiger(String name){
        super(name, "Tiger");
    }

    // Method to give food to the tiger, adjusting hunger, thirst, boredom and cost as necessary
    @Override
    public void giveFood() {
        hunger = Math.max(0, hunger - 30);
        thirst = thirst + 15;
        boredom = boredom + 15;
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost()+30);
        previousItem = "food";
    }

    // Method to give water to the tiger, adjusting hunger, thirst, boredom and cost as necessary
    @Override
    public void giveWater() {
        hunger = hunger + 15;
        thirst = Math.max(0, thirst - 30);
        boredom = boredom + 15;
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost()+20);
        previousItem = "water";
    }

    // Method to give a toy to the tiger, adjusting hunger, thirst, boredom and cost as necessary
    @Override
    public void giveToy() {
        hunger = hunger + 15;
        thirst = thirst + 15;
        boredom = Math.max(0, boredom - 30);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost()+40);
        previousItem = "toy";
    }
}