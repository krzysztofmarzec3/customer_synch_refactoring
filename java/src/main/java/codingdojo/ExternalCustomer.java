package codingdojo;

import java.util.List;
import java.util.Objects;

public class ExternalCustomer {
    private Address address;
    private String name;
    private String preferredStore;
    private List<ShoppingList> shoppingLists;
    private ExternalCustomerId externalId;
    private String companyNumber;
    private Integer bonusPointsBalance;

    public Integer getBonusPointsBalance() {
        return bonusPointsBalance;
    }

    public ExternalCustomerId getExternalId() {
        return externalId;
    }

    public String getCompanyNumber() {
        return companyNumber;
    }

    public boolean isCompany() {
        return companyNumber != null;
    }

    public Address getPostalAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreferredStore() {
        return preferredStore;
    }

    public void setPreferredStore(String preferredStore) {
        this.preferredStore = preferredStore;
    }

    public List<ShoppingList> getShoppingLists() {
        return shoppingLists;
    }

    public void setShoppingLists(List<ShoppingList> shoppingLists) {
        this.shoppingLists = shoppingLists;
    }

    public void setExternalId(ExternalCustomerId externalId) {
        this.externalId = externalId;
    }

    public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setBonusPointsBalance(Integer bonusPointsBalance) {
        this.bonusPointsBalance = bonusPointsBalance;
    }

    static class ExternalCustomerId {
        public String getExternalId() {
            return externalId;
        }

        private final String externalId;

        ExternalCustomerId(String externalId) {
            this.externalId = externalId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Customer)) return false;
            Customer customer = (Customer) o;
            return Objects.equals(this.externalId, customer.getExternalId().externalId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(externalId);
        }

        @Override
        public String toString() {
            return externalId;
        }
    }
}
