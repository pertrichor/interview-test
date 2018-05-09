package test.bluext.interview.collection;

import lombok.Getter;
import lombok.Setter;

/**
 * Description：测试treeSet
 *
 * @author : xutao
 *         Created_Date : 2018-04-19 9:43
 */
@Setter
@Getter
public class TreeSetTest implements Comparable<TreeSetTest> {
    private String name;

    public TreeSetTest(String name) {
        this.name = name;
    }

    public int compareTo(TreeSetTest o) {
        return this.getName().charAt(0) - o.getName().charAt(0);
    }
}
