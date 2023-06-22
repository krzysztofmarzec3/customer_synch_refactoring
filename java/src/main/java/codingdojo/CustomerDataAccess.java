package codingdojo;

class CustomerDataAccess {

    private final CustomerDataLayer customerDataLayer;

    CustomerDataAccess(CustomerDataLayer customerDataLayer) {
        this.customerDataLayer = customerDataLayer;
    }

    Customer updateCustomerRecord(Customer customer) {
        updateShoppingList(customer);
        return customerDataLayer.updateCustomerRecord(customer);
    }

    Customer createCustomerRecord(Customer customer) {
        updateShoppingList(customer);
        return customerDataLayer.createCustomerRecord(customer);
    }

    private void updateShoppingList(Customer customer) {
        for (ShoppingList consumerShoppingList : customer.getShoppingLists()) {
            updateShoppingList(consumerShoppingList);
        }
    }

    private void updateShoppingList(ShoppingList consumerShoppingList) {
        customerDataLayer.updateShoppingList(consumerShoppingList);
    }
}
