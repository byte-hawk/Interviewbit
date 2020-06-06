/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
 */

package Math;

public class ExcelColumnTitle {

    public String convertToTitle(int A) {
        StringBuilder sb = new StringBuilder();
        while(A>0) {
            // Character Z is a special case
            if(A % 26 == 0) {
                A = (A / 26) - 1;
                sb.append('Z');
            }
            else {
                sb.append((char) ('A' + ((A % 26) - 1)));
                A /= 26;
            }
        }

        return sb.reverse().toString();
    }
}
