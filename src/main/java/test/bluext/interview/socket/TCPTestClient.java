package test.bluext.interview.socket;

import java.io.*;
import java.net.Socket;

/**
 * Description：
 *
 * @author : xutao
 *         Created_Date : 2018-05-02 14:38
 */
public class TCPTestClient {

    public static void main(String[] args) throws IOException {

        int count = 100;
        while (count-- > 0) {
            try (Socket socket = new Socket("127.0.0.1", 9999)) {
                try (OutputStream out = socket.getOutputStream()) {
                    System.out.print("请输入发送内容: ");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    String msg = reader.readLine();
                    out.write(msg.getBytes("UTF-8"));
                    System.out.println("发送成功..");
                    socket.shutdownOutput();// 通过shutdownOutput通知服务器已经发送完数据，后续只能接受数据

                    InputStream in = socket.getInputStream();
                    byte[] buffer = new byte[1024];
                    int length;
                    StringBuilder sb = new StringBuilder();
                    while ((length = in.read(buffer)) != -1) {
                        sb.append(new String(buffer, 0, length, "UTF-8"));
                    }
                    System.out.println("服务端响应: " + sb.toString());

                    System.out.println();
                }
            }
        }
    }
}
