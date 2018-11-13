package chap09;

import java.util.ArrayList;

class SimUnit {
    String botType;

    SimUnit(String type) {
        botType = type;
        System.out.print(powerUse());
    }

    int powerUse() {
        if ("Retention".equals(botType)) {
            return 2;
        } else {
            return 4;
        }
    }
}

class RetentionBot {
    RetentionBot(ArrayList rlist) {
        rlist.add(new SimUnit("Retention"));
    }
}

class V2Radiator {
    V2Radiator(ArrayList list) {
        for (int i = 0; i < 5; i++) {
            list.add(new SimUnit("V2Radiator"));
        }
    }
}

class V3Radiator extends V2Radiator {
    V3Radiator(ArrayList lglist) {
        super(lglist);
        for (int i = 0; i < 10; i++) {
            lglist.add(new SimUnit("V3Radiator"));
        }
    }
}

public class TestLifeSupportSim {
    public static void main(String[] args) {
        ArrayList aList = new ArrayList();
//        V2Radiator v2 = new V2Radiator(aList);
        V3Radiator v3 = new V3Radiator(aList);
        System.out.println(aList + "\t" + aList.size());

        for (int i = 0; i < 20; i++) {
            RetentionBot ret = new RetentionBot(aList);
//            System.out.println(ret+"\t"+aList.size());
        }
        System.out.println(aList + "\t" + aList.size());
    }
}
