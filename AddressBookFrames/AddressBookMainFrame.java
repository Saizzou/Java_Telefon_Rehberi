package AddressBookFrames;

import java.awt.*;

public class AddressBookMainFrame extends Frame {
    public AddressBookMainFrame(PersonPanel personPanel, Button newButton){
        super("Adress Kitabi");
        setBackground(Color.LIGHT_GRAY);
        Panel dataPanel = new Panel(new GridLayout(1,3));
        dataPanel.add(new Label("Isim: "));
        dataPanel.add(new Label("Soyisim: "));
        dataPanel.add(new Label("Telefon No: "));
        add(dataPanel,BorderLayout.PAGE_START);
        add(personPanel, BorderLayout.CENTER);

        Panel southPanel = new Panel();
        southPanel.add(newButton);
        add(southPanel, BorderLayout.SOUTH);
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
