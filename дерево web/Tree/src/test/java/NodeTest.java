import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class NodeTest {
    @Test
    void NodeTestAdd(){
        Node node = new Node();
        node.add("1");
        node.add("2");
        node.add("3");
        assertEquals(3, node.size());
    }
    @Test
    void NodeTestRemove(){
        Node node = new Node();
        node.add("1");
        node.add("2");
        assertEquals(2, node.size());
        // Удаление одного элемента
        node.remove("1");
        assertEquals(1, node.size());
        assertEquals("2", node.find("2").getData());
        // Удаление несуществующего элемента
        node.remove("1");
        assertEquals(1, node.size());
    }
    @Test
    void NodeTestRemoveAll(){
        Node node = new Node();
        node.add("1");
        node.add("2");
        assertEquals(2, node.size());
        // Удаление всех элементов
        node.removeAll();
        assertEquals(0, node.size());
        // Удаление из листа
        node.removeAll();
    }
    @Test
    void NodeTestFind(){
        Node node = new Node();
        // Найти несуществующий элемент
        Node foundNode = node.find("1");
        assertEquals(null, foundNode);
        node.add("1");
        node.add("2");
        foundNode = node.find("1");
        assertEquals("1", foundNode.getData());
    }
    @Test
    void NodeTestSetData()
    {
        Node node = new Node();
        node.setData("a");
        assertEquals("a", node.getData());
    }
}
