package services;

public interface ShippingLabel {
	public void generatePackingSlipForShipping(Membership memberOrderList, String products, Double price);
    public void createDuplicatePackingSlipToRoyaltyDepartment(Membership memberOrderList, String products, Double price);
}
