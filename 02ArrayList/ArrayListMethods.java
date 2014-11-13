import java.util.*;
public class ArrayListMethods{
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
	randomize(l);
    }

    public static void randomize(ArrayList<Integer> l){
	Random r = new Random();
	for (int i = 0;i<l.size();i++){
	    int num = r.nextInt(l.size());
	    int save = l.get(i);
	    l.set(i,l.get(num));
	    l.set(num,save);
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
	ArrayList<Integer> test2 = new ArrayList<Integer>();
	for (int i = 0;i<10;i++){
	    test2.add(i);
	}
	System.out.println(test2);
	randomize(test2);
	System.out.println(test2);
    }
}
