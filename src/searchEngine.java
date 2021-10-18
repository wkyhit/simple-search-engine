import org.apache.lucene.search.Query;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class searchEngine {
    public static void main(String[] args) throws Exception{
        // input from the console
        SearchIndex searchIndex = new SearchIndex();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            Integer flag = 0;
            System.out.println("\nSelect Query Model (single word -- 0 or phrase -- 1):");
            String input = in.readLine();
            if (input==null){
                System.out.println("Input null------------exit");
                break;
            }
            flag = Integer.parseInt(input);
            // single word search
            if (flag == 0){
                System.out.println("Input single keyword:");
                input = in.readLine();
                if (input != null){
                    // remove the front and the tail blank space
                    input = input.trim();
                    if (input.length() == 0){
                        continue;
                    }
                    Query query = searchIndex.singleKeywordQuery(input);
                    searchIndex.Search(query);
                }
            }
            // phrase search
            else if(flag == 1){
                System.out.println("Input phrase:");
                input = in.readLine();
                if (input != null){
                    input = input.trim();
                    if (input.length() == 0){
                        continue;
                    }
                    Query query = searchIndex.PhraseQuery(input);
                    searchIndex.Search(query);
                }
            // did not select any models
            }else {
                System.out.println("model selection error-----exit");
                break;
            }
        }
    }
}
