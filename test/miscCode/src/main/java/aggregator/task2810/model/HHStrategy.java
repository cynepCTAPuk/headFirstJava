package aggregator.task2810.model;

import aggregator.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HHStrategy implements Strategy {
    //    public static final String URL_FORMAT = "http://hh.ru/search/vacancy?text=java+Kiev&page=3";
    private static final String URL_FORMAT = "http://hh.ru/search/vacancy?text=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        int page = 0;

        while (true) {
            Document document = getDocument(searchString, page++);
            if (document == null) break;

            String key = "data-qa";
            String tagVacancy = "vacancy-serp__vacancy";
            Elements elements = document.getElementsByAttributeValue(key, tagVacancy);
            if (elements.size() == 0) break;

            String tagTitle = "vacancy-serp__vacancy-title";
            String tagSalary = "vacancy-serp__vacancy-compensation";
            String tagCity = "vacancy-serp__vacancy-address";
            String tagCompanyName = "vacancy-serp__vacancy-employer";
//        String tagResponsibility = "vacancy-serp__vacancy_snippet_responsibility";
//        String tagRequirement = "vacancy-serp__vacancy_snippet_requirement";
//            System.out.println("---");

            for (Element x : elements) {
                Vacancy vacancy = new Vacancy();
                vacancy.setTitle(x.getElementsByAttributeValue(key, tagTitle).first().text().trim());

                Element salary = x.getElementsByAttributeValue(key, tagSalary).first();
                vacancy.setSalary(salary != null ? salary.text().trim() : "");

                Element companyName = x.getElementsByAttributeValue(key, tagCompanyName).first();
                vacancy.setCompanyName(companyName != null ? companyName.text().trim() : "");

                vacancy.setCity(x.getElementsByAttributeValue(key, tagCity).first().text().trim());
                vacancy.setUrl(x.getElementsByAttributeValue(key, tagTitle).attr("href"));
                vacancy.setSiteName("hh.ru");
//                vacancy.setSiteName(url.getHost());
                vacancies.add(vacancy);
            }
//            if (page > 0) break; // for Test purpose only
        }
        return vacancies;
    }

    protected Document getDocument(String searchString, int page) {
        String url = String.format(URL_FORMAT, searchString, page);
//        url = "http://javarush.ru/testdata/big28data.html";
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
