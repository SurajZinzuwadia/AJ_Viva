import java.io.*;
import java.net.*;
import java.util.*;

public class Client
{

  private static Socket socket;

  public static void main(String args[])
  {
    try
    {
      String host = "localhost";
      int port = 5000;
      InetAddress address = InetAddress.getByName(host);

      //Creates a socket connection.
      socket = new Socket(address, port);
      OutputStream os = socket.getOutputStream();
      OutputStreamWriter osw = new OutputStreamWriter(os);

      //Creates a buffered writer object.
      BufferedWriter bw = new BufferedWriter(osw);
      String input = "network";
      String sendMessage = input + "\n";
      bw.write(sendMessage);
      bw.flush();
      System.out.println("Message sent to the server : "+sendMessage.trim());

      //Receiving message back from the server.
      InputStream is = socket.getInputStream();
      InputStreamReader isr = new InputStreamReader(is);
      BufferedReader br = new BufferedReader(isr);
      String message = br.readLine();

      //Printing the received message from the server.
      System.out.println("Message received from the server : " +message);

    }

    //Catches.
    catch (Exception exception)
    {
      exception.printStackTrace();
    }

    finally
    {
      try
      {
        // Socket Close
        socket.close();
      }
      catch(Exception e)
      {
        e.printStackTrace();
      }
    }
  }
}