package stars;
import java.lang.*;
import java.lang.reflect.*;

public class NotificationFactory {
    public NotificationFactory() {}

    public Notifications getNotifObj(String className) {
        Notifications notification = null;

        try {

            Class<?> notif = ClassLoader.getSystemClassLoader().loadClass(className);

            notification = (Notifications) notif.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return notification;
    }
}

