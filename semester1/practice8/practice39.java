package practice8;

class CharacterUnit {
    private String name;
    protected int hp;
    protected int maxHp;
    protected int armor;
    public CharacterUnit(String name, int maxHp, int armor) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.armor = armor;
    }
    public void takeDamage(int rawDamage) {
        int damage = Math.max(1, rawDamage - armor);
        hp -= damage;
        if (hp < 0) {
            hp = 0;
        }
    }
    @Override
    public String toString() {
        int filledBlocks = (int) Math.round((double) hp / maxHp * 10);
        String healthBar = "[";
        for (int i = 0; i < 10; i++) {
            if (i < filledBlocks) {
                healthBar += "█";
            } else {
                healthBar += "░";
            }
        }
        healthBar += "]";
        return "Персонаж: " + name +
                "\nHP: " + hp + "/" + maxHp +
                "\nЗдоров'я: " + healthBar +
                "\nБроня: " + armor;
    }
}
class ShieldedPaladin extends CharacterUnit {
    private int shieldPoints;
    public ShieldedPaladin(String name, int maxHp, int armor, int shieldPoints) {
        super(name, maxHp, armor);
        this.shieldPoints = shieldPoints;
    }
    @Override
    public void takeDamage(int rawDamage) {
        if (rawDamage <= 0) {
            return;
        }
        if (shieldPoints > 0) {
            if (rawDamage <= shieldPoints) {
                shieldPoints -= rawDamage;
                return;
            } else {
                int remainingDamage = rawDamage - shieldPoints;
                shieldPoints = 0;

                super.takeDamage(remainingDamage);
            }
        } else {
            super.takeDamage(rawDamage);
        }
    }
    @Override
    public String toString() {
        return super.toString() +
                "\nМагічний щит: " + shieldPoints;
    }
}
public class practice39 {
    public static void main(String[] args) {
        ShieldedPaladin paladin =
                new ShieldedPaladin("Артур", 100, 10, 40);
        System.out.println("Початковий стан:");
        System.out.println(paladin);
        System.out.println("\nПісля отримання 25 шкоди:");
        paladin.takeDamage(25);
        System.out.println(paladin);
        System.out.println("\nПісля отримання 40 шкоди:");
        paladin.takeDamage(40);
        System.out.println(paladin);
    }
}

