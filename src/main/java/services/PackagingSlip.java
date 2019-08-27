package services;

import services.Membership;

public class PackagingSlip implements ShippingLabel {
	 
	public void generatePackingSlipForShipping(Membership membershipInfo) {
		System.out.println("===============================================");
        System.out.println("************ PACKING SLIP *************");
        System.out.println("===============================================");
        System.out.println("Name : " + membershipInfo.getMember_name());
        System.out.println("Address : " + membershipInfo.getAddress());
        System.out.println("Phone Number : " + membershipInfo.getPhoneNumber());
        System.out.println();
        System.out.println("Email Address : " + membershipInfo.getEmailAddress());
    }
    public void createDuplicatePackingSlipToRoyaltyDepartment(Membership membership) {
    	System.out.println("===============================================");
        System.out.println("****** PACKING SLIP FOR ROYALTY DEPT. *******");
        System.out.println("===============================================");
        System.out.println("Name : " + membership.getMember_name());
        System.out.println("Address : " + membership.getAddress());
        System.out.println("Phone Number : " + membership.getPhoneNumber());
        System.out.println();
        System.out.println("Email Address : " + membership.getEmailAddress());
    }
}
