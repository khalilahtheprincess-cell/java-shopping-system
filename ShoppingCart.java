import java.util.ArrayList;

public class ShoppingCart {

	 private ArrayList<ItemOrder> orders;
	    private boolean discount;

	    /**
	     * Constructs an empty shopping cart.
	     */
	    public ShoppingCart() {
	        orders = new ArrayList<ItemOrder>();
	        discount = false;
	    }

	    /**
	     * Adds an item order to this cart.
	     * If an order for the same item already exists, it is replaced
	     * with the new one (regardless of quantity, including 0).
	     *
	     * @param newOrder the item order to be added or used to replace an existing one
	     */
	    public void add(ItemOrder newOrder) {
	        Item newItem = newOrder.getItem();

	        // Look for an existing order for the same item
	        for (int i = 0; i < orders.size(); i++) {
	            ItemOrder current = orders.get(i);
	            if (current.getItem() == newItem) { // same Item object
	                orders.set(i, newOrder);       // replace old order
	                return;
	            }
	        }

	        // If not found, add as a new order
	        orders.add(newOrder);
	    }

	    /**
	     * Sets whether this cart should receive the 10% discount.
	     * @param value true if discount should be applied, false otherwise
	     */
	    public void setDiscount(boolean value) {
	        this.discount = value;
	    }

	    /**
	     * Returns the total cost of all item orders in the cart.
	     * If the discount is active, returns 90% of the subtotal.
	     *
	     * @return total cost as a double
	     */
	    public double getTotal() {
	        double total = 0.0;

	        for (ItemOrder order : orders) {
	            total += order.getPrice();
	        }

	        if (discount) {
	            total = total * 0.90; // 10% off
	        }

	        return total;
	    }

	    @Override
	    public String toString() {
	        return "ShoppingCart with " + orders.size() + " item orders"
	               + (discount ? " (10% discount applied)" : "");
	    }
	}

