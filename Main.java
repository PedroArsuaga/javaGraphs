/**     See  graph folder for implementation     **/
/**
        Example graph:
  
        0  --- 1 --- 2 --- 4 
          \    |
            \  |
              3
  
 **/
import graphs.*;

public class Main 
{

    
    
    public static void main(String[] args)
    {
        /*UUGraph<Integer> G = new UUGraph<Integer>();
        for(int i = 0; i < 5; i++)
            G.add(i);
        G.addEdge(0, 1);
        G.addEdge(0,3);
        G.addEdge(1,3);
        G.addEdge(1,2);
        G.addEdge(2,4);
        G.dfs(0);*/
        directedGraph<Integer> G = new directedGraph<Integer>();
        for(int i = 1; i < 8; i++)
          G.add(i);
        G.addEdge(1,2);G.addEdge(1,3);G.addEdge(1,4);
        G.addEdge(2,4);G.addEdge(2,5);
        G.addEdge(3,6);
        G.addEdge(4,3);G.addEdge(4,6);G.addEdge(4,7);
        G.addEdge(5,4);G.addEdge(5,7);
        G.addEdge(7,6);
        G.dfs(1);

        
    };
    



}
