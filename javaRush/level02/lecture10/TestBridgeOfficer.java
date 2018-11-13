package level02.lecture10;

public class TestBridgeOfficer {
  public static void main(String[] args) {
    Truck first = new Truck();
    first.weight = 10_000;
    Truck second = new Truck();
    second.weight = 20_000;

    BridgeOfficer officer = new BridgeOfficer(15_000);
//    System.out.println("Max weight = " + officer.maxWeight + "\n");

    System.out.println("Грузовик номер 1! Могу я проехать, офицер?");
    boolean canFirstTruckGo = officer.checkTruck(first);
//    System.out.println(canFirstTruckGo);

    System.out.println();

    System.out.println("Грузовик номер 2! А мне можно?");
    boolean canSecondTruckGo = officer.checkTruck(second);
//    System.out.println(canSecondTruckGo);
  }
}
