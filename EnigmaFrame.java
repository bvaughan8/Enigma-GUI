import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EnigmaFrame extends JFrame {
    private JTextField intialPos;

    private JComboBox<String> inner;
    private JComboBox<String> middle;
    private JComboBox<String> outer;

    private JButton encrypt;
    private JButton decrypt;

    private JTextArea input;
    private JTextArea output;

    private final String[] rotor = {
        "1", "2", "3", "4", "5"
    };

    public EnigmaFrame(){
        super();
        this.setTitle("Enigma GUI");

        //TODO: Complete the GUI
        inner = new JComboBox<String>(rotor);
        middle = new JComboBox<String>(rotor);
        outer = new JComboBox<String>(rotor);
        intialPos = new JTextField("", 3);
        encrypt = new JButton("Encrypt");
        decrypt = new JButton("Decrypt");
        input = new JTextArea(10, 30);
        output = new JTextArea(10, 30);

        JPanel main = new JPanel(new BorderLayout());
        JPanel setting = new JPanel();
        setting.add(new JLabel(" Inner: "));
        setting.add(inner);
        setting.add(new JLabel(" Middle: "));
        setting.add(middle);
        setting.add(new JLabel(" Outer: "));
        setting.add(outer);   
        setting.add(new JLabel(" Intial Positions: "));
        setting.add(intialPos); 
        setting.add(encrypt);
        setting.add(decrypt);

        JPanel inputP = new JPanel();
        inputP.add(new JLabel(" Input:  ")); 
        inputP.add(input);
        
        JPanel outputP = new JPanel();
        outputP.add(new JLabel(" Output: "));
        outputP.add(output);  

        main.add(setting, BorderLayout.NORTH);
        main.add(inputP, BorderLayout.CENTER);
        main.add(outputP, BorderLayout.SOUTH);

        this.add(main);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        encrypt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int iIdx = inner.getSelectedIndex();
                int mIdx = middle.getSelectedIndex();
                int oIdx = outer.getSelectedIndex();
                String startChars = intialPos.getText(); 

                Enigma enigma = new Enigma(iIdx, mIdx, oIdx, startChars);
                output.setText(enigma.encrypt(input.getText()));               
            }
            
        });

        decrypt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int iIdx = inner.getSelectedIndex();
                int mIdx = middle.getSelectedIndex();
                int oIdx = outer.getSelectedIndex();
                String startChars = intialPos.getText(); 

                Enigma enigma = new Enigma(iIdx, mIdx, oIdx, startChars);
                output.setText(enigma.decrypt(input.getText()));               
            }
            
        });
    }
}
