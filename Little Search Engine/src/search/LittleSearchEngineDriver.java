package search;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Sasha on 3/31/17.
 */
public class LittleSearchEngineDriver {

    public static void main(String[]args) {
        LittleSearchEngine engine = new LittleSearchEngine();
        try {
            engine.makeIndex("docs.txt", "noisewords.txt");
            print(engine);
            String keyword1 = "one";
            String keyword2 =  "recent";
            ArrayList<String> results = engine.top5search(keyword1, keyword2);
            System.out.println("Documents matching '" + keyword1 + "' or '" + keyword2 + "':");
            System.out.println(results);
        }   catch (FileNotFoundException e) {
            System.out.println("File does not exist");
            System.out.println(e);
            performQueries(engine);

        }
    }
    static BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
    
    static void performQueries(LittleSearchEngine engine) throws IOException {
        System.out.print("\nEnter two keywords or quit to stop => ");
        String schedule = keyboard.readLine();
        while (!schedule.equals("quit")) {
            StringTokenizer st = new StringTokenizer(schedule);

            String first = st.nextToken();
            String second = st.nextToken();
            System.out.println(engine.top5search(first, second));

        }
    }
    private static void print(LittleSearchEngine engine) {
       System.out.println("Number of keywords: " + engine.keywordsIndex.size());
        for (Map.Entry<String, ArrayList<Occurrence>> entry : engine.keywordsIndex.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + "          OCCURENCE: " + value);
        }
    }
}
