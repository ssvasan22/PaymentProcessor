package services;

public class Email {
	public void sendEmail(String message, String email_ID) {
        message = message.toLowerCase();
        if(message.contains("upgrade")) {
            System.out.println("Member Email ID : " + email_ID);
            System.out.println("===========================================================");
            System.out.println("From: Tempo" );
            System.out.println("Subject: Notification for Upgrading Membership");
            System.out.println("Thank you for the payment. Your membership is now Upgraded. Thank you for choosing us!");
            System.out.println();
            System.out.println("===========================================================");
        } else if (message.contains("activate")) {
            System.out.println("Member Email ID : " + email_ID);
            System.out.println("===========================================================");
            System.out.println("From: Tempo" );
            System.out.println("Subject: Notification for Activating Membership");
            System.out.println("Thank you for the payment. Your membership is now activated. Thank you for choosing us!");
            System.out.println();
            System.out.println("===========================================================");
        }

    }
}
