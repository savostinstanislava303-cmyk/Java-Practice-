package practice9;

class WeaponItem {
    private final String name;
    private final int bonusDamage;
    private int durability;
    public WeaponItem(String name, int bonusDamage, int durability) {
        this.name = name;
        this.bonusDamage = bonusDamage;
        if (durability < 0) {
            this.durability = 0;
        } else if (durability > 100) {
            this.durability = 100;
        } else {
            this.durability = durability;
        }
    }
    public int useWeapon() {
        if (durability == 0) {
            return 0;
        }
        int damage = bonusDamage;
        durability -= 10;
        if (durability < 0) {
            durability = 0;
        }
        return damage;
    }
    @Override
    public String toString() {
        return "Зброя: " + name +
                ", бонусна шкода: " + bonusDamage +
                ", міцність: " + durability + "%";
    }
}
public class HeroCharacter {
    private final String nickname;
    private int baseStrength;
    private WeaponItem equippedWeapon;
    public HeroCharacter(String nickname, int baseStrength) {
        this.nickname = nickname;
        this.baseStrength = baseStrength;
        this.equippedWeapon = null;
    }
    public void equip(WeaponItem newWeapon) {
        this.equippedWeapon = newWeapon;
        System.out.println("Герой екіпірував нову зброю!");
    }
    public void unequip() {
        this.equippedWeapon = null;
        System.out.println("Герой зняв зброю!");
    }
    public int attack() {
        int totalDamage = baseStrength;
        if (equippedWeapon != null) {
            totalDamage += equippedWeapon.useWeapon();
        }
        return totalDamage;
    }
    @Override
    public String toString() {
        return "Герой: " + nickname +
                "\nБазова сила: " + baseStrength +
                "\nЕкіпірована зброя: " +
                (equippedWeapon != null ? equippedWeapon : "Відсутня");
    }
    public static void main(String[] args) {
        HeroCharacter hero = new HeroCharacter("DragonSlayer", 20);
        WeaponItem sword = new WeaponItem("Залізний меч", 15, 30);
        System.out.println("Початковий стан:");
        System.out.println(hero);
        System.out.println("\nЕкіпірування зброї:");
        hero.equip(sword);
        System.out.println(hero);
        System.out.println("\nПерша атака:");
        System.out.println("Загальна шкода: " + hero.attack());
        System.out.println(sword);
        System.out.println("\nДруга атака:");
        System.out.println("Загальна шкода: " + hero.attack());
        System.out.println(sword);
        System.out.println("\nТретя атака:");
        System.out.println("Загальна шкода: " + hero.attack());
        System.out.println(sword);
        System.out.println("\nЧетверта атака:");
        System.out.println("Загальна шкода: " + hero.attack());
        System.out.println(sword);
        System.out.println("\nЗаміна зброї:");
        WeaponItem axe = new WeaponItem("Бойова сокира", 25, 100);
        hero.equip(axe);
        System.out.println("Загальна шкода: " + hero.attack());
        System.out.println(hero);
        System.out.println("\nЗняття зброї:");
        hero.unequip();
        System.out.println("Загальна шкода: " + hero.attack());
        System.out.println(hero);
    }
}

