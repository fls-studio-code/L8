package lectia8.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testele pentru DataClass, în ordinea din lecție (diapozitivele 12–17).
 *
 * La prima rulare DOUĂ teste pică intenționat — asta e demonstrația din lecție:
 *  - testBool2: greșeala e în TEST (am așteptat un rezultat greșit) -> assertTrue devine assertFalse;
 *  - testCharAt: greșeala e în COD (bug în DataClass.charAt) -> ">" devine ">=".
 * După ambele corecturi, toate cele 5 teste sunt verzi.
 */
public class TestClass {

    DataClass testData = new DataClass();

    // --- Primul test (diapozitivul 13) ---
    @Test
    public void testEquals() {
        assertEquals(4, testData.sum(2, 2));
    }

    // --- Încă două teste (diapozitivul 15) ---
    @Test
    public void testBool() {
        assertTrue(testData.boolAnd(true, true));
    }

    @Test
    public void testBool2() {
        // PICĂ intenționat: false & true = false, deci aici trebuie assertFalse
        assertTrue(testData.boolAnd(false, true));
    }

    // --- Sarcina „Teste” (diapozitivul 17): soluția ---
    @Test
    public void testEmpty() {
        assertTrue(testData.isStringEmpty(""));
        assertFalse(testData.isStringEmpty("Java"));
    }

    @Test
    public void testCharAt() {
        assertEquals('J', testData.charAt("Java", 0));
        assertEquals('a', testData.charAt("Java", 3));   // ultima literă
        // PICĂ până la corectarea DataClass: "Java" are pozițiile 0..3, poziția 4 nu există
        assertEquals(' ', testData.charAt("Java", 4));
    }
}
