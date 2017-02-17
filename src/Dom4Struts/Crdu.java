package Dom4Struts;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;

/**
 * Created by solitude on 2017/2/14.
 */
public class Crdu {
    public static void main(String[] args) throws Exception{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("classPath\\book.xml");
//        read2(document);
//        read1(document);
//        read3(document);
//        add(document);
        addAttr(document);
    }

    //遍历xml文档所有节点
    public static void read2(Document document) throws Exception{
        Node node = document.getElementsByTagName("书架").item(0);
        list(node);
    }

    private static void list(Node node){
        //只打印标签
        if (node instanceof Element){
            System.out.println(node.getNodeName());
        }
        NodeList list = node.getChildNodes();
        for (int i = 0;i<list.getLength();i++){
            Node child = list.item(i);
                list(child);
        }
    }

    //获取指定节点内容
    public static void read1(Document document) throws Exception{
        NodeList list = document.getElementsByTagName("书名");
        Node node = list.item(1);
        String content = node.getTextContent();
        System.out.println(content);
    }

    //获取xml文档中标签的属性值
    public static void read3(Document document) throws Exception{
        NodeList list = document.getElementsByTagName("书名");
        Node nodeName = list.item(0);
        Element bookName = (Element) nodeName;
        String content = bookName.getAttribute("name");
        System.out.println(content);
    }
    //向xml文档中添加节点：<售价>59.00元</售价>
    public static void add(Document document) throws Exception{
        Element price = document.createElement("售价");
        price.setTextContent("59.00元");
        Element bookNode = (Element)document.getElementsByTagName("书").item(0);
        bookNode.appendChild(price);
        //把更新后的内存写到xml文档中
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new FileOutputStream("classPath\\book.xml"));
        transformer.transform(source,result);
    }

    //向xml文档节点中插入属性
    public static void addAttr(Document document) throws Exception{
        Element bookName = (Element)document.getElementsByTagName("作者").item(0);
        bookName.setAttribute("age","24");
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new FileOutputStream("classPath\\book.xml"));
        transformer.transform(source,result);
    }
    // 删除<售价>59.00元</售价>
    public static void delete(Document document) throws Exception {
        Element delNode = (Element) document.getElementsByTagName("售价").item(0);
        Element book = (Element) delNode.getParentNode();
        book.removeChild(delNode);
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new FileOutputStream(
            "src/book.xml"));
        transformer.transform(source, result);
    }
    // 更新价格
    public static void update(Document document) throws Exception {
        Element priceNode = (Element) document.getElementsByTagName("售价").item(0);
        priceNode.setTextContent("199.00元");
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new FileOutputStream(
            "src/book.xml"));
        transformer.transform(source, result);
    }
}
