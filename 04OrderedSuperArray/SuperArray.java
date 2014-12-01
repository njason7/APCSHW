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
	return data.length;
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

    public static void main(String[]args){
	SuperArray test = new SuperArray(4);
	System.out.println(test);
	test.add("e");
	System.out.println(test);
	test.resize(9);
	System.out.println(test);
	Integer x = new Integer(5);
	SuperArray L = new SuperArray();
	L.add("x");
	L.add("99");
	System.out.println(L);
	test.add(0,"a");
	System.out.println(test);
	try{
	System.out.println(test.get(0));
	System.out.println(test.get(11));
	System.out.println(test.set(0,"u"));
	System.out.println(test);
	System.out.println(test.set(11,"u"));	
	System.out.println(test.remove(0));
	System.out.println(test);	
	System.out.println(test.remove(11));
	}
	catch (IndexOutOfBoundsException e){
	    System.out.println("ERROR. INDEX OUT OF BOUNDS.");
	}
    }
}
