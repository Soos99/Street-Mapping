*Contact Information:
- Name: Hoang Le
- NetID: hle7
- Email: hle7@u.rochester.edu
*Class and lab number:
- CSC 172
- Lab time: TR 1400
- Lab Room: MEL 210
*How my code work:
- First, it reads the data from the input file and intialize the Graph object with nodes(intersections) and edges (roads). Then, if the users write "--show" it draw the map using Java Graphics by visiting all nodes and their unvisited roads. Finally, I implements Dijkstra algorithm to find the shortest path between two locations if the users write "--direction"
*Obstacles: 
- I have some problems with reading the input file at the beginning, as my program read the entire line, not one word at a time. It affects the whole program in general, as the inputs I read are incorrect. It takes me a lot of time to recognize this fault.
- The second problem is when I implements the findMin method in Dijkstra algorithm, as my program finds the marked smallest path, so it enters the infinity loop.
*List of files: DrawMap.java, Edge.java, Graph.java, Node.java, StreetMap.java, and README.txt
*Design:
- Edge class represents the roads
- Node class represents the intersections. Each Node contains an arraylist of edges, which is the list of the distances to its neighbors.
- Graph class contains a hashmap of String and Node so that we can find the Node based on String
- StreetMap class contains the Dijkstra algorithm. To find the smallest path for Dijkstra, I use the Priority Queue.
- DrawMap class contains the drawing methods. The map automatically scales to the size of the window.
*Expected runtime: 
- The runtime to initialize the graph is O(|V| + |E|)
- The runtime to draw the map is O(|V| + |E|)
- Find the shortest path: The Dijkstra algorithm cost is O(|E|log|E| + |V|log|V|). However, during the program, I use the HashMap to find the Node and the index, so the complexity is O(|E|*log|E|*log|E| + |V|*log|V|*log|V|), as the hash code costs O(log N) in average.

