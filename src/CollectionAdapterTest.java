import org.junit.Test;

import static org.junit.Assert.*;

public class CollectionAdapterTest {
    /**
     * Test del metodo add(Object o)
     */
    @Test
    public void addTest() {
        CollectionAdapter cAd = new CollectionAdapter();
        cAd.add("Pippero");
        assertTrue(cAd.contains("Pippero"));
    }

    /**
     * Test del metodo add con un parametro "null"
     */
    @Test
    public void addTestNull() {
        ListAdapter cAd = new ListAdapter();
        cAd.add(null);
        assertTrue(cAd.contains(null));
    }

    /**
     * Test del metodo addAll()
     */
    @Test
    public void addAllTest() {
        ListAdapter cAd = new ListAdapter();
        ListAdapter cAdAdd = new ListAdapter();
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
        ListAdapter cAd = new ListAdapter();
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
        ListAdapter cAd = new ListAdapter();
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
        ListAdapter cAd = new ListAdapter();
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
        ListAdapter cAd = new ListAdapter();
        ListAdapter cAdRef = new ListAdapter();
        ListAdapter cAdRefFalse = new ListAdapter();
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
        ListAdapter cAd = new ListAdapter();
        ListAdapter cAdRef = new ListAdapter();
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
        ListAdapter cAd = new ListAdapter();
        ListAdapter cAdRef = new ListAdapter();
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
        ListAdapter cAd = new ListAdapter();
        ListAdapter cAdRef = new ListAdapter();
        ListAdapter cAdRefRef = new ListAdapter();
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
        assertEquals(cAdRefRef,cAdRef);
    }
}