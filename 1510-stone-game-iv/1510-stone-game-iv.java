class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] arr = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            if (!arr[i]) {
                for (int j = 1; i + j * j <= n; j++) {
                    arr[i + j * j] = true;
                }
                if (arr[n]) {
                    return true;
                }
            }
        }
        return false;
    }
}