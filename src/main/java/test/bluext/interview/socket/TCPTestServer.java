package test.bluext.interview.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description：
 *
 * @author : xutao
 *         Created_Date : 2018-05-02 14:29
 */
public class TCPTestServer {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9999);

        Thread.currentThread().sleep(20000L);
        while (true) {
            System.out.println("服务端状态就绪");
            Socket socket = serverSocket.accept();
            try (InputStream in = socket.getInputStream()) {
                byte[] buffer = new byte[2048];
                int length;
                StringBuilder sb = new StringBuilder();
                while ((length = in.read(buffer)) != -1) { // 只有当客户端关闭它的输出流的时候，服务端才能取得结尾的-1
                    sb.append(new String(buffer, 0, length, "UTF-8"));
                }

                System.out.print("客户端消息: ");
                System.out.println(sb.toString());

                OutputStream out = socket.getOutputStream();
                out.write("已收到".getBytes("UTF-8"));
                socket.shutdownOutput();

                System.out.println();
            }

            socket.close();
        }

    }

}
