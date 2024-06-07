package DataStructures;//Undirected graph implemented using adjacency list

import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
public class Graph{
    private static class Vertex{
        String value;
        Vertex (String value){
            this.value = value;
        }

        @Override
        public boolean equals(Object other){
            if (other instanceof Vertex otherVertex){
                return this.value.equals(otherVertex.value);
            }
            return false;
        }

        @Override
        public int hashCode(){
            int code = 0;
            char[] charArray = value.toCharArray();
            for (char c : charArray) {
                code += c;
            }
            return code / charArray.length;
        }
    }

    private Map<Vertex, LinkedList<Vertex>> graph = new HashMap<>();

    public void addVertex(String value){
        graph.putIfAbsent(new Vertex(value), new LinkedList<>());
    }

    public void removeVertex(String value){
        graph.remove(new Vertex(value));
    }

    public boolean addEdge(String value1, String value2){
        Vertex vertex1 = new Vertex(value1);
        Vertex vertex2 = new Vertex(value2);
        if (graph.containsKey(vertex1) && graph.containsKey(vertex2)){
            graph.get(vertex1).add(vertex2);
            graph.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }

    public void removeEdge(String value1, String value2) {
        Vertex vertex1 = new Vertex(value1);
        Vertex vertex2 = new Vertex(value2);
        LinkedList<Vertex> edges1 = graph.get(vertex1);
        LinkedList<Vertex> edges2 = graph.get(vertex2);
        if (edges1 != null) edges1.remove(vertex2);
        if (edges2 != null) edges2.remove(vertex1);
    }

    public boolean adjacent(String value1, String value2){
        Vertex vertex1 = new Vertex(value1);
        Vertex vertex2 = new Vertex(value2);
        return graph.get(vertex1).contains(vertex2);
    }

    public LinkedList<String> getNeighbours(String value){
        LinkedList<String> result = new LinkedList<>();
        Vertex vertex = new Vertex(value);
        LinkedList<Vertex> neighbours = graph.get(vertex);
        for (Vertex neighbour : neighbours){
            result.add(neighbour.value);
        }
        return result;
    }
}
