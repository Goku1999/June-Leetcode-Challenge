/*Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.

Note:

1 <= w.length <= 10000
1 <= w[i] <= 10^5
pickIndex will be called at most 10000 times.
Example 1:

Input: 
["Solution","pickIndex"]
[[[1]],[]]
Output: [null,0]
Example 2:

Input: 
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output: [null,0,1,1,1,0]
Explanation of Input Syntax:

The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array w. pickIndex has no arguments. Arguments are always wrapped with a list, even if there aren't any.*/

class Solution 
{
    private int[] accSum;
    private int total;
    private Random rand;

    public Solution(int[] w) 
    {
        accSum = new int[w.length];
        rand = new Random();
        for (int i = 0; i< w.length; i++) 
        {
            total += w[i];
            accSum[i] = total; 
        }
    }

    public int pickIndex() 
    {
        int r = rand.nextInt(total) + 1;
        int start = 0, end = accSum.length - 1;

        while (start <= end) 
        {
            int mid = start + (end - start) / 2;
            if (accSum[mid] == r) 
            {
                return mid;
            } 
            else if (accSum[mid] > r) 
            {
                end = mid - 1;
            } 
            else 
            {
                start = mid + 1;
            }
        }
        return start;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
