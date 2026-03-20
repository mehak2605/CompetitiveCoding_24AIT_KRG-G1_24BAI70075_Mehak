class Solution {
    public boolean isPossible(int mid, int h, int nums[])
    {
        long sum=0;
        for(int i=0; i<nums.length; i++)
        {
            sum=sum+(long)Math.ceil((double)nums[i]/mid);
        }
        if(sum<=h)
        return true;
        return false;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=piles[0];
        int mid=0;
        for(int i=1; i<piles.length; i++)
        high=Math.max(high, piles[i]);
        while(low<=high)
        {
            mid=low+(high-low)/2;
            if(isPossible(mid, h, piles))
            high=mid-1;
            else
            low=mid+1;
        }
        return low;
    }
}