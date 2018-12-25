//by Hoang Le
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Graph {
    public static double maxLong = Integer.MIN_VALUE;
    public static double minLong = Integer.MAX_VALUE;
    public static double maxLat = Integer.MIN_VALUE;
    public static double minLat = Integer.MAX_VALUE;
    int n,e;
    public static HashMap<String,Node> findNode;
    public Graph(String fileDir) throws FileNotFoundException {
        n = 0;
        e = 0;
        findNode = new HashMap<>();
        String s1 = "";
        String s2 = "";
        String s3 = "";
        String s4 = "";
        File file = new File(fileDir);
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            s1 = sc.next();
            s2 = sc.next();
            s3 = sc.next();
            s4 = sc.next();
            if (s1.equals("i")){
                double longitude = Double.parseDouble(s4);
                double latitude = Double.parseDouble(s3);
                Node node = new Node(s2,latitude,longitude);
                findNode.put(node.ID(),node);
                n++;
                if (maxLat < latitude)
                    maxLat = latitude;
                if (minLat > latitude)
                    minLat = latitude;
                if (maxLong < longitude)
                    maxLong = longitude;
                if (minLong > longitude)
                    minLong = longitude;
            }
            else if (s1.equals("r")){
                findNode.get(s3).addEdge(new Edge(s2,s3,s4));
                findNode.get(s4).addEdge(new Edge(s2,s4,s3));
                e++;
            }
        }
    }

    public int n() {
        return n;
    }
    public int e() {
        return e;
    }
}
