## Enigma GUI

I created multiple member variables of JTextField, JComboBox, JButton, JTextArea. The JTextField will hold user input for the intial positions of each starting letter for each rotor. Each JComboBox represents the inner, middle, and outer rotor and which rotor it will be. Then the Jbuttons are for encrypting and decrypting. I also have JTextArea for input and output texts that will be encrypted or decrypted. 

Then I created 4 JPanels. The first panel was the main panel that had a BorderLayout. I then created three other panels: setting, input and output. The setting panel had all the objects that the user would choose for the settings of an enigma. Then I add all three panels to the main panel.

## Extensions to GUI

To make my GUI functional I used ActionListeners. I used one for each button for encrypt and decrypt. In the encrypt button action listener it would create an Enigma instance with the inputed settings and then set the output text using the encrypt method from enigma. The same concept was used for decrypt just instead of the encrypt method it was the decrpyt method.
