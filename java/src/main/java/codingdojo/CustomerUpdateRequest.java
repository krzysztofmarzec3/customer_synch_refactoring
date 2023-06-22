package codingdojo;

import java.util.Collections;
import java.util.List;

public class CustomerUpdateRequest {
    private final String name;
    private final List<ShoppingList> shoppingLists;
    private final String preferredStore;
    private final Address postalAddress;

    public CustomerUpdateRequest(String name, List<ShoppingList> shoppingLists, String preferredStore, Address postalAddress) {
        this.name = name;
        this.shoppingLists = Collections.unmodifiableList(shoppingLists);
        this.preferredStore = preferredStore;
        this.postalAddress = postalAddress;
    }

    public String getName() {
        return name;
    }

    public List<ShoppingList> getShoppingLists() {
        return shoppingLists;
    }

    public String getPreferredStore() {
        return preferredStore;
    }

    public Address getPostalAddress() {
        return postalAddress;
    }
}
