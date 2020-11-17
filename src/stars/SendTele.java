package stars;

public class SendTele implements Notifications{
    public SendTele() {}

    public void sendNotification(String recipient){
        System.out.println("Sending telegram message to " + recipient);
    }
}