package list;
import java.util.List;
import java.util.ArrayList;
public class list_program {

	public static void main(String[] args) {
		
		        ArrayList<Integer> l1 = new ArrayList<Integer>(); 
		        l1.add(0, 1); 
		        l1.add(1, 2);  
		        System.out.println(l1);  
		        List<Integer> l2 = new ArrayList<Integer>(); 
		        l2.add(1); 
		        l2.add(2); 
		        l2.add(3); 
		  
		        l1.addAll(1, l2); 
		        System.out.println(l1); 
		  
		        l1.remove(1);      
		        System.out.println(l1); 
		  
		        l1.set(0, 5);    
		        System.out.println(l1);  
		    } 
	{

	}

}

