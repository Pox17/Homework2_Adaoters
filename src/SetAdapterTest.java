import org.junit.Test;

import static org.junit.Assert.*;

public class SetAdapterTest {

    /**
     * Test dei metodi di MapAdapter in cui è previsto il ritorno di "UnsupportedOperationException"
     * in quanto metodi non supportati dal sistema.
     */
    @Test
    public void unsupportedMethodsTest() {
        SetAdapter sAd = new SetAdapter();
        assertThrows(UnsupportedOperationException.class, () -> sAd.of());
        assertThrows(UnsupportedOperationException.class, () -> sAd.of(null));
        assertThrows(UnsupportedOperationException.class, () -> sAd.of(null,null));
        assertThrows(UnsupportedOperationException.class, () -> sAd.of(null,null,null));
        assertThrows(UnsupportedOperationException.class, () -> sAd.of(null,null,null,null));
        assertThrows(UnsupportedOperationException.class, () -> sAd.of(null,null,null,null,null));
        assertThrows(UnsupportedOperationException.class, () -> sAd.of(null,null,null,null,null,null));
        assertThrows(UnsupportedOperationException.class, () -> sAd.of(null,null,null,null,null,null,null));
        assertThrows(UnsupportedOperationException.class, () -> sAd.of(null,null,null,null,null,null,null,null));
        assertThrows(UnsupportedOperationException.class, () -> sAd.of(null,null,null,null,null,null,null,null,null));
        assertThrows(UnsupportedOperationException.class, () -> sAd.of(null,null,null,null,null,null,null,null,null,null));
        assertThrows(UnsupportedOperationException.class, () -> sAd.spliterator());
    }
}