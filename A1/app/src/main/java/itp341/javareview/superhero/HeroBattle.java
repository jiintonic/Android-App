/*
 * Name: Ching-chuan Yang
  * ID: 2451-400-390
  * */

package itp341.javareview.superhero;

public class HeroBattle {

    private String battleResult = "";
    private Superhero p1, p2;
    private int round = 1;

    public HeroBattle(){
        p1 = new Superhero("p1");
        p2 = new Superhero("p2");
        battleResult += "HEROS" + "\n" + p1.getHeroStats() + "\n";
        battleResult += p2.getHeroStats() +"\n";

    }
    public String play(){
        battleResult += "FIGHT!";
        battleResult += displayHero();
        while(!p1.isInjured() && !p2.isInjured()){
            p1.setHealthPoints(p1.getHealthPoints() - p2.getAttackValue());
            p2.setHealthPoints(p2.getHealthPoints() - p1.getAttackValue());
            battleResult += displayHero();
        }

        if(p1.isInjured()){
            if(p2.isInjured()) battleResult += "It's a tie";
            else battleResult += p2.getName() + "wins!";
        }
        else
            battleResult += p1.getName() + "wins!";

        return battleResult;
    }

    private String displayHero(){
        String r = "";
        r += "===== Round " + round + " ===== \n";
        if(round == 1){
            r+= p1.getName() + " has healthPoints = " + p1.getHealthPoints() + " and attackValue = " + p1.getAttackValue() + "\n";
            r+= p2.getName() + " has healthPoints = " + p2.getHealthPoints() + " and attackValue = " + p2.getAttackValue() + "\n";
        }
        else{
            r+= p1.getName() + " has healthPoints = " + p1.getHealthPoints() + "\n";
            r+= p2.getName() + " has healthPoints = " + p2.getHealthPoints() + "\n";
        }
        r+= "/n";
        round++;
        return r;
    }

}
