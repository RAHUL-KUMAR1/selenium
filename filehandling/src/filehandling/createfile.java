package filehandling;
import java.io.File;
import java.io.IOException;

public class createfile {
	public static void main(String[] args) throws IOException {
		
		File f=new File("C:\\Users\\PREETY KUMARI\\Desktop\\filehandling\\java.text");
		if(f.exists()) {
			System.out.println("not");
		}
		else {
			System.out.println("creat");
		}
		f.createNewFile();
	}

}
