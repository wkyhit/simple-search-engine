import com.alibaba.fastjson.JSONObject;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.text.ParseException;

public class CreateIndex {
//    private IndexWriter writer;
    public static final String DATA_DIR="/Users/enity/Downloads/text_group_work/yelp_dataset/yelp_academic_dataset_review.json";
    public static final String INDEX_DIR="/Users/enity/Downloads/text_group_work/lucene_index";
    public static int docNum = 1;

    public static void main(String[] args) throws Exception{
        BuildIndex();
    }


    public static void BuildIndex() throws Exception{
        try {
            // index directory
            Directory directory = FSDirectory.open(Paths.get(INDEX_DIR));
            //init indexWriterConfig
            //*****use the customizable analyzer: stemming
            IndexWriterConfig indexWriterConfig = new IndexWriterConfig(new PorterStemAnalyzer(null));
            indexWriterConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);

            //setup index
            IndexWriter indexWriter = new IndexWriter(directory,indexWriterConfig);

            // ***start indexing
            long startTime = System.currentTimeMillis();

            // add document
            AddDocument(indexWriter);

            // ***end
            long endTime = System.currentTimeMillis();
            System.out.println("indexing every 10% of the dataset(time consuming): "+(endTime-startTime)/10f+"ms");
            System.out.println("total document number: "+ docNum);
            indexWriter.close();
            directory.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    /**
     * add document from JSON file
     */
    public static void AddDocument(IndexWriter indexWriter) throws Exception {
        // open JSON file
        FileInputStream file = new FileInputStream(DATA_DIR);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file,"UTF-8"));
        String line = "";
        while ((line=bufferedReader.readLine()) != null){
            // covert to json object
            JSONObject jsonObject = JSONObject.parseObject(line);
            // parse json object and return a document
            Document doc = createDocument(jsonObject);
            // add index
            indexWriter.addDocument(doc);
            docNum++;
        }
        bufferedReader.close();
        file.close();
    }

    /**
     * parse json and add to the document
     * @param jsonObject
     * @return
     * @throws ParseException
     */
    public static Document createDocument(JSONObject jsonObject) throws ParseException{
        String reviewId = jsonObject.getString("review_id");
        String userId = jsonObject.getString("user_id");
        String businessId = jsonObject.getString("business_id");
        Double stars = jsonObject.getDouble("stars");
        Integer useful = jsonObject.getInteger("useful");
        Integer funny = jsonObject.getInteger("funny");
        Integer cool = jsonObject.getInteger("cool");
        String text = jsonObject.getString("text");
        String date = jsonObject.getString("date");

        Document document = new Document();
        document.add(new Field("review_id",reviewId, StringField.TYPE_STORED));
        document.add(new Field("user_id",userId, StringField.TYPE_STORED));
        document.add(new Field("business_id",businessId, StringField.TYPE_STORED));
        document.add(new DoublePoint("stars",stars));
        document.add(new IntPoint("useful",useful));
        document.add(new IntPoint("funny",funny));
        document.add(new IntPoint("cool",cool));
        document.add(new TextField("text",text,Field.Store.YES));
        document.add(new Field("date",date,StringField.TYPE_STORED));

        return document;

    }
}
