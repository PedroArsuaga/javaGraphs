/* IMPLEMENTATION OF DIRECTED, UNWEIGHTED INT/FLOAT GRAPH */
package graphs;

import java.util.ArrayList; //Node storage

public class directedGraph<E extends Number> implements graph<E> {
    
    int nodeCount;
    ArrayList<node> nodes;

    private class node implements nodeTemplate
    {
        E elem;
        ArrayList<node> heads, tails; //Lists for head ("moving towards" node) and tail ("moving away from" node) ends adjacent to vertex
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
                del.heads.get(j).tails.remove(del);
            for(int j = 0; j < tailNodeCount; j++)
                del.tails.get(j).heads.remove(del);
            del = null;
        };

        this.nodeCount--;
    };
 
    /* Adds edge from u to v */
    public void addEdge(E u, E v)
    {
        int i = 0; int j = 0;
        while( (i < this.nodeCount) && (this.nodes.get(i).elem != u)) 
            i++;
        while( (j < this.nodeCount) && (this.nodes.get(j).elem != v)) 
            j++;
        node U  = this.nodes.get(i); node V = this.nodes.get(j);
        U.tails.add(V);
        V.heads.add(U);
    };
 
    /* Removes edge from u to v, or from v to u, if either exists. */
    public void removeEdge(E u, E v)
    {
        int i = 0; int j = 0;
        while( (i < this.nodeCount) && (this.nodes.get(i).elem != u)) 
            i++;
        while( (j < this.nodeCount) && (this.nodes.get(j).elem != v)) 
            j++;
        node U  = this.nodes.get(i); node V = this.nodes.get(j);
        if(U.heads.contains(V)) //There's an edge from V to U
        {
            U.heads.remove(V);
            V.tails.remove(U);
        }
        else if(V.heads.contains(U)) //There's an edge from U to V
        {
            U.tails.remove(V);
            V.tails.remove(U);
        };
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
