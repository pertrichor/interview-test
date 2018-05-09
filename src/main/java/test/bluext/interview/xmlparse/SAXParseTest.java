package test.bluext.interview.xmlparse;

import com.alibaba.fastjson.JSON;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.List;

/**
 * Description：
 *
 * @author : xutao
 *         Created_Date : 2018-05-03 14:39
 */
public class SAXParseTest {

    public static void main(String[] args) {
        try {
            SAXParserFactory sParserFactory = SAXParserFactory.newInstance();
            SAXParser parser = sParserFactory.newSAXParser();

            SAXParseHandler handler = new SAXParseHandler();
            parser.parse("src/main/resources/book.xml", handler);
            List<Book> books = handler.getBooks();

            System.out.println(JSON.toJSONString(books));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
