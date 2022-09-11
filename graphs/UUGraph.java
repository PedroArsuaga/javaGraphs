/* IMPLEMENTATION OF UNDIRECTED, UNWEIGHTED INT/FLOAT GRAPH */
package graphs;

import java.util.ArrayList; //Node storage
import java.util.ArrayDeque; //BFS
import java.util.Stack; //DFS

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

     /* Adds E to the graph */
     public void add(E e)
     {

     };
 
     /* Removes E from the graph */
     public void remove(E e)
     {

     };
 
     /* Adds edge between u and v */
     public void addEdge(E u, E v)
     {

     };
 
     /* Removes edge between u and v */
     public void removeEdge(E u, E v)
     {

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

     };

}
