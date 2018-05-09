package test.bluext.interview.xmlparse;

import com.alibaba.fastjson.JSON;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Description：StAX解析xml
 *
 * @author : xutao
 *         Created_Date : 2018-05-03 15:21
 */
public class StAXParseTest {

    public static void main(String[] args) {
        try {
            XMLInputFactory factory = XMLInputFactory.newFactory();
            XMLStreamReader xmlStreamReader = factory.createXMLStreamReader(new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/main/resources/book.xml")))));

            List<Book> bookList = new ArrayList<>();
            Book book = new Book();
            while (xmlStreamReader.hasNext()) {
                int eventType = xmlStreamReader.next();

                if (XMLStreamConstants.START_ELEMENT == eventType) {
                    String nodeName = xmlStreamReader.getLocalName();
                    if ("book".equals(nodeName)) {
                        book.setId(Integer.valueOf(xmlStreamReader.getAttributeValue(null, "id")));
                    } else if (nodeName.equals("name")) {
                        book.setName(xmlStreamReader.getElementText());
                    } else if (nodeName.equals("author")) {
                        book.setAuthor(xmlStreamReader.getElementText());
                    } else if (nodeName.equals("year")) {
                        book.setYear(Integer.parseInt(xmlStreamReader.getElementText()));
                    } else if (nodeName.equals("price")) {
                        book.setPrice(Double.parseDouble(xmlStreamReader.getElementText()));
                    }
                }

                if (XMLStreamConstants.END_ELEMENT == eventType) {
                    if ("book".equals(xmlStreamReader.getLocalName())) {
                        bookList.add(book);
                        book = new Book();
                    }
                }
            }

            System.out.println(JSON.toJSONString(bookList));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
