package aggregator.task2810;

import aggregator.task2810.model.HHStrategy;
import aggregator.task2810.model.Model;
import aggregator.task2810.model.MoikrugStrategy;
import aggregator.task2810.model.Provider;
import aggregator.task2810.view.HtmlView;

public class Aggregator {
    public static void main(String[] args) {
        Provider hh = new Provider(new HHStrategy());
        Provider moiKrug = new Provider(new MoikrugStrategy());
        HtmlView view = new HtmlView();
        Model model = new Model(view, hh, moiKrug);
//        Model model = new Model(view, moiKrug);
        Controller controller = new Controller(model);
        view.setController(controller);
        controller.onCitySelect("Kiev");
//        view.userCitySelectEmulationMethod();
    }
}
