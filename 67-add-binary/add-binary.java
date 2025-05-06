import java.util.*;
import java.math.*;

class Solution {
    public String addBinary(String a, String b) {
        BigInteger n1=new BigInteger(a,2);
        BigInteger n2=new BigInteger(b,2);
        n1=n1.add(n2);
        String ans=n1.toString(2);
        return ans;
    }
}