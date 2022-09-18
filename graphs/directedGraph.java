/* IMPLEMENTATION OF DIRECTED, UNWEIGHTED INT/FLOAT GRAPH */
package graphs;

import java.util.ArrayList; //Node storage
import java.util.HashSet; //For storing nodes in bfs and dfs
import java.util.ArrayDeque; //for bfs

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

     /* Gets node with e as element. Returns null if node is not found. */
    private node getNode(E e)
    {
        int i = 0; 
        while( (i < this.nodeCount) && (this.nodes.get(i).elem != e)) //Look for node
             i++;
        if(i < this.nodeCount)
            return this.nodes.get(i);
        else   
            return null;
    };

    public void bfs(E s)
    {
        node S = this.getNode(s);
        int i = 0; //Layer counter
        HashSet<node> visited = new HashSet<node>();
        ArrayDeque<node> q = new ArrayDeque<node>();
        node current;
        node nullNode = new node(s); //Marker for end of layer
        
        System.out.println("Starting node: " + s );
        q.add(nullNode); //nullNode marks the end of the layer
        visited.add(S);
        S.tails.forEach(
            (v) -> { 
                     q.add(v); 
                     visited.add(v); 
                }
        );
        q.add(nullNode);

        while(!q.isEmpty())
        {   
            current = q.pop();
            if(current == nullNode){//Connected component fully explored
                current = q.peek();
                if(current == nullNode)
                    break;
                i++;
                System.out.print("Layer " + i + ": ");  
            }else{
                System.out.print(current.elem + " ");
                current.tails.forEach(
                    (v) -> {
                            if(!visited.contains(v))
                            {   
                                q.add(v); 
                                visited.add(v); 
                            }
                        }
                );
                if(q.peek() == nullNode){
                    System.out.println();
                    q.add(nullNode);
                };
            };

        };//while
    };
 

    public void dfs(E s)
    {
        
    };
 

    public boolean contains(E e)
    {
        return this.getNode(e) != null;
    };


    public void print()
    {
        this.nodes.forEach(
            (u) -> {
                System.out.println(u.elem + ": ");
                System.out.print(u.elem + "Edges towards: ");
                u.tails.forEach(
                    (v) -> {
                        System.out.print( v.elem + " -> ");
                    }
                );
                System.out.println(" ");
                System.out.print(u.elem + "Edges from: ");
                u.heads.forEach(
                    (v) -> {
                        System.out.print( v.elem + " -> ");
                    }
                );
                System.out.println(" . ");
            }
        );
    };

}
