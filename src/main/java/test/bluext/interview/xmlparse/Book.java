package test.bluext.interview.xmlparse;

import lombok.Getter;
import lombok.Setter;

/**
 * Description：book.xml对应实体类
 *
 * @author : xutao
 *         Created_Date : 2018-05-03 10:50
 */
@Setter
@Getter
public class Book {
    private int id;
    private String name;
    private String author;
    private int year;
    private double price;
}
