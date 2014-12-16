public class sorts{
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
		    index  = i+j;
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

    public static void main(String[]args){
	int[] test = new int[5];
	test[0] = 4;
	test[1] = 2;
	test[2] = 0;
	test[3] = 3;
	test[4] = 1;
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
	}
    }
}
