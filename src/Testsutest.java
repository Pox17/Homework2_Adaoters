import java.util.Collection;
import java.util.Objects;
import java.util.Vector;
import java.lang.Object;

public class Testsutest {
    public static void main(String[] args) {
        Vector v = new Vector();
        String pip1 = "Pippero";
        String pip2 = "Pippero";
        boolean isEq = Objects.equals(pip1, pip2);
        System.out.println("Sono uguali? " + isEq);
        int i = 2;
        valueTest(i);
        boolean isEq2 = i == 2;
        System.out.println("Sono uguali? " + isEq2);
        CollectionAdapter<String> cAd = new CollectionAdapter<String>();

        //CollectionAdapter<int> cl = new CollectionAdapter<int>();

    }

    public static void valueTest(int i) {
        i = i+1;
    }

}
