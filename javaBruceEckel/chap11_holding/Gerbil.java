package chap11_holding;

import java.util.*;

public class Gerbil {
    int gerbilNumber;
    Gerbil(int gerbilNumber) { this.gerbilNumber = gerbilNumber; }
    void hop() { System.out.print(gerbilNumber + " "); }

    public static void main(String[] args) {
        ArrayList<Gerbil> gerbils = new ArrayList<>();
        gerbils.add(new Gerbil(1));
        gerbils.add(new Gerbil(4));
        gerbils.add(new Gerbil(3));
        gerbils.add(new Gerbil(9));

        for (int i = 0; i < gerbils.size(); i++) gerbils.get(i).hop();
        System.out.println();
        for(Gerbil g: gerbils) g.hop();
        System.out.println();
        Iterator<Gerbil> itr = gerbils.iterator();
        while (itr.hasNext()) itr.next().hop();
    }
}
