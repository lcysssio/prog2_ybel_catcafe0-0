import static org.junit.jupiter.api.Assertions.*;

import catcafe.CatCafe;
import catcafe.FelineOverLord;
import org.junit.jupiter.api.Test;

/** Testet die Klasse {@link CatCafe}. */
public class Tests {

    /** gegeben ein leeres cat cafe wenn die anzahl abgefragt wird dann ist sie null. */
    @Test
    public void givenEmptyCatCafe_whenGetCatCount_thenReturnsZero() {
        // gegeben
        CatCafe catCafe = new CatCafe();

        // wenn
        long count = catCafe.getCatCount();

        // dann
        assertEquals(0, count);
    }

    /** gegeben ein leeres cat cafe wenn nach namen gesucht wird dann kommt null zurück. */
    @Test
    public void givenEmptyCatCafe_whenGetCatByName_thenReturnsNull() {
        // gegeben
        CatCafe catCafe = new CatCafe();

        // wenn
        FelineOverLord found = catCafe.getCatByName("Minka");

        // dann
        assertNull(found);
    }

    /** gegeben ein leeres cat cafe wenn nach gewicht gesucht wird dann kommt null zurück. */
    @Test
    public void givenEmptyCatCafe_whenGetCatByWeight_thenReturnsNull() {
        // gegeben
        CatCafe catCafe = new CatCafe();

        // wenn
        FelineOverLord found = catCafe.getCatByWeight(1, 10);

        // dann
        assertNull(found);
    }

    /** gegeben ein cat cafe wenn eine katze hinzufuegt wird dann ist die anzahl eins. */
    @Test
    public void givenCatCafe_whenAddOneCat_thenCatCountIsOne() {
        // gegeben
        CatCafe catCafe = new CatCafe();
        FelineOverLord cat = new FelineOverLord("Minka", 5);

        // wenn
        catCafe.addCat(cat);

        // dann
        assertEquals(1, catCafe.getCatCount());
    }

    /** gegeben ein cat cafe mit einer katze wenn nach dem namen gesucht wird dann kommt sie zurueck. */
    @Test
    public void givenCatCafeWithOneCat_whenGetCatByName_thenReturnsCat() {
        // gegeben
        CatCafe catCafe = new CatCafe();
        FelineOverLord cat = new FelineOverLord("Minka", 5);
        catCafe.addCat(cat);

        // wenn
        FelineOverLord found = catCafe.getCatByName("Minka");

        // dann
        assertEquals(cat, found);
    }

    /** gegeben ein cat cafe mit einer katze wenn ein falscher name gesucht wird dann kommt null. */
    @Test
    public void givenCatCafeWithOneCat_whenGetCatByWrongName_thenReturnsNull() {
        // gegeben
        CatCafe catCafe = new CatCafe();
        catCafe.addCat(new FelineOverLord("Minka", 5));

        // wenn
        FelineOverLord found = catCafe.getCatByName("Luna");

        // dann
        assertNull(found);
    }

    /** gegeben ein cat cafe mit mehreren katzen wenn nach gewicht gesucht wird dann kommt die erste passende katze. */
    @Test
    public void givenCatCafeWithCats_whenGetCatByWeight_thenReturnsFirstMatchingCat() {
        // gegeben
        CatCafe catCafe = new CatCafe();
        FelineOverLord firstCat = new FelineOverLord("Minka", 3);
        FelineOverLord middleCat = new FelineOverLord("Luna", 7);
        FelineOverLord heavyCat = new FelineOverLord("Balu", 10);
        catCafe.addCat(middleCat);
        catCafe.addCat(firstCat);
        catCafe.addCat(heavyCat);

        // wenn
        FelineOverLord found = catCafe.getCatByWeight(3, 8);

        // dann
        assertEquals(firstCat, found);
    }

    /** gegeben ein cat cafe mit katzen wenn ausserhalb vom gewicht gesucht wird dann kommt null. */
    @Test
    public void givenCatCafeWithCats_whenGetCatByWeightOutsideRange_thenReturnsNull() {
        // gegeben
        CatCafe catCafe = new CatCafe();
        catCafe.addCat(new FelineOverLord("Minka", 3));
        catCafe.addCat(new FelineOverLord("Luna", 7));

        // wenn
        FelineOverLord found = catCafe.getCatByWeight(8, 12);

        // dann
        assertNull(found);
    }

    /** gegeben ein cat cafe wenn ein null name gesucht wird dann kommt null. */
    @Test
    public void givenCatCafe_whenGetCatByNameNull_thenReturnsNull() {
        // gegeben
        CatCafe catCafe = new CatCafe();
        catCafe.addCat(new FelineOverLord("Minka", 5));

        // wenn
        FelineOverLord found = catCafe.getCatByName(null);

        // dann
        assertNull(found);
    }

    /** gegeben ein cat cafe wenn min gewicht negativ ist dann kommt null. */
    @Test
    public void givenCatCafe_whenGetCatByWeightWithNegativeMin_thenReturnsNull() {
        // gegeben
        CatCafe catCafe = new CatCafe();
        catCafe.addCat(new FelineOverLord("Minka", 5));

        // wenn
        FelineOverLord found = catCafe.getCatByWeight(-1, 10);

        // dann
        assertNull(found);
    }

    /** gegeben ein cat cafe wenn max gewicht kleiner als min gewicht ist dann kommt null. */
    @Test
    public void givenCatCafe_whenGetCatByWeightWithMaxSmallerThanMin_thenReturnsNull() {
        // gegeben
        CatCafe catCafe = new CatCafe();
        catCafe.addCat(new FelineOverLord("Minka", 5));

        // wenn
        FelineOverLord found = catCafe.getCatByWeight(10, 5);

        // dann
        assertNull(found);
    }

    /** gegeben ein cat cafe wenn null hinzugefuegt wird dann kommt ein fehler. */
    @Test
    public void givenCatCafe_whenAddNullCat_thenThrowsNullPointerException() {
        // gegeben
        CatCafe catCafe = new CatCafe();

        // wenn dann
        assertThrows(NullPointerException.class, () -> catCafe.addCat(null));
    }

    /** gegeben ein cat cafe mit doppeltem namen wenn gesucht wird dann kommt der erste treffer. */
    @Test
    public void givenCatCafeWithDuplicateNames_whenGetCatByName_thenReturnsFirstMatch() {
        // gegeben
        CatCafe catCafe = new CatCafe();
        FelineOverLord firstCat = new FelineOverLord("Minka", 4);
        FelineOverLord secondCat = new FelineOverLord("Minka", 9);
        catCafe.addCat(firstCat);
        catCafe.addCat(secondCat);

        // wenn
        FelineOverLord found = catCafe.getCatByName("Minka");

        // dann
        assertEquals(firstCat, found);
    }
}
