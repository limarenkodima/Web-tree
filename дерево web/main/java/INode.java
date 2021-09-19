public interface INode {
    public void Add(String str);
    public void Remove(String str);
    public void RemoveAll();
    public Node Find(String str);
    public void SetData(String str);
    public String GetData();
    public int Size();
}
