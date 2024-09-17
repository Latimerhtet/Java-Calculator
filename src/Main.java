import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Main implements ActionListener{

    // Creating Frame, Text fiend and buttons
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addBtn, subBtn, mulBtn, divBtn;
    JButton deciBtn, equBtn, delBtn, clrBtn, negBtn;

    // Creating panel
    JPanel panel;

    Font myFont = new Font("Ink Free",Font.BOLD,30);

    double num1=0,num2=0,result=0;
    char operator;

    Main(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50,30,300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addBtn = new JButton("+");
        subBtn = new JButton("-");
        mulBtn = new JButton("*");
        divBtn = new JButton("/");
        deciBtn = new JButton(".");
        equBtn = new JButton("=");
        delBtn = new JButton("Del");
        clrBtn = new JButton("Clear");
        negBtn = new JButton("(-)");
        functionButtons[0] = addBtn;
        functionButtons[1] = subBtn;
        functionButtons[2] = mulBtn;
        functionButtons[3] = divBtn;
        functionButtons[4] = deciBtn;
        functionButtons[5] = equBtn;
        functionButtons[6] = delBtn;
        functionButtons[7] = clrBtn;
        functionButtons[8] = negBtn;


        for(int i = 0; i <9 ; i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }
        for(int i = 0; i < 10; i++){
            numberButtons[i]= new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }
        negBtn.setBounds(50, 430, 100, 50);
        delBtn.setBounds(150, 430, 100, 50);
        clrBtn.setBounds(250, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300,300);
        panel.setLayout(new GridLayout(4,4,10, 10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addBtn);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subBtn);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulBtn);
        panel.add(divBtn);
        panel.add(deciBtn);
        panel.add(numberButtons[0]);
        panel.add(equBtn);
        panel.add(divBtn);



        frame.add(panel);
        frame.add(negBtn);
        frame.add(delBtn);
        frame.add(clrBtn);

        frame.add(textField);
        // making frame visible
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        Main calc = new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 10; i++){
            if(e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == deciBtn){
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource() == addBtn){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if(e.getSource() == subBtn){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if(e.getSource() == mulBtn){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if(e.getSource() == divBtn){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if(e.getSource() == equBtn){
            num2 = Double.parseDouble(textField.getText());
            if( operator != '\0' ){
                switch (operator){
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                }
                textField.setText(String.valueOf(result));
                num1 = result;
            }else{
                System.out.println("operator is undefined");
            }


        }
        if(e.getSource() == clrBtn){
            num1 = 0;
            num2 = 0;
            textField.setText("");
        }
        if(e.getSource() == delBtn){
            String string = textField.getText();
            textField.setText("");
            for(int i = 0; i < string.length()-1; i++){
                textField.setText(textField.getText()+string.charAt(i));
            }
        }
        if(e.getSource() == negBtn){
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
    }
}
