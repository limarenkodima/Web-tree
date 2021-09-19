import java.util.ArrayList;

public class Node implements INode
{
    private String data;
    private ArrayList<Node> Nodes = new ArrayList<Node>();

    public Node() {

    }

    public Node(String str) {
        data = str;
    }

    public void Add(String str) {
        subNodes.add(new Node(str));
    }

    public void Remove(String str) {
        Node found = Find(str);
        if(found == null) return;
        Nodes.remove(found);
    }

    public void RemoveAll() {
        Nodes.clear();
    }

    public Node Find(String str) {
        for (Node n: Nodes)
            if(n.data == str) return n;
        return null;
    }

    public void SetData(String str) {
        data = str;
    }

    public String GetData() {
        return data;
    }

    public int Size() {
        return Nodes.size();
    }
}
