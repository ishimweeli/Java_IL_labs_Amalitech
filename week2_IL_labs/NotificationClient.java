package week2_IL_labs;



// Interface representing the base notification
interface Notification {
    void send(String message);
}

// Concrete implementation of the base notification (SimpleNotification)
class SimpleNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending simple notification: " + message);
    }
}

// Abstract decorator class
abstract class NotificationDecorator implements Notification {
    protected Notification notification;

    public NotificationDecorator(Notification notification) {
        this.notification = notification;
    }

    @Override
    public void send(String message) {
        notification.send(message); // Delegates the send operation to the wrapped notification
    }
}

// Concrete decorator for adding WhatsApp functionality
class WhatsAppDecorator extends NotificationDecorator {
    public WhatsAppDecorator(Notification notification) {
        super(notification);
    }

    @Override
    public void send(String message) {
        super.send(message); // Call the base send method of NotificationDecorator
        System.out.println("Sending WhatsApp message: " + message);
    }
}

// Concrete decorator for adding Facebook functionality
class FacebookDecorator extends NotificationDecorator {
    public FacebookDecorator(Notification notification) {
        super(notification);
    }

    @Override
    public void send(String message) {
        super.send(message); // Call the base send method of NotificationDecorator
        System.out.println("Posting on Facebook: " + message);
    }
}

// Concrete decorator for adding Email functionality
class EmailDecorator extends NotificationDecorator {
    public EmailDecorator(Notification notification) {
        super(notification);
    }

    @Override
    public void send(String message) {
        super.send(message); // Call the base send method of NotificationDecorator
        System.out.println("Sending email: " + message);
    }
}

// Concrete decorator for adding SMS functionality
class SMSDecorator extends NotificationDecorator {
    public SMSDecorator(Notification notification) {
        super(notification);
    }

    @Override
    public void send(String message) {
        super.send(message); // Call the base send method of NotificationDecorator
        System.out.println("Sending SMS: " + message);
    }
}

// Main class to test the decorator pattern
public class NotificationClient {
    public static void main(String[] args) {
        // Create a simple notification
        Notification notification = new SimpleNotification();

//         Wrap the simple notification with decorators to add functionalities
        notification = new WhatsAppDecorator(notification);
        notification = new FacebookDecorator(notification);
        notification = new EmailDecorator(notification);
        notification = new SMSDecorator(notification);

//         Send the decorated notification
        notification.send("Hello, world!");
    }
}
