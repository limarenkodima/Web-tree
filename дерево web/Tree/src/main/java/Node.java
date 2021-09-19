import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Node implements INode
{
    private String data;
    private ArrayList<Node> subNodes = new ArrayList<>();

    public Node() {

    }

    public String getData() {
        return data;
    }

    public ArrayList<Node> getSubNodes() {
        return subNodes;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setSubNodes(ArrayList<Node> subNodes) {
        this.subNodes = subNodes;
    }

    @Override
    public void removeSubNode(int i) {
        subNodes.remove(i);
    }

    @Override
    public Node getSubNode(int i) {
        return subNodes.get(i);
    }

    public Node(String str) {
        data = str;
    }

    public void add(String str) {
        subNodes.add(new Node(str));
    }

    public void remove(String str) {
        Node found = find(str);
        if(found == null) return;
        subNodes.remove(found);
    }

    public void removeAll() {
        subNodes.clear();
    }

    public Node find(String str) {
        for (Node n: subNodes)
            if(n.data == str) return n;
        return null;
    }

    public int size() {
        return subNodes.size();
    }

    @Override
    public String print() {
        String res = data + "[";
        for(Node a: subNodes){
            res += a.print();
        }
        res += "]";
        return res;
    }

    private String text(String path, int id, int it) {
        String result = "";
        for(int i = 0; i < it; i++) result += "..";
        result += data;
        result += "     <form style=\"display:inline-block;\" method=\"get\" action=\"/edit/" + path + "\"><input type=\"submit\" value=\"Edit\"/></form>";
        result += "     <form style=\"display:inline-block;\" method=\"post\" action=\"/remove/" + path + "\"><input type=\"submit\" value=\"Remove\"/></form>";
        result += "<br>";
        for (int i = 0; i < size(); i++) {
            result += subNodes.get(i).text(path + "-" + Integer.toString(i), i,it + 1);
        }
        return result;
    }

    @Override
    public String toHtml() {
        String path = "0";
        return text(path, 0,0);
    }

    @Override
    public void toJSONFile(String filename) {
        try {
            new ObjectMapper().writeValue(new File(filename), this);
        } catch (IOException e) {
            Logger.getLogger("log").log(Level.WARNING,"from JSON error:" , e);
        }
    }

    public static Node fromJSONFile(String filename) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Node node = objectMapper.readValue(new File(filename), Node.class);
            return node;
        } catch (IOException e) {
            Logger.getLogger("log").log(Level.WARNING,"from JSON error:" , e);
        }
        return null;
    }
}
