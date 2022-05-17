package group3;

import group3.model.Employee;
import group3.model.ObjectTransfer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

@Component
public class InitializeConnection
{

    ObjectOutputStream objectOutputStream;
    ObjectInputStream objectInputStream;
    Socket clientSocket;


    public InitializeConnection() throws IOException, ClassNotFoundException
    {

        //hello this is test

        InetAddress host = InetAddress.getLocalHost();

        //create a client socket and connect to the server
        clientSocket = new Socket(host.getHostAddress(), 6789);


        // create an object output and input stream so we can send an object through it and receive
        objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
        objectInputStream = new ObjectInputStream(clientSocket.getInputStream());

        System.out.println("obj out: " + objectOutputStream);
        System.out.println("obj in: " + objectInputStream);


        //System.out.println("Closing socket...");
        //TimeUnit.SECONDS.sleep(1);
        //close the socket on the client side
        //clientSocket.close();

    }

    public Object getReceivedObject(String command, Object object) throws IOException, ClassNotFoundException
    {

        System.out.println("Sent Command: " + command);
        System.out.println("Sent Object: " + object);
        ObjectTransfer objectTransfer = new ObjectTransfer(object, command);

        objectOutputStream.writeObject(objectTransfer);

        Object receivedObject = objectInputStream.readObject();

        System.out.println("Received: " + receivedObject);

        if (receivedObject instanceof ObjectTransfer)
        {
            command = ((ObjectTransfer) receivedObject).getCommand();
            object = ((ObjectTransfer) receivedObject).getObject();
        }

        return object;

    }
}
