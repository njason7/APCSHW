import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class Driver{
    public static void main (String[]args) throws FileNotFoundException{
	if (args.length < 2 || args.length > 4){
	    System.out.println("Please input 2-4 arguments.");
	}else if (args.length == 2){
	    WordGrid test = new WordGrid(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
	    test.loadWordsFromFile("WordList.txt",true);
	    test.addWords();
	}else if (args.length == 3){
	    WordGrid test = new WordGrid(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Long.parseLong(args[2]));
	    test.loadWordsFromFile("WordList.txt",true);
	    test.addWords();
	}else{
	    if (args[3].equals("1")){
		WordGrid test = new WordGrid(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Long.parseLong(args[2]));
		test.loadWordsFromFile("WordList.txt",false);
		test.addWords();
	    }else{
		WordGrid test = new WordGrid(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Long.parseLong(args[2]));
		test.loadWordsFromFile("WordList.txt",true);
		test.addWords();
	    }
	}
    }
}
