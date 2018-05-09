package test.bluext.interview.xmlparse;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：sax解析器
 *
 * @author : xutao
 *         Created_Date : 2018-05-03 14:10
 */
public class SAXParseHandler extends DefaultHandler {
    private List<Book> list = new ArrayList<>(); // 存放解析到的book数组
    private Book book; // 存放当前解析的book

    private String content = null; // 存放当前节点值

    /**
     * 开始解析节点时调用此方法
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);

        //当节点名为book时,获取book的属性id
        if (qName.equals("book")) {
            book = new Book();
            String id = attributes.getValue("id");//System.out.println("id值为"+id);
            book.setId(Integer.parseInt(id));
        }
    }


    /**
     * 节点解析完毕时调用此方法
     *
     * @param qName 节点名
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);

        if (qName.equals("name")) {
            book.setName(content);
        } else if (qName.equals("author")) {
            book.setAuthor(content);
        } else if (qName.equals("year")) {
            book.setYear(Integer.parseInt(content));
        } else if (qName.equals("price")) {
            book.setPrice(Double.parseDouble(content));
        } else if (qName.equals("book")) { // 当结束当前book解析时,将该book添加到数组后置为空，方便下一次book赋值
            list.add(book);
        }

    }

    /**
     * 此方法用来获取节点的值
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        content = new String(ch, start, length);
        if (content.trim().equals("") || content.equals(System.lineSeparator())) {

        } else {
            System.out.println(content);
        }
    }

    public List<Book> getBooks() {
        return list;
    }
}
