package io.meighen.service_bulder.service.builders;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

import io.meighen.service_bulder.entity_flow.*;
import io.meighen.service_bulder.entity_flow.Path;
import io.meighen.service_bulder.entity_flow.Properties;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;

@Service
public class Builder_SQL {
    public void build(String m) throws IOException, URISyntaxException {
//        String path = "{\"offset\":{\"x\":-2033,\"y\":-819,\"deltaX\":0,\"deltaY\":1,\"lastX\":-2033,\"lastY\":-820},\"nodes\":{\"e057b382-2a23-460d-8b84-8b0c468e1d4d\":{\"id\":\"e057b382-2a23-460d-8b84-8b0c468e1d4d\",\"position\":{\"x\":2160,\"y\":824,\"deltaX\":-1,\"deltaY\":0,\"lastX\":2161,\"lastY\":824},\"orientation\":0,\"type\":\"start\",\"ports\":{\"port4\":{\"id\":\"port4\",\"type\":\"bottom\",\"position\":{\"x\":50,\"y\":102}}},\"properties\":{\"name\":\"Start\",\"Id\":\"\",\"nodeRole\":\"\"},\"size\":{\"width\":100,\"height\":100}},\"e6b59a14-8653-47b3-bcac-1c92e5719119\":{\"id\":\"e6b59a14-8653-47b3-bcac-1c92e5719119\",\"position\":{\"x\":2110,\"y\":1017,\"deltaX\":-1,\"deltaY\":0,\"lastX\":2111,\"lastY\":1017},\"orientation\":0,\"type\":\"process-point\",\"ports\":{\"port1\":{\"id\":\"port1\",\"type\":\"top\",\"position\":{\"x\":100,\"y\":-2}},\"port3\":{\"id\":\"port3\",\"type\":\"bottom\",\"position\":{\"x\":100,\"y\":122}}},\"properties\":{\"name\":\"Установка начальных значений\",\"Id\":\"\",\"nodeRole\":\"\"},\"size\":{\"width\":200,\"height\":120}},\"570e649e-0f44-423b-8f00-6fc0988e8bcb\":{\"id\":\"570e649e-0f44-423b-8f00-6fc0988e8bcb\",\"position\":{\"x\":2110,\"y\":1234,\"deltaX\":-1,\"deltaY\":0,\"lastX\":2111,\"lastY\":1234},\"orientation\":0,\"type\":\"process-point\",\"ports\":{\"port1\":{\"id\":\"port1\",\"type\":\"top\",\"position\":{\"x\":100,\"y\":-2}},\"port3\":{\"id\":\"port3\",\"type\":\"bottom\",\"position\":{\"x\":100,\"y\":122}}},\"properties\":{\"name\":\"Проверка установленных значений\",\"Id\":\"\",\"nodeRole\":\"\"},\"size\":{\"width\":200,\"height\":120}},\"999b93ef-d795-4616-9891-861830cb42bc\":{\"id\":\"999b93ef-d795-4616-9891-861830cb42bc\",\"position\":{\"x\":2537,\"y\":950,\"deltaX\":0,\"deltaY\":1,\"lastX\":2537,\"lastY\":949},\"orientation\":0,\"type\":\"process-queue\",\"ports\":{\"port1\":{\"id\":\"port1\",\"type\":\"top\",\"position\":{\"x\":100,\"y\":-2}},\"port3\":{\"id\":\"port3\",\"type\":\"bottom\",\"position\":{\"x\":100,\"y\":122}}},\"properties\":{\"name\":\"Расчёт основных параметров\",\"Id\":\"\",\"nodeRole\":\"\"},\"size\":{\"width\":200,\"height\":120}},\"7162f4ae-cc42-412f-9083-cbde9bcd49e5\":{\"id\":\"7162f4ae-cc42-412f-9083-cbde9bcd49e5\",\"position\":{\"x\":2537,\"y\":1183,\"deltaX\":0,\"deltaY\":-1,\"lastX\":2537,\"lastY\":1184},\"orientation\":0,\"type\":\"process-point\",\"ports\":{\"port1\":{\"id\":\"port1\",\"type\":\"top\",\"position\":{\"x\":100,\"y\":-2}},\"port3\":{\"id\":\"port3\",\"type\":\"bottom\",\"position\":{\"x\":100,\"y\":122}}},\"properties\":{\"name\":\"Обработка ответа\",\"Id\":\"\",\"nodeRole\":\"\"},\"size\":{\"width\":200,\"height\":120}},\"858bc5a9-683d-4624-9beb-2ce35cd6ca0f\":{\"id\":\"858bc5a9-683d-4624-9beb-2ce35cd6ca0f\",\"position\":{\"x\":2587,\"y\":1413,\"deltaX\":0,\"deltaY\":-1,\"lastX\":2587,\"lastY\":1414},\"orientation\":0,\"type\":\"end\",\"ports\":{\"port3\":{\"id\":\"port3\",\"type\":\"top\",\"position\":{\"x\":50,\"y\":-2}}},\"properties\":{\"name\":\"End\",\"Id\":\"\",\"nodeRole\":\"\"},\"size\":{\"width\":100,\"height\":100}}},\"links\":{\"95ce6c69-a5d7-4e20-9c76-197ca515a2d4\":{\"id\":\"95ce6c69-a5d7-4e20-9c76-197ca515a2d4\",\"from\":{\"nodeId\":\"e057b382-2a23-460d-8b84-8b0c468e1d4d\",\"portId\":\"port4\"},\"to\":{\"nodeId\":\"e6b59a14-8653-47b3-bcac-1c92e5719119\",\"portId\":\"port1\"},\"properties\":{\"label\":\"\"}},\"3995de59-6ecc-45c0-b022-f5d2107d5439\":{\"id\":\"3995de59-6ecc-45c0-b022-f5d2107d5439\",\"from\":{\"nodeId\":\"e6b59a14-8653-47b3-bcac-1c92e5719119\",\"portId\":\"port3\"},\"to\":{\"nodeId\":\"570e649e-0f44-423b-8f00-6fc0988e8bcb\",\"portId\":\"port1\"},\"properties\":{\"label\":\"\"}},\"4d056a0d-34e8-4c92-b1c0-079dccde7292\":{\"id\":\"4d056a0d-34e8-4c92-b1c0-079dccde7292\",\"from\":{\"nodeId\":\"570e649e-0f44-423b-8f00-6fc0988e8bcb\",\"portId\":\"port3\"},\"to\":{\"nodeId\":\"999b93ef-d795-4616-9891-861830cb42bc\",\"portId\":\"port1\"},\"properties\":{\"label\":\"\"}},\"626f2056-5fcf-4ade-b54f-3106427782cc\":{\"id\":\"626f2056-5fcf-4ade-b54f-3106427782cc\",\"from\":{\"nodeId\":\"999b93ef-d795-4616-9891-861830cb42bc\",\"portId\":\"port3\"},\"to\":{\"nodeId\":\"7162f4ae-cc42-412f-9083-cbde9bcd49e5\",\"portId\":\"port1\"},\"properties\":{\"label\":\"\"}},\"bf8c2b6f-5f7d-414d-984d-7d9a4c5ffc30\":{\"id\":\"bf8c2b6f-5f7d-414d-984d-7d9a4c5ffc30\",\"from\":{\"nodeId\":\"7162f4ae-cc42-412f-9083-cbde9bcd49e5\",\"portId\":\"port3\"},\"to\":{\"nodeId\":\"858bc5a9-683d-4624-9beb-2ce35cd6ca0f\",\"portId\":\"port3\"},\"properties\":{\"label\":\"\"}}},\"selected\":{\"type\":\"node\",\"id\":\"570e649e-0f44-423b-8f00-6fc0988e8bcb\"},\"hovered\":{},\"preNodes\":[\"e057b382-2a23-460d-8b84-8b0c468e1d4d\",\"e6b59a14-8653-47b3-bcac-1c92e5719119\",\"570e649e-0f44-423b-8f00-6fc0988e8bcb\",\"999b93ef-d795-4616-9891-861830cb42bc\",\"7162f4ae-cc42-412f-9083-cbde9bcd49e5\",\"858bc5a9-683d-4624-9beb-2ce35cd6ca0f\"],\"isModelShow\":false,\"nodeName\":\"End\",\"nodeId\":\"\",\"newNodeId\":\"858bc5a9-683d-4624-9beb-2ce35cd6ca0f\",\"preLinks\":[\"95ce6c69-a5d7-4e20-9c76-197ca515a2d4\",\"3995de59-6ecc-45c0-b022-f5d2107d5439\",\"4d056a0d-34e8-4c92-b1c0-079dccde7292\",\"626f2056-5fcf-4ade-b54f-3106427782cc\",\"bf8c2b6f-5f7d-414d-984d-7d9a4c5ffc30\"],\"showModelName\":\"newLinkModel\",\"linkLabel\":\"\",\"newLinkId\":\"bf8c2b6f-5f7d-414d-984d-7d9a4c5ffc30\",\"clickNodeId\":\"\",\"modelOption\":\"addLabel\",\"nodeRoleOption\":\"\",\"clickLinkId\":\"3995de59-6ecc-45c0-b022-f5d2107d5439\",\"alertMessageInfo\":\"\",\"alertMessageStatus\":\"init\"}";

        Path p = parse(m);
        List<Node> list = makeGraph(p);

//        URL resource = new ClassPathResource("demo").getURL();

//        createTemplate("");
        copyMainTemplateFolder();

//        for(Node node: list) {
//            createTemplate(node.getProperties().getNodeScript());
//        }
    }

    protected void copyMainTemplateFolder() throws IOException, URISyntaxException {
        File source = new File(new ClassPathResource("/demo").getURL().toURI());
        File dest = new File(new File(new FileSystemResource("").getFile().getAbsolutePath()).toURI());
        try {
            FileUtils.copyDirectory(source, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void createTemplate(String scrptName) throws IOException, URISyntaxException {
        File source = new File(new ClassPathResource("Template.java").getURL().toURI());
        File dest = new File(new ClassPathResource("/demo/src/main/java/com/meighen/demo").getURL().toURI());
        try {
            FileUtils.copyFileToDirectory(source, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copyFromJar(String source, final java.nio.file.Path target) throws URISyntaxException, IOException {
//        URI resource = getClass().getResource("").toURI();
        URI resource = new ClassPathResource("demo/Dockerfile").getURI();
        System.out.println(resource);
        FileSystem fileSystem = FileSystems.newFileSystem(
                resource,
                Collections.<String, String>emptyMap()
        );


        final java.nio.file.Path jarPath = fileSystem.getPath(source);

        Files.walkFileTree(jarPath, new SimpleFileVisitor<java.nio.file.Path>() {

            private java.nio.file.Path currentTarget;

            @Override
            public FileVisitResult preVisitDirectory(java.nio.file.Path dir, BasicFileAttributes attrs) throws IOException {
                currentTarget = target.resolve(jarPath.relativize(dir).toString());
                Files.createDirectories(currentTarget);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(java.nio.file.Path file, BasicFileAttributes attrs) throws IOException {
                Files.copy(file, target.resolve(jarPath.relativize(file).toString()), StandardCopyOption.REPLACE_EXISTING);
                return FileVisitResult.CONTINUE;
            }

        });
    }

    protected List<Node> makeGraph(Path path) {
        System.out.println("Graph: ");

        List<Node> linkedList = new LinkedList<Node>();

        // Find Start node
        Node curNode = path.getNodes().stream().filter(node -> node.type.equals("start")).findFirst().orElse(null);
        if (curNode == null) {return linkedList;}
        linkedList.add(curNode);
        System.out.print(curNode.id + "(" + curNode.type + ") ");

        while (!curNode.type.equals("end")) {
            String curUUID = curNode.id;
            Link linkTo = path.getLinks().stream().filter(link -> link.from.nodeId.equals(curUUID)).findFirst().orElse(null);
            curNode = path.getNodes().stream().filter(node -> node.id.equals(linkTo.to.nodeId)).findFirst().orElse(null);
            linkedList.add(curNode);
            System.out.print("-> " + curNode.id + "(" + curNode.type + ") ");
        }
        System.out.println();
        return linkedList;
    }

    protected Path parse(String inPath) {
        System.out.println("Started");
        JSONObject obj = new JSONObject(inPath);

        Offset offset = new Offset(
                obj.getJSONObject("offset").getInt("x"),
                obj.getJSONObject("offset").getInt("y"),
                obj.getJSONObject("offset").getInt("deltaX"),
                obj.getJSONObject("offset").getInt("deltaY"),
                obj.getJSONObject("offset").getInt("lastX"),
                obj.getJSONObject("offset").getInt("lastY")
        );

        List<Node> nodes = new ArrayList<Node>();
        Iterator<String> node_keys = obj.getJSONObject("nodes").keys();
        while(node_keys.hasNext()){
            String key = node_keys.next();

            JSONObject temp_node = (JSONObject) obj.getJSONObject("nodes").get(key);
            Node node = new Node(
                    temp_node.getString("id"),
                    new Position(
                            temp_node.getJSONObject("position").getInt("x"),
                            temp_node.getJSONObject("position").getInt("y"),
                            temp_node.getJSONObject("position").getInt("deltaX"),
                            temp_node.getJSONObject("position").getInt("deltaY"),
                            temp_node.getJSONObject("position").getInt("lastX"),
                            temp_node.getJSONObject("position").getInt("lastY")
                    ),
                    temp_node.getInt("orientation"),
                    temp_node.getString("type"),
                    null,
                    new Properties(
                            temp_node.getJSONObject("properties").getString("name"),
                            temp_node.getJSONObject("properties").getString("Id"),
                            temp_node.getJSONObject("properties").getString("nodeRole"),
                            temp_node.getJSONObject("properties").getString("nodeScript")
                    ),
                    null
            );

            nodes.add(node);
        }

        List<Link> links = new ArrayList<Link>();
        Iterator<String> link_keys = obj.getJSONObject("links").keys();
        while(link_keys.hasNext()) {
            String key = link_keys.next();

            JSONObject temp_link = (JSONObject) obj.getJSONObject("links").get(key);
            Link link = new Link(
                    temp_link.getString("id"),
                    new From(
                            temp_link.getJSONObject("from").getString("nodeId"),
                            temp_link.getJSONObject("from").getString("portId")
                    ),
                    new To(
                            temp_link.getJSONObject("to").getString("nodeId"),
                            temp_link.getJSONObject("to").getString("portId")
                    ),
                    null
            );

            links.add(link);
        }

        Path path = new Path(
                offset,
                nodes,
                links,
                null,
                null,
                null,
                obj.getBoolean("isModelShow"),
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );

        System.out.println(path.toString());
        return path;
    }
}
