import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class Driver{
    public static void main (String[]args) throws FileNotFoundException{
	WordGrid test = new WordGrid(15,15);
	File text = new File("WordList.txt");
	Scanner scan = new Scanner(text);
	ArrayList<String> textlist = new ArrayList<String>();
	while(scan.hasNextLine()){
	    String line = scan.nextLine();
	    textlist.add(line);
	}
	Random rd = new Random();
	Random rx = new Random();
	Random ry = new Random();
	Random rz = new Random();
	int count = 0;
	while (textlist.size()>0){
	    int z = rz.nextInt(textlist.size());
	    char[][] clone = new char[test.getLength()][test.getLength()];
	    for (int i = 0;i<test.getLength();i++){
		for (int j = 0;j<test.getLength(i);j++){
		    clone[i][j] = test.getChar(i,j);
		}
	    }
	    while (count < 10){
		int decision = rd.nextInt(3);
		int decy = ry.nextInt(test.getLength());
		int decx = rx.nextInt(test.getLength(decy));
		if (decision == 0){
		    if (test.addWordHorizontal(textlist.get(z),decy,decx)){
			break;
		    }else{
			count++;
		    }
		}else if (decision == 1){
		    if (test.addWordVertical(textlist.get(z),decy,decx)){
			break;
		    }else{
			count++;
		    }
		}else{
		    if (test.addWordDiagonal(textlist.get(z),decy,decx)){
			break;
		    }else{
			count++;
		    }
		}
	    }
	    textlist.remove(z);
	}
	System.out.println(test);
    }
}
