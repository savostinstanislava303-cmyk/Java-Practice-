package practice8;

class DotaHero {
    private String name;
    private String primaryAttribute;
    private int baseHp;
    public DotaHero(String name, String primaryAttribute, int baseHp) {
        this.name = name;
        this.primaryAttribute = primaryAttribute;
        this.baseHp = baseHp;
    }
    public int getMaxHp() {
        return baseHp;
    }
    public String getName() {
        return name;
    }
    public String getPrimaryAttribute() {
        return primaryAttribute;
    }
    @Override
    public String toString() {
        return "Герой: " + name +
                "\nОсновний атрибут: " + primaryAttribute +
                "\nБазове HP: " + baseHp +
                "\nМаксимальне HP: " + getMaxHp();
    }
}
class StrengthHero extends DotaHero {
    private int strength;
    public StrengthHero(String name, String primaryAttribute,
                        int baseHp, int strength) {
        super(name, primaryAttribute, baseHp);
        this.strength = strength;
    }
    @Override
    public int getMaxHp() {
        return super.getMaxHp() + strength * 22;
    }
    public int getStrength() {
        return strength;
    }
    @Override
    public String toString() {
        return super.toString() +
                "\nСила: " + strength;
    }
}
class AlchemistHero extends StrengthHero {
    private int greevilsGreedBonusGold;
    public AlchemistHero(String name, String primaryAttribute,
                         int baseHp, int strength,
                         int greevilsGreedBonusGold) {
        super(name, primaryAttribute, baseHp, strength);
        this.greevilsGreedBonusGold = greevilsGreedBonusGold;
    }
    public void chemicalRage() {
        System.out.println("Chemical Rage активовано!");
        System.out.println("Алхімік переходить у режим люті!");
    }
    public int getGreevilsGreedBonusGold() {
        return greevilsGreedBonusGold;
    }
    @Override
    public String toString() {
        return super.toString() +
                "\nБонус золота Greevil's Greed: " +
                greevilsGreedBonusGold;
    }
}
public class practice25 {
    public static void main(String[] args) {
        AlchemistHero alchemist = new AlchemistHero(
                "Alchemist",
                "Сила",
                200,
                25,
                18
        );
        System.out.println(alchemist);
        System.out.println();
        alchemist.chemicalRage();
    }
}