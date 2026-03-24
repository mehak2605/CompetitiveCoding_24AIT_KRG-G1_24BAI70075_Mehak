class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        long A=a, B=b;
        long low=Math.min(a,b);
        long high=(long)n*Math.min(a,b);
        long mod=(long)(Math.pow(10, 9)+7);
        while(B>0)
        {
            long temp=A;
            A=B;
            B=temp%B;
        }
        long lcm=(a*b)/A;
        while(low<high)
        {
            long mid=low+(high-low)/2;
            if((mid/a)+(mid/b)-(mid/lcm) < n)
            low=mid+1;
            else
            high=mid;
        }
        return (int)(low%mod);
    }
}
