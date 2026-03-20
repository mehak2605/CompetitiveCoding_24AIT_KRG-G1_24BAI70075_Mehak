class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum=0;
        HashMap <Integer, Integer> ht=new HashMap<>();
        ht.put(0, -1);
        for(int i=0; i<nums.length; i++)
        {
            sum+=nums[i];
            int rem=sum%k;
            if(ht.containsKey(rem))
            {
                if(i-ht.get(rem)>=2)
                return true;
            }
            else
            ht.put(rem, i);
        }
        return false;
    }
}