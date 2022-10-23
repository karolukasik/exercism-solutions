import java.util.ArrayList;
import java.util.Random;

class DnDCharacter {

    private Random rnd = new Random();
    private ArrayList<Integer> dicesRolls = new ArrayList<>();
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private int hitpoints;

    public DnDCharacter() {
        this.strength = ability();
        this.dexterity = ability();
        this.constitution = ability();
        this.intelligence = ability();
        this.wisdom = ability();
        this.charisma = ability();
        this.hitpoints = 10 + modifier(this.constitution);
    }

    int ability() {
        for (int i = 0; i < 4; i++) {
            dicesRolls.add(rollTheDice());
        }

        dicesRolls.sort(null);

        int sumOfRolls = 0;
        for (int i = 1; i < 4; i++) {
            sumOfRolls += dicesRolls.get(i);
        }

        return sumOfRolls;
    }

    int modifier(int input) {
        double mod = ((double) input - 10) / 2;
        return (int) (Math.floor(mod));

    }



    int getStrength() {
        return this.strength;
    }

    int getDexterity() {
        return this.dexterity;
    }

    int getConstitution() {
        return this.constitution;
    }

    int getIntelligence() {
        return this.intelligence;
    }

    int getWisdom() {
        return this.wisdom;
    }

    int getCharisma() {
        return this.charisma;
    }

    int getHitpoints() {
        return this.hitpoints;
    }

    int rollTheDice() {
        return rnd.nextInt(6) + 1;
    }

}
