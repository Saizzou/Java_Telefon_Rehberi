package AddressBook;

import java.io.Serializable;

public class Person implements Serializable{
    private final String isim;
    private final String soyisim;
    private final String numara;

    public Person(String isim, String soyisim, String numara){
        this.isim = isim;
        this.soyisim = soyisim;
        this.numara = numara;
    }

    public String getIsim(){
        return isim;
    }

    public String getSoyisim(){
        return soyisim;
    }

    public String getNumara(){
        return numara;
    }
}
