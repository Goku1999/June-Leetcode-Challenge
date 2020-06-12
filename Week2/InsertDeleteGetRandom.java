/*
Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
Example:

// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
randomSet.getRandom();*/

class RandomizedSet 
{

    /** Initialize your data structure here. */
    int m=100003;
    ArrayList<Integer>[] set;
    ArrayList<Integer> value;
    public RandomizedSet() 
    {
        set=new ArrayList[m];
        value=new ArrayList<>();
    }
    
    public int h(long x) 
    {
        x = ((x >>> 16) ^ x) * 123;
        x = ((x >>> 16) ^ x) * 123;
        x = (x >>> 16) ^ x;
        return (int)(x%m);
    }
    
    public boolean insert(int val)
    {
        int n=Math.abs(val);
        int key=h(n);
        if(set[key]==null)
        {
        
            set[key]=new ArrayList<Integer>();
        }
        for(int x:set[key])
        {
            if(x==val)
            {
                return false;
            }
        }
        set[key].add(val);
        value.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) 
    {
        int n=Math.abs(val);
        int key=h((long)n);
        if(set[key]==null)
        {
            return false;
        }
        for(int x=0;x<set[key].size();x++)
        {
            
            if(set[key].get(x)==val)
            {
                set[key].remove(x);
                if(set[key].size()==0)
                {
                    set[key]=null;
                }
                return true;
            }
        }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() 
    {
        while(true)
        {
            int s=value.size();   
            if(s==0)
            {
                return -1;
            }
            int r=(int)(Math.random()*s);
            int d=value.get(r);
            int k=h(Math.abs(d));
            if(set[k]==null)
            {
                continue;
            }
            int x=set[k].get(0);
            for(int v:set[k])
            {
                if(v==d)
                {
                    return d;
                }
            }
            value.remove(r);
            return x;
        }
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
