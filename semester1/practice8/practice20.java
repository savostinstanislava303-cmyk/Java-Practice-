package practice8;

class Weapon {
    private String title;
    private int baseDamage;
    public Weapon(String title, int baseDamage) {
        this.title = title;
        this.baseDamage = baseDamage;
    }
    public int calculateDamage() {
        return baseDamage;
    }
    @Override
    public String toString() {
        return "Назва зброї: " + title +
                ", фізична шкода: " + baseDamage;
    }
}
class EnchantedSword extends Weapon {
    private String element;
    private int magicPower;
    private int enchantmentLevel;
    public EnchantedSword(String title, int baseDamage,
                          String element, int magicPower,
                          int enchantmentLevel) {
        super(title, baseDamage);
        this.element = element;
        this.magicPower = magicPower;
        this.enchantmentLevel = enchantmentLevel;
    }
    @Override
    public int calculateDamage() {
        return super.calculateDamage() + magicPower * enchantmentLevel;
    }
    @Override
    public String toString() {
        return super.toString() +
                ", стихія: " + element +
                ", магічна сила: " + magicPower +
                ", рівень зачарування: " + enchantmentLevel +
                ", магічна шкода: " + (magicPower * enchantmentLevel) +
                ", загальна шкода: " + calculateDamage();
    }
}
public class practice20 {
    public static void main(String[] args) {
        Weapon weapon = new Weapon("Залізний меч", 50);
        EnchantedSword sword = new EnchantedSword(
                "Вогняний меч",
                50,
                "Вогонь",
                20,
                3
        );
        System.out.println(weapon);
        System.out.println();
        System.out.println(sword);
    }

}
