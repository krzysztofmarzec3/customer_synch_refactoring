package codingdojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

abstract class CustomerMatches<T extends Customer> {

    private final Collection<T> duplicates = new ArrayList<>();

    protected Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public boolean hasDuplicates() {
        return !duplicates.isEmpty();
    }

    public void addDuplicate(T duplicate) {
        duplicates.add(duplicate);
    }

    public Collection<T> getDuplicates() {
        return Collections.unmodifiableCollection(duplicates);
    }
}
