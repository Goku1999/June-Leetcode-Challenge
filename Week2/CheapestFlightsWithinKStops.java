/*There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.

Now given all the cities and flights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.

Example 1:
Input: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1
Output: 200
Explanation: 
The graph looks like this:


The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
Example 2:
Input: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 0
Output: 500
Explanation: 
The graph looks like this:


The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
 

Constraints:

The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
The size of flights will be in range [0, n * (n - 1) / 2].
The format of each flight will be (src, dst, price).
The price of each flight will be in the range [1, 10000].
k is in the range of [0, n - 1].
There will not be any duplicated flights or self cycles.*/

//Solution 1:
//DFS Backtracking

class Solution 
{
    class Edge
    {
        int v,d;
        public Edge(int v,int d)
        {
            this.v=v;
            this.d=d;
        }
    }
    public int findCheapestPrice(int n, int[][] ar, int src, int dest, int k)
    {
        LinkedList<Edge> graph[]=new LinkedList[n];
        for(int x=0;x<n;x++)
        {
            graph[x]=new LinkedList<>();
        }
        for(int x=0;x<ar.length;x++)
        {
            graph[ar[x][0]].add(new Edge(ar[x][1],ar[x][2]));
        }
        int weight=0;
        boolean visited[]=new boolean[n];
        visited[src]=true;
        dfs(graph,n,src,dest,k,weight,visited);
        return min==Integer.MAX_VALUE?-1:min;
    }
    int min=Integer.MAX_VALUE;
    public void dfs(LinkedList<Edge> graph[],int n,int s,int t,int k,int res,boolean visited[])
    {
        if(s==t)
        {
            //System.out.println(weight);
            if(res<min)
            {
               min=res;
            }
        }
        else if(k<0)
        {
            return;
        }
        else
        {
            for(Edge edge:graph[s])
            {
                int v=edge.v;
                int d=edge.d;
                if(!visited[v]&&res+d<min)
                {
                    //System.out.println(v);
                    visited[v]=true;
                    dfs(graph,n,v,t,k-1,res+d,visited);
                    visited[v]=false;
                }
            }
        }
    }
}
