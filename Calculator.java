import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

JFrame frame;
JTextField textfield;
JButton[] numberButtons = new JButton[10];
JButton[] functionButtons = new JButton[9];
JButton addButton, subButton, mulButton, divButton, modButton;
JButton decButton, equButton, delButton, clrButton;
JPanel panel;

	Font myFont = new Font("Ink Free", Font.BOLD,30);

	double num1=0,num2=0,result=0;
	char operator;

Calculator() {
		frame = new JFrame ("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 550);
		frame.setLayout(null);
		
		textfield = new JTextField();
		textfield.setBounds(50, 25, 350, 50);
		textfield.setFont(myFont);
		textfield.setEditable(false);
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		modButton = new JButton("%");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Del");
		clrButton = new JButton("AC");


			functionsButtons[0]= addButton;
			functionsButtons[1]= subButton;
			functionsButtons[2]= mulButton;
			functionsButtons[3]= divButton;
			functionsButtons[4]= modButton;
			functionsButtons[5]= decButton;
			functionsButtons[6]= equButton;
			functionsButtons[7]= delButton;
			functionsButtons[8]= clrButton;

for(int i=0; i<9; i++) {
	functionsButtons[i].addActionListener(this);
	functionsButtons[i].setFont(myFont);
	functionsButtons[i].setFocusable(false);
}

	for(int i=0; i<10; i++) {
		numberButtons[i] = new JButton(String.valueOf(i));
		numberButtons[i].addActionListener(this);
		numberButtons[i].setFont(myFont);
		numberButtons[i].setFocusable(false);
}

	delButton.setBounds(50, 430, 100, 50);		
	clrButton.setBounds(205, 430, 145, 50);

	panel = new JPanel();
	panel.setBounds(50, 100, 300, 300);
	panel.setLayout(new GridLayout(4, 4, 10, 10));
	panel.setBackground(Color.GRAY);

	panel.add(numberButtons[1]);
	panel.add(numberButtons[2]);
	panel.add(numberButtons[3]);
	panel.add(addButton);
	panel.add(numberButtons[4]);
	panel.add(numberButtons[5]);
	panel.add(numberButtons[6]);
	panel.add(subButton);
	panel.add(numberButtons[7]);
	panel.add(numberButtons[8]);
	panel.add(numberButtons[9]);
	panel.add(mulButton);
	panel.add(numberButtons[0]);
	panel.add(decButton);
	panel.add(equButton);
	panel.add(divButton);
	panel.add(modButton);

	frame.add(panel);
	frame.add(delButton);
	frame.add(clrButton);
	frame.add(textfield);
	frame.setVisible(true);
}
    
public static void main(String[] args) {

  	Calculator calc = new Calculator();
}

@Override
   public void actionPerformed(ActionEvent e) {
	for(int i=0; i<10; i++){
	  if(e.getSource() == numberButtons[i]) {
	     textfield.setText(textfield.getText().concat(String.valueOf(i)));
		}
  }

  	  if(e.getSource() == decButton) {
	     textfield.setText(textfield.getText().concat("."));
	}

	  if(e.getSource() == addButton) {
	     num1 = Double.parseDouble(textfield.getText());
	     operator = '+';
	     textfield.setText("");
	}

	  else if(e.getSource() == subButton) {
	     num1 = Double.parseDouble(textfield.getText());
	     operator = '-';
	     textfield.setText("");
	}

	  else if(e.getSource() == mulButton) {
	     num1 = Double.parseDouble(textfield.getText());
	     operator = '*';
	     textfield.setText("");
	}

	  else if(e.getSource() == divButton) {
	     num1 = Double.parseDouble(textfield.getText());
	     operator = '/';
	     textfield.setText("");
	}

	  else if(e.getSource() == modButton) {
	     num1 = Double.parseDouble(textfield.getText());
	     operator = '%';
	     textfield.setText("");
	}

	  if(e.getSource() == equButton) {
	     num2 = Double.parseDouble(textfield.getText());

	switch(operator) {
	   case '+':
	   result=num1 + num2;
	   break;

	   case '-':
	   result=num1 - num2;
	   break;

	   case '*':
	   result=num1 * num2;
	   break;

	   case '/':
      if (num2 == 0) {
      textfield.setText("Error");
      return;
      }
	   result=num1 / num2;
	   break;

	   case '%':
	   result=num1 % num2;
	   break;
	}

		textfield.setText(String.valueOf(result));
		num1=result;

	}

	  if(e.getSource() == clrButton) {
	   textfield.setText("");
	}

	  if(e.getSource() == delButton) {
	   String string = textfield.getText();
	  if(string! =null && !string.isEmpty()) {
	     textfield.setText(string.substring(0, string.length() -1));
       	 }
    }

     
      }

}
