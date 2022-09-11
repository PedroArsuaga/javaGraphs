/* IMPLEMENTATION OF UNDIRECTED, UNWEIGHTED INT/FLOAT GRAPH */
package graphs;

import java.util.ArrayList; //Node storage
//import java.util.ArrayDeque; //BFS
//import java.util.Stack; //DFS

public class UUGraph<E extends Number> implements graph<E> {
    
    int nodeCount;
    ArrayList<node> nodes;
    

     /* Interface for nodes of graph */
    private class node implements nodeTemplate{
        E elem;
        ArrayList<node> adj; //Adjacent nodes
        /* Constructor */
        public node(E e)
        {
            this.elem = e;
            this.adj = new ArrayList<node>();
        };
     };

     /* Constructor */
     public UUGraph()
     {
        this.nodeCount = 0;
        this.nodes = new ArrayList<node>();
     };


     /* Adds E to the graph */
     public void add(E e)
     {
        node newNode = new node(e);
        this.nodes.add(newNode);
        nodeCount++;
     };
 
     /* Removes E from the graph */
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
            int adjNodeCount = del.adj.size();
            for(int j = 0; j < adjNodeCount; j++)
                del.adj.get(j).adj.remove(del);
            del = null;
        };

        this.nodeCount--;
     };
 
     /* Adds edge between u and v */
     public void addEdge(E u, E v)
     {
        int i = 0; int j = 0;
        while( (i < this.nodeCount) && (this.nodes.get(i).elem != u)) 
            i++;
        while( (j < this.nodeCount) && (this.nodes.get(j).elem != v)) 
            j++;
        node U  = this.nodes.get(i); node V = this.nodes.get(j);
        U.adj.add(V); V.adj.add(U);
     };
 
     /* Removes edge between u and v */
     public void removeEdge(E u, E v)
     {
        int i = 0; int j = 0;
        while( (i < this.nodeCount) && (this.nodes.get(i).elem != u)) 
            i++;
        while( (j < this.nodeCount) && (this.nodes.get(j).elem != v)) 
            j++;
        node U  = this.nodes.get(i); node V = this.nodes.get(j);
        U.adj.remove(V); V.adj.remove(U);
     };
 
     /* Breadth-first-search starting from s*/
     public void bfs(E s)
     {

     };
 
     /* Depth-first-search starting from s */
     public void dfs(E e)
     {

     };
 
     /* Looks for e in the graph */
     public boolean contains(E e)
     {
        int i = 0; 
        while( (i < this.nodeCount) && (this.nodes.get(i).elem != e)) //Look for node
            i++;
        return i < this.nodeCount;
     };

    public void print()
    {
        this.nodes.forEach(
            (u) -> {
                System.out.print(u.elem + ": ");
                u.adj.forEach(
                    (v) -> {
                        System.out.print( v.elem + " -> ");
                    }
                );
                System.out.println(" . ");
            }
        );
        //System.out.println(" null");
    };
}
