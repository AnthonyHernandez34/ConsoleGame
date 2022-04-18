package oop.characters;

public class Enemy extends Character {

    public Enemy(int hp, int attackDamage) {
        super(hp, attackDamage);
    }

    @Override
    public void attack() {
        System.out.println("Enemy Attack!");
    }

    public void spAttack(){
        System.out.println("Used Special Attack for " + spAttackDamage + " damage");
    }

}
