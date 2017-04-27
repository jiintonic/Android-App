package itp341.javareview.superhero;/*
 * Name: Ching-chuan Yang
  * ID: 2451-400-390*/
import java.util.Random;


public class Superhero{
    private String name;
    private int healthPoints;
    private int attackValue;
    public static final int MAX_HEALTHPOINTS = 100;
    public static final int MAX_ATTACKVALUE = 20;
    public static final int MIN_HEALTHPOINTS = 0;
    public static final int MIN_ATTACKVALUE = 5;

    public Superhero(String name){
        this.name = name;
        healthPoints = MAX_HEALTHPOINTS;
        Random random_generator = new Random();
        attackValue = random_generator.nextInt((MAX_ATTACKVALUE - MIN_ATTACKVALUE) + 1) + MIN_ATTACKVALUE;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setHealthPoints(int healthPoints){
        this.healthPoints = healthPoints;
    }

    public void setAttackValue(int attackValue){
        this.attackValue = attackValue;
    }

    public String getName(){
        return name;
    }

    public int getHealthPoints(){
        return healthPoints;
    }

    public int getAttackValue(){
        return attackValue;
    }

    public String getHeroStats(){
        return "Name: " + name + "\n" + "Health Points: " + healthPoints + "\n" + "Attack Value: " + attackValue;
    }

    public boolean isInjured(){
        return healthPoints <= MIN_HEALTHPOINTS;
    }

    public void loseHealthPoints(int attack){
        healthPoints-= attack;
    }


}





