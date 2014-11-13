import java.util.*;
public class collapse{
    public static void collapseDuplicates(ArrayList<Integer> l){
	int i = 0;
	while (i<l.size()-1){
	    while (i+1<l.size()){
		if (l.get(i) == l.get(i+1)){
		    l.remove(i);
		}else{
		    break;
		}
	    }
	    i++;
	}
    }

    public static void main(String[]args){
	ArrayList<Integer> test = new ArrayList<Integer>();
	test.add(1);
	test.add(3);
	test.add(3);
	test.add(4);
	test.add(4);
	test.add(4);
	test.add(2);
	test.add(2);
	test.add(2);
	test.add(9);
	test.add(9);
	System.out.println(test);
	collapseDuplicates(test);
	System.out.println(test);
    }
}
