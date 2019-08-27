package services;

public interface ShippingLabel {
	public void generatePackingSlipForShipping(Membership memberOrderList);
    public void createDuplicatePackingSlipToRoyaltyDepartment(Membership memberOrderList);
}
