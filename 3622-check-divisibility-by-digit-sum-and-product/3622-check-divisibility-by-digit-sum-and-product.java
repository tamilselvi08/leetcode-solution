class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0;
        int pro=1;
        int ori=n;
        while(n>0){
            int digit=n%10;
            sum=sum+digit;
            pro=pro*digit;
            n=n/10;
        }
        int add=sum+pro;
        return ori%add==0;
    }
}