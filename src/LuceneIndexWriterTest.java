import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.search.highlight.Scorer;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;

public class LuceneIndexWriterTest {
//    public static final String INDEX_PATH="/Users/enity/Downloads/text_group_work/test_index";
    static final String INDEX_PATH = "/Users/enity/Downloads/text_group_work/lucene_index";
//    static final String JSON_FILE_PATH = "/Users/enity/Downloads/text_group_work/review_part.json";

    @Test
    public void testWriteIndex() {
        try {
            //open the index
            Directory indexDirectory = FSDirectory.open(Paths.get(INDEX_PATH));
            IndexReader indexReader = DirectoryReader.open(indexDirectory);

            int numDocs = indexReader.numDocs();
//            assertEquals(numDocs, 28);

            for (int i = 0; i < numDocs; i++) {
                Document document = indexReader.document(i);
                System.out.println("d=" + document);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testForInput() throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = "so express";
        input = input.trim();
        System.out.println("after: "+input);
        System.out.println("input length: " + input.length());
    }

    @Test
    public void testQueryLucene() throws IOException, ParseException, org.apache.lucene.queryparser.classic.ParseException, InvalidTokenOffsetsException {
        Directory indexDirectory = FSDirectory.open(Paths.get(INDEX_PATH));
        IndexReader indexReader = DirectoryReader.open(indexDirectory);
        final IndexSearcher indexSearcher = new IndexSearcher(indexReader);

        //检索方式1
//        Term t = new Term("useful", "0");
//        Query query = new TermQuery(t);

        //搜索整数
//        Query query = IntPoint.newExactQuery("useful",0);
//        Query query = IntPoint.newRangeQuery("useful",0,2);
        //检索浮点数
//        Query query = DoublePoint.newExactQuery("stars",5.0);

        //搜索字符串
        // standard analyzer default stop word set is empty
//        Analyzer analyzer = new StandardAnalyzer(EnglishAnalyzer.getDefaultStopSet());
        Analyzer analyzer = new PorterStemAnalyzer(new StandardAnalyzer(EnglishAnalyzer.getDefaultStopSet()));
        QueryParser parser = new QueryParser("text", analyzer);
        Query query = parser.parse("Renaissance");

        // save the search result
        TopDocs topDocs = indexSearcher.search(query, 10);
        ScoreDoc scoreDocs[] = topDocs.scoreDocs;

        // highlight format
        Formatter formatter = new SimpleHTMLFormatter("<font color='red'>","</font>");
        // connect to query
        Scorer scorer = new QueryScorer(query);
        // init a highlighter
        Highlighter highlighter = new Highlighter(formatter,scorer);

        // total hits
        System.out.println("total hits: "+topDocs.totalHits);
        //show the top 10 match result
        for (ScoreDoc scoreDoc: scoreDocs ) {
            // get the document id
            int docId = scoreDoc.doc;
            Document document = indexSearcher.doc(docId);
            // print the document score: VSM algorithm
            System.out.println("\nscore: "+scoreDoc.score);
            // use the highlighter
            String highlightContent = highlighter.getBestFragment(analyzer,"text",document.get("text"));
            System.out.println("content: \n"+highlightContent);
//            System.out.println("content: \n"+document.get("text"));
        }

    }
}
