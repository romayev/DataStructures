package search;

import java.io.FileNotFoundException;
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
