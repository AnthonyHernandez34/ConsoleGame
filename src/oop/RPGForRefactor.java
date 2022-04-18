package oop;

import java.util.Random;
import java.util.Scanner;

public class RPGForRefactor {

    public static void main(String[] args) {

        // ENEMIES

        String[] enemies = { "Clown Zombie", "Bill Murray Zombie", "Carney Zombie", "Huge Zombie" };

        // ENEMY VARIABLES
        int maxEnemyHealth = 75;
        int enemyAttackDamage = 25;

        // HERO VARIABLES
        int heroHealth = 100;
        int baseballBat = 25;
        int doubleTapDamage = 50;
        int whiteClaw = 1;
        int whiteClawAmount = 25;

        boolean gameRunning = true;


        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Do want to play ZombieLand? [yes/no]");
        String userAnswer = scanner.nextLine();


        if (userAnswer.equalsIgnoreCase("yes")) {
            System.out.println("Lets start the adventure");
            System.out.println("------------------------");
            System.out.println("Choose your character: ");
            System.out.println("------------------------");
            System.out.println("'c' for Columbus");
            System.out.println("'t' for Tallahassee");
            System.out.println("'w' for Wichita");
            System.out.println("------------------------");
            String character = scanner.nextLine();
            while(character.toLowerCase().charAt(0) != 'c' && character.toLowerCase().charAt(0) != 't' && character.toLowerCase().charAt(0) != 'w') {
                System.out.println("'c' for Columbus");
                System.out.println("'t' for Tallahassee");
                System.out.println("'w' for Wichita");
                System.out.println("------------------------");
                character = scanner.nextLine();
            }
            if(character.toLowerCase().charAt(0) == 'c'){
                System.out.println("Columbus, you are entering Pacific Playland");
            }
            if(character.toLowerCase().charAt(0) == 't'){
                System.out.println("Tallahassee, you are entering Pacific Playland");
            }
            if(character.toLowerCase().charAt(0) == 'w'){
                System.out.println("Wichita, you are entering Pacific Playland");
            }

            GAME:
            while(gameRunning){
                System.out.println("Watch out for Zombies!!");
                System.out.println("     ________     ");
                System.out.println("   (  O   o   )");
                System.out.println("  /     0     \\");
                System.out.println(" /  / |   | \\  \\");
                System.out.println("///\\  |   |  /\\\\\\");
                System.out.println("       |  |         ");
                System.out.println("      /   \\        ");
                System.out.println("     |     |       ");
                System.out.println("   --      --      ");
                System.out.println("------------------------");
                int enemyHealth = random.nextInt(maxEnemyHealth);
                String enemy = enemies[random.nextInt(enemies.length)];
                System.out.println(enemy + " has appeared!");
                System.out.println("[¬º-°]¬");

                while(enemyHealth > 0) {
                    System.out.println("----------------------------------------");
                    System.out.println("Would you like to see your health stats? [yes/no]");
                    String statsInput = scanner.nextLine();

                    if (statsInput.equalsIgnoreCase("yes")) {
                        System.out.println("You have " + heroHealth + " health points!");
                        System.out.println("You have " + whiteClaw + " White Claws!");
                        System.out.println("             <\"\"  -   \"\">                ");
                        System.out.println("             |\"\"     \"\"|                ");
                        System.out.println("             |  WHITE  |                ");
                        System.out.println("             |  CLAW   |                ");
                        System.out.println("             |         |                ");
                        System.out.println("             (         )                ");
                        System.out.println("             \"\"  __   \"\"                ");
                        System.out.println("----------------------------------------");
                        System.out.println(enemy + " has " + enemyHealth + " health points!");
                    }
                    System.out.println("----------------------------------------");
                    System.out.println("What would you like to do?");
                    System.out.println("1. to use Double Tap");
                    System.out.println("2. to use Baseball Bat");
                    System.out.println("3. to boost with White Claw");
                    System.out.println("4. to RUN!");

                    String input = scanner.nextLine();

                    if (input.equals("1")){
                        int damageDone = doubleTapDamage;
                        int damageTaken = enemyAttackDamage;
                        enemyHealth -= damageDone;
                        heroHealth -= damageTaken;
                        System.out.println("You doubletapped the zombie");
                        if (heroHealth < 1) {
                            System.out.println("The Zombie killed you!");
                            System.out.println("----------------------");
                            System.out.println("-------RESTART--------");
                            System.out.println("----------------------");
                            heroHealth = 100;
                            break;
                        }


                    } else if (input.equals("2")) {

                        int damageDone = baseballBat;
                        int damageTaken = enemyAttackDamage;
                        enemyHealth -= damageDone;
                        heroHealth -= damageTaken;

                        if (heroHealth < 1) {
                            System.out.println("The Zombie killed you!");
                            System.out.println("----------------------");
                            System.out.println("-------RESTART--------");
                            System.out.println("----------------------");
                            heroHealth = 100;
                            break;
                        }

                    } else if (input.equals("3")) {
                        heroHealth += whiteClawAmount;
                        whiteClaw -= 1;
                        System.out.println("The White Claw gave you 25 health points! You now have " + heroHealth + " health points and you need to go to the store to get more White Claws!");

                    } else if (input.equals("4")){
                        System.out.println("Really?, you're just going to run away like that?");
                        continue GAME;

                    } else {
                        System.out.println("Invalid input!");
                    }

                }


            }


        } else {
            System.out.println("Alright, we'll play next time then!");
        }


    }
}