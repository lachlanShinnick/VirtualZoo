// Abstract class representing an Animal
public abstract class Animal {
    // instance variables
    protected String name, species, previousItem; // variables to store the name, species, and previously used item
    protected int hunger = 50; // variable to store the level of hunger
    protected int thirst = 50; // variable to store the level of thirst
    protected int boredom = 50; // variable to store the level of boredom

    // Constructor that defines the animal's name and species
    public Animal(String name, String species){
        this.name = name;
        this.species = species;
    }

    // Getter methods for all instance variables
    public String getName(){
        return name;
    }

    public String getSpecies(){
        return species;
    }

    public String getPreviousItem(){
        return previousItem;
    }

    public int getHunger(){
        return hunger;
    }

    public int getThirst(){
        return thirst;
    }

    public int getBoredom(){
        return boredom;
    }

    // Setter methods for all instance variables
    public void setName(String name){
        this.name = name;
    }

    public void setSpecies(String species){
        this.species = species;
    }

    public void setHunger(int hunger){
        this.hunger = hunger;
    }

    public void setThirst(int thirst){
        this.thirst = thirst;
    }

    public void setBoredom(int boredom){
        this.boredom = boredom;
    }

    public void setPreviousItem(String item){
        this.previousItem = item;
    }

    // Method indicating if the animal is dead if any of its properties are above 100
    public boolean isDead(){
        if (hunger > 100 || thirst > 100 || boredom > 100){
            return true;
        }
        else return false;
    }

    // Method to represent the object as a string
    public String toString()
    {
        String statusMessage = isDead() ? "Name = " + getName() + " (Dead)\n" : "Name = " + getName() + "\n";
        statusMessage += "Species = " + getSpecies() + "\n";
        statusMessage += "Hunger = " + getHunger() + "\n";
        statusMessage += "Thirst = " + getThirst() + "\n";
        statusMessage += "Boredom = " + getBoredom() + "\n";
        return statusMessage;
    }

    // Abstract methods to be implemented by the subclasses
    public abstract void giveFood();

    public abstract void giveWater();

    public abstract void giveToy();
}