import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class WordGrid{
    private char[][]data;

    /**Initialize the grid to the size specified and fill all of the positions
     *with spaces.
     *@param row is the starting height of the WordGrid
     *@param col is the starting width of the WordGrid
     */
    public WordGrid(int rows,int cols){
	data = new char[rows][cols];
	clear();
    }
    
    /**Set all values in the WordGrid to spaces ' '*/
    private void clear(){
	for (int r = 0;r<data.length;r++){
	    for (int c = 0;c<data[r].length;c++){
		data[r][c] = ' ';
	    }
	}
    }

    /**The proper formatting for a WordGrid is created in the toString.
     *@return a String with each character separated by spaces, and each row
     *separated by newlines.
     */
    public String toString(){
	String result = "";
	for (int r = 0;r<data.length;r++){
	    for (int c = 0;c<data[r].length;c++){
		result += data[r][c]+" ";
	    }
	    result +="\n";
	}
	return result;
    }

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */
    public boolean addWordHorizontal(String word,int row, int col){
	if (word.length()<=data[row].length-col){
	    boolean test = true;
	    for (int i = 0;i<word.length();i++){
		if (data[row][col+i] == ' ' || data[row][col+i] == word.charAt(i)){
		   test = test && true;
		}else{
		    test = false;
		}
	    }
	    if (test){
		for (int i = 0;i<word.length();i++){
		    data[row][col+i] = word.charAt(i);
		}
		return true;
	    }
	    return false;
	}else if (col+1>=word.length()){
	    boolean test = true;
	    for (int i = 0;i<word.length();i++){
		if (data[row][col-i] == word.charAt(i) || data[row][col-i] == ' '){
		    test = test && true;
		}else{
		    test = false;
		}
	    }
	    if (test){
		for (int i = 0;i<word.length();i++){
		    data[row][col-i] = word.charAt(i);
		}
		return true;
	    }
	}
	return false;
    }
    

    public boolean addWordVertical(String word,int row, int col){
	if (word.length()<=data.length-row){
	    boolean test = true;
	    for (int i = 0;i<word.length();i++){
		if (data[row+i][col] == ' ' || data[row+i][col] == word.charAt(i)){
		   test = test && true;
		}else{
		    test = false;
		}
	    }
	    if (test){
		for (int i = 0;i<word.length();i++){
		    data[row+i][col] = word.charAt(i);
		}
		return true;
	    }
	    return false;
	}else if (row+1>=word.length()){
	    boolean test = true;
	    for (int i = 0;i<word.length();i++){
		if (data[row-i][col] == word.charAt(i) || data[row-i][col] == ' '){
		    test = test && true;
		}else{
		    test = false;
		}
	    }
	    if (test){
		for (int i = 0;i<word.length();i++){
		    data[row-i][col] = word.charAt(i);
		}
		return true;
	    }
	}
	    return false;
    }

    public boolean addWordDiagonal(String word,int row, int col){
	if (word.length()<=data[row].length-col && word.length()<=data.length-row){
	    boolean test = true;
	    for (int i = 0;i<word.length();i++){
		if (data[row+i][col+i] == ' ' || data[row+i][col+i] == word.charAt(i)){
		   test = test && true;
		}else{
		    test = false;
		}
	    }
	    if (test){
		for (int i = 0;i<word.length();i++){
		    data[row+i][col+i] = word.charAt(i);
		}
		return true;
	    }
	    return false;
	}else if (col+1>=word.length() && row+1>=word.length()){
	    boolean test = true;
	    for (int i = 0;i<word.length();i++){
		if (data[row-i][col-i] == word.charAt(i) || data[row-i][col-i] == ' '){
		    test = test && true;
		}else{
		    test = false;
		}
	    }
	    if (test){
		for (int i = 0;i<word.length();i++){
		    data[row-i][col-i] = word.charAt(i);
		}
		return true;
	    }
	}
	return false;
    }

    private int getLength(){
	return data.length;
    }
    
    private int getLength(int i){
	return data[i].length;
    }

    private char getChar(int i, int j){
	return data[i][j];
    }
    
    public static void main (String[]args) throws FileNotFoundException{
	WordGrid test = new WordGrid(10,10);
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
	int count = 0;
	for (int z = 0;z<textlist.size();z++){
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
	}
	System.out.println(test);
    }
}
