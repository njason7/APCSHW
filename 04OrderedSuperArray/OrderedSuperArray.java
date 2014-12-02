public class OrderedSuperArray extends SuperArray{

    public OrderedSuperArray(){
	super();
    }
    
    public OrderedSuperArray(int capacity){
	super(capacity);
    }

    public int getProper(String e){
	for (int i = 0;i<data.length;i++){
	    if (data[i] == null || e.compareTo(data[i]) < 0){
		return i;
	    }
	}
	return data.length-1;
    }
    
    public void add (String e){
	int index = getProper(e);
	super.add(index,e);
    }

    public void add(int index,String e){
	add(e);
    }
    
    public String set(int index,String o){
	String save = super.remove(index);
	super.add(o);
	return save;
    }

    public static void main(String[]args){
	OrderedSuperArray test = new OrderedSuperArray();
	test.add("jkl");
	test.add("abc");
	test.add("def");
	test.add("ghi");
	System.out.println(test);
	System.out.println(test.set(0,"mno"));
	System.out.println(test);
    }
}
