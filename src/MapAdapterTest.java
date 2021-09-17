import static org.junit.Assert.*;

public class MapAdapterTest {


    /**
     * Test dei metodi di MapAdapter in cui è previsto il ritorno di "UnsupportedOperationException"
     * in quanto metodi non supportati dal sistema.
     */
    @org.junit.Test
    public void unsupportedMethodsTest() {
        MapAdapter mAd = new MapAdapter();
        assertThrows(UnsupportedOperationException.class, () -> mAd.compute(null,null));
        assertThrows(UnsupportedOperationException.class, () -> mAd.computeIfAbsent(null,null));
        assertThrows(UnsupportedOperationException.class, () -> mAd.computeIfPresent(null,null));
        assertThrows(UnsupportedOperationException.class, () -> mAd.forEach(null));
        assertThrows(UnsupportedOperationException.class, () -> mAd.merge(null,null,null));
        assertThrows(UnsupportedOperationException.class, () -> mAd.of());
        assertThrows(UnsupportedOperationException.class, () -> mAd.of(null,null));
        assertThrows(UnsupportedOperationException.class, () -> mAd.of(null,null,null,null));
        assertThrows(UnsupportedOperationException.class, () -> mAd.of(null,null,null,null,null,null));
        assertThrows(UnsupportedOperationException.class, () -> mAd.of(null,null,null,null,null,null,null,null));
        assertThrows(UnsupportedOperationException.class, () -> mAd.of(null,null,null,null,null,null,null,null,null,null));
        assertThrows(UnsupportedOperationException.class, () -> mAd.of(null,null,null,null,null,null,null,null,null,null,null,null));
        assertThrows(UnsupportedOperationException.class, () -> mAd.of(null,null,null,null,null,null,null,null,null,null,null,null,null,null));
        assertThrows(UnsupportedOperationException.class, () -> mAd.of(null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null));
        assertThrows(UnsupportedOperationException.class, () -> mAd.of(null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null));
        assertThrows(UnsupportedOperationException.class, () -> mAd.of(null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null));
        assertThrows(UnsupportedOperationException.class, () -> mAd.ofEntries());
        assertThrows(UnsupportedOperationException.class, () -> mAd.replaceAll(null));
    }
}