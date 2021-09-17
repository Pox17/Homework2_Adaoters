import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class CollectionAdapterTest {
    /**
     * Test del metodo add
     */
    @Test
    public void addTest() {
        CollectionAdapter<String> cAd = new CollectionAdapter();
        cAd.add("Pippero");
        assertTrue(cAd.contains("Pippero"));
    }

    /**
     * Test del metodo add con un parametro "null"
     */
    @Test
    public void addTestNull() {
        CollectionAdapter<String> cAd = new CollectionAdapter();
        cAd.add(null);
        assertTrue(cAd.contains(null));
    }

    /**
     * Test del metodo addAll()
     */
    @Test
    public void addAllTest() {
        CollectionAdapter<String> cAd = new CollectionAdapter();
        CollectionAdapter<String> cAdAdd = new CollectionAdapter();
        cAd.add("Pippero");
        cAdAdd.add("Ramaya");
        cAdAdd.add("Sandokan");
        cAdAdd.add("Rasputin");
        cAd.addAll(cAdAdd);
        assertTrue(cAd.contains("Ramaya"));
        assertTrue(cAd.contains("Rasputin"));
        assertTrue(cAd.contains("Sandokan"));
        assertTrue(cAd.containsAll(cAdAdd));

    }

    /**
     * Test del metodo clear()
     */
    @Test
    public void clearTest() {
        CollectionAdapter<String> cAd = new CollectionAdapter();
        cAd.add("Pippero");

        assertFalse(cAd.isEmpty());
        cAd.clear();
        assertTrue(cAd.isEmpty());
        cAd.add("Ramaya");
        cAd.add("Sandokan");
        cAd.add("Rasputin");
        assertFalse(cAd.isEmpty());
        cAd.clear();
        assertTrue(cAd.isEmpty());
    }


    /**
     * Test metodo contains
     */
    @Test
    public void containsTest() {
        CollectionAdapter<String> cAd = new CollectionAdapter();
        cAd.add("Pippero");
        assertTrue(cAd.contains("Pippero"));
        assertFalse(cAd.contains("Ramaya"));
        cAd.add("Ramaya");
        assertTrue(cAd.contains("Ramaya"));
        cAd.remove("Pippero");
        assertFalse(cAd.contains("Pippero"));
    }

    /**
     * Test metodo contains
     */
    @Test
    public void containsNullTest() {
        CollectionAdapter<String> cAd = new CollectionAdapter();
        cAd.add(null);
        assertTrue(cAd.contains(null));
        assertFalse(cAd.contains("Pippero"));
        cAd.add("Pippero");
        assertTrue(cAd.contains("Pippero"));
        cAd.remove(null);
        assertFalse(cAd.contains(null));
    }

    /**
     * Test del metodo containsAll()
     */
    @Test
    public void containsAllTest() {
        CollectionAdapter<String> cAd = new CollectionAdapter();
        CollectionAdapter<String> cAdRef = new CollectionAdapter();
        CollectionAdapter<String> cAdRefFalse = new CollectionAdapter();
        cAd.add("Ramaya");
        cAd.add("Sandokan");
        cAd.add("Rasputin");
        cAd.add("Ramaya");
        cAd.add("Bulgaria");
        String ins0 = "Rasputin";
        cAdRef.add("Ramaya");
        cAdRef.add("Sandokan");
        cAdRef.add(ins0);
        assertTrue(cAd.containsAll(cAdRef));
        cAdRefFalse.add("Bulgaria");
        cAdRefFalse.add("Ramaya");
        cAdRefFalse.add("Balsa");
        assertFalse(cAd.containsAll(cAdRefFalse));

    }

    /**
     * Test del metodo containsAll() nel caso in cui il
     */
    @Test
    public void containsALlVoidRefTest() {
        CollectionAdapter<String> cAd = new CollectionAdapter();
        CollectionAdapter<String> cAdRef = new CollectionAdapter();
        cAd.add("Ramaya");
        cAd.add("Sandokan");
        cAd.add("Rasputin");
        cAd.add("Ramaya");
        cAd.add("Bulgaria");
        assertTrue(cAd.containsAll(cAdRef));
    }

    /**
     * Test del metodo containsAll() nel caso in cui il
     */
    @Test
    public void containsALlNullRefTest() {
        CollectionAdapter<String> cAd = new CollectionAdapter();
        CollectionAdapter<String> cAdRef = new CollectionAdapter();
        cAd.add("Ramaya");
        cAd.add("Sandokan");
        cAd.add("Rasputin");
        cAd.add(null);
        cAd.add(null);
        cAd.add("Bulgaria");
        cAdRef.add(null);
        assertTrue(cAd.containsAll(cAdRef));

    }

    /**
     * Test del metodo containsAll() nel caso in cui il
     */
    @Test
    public void containsALlModifiesTest() {
        CollectionAdapter<String> cAd = new CollectionAdapter();
        CollectionAdapter<String> cAdRef = new CollectionAdapter();
        CollectionAdapter<String> cAdRefRef = new CollectionAdapter();
        cAd.add("Ramaya");
        cAd.add("Sandokan");
        cAd.add("Rasputin");
        cAd.add("Ramaya");
        cAd.add("");
        cAd.add("Bulgaria");

        cAdRef.add("Ramaya");
        cAdRef.add("Sandokan");
        cAdRef.add("Ramaya");
        cAdRef.add("");
        cAdRef.add("Bulgaria");
        assertTrue(cAd.containsAll(cAdRef));
        cAdRefRef.add("Ramaya");
        cAdRefRef.add("Sandokan");
        cAdRefRef.add("Ramaya");
        cAdRefRef.add("");
        cAdRefRef.add("Bulgaria");
        assertTrue(cAdRefRef.equals(cAdRef));
    }

    /**
     * Test del metodo equals()
     */
    @Test
    public void equalsTest() {
        CollectionAdapter<String> cAd = new CollectionAdapter();
        CollectionAdapter<String> cAdRef = new CollectionAdapter();
        cAd.add("Ramaya");
        cAd.add("Sandokan");
        cAd.add("Rasputin");
        cAd.add("Ramaya");
        cAd.add("");
        cAd.add("Bulgaria");
        cAdRef.add("Ramaya");
        cAdRef.add("Sandokan");
        cAdRef.add("Rasputin");
        cAdRef.add("Ramaya");
        cAdRef.add("");
        cAdRef.add("Bulgaria");
        assertTrue(cAd.equals(cAdRef));
    }

    /**
     * Test del metodo hashCode()
     */
    @Test
    public void hashCodeTest() {
        CollectionAdapter<String> cAd = new CollectionAdapter();
        CollectionAdapter<String> cAdRef = new CollectionAdapter();
        cAd.add("Ramaya");
        cAd.add("Sandokan");
        cAd.add("Rasputin");
        cAd.add("Ramaya");
        cAd.add("");
        cAd.add("Bulgaria");
        cAdRef.add("Ramaya");
        cAdRef.add("Sandokan");
        cAdRef.add("Rasputin");
        cAdRef.add("Ramaya");
        cAdRef.add("");
        cAdRef.add("Bulgaria");
        assertEquals(cAdRef.hashCode(),cAd.hashCode());
    }
    /**
     * Test del metodo hashCode()
     */
    @Test
    public void hashCodeObjTest() {
        CollectionAdapter<Object> cAd = new CollectionAdapter();
        CollectionAdapter<Object> cAdRef = new CollectionAdapter();
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = "ciao";
        cAd.add(obj1);
        cAd.add(obj2);
        cAd.add(obj3);
        cAdRef.add(obj1);
        cAdRef.add(obj2);
        cAdRef.add(obj3);
        assertEquals(cAdRef.hashCode(),cAd.hashCode());
    }

    /**
     * Test della consistenza del metodo hashCode() con il metodo equals()
     */
    @Test
    public void equalsHashCodeTest() {
        CollectionAdapter<String> cAd = new CollectionAdapter();
        CollectionAdapter<String> cAdRef = new CollectionAdapter();
        cAd.add("Ramaya");
        cAd.add("Sandokan");
        cAd.add("Rasputin");
        cAd.add("Ramaya");
        cAd.add("");
        cAd.add("Bulgaria");
        cAdRef.add("Ramaya");
        cAdRef.add("Sandokan");
        cAdRef.add("Rasputin");
        cAdRef.add("Ramaya");
        cAdRef.add("");
        cAdRef.add("Bulgaria");
        assertEquals(cAdRef.hashCode(),cAd.hashCode());
        assertTrue(cAd.equals(cAdRef));
    }

    /**
     * Test della consistenza del metodo hashCode() con il metodo equals()
     */
    @Test
    public void equalsHashCodeDifferentOrderOfInputTest() {
        CollectionAdapter<String> cAd = new CollectionAdapter();
        CollectionAdapter<String> cAdRef = new CollectionAdapter();
        cAd.add("Sandokan");
        cAd.add("Ramaya");
        cAd.add("Rasputin");
        cAd.add("Ramaya");
        cAd.add("");
        cAd.add("Bulgaria");
        cAdRef.add("Sandokan");
        cAdRef.add("Rasputin");
        cAdRef.add("Ramaya");
        cAdRef.add("");
        cAdRef.add("Ramaya");
        cAdRef.add("Bulgaria");
        assertEquals(cAdRef.hashCode(),cAd.hashCode());
        assertTrue(cAd.equals(cAdRef));
    }
    /**
     * Test del metodo isEmpty()
     * facendo un controllo prima su una collection inizializzata ma con all'interno 0 elementi,
     * successivamente aggiungendo un certo numero di elementi >0 valutando che il metodo dia valore negativo,
     * infine si svuota la collection e si aspetta nuovamente un valore positivo da parte di isEmpty
     */
    @Test
    public void isEmptyTest() {
        CollectionAdapter<String> cAd = new CollectionAdapter();
        assertTrue(cAd.isEmpty());
        cAd.add("Pippero");
        assertFalse(cAd.isEmpty());
        cAd.remove("Pippero");
        assertTrue(cAd.isEmpty());
    }

    /**
     * test metodo iterator()
     */
    @Test
    public void iteratorTest() {
        CollectionAdapter<String> cAd = new CollectionAdapter();
        Iterator<String> cAdIter = cAd.iterator();
        cAd.add("Pippero");
        assertTrue(cAdIter.hasNext());
        assertEquals("Pippero", cAdIter.next());
    }

    /**
     * test metodo iterator()
     */
    @Test
    public void iteratorSequenceTest() {
        CollectionAdapter<String> cAd = new CollectionAdapter();
        Iterator<String> cAdIter = cAd.iterator();
        cAd.add("Pippero");
        cAd.add("Ramaya");
        cAd.add("Sandokan");
        cAd.add("Rasputin");
        cAd.add(null);
        cAd.add(null);
        cAd.add("Bulgaria");
        cAd.add(null);
        int count = 0;
        while(cAdIter.hasNext()) {
            assertEquals(cAd.elementAt(count), cAdIter.next());
            count++;
        }
        assertEquals(cAd.size(),count);
    }

    /**
     * Test del metodo remove
     */
    @Test
    public void removeTest() {
        CollectionAdapter<String> cAd = new CollectionAdapter();
        cAd.add("Pippero");
        assertTrue(cAd.remove("Pippero"));
        assertFalse(cAd.remove("Ramaya"));

    }

    /**
     * Test del metodo remove con parametro null
     */
    @Test
    public void removeNullTest() {
        CollectionAdapter<String> cAd = new CollectionAdapter();
        cAd.add(null);
        assertTrue(cAd.remove(null));
        assertFalse(cAd.remove("Ramaya"));

    }

    /**
     * Test sul metodo remove che valuta che in caso di presenza di più elementi uguali ne venga eliminata solo un'istanza
     */
    @Test
    public void removeOneInstanceTest() {
        CollectionAdapter<String> cAd = new CollectionAdapter();
        cAd.add("Pippero");
        String pip1 = "Pippero";
        cAd.add(pip1);
        assertTrue(cAd.remove("Pippero"));
        assertTrue(cAd.contains("Pippero"));
    }

    /**
     * Test sul metodo remove che valuta che in caso di presenza di più "null" ne venga eliminata solo un'istanza
     */
    @Test
    public void removeOneInstanceNullTest() {
        CollectionAdapter<String> cAd = new CollectionAdapter();
        cAd.add(null);
        String pip1 = null;
        cAd.add(pip1);
        assertTrue(cAd.remove(null));
        assertTrue(cAd.contains(null));
    }

    /**
     * Test del metodo retainAll()
     */
    @Test
    public void retainAllTest() {
        CollectionAdapter<String> cAd = new CollectionAdapter();
        CollectionAdapter<String> cAd2 = new CollectionAdapter();
        cAd.add("Pippero");
        cAd.add("Ramaya");
        cAd.add("Bulgaria");
        cAd.add("Pampero");
        cAd2.add("Bulgaria");
        cAd2.add("Pampero");
        System.out.println(cAd.toString());
        System.out.println(cAd2.toString());
        assertEquals(4,cAd.size());
        assertEquals(2,cAd2.size());
        assertTrue(cAd.retainAll(cAd2));
        assertEquals(2,cAd.size());
        //System.out.println(cAd.toString());
        assertTrue(cAd.contains("Bulgaria"));
        assertFalse(cAd.contains("Pippero"));
        assertTrue(cAd.contains("Pampero"));
        assertFalse(cAd.contains("Ramaya"));
        assertTrue(cAd.containsAll(cAd2));
        assertEquals(2,cAd.size());
    }

    /**
     * Test del metodo size()
     */
    @Test
    public void sizeTest() {
        CollectionAdapter<String> cAd = new CollectionAdapter();
        assertEquals(0,cAd.size());
        cAd.add("Pippero");
        assertEquals(1,cAd.size());
        cAd.remove("Pippero");
        assertEquals(0,cAd.size());
    }

    /**
     * Test del metodo toArray()
     */
    @Test
    public void toArrayTest() {
        CollectionAdapter<String> cAd = new CollectionAdapter();
        cAd.add("Pippero");
        cAd.add("Ramaya");
        cAd.add("Bulgaria");
        Object[] cAdArray = cAd.toArray();
        Iterator cAdIter = cAd.iterator();
        for(int i = 0; i < cAdArray.length; i++) {
            assertEquals(cAdIter.next(), cAdArray[i]);
        }
    }

    /**
     * Test del metodo toArray(T[])
     */
    @Test
    public void toArrayInputTest() {
        CollectionAdapter<String> cAd = new CollectionAdapter();
        cAd.add("Pippero");
        cAd.add("Ramaya");
        cAd.add("Bulgaria");
        String[] arr = new String[0];
        Object[] cAdArray = cAd.toArray(arr);
        Iterator cAdIter = cAd.iterator();
        for(int i = 0; i < cAdArray.length; i++) {
            assertEquals(cAdIter.next(), cAdArray[i]);
        }
    }

    /**
     * Test dei metodi di MapAdapter in cui è previsto il ritorno di "UnsupportedOperationException"
     * in quanto metodi non supportati dal sistema.
     */
    @Test
    public void unsupportedMethodsTest() {
        CollectionAdapter cAd = new CollectionAdapter();
        assertThrows(UnsupportedOperationException.class, () -> cAd.parallelStream());
        assertThrows(UnsupportedOperationException.class, () -> cAd.removeIf(null));
        assertThrows(UnsupportedOperationException.class, () -> cAd.spliterator());
        assertThrows(UnsupportedOperationException.class, () -> cAd.stream());

    }
}