/** Undirected integer graph implementation **/

import java.util.ArrayList; //Node storage
import java.util.ArrayDeque; //BFS
import java.util.Stack; //DFS

public class intGraph
{
   
    ArrayList<node> nodes;
    int nodeCount, maxNode;

    public class node
    {
        int elem;
        ArrayList<Integer> adj; //Adjacent nodes

        node(int i){
            this.elem = i;
            adj = new ArrayList<Integer>();
        };
    };//node

    
    /* Constructor */
    public intGraph()
    {
        this.nodes = new ArrayList<node>();
        this.nodeCount = 0;
        this.maxNode = 0;
    };

    /* ========= Basic operations ========= */
    /* Add node */
    public void add(int u)
    {
        node newNode = new node(u);
        this.nodes.add(newNode);
        if(this.nodeCount == 0)
            this.maxNode = u;
        else
            if(this.maxNode < u) 
                this.maxNode = u;
        this.nodeCount++;
        
    };
    /* Get specific node */
    public node getNode(int u)
    {
        int i = 0; int max = this.nodes.size(); node res = null;
        while( (i < max) && (this.nodes.get(i).elem != u))
            i++;
        if( i < max )
            res = this.nodes.get(i);
        return res;
    };
    /* Add edge between u and v */
    public void addEdge(int u, int v)
    {
        node nu = getNode(u);
        node nv = getNode(v);
        nu.adj.add(v);
        nv.adj.add(u);
    };
    /* Prints adjacency list */
    public void print()
    {   
        this.nodes.forEach(
            (n) -> {

                System.out.print(n.elem + ": ");
                n.adj.forEach(
                    (m) -> System.out.print(m + " ") 
                );//n.adj.foreach
                System.out.println();

            }
        );//nodes.foreach
    };
    /* Get max element */
    public int max()
    {
        return this.maxNode;
    };
    /* Get current amount of nodes in graph*/
    public int size()
    {
        return this.nodeCount;
    };

    /* ========= BFS and DFS ========= */
    /* Prints nodes found during BFS from s */
    public void BFS(int s)
    {
        System.out.print("Breadth-First Search of graph: ");
        boolean visited[] = new boolean[this.maxNode + 1];//Array to keep track of visited nodes
        for(int i = 0; i <= this.maxNode; i++) visited[i] = false;
        node start = getNode(s); //Get starting node
        ArrayDeque<Integer> q = new ArrayDeque<Integer>(); //Queue for storing element of discovered nodes

        q.add(start.elem);
        System.out.print(s + " ");
        visited[s] = true;

        node current;
        while(!q.isEmpty())
        {
            current = this.getNode(q.peek());
            current.adj.forEach(
                (n) -> {
                    if(!visited[n]){ //If node is not visited add to queue
                        visited[n] = true;
                        q.add(n);
                        System.out.print(n + " ");
                    };
                }
            );//Endfor
            
            q.remove();
            
        };//Endwhile
        System.out.println();
    };

    /* Prints nodes found during DFS from s */
    public void DFS(int s)
    {
        System.out.print("Depth-First Search of graph: ");
        boolean visited[] = new boolean[this.maxNode + 1];//Array to keep track of visited nodes
        for(int i = 0; i <= this.maxNode; i++) visited[i] = false;
        Stack<Integer> st = new Stack<Integer>(); //Stack for storing element of discovered node
        st.push(s); node current;
        while(!st.isEmpty())
        {
            current = this.getNode(st.pop());
            if(!visited[current.elem]){
                System.out.print(current.elem + " ");
                visited[current.elem] = true;
                current.adj.forEach(
                    (n) -> {
                        st.push(n);
                    }
                );//EndFor
            };//Endif

        };//EndWhile

        System.out.println();
    };

}; //Main class