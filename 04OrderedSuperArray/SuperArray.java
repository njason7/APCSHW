public class SuperArray{
    public String[] data;
    public int stored;

    public SuperArray(){
	data = new String[10];
	stored = 0;
    }

    public SuperArray(int capacity){
	data = new String[capacity];
	stored = 0;
    }

    public String toString(){
	String result = "[ ";
	for (int i = 0;i < data.length;i++){
	    result = result + data[i] + " ";
	}
	result += "]";
	return result;
    }

    public void add(String e){
	if (data[stored] == null){
	    data[stored] = e;
	    stored++;
	}else{
	    String[] result = new String[data.length + 1];
	    for (int i = 0;i<data.length;i++){
		result[i] = data[i];
	    }
	    result[stored] = e;
	    data = result;
	    stored++;
	}
    }
    
    public void add(int index, String o){
	if (data[index] == null){
	    data[index] = o;
	    stored++;
	}else if (data[data.length-1] != null){
	    String[] result = new String[data.length + 1];
	    int i = 0;
	    while (i<index){
		result[i] = data[i];
		i++;
	    }
	    result[i] = o;
	    while (i<data.length){
		result[i+1] = data[i];
		i++;
	    }
	    data = result;
	    stored++;
	}else{
	    String[] result = new String[data.length];
	    int i = 0;
	    while (i<index){
		result[i] = data[i];
		i++;
	    }
	    result[i] = o;
	    while (i<data.length-1){
		result[i+1] = data[i];
		i++;
	    }
	    data = result;
	    stored++;
	}
    }
    
    public boolean OutOfRange(int ind){
	return (ind <  0 || ind >= size());
    }
    
    public String get(int index){
	if (OutOfRange(index)){
	    throw new IndexOutOfBoundsException();
	}
	return data[index];
    }
    
    
    public int size(){
	int count = 0;
	for (int i = 0;i<data.length;i++){
	    if (data[i] != null){
		count++;
	    }
	}
	return count;
    }
    
    public void resize(int newCapacity){
	if (newCapacity > data.length){
	String[]result = new String[newCapacity];
	for (int i = 0;i<data.length;i++){
	    result[i] = data[i];
	}
	data = result;
	}
    }

    public String set(int index, String o){
	if (OutOfRange(index)){
	    throw new IndexOutOfBoundsException();
	}
	String save = data[index];
	data[index] = o;
	return save;
    }

    public String remove(int index){
	if(OutOfRange(index)){
	    throw new IndexOutOfBoundsException(); 
	}
	String save = data[index];
	String[] result = new String[data.length];
	int i = 0;
	while (i<index){
	    result[i] = data[i];
	    i++;
	}
	while (i+1<data.length){
	    result[i] = data[i+1];
	    i++;
	}
	data = result;
	stored--;
	return save;
    }

    public void insertionSort(){
	int i = 1;
	while (i<data.length){
	    if (data[i].compareTo(data[0]) < 0){
		this.add(0,this.remove(i));
	    }
	    for (int j = i;j>0;j--){
		if (data[i].compareTo(data[i-j]) > 0 && data[i].compareTo(data[i-j+1]) < 0){
		    this.add((i-j),this.remove(i));
		}
	    }
	    i++;
	}
    }

    public void badInsertionSort(){
        OrderedSuperArray c = new OrderedSuperArray();
        while( this.size() > 0){ 
            c.add(this.remove(0));
        }
        while(c.size() > 0){
            this.add(c.remove(0));
        }
    }
    
    public static void main(String[]args){
	SuperArray test = new SuperArray(4);
	System.out.println(test);
	test.add("e");
	//System.out.println(test);
	//test.resize(9);
	//System.out.println(test);
	test.add(0,"a");
	//System.out.println(test);
	try{
	System.out.println(test.get(0));
	//System.out.println(test.get(11));
	System.out.println(test.set(0,"u"));
	System.out.println(test);
	System.out.println(test.size());
	//System.out.println(test.set(11,"u"));	
	System.out.println(test.remove(0));
	System.out.println(test);
	System.out.println(test.size());
	//System.out.println(test.remove(11));
	}
	catch (IndexOutOfBoundsException e){
	    System.out.println("ERROR. INDEX OUT OF BOUNDS.");
	}
	SuperArray test2 = new SuperArray(4);
	for (int i=0;i<20;i++){
	    test2.add(""+i);
	}
	System.out.println(test2);
	long startTime = System.nanoTime();
	test2.insertionSort();
	long endTime = System.nanoTime();
	long duration = endTime - startTime;
	System.out.println(test2);
	System.out.println(duration);
	SuperArray test3 = new SuperArray(4);
	for (int i=0;i<20;i++){
	    test3.add(""+i);
	}
	long startTime2 = System.nanoTime();
	test2.insertionSort();
	long endTime2 = System.nanoTime();
	long duration2 = endTime2 - startTime2;
	System.out.println(test2);
	System.out.println(duration2);
    }
}
