package AddressBook;

import java.io.Serializable;
import java.util.*;

public class ArrayListAddressBookDataModel implements AddressBookModel, Serializable{
    private ArrayList<Person> persons;

    public ArrayListAddressBookDataModel() {
        persons = new ArrayList<Person>();
    }

    @Override
    public void addPerson(Person p){
        persons.add(p);
    }

    @Override
    public Iterator<Person> iterator(){
        return persons.iterator();
    }
}
