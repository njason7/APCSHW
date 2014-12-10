import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class GUICtoF extends JFrame implements ActionListener{
    private Container pane1,filler,button,show;
    private JButton convert,opposite;
    private JLabel display;
    private JTextField text;

    public GUICtoF(){
	this.setTitle("Celsius and Farenheit Converter");
        this.setSize(600,400);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane1 = this.getContentPane();
	pane1.setLayout(new GridLayout(3,1));

	text = new JTextField(10);
	convert = new JButton("Convert Celsius to Farenheit");
	opposite = new JButton("Convert Farenheit to Celsius.");
	display = new JLabel("",null,JLabel.CENTER);

	convert.setActionCommand("CtoF");
	convert.addActionListener(this);
	opposite.setActionCommand("FtoC");
	opposite.addActionListener(this);

	filler = new Container();
	filler.setLayout(new FlowLayout());
	filler.add(text);
	
	button = new Container();
	button.setLayout(new FlowLayout());
	button.add(opposite);
	button.add(convert);

	show = new Container();
	show.setLayout(new FlowLayout());
	show.add(display);

	pane1.add(filler);
	pane1.add(button);
	pane1.add(show);
    }

    public void actionPerformed(ActionEvent e){
	String action = e.getActionCommand();
	if (action.equals("CtoF")){
	    String s = text.getText();
	    int c = Integer.parseInt(s);
	    double r = 1.4;
	    r = r*c + 32;
	    display.setText(""+r);
	}
	if (action.equals("FtoC")){
	    String s = text.getText();
	    int c = Integer.parseInt(s);
	    double r = 5;
	    r = r/9;
	    r = (c-32)*r;
	    display.setText(""+r);
	}
    }

	public static void main(String[]args){
	    GUICtoF window = new GUICtoF();
	    window.setVisible(true);
	}

    }
	
