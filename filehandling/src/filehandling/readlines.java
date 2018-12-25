package filehandling;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.Buffer;

public class readlines {

	public static void main(String[] args)throws IOException {
		
    FileReader f=new FileReader("C:\\Users\\PREETY KUMARI\\Desktop\\detox\\java.txt");
    BufferedReader f1=new BufferedReader(f);
    String read=f1.readLine();
    while(read!=null) {
    	System.out.println(read);
    	read=f1.readLine();
    	
    
    }
   
	}

}
