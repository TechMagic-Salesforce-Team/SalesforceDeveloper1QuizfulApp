import quizlet.http.QuizletLinkParser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseHtmlMain {
    public static void main(String[] args) throws IOException {
        List<String> ids = new ArrayList<String>();
        for (Integer i = 2; i < 6; i++) {
            ids.addAll(QuizletLinkParser.parseIdElement(i));
        }
        File idsOfPage2_6 = new File("IdsOfSalesforceDeveloper1_Page_2_6.txt");
        FileWriter fileWriter = new FileWriter(idsOfPage2_6);
        fileWriter.write("");
        for (String id : ids) {
            fileWriter.append(id+"\n");
        }
        fileWriter.close();
    }
}
