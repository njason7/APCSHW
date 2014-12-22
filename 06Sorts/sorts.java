import java.util.*;
public class sorts{

    public static String name(){
	return "Ng,Jason";
    }
    
    public static int period(){
	return 7;
    }
    
    public static void bubble(int[]c){
	int end = 0;
	while (end < c.length){
	    for (int i = 0;i<c.length-1-end;i++){
		if (c[i] > c[i+1]){
		    int save = c[i];
		    c[i] = c[i+1];
		    c[i+1] = save;
		}
	    }
	    end++;
	}
    }
    public static void select(int[]c){
	for (int i =0;i<c.length-1;i++){
	    int index = i;
	    int min = c[i];
	    for (int j=1;i+j<c.length;j++){
		if (c[i+j]<min){
		    min = c[i+j];
		    index = i+j;
		}
	    }
	    c[index] = c[i];
	    c[i] = min;
	}
    }
    public static void insertion(int[]c){
	int i = 1;
	while (i<c.length){
	    if (c[i]<c[0]){
		int save = c[i];
		for (int k = 0;k < i;k++){
		    c[i-k] = c[i-k-1];
		}
		c[0] = save;
	    }
	    for (int j = i;j>0;j--){
		if (c[i]>c[i-j] && c[i]<c[i-j+1]){
		    int save = c[i];
		    for (int k = 0;k < j-1;k++){
			c[i-k] = c[i-k-1];
		    }
		    c[i-j+1] = save;
		}
	    }
	    i++;
	}
    }

    //Adds to every bucket for some reason and that causes the code to be messed up and doesn't work.
    public static void radix(int[]c){
	ArrayList<ArrayList<Integer>> bucket = new ArrayList<ArrayList<Integer>>(10);
	ArrayList<Integer> fill = new ArrayList<Integer>();
	for (int i = 0;i<10;i++){
	    bucket.add(fill);
	}
	ArrayList<Integer> result = new ArrayList<Integer>(c.length);
	int[] convert = new int[c.length];   
	int max = c[0];
	for (int i = 1;i<c.length;i++){
	    if (max < c[i]){
		max = c[i];
	    }
	}
	int count = 1;
	while (max/(Math.pow(10,count)) > 1){
	    count++;
	}
	for (int ex = 1;ex<=count;ex++){
	    for (int i = 0;i<c.length;i++){
		if (c[i]/(int)Math.pow(10,ex-1)%10 == 0){
		    bucket.get(0).add(c[i]);
		}else if (c[i]/(int)Math.pow(10,ex-1)%10 == 1){
		    bucket.get(1).add(c[i]);
		}else if (c[i]/(int)Math.pow(10,ex-1)%10 == 2){
		    bucket.get(2).add(c[i]);
		}else if (c[i]/(int)Math.pow(10,ex-1)%10 == 3){
		    bucket.get(3).add(c[i]);
		}else if (c[i]/(int)Math.pow(10,ex-1)%10 == 4){
		    bucket.get(4).add(c[i]);
		}else if (c[i]/(int)Math.pow(10,ex-1)%10 == 5){
		    bucket.get(5).add(c[i]);
		}else if (c[i]/(int)Math.pow(10,ex-1)%10 == 6){
		    bucket.get(6).add(c[i]);
		}else if (c[i]/(int)Math.pow(10,ex-1)%10 == 7){
		    bucket.get(7).add(c[i]);
		}else if (c[i]/(int)Math.pow(10,ex-1)%10 == 8){
		    bucket.get(8).add(c[i]);
		}else if (c[i]/(int)Math.pow(10,ex-1)%10 == 9){
		    bucket.get(9).add(c[i]);
		}
	    }
	    for (int i = 0;i<bucket.size();i++){
		for (int j = 0;j<bucket.get(i).size();j++){
		    result.add(bucket.get(i).get(j));
		}
	    }
	    for (int i = 0;i<c.length;i++){
		convert[i] = result.get(i);
	    }
	    c = convert;
	    result.clear();
	    for (int i = 0;i<bucket.size();i++){
		bucket.get(i).clear();
	    }
	}
    }
    public static void main(String[]args){
	int[] test = new int[10];
	test[0] = 403;
	test[1] = 222;
	test[2] = 4;
	test[3] = 13;
	test[4] = 1907;
	test[5] = 55555;
	test[6] = 21;
	test[7] = 42;
	test[8] = 100;
	test[9] = 1;
	String disp = "";
	for (int i = 0;i<test.length;i++){
	    disp += " "+ test[i];
	}
	System.out.println(disp);
	if (args[0].equals("bubble")){
	    bubble(test);
	    String disp2 = "";
	    for (int i = 0;i<test.length;i++){
		disp2 += " "+ test[i];
	    }
	    System.out.println(disp2);
	}else if (args[0].equals("select")){
	    select(test);
	    String disp2 = "";
	    for (int i = 0;i<test.length;i++){
		disp2 += " "+ test[i];
	    }
	    System.out.println(disp2);
	}else if (args[0].equals("insertion")){
	    insertion(test);
	    String disp2 = "";
	    for (int i = 0;i<test.length;i++){
		disp2 += " "+ test[i];
	    }
	    System.out.println(disp2);
	}else if (args[0].equals("radix")){
	    radix(test);
	    String disp2 = "";
	    for (int i = 0;i<test.length;i++){
		disp2 += " "+ test[i];
	    }
	    System.out.println(disp2);
	}
    }
}
