package test.bluext.interview;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Description：罗列文件
 *
 * @author : xutao
 *         Created_Date : 2018-04-26 14:49
 */
public class FileListTest {

    public static void main(String[] args) throws IOException {
        String filePath = "/Users/xutao/Desktop/blue_workspace/interview/target/classes/test/bluext";
        listFile(new File(filePath));
        System.out.println("-------------------------");
        recursiveListFile(new File(filePath), 0);
        System.out.println("-------------------------");
        listFileNIO(filePath);
    }

    public static void listFileNIO(String filePath) throws IOException {
        Path initPath = Paths.get(filePath);
        Files.walkFileTree(initPath, new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                    throws IOException {
                System.out.println(file.getFileName().toString());
                return FileVisitResult.CONTINUE;
            }

        });
    }

    public static void listFile(File file) {
        if (file == null || file.isFile()) {
            return;
        }

        File[] files = file.listFiles();
        if (files == null || files.length == 0) {
            return;
        }

        for (File _file : files) {
            if (_file.isFile()) {
                System.out.println(_file.getName());
            }
        }
    }

    public static void recursiveListFile(File file, int depth) {
        if (file == null) {
            return;
        }

        String prefix = "";
        int i = depth;
        while (i-- > 0) {
            prefix += "\t";
        }

        if (file.isFile()) {
            System.out.println(prefix + "|- " + file.getName());
        } else {
            File[] files = file.listFiles();
            if (files == null || files.length == 0) {
                return;
            }

            System.out.println(prefix + "|- [" + file.getName() + "]");

            for (File ele : files) {
                recursiveListFile(ele, depth + 1);
            }
        }
    }
}
