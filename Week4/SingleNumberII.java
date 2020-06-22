/*
Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,3,2]
Output: 3
Example 2:

Input: [0,1,0,1,0,1,99]
Output: 99*/

class Solution 
{
    public int singleNumber(int[] arr) 
    {
        if(arr.length==1||arr.length==2)
            return arr[0];
        else
        {
            Arrays.sort(arr);
            int i=0;
           for( i=0;i<arr.length-2;i++)
           {
             if(arr[i]==arr[i+2])
             {
                i=i+2;
                continue;
              }
             else
                return arr[i];
           }
            return arr[i];
        }
        
    }
}
