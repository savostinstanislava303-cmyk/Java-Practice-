package practice8;


class SecurityTerminal {
    public final String generateAuthHash(String user) {
        return "AUTH-SHA-" + user.toUpperCase();
    }
    public String getWelcomeBanner() {
        return "Ласкаво просимо до термінала безпеки!";
    }
}
class CustomTerminal extends SecurityTerminal {
    @Override
    public String getWelcomeBanner() {
        return "Вітаємо! Ви використовуєте власний термінал.";
    }
    public void authenticateUser(String user) {
        System.out.println("Підпис користувача: " +
                generateAuthHash(user));
    }
    /*
    @Override
    public String generateAuthHash(String user) {
        return "CUSTOM-" + user;
    }
    */
    // Цей метод не можна перевизначити, оскільки в SecurityTerminal він оголошений з ключовим словом final.
    // Спроба перевизначення викличе помилку компіляції.
}

public class practice28 {
    public static void main(String[] args) {
        CustomTerminal terminal = new CustomTerminal();
        System.out.println(terminal.getWelcomeBanner());
        terminal.authenticateUser("Микита");
        System.out.println(terminal.generateAuthHash("Микита"));
    }
}