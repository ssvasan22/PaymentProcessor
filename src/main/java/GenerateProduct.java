import productCart.PaymentInfo;
import services.Membership;

public class GenerateProduct {

	public static void main(String[] args) {
		Membership membership = new Membership();
		PaymentInfo paymentInfo = new PaymentInfo(membership);
	}

}
