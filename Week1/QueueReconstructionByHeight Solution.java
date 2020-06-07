/*Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.

 
Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]*/

class Solution 
{
    public int[][] reconstructQueue(int[][] people)
    {
        Arrays.sort(people,new Comparator<int []>()
        {
           public int compare(int a[],int b[])
           {
               if(a[0]<b[0])
                   return 1;
               else if(a[0]==b[0])
               {
                   if(a[1]>b[1])
                       return 1;
                   else
                       return -1;
               }
               else
                   return -1;
           }
        });
        ArrayList<int []>arr =new ArrayList<int[]>();
        for(int i=0;i<people.length;i++)
        {
            int val[]=people[i];
            arr.add(val[1],val);
        }
        return arr.toArray(new int[people.length][2]);
        
    }
}
