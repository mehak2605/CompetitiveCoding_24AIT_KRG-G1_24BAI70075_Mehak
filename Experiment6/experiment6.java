class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer, Integer> map=new HashMap<>();
        long max=0, sum=0;
        for(int i=0; i<k; i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            sum=sum+nums[i];
        }
        int l=0, r=k;
        while(r<n)
        {
            if(map.size()==k)
                max=Math.max(max, sum);
            l = r - k;
            map.put(nums[l], map.getOrDefault(nums[l], 0)-1);
            sum-=nums[l];
            if(map.get(nums[l])==0)
                map.remove(nums[l]);
            map.put(nums[r], map.getOrDefault(nums[r], 0)+1);
            sum+=nums[r];
            r++;
        }
        if(map.size()==k)
        max=Math.max(max, sum);
        return max;
    }
}
