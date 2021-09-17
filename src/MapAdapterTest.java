import org.junit.Test;
import static org.junit.Assert.*;
//TEST DA IMPLEMENTARE: entrySet, keySet, values
public class MapAdapterTest {

    /**
     * Test del metodo clear();
     */
    @Test
    public void clearTest() {
        HMap hm = new MapAdapter();
        hm.put("Italia","Pasta");
        hm.put("USA","Hamburger");
        hm.put("Francia","Baguette");
        assertTrue(hm.size() != 0);
        hm.clear();
        assertTrue(hm.size() == 0);
    }

    /**
     * Test del metodo containsKey
     */
    @Test
    public void containsKeyTest() {
        HMap hm = new MapAdapter();
        hm.put("Italia","Pasta");
        hm.put("USA","Hamburger");
        hm.put("Francia","Baguette");
        assertTrue(hm.containsKey("USA"));
        assertFalse(hm.containsKey("Canada"));
    }

    /**
     * Test del metodo containsKey
     */
    @Test
    public void containsValueTest() {
        HMap hm = new MapAdapter();
        hm.put("Italia","Pasta");
        hm.put("USA","Hamburger");
        hm.put("Francia","Baguette");
        assertTrue(hm.containsValue("Pasta"));
        assertFalse(hm.containsKey("Baklava"));
    }

    /**
     * Test del metodo equals
     */
    @Test
    public void equalsTest() {
        HMap hm1 = new MapAdapter();
        HMap hm2 = new MapAdapter();
        HMap hm3 = new MapAdapter();
        hm1.put("Italia","Pasta");
        hm1.put("USA","Hamburger");
        hm1.put("Francia","Baguette");
        hm2.put("Italia","Pasta");
        hm2.put("USA","Hamburger");
        hm2.put("Francia","Baguette");
        hm3.put("Canada","SciroppoAcero");
        hm3.put("USA","Hamburger");
        hm3.put("Italia","Pasta");
        assertTrue(hm1.equals(hm2));
        assertTrue(hm2.equals(hm1));
        assertFalse(hm1.equals(hm3));
        assertFalse(hm2.equals(hm3));
    }

    /**
     * Test del metodo containsKey
     */
    @Test
    public void getTest() {
        HMap hm = new MapAdapter();
        hm.put("Italia","Pasta");
        hm.put("USA","Hamburger");
        hm.put("Francia","Baguette");
        assertEquals("Baguette",hm.get("Francia"));
        assertNotEquals("Lasagne",hm.get("Italia"));
    }

    /**
     * Test del metodo isEmpty
     */
    @Test
    public void isEmptyTest() {
        HMap hm = new MapAdapter();
        hm.put("Italia","Pasta");
        hm.put("USA","Hamburger");
        hm.put("Francia","Baguette");
        assertFalse(hm.isEmpty());
        hm.clear();
        assertTrue(hm.isEmpty());
    }



    /**
     * Test del metodo size
     */
    @Test
    public void putTest() {
        HMap hm = new MapAdapter();
        hm.put("Italia","Pasta");
        hm.put("USA","Hamburger");
        hm.put("Francia","Baguette");
        assertTrue(hm.containsKey("Francia"));
        assertTrue(hm.containsValue("Pasta"));
        assertTrue(hm.containsValue("Hamburger"));
    }

    /**
     * Test del metodo putAll
     */
    @Test
    public void putAllTest() {
        HMap hm1 = new MapAdapter();
        HMap hm3 = new MapAdapter();
        hm1.put("Italia", "Pasta");
        hm1.put("USA", "Hamburger");
        hm1.put("Francia", "Baguette");
        hm3.put("Canada", "SciroppoAcero");
        hm3.put("USA", "HotDog");
        hm3.put("Italia", "Pasta");
        hm1.putAll(hm3);
        assertTrue(hm1.containsValue("SciroppoAcero"));
        assertTrue(hm1.containsValue("HotDog"));
        assertTrue(hm1.containsKey("Canada"));
    }
    /**
     * Test del metodo clear();
     */
    @Test
    public void removeTest() {
        HMap hm = new MapAdapter();
        hm.put("Italia","Pasta");
        hm.put("USA","Hamburger");
        hm.put("Francia","Baguette");
        assertEquals("Pasta",hm.remove("Italia"));
        assertFalse(hm.containsValue("Pasta"));

    }

    @Test
    public void putswapTest() {
        HMap hm = new MapAdapter();
        hm.put("Italia","Pasta");
        hm.put("USA","Hamburger");
        assertEquals("Pasta",hm.get("Italia"));
        hm.put("Italia","Lasagne");
        assertNotEquals("Pasta",hm.get("Italia"));
        assertEquals("Lasagne",hm.get("Italia"));

    }

    /**
     * Test del metodo size
     */
    @Test
    public void sizeTest() {
        HMap hm = new MapAdapter();
        hm.put("Italia","Pasta");
        hm.put("USA","Hamburger");
        hm.put("Francia","Baguette");
        assertTrue(hm.size() == 3);
        hm.clear();
        assertTrue(hm.size() == 0);
    }
}