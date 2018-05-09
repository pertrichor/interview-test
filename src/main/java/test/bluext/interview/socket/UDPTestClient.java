package test.bluext.interview.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Description：
 *
 * @author : xutao
 *         Created_Date : 2018-05-03 9:15
 */
public class UDPTestClient {

    public static void main(String[] args) {
        DatagramSocket clientSocket = null;
        try {
            clientSocket = new DatagramSocket();

            String msg = "abcdefghijklmnopqrstuvwxyz";
            DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.getBytes().length, InetAddress.getByName("127.0.0.1"), 8888);
            clientSocket.send(packet);
            System.out.println("已发送消息");

            byte[] buffer = new byte[2048];
            DatagramPacket respPacket = new DatagramPacket(buffer, buffer.length);
            clientSocket.receive(respPacket);

            String respMsg = new String(respPacket.getData(), 0, respPacket.getLength());
            System.out.println("收到回信: " + respMsg);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (clientSocket != null) {
                clientSocket.close();
            }
        }
    }

}
