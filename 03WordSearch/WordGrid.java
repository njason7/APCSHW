import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class WordGrid{
    private char[][]data;
    private ArrayList<String> textlist = new ArrayList<String>();
    Random rand = new Random();
    public ArrayList<String> addList = new ArrayList<String>();
    private boolean noanskey;

    /**Initialize the grid to the size specified and fill all of the positions
     *with spaces.
     *@param row is the starting height of the WordGrid
     *@param col is the starting width of the WordGrid
     */
    public WordGrid(int rows,int cols){
	data = new char[rows][cols];
	clear();
    }

    public WordGrid(int rows,int cols,long seed){
	data = new char[rows][cols];
	rand.setSeed(seed);
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

    public int getLength(){
	return data.length;
    }
    
    public int getLength(int i){
	return data[i].length;
    }

    public char getChar(int i, int j){
	return data[i][j];
    }
    
    public void setChar(int i,int j,char c){
	data[i][j] = c;
    }

    public void setSeed(long seed){
	rand.setSeed(seed);
    }
    
    public void setanskey(boolean anskey){
	noanskey = anskey;
    }

    public boolean getanskey(){
	return noanskey;
    }

    public void loadWordsFromFile(String fileName, boolean fillRandomLetters) throws FileNotFoundException{
	File text = new File(fileName);
	Scanner scan = new Scanner(text);
	while(scan.hasNextLine()){
	    String line = scan.nextLine();
	    textlist.add(line);
	}
	noanskey = fillRandomLetters;
    }

    public String wordsInPuzzle(){
	String result = "Find these words: \n";
	int i = 1;
	while (i-1<addList.size()){
	    String extra = "";
	    for (int j = 10;j>addList.get(i-1).length();j--){
		extra += " ";
	    }
	    result = result + addList.get(i-1) + extra;
	    if (i%4 == 0 && i>0){
		result += "\n";
	    }
	    i++;
	}
	return result;
    }

    public void fillInBlanks(){
	for (int i = 0;i<data.length;i++){
	    for (int j = 0;j<data[0].length;j++){
		if (data[i][j]==' '){
		    data[i][j] = (char)('A'+(int)(rand.nextInt(26)));
		}
	    }
	}
    }

    public void addWords(){
	int count = 0;
	WordGrid clone = new WordGrid(data.length,data[0].length);
	while (textlist.size()>0){
	    int z = rand.nextInt(textlist.size());
	    while (count < 10){
		int decision = rand.nextInt(3);
		int decy = rand.nextInt(this.getLength());
		int decx = rand.nextInt(this.getLength(decy));
		if (decision == 0){
		    if (this.addWordHorizontal(textlist.get(z),decy,decx)){
			addList.add(textlist.get(z));
			break;
		    }else{
			count++;
		    }
		}else if (decision == 1){
		    if (this.addWordVertical(textlist.get(z),decy,decx)){
			addList.add(textlist.get(z));
			break;
		    }else{
			count++;
		    }
		}else{
		    if (this.addWordDiagonal(textlist.get(z),decy,decx)){
			addList.add(textlist.get(z));
			break;
		    }else{
			count++;
		    }
		}
	    }
	    textlist.remove(z);
	    for (int i = 0;i<data.length;i++){
		for (int j = 0;j<data[0].length;j++){
		    clone.setChar(i,j,data[i][j]);
		}
	    }
	}
	if (!noanskey){
	    System.out.println(clone);
	}
	System.out.println(this.wordsInPuzzle());
	this.fillInBlanks();
	System.out.println(this);
    }
}
