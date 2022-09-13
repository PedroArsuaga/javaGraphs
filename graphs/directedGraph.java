/* IMPLEMENTATION OF DIRECTED, UNWEIGHTED INT/FLOAT GRAPH */
package graphs;

import java.util.ArrayList; //Node storage

public class directedGraph<E extends Number> implements graph<E> {
    
    int nodeCount;
    ArrayList<node> nodes;

    private class node implements nodeTemplate
    {
        E elem;
        ArrayList<node> heads, tails; //Lists for head and tail ends adjacent to vertex
        /* Constructor */
        public node(E e)
        {
            this.elem = e;
            heads = new ArrayList<node>();
            tails = new ArrayList<node>();
        };
    };

    /* Constructor */
    public directedGraph()
    {
        this.nodeCount = 0;
        this.nodes = new ArrayList<node>();
    }

    public void add(E e)
    {
        node newNode = new node(e);
        this.nodes.add(newNode);
        nodeCount++;
    };
 

    public void remove(E e)
    {
        int i = 0; 
        while( (i < this.nodeCount) && (this.nodes.get(i).elem != e)) //Look for node
            i++;
        if(i >= this.nodeCount)
            System.out.println("Node not found.");
        else   
        {
            node del = this.nodes.get(i);
            this.nodes.remove(i);
            int headNodeCount = del.heads.size();
            int tailNodeCount = del.tails.size();
            for(int j = 0; j < headNodeCount; j++)  
                del.heads.get(j).heads.remove(del);
            for(int j = 0; j < tailNodeCount; j++)
                del.tails.get(j).tails.remove(del);
            del = null;
        };

        this.nodeCount--;
    };
 

    public void addEdge(E u, E v)
    {

    };
 

    public void removeEdge(E u, E v)
    {

    };

    public void bfs(E s)
    {

    };
 

    public void dfs(E s)
    {
        
    };
 

    public boolean contains(E e)
    {
        return false;
    };


    public void print()
    {

    };

}
