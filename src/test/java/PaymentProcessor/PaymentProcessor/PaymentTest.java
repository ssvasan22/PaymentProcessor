package PaymentProcessor.PaymentProcessor;

import org.testng.annotations.Test;
import productCart.PaymentInfo;
import services.Membership;
import org.testng.annotations.BeforeTest;

public class PaymentTest {
	Membership member = new Membership();
	PaymentInfo paymentInfo = new PaymentInfo(member);

	@BeforeTest
	public void setUp() {
		member.setMember_name("Tom");
		member.setEmailAddress("tom@ttt.ca");
		member.setPhoneNumber("+1 123 456 7890");
		member.setAddress("123 Boulevard St-Catherine, Montreal H12 N23, Quebec");
	}

	@Test
	public void testProductBehaviour() {
		paymentInfo.setProductName("Monitor");
		paymentInfo.setPrice(220.00);
//		paymentInfo.setPhysical_Product(false);
		paymentInfo.setPhysical_Product(true);
	}
	
	@Test
	public void testBookBehaviour() {
		paymentInfo.setBookName("Game Of Thrones");
		paymentInfo.setPrice(130.00);
		paymentInfo.setBook(true);
	}
	
	@Test
	public void testVideoBehaviour() {
//		paymentInfo.setVideoName("Game Of Thrones");
		paymentInfo.setVideoName("Learning to Ski");
		paymentInfo.setVideo(true);
	}
	
	@Test
	public void testMembershipActivate() {
		paymentInfo.setMembership(true);
	}
	
	@Test
	public void testMembershipUpgrade() {
		paymentInfo.setMembershipUpgrade(true);
	}

}
