package NineTails;

import java.util.ArrayList;
import java.util.List;
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *<pre>
 * Class        NineTailsModel.java
 * Description  Class for majority of logic and building the graph to solve the
 *              nine tails problem.
 * Project      Project 4 -- ine Tails Problem.
 * Platform     jdk 1.8.0_241; NetBeans IDE 18; PC Windows 10
 * Course       CS 143
 * Hours        5 hours 30 minutes
 * Date         3/24/2024
 * @author	<i>Robert Zimmerman</i>
 * @version 	1.0.0
 *</pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class NineTailsModel {
    public int gridSize = 3;                        //Length of grid sizes
    public int NUM_OF_NODES = 512;                  //Number of nodes in graph
    public int gridSquare = 9;                      //Number of cells in nodes
    public AbstractGraph<Integer>.Tree tree;        //Define the nodes tree
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  NineTailsModel - Default Constructor
     * Description  Defualt constructor for the NineTailsModel class
     * Date:        3/24/2024
     * @author      <i>Robert Zimmerman</i>
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    NineTailsModel(int numberOfNodes) {
        //Set the num of nodes
        NUM_OF_NODES = numberOfNodes;
        //Set the dimensions of each node
        setDimensions(NUM_OF_NODES);
        System.out.println("GridSize and Square(OUT): " + gridSize + ", " + gridSquare);
        //Create list of edges for graph
        List<AbstractGraph.Edge> edges = getEdges();
        System.out.println("GridSize and Square(EDGES): " + gridSize + ", " + gridSquare);
        //Create the graph of all edges
        UnweightedGraph<Integer> graph = new UnweightedGraph<>
                (edges, NUM_OF_NODES); 
        System.out.println("GridSize and Square(GRAPH): " + gridSize + ", " + gridSquare);
        //Create a tree with the root at the target value of node 511
        tree = graph.bfs(NUM_OF_NODES - 1);
        System.out.println("GridSize and Square(TREE): " + gridSize + ", " + gridSquare);
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       setDimensions()
     * Description  Sets gridSize and Square depending on number of nodes.
     * Date         11/17/2023
     * History      11/17/2023, 11/18/2023
     * @author      <i>Robert Zimmerman</i>
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void setDimensions(int numberOfNodes) {
        if(numberOfNodes == 512) {
            gridSize = 3;
        } else {
            gridSize = 4;
        }
        gridSquare = gridSize * gridSize;
        System.out.println("GridSize and Square(IN): " + gridSize + ", " + gridSquare);
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       getEdges()
     * Description  Builds a list of edges based in number of nodes, populates
     *              cells with H and T.
     * Date         11/17/2023
     * History      11/17/2023, 11/18/2023
     * @author      <i>Robert Zimmerman</i>
     * @return      List
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private List<AbstractGraph.Edge> getEdges() {
        //Create ArrayList to hold the edges
        List<AbstractGraph.Edge> edges = new ArrayList<>();
         
        for(int u = 0; u < NUM_OF_NODES; u++) {
            for(int t = 0; t < gridSquare; t++) {
                char[] uNode = getNode(u); //Build a new node for the current u value
                if(uNode[t] == 'H') {
                    int flipped = getFlippedNode(uNode, t);
                    //Create and edge from node u to the flipped node
                    edges.add(new AbstractGraph.Edge(flipped, u));
                }
            }
        }
        return edges;
    }
     
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       getFlippedNode()
     * Description  Takes in node and cell to be flipped, calls function to flip
     *              cell and adjacent cells. Returns flipped node.
     * Date         11/17/2023
     * History      11/17/2023, 11/18/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       node char[]
     * @param       position int
     * @return      int
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private int getFlippedNode(char[] node, int position) {
        //Row is the rounded down division of the position and 3, if both
        //were modulus then it would always be a square(0-0, 1-1, or 2-2)
        int row = position / gridSize;
        //Column is remaineder of the position in node (0,1,2)
        int col = position % gridSize;
        
        flipCell(node, row, col);
        flipCell(node, row - 1, col);
        flipCell(node, row + 1, col);
        flipCell(node, row, col - 1);
        flipCell(node, row, col + 1);
        
        return getIndex(node);
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       flipCell()
     * Description  Flips a cell to other side (T -> H || H -> T)
     * Date         11/17/2023
     * History      11/17/2023, 11/18/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       node char[]
     * @param       row int
     * @param       col int
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void flipCell(char[] node, int row, int col) {
        if(row >= 0 && row <= (gridSize - 1) && col >= 0 && col <= (gridSize - 1)) {
            if(node[row * gridSize + col] == 'H') {
                node[row * gridSize + col] = 'T';
            } else {
                node[row * gridSize + col] = 'H';
            }
        }
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       getIndex()
     * Description  Takes in cell, using math and T's and H's determines the 
     *              index and returns index of cell.
     * Date         11/17/2023
     * History      11/17/2023, 11/18/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       node char[]
     * @return      int
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int getIndex(char[] node) {
        int index = 0;
        //Look at each value in node to compute the index(undo the getNode process).
        for(int i = 0; i < gridSquare; i++) {
            if(node[i] == 'T') {
                index = index * 2 + 1;
            } else {
                index = index * 2;
            }
        }
        return index;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       getNode()
     * Description  Creates a node with filled cells based on given index,
     *              used to create initial list of nodes.
     * Date         11/17/2023
     * History      11/17/2023, 11/18/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       index int
     * @return      char[]
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public char[] getNode(int index) {
        //Temp place to hold the returned node
        char[] tempNode = new char[gridSquare];
         
        //Build a node based on the index number
        for(int i = 1; i <= gridSquare; i++) {
            int digit = index % 2;
            //If even then place n H otherwise place a T
            if(digit == 0) { 
                tempNode[gridSquare - i] = 'H';
            }else {
                tempNode[gridSquare - i] = 'T';
            }
            //Reduce index, if it is odd the the quotient will be rounded down
            index = index / 2;
        }
        return tempNode;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       bfsShortestPath()
     * Description  Use BFS method to find the shortest path from startNode to
     *              root of the graph(solution of all Ts). Returns the path as 
     *              list.
     * Date         11/17/2023
     * History      11/17/2023, 11/18/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       index int
     * @return      List
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public List<Integer> bfsShortestPath(int index) {
        //Use the getPath method in the tree sub class of AbstractGraph to
        //return the shortest path from the target value.
        return tree.getPath(index);
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       printNode()
     * Description  Takes in node, adds node to the string in a grid pattern
     *              used to hold the text before being displayed to the 
     *              richtextfield.
     * Date         11/17/2023
     * History      11/17/2023, 11/18/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       node char[]
     * @return      String
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public String printNode(char[] node) {
        System.out.println(node.length);
        String temp = "";
        for(int i = 0; i < gridSquare; i++) {
            if(i % gridSize != (gridSize - 1)) {
                temp += node[i] + " ";
            } else {
                temp += node[i] + "\n";
            }
        }
        temp += "\n";
        return temp;
    }
}
