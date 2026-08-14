class Solution {
    public int maximumLengthSubstring(String s) {
        int[] f=new int[26];
        int left=0;
        int ans=0;
        for(int right=0;right<s.length();right++){
            f[s.charAt(right)-'a']++;
            while(f[s.charAt(right)-'a']>2){
                f[s.charAt(left)-'a']--;
                left++;
            }
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
}