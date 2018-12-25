package list;
import java.util.*;

public class size {

	public static void main(String[] args) {
		ArrayList a=new ArrayList();
         a.add("ram");
         a.add("rams");
	     a.add("rama");
	     a.add("ramz");
	     a.add("ramv");
	     ArrayList d=new ArrayList();
	     d.add("tram");
         d.add("yrams");
	     d.add("grama");
	     d.add("jramz");
	     d.add("kramv");
	     Collections.copy(a, d);
	     System.out.print(a);
	     System.out.println();
	     a.forEach(e -> System.out.print(e+","));
	     System.out.println();
	     for(Object f:a) 
	    	
	    	 System.out.print(f+" ");
	     
	     System.out.println();
List b=a.subList(1, 3);
System.out.println(b);

a.forEach(s -> System.out.print(s));
Collections.sort(a);
System.out.print(a);
}
}