import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

@Path("/")
public class ListPresentationController {
    private final Node tree;

    public ListPresentationController(Node list) {
        this.tree = list;
    }

    @GET
    @Path("...")
    @Produces("text/plain")
    public String getSimpleText() {
        return "Error 404";
    }

    @GET
    @Path("/")
    @Produces("text/html")
    public String getTree() {
        String result =
                "<html>" +
                        "  <head>" +
                        "    <title>Дерево</title>" +
                        "  </head>" +
                        "  <body>" +
                        "    <h1>Дерево</h1>" +
                             tree.toHtml() +
                        "  </body>" +
                        "</html>";
        return result;
    }

    @POST
    @Path("/remove/{path}/")
    @Produces("text/html")
    public Response removeItem(@PathParam("path") String path) {
        String[] StringList = path.split("-");
        Node curNode = tree;
        for (int i = 1; i < StringList.length - 1; i++) {
            curNode = curNode.getSubNode(Integer.parseInt(StringList[i]));
        }
        curNode.removeSubNode(Integer.parseInt(StringList[StringList.length - 1]));
        try {
            return Response.seeOther(new URI("/")).build();
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Ошибка URI");
        }
    }

    @GET
    @Path("/edit/{path}/")
    @Produces("text/html")
    public String getEditPage(@PathParam("path") String path) {
        String[] StringList = path.split("-");
        Node curNode = tree;
        for (int i = 1; i < StringList.length; i++) {
            curNode = curNode.getSubNode(Integer.parseInt(StringList[i]));
        }
        String result =
                "<html>" +
                        "  <head>" +
                        "    <title>Изменение элемента</title>" +
                        "  </head>" +
                        "  <body>" +
                        "    <h1>Изменение элемента</h1>" +
                        "    <form method=\"post\" action=\"/edit/" + curNode + "\">" +
                        "      <p>Значение элемента</p>" +
                        "      <input type=\"text\" name=\"value\" value=\"" + curNode.getData() +"\"/>" +
                        "      <input type=\"submit\" value=\"Set\"/>";
        result +=
                "            </form>" +
                        "    <form method=\"post\" action=\"/add/" + path + "\">" +
                        "      <p>Значение предыдущего элемента</p>" +
                        "      <input type=\"text\" name=\"value\" value=\"" + curNode.getData() +"\"/>" +
                        "      <input type=\"submit\" value=\"Add\"/>";
        result +=
                "            </form>" +
                        "  </body>" +
                        "</html>";
        return result;
    }

    @POST
    @Path("/edit/{id}")
    @Produces("text/html")
    public Response editItem(@PathParam("id") int itemId, @FormParam("value") String itemValue) {
        tree.add(itemValue);
        try {
            return Response.seeOther(new URI("/")).build();
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Ошибка URI");
        }
    }

    @POST
    @Path("/add/{path}")
    @Produces("text/html")
    public Response addItem(@PathParam("path") String path, @FormParam("value") String itemValue) {
        String[] StringList = path.split("-");
        Node curNode = tree;
        for (int i = 1; i < StringList.length; i++) {
            curNode = curNode.getSubNode(Integer.parseInt(StringList[i]));
        }
        curNode.add(itemValue);
        try {
            return Response.seeOther(new URI("/")).build();
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Ошибка URI");
        }
    }
}
