package productCart;

import java.util.Collections;
import java.util.List;

import services.Email;
import services.Membership;
import services.PackagingSlip;

public class PaymentInfo extends Membership{
	private boolean isPhysical_Product;
    private boolean isBook;
    private boolean isVideo;
    private boolean isMembershipActivation;
    private boolean isMembershipUpgrade;

    private String productName;
    private String bookName;
    private String videoName;
    private Double price;

    Email email = new Email();
    Membership membershipInfo = new Membership();
    AddCart addToCart = new AddCart();
    PackagingSlip slip = new PackagingSlip();

    public PaymentInfo(Membership mem) {
    	this.membershipInfo = mem;
    }
    public boolean isPhysical_Product() {
        return isPhysical_Product;
    }

    public void setPhysical_Product(boolean physical_Product) {
        isPhysical_Product = physical_Product;
        if(isPhysical_Product) {
            addToCart.setItemsToAddToCart(Collections.singletonList(getProductName()));
            slip.generatePackingSlipForShipping(membershipInfo);
            generateCommissionPaymentToAgent();
        }
    }

    public boolean isBook() {
        return isBook;
    }

    public void setBook(boolean book) {
        isBook = book;
        if(isBook) {
            addToCart.setItemsToAddToCart(getBookName());
            slip.generatePackingSlipForShipping(membershipInfo);
            slip.createDuplicatePackingSlipToRoyaltyDepartment(membershipInfo);
            generateCommissionPaymentToAgent();
        }
    }

    public boolean isVideo() {
        return isVideo;
    }

    public void setVideo(boolean video) {
        isVideo = video;
        if(isVideo) {
            if(getVideoName().equalsIgnoreCase("Learning to Ski")) {
                addToCart.setItemsToAddToCart(Collections.singletonList("Learning to Ski"));
//                addToCart.getItemsToAddToCart().add("First Aid");
                addToCart.setItemsToAddToCart(Collections.singletonList("First Aid"));
                slip.generatePackingSlipForShipping(membershipInfo);
                System.out.println("Payment for videos");
                for(int i = 0; i < addToCart.getItemsToAddToCart().size(); i++) {
                	System.out.println("Video Name : " + addToCart.getItemsToAddToCart().get(i));
                }
            } else {
                addToCart.setItemsToAddToCart(Collections.singletonList(getVideoName()));
                for(int i = 0; i < addToCart.getItemsToAddToCart().size(); i++) {
                	System.out.println("Video Name : " + addToCart.getItemsToAddToCart().get(i));
                }
            }
        }
    }

    public boolean isMembership() {
        return isMembershipActivation;
    }

    public void setMembership(boolean membership) {
        isMembershipActivation = membership;
        if(isMembershipActivation) {
            email.sendEmail("activate", membershipInfo.getEmailAddress());
        }
    }

    public boolean isMembershipUpgrade() {
        return isMembershipUpgrade;
    }

    public void setMembershipUpgrade(boolean membershipUpgrade) {
        isMembershipUpgrade = membershipUpgrade;
        if(isMembershipUpgrade()) {
            email.sendEmail("upgrade", membershipInfo.getEmailAddress());
        }
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<String> getBookName() {
        return Collections.singletonList(bookName);
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public void generateCommissionPaymentToAgent() {
        System.out.println("==========================================");
        System.out.println("Generating agent commission for the order");
        System.out.println("==========================================");
        Double commission = getPrice() * 0.15;
        System.out.println("Agent commission for the item is : " + commission);
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
