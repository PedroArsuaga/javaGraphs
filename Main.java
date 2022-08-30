/**     See intGraph.java for implementation     **/
/**
        Example graph:
  
        0  --- 1 --- 2 --- 4 
          \    |
            \  |
              3
  
 **/


public class Main 
{

    
    
    public static void main(String[] args)
    {
        intGraph G = new intGraph();
        for(int i = 0; i < 5; i++)
            G.add(i);
        G.addEdge(0, 1);
        G.addEdge(0,3);
        G.addEdge(1,3);
        G.addEdge(1,2);
        G.addEdge(2,4);
        G.print();
        G.BFS(0);
        G.DFS(0);
    };
    



}
