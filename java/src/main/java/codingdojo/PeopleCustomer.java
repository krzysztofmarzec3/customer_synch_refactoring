package codingdojo;

import java.util.Objects;

class PeopleCustomer extends Customer {

    private Integer bonusPointsBalance;

    PeopleCustomer(ExternalCustomer.ExternalCustomerId externalId) {
        super(externalId, CustomerType.PERSON);
    }

    public Integer getBonusPointsBalance() {
        return bonusPointsBalance;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public void updateBonusPointsBalance(Integer bonusPointsBalance) {
        if (!Objects.equals(this.bonusPointsBalance, bonusPointsBalance)) {
            this.bonusPointsBalance = bonusPointsBalance;
        }
    }
}
