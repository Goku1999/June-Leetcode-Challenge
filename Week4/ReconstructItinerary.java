/*
Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:

If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
One must use all the tickets once and only once.
Example 1:

Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
Example 2:

Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
             But it is larger in lexical order.
*/

class Solution 
{
    
    public List<String> findItinerary(List<List<String>> s) 
    {
        HashMap<String,PriorityQueue<String>> graph=new HashMap<>();
        for(int x=0;x<s.size();x++)
        {
            if(!graph.containsKey(s.get(x).get(0)))
            {
                PriorityQueue<String> pq=new PriorityQueue<>();
                graph.put(s.get(x).get(0),pq);
            }
            graph.get(s.get(x).get(0)).add(s.get(x).get(1));
        }
        LinkedList<String> ans=new LinkedList<>();
        dfs(graph,ans,"JFK");
        LinkedList<String> res=new LinkedList<>();
        for(int x=ans.size()-1;x>=0;x--)
        {
            res.add(ans.get(x));
        }
        return res;
        
    }
    public void dfs(HashMap<String,PriorityQueue<String>> graph,LinkedList<String> ans,String s)
    {
        PriorityQueue<String> q=graph.get(s);
        while(q!=null&&!q.isEmpty())
        {
            dfs(graph,ans,q.poll());
        }
        ans.add(s);
    }
}
