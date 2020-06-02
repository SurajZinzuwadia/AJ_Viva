import java.io.IOException; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 
import java.util.Scanner; 

class Client 
{ 
	public static void main(String args[]) throws IOException 
	{ 
		//datagram socket
		DatagramSocket ds = new DatagramSocket(); 
		//ip and host name
		InetAddress ipAddress = InetAddress.getLocalHost(); 
		// creating null buffer
		byte buf[] = null;
		//scanning input
		Scanner sc = new Scanner(System.in);  
		String str = sc.nextLine();  
		buf = str.getBytes(); 
		//connecting packet
		DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ipAddress, 5000); 
		ds.send(DpSend);
		DatagramSocket ds1 = new DatagramSocket(2356); 
		byte[] receive = new byte[65535]; 
		DatagramPacket DpR = new DatagramPacket(receive, receive.length); 
		ds1.receive(DpR); 
		System.out.println("Server :-" + data(receive)); 
	} 

	public static StringBuilder data(byte[] a) 
    	{ 
        	if (a == null) 
          		return null; 
        	StringBuilder ret = new StringBuilder(); 
        	int i = 0; 
        	while (a[i] != 0) 
        	{ 
           		ret.append((char) a[i]); 
            		i++; 
        	} 
        	return ret; 
    	}
} 
