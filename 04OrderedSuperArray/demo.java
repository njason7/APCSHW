import java.util.*;
public class demo{
    public static void main(String[]args){
	SuperArray test = new SuperArray(500000);
	for (int i = 0;i<500000;i++){
	    test.add(""+i);
	}
	if (args[0].equals("select")){
	    test.selectSort();
	}else if (args[0].equals("insert")){
	    test.insertionSort();
	}else if (args[0].equals("array")){
	    test.sort();
	}
    }
}