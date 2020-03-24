package aggregator.task2810.view;

import aggregator.task2810.Controller;
import aggregator.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HtmlView implements View {
    private Controller controller;
    private final String filePath = "./4.JavaCollections/src/"
            + getClass().getPackage().getName().replace('.', '/')
            + "/vacancies.html";


    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void update(List<Vacancy> vacancies) {
        try {
            updateFile(getUpdatedFileContent(vacancies));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateFile(String string) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        writer.write(string);
        writer.close();
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies) {
        Document document = null;
        try {
            document = getDocument();
            Element template = document.getElementsByClass("template").first();
            Element cloneTemplate = template.clone();
            cloneTemplate.removeClass("template");
            cloneTemplate.removeAttr("style");
            document.select("tr[class=vacancy]").remove();

            for (Vacancy vacancy : vacancies) {
                Element element = cloneTemplate.clone();
                element.getElementsByClass("city").first().text(vacancy.getCity());
                element.getElementsByClass("companyName").first().text(vacancy.getCompanyName());
                element.getElementsByClass("salary").first().text(vacancy.getSalary());
                Element link = element.getElementsByTag("a").first();
                link.text(vacancy.getTitle());
                link.attr("href", vacancy.getUrl());

                template.before(element.outerHtml());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Some exception occurred";
        }

        return document.html();
    }

    protected Document getDocument() throws IOException {
        Document document = Jsoup.parse(new File(filePath), "UTF-8");
        return document;
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Moscow");
    }
}
