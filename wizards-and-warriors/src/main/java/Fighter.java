abstract class Fighter {

    public static void main(String[] args) {
        Warrior warrior = new Warrior();
        Wizard wizard = new Wizard();

        // wizard.prepareSpell();
        System.out.println(warrior.damagePoints(wizard));

    }

    boolean isVulnerable() {
        return false;
    }

    abstract int damagePoints(Fighter fighter);

    @Override
    public String toString() {
        return "Fighter is a " + this.getClass().getSimpleName();
    }

}

class Warrior extends Fighter {

    @Override
    int damagePoints(Fighter wizard) {
        return wizard.isVulnerable() == true ? 10 : 6;
    }
}

class Wizard extends Fighter {
    private boolean hasPreparedSpell = false;

    @Override
    boolean isVulnerable() {
        return !this.hasPreparedSpell;
    }

    @Override
    int damagePoints(Fighter warrior) {
        return this.hasPreparedSpell == true ? 12 : 3;
    }

    void prepareSpell() {
        this.hasPreparedSpell = true;
    }

}
