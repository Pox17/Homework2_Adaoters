import org.junit.Test;

import static org.junit.Assert.*;

public class ListAdapterTest {

    /**
     * Test dei metodi di MapAdapter in cui è previsto il ritorno di "UnsupportedOperationException"
     * in quanto metodi non supportati dal sistema.
     */
    @Test
    public void unsupportedMethodsTest() {
        ListAdapter lAd = new ListAdapter();
        assertThrows(UnsupportedOperationException.class, () -> lAd.of());
        assertThrows(UnsupportedOperationException.class, () -> lAd.of(null));
        assertThrows(UnsupportedOperationException.class, () -> lAd.of(null,null));
        assertThrows(UnsupportedOperationException.class, () -> lAd.of(null,null,null));
        assertThrows(UnsupportedOperationException.class, () -> lAd.of(null,null,null,null));
        assertThrows(UnsupportedOperationException.class, () -> lAd.of(null,null,null,null,null));
        assertThrows(UnsupportedOperationException.class, () -> lAd.of(null,null,null,null,null,null));
        assertThrows(UnsupportedOperationException.class, () -> lAd.of(null,null,null,null,null,null,null));
        assertThrows(UnsupportedOperationException.class, () -> lAd.of(null,null,null,null,null,null,null,null));
        assertThrows(UnsupportedOperationException.class, () -> lAd.of(null,null,null,null,null,null,null,null,null));
        assertThrows(UnsupportedOperationException.class, () -> lAd.of(null,null,null,null,null,null,null,null,null,null));
        assertThrows(UnsupportedOperationException.class, () -> lAd.replaceAll(null));
        assertThrows(UnsupportedOperationException.class, () -> lAd.spliterator());
    }

}