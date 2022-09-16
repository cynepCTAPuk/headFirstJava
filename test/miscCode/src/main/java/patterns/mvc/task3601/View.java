package patterns.mvc.task3601;

public class View {
    public void fireShowDataEvent() {
        System.out.println(new Controller().onShowDataList());
    }
}
