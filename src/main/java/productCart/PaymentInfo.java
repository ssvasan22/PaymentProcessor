package productCart;

import java.util.ArrayList;
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

    private ArrayList<String> itemsToBeAddedToCart = new ArrayList<>();

    Email email = new Email();
    Membership membershipInfo = new Membership();
    AddToCart addToCart = new AddToCart();
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
            itemsToBeAddedToCart.clear();
            itemsToBeAddedToCart.add(getProductName());
            addToCart.setItemsToAddToCart(itemsToBeAddedToCart);
            slip.generatePackingSlipForShipping(membershipInfo, getProductName(), getPrice());
            generateCommissionPaymentToAgent();
        }
    }

    public boolean isBook() {
        return isBook;
    }

    public void setBook(boolean book) {
        isBook = book;
        if(isBook) {
            itemsToBeAddedToCart.clear();
            itemsToBeAddedToCart.add(getBookName());
            addToCart.setItemsToAddToCart(itemsToBeAddedToCart);
            slip.generatePackingSlipForShipping(membershipInfo, getBookName(), getPrice());
            slip.createDuplicatePackingSlipToRoyaltyDepartment(membershipInfo, getBookName(), getPrice());
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
                itemsToBeAddedToCart.clear();
                itemsToBeAddedToCart.add("Learning To Ski");
                itemsToBeAddedToCart.add("First Aid");
                addToCart.setItemsToAddToCart(itemsToBeAddedToCart);
                slip.generatePackingSlipForShipping(membershipInfo, getVideoName(), getPrice());
                for(int i = 0; i < addToCart.getItemsToAddToCart().size(); i++) {
                	System.out.println("Video Name : " + addToCart.getItemsToAddToCart().get(i));
                }
            } else {
                itemsToBeAddedToCart.clear();
                itemsToBeAddedToCart.add(getVideoName());
                addToCart.setItemsToAddToCart(itemsToBeAddedToCart);
                slip.generatePackingSlipForShipping(membershipInfo, getVideoName(), getPrice());
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

    public String getBookName() {
        return bookName;
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
