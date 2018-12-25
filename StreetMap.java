// by Hoang Le
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class StreetMap {
    public static ArrayList<String> shortestPath;
    static Graph graph;
    static DrawMap dm;
    public static void main(String[] args) throws FileNotFoundException {
        String fileDir = args[0];
        Graph graph = new Graph(fileDir);
        boolean hasShow = false;
        boolean hasDirect = false;
        String source = "", target = "";
        for (int i = 0; i < args.length; i++){
            if (args[i].equals("--show"))
                hasShow = true;
            if (args[i].equals("--directions")){
                hasDirect = true;
                source = args[i+1];
                target = args[i+2];
            }
        }
        if (hasDirect){
            shortestPath = findShortestPath(graph,source,target);
        }
        if (hasShow) {
            dm = new DrawMap(graph);
        }
    }

    //Using Dijkstra algorithm
    public static ArrayList<String> findShortestPath(Graph graph, String source, String target){
        HashMap<Double,Integer> index1 = new HashMap<>();
        HashMap<String,Integer> index = new HashMap<>();
        String[] findValue = new String[graph.n()];
        double[] path = new double[graph.n()];
        boolean[] mark = new boolean[graph.n()];
        int[] prev = new int[graph.n()];
        ArrayList<String> shortestPath = new ArrayList<>();
        int j = 0;
        for (String key : graph.findNode.keySet()){
            index.put(key,j);
            path[j] = Double.MAX_VALUE;
            findValue[j] = key;
            mark[j] = false;
            j++;
        }
        // Check if two input locations are correct
        if (!index.containsKey(source) || !index.containsKey(target)){
            System.out.println("Sorry, it seems that you enter the wrong location");
            return null;
        }
        else {
            prev[index.get(source)] = -1;
            path[index.get(source)] = 0;
            index1.put(0.0,index.get(source));
            PriorityQueue<Double> minHeap = new PriorityQueue<>();
            minHeap.add(0.0);
            while (!mark[index.get(target)]) {
                while (minHeap.size() > 0 && mark[index1.get(minHeap.peek())]){
                    minHeap.remove();
                }
                //Check if the destination is reachable
                if (minHeap.size() == 0){
                    System.out.println("Sorry, this destination is unreachable from " + source);
                    return null;
                }
                int choose = index1.get(minHeap.remove());
                mark[choose] = true;
                ArrayList<Edge> edges = graph.findNode.get(findValue[choose]).Edges();
                for (int i = 0; i < edges.size(); i++) {
                    String destination = edges.get(i).inter2();
                    if ((!mark[index.get(destination)]) && ((path[choose] + edges.get(i).dist()) < path[index.get(destination)])) {
                        path[index.get(destination)] = path[choose] + edges.get(i).dist();
                        prev[index.get(destination)] = choose;
                        minHeap.add(path[index.get(destination)]);
                        index1.put(path[index.get(destination)],index.get(destination));
                    }
                }
            }
            String s = target;
            while (prev[index.get(s)] != -1) {
                shortestPath.add(0, s);
                s = findValue[prev[index.get(s)]];
            }
            shortestPath.add(0, source);
            System.out.println("The total distance is " + path[index.get(target)]);
            System.out.print("The shortest way from " + source + " to " + target + " is: ");
            for (int i = 0; i < shortestPath.size(); i++) {
                System.out.print(shortestPath.get(i) + " ");
            }
            System.out.println();
            return shortestPath;
        }
    }
}