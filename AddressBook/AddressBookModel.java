package AddressBook;

import java.util.Iterator;

public interface AddressBookModel {
    void addPerson(Person p);
    Iterator<Person> iterator();
}
