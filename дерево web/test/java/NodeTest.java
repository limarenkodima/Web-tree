import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NodeTest {
    @Test
    void NodeTestAdd(){
        Node node = new Node();
        node.Add("1");
        node.Add("2");
        node.Add("3");
        assertEquals(3, node.Size());
    }
    @Test
    void NodeTestRemove(){
        Node node = new Node();
        node.Add("1");
        node.Add("2");
        assertEquals(2, node.Size());
        // Удаление одного элемента
        node.Remove("1");
        assertEquals(1, node.Size());
        assertEquals("2", node.Find("2").GetData());
        // Удаление несуществующего элемента
        node.Remove("1");
        assertEquals(1, node.Size());
    }
    @Test
    void NodeTestRemoveAll(){
        Node node = new Node();
        node.Add("1");
        node.Add("2");
        assertEquals(2, node.Size());
        // Удаление всех элементов
        node.RemoveAll();
        assertEquals(0, node.Size());
        // Удаление из листа
        node.RemoveAll();
    }
    @Test
    void NodeTestFind(){
        Node node = new Node();
        // Найти несуществующий элемент
        Node foundNode = node.Find("1");
        assertEquals(null, foundNode);
        node.Add("1");
        node.Add("2");
        foundNode = node.Find("1");
        assertEquals("1", foundNode.GetData());
    }
    @Test
    void NodeTestSetData()
    {
        Node node = new Node();
        node.SetData("a");
        assertEquals("a", node.GetData());
    }
}
