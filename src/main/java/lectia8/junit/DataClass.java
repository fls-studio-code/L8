package lectia8.junit;

/**
 * Clasa pe care o testăm în lecție (diapozitivul 11).
 *
 * ATENȚIE: metoda charAt are intenționat un bug la margine.
 * Testul testCharAt din TestClass îl prinde. Corectarea: ">" devine ">=".
 */
public class DataClass {

    public int sum(int a, int b) {
        return a + b;
    }

    public boolean boolAnd(boolean a, boolean b) {
        return a & b;
    }

    public boolean isStringEmpty(String str) {
        return str.isEmpty();
    }

    public char charAt(String str, int position) {
        if (position > str.length()) {   // BUG intenționat: trebuie ">="
            return ' ';
        } else {
            return str.charAt(position);
        }
    }
}
