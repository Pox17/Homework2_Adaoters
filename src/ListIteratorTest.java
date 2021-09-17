import org.junit.Test;

import static org.junit.Assert.*;

public class ListIteratorTest {

    private static ListAdapter setList() {
        ListAdapter toRet = new ListAdapter();
        toRet.add("Pippero");
        toRet.add("Ramaya");
        toRet.add("Bulgaria");
        toRet.add("Vitello");
        toRet.add("Balsa");
        return toRet;
    }

    @Test
    public void hasPrevious() {
        ListAdapter lAd = setList();
        HListIterator lIter = lAd.listIterator();
        assertFalse(lIter.hasPrevious());
        lIter.next();
        assertTrue(lIter.hasPrevious());
    }

    @Test
    public void hasNext() {
        ListAdapter lAd = setList();
        HListIterator lIter = lAd.listIterator();
        assertTrue(lIter.hasNext());
        lIter.next();
        lIter.next();
        lIter.next();
        lIter.next();
        lIter.next();
        assertFalse(lIter.hasNext());
    }

    @Test
    public void next() {
        ListAdapter lAd = setList();
        HListIterator lIter = lAd.listIterator();
        assertTrue(lIter.hasNext());
        int i = 0;
        while(lIter.hasNext()) {
            assertEquals(lAd.get(i++),lIter.next());
        }
    }

    @Test
    public void previous() {
        ListAdapter lAd = setList();
        HListIterator lIter = lAd.listIterator();
        int i = lAd.size() -1;
        while(lIter.hasNext()) {
            lIter.next();
        }
        while(lIter.hasPrevious()) {
            assertEquals(lAd.get(i--),lIter.previous());
        }
        assertThrows();
    }

    @Test
    public void previousIndex() {
        ListAdapter lAd = setList();
        HListIterator lIter = lAd.listIterator();
        int i = -1;
        while(lIter.hasNext()) {
            assertEquals(i++, lIter.previousIndex());
            lIter.next();
        }
    }
}