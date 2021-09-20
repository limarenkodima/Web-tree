import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Web-приложение в котором регистрируются все ресурсы.
 */
public class WebApplication extends Application {

    private Node Tree = new Node();

    public WebApplication() {
        Tree.setData("aaa");
        Tree.add("aaa");
        Tree.add("bbb");
        Tree.add("ccc");
        Tree.add("ddd");
        Tree.find("aaa").add("asd");
        Tree.find("aaa").add("ttt");
        Tree.find("ccc").add("ttt");
    }

    /**
     * Возвращает список всех ресурсов web-приложения.
     * @return список всех ресурсов web-приложения.
     */
    @Override
    public Set<Object> getSingletons() {
        Set<Object> resources = new HashSet<>();
        resources.add(new ListPresentationController(Tree));
        return resources;
    }
}
