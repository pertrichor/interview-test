package test.bluext.interview;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Description：测试文件中字符串的出现次数
 *
 * @author : xutao
 *         Created_Date : 2018-04-26 14:24
 */
public class CheckStrCntTest {

    private CheckStrCntTest() {
        throw new AssertionError();
    }

    public static void main(String[] args) throws Exception {
        String source = "/Users/xutao/Desktop/blue_workspace/interview/target/classes/test/bluext/interview/input/test.txt";
        int cnt = checkCnt(source, "hello");
        System.out.println("统计: " + cnt);
    }

    private static int checkCnt(String fileName, String str) throws IOException {
        int cnt = 0;
        try (FileReader fileReader = new FileReader(fileName)) {
            try (BufferedReader br = new BufferedReader(fileReader)) {
                String line;
                while ((line = br.readLine()) != null) {
                    int index;
                    while (line.length() >= str.length() && (index = line.indexOf(str)) >= 0) {
                        cnt++;
                        line = line.substring(index + str.length());
                    }
                }
            }
        }
        return cnt;
    }
}
