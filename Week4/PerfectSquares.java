/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
*/
class Solution 
{
    public int numSquares(int n) 
    {
        ArrayList<Integer> ar=new ArrayList<>();
        int i=1;
        while((long)i*i<=Integer.MAX_VALUE)
        {
            ar.add(i*i);
            i++;
        }
        int ans=0;
        int dp[]=new int[n+1];
        int l=ar.size();
        for(int x=1;x<=n;x++)
        {
            i=0;
            int min=Integer.MAX_VALUE;
            while(i<l&&ar.get(i)<=x)
            {
                int d=x-ar.get(i);
                min=Math.min(min,dp[d]+1);
                i++;
            }
            dp[x]=min;
        }
        return dp[n];
    }
}
