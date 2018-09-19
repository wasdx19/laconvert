/*
*
* created by Azatkhanov Ansar
* WaSDX  05.03.2018
*/

import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui extends JFrame{
  private JButton pushButton;
  private JButton pushButton1;
  private JButton pushButton2;
  private JTextArea text;
  private JTextArea text1;
  private JLabel label;
  private JLabel label1;

  public Gui(){
    setSize(635,500);
    setTitle("Laconverter");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

    JPanel panel=new JPanel();

    label=new JLabel("Enter your text:");
    label.setBounds(30,5,150,40);
    add(label);

    label1=new JLabel("Your text:");
    label1.setBounds(30,205,100,40);
    add(label1);

    text=new JTextArea(10,20);
    text.setLineWrap(true);
    text.setWrapStyleWord(true);
    add(text);

    text1=new JTextArea();
    text1.setLineWrap(true);
    text1.setWrapStyleWord(true);
    add(text1);

    JScrollPane scroll = new JScrollPane(text);
    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    scroll.setBounds(30, 50, 575, 155);
    getContentPane().add(scroll);

    JScrollPane scroll1 = new JScrollPane(text1);
    scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    scroll1.setBounds(30, 250, 575, 150);
    getContentPane().add(scroll1);

    pushButton=new JButton("Convert");
    pushButton.setBounds(30,415,100,40);
    add(pushButton);

    pushButton1=new JButton("EXIT");
		pushButton1.setBounds(505, 415, 100, 40);
		add(pushButton1);

    pushButton2=new JButton("Clear all");
		pushButton2.setBounds(150, 415, 100, 40);
		add(pushButton2);

    pushButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        String kiril[]={"а","ә","б","в","г","ғ","д","е","ж","з","и","й","к","қ",
                        "л","м","н","ң","о","ө","п","р","с","т","у","ұ","ү","ф",
                        "х","һ","ц","ч","ш","щ","ы","і","э","ю","я","ё",
                        "А","Ә","Б","В","Г","Ғ","Д","Е","Ж","З","И","Й","К","Қ",
                        "Л","М","Н","Ң","О","Ө","П","Р","С","Т","У","Ұ","Ү","Ф",
                        "Х","Һ","Ц","Ч","Ш","Щ","Ы","І","Э","Ю","Я","Ё"};
        String latin[]={"a","á","b","v","g","ǵ","d","e","j","z","ı","ı","k","q",
                        "l","m","n","ń","o","ó","p","r","s","t","ý","u","ú","f",
                        "kh","h","ts","ch","sh","shi","y","i","e","ıý","ıa","ё",
                        "A","Á","B","V","G","Ǵ","D","E","J","Z","I","I","K","Q",
                        "L","M","N","Ń","O","Ó","P","R","S","T","Ý","U","Ú","F",
                        "Kh","H","Ts","Ch","Sh","Shi","Y","I","E","Iý","Ia","Ё"};
        text1.setText(null);
        String txt=text.getText();

        for(int i=0; i<kiril.length; i++){
          if(txt.contains(kiril[i])){
            txt=txt.replaceAll(kiril[i],latin[i]);
          }
        }
        text1.append(txt);
      }
    });

    pushButton1.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        System.exit(0);
      }
    });

    pushButton2.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        text.setText(null);
        text1.setText(null);
      }
    });
  }
}
