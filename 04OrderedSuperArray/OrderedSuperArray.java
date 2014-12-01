public class OrderedSuperArray extends SuperArray{

    public OrderedSuperArray(){
	super();
    }
    
    public OrderedSuperArray(int capacity){
	super(capacity);
    }

    public int getProper(String e){
	for (int i = 0;i<data.length;i++){
	    if (e.compareTo(data[i]) > 0){
		return i;
	    }
	}
	return data.length-1;
    }
    
    public void add (String e){
	
    }	

    public static void main(String[]args){
	OrderedSuperArray test = new OrderedSuperArray();
	System.out.println(test);
    }
}