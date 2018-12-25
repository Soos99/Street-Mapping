// by Hoang Le
public class Edge {
    public final static double RADIUS = 6378.0;
    double dist;
    String ID;
    String inter1,inter2;
    public Edge(String ID, String inter1, String inter2){
        this.ID = ID;
        this.inter1 = inter1;
        this.inter2 = inter2;
        double lat1 = Graph.findNode.get(inter1).Lat();
        double lat2 = Graph.findNode.get(inter2).Lat();
        double long1 = Graph.findNode.get(inter1).Long();
        double long2 = Graph.findNode.get(inter2).Long();
        dist = 2*RADIUS*Math.asin(Math.sqrt(Math.pow(Math.sin(0.5*(lat2 - lat1)),2.0) + Math.cos(lat1)*Math.cos(lat2)*Math.pow(Math.sin(0.5*(long2 - long1)),2.0)));
    }

    public String inter1() { return inter1; }
    public String inter2() { return inter2; }
    public String RoadID() { return ID; }
    public double dist(){
        return dist;
    }
}
