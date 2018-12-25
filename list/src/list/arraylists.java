package list;
import java.util.*;

public class arraylists {
	public static void main(String[] args) {
		
		ArrayList a1=new ArrayList();
		   a1.add("rahul");
		    a1.add("sriharsha");
		    a1.add("shyam");
		    a1.add(1);
		System.out.println(a1);
		LinkedList a=new LinkedList();
		   a.add("rahul");
		    a.add("sriharsha");
		    a.add("shyam");
		    a.add(1);
		System.out.println(a);
		
		LinkedHashSet obj = new LinkedHashSet (
	    	    Arrays.asList("Boston", "Chicago", "Dallas"));
	    	       System.out.println("Elements are:"+obj);
	}

}
