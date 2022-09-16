package aggregator.task2810.model;

import aggregator.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoikrugStrategy implements Strategy {
    //    private static final String URL_FORMAT = "http://hh.ru/search/vacancy?text=java+%s&page=%d";
//    private static final String URL_FORMAT = "http://career.habr.com/vacancies?page=%d&q=java+%s&type=all";
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        int page = 0;

        while (true) {
            System.out.println(page);
            Document document = getDocument(searchString, page++);
            if (document == null) break;

//            String key = "data-qa";
//            String tagVacancy = "vacancy-serp__vacancy";
            Elements elements = document.getElementsByClass("job");
            if (elements.size() == 0) break;

//            String tagTitle = "vacancy-serp__vacancy-title";
//            String tagSalary = "vacancy-serp__vacancy-compensation";
//            String tagCity = "vacancy-serp__vacancy-address";
//            String tagCompanyName = "vacancy-serp__vacancy-employer";
//            System.out.println("---");

            for (Element x : elements) {
                Vacancy vacancy = new Vacancy();

                vacancy.setTitle(x.getElementsByClass("title").first().text().trim());

                Element salary = x.getElementsByClass("count").first();
                vacancy.setSalary(salary != null ? salary.text().trim() : "");

                Element companyName = x.getElementsByClass("company_name").first();
                vacancy.setCompanyName(companyName != null ? companyName.text().trim() : "");

                Element city = x.getElementsByClass("location").first();
                vacancy.setCity(city != null ? city.text().trim() : "");

                vacancy.setUrl("https://moikrug.ru" + x.getElementsByClass("title").first()
                        .select("a").attr("href"));
                vacancy.setSiteName("moikrug.ru");
                vacancies.add(vacancy);
            }
//            if (page > 0) break; // for Test purpose only
        }
        return vacancies;
    }

    protected Document getDocument(String searchString, int page) {
        String url = String.format(URL_FORMAT, searchString, page);
//        url = "http://javarush.ru/testdata/big28data2.html";
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36";
        String refer = "";
        Document document;
        try {
            document = Jsoup.connect(url)
                    .userAgent(userAgent)
                    .referrer(refer)
//                .timeout(5000)
                    .get();
        } catch (IOException ex) {
            return null;
        }
        return document;
    }
}
