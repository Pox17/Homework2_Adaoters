import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;
//Metodi da implementare: HashCode, toArray
public class SetAdapterTest {

    /**
     * Test metodo add
     */
    @Test
    public void addTest() {
        HSet hs = new SetAdapter();
        hs.add("Banana");
        hs.add("Mela");
        hs.add("Pera");
        hs.add("Arancia");
        assertEquals(4,hs.size());
        assertTrue(hs.contains("Mela"));
    }

    /**
     * Test della capacità del metodo add di non aggiungere doppi
     */
    @Test
    public void addMultipleTest() {
        HSet hs = new SetAdapter();
        assertTrue(hs.add("Banana"));
        assertTrue(hs.add("Mela"));
        assertTrue(hs.add("Pera"));
        assertTrue(hs.add("Arancia"));
        assertFalse(hs.add("Banana"));
        assertEquals(4,hs.size());
        HIterator iter = hs.iterator();
        int bananaNum = 0;
        while(iter.hasNext()) {
            if(iter.next().equals("Banana"))
                bananaNum++;
        }
        assertEquals(1,bananaNum);
    }

    /**
     * Test metodo addAll
     */
    @Test
    public void addAllTest() {
        HSet hs1 = new SetAdapter();
        HSet hs2 = new SetAdapter();
        hs1.add("Banana");
        hs1.add("Mela");
        hs1.add("Pera");
        hs2.add("Arancia");
        hs2.add("Pompelmo");
        assertTrue(hs1.addAll(hs2));
        assertEquals(5,hs1.size());
        assertTrue(hs1.contains("Arancia"));
    }

    /**
     * Test metodo clear
     */
    @Test
    public void clearTest() {
        HSet hs = new SetAdapter();
        hs.add("Banana");
        hs.add("Mela");
        hs.add("Pera");
        hs.add("Arancia");
        assertEquals(4,hs.size());
        hs.clear();
        assertEquals(0,hs.size());
    }

    /**
     * Test metodo contains
     */
    @Test
    public void containsTest() {
        HSet hs = new SetAdapter();
        hs.add("Banana");
        hs.add("Mela");
        hs.add("Pera");
        hs.add("Arancia");
        assertTrue(hs.contains("Mela"));
        assertFalse(hs.contains("Pesca"));
    }

    /**
     * Test metodo containsAll
     */
    @Test
    public void containsAllTest() {
        HSet hs1 = new SetAdapter();
        HSet hs2 = new SetAdapter();
        hs1.add("Banana");
        hs1.add("Mela");
        hs1.add("Pera");
        hs2.add("Arancia");
        hs2.add("Pompelmo");
        assertTrue(hs1.addAll(hs2));
        assertTrue(hs1.containsAll(hs2));
    }

    /**
     * Test metodo equals
     */
    @Test
    public void equalsTest() {
        HSet hs1 = new SetAdapter();
        HSet hs2 = new SetAdapter();
        HSet hs3 = new SetAdapter();
        hs1.add("Banana");
        hs1.add("Mela");
        hs1.add("Pera");
        hs2.add("Banana");
        hs2.add("Mela");
        hs2.add("Pera");
        hs3.add("Mela");
        hs3.add("Pera");
        hs3.add("Pesca");
        assertTrue(hs2.equals(hs1));
        assertTrue(hs1.equals(hs2));
        assertFalse(hs1.equals(hs3));
    }

    /**
     * Test metodo isEmpty
     */
    @Test
    public void isEmptyTest() {
        HSet hs = new SetAdapter();
        assertTrue(hs.isEmpty());
        hs.add("Banana");
        hs.add("Mela");
        hs.add("Pera");
        hs.add("Arancia");
        assertFalse(hs.isEmpty());
        hs.clear();
        assertTrue(hs.isEmpty());
    }

    /**
     * Test metodo remove
     */
    @Test
    public void removeTest() {
        HSet hs = new SetAdapter();
        assertTrue(hs.isEmpty());
        hs.add("Banana");
        hs.add("Mela");
        hs.add("Pera");
        hs.add("Arancia");
        assertTrue(hs.contains("Banana"));
        assertTrue(hs.remove("Banana"));
        assertFalse(hs.contains("Banana"));
    }

    /**
     * Test metodo removeAll
     */
    @Test
    public void removeAllTest() {
        HSet hs1 = new SetAdapter();
        HSet hs2 = new SetAdapter();
        hs1.add("Banana");
        hs1.add("Mela");
        hs1.add("Pera");
        hs1.add("Pesca");
        hs2.add("Banana");
        hs2.add("Mela");
        assertTrue(hs1.removeAll(hs2));
        assertFalse(hs1.containsAll(hs2));
        assertFalse(hs1.contains("Mela"));
        }

    /**
     * Test metodo retainAll
     */
    @Test
    public void retainAllTest() {
        HSet hs1 = new SetAdapter();
        HSet hs2 = new SetAdapter();
        hs1.add("Banana");
        hs1.add("Mela");
        hs1.add("Pera");
        hs1.add("Pesca");
        hs2.add("Banana");
        hs2.add("Mela");
        assertTrue(hs1.retainAll(hs2));
        assertTrue(hs1.containsAll(hs2));
    }

    /**
     * Test metodo size
     */
    @Test
    public void sizeTest() {
        HSet hs = new SetAdapter();
        hs.add("Banana");
        hs.add("Mela");
        hs.add("Pera");
        hs.add("Arancia");
        assertEquals(4,hs.size());
        hs.remove("Banana");
        assertEquals(3,hs.size());
        hs.clear();
        assertEquals(0,hs.size());
    }
}