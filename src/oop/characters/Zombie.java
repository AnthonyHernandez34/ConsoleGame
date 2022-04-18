package oop.characters;

public class Zombie extends Enemy {

    private boolean isRotting;

    public Zombie() {
        super(100, 15);
        this.isRotting = true;
    }

    public boolean isRotting() {
        return isRotting;
    }

    public void setRotting(boolean rotting) {
        isRotting = rotting;
    }

    @Override
    public void attack() {
        System.out.println("Eating brains!");
    }






}
