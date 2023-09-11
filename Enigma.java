//TODO
public class Enigma{
    Rotor inner;
    Rotor middle;
    Rotor outer;

    public Enigma(int id1, int id2, int id3, String startChars){
        //set inner rotor
        if(id1 == 0){
            this.inner = new Rotor("#GNUAHOVBIPWCJQXDKRYELSZFMT", startChars.charAt(0));
        }
        else if(id1 == 1){
            this.inner = new Rotor("#EJOTYCHMRWAFKPUZDINSXBGLQV", startChars.charAt(0));
        }
        else if(id1 == 2){
            this.inner = new Rotor("#BDFHJLNPRTVXZACEGIKMOQSUWY", startChars.charAt(0));
        }
        else if(id1 == 3){
            this.inner = new Rotor("#NWDKHGXZVRIFJBLMAOPSCYUTQE", startChars.charAt(0));
        }
        else{
            this.inner = new Rotor("#TGOWHLIFMCSZYRVXQABUPEJKND", startChars.charAt(0));
        }

        //set middle rotor
        if(id2 == 0){
            this.middle = new Rotor("#GNUAHOVBIPWCJQXDKRYELSZFMT", startChars.charAt(1));
        }
        else if(id2 == 1){
            this.middle = new Rotor("#EJOTYCHMRWAFKPUZDINSXBGLQV", startChars.charAt(1));
        }
        else if(id2 == 2){
            this.middle = new Rotor("#BDFHJLNPRTVXZACEGIKMOQSUWY", startChars.charAt(1));
        }
        else if(id2 == 3){
            this.middle = new Rotor("#NWDKHGXZVRIFJBLMAOPSCYUTQE", startChars.charAt(1));
        }
        else{
            this.middle = new Rotor("#TGOWHLIFMCSZYRVXQABUPEJKND", startChars.charAt(1));
        }

        //set outer rotor
        if(id3 == 0){
            this.outer = new Rotor("#GNUAHOVBIPWCJQXDKRYELSZFMT", startChars.charAt(2));
        }
        else if(id3 == 1){
            this.outer = new Rotor("#EJOTYCHMRWAFKPUZDINSXBGLQV", startChars.charAt(2));
        }
        else if(id3 == 2){
            this.outer = new Rotor("#BDFHJLNPRTVXZACEGIKMOQSUWY", startChars.charAt(2));
        }
        else if(id3 == 3){
            this.outer = new Rotor("#NWDKHGXZVRIFJBLMAOPSCYUTQE", startChars.charAt(2));
        }
        else{
            this.outer = new Rotor("#TGOWHLIFMCSZYRVXQABUPEJKND", startChars.charAt(2));
        }
    }

    public String encrypt(String s){
        String temp = "";
        for(int i=0; i<s.length(); i++){
            temp += outer.letter(middle.index(outer.letter(inner.index(s.charAt(i)))));
            if(inner.topChar == inner.rotor.charAt(inner.rotor.length()-1)){
                if(middle.topChar == middle.rotor.charAt(middle.rotor.length()-1)){
                    inner.rotate();
                    middle.rotate();
                }
                else{
                    inner.rotate();
                    middle.rotate();
                }
            }
            else{
                inner.rotate();
            }
        }
        return temp;
    }

    public String decrypt(String s){
        String temp = "";
        for(int i=0; i<s.length(); i++){
            temp += inner.letter(outer.index(middle.letter(outer.index(s.charAt(i)))));
            if(inner.topChar == inner.rotor.charAt(inner.rotor.length()-1)){
                if(middle.topChar == middle.rotor.charAt(middle.rotor.length()-1)){
                    inner.rotate();
                    middle.rotate();
                }
                else{
                    inner.rotate();
                    middle.rotate();
                }
            }
            else{
                inner.rotate();
            }
        }

        return temp;
    }
}