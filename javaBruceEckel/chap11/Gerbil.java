package chap11;

import java.util.*;

public class Gerbil {
    int gerbilNumber;
    Gerbil(int gerbilNumber) { this.gerbilNumber = gerbilNumber; }
    void hop() { System.out.println(gerbilNumber); }

    public static void main(String[] args) {
        ArrayList<Gerbil> gerbils = new ArrayList<>();
        gerbils.add(new Gerbil(1));
        gerbils.add(new Gerbil(4));
        gerbils.add(new Gerbil(3));
        gerbils.add(new Gerbil(9));

        for (int i = 0; i < gerbils.size(); i++) gerbils.get(i).hop();
        for(Gerbil g: gerbils) g.hop();
    }
}
