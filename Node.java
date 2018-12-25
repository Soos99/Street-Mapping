//by Hoang Le
import java.util.ArrayList;

public class Node {
    String ID;
    double lat,lon;
    ArrayList<Edge> edges;
    public Node(String ID, double lat, double lon){
        this.ID = ID;
        this.lat = lat;
        this.lon = lon;
        edges = new ArrayList<>();
    }

    public String ID(){
        return ID;
    }

    public double Lat(){
        return lat;
    }

    public double Long(){
        return lon;
    }

    public ArrayList<Edge> Edges() { return edges; }

    public void addEdge(Edge edge) { edges.add(edge);}

}
