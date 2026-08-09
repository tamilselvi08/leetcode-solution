class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int rev = 0;
        int num = x;
        while (x != 0) {
            int digit = x % 10;
            rev= rev * 10 + digit;
            x /= 10;
        }
        return num == rev;
    }
}
