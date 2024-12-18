package NineTails;
import java.util.*;
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
 * Class        UnweightedGraph.java
 * Description  Concrete class in the triad of defining data structures in
 *              Java with interfaces, abstract classes and concrete classes.
 *              It extends the abstract AbstractGraph class.
 * Platform     jdk 1.8.0_241; NetBeans IDE 11.3; PC Windows 10
 * Course       CS 143
 * Hourse       1 hours and 9 minutes
 * Date         11/12/2023
 * History Log  11/12/2023
 * @author	<i>Robert Zimmerman</i>
 * @version 	%1%
 * @param       <V> generic type
 *</pre>
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class UnweightedGraph<V> extends AbstractGraph<V> 
{
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  UnweightedGraph()-default constructor.
     * Description  Construct an empty graph
     * Date         11/12/2023
     * History Log  11/12/2023
     * @author      <i>Robert Zimmerman</i>
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    public UnweightedGraph() 
    {
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  UnweightedGraph()-overloaded constructor
     * Description  Construct a graph from vertices and edges stored in arrays.
     * Date         11/12/2023
     * History Log  11/12/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       vertices V[]
     * @param       edges int[][]
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/     
    public UnweightedGraph(V[] vertices, int[][] edges) 
    {
        super(vertices, edges);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  UnweightedGraph()-overloaded constructor
     * Description  Construct a graph from vertices and edges stored in List.
     * Date         11/12/2023
     * History Log  11/12/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       vertices List
     * @param       edges List
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/     
    public UnweightedGraph(List<V> vertices, List<Edge> edges) 
    {
        super(vertices, edges);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  UnweightedGraph()-overloaded constructor
     * Description  Construct a graph for integer vertices 0, 1, 2 and edge list.
     * Date         11/12/2023
     * History Log  11/12/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       edges List
     * @param       numberOfVertices int
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    
    public UnweightedGraph(List<Edge> edges, int numberOfVertices) 
    {
        super(edges, numberOfVertices);
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  UnweightedGraph()-overloaded constructor
     * Description  Construct a graph from integer vertices 0, 1, and edge array.
     * Date         11/12/2023
     * History Log  11/12/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       edges int[][]
     * @param       numberOfVertices int
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    public UnweightedGraph(int[][] edges, int numberOfVertices) 
    {
        super(edges, numberOfVertices);
    }       
}
