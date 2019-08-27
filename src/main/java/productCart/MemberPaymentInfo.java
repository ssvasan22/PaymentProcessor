package productCart;

public interface MemberPaymentInfo {
	public void productInfo(String name, String email_ID, String phone, String addr, boolean isPhysicalProduct);
    public void bookInfo(String name, String email_ID, String phone, String addr, boolean isBook);
    public void videoInfo(String name, String email_ID, String phone, String addr, boolean isVideo, String videoName);
    public void memberActivate(String email_ID, boolean isActivate);
    public void memberUpgrade(String email_ID, boolean isUpgrade);
}
