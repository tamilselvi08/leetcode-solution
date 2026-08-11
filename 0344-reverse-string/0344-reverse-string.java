class Solution {
    public void reverseString(char[] s) {
        int fir = 0;
        int end = s.length-1;
        while(fir<=end){
            char temp = s[fir];
            s[fir]=s[end];
            s[end]=temp;
            fir++;
            end--;
        }
    }
}