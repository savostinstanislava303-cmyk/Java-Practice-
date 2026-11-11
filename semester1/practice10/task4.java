package practice10;

class NotificationSender {
    private final String recipient;
    public NotificationSender(String recipient) {
        this.recipient = recipient;
    }
    public String send(String message) {
        return "Отримувач: " + recipient + "\nПовідомлення: " + message;
    }
    public String getRecipient() {
        return recipient;
    }
}
class EmailSender extends NotificationSender {
    public EmailSender(String recipient) {
        super(recipient);
    }
    @Override
    public String send(String message) {
        return "EMAIL\n"
                + "Кому: " + getRecipient() + "\n"
                + "Тема: Важливе сповіщення\n"
                + "Текст: " + message;
    }
}
class SmsSender extends NotificationSender {
    public SmsSender(String recipient) {
        super(recipient);
    }
    @Override
    public String send(String message) {

        if (message.length() > 70) {
            message = message.substring(0, 70);
        }
        return "SMS\n"
                + "Номер: " + getRecipient() + "\n"
                + "Текст: " + message;
    }
}
class TelegramBotSender extends NotificationSender {
    public TelegramBotSender(String recipient) {
        super(recipient);
    }
    @Override
    public String send(String message) {
        return "TELEGRAM\n"
                + "Користувач: " + getRecipient() + "\n"
                + "Повідомлення:  **" + message + "** ⚠️";
    }
}
public class task4 {
    public static void broadcastAlert(
            NotificationSender[] senders,
            String alertText) {
        for (NotificationSender sender : senders) {
            System.out.println(sender.send(alertText));
            System.out.println("--------------------------");
        }
    }
    public static void main(String[] args) {
        NotificationSender[] senders = {
                new EmailSender("example@gmail.com"),
                new SmsSender("+380991112233"),
                new TelegramBotSender("@example_user")
        };
        String alertText = "Увага! Важливе повідомлення. "
                + "Просимо всіх ознайомитися з інформацією "
                + "та дотримуватися правил безпеки.";
        broadcastAlert(senders, alertText);
    }
}
