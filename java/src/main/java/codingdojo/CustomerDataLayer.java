package codingdojo;

public interface CustomerDataLayer extends CustomerDataReadLayer {

    Customer updateCustomerRecord(Customer customer);

    Customer createCustomerRecord(Customer customer);

    void updateShoppingList(ShoppingList consumerShoppingList);
}
