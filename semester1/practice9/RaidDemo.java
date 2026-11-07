package practice9;

abstract class AbstractHeroUnit {
    private final String name;
    protected int hp;
    public AbstractHeroUnit(String name, int hp) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Ім'я героя не може бути порожнім");
        }
        if (hp <= 0) {
            throw new IllegalArgumentException("HP має бути додатним");
        }
        this.name = name;
        this.hp = hp;
    }
    public String getName() {
        return name;
    }
    public int getHp() {
        return hp;
    }
    public abstract int getCombatPower();
    public abstract String getRole();
    @Override
    public String toString() {
        return getRole() + " " + name;
    }
}
class TankWarrior extends AbstractHeroUnit {
    private final int armor;
    public TankWarrior(String name, int hp, int armor) {
        super(name, hp);
        if (armor < 0) {
            throw new IllegalArgumentException("Броня не може бути від'ємною");
        }
        this.armor = armor;
    }
    @Override
    public int getCombatPower() {
        return hp / 2 + armor * 10;
    }
    @Override
    public String getRole() {
        return "Tank";
    }
}
class ArcaneMage extends AbstractHeroUnit {
    private final int intelligence;
    private final int spellPower;
    public ArcaneMage(String name, int hp, int intelligence, int spellPower) {
        super(name, hp);
        if (intelligence < 0 || spellPower < 0) {
            throw new IllegalArgumentException("Інтелект і сила заклинань не можуть бути від'ємними");
        }
        this.intelligence = intelligence;
        this.spellPower = spellPower;
    }
    @Override
    public int getCombatPower() {
        return intelligence * 5 + spellPower * 8;
    }
    @Override
    public String getRole() {
        return "Mage";
    }
}
class RaidParty {
    private final String guildName;
    private final AbstractHeroUnit[] members;
    private int memberCount;
    public RaidParty(String guildName, int maxMembers) {
        if (guildName == null || guildName.isBlank()) {
            throw new IllegalArgumentException("Назва гільдії не може бути порожньою");
        }
        if (maxMembers <= 0) {
            throw new IllegalArgumentException("Розмір загону має бути додатним");
        }
        this.guildName = guildName;
        this.members = new AbstractHeroUnit[maxMembers];
        this.memberCount = 0;
    }
    public String getGuildName() {
        return guildName;
    }
    public int getMemberCount() {
        return memberCount;
    }
    public boolean addMember(AbstractHeroUnit hero) {
        if (hero == null || memberCount >= members.length) {
            return false;
        }
        members[memberCount++] = hero;
        return true;
    }
    public boolean hasTank() {
        for (int i = 0; i < memberCount; i++) {
            if ("Tank".equals(members[i].getRole())) {
                return true;
            }
        }
        return false;
    }
    public int getTotalCombatPower() {
        int total = 0;
        for (int i = 0; i < memberCount; i++) {
            total += members[i].getCombatPower();
        }
        return total;
    }
    public boolean isReadyForRaid(int dungeonDifficulty) {
        return hasTank() && getTotalCombatPower() > dungeonDifficulty;
    }
    public void printReadiness(String dungeonName, int dungeonDifficulty) {
        System.out.printf("Гільдія «%s», підземелля «%s» (складність %d):%n",
                guildName, dungeonName, dungeonDifficulty);
        for (int i = 0; i < memberCount; i++) {
            System.out.printf("  - %-18s міць: %d%n", members[i], members[i].getCombatPower());
        }
        System.out.printf("  Танк: %s, сумарна міць: %d -> %s%n",
                hasTank() ? "є" : "немає", getTotalCombatPower(),
                isReadyForRaid(dungeonDifficulty) ? "ГОТОВИЙ до рейду" : "НЕ готовий");
    }
}
public class RaidDemo {
    public static void main(String[] args) {
        RaidParty party = new RaidParty("Лицарі Світанку", 5);
        party.addMember(new TankWarrior("Грім", 1200, 80));          // 600 + 800 = 1400
        party.addMember(new ArcaneMage("Аріель", 500, 90, 70));      // 450 + 560 = 1010
        party.addMember(new ArcaneMage("Мерлін", 450, 100, 85));     // 500 + 680 = 1180
        party.printReadiness("Печера Дракона", 3000);   // 3590 > 3000 -> готовий
        System.out.println();
        party.printReadiness("Цитадель Лича", 4000);    // 3590 < 4000 -> не готовий
        System.out.println();
        RaidParty noTank = new RaidParty("Чарівники Півночі", 5);
        noTank.addMember(new ArcaneMage("Ізольда", 480, 95, 80));    // 475 + 640 = 1115
        noTank.addMember(new ArcaneMage("Зевс", 520, 110, 90));      // 550 + 720 = 1270
        noTank.printReadiness("Печера Дракона", 1000);  // міць 2385 > 1000, але немає танка
    }
}

