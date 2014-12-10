import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class GUICtoF extends JFrame implements ActionListener{
    private Container pane1,pane2,pane3;
    private JButton convert;
    private JLabel display;
    private JTextField text;
    private JCheckBox opposite;

    public GUICtoF(){
	this.setTitle("Celsius and Farenheit Converter");
        this.setSize(600,400);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	pane1 = this.getContentPane();
	pane2 = this.getContentPane();
	pane3 = this.getContentPane();
	pane1.setLayout(new GridLayout(2,1));
	pane2.setLayout(new FlowLayout());
	pane3.setLayout(new FlowLayout());
	pane1.add(pane2);
    }

    public void actionPerformed(ActionEvent e){

    }

    public static void main(String[]args){
	GUICtoF window = new GUICtoF();
	window.setVisible(true);
    }

}
	