public class Panda extends Animal {

    // Constructor for the Panda class
    public Panda(String name){
        super(name, "Panda");
    }

    // Method to give food to the panda, adjusting hunger, thirst, boredom and cost as necessary
    @Override
    public void giveFood() {
        hunger = Math.max(0, hunger - 25);
        thirst = thirst + 15;
        boredom = boredom - 5;
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost()+70);
        previousItem = "food";
    }

    // Method to give water to the panda, adjusting hunger, thirst, boredom and cost as necessary
    @Override
    public void giveWater() {
        hunger = hunger + 40;
        thirst = Math.max(0, thirst - 80);
        boredom = boredom + 10;
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost()+5);
        previousItem = "water";
    }

    // Method to give a toy to the monkey, adjusting hunger, thirst, boredom and cost as necessary
    @Override
    public void giveToy() {
        hunger = hunger + 40;
        thirst = thirst + 15;
        boredom = Math.max(0, boredom - 40);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost()+20);
        previousItem = "toy";
    }
}