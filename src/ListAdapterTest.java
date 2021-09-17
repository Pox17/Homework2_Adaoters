import org.junit.Test;



import static org.junit.Assert.*;

public class ListAdapterTest {

    /**
     * Test del metodo add(Object o,int index)
     */
    @Test
    public void addPositionTest() {
        ListAdapter cAd = new ListAdapter();
        System.out.println("cAdSize =" + cAd.size());
        cAd.add(3, "Pippero");
        System.out.println("cAdSize =" + cAd.size());
        System.out.println(cAd.toString());
        assertTrue(cAd.contains("Pippero"));
        assertEquals(3,cAd.indexOf("Pippero"));
        System.out.println(cAd.indexOf("Pippero"));
        assertEquals("Pippero",cAd.get(3));
        System.out.println(cAd.get(3));
    }



















    /**
     * Test del metodo equals()
     */
    @Test
    public void equalsTest() {
        ListAdapter cAd = new ListAdapter();
        ListAdapter cAdRef = new ListAdapter();
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
        ListAdapter cAd = new ListAdapter();
        ListAdapter cAdRef = new ListAdapter();
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
        ListAdapter cAd = new ListAdapter();
        ListAdapter cAdRef = new ListAdapter();
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
        ListAdapter cAd = new ListAdapter();
        ListAdapter cAdRef = new ListAdapter();
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
        ListAdapter cAd = new ListAdapter();
        ListAdapter cAdRef = new ListAdapter();
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
        assertFalse(cAd.equals(cAdRef));
    }
    /**
     * Test del metodo isEmpty()
     * facendo un controllo prima su una collection inizializzata ma con all'interno 0 elementi,
     * successivamente aggiungendo un certo numero di elementi >0 valutando che il metodo dia valore negativo,
     * infine si svuota la collection e si aspetta nuovamente un valore positivo da parte di isEmpty
     */
    @Test
    public void isEmptyTest() {
        ListAdapter cAd = new ListAdapter();
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
        ListAdapter cAd = new ListAdapter();
        HIterator cAdIter = cAd.iterator();
        cAd.add("Pippero");
        assertTrue(cAdIter.hasNext());
        assertEquals("Pippero", cAdIter.next());
    }

    /**
     * test metodo iterator()
     */
    @Test
    public void iteratorSequenceTest() {
        ListAdapter cAd = new ListAdapter();
        HIterator cAdIter = cAd.iterator();
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
            assertEquals(cAd.get(count), cAdIter.next());
            count++;
        }
        assertEquals(cAd.size(),count);
    }

    /**
     * Test del metodo remove
     */
    @Test
    public void removeTest() {
        ListAdapter cAd = new ListAdapter();
        cAd.add("Pippero");
        assertTrue(cAd.remove("Pippero"));
        assertFalse(cAd.remove("Ramaya"));

    }

    /**
     * Test del metodo remove con parametro null
     */
    @Test
    public void removeNullTest() {
        ListAdapter cAd = new ListAdapter();
        cAd.add(null);
        assertTrue(cAd.remove(null));
        assertFalse(cAd.remove("Ramaya"));

    }

    /**
     * Test sul metodo remove che valuta che in caso di presenza di più elementi uguali ne venga eliminata solo un'istanza
     */
    @Test
    public void removeOneInstanceTest() {
        ListAdapter cAd = new ListAdapter();
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
        ListAdapter cAd = new ListAdapter();
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
        ListAdapter cAd = new ListAdapter();
        ListAdapter cAd2 = new ListAdapter();
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
     * Test del metodo set()
     */
    @Test
    public void setTest() {
        ListAdapter cAd = new ListAdapter();
        cAd.add("Pippero");
        cAd.add("Ramaya");
        cAd.add("Bulgaria");
        cAd.add("Pampero");
        assertEquals("Ramaya",cAd.set(1,"Peropip"));
        assertEquals("Peropip",cAd.get(1));
    }

    /**
     * Test del metodo size()
     */
    @Test
    public void sizeTest() {
        ListAdapter cAd = new ListAdapter();
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
        ListAdapter cAd = new ListAdapter();
        cAd.add("Pippero");
        cAd.add("Ramaya");
        cAd.add("Bulgaria");
        Object[] cAdArray = cAd.toArray();
        HIterator cAdIter = cAd.iterator();
        for(int i = 0; i < cAdArray.length; i++) {
            assertEquals(cAdIter.next(), cAdArray[i]);
        }
    }

    /**
     * Test del metodo toArray(T[])
     */
    @Test
    public void toArrayInputTest() {
        ListAdapter cAd = new ListAdapter();
        cAd.add("Pippero");
        cAd.add("Ramaya");
        cAd.add("Bulgaria");
        String[] arr = new String[0];
        Object[] cAdArray = cAd.toArray(arr);
        HIterator cAdIter = cAd.iterator();
        for(int i = 0; i < cAdArray.length; i++) {
            assertEquals(cAdIter.next(), cAdArray[i]);
        }
    }

    /**
     * Test del metodo toArray(T[])
     */
    @Test
    public void toArrayInputGreaterLengthTest() {
        ListAdapter cAd = new ListAdapter();
        cAd.add("Pippero");
        cAd.add("Ramaya");
        cAd.add("Bulgaria");
        String[] arr = new String[10];
        Object[] cAdArray = cAd.toArray(arr);
        for(int i = 0; i<cAdArray.length;i++) {
            System.out.println(cAdArray[i]);
        }
        HIterator cAdIter = cAd.iterator();

        for(int i = 0; i < cAd.size(); i++) {
            assertEquals(cAdIter.next(), cAdArray[i]);
        }
        for(int i = cAd.size(); i < cAdArray.length; i++) {
            assertEquals(null, cAdArray[i]);
        }

    }

}