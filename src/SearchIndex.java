import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Paths;

public class SearchIndex {

    static final String INDEX_PATH = "/Users/enity/Downloads/text_group_work/lucene_index";

    public void Search(Query query) throws IOException, ParseException, InvalidTokenOffsetsException {

        Directory indexDirectory = FSDirectory.open(Paths.get(INDEX_PATH));

        long startTime = System.currentTimeMillis();

        IndexReader indexReader = DirectoryReader.open(indexDirectory);
        final IndexSearcher indexSearcher = new IndexSearcher(indexReader);

        Analyzer analyzer = new PorterStemAnalyzer(new StandardAnalyzer(EnglishAnalyzer.getDefaultStopSet()));

        // save the search result
        TopDocs topDocs = indexSearcher.search(query, 10);
        ScoreDoc scoreDocs[] = topDocs.scoreDocs;

        long endTime = System.currentTimeMillis();
        System.out.println("Query time consuming: "+(endTime-startTime)+"ms");

        // highlight format
        Formatter formatter = new SimpleHTMLFormatter("<font color='red'>","</font>");
        // connect to query
        Scorer scorer = new QueryScorer(query);
        // init a highlighter
        Highlighter highlighter = new Highlighter(formatter,scorer);

        // total hits
        System.out.println("\ntotal hits: "+topDocs.totalHits);
        //show the top 10 match result
        for (ScoreDoc scoreDoc: scoreDocs ) {
            // get the document id
            int docId = scoreDoc.doc;
            Document document = indexSearcher.doc(docId);
            // print the document score: VSM algorithm
            System.out.println("\nscore: "+scoreDoc.score);
            System.out.println("\ndocId: "+docId);
            // use the highlighter
//             String highlightContent = highlighter.getBestFragment(analyzer,"text",document.get("text"));
//             System.out.println("content: \n"+highlightContent);

            // output directly
            System.out.println("\ncontent: \n"+document.get("text"));
        }
    }

    public Query singleKeywordQuery(String keyword) throws ParseException {
        Analyzer analyzer = new PorterStemAnalyzer(new StandardAnalyzer(EnglishAnalyzer.getDefaultStopSet()));
        QueryParser parser = new QueryParser("text", analyzer);
        Query query = parser.parse(keyword);
        return query;
    }

    public Query PhraseQuery(String phrase){
        Analyzer analyzer = new PorterStemAnalyzer(new StandardAnalyzer(EnglishAnalyzer.getDefaultStopSet()));
        QueryParser parser = new QueryParser("text", analyzer);
        parser.setDefaultOperator(QueryParser.AND_OPERATOR);
        parser.setPhraseSlop(0); // with 0 word between each words
        Query query = parser.createPhraseQuery("text", phrase);
        return query;
    }

}
