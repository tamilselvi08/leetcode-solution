class Solution {
    public int smallestNumber(int n, int t) {
        int num = n;
        while (true) {
            int temp = num;
            int multy = 1;
            while (temp > 0) {
                multy *= temp % 10;
                temp /= 10;
            }
            if (multy % t == 0) {
            return num;}
            num++;
        }
    }
}