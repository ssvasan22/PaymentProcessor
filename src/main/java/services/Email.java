package services;

public class Email {
	public void sendEmail(String message, String email_ID) {
        message = message.toLowerCase();
        if(message.contains("upgrade")) {
        	System.out.println();
            System.out.println("Sending Email to ID : " + email_ID);
            System.out.println("Thank you for the payment. Your membership is Upgraded.");
            System.out.println();
        } else if (message.contains("activate")) {
        	System.out.println();
            System.out.println("Sending Email to ID : " + email_ID);
            System.out.println("Membership activation successful");
            System.out.println();
        }

    }
}
