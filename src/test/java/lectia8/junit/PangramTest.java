package lectia8.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Legătura dintre tema din lecția 7 și JUnit:
 * în loc să încercăm fraze de mână, le verificăm automat.
 */
public class PangramTest {

    @Test
    public void classicPangram() {
        assertTrue(Pangram.isPangram("The quick brown fox jumps over the lazy dog"));
    }

    @Test
    public void notAPangram() {
        assertFalse(Pangram.isPangram("Hello world"));
    }

    @Test
    public void upperCaseCounts() {
        // greșeală frecventă: fără toLowerCase() acest test pică
        assertTrue(Pangram.isPangram("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG"));
    }

    @Test
    public void emptyString() {
        assertFalse(Pangram.isPangram(""));
    }

    @Test
    public void longButMissingLetters() {
        // greșeală frecventă: verificarea lungimii (>= 26) în loc de fiecare literă
        assertFalse(Pangram.isPangram("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }
}
