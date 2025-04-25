class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder filtered = new StringBuilder();
        
        // Filter out non-alphanumeric characters and convert to lowercase
        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                filtered.append(Character.toLowerCase(ch));
            }
        }
        
        // Check if the filtered string is a palindrome
        String filteredStr = filtered.toString();
        String reversedStr = filtered.reverse().toString();
        
        return filteredStr.equals(reversedStr);
    }
}
