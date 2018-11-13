package level02.lecture10;

public class BridgeOfficer {
  int maxWeight;

  public BridgeOfficer(int normalVolume) {
    this.maxWeight = normalVolume;
  }

  public boolean checkTruck(Truck truck) {

    if (truck.weight > maxWeight) {
      System.out.println("Разворачивайся, перевес!");
      return false;
    } else {
      System.out.println("Порядок, проезжай!");
      return true;
    }
  }}