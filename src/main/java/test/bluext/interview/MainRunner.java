package test.bluext.interview;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description：测试面试题
 *
 * @author : xutao
 *         Created_Date : 2018-04-17 9:11
 */
public class MainRunner {

    public static void main(String[] args) {
//        面试题: short s1 = 1; s1 = s1 + 1;有错吗?short s1 = 1; s1 += 1;有错吗？
//        short s1 = 1;
//        s1 = s1 + 1;
//        short s2 = 1;
//        s2 += 1;
//        byte i = 1;
//        i += 259;
//        System.out.println(i);

//        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
//        System.out.println(f1 == f2);// Integer内部有缓存-128~127 包括所有整形包装类型都有
//        System.out.println(f3 == f4);// 不走缓存 , 相当于调用Integer.valueOf()创建新对象 , 引用值不同

//        Double的自动拆装箱
//        Double b = 0.5;

//        Byte的自动拆装箱
//        Byte b = 1;

//        Short的自动拆装箱
//        Short i = 1;

//        Integer的自动拆装箱
//        Integer i = 0;
//        System.out.println(Integer.valueOf("a"));

//        Long的自动拆装箱
//        Long l = 1L;
//        整数型包装类都存在-128~127的缓存对象

//        测试异或运算
//        int i = 1 ^ 3;
//        System.out.println(i);
//        int j = 8 ^ 5;
//        System.out.println(j);
//        测试 b ^ (b ^ c) = b
//        int i = 7, j = 9;
//        System.out.println(i ^ j);
//        i = i ^ j;// 此时相当于将i和j的值同时储存起来 , 只需要利用b^a^a=b的特性取出原数即可
//        System.out.println(j ^ i);
//        j = j ^ i;
//        System.out.println(i ^ j);
//        i = i ^ j;
//        System.out.println("i:" + i + " j:" + j);
//        利用异或计算绝对值
//        右移31位实际是将每一位转换成原数字的符号位 , 利用异或符号位取得原数中的有效位数 , 再减去右移31位的数
//        此数在原数为正数时为0 , 为负数时为-1 , 正好补足了负数异或完后缺1的情况 , 并且不会对正数产生影响
//        int a = -3;
//        int b = (a ^ (a >> 31)) - (a >> 31);
//        System.out.println(b);

//        使用异或实现原始值1在0和1之间切换
//        int i = 1;
//        System.out.println(i = i ^ 1);
//        System.out.println(i = i ^ 1);
//        System.out.println(i = i ^ 1);
//        int j = 3;
//        System.out.println(j = j ^ 3);
//        System.out.println(j = j ^ 3);
//        System.out.println(j = j ^ 3);
//        int k = 9;
//        System.out.println(k = k ^ 9);
//        System.out.println(k = k ^ 9);
//        System.out.println(k = k ^ 9);
//        一个数异或自己结果为0 , 一个数异或0结果为自己

//        测试与运算
//        System.out.println(3 & 2);

//        测试或运算
//        System.out.println(2 | 1);

//        测试非运算
//        System.out.println(~3);

//        测试左移<<运算 , 相当于乘以2的移动位数次方
//        System.out.println(2 << 3);
//        System.out.println(1 << -1);
//        System.out.println(1 >> 1);
//        System.out.println(Integer.toBinaryString(1 << -1));
//        System.out.println(Integer.toBinaryString(1 >> 1));
//        System.out.println(15 << 64);
//        System.out.println(97 << 2);
//        System.out.println('a' << 2);
//        byte b = 2;
//        System.out.println(b << 16);

//        测试右移>>运算
//        System.out.println(6 >> 2);// 1
//        System.out.println(6 >> 1);// 3

//        无符号右移测试
//        int i = 8 >>> 3;
//        System.out.println(i);// 1
//        int j = 1 >>> 3;
//        System.out.println(j);// 0
//        int k = 16 >>> 3;
//        System.out.println(k);// 2
//        System.out.println(Integer.toBinaryString(-1 >>> 1));
//        System.out.println(-1 >>> 1);
//        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
//        System.out.println(-1 >>> 1);
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(-6 >>> 1);
//        System.out.println(new BigDecimal(2).pow(31).subtract(new BigDecimal(1)));
//        System.out.println(Integer.toBinaryString(-6 >>> 1));// 1111 1111 1111 1111 1111 1111 1111 101
//        byte b = 1;
//        System.out.println(b >>> 31);

//        位运算的优先级 ~的优先级最高，其次是<<、>>和>>>，再次是&，然后是^，优先级最低的是|
//        System.out.println(2 << 3 & 1);
//        System.out.println(2 << (3 & 1));
//        System.out.println(2 << 3 << 3);
//        System.out.println(2 << 3 >>> 3);
//        System.out.println(3 | 4 ^ 3 & 2);

//        8进制 16进制测试
//        int i8 = 010;
//        int i8_2 = -010;
//        System.out.println(i8);
//        System.out.println(i8_2);
//        int i16 = 0xAF;
//        int i16_2 = -0xAF;
//        System.out.println(i16);
//        System.out.println(i16_2);

//        switch java7支持byte,short,int,char,enum,String 及 对应包装类型, 不支持long
//        switch (1L) {
//            case 1L:
//                System.out.println("1L");
//            default:
//                System.out.println("default");
//        }

//        跳出多重循环
//        int k = 0;
//        int l = 0;
//        first:
//        for (int i = 0; i < 10; i++) {
//            l++;
//            second:
//            for (int j = 0; j < 10; j++) {
//                k++;
//                if (k == 3) {
//                    break second;
//                }
//            }
//        }
//        System.out.println("k:" + k + "  l:" + l);

//        字符串常量测试
//        String str1 = "abc";
//        String str2 = "abc";
//        String str3 = new String("abc");
//        System.out.println(str1 == str2);
//        System.out.println(str1 == str3);
//        String s1 = "Programming";
//        String s2 = new String("Programming");
//        String s3 = "Program" + "ming";
//        System.out.println(s1 == s2);
//        System.out.println(s1 == s3);
//        System.out.println(s1 == s1.intern());
//        StringBuffer sb = new StringBuffer("a");
//        sb.append("b").append("c").append("d").append("e");
//        String b = sb.toString();
//        b.intern();
//        String a = "abcde";
//        System.out.println(a == sb.toString());
//        System.out.println(a == b);// 因为b.intern()调用时 , 将b的引用作为"abcde"值的引用加入到了字符串常量池的哈希表中 , 所以下面新建a变量时 , 直接从常量池取了b的引用
//        System.out.println(a == b.intern());
//        String s1 = new String("aaa") + new String("bbb");
//        String s3 = s1;
//        String s2 = "aaabbb";
//        s1.intern();
//        System.out.println(s1 == s2);
//        System.out.println(s3 == s2);
//        System.out.println(s3 == s1);
//        String str1 = new String("abc");
//        String str1 = "a" + "b" + "c";
//        str1.intern();
//        String str2 = "abc";
//        System.out.println(str1 == str2);

//        字符串+运算和StringBuilder/StringBuffer性能对比
//        String a = "a";
//        String appendStr = "append";
//        a = a + appendStr;
//        a = a + appendStr;
//        a = a + appendStr;
//        for (int i = 0; i < 100; i++) {
//            a += appendStr;
//        }

//        equals()和hashCode()
//        equals()比较两个对象是否相等 , 可以重写来加入对象关键属性的对比
//        如果equals()相等 , 那么hashCode()也应该相等 , 当然你可以任性得定义为不等 , 但是当这个对象使用哈希表如HashSet HashMap等容器时 , 将出错
//        因为哈希表先计算哈希值 , 判断此对象在表中的位置 , 如果该位置有对象存在 , 则调用equals()来判断是否为同一对象 , 如果是同一对象 , 则不存储 , 否则采用链表方式存储
//        Object obj = null;
//        String str = null;

//        问题: char能不能放入一个中文 , char大小为2字节 , 引申:byte-1字节 short-2字节 int-4字节 long-8字节 char-2字节 double-8字节 float-4字节 boolean-由虚拟机决定 jvm规范中规定boolean按int处理 , boolean数组按byte数组处理
//        char i = '好';
//        System.out.println(i);
//        System.out.println(i + 1 - 1);

//        问题: +=的实质 , 带强转 , 超出位数截断
//        short i = 127;
//        int k = 127;
//        int j = 1280000000;
//        i += j;
//        k += j;
//        System.out.println(k);
//        System.out.println(Integer.toBinaryString(k));
//        System.out.println(i);

//        接口特性测试
//        接口中的成员变量必须是final修饰的类变量
//        System.out.println(InterfaceTest.i);
//        System.out.println(InterfaceTestImpl.i);
//        new InterfaceTestImpl().test();

//        java文件中包含多个class定义
//        PrivateClass privateClass = new PrivateClass();
//        System.out.println(privateClass.i);

//        匿名内部类
//        Thread t1 = new Thread(() -> System.out.println("run"));

//        面试题: 反转字符串
//        System.out.println(reverse("abcdefg"));

//        日期操作
//        LocalDateTime localDateTime = LocalDateTime.parse("2018-04-17T01:02:03");
//        System.out.println(localDateTime.getYear());
//        System.out.println(localDateTime.getMonthValue());
//        System.out.println(localDateTime.getDayOfMonth());
//        System.out.println(localDateTime.getHour());
//        System.out.println(localDateTime.getMinute());
//        System.out.println(localDateTime.getSecond());
//        Calendar time = Calendar.getInstance();
//        time.set(Calendar.MONTH, 1);
//        System.out.println(time.getActualMaximum(Calendar.DAY_OF_MONTH));
//        System.out.println(time.getActualMinimum(Calendar.DAY_OF_MONTH));

//        测试断言 JVM需包含参数 -ea 或者 -enableassertions 来开启断言
//        int i = 1;
//        assert i == 0 : "i包含错误值";

//        测试finally
//        System.out.println(testFinally());

//        探究Set List实现
//        Set set = new HashSet();
//        List list = new ArrayList<>();

//        集合测试
//        HashSet set = new HashSet();
//        set.add(123);
//        System.out.println(set);
//        TreeSet的存储元素必须实现Comparable接口
//        TreeSet treeSet = new TreeSet();
//        treeSet.add(new Object());
//        System.out.println(treeSet);// 运行报错 , 强制转换为Comparable失败
//        treeSet.add(new TreeSetTest("a123"));
//        treeSet.add(new TreeSetTest("c123"));
//        treeSet.add(new TreeSetTest("b123"));
//        System.out.println(JSON.toJSONString(treeSet));

//        测试引用
//        String a = "a";
//        String b = a;
//        a = null;
//        System.out.println(b);

//        测试JAVA8新日期操作API
//        Instant instant = Instant.now();
//        LocalDateTime localDateTime = LocalDateTime.now();

//        测试异常
//        try {
//            try {
//                throw new ChildException();
//            } catch (ParentException c) {
//                System.out.println("ParentException");
//                throw c;
//            }
//        } catch (ChildException p) {
//            System.out.println("ChildException");
//        } catch (Exception e) {
//            System.out.println("Exception");
//        }

//        测试双向链表
//        LinkedList linkedList = new LinkedList();

        //URL-API
//        try {
//            URL baidu = new URL("http://www.baidu.com");
//            URL url = new URL(baidu, "/index.html?username=tom#test");//？表示参数，#表示锚点
//            System.out.println(url.getProtocol());//获取协议
//            System.out.println(url.getHost());//获取主机
//            System.out.println(url.getPort());//如果没有指定端口号，根据协议不同使用默认端口。此时getPort()方法的返回值为 -1
//            System.out.println(url.getPath());//获取文件路径
//            System.out.println(url.getFile());//文件名，包括文件路径+参数
//            System.out.println(url.getRef());//相对路径，就是锚点，即#号后面的内容
//            System.out.println(url.getQuery());//查询字符串，即参数
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        非正确执行时间点 , requestInfo->{"account":"18270994890","activeTime":1524215348000,"createdTime":1524215314000,"customerId":0,"delayArr":"1,3,6,30,60,90","finishArr":"","id":143202,"isDeleted":false,"scene":"register","updatedTime":1524215314000} now->2018-05-01
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(1524098242000L)));
    }

    // 递归反转字符串
    public static String reverse(String originStr) {
        if (originStr == null || originStr.length() <= 1)
            return originStr;
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }

    public static int testFinally() {
        int i = 1;
        try {
            System.out.println("ready to return");
            return i;
        } finally {
            i++;
            System.out.println("finally");
        }
    }
}

class ParentException extends Exception {
}

class ChildException extends ParentException {
}