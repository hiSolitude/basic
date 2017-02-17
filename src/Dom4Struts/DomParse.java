package Dom4Struts;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.*;

/**
 * Created by solitude on 2017/2/13.
 */
public class DomParse {
    public static Map<String,ActionBean> parse(String filePath) {
        Map<String, ActionBean> map = new HashMap<String, ActionBean>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document dom = builder.parse(new File(filePath));
            Element root = dom.getDocumentElement();
            NodeList actionNodes = root.getChildNodes();

            for (int i = 0;i<actionNodes.getLength();i++){
                Node actionNode = actionNodes.item(i);
                if ("action".equals(actionNode.getNodeName())){
                    ActionBean ab = new ActionBean();
                    String actionName = actionNode.getAttributes().getNamedItem("name").getNodeValue();
                    String className = actionNode.getAttributes().getNamedItem("class").getNodeValue();
                    String methodName = actionNode.getAttributes().getNamedItem("method").getNodeValue();
                    ab.setName(actionName);
                    ab.setClassPath(className);
                    ab.setMethodName(methodName);

                    Map<String,Result> results = new HashMap<String ,Result>();
                    NodeList resultNodes = actionNode.getChildNodes();
                    for (int j = 0; j < resultNodes.getLength(); j++) {
                        Node resultNode = resultNodes.item(j);
                        if ("result".equals(resultNode.getNodeName())) {
                            Result result = new Result();
                            String name = resultNode.getAttributes().getNamedItem("name").getNodeValue();
                            String type = resultNode.getAttributes().getNamedItem("type").getNodeValue();
                            String path = resultNode.getTextContent();
                            result.setName(name);
                            result.setType(type);
                            result.setPath(path);
                            results.put(name, result);
                        }
                    }
                    ab.setResults(results);
                    map.put(actionName, ab);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }
    public static void main(String[] args){
        Map<String,ActionBean> map = parse("classPath\\struts.xml");
        ActionBean a = map.get("user");
        System.out.println(a.getResults().get("success").getType());
        System.out.println(DomParse.class.getClassLoader().getResource("").toString());
    }
}
