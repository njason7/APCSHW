public class SuperArray{
    private Object[] data;
    private int stored;

    public SuperArray(){
	data = new Object[10];
	stored = 0;
    }

    public SuperArray(int capacity){
	data = new Object[capacity];
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

    public void add(Object e){
	if (data[data.length - 1] == null){
	    data[stored] = e;
	    stored++;
	}else{
	    Object[] result = new Object[data.length + 1];
	    for (int i = 0;i<data.length;i++){
		result[i] = data[i];
	    }
	    result[data.length] = e;
	    data = result;
	    stored++;
	}
    }
    
    public void add(int index, Object o){
	if (data[index] == null){
	    data[index] = o;
	    stored++;
	}else if (data[data.length-1] != null){
	    Object[] result = new Object[data.length + 1];
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
	    Object[] result = new Object[data.length];
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
    
    public Object get(int index){
	if (!OutOfRange(index)){
	    return data[index];
	}else{
	    System.out.println("ERROR. INDEX OUT OF RANGE.");
	    return null;
	}
    }
    
    
    public int size(){
	return data.length;
    }
    
    public void resize(int newCapacity){
	if (newCapacity > data.length){
	Object[]result = new Object[newCapacity];
	for (int i = 0;i<data.length;i++){
	    result[i] = data[i];
	}
	data = result;
	}
    }

    public Object set(int index, Object o){
	if (!OutOfRange(index)){
	    Object save = data[index];
	    data[index] = o;
	    return save;
	}else{
	    System.out.println("ERROR. INDEX OUT OF RANGE.");
	    return null;
	}
    }

    public Object remove(int index){
	if(!OutOfRange(index)){
	    Object save = data[index];
	    Object[] result = new Object[data.length];
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
	}else{
	    System.out.println("ERROR. INDEX OUT OF RANGE.");
	    return null;
	}
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
	L.add(x);
	L.add(new Integer(99));
	System.out.println(L);
	test.add(0,"a");
	System.out.println(test);
	System.out.println(test.get(0));
	System.out.println(test.get(11));
	System.out.println(test.set(0,"u"));
	System.out.println(test);
	System.out.println(test.set(11,"u"));	
	System.out.println(test.remove(0));
	System.out.println(test);	
	System.out.println(test.remove(11));
    }
}
