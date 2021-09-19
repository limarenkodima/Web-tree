import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJSON {
//
    @Test
    void toJSON()
    {
        Node node = new Node("0");
        node.add("1");
        node.add("2");
        node.find("1").add("3");
        //ObjectMapper objectMapper = new ObjectMapper();
        try {
            String myJson = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(node);
            System.out.println(myJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    @Test
    void toJSONFile()
    {
        Node node = new Node("0");
        node.add("1");
        node.add("2");
        node.find("1").add("3");
        node.toJSONFile("C:\\Users\\Admin\\Desktop\\TreeJson.json");
        Node loaded = node.fromJSONFile("C:\\Users\\Admin\\Desktop\\TreeJson.json");
        assertEquals(node.print(), loaded.print());
    }
}
