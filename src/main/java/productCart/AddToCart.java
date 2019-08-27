package productCart;

import java.util.ArrayList;
import java.util.List;

public class AddToCart {
	private ArrayList<String> itemsToAddToCart = new ArrayList<String>();

    public void AddToCart() {

    }

    public void AddToCart(String item) {
        getItemsToAddToCart().add(item);
    }

    public List<String> getItemsToAddToCart() {
        return itemsToAddToCart;
    }

    public void setItemsToAddToCart(ArrayList<String> itemsToAddToCart) {
        this.itemsToAddToCart = itemsToAddToCart;
    }
}
