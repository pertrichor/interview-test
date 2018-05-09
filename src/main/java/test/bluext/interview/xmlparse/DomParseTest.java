package test.bluext.interview.xmlparse;

import com.alibaba.fastjson.JSON;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Description：使用dom方式解析xml文件
 *
 * @author : xutao
 *         Created_Date : 2018-05-03 10:36
 */
public class DomParseTest {

    public static void main(String[] args) {
        try {
            String fileName = "src/main/resources/book.xml";
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(fileName));

            NodeList nodeList = document.getElementsByTagName("book");// 获取所有book节点

            List<Book> bookList = new ArrayList<>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Book book = new Book();
                Node node = nodeList.item(i);
                String id = node.getAttributes().item(0).getTextContent();// 获取book节点的属性id
                book.setId(Integer.valueOf(id));

                NodeList childNodeList = node.getChildNodes();// 获取每个book节点下的所有子节点

                for (int j = 1; j < childNodeList.getLength(); j += 2) {// 子节点中包含换行符 , 跳过换行
                    Node childNode = childNodeList.item(j);
                    String nodeName = childNode.getNodeName();
                    String nodeVal = childNode.getTextContent();

                    if ("name".equals(nodeName)) {
                        book.setName(nodeVal);
                    }

                    if ("author".equals(nodeName)) {
                        book.setAuthor(nodeVal);
                    }

                    if ("year".equals(nodeName)) {
                        book.setYear(Integer.valueOf(nodeVal));
                    }

                    if ("price".equals(nodeName)) {
                        book.setPrice(Double.valueOf(nodeVal));
                    }
                }

                bookList.add(book);
            }

            System.out.println(JSON.toJSONString(bookList));

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
