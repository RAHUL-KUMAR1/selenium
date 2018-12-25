package filehandling;
import java.io.FileWriter;
import java.io.IOException;

public class filewriter {

	public static void main(String[] args) throws IOException {
	FileWriter f=new FileWriter("C:\\Users\\PREETY KUMARI\\Desktop\\detox\\java.txt");
    f.write("java is easy"+"\r\n");
    f.write("java is magicaly");
    f.flush();
    f.close();
	}

}

