package test.bluext.interview.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;

/**
 * Description：
 *
 * @author : xutao
 *         Created_Date : 2018-05-03 9:15
 */
public class UDPTestServer {

    public static void main(String[] args) {
        DatagramSocket serverSocket = null;
        try {
            InetAddress address = Inet4Address.getByName("127.0.0.1");
            serverSocket = new DatagramSocket(8888, address);

            byte[] buffer = new byte[2048];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            while (true) {
                serverSocket.receive(packet);

                String msg = new String(packet.getData(), 0, packet.getLength());
                System.out.println("收到信息: " + msg);

                String respMsg = msg.toUpperCase();
                byte[] respByte = respMsg.getBytes();
                DatagramPacket respPacket = new DatagramPacket(respByte, respByte.length, packet.getAddress(), packet.getPort());

                serverSocket.send(respPacket);
                System.out.println("已发送回复信息");
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }


    }

}
