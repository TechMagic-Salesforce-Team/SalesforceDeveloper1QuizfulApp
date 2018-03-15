package quizlet.http;

import com.google.gson.Gson;
import quizlet.parsing.QuizletSet;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class QuizletHttp {
    private static final  String client_id = "3XGWsCrqg5";


    public static List<QuizletSet> getQuizletSetsByIdsFromFileHttp(File file) throws Exception {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = "";
        String fileContent = "";
        while ((line = bufferedReader.readLine()) != null) {
            fileContent += line;
        }
        System.out.println(fileContent);
        bufferedReader.close();
        fileReader.close();

        String [] ids = fileContent.split(",");
        List<QuizletSet> quizletSets = new ArrayList<QuizletSet>();

        for (String id : ids) {
            quizletSets.add(getQuizletSetQuestionsHttp(id));
        }
        return quizletSets;
    }


    public static QuizletSet getQuizletSetQuestionsHttp(String setId) throws Exception {
        String url = "https://api.quizlet.com/2.0/sets/"+setId+"?client_id=3XGWsCrqg5";

        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);


        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();


        QuizletSet quizletSet = new Gson().fromJson(response.toString(), QuizletSet.class);
        System.out.println("Terms size: "+quizletSet.terms.size());

        return quizletSet;
    }
}
