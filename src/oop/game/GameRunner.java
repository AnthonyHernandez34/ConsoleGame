package oop.game;


import oop.characters.Attackable;
import oop.characters.Knight;
import oop.characters.Mage;
import oop.characters.Warrior;

import java.util.Random;
import java.util.Scanner;


public class GameRunner {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

//        Game Var
        String[] enemies = {"Skeleton", "Zombie", "Warrior", "Assassin"};
        int maxEnemyHealth = 100;
        int enemyAttackDamage = 25;

//        Playervar
        int health = 100;
        int attackDamage = 50;
        int defend= 0;
        int roll = 0;
        int numHealthPotions = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50;

        boolean running = true;
        System.out.println("Welcome Enter");

        Game:
        while (running) {
            System.out.println("------------------");
            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# " + enemy + " has appeared! #\n");

            while (enemyHealth > 0) {
                System.out.println("\tHero HP: " + health);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Defend");
                System.out.println("\t3. Drink Health Potion");
                System.out.println("\t4. Roll!");
                System.out.println("\t5. Run!");

                String input = in.nextLine();
                if (input.equals("1")) {
                    int damageDealt = rand.nextInt(attackDamage);
                    int damagetaken = rand.nextInt(enemyAttackDamage);

                    enemyHealth -= damageDealt;
                    health -= damagetaken;

                    System.out.println("\t> You Strike The " + enemy + " for " + damageDealt + " Damage. ");
                    System.out.println("\t> You Receive " + damagetaken + " In Counter! ");

                    if (health < 1) {
                        System.out.println("\t> You Have Taken To Much Damage, You Can Not Continue On!");
                        break;
                    }

                }else if(input.equals("2")) {
                    int damageDelt = defend;
                    System.out.println("\tYou Used Defend Stopped Damage " + damageDelt + "!");


                } else if (input.equals("3")) {
                    if (numHealthPotions > 0) {
                        health += healthPotionHealAmount;
                        numHealthPotions--;
                        System.out.println("\t> You Drink A Health Potion, Healing Yourself for " + healthPotionHealAmount + "." + " " +
                                "\n\t> You Now Have " + health + "Hp." +
                                "\n\t> You have " + numHealthPotions + " Health Potion Left. \n");
                    } else {
                        System.out.println("\t> You Have No Health Potion Left! Defeat Enemies for A Chance To Get One");
                    }

                } else if (input.equals("4")) {
                    int damageDelt = roll;
                    System.out.println("\tYou rolled to Dodge Damage " + damageDelt + "!");

                } else if (input.equals("5")) {
                    System.out.println("\tYou Run Away From The " + enemy + "!");
                    continue Game;
                } else {
                    System.out.println("\tInvalid Command!");

                }
            }
            if (health < 1) {
                System.out.println("You Are Too Wounded You Limp Away, From Battle.");
                break;
            }
            System.out.println("------------------------------");
            System.out.println(" # " + enemy + " Was Killed! # ");
            System.out.println(" # You Have " + health + "Hp Left. # ");
            if (rand.nextInt(100) < healthPotionDropChance) {
                numHealthPotions++;
                System.out.println(" # The " + enemy + " Dropped A Health Potion! # ");
                System.out.println(" # You Now Have" +  numHealthPotions  + " Health Potion(s) .");
            }
            System.out.println("------------------------------");
            System.out.println("What Would You Like To Do Now");
            System.out.println("1. Continue Fighting");
            System.out.println("2. Exit The Area");

            String input = in.nextLine();

            while (!input.equals("1") && !input.equals("2")) {
                System.out.println("Invalid Command!");
                input = in.nextLine();
            }

            if (input.equals("1")) {
                System.out.println("You Continue The Adventure!");
            } else if (input.equals("2")) {
                System.out.println("You Run Out Of The Area With Your Loot!");
                break;
            }
        }
        System.out.println("------------------------------------");
        System.out.println("# Thanks For Playing");
        System.out.println("------------------------------------");

    }
}