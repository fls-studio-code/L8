package lectia8.junit;

/**
 * Tema pentru acasă din lecția 7: este propoziția un pangram?
 * Pangram = o propoziție care conține fiecare literă a alfabetului englez cel puțin o dată.
 * Folosită în lecția 8 ca exemplu de cod pe care îl acoperim cu teste (PangramTest).
 */
public class Pangram {

    public static boolean isPangram(String s) {
        String lower = s.toLowerCase();          // "T" și "t" sunt aceeași literă
        for (char c = 'a'; c <= 'z'; c++) {
            if (lower.indexOf(c) == -1) {
                return false;                    // lipsește o literă -> nu e pangram
            }
        }
        return true;                             // abia după ce am verificat toate literele
    }

    public static void main(String[] args) {
        System.out.println(isPangram("The quick brown fox jumps over the lazy dog")); // true
        System.out.println(isPangram("Hello world"));                                 // false
    }
}
