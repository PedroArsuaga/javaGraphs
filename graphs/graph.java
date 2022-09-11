/* INTERFACE FOR INTEGER/FLOAT GRAPHS */

package graphs;

public interface graph<E extends Number>
{
    /* Interface for nodes of graph */
    public interface nodeTemplate{};

    /* Adds E to the graph */
    public void add(E e);

    /* Removes E from the graph */
    public void remove(E e);

    /* Adds edge between u and v */
    public void addEdge(E u, E v);

    /* Removes edge between u and v */
    public void removeEdge(E u, E v);

    /* Breadth-first-search starting from s*/
    public void bfs(E s);

    /* Depth-first-search starting from s */
    public void dfs(E e);

    /* Looks for e in the graph */
    public boolean contains(E e);

};