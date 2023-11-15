
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        
        //System objects
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        //Game variables //enemies will attack you with their cuteness
        String[] enemies = {"Jack", "Chloe", "Newton", "Peanut"};
        int maxEnemyHealth = 75;
        int enemyAttackDamage = 50;

        //Player variables
        int health = 100;
        int attackDamage = 50;
        int numHealthPotions = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 30; //percentage.. means 50% chance to drop potion

        boolean running = true; //game keeps iterating over and over

        System.out.println("Welcome! Good luck resisting the cuteness!");

        GAME:
        while(running) {
            System.out.println("-------------------------------------------");

            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# " + enemy + " appeared! #\n");

            while(enemyHealth > 0) {
                System.out.println("Your HP: " + health);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Resist cuteness");
                System.out.println("\t2. Drink self control potion");
                System.out.println("\t3. Run!");

                String input = in.nextLine();
                if(input.equals("1")){
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);

                    enemyHealth -= damageDealt;
                    health -= damageTaken;

                    System.out.println("\t> You resisted the cuteness powers of " + enemy + " and have decreased their HP by " + damageDealt + ".");
                    System.out.println("\t> You recieve " + damageTaken + " damage in retaliation!");

                    if(health <1) {
                        System.out.println("You have taken too much damage, you're too weak to go on... " +
                        "did you even want to win anyways? Who would want to resist all this cuteness!?");
                        break;
                        //smothered by cuddles when you die
                    }

                }
                else if(input.equals("2")) {
                    if(numHealthPotions > 0) {
                        health += healthPotionHealAmount;
                        numHealthPotions --;
                        System.out.println("\t> You drink a self control potion, healing yourself for " + healthPotionHealAmount+ "." 
                        + "\n\t> You now have " + health + " HP."
                        + "\n\t>  You have " + numHealthPotions + " health potions left.\n");

                    }
                    else {
                        System.out.println("\t> You have no self control potions left! Defeat enemies for a chance to get one.");

                    }

                }
                else if(input.equals("3")) {
                    System.out.println("\tYou run away from " + enemy + "!");
                    continue GAME;  //goes back to the outer loop named GAME

                }
                else {
                    System.out.println("\tInvalid command!");

                }

            }

            if (health < 1) {
                System.out.println("You are captured by the pets and are smothered with cuddles.");
                break;
            }

            System.out.println("-------------------------------------------");
            System.out.println( " # " + enemy + " was defeated! # ");
            System.out.println(" # You have " + health + " HP left #");
            if(rand.nextInt(100) < healthPotionDropChance) {
                numHealthPotions++;
                System.out.println(" # The " + enemy + " dropped a self control potion! # ");
                System.out.println(" # You now have " + numHealthPotions + " self control potion(s). # ");

            }
            System.out.println("-------------------------------------------");
            System.out.println("What would you like to do now?");
            System.out.println("1. Continue onwards");
            System.out.println("2. Exit");

            String input = in.nextLine();

            while (!input.equals("1") && !input.equals("2")){
                System.out.println("Invalid command!");
                input = in.nextLine();
            }

            if(input.equals("1")) {
                System.out.println("You continue on your adventure!");

            }
            else if(input.equals("2")) {
                System.out.println("You exit, you've resisted all the cuddles.. Yay you... You must feel so proud of yourself.");
                break;
            }

        }
        System.out.println("#######################");
        System.out.println("# Thanks for playing! #");
        System.out.println("#######################");

        in.close();
        System.exit(0);
    }
    
}
