//TODO
public class Rotor{
    String rotor;
    char topChar;

    public Rotor(String str, char c){
        this.rotor = str;
        this.topChar = c;

        while(topChar != rotor.charAt(0)){
            rotate();
        }
    }

    //rotate one click clockwise
    public void rotate(){            
        String temp = "";
        temp += rotor.charAt(rotor.length()-1);
        for(int i=0; i<rotor.length()-1; i++){
            temp += rotor.charAt(i);
        }
        rotor = temp;
    }

    //return index for given character
    public int index(char c){
        return rotor.indexOf(c);
    }

    //return character at given index
    public char letter(int i){
        return rotor.charAt(i);
    }
}