public class superArray{
    private Object[] data;
    private int stored;

    public superArray(){
	data = new Object[10];
	stored = 0;
    }

    public superArray(int capacity){
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
	data[stored] = e;
	stored++;
    }

    public int size(){
	return stored;
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

    public static void main(String[]args){
	superArray test = new superArray(4);
	System.out.println(test);
	test.add("e");
	System.out.println(test);
	test.resize(9);
	System.out.println(test);
	Integer x = new Integer(5);
	superArray L = new superArray();
	L.add(x);
	L.add(new Integer(99));
	System.out.println(L);
    }
}

/*	Object[] result = Object[data.length + 1];
	for (int i = 0;i<data.length;i++){
	    result[i] = data[i];
	}
	result[data.length] = e;
	data = result;
	stored++;
*/
