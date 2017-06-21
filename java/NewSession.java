import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public class NewSession {
	public ServerSocket listener = null;
    public String line;
    public BufferedReader is;
    public BufferedWriter os;
    public Socket socketOfServer = null;
    public TreeNode root;
	public NewSession(){
		// create Socket connection
		try {
           	listener = new ServerSocket(1210);
       	} catch (IOException e) {
           	System.out.println(e);
           	System.exit(1);
       	}
       	// Create root node
       	ArrayList<TreeNode> nullNode
		ArrayList<TreeNode> gene1 = new ArrayList<TreeNode>();
		root = new TreeNode(gene1,"Xin chào, tôi giúp gì bạn?",0);
		// Begin add data
		gene1 = new ArrayList<TreeNode>();
		
		
	}
	public void aSession(){
	}
	
	public void run(){
		try {
           System.out.println("Server is waiting to accept user...");
 
 
           
           socketOfServer = listener.accept();
           System.out.println("Accept a client!");
 
      
           is = new BufferedReader(new InputStreamReader(socketOfServer.getInputStream()));
           os = new BufferedWriter(new OutputStreamWriter(socketOfServer.getOutputStream()));
 
    
           
           while (true) {
               
               line = is.readLine();
               System.out.println(line);
               //Call a session
               //aSession();


	            if (true){
					// *****************************************************************8
					os.write(">> Chao Ban, Ban can giup do gi: 1-Game 2-TinhCam  ");
			        os.newLine();
			        os.flush();
			        String firstOption = is.readLine();
			        System.out.println(firstOption);
					os.write(">> Ban vui long nhap ho ten.");
			        os.newLine();
			        os.flush();
			        String hoTen = is.readLine();
			        System.out.println(hoTen);
			        if (firstOption=="1\n" ||firstOption=="1" ||firstOption.contains("1")){
			        	// This is game supporting session.
			        	os.write(">> Ban gap van de o game gi: 1-VoLam 2-Gunny");
				        os.newLine();
			    	    os.flush();
			    	    String vanDeGame = is.readLine();
			    	    System.out.println(vanDeGame);
			    	 	os.write(">> Ban vui long mo ta game ban co.");
				        os.newLine();
			    	    os.flush();
			    	    String moTaVanDe = is.readLine();
			    	    System.out.println(moTaVanDe);
			    	    os.write(">> Cam on ban. Van de da duoc ghi lai, chung toi se giai quyet som.");
				        os.newLine();
			    	    os.flush();			    	    
			        }
			        else {
			        	// this is tinhCam supporting session.
			        	os.write(">> Ban Ke di, toi nghe.");
					    os.newLine();
			            os.flush();
			        	String xamlong = is.readLine();
			        	System.out.println(xamlong);
			        	os.write(">> Hay lam! dmm");
					    os.newLine();
			            os.flush();
			        	
			        }
	        		//**************************************************************************** 
		    	}

 
               
               if (line.equals("QUIT")) {
                   os.write(">> OK");
                   os.newLine();
                   os.flush();
                   break;
               }
           }
 
       } catch (IOException e) {
           System.out.println(e);
           e.printStackTrace();
       }
       System.out.println("Sever stopped!");
	}
}