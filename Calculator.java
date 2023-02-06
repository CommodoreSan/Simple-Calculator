import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Calculator
{
    public static void main(String[] args)
    {
        Calc ob = new Calc();
    }
}
class EmptyFieldException extends Exception
{
}
class Calc implements ActionListener
{
    boolean flag=false;
    String res;
    JFrame win;
    JTextField op1 = new JTextField();
    JTextField opr = new JTextField();
    JTextField op2 = new JTextField();
    JTextField out = new JTextField();
    /*Popup p;
    PopupFactory pf = new PopupFactory();
    JPanel pop = new JPanel();
    JLabel popL;*/
    Calc()
    {
        win = new JFrame("Calculator Assignment Q1");
        win.setSize(420,300);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton b = new JButton("Calculate");

        op1.setHorizontalAlignment(JTextField.CENTER);
        opr.setHorizontalAlignment(JTextField.CENTER);
        op2.setHorizontalAlignment(JTextField.CENTER);
        out.setHorizontalAlignment(JTextField.CENTER);

        b.setBounds(145,100,120,40);
        op1.setBounds(20, 20,150 , 40);
        opr.setBounds(180, 20,50 , 40);
        op2.setBounds(240, 20,150 , 40);
        out.setBounds(20,180,360,60);

        JLabel o1 = new JLabel("Operand 1");
        o1.setBounds(65,60,150,40);
        JLabel or = new JLabel("Opr");
        or.setBounds(195,60,50,40);
        JLabel o2 = new JLabel("Operand 2");
        o2.setBounds(285,60,150,40);

        win.setLayout(null);
        win.add(op1);
        win.add(opr);
        win.add(op2);
        win.add(b); 
        win.add(o1);
        win.add(or);
        win.add(o2);
        win.add(out);

        win.setVisible(true);
        b.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        //if(flag==true)
        //    p.hide();
        res="";
        out.setText(null);
        double x=0.0,y=0.0,z=0.0;
        char op=' ';
        try
        {
            if(op1.getText().equals("") || opr.getText().equals("") || op2.getText().equals(""))
                throw new EmptyFieldException();
            op=opr.getText().charAt(0);
            try
            {
                x=Double.parseDouble(op1.getText());
                y=Double.parseDouble(op2.getText());
            }
            catch(NumberFormatException nfe)
            {
                res = "Enter numbers only for operands";
            }
        }
        catch(EmptyFieldException efe)
        {
            res = "Empty fields";
        }
        switch(op)
        {
            case '+': z=x+y;
            break;
            case '-': z=x-y;
            break;
            case '*': z=x*y;
            break;
            case '/':
            try
            {
                z=x/y;
            }
            catch(ArithmeticException div)
            {
                res="Division by zero";
            }
            break;
            case '%':
            try
            {
                z=x%y;
            }
            catch(ArithmeticException div)
            {
                res="Mod by zero";
            }
            break;
            default: if(op!='+' && op!='-' && op!='*' && op!='/' && op!='%' && res.equals("")) 
                res="Invalid operator";
        }
        if(res.equals(""))
            res=Double.toString(z);
        /*popL = new JLabel(res);
        pop.add(popL);
        p = pf.getPopup(win, pop, 20,200);
        res="";
        flag=true;
        p.show();*/
        out.setText(res);
    }
}