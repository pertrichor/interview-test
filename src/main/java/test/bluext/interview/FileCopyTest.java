package test.bluext.interview;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Description：测试文件流
 *
 * @author : xutao
 *         Created_Date : 2018-04-26 11:43
 */
public class FileCopyTest {

    public static void main(String[] args) throws IOException {
        String source = "/Users/xutao/Desktop/blue_workspace/interview/target/classes/test/bluext/interview/input/test.txt";
        String target = "/Users/xutao/Desktop/blue_workspace/interview/target/classes/test/bluext/interview/output/test.txt";

        fileCopy(source, target);
//        fileCopyNIO(source, target);
    }

    public static void fileCopy(String source, String target) throws IOException {
        try (InputStream in = new FileInputStream(source)) {
            try (OutputStream out = new FileOutputStream(target)) {
                byte[] buffer = new byte[4096];
                int bytesToRead;
                while ((bytesToRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesToRead);
                }
            }
        }
    }

    public static void fileCopyNIO(String source, String target) throws IOException {
        try (FileInputStream in = new FileInputStream(source)) {
            try (FileOutputStream out = new FileOutputStream(target)) {
                FileChannel inChannel = in.getChannel();
                FileChannel outChannel = out.getChannel();
                ByteBuffer buffer = ByteBuffer.allocate(4096);
                while (inChannel.read(buffer) != -1) {
                    buffer.flip();
                    outChannel.write(buffer);
                    buffer.clear();
                }
            }
        }
    }

}
