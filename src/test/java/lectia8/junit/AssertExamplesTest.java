package lectia8.junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Exemplele din teorie (diapozitivele 8–10): cele trei metode assert.
 * Toate testele de aici trec (verde).
 */
public class AssertExamplesTest {

    // assertEquals(așteptat, real): trece dacă valorile sunt egale
    @Test
    public void testEquals() {
        assertEquals(4, 2 + 2);
    }

    // assertTrue(condiție): trece dacă condiția este adevărată
    @Test
    public void testTrue() {
        assertTrue(4 == 2 + 2);
    }

    // assertFalse(condiție): trece dacă condiția este falsă (teste negative)
    @Test
    public void testNotEquals() {
        assertFalse(5 == 2 + 2);
    }

    // Bonus pentru elevii rapizi: un nume clar în raport și verificarea unei excepții
    @Test
    @DisplayName("Împărțirea la zero aruncă ArithmeticException")
    public void testException() {
        assertThrows(ArithmeticException.class, () -> {
            int x = 10 / 0;
        });
    }
}
