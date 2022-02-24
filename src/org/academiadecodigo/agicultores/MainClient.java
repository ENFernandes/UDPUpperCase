package org.academiadecodigo.agicultores;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class MainClient {
    public static void main(String[] args) throws IOException {
        String hostName = "localhost";
        int portNumber = 4042;
        String str = "Welcome to the magnificox";
        InetAddress ip = InetAddress.getByName(hostName);

        byte[] sendBuffer = new byte[1024];
        byte[] recvBuffer = new byte[1024];

        DatagramSocket socket = new DatagramSocket();

        DatagramPacket sendPacket = new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getByName(hostName), portNumber);
        socket.send(sendPacket);

        DatagramPacket receivePacket = new DatagramPacket(recvBuffer, recvBuffer.length);
        socket.receive(receivePacket);

        String s = new String(receivePacket.getData());
        System.out.println(s);

        socket.close();
    }

}
