import java.io.*;
import java.net.*;
import java.util.*;

public class Server
{
  private static Socket socket;
  public static void main(String[] args)
  {
    try
    {
      int port = 5000;
      ServerSocket serverSocket = new ServerSocket(port);
      System.out.println("Server Started and listening to the port 5000");

        //Reading the message from the client
        socket = serverSocket.accept();
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String input = br.readLine();
        System.out.println("Message received from client is "+input);
        String returnMessage;

        //Converting the received string to reverse and converting to upper case.
        StringBuilder input1 = new StringBuilder();
        input1.append(input);
        input1 = input1.reverse();
        String out = input1.toString();
        StringBuffer cap =  new StringBuffer(out);
        int ln = cap.length();

        //Changes the Capitalization.
        for (int i=0; i<ln; i++)
         {
            Character c = cap.charAt(i);
            if (Character.isLowerCase(c))
              cap.replace(i, i+1, Character.toUpperCase(c)+"");
            else
              cap.replace(i, i+1, Character.toLowerCase(c)+"");
         }
         returnMessage = cap.toString();
        OutputStream os = socket.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write(returnMessage);
        System.out.println("Message sent to the client is "+returnMessage);
        bw.flush();
    }

    //Catches input and output errors.
    catch (IOException e) {
      System.out.println("Error with sending/receiving");
    }

    finally
    {
      try
      {
        //SOcket Close
        socket.close();
      }
      catch(Exception e){}
    }
  }
}