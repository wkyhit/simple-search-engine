import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.LowerCaseTokenizer;
import org.apache.lucene.analysis.en.PorterStemFilter;

public class PorterStemAnalyzer extends Analyzer {

    private Analyzer baseAnalyzer;

    public PorterStemAnalyzer(Analyzer baseAnalyzer) {
        this.baseAnalyzer = baseAnalyzer;
    }

    protected Analyzer getWrappedAnalyzer(String fieldName)
    {
        return baseAnalyzer;
    }

    @Override
    protected TokenStreamComponents createComponents(String fieldName) {
        LowerCaseTokenizer tokenizer = new LowerCaseTokenizer();
        return new TokenStreamComponents(tokenizer,new PorterStemFilter(tokenizer));
    }

    @Override
    public void close() {
        baseAnalyzer.close();
        super.close();
    }
}
