import java.util.ArrayList;

public interface INode {
    public String getData();
    public ArrayList<Node> getSubNodes();
    public void setData(String data);
    public void setSubNodes(ArrayList<Node> Nodes);
    public void removeSubNode(int i);
    public Node getSubNode(int i);
    public void add(String str);
    public void remove(String str);
    public void removeAll();
    public Node find(String str);
    public int size();
    public String print();
    public String toHtml();
    public void toJSONFile(String filename);
}
