package quizlet.http;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class QuizletLinkParser {


    public static List<String> parseIdElement(Integer page) throws IOException {
        Document doc = Jsoup.connect("https://quizlet.com/subject/salesforce-developer-1/page/"+page).get();
        Element body = doc.body();
        Element siteDiv = body.getElementsByClass("site").get(0);
        Element pageIdMainElement = siteDiv.getElementById("page");
        Element uiContainer = pageIdMainElement.getElementsByClass("UIContainer").get(0);
        Element searchPageClassElement = uiContainer.getElementsByClass("SearchPage").get(0);
        Element searchPageContainerClassElement = searchPageClassElement.getElementsByClass("SearchPage-container").get(0);
        Element searchPageResultsClassElement = searchPageContainerClassElement.getElementsByClass("SearchPage-results").get(0);
        Elements allBlocks = searchPageResultsClassElement.getElementsByClass("js-setResult");

        List<String> ids = new ArrayList<String>();

        for (Element block : allBlocks) {
            ids.add(block.attr("data-item-id"));
        }

        return ids;
    }


}
