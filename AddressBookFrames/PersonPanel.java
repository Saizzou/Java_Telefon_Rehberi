package AddressBookFrames;

import AddressBook.*;

import java.util.Iterator;
import java.awt.*;


public class PersonPanel extends Panel {
    private AddressBookModel model;

    private static final Color EVEN_ROW_COLOR = new Color(240, 240, 255);
    private static final Color ODD_ROW_COLOR = new Color(255,255,240);

    public PersonPanel(AddressBookModel model){
        this.model = model;
        setBackground(Color.BLACK);
        setLayout(new GridLayout(0, 3,0,1));
        refresh();
    }
    public void refresh() {
        removeAll();
        boolean isEvenRowNumber = true;
        Iterator<Person> iterator = model.iterator();
        while (iterator.hasNext()){
            Person person = iterator.next();
            Color rowColor = isEvenRowNumber ? EVEN_ROW_COLOR : ODD_ROW_COLOR;
            Label firstNameLabel = new Label(person.getIsim());
            firstNameLabel.setBackground(rowColor);
            add(firstNameLabel);
            Label lastNameLabel = new Label(person.getSoyisim());
            lastNameLabel.setBackground(rowColor);
            add(lastNameLabel);
            Label telefonLabel = new Label(person.getNumara());
            telefonLabel.setBackground(rowColor);
            add(telefonLabel);
            isEvenRowNumber = !isEvenRowNumber;
        }
        revalidate();
    }

}
