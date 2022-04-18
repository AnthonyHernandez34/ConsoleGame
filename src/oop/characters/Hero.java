package oop.characters;

public class Hero extends Character {

    private String name;

    public Hero(int hp, int attackDamage, String name) {
        super(hp, attackDamage);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void spAttack(){
        System.out.println("Used Special Attack for " + spAttackDamage + " damage");
    }
}
