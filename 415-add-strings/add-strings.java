import java.math.*;

class Solution {
    public String addStrings(String num1, String num2) {
        BigInteger bg1=new BigInteger(num1);
        BigInteger bg2=new BigInteger(num2);
        bg1=bg1.add(bg2);

        return bg1.toString();
        
    }
}