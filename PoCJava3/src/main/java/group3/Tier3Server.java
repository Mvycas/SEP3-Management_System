package group3;

import group3.model.Employee;
import group3.model.ObjectTransfer;
import group3.repository.IEmployeeRepository;
import group3.util.BeanUtility;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

public class Tier3Server implements Runnable{
    @Override
    public void run()
    {
        System.out.println("\nWaiting for client connection ...\n");
        ServerSocket server = null;

        try {

            server = new ServerSocket(6789);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected");
                ClientHandler c = new ClientHandler(socket);
                Thread t = new Thread(c);
                System.out.println("Thread: " + t);
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
