package org.academiadecodigo.agicultores;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Locale;

public class MainServer {
    public static void main(String[] args) throws IOException {
        //String hostName = "localhost";
        int portNumber = 4042;//Integer.parseInt(args[1]);
        //InetAddress ip = InetAddress.getByName(hostName);

        byte[] sendBuffer = new byte[1024];
        byte[] recvBuffer = new byte[1024];

        DatagramSocket socket = new DatagramSocket(portNumber);

        DatagramPacket receivePacket = new DatagramPacket(recvBuffer, recvBuffer.length);
        socket.receive(receivePacket);

        String s = new String(receivePacket.getData());
        System.out.println(s);
        s=s.toUpperCase();

        DatagramPacket sendPacket = new DatagramPacket(s.getBytes(), s.getBytes().length, receivePacket.getAddress(), receivePacket.getPort());
        socket.send(sendPacket);



        socket.close();
    }
}
