/*
The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.
Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"
*/

class Solution {
    public String getPermutation(int n, int k) 
    {
        int fact[]=new int[11];
        fact[0]=1;
        fact[1]=1;
        ArrayList<Integer> store=new ArrayList<>();
        for(int x=1;x<=n;x++)
        {
            store.add(x);
        }
        for(int x=2;x<=10;x++)
        {
            fact[x]=fact[x-1]*x;
        }
        String ans="";
        while(n>1)
        {
            int d=((k-1)/fact[n-1]);
            ans=ans+store.get(d);
            store.remove(d);
            k=k%(fact[n-1]);
            if(k==0)
            {
                k=fact[n-1];
            }
            n--;
        }
        ans=ans+store.get(0);
        return ans;
    }
    
}
