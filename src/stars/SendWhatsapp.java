package stars;

public class SendWhatsapp implements Notifications{
    public SendWhatsapp() {}

    public void sendNotification(String recipient) {
        System.out.println("Sending whatsapp message to " + recipient);
    }
}