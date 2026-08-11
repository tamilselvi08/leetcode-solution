import java.util.Arrays;

public class Solution {
    private int[] target = new int[101]; 
    private String originalNum;

    public String smallestNumber(String num, long t) {
        this.originalNum = num;
        int[] primes = {2, 3, 5, 7};
        for (int i = 0; i < 4; i++) {
            while (t % primes[i] == 0) {
                target[i]++;
                t /= primes[i];
            }
        }
        if (t > 1) return "-1";
        char[] current = new char[num.length()];
        if (backtrack(0, true, current, new int[101])) {
            return new String(current);
        }
        int extraLength = num.length() + 1;
        while (true) {
            char[] longerCurrent = new char[extraLength];
            if (backtrack(0, false, longerCurrent, new int[101])) {
                return new String(longerCurrent);
            }
            extraLength++; 
                   }
    }
    private boolean backtrack(int index, boolean isBound, char[] current, int[] activeCounts) {

        if (index == current.length) {
            for (int i = 0; i < 4; i++) {
                if (activeCounts[i] < target[i]) return false;
            }
            return true;
        }
        int slotsLeft = current.length - index;
        if (getMinSlotsNeeded(activeCounts) > slotsLeft) {
            return false; // Mudiyadhu nu therinja, ingaye U-turn potruvom (Pruning)
        }
        int startDigit = 1;
        if (isBound) {
            startDigit = originalNum.charAt(index) - '0';
            if (startDigit == 0) startDigit = 1; // 0 iruka koodadhu zero-free num nala
        }
        for (int d = startDigit; d <= 9; d++) {
            current[index] = (char) (d + '0');
            
            int[] nextCounts = Arrays.copyOf(activeCounts, 4);
            addFactors(d, nextCounts);
            boolean nextBound = isBound && (d == (originalNum.charAt(index) - '0'));
            if (backtrack(index + 1, nextBound, current, nextCounts)) {
                return true; 
            }
        }

        return false;
    }
    private int getMinSlotsNeeded(int[] current) {
        int rem2 = Math.max(0, target[0] - current[0]);
        int rem3 = Math.max(0, target[1] - current[1]);
        int rem5 = Math.max(0, target[2] - current[2]);
        int rem7 = Math.max(0, target[3] - current[3]);
        int slots = rem5 + rem7; 
        slots += rem3 / 2; rem3 %= 2; 
        slots += rem2 / 3; rem2 %= 3; 
        if (rem3 == 1 && rem2 > 0) { slots += 1; rem3 = 0; rem2--; } 
        if (rem2 == 2) slots += 1; 
        else slots += rem2 + rem3;

        return slots;
    }
    private void addFactors(int digit, int[] counts) {
        if (digit == 2) counts[0] += 1;
        else if (digit == 3) counts[1] += 1;
        else if (digit == 4) counts[0] += 2;
        else if (digit == 5) counts[2] += 1;
        else if (digit == 6) { counts[0] += 1; counts[1] += 1; }
        else if (digit == 7) counts[3] += 1;
        else if (digit == 8) counts[0] += 3;
        else if (digit == 9) counts[1] += 2;
    }
}
