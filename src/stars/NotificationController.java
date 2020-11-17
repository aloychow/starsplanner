package stars;
import java.util.HashMap;

public class NotificationController {
    public NotificationController() {}

    public void notify(Student student) {
        NotificationFactory notifType = new NotificationFactory();
        HashMap<String, String> choice = student.getNotificationType();
        String keyMethod = choice.keySet().stream().findFirst().get();
        String recipient = choice.get(keyMethod);
        Notifications preferredNotifMethod = notifType.getNotifObj(keyMethod);
        preferredNotifMethod.sendNotification(recipient);
    }
}