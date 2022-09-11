/**     See intGraph.java for implementation     **/
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
        UUGraph<Integer> G = new UUGraph<Integer>();
        for(int i = 0; i < 5; i++)
            G.add(i);
        G.addEdge(0, 1);
        G.addEdge(0,3);
        G.addEdge(1,3);
        G.addEdge(1,2);
        G.addEdge(2,4);
        G.remove(0);
        G.print();
        

        
    };
    



}
