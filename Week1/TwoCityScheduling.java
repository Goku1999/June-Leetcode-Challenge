/*There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].

Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.

 

Example 1:

Input: [[10,20],[30,200],[400,50],[30,20]]
Output: 110
Explanation: 
The first person goes to city A for a cost of 10.
The second person goes to city A for a cost of 30.
The third person goes to city B for a cost of 50.
The fourth person goes to city B for a cost of 20.

The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
 

Note:

1 <= costs.length <= 100
It is guaranteed that costs.length is even.
1 <= costs[i][0], costs[i][1] <= 1000*/

class Solution 
{
    class Sort implements Comparator<int[]>
    {
        public int compare(int a[],int b[])
        {
            int d=Math.abs(a[0]-a[1]);
            int c=Math.abs(b[0]-b[1]);
            if(d>c)
            {
                return -1;
            }
            else
            {
                return 1;
            }
        }
    }
    public int twoCitySchedCost(int[][] ar) 
    {
        int n=ar.length;
        Arrays.sort(ar,new Sort());
        int sum=0;
        int a=n/2;
        int b=n/2;
        int i=0;
        for(int x=0;x<n;x++)
        {
            if(b==0||(ar[x][0]<=ar[x][1]&&a>0))
            {
                a--;
                sum+=ar[x][0];
            }
            else
            {
                b--;
                sum+=ar[x][1];
            }
        }
        return sum;
    }
}
