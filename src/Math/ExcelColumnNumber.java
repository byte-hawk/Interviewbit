/*
Given a column title as appears in an Excel sheet, return its corresponding column number.

Example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
 */

package Math;

public class ExcelColumnNumber {

    /**
     * Get Excel column number from the column title
     * @param A
     * @return
     */
    public int titleToNumber(String A) {
        int col=0, len = A.length();
        for(int i=0; i<len; i++)
            col = col*26 + (A.charAt(i) - 'A' + 1);

        return col;
    }
}
