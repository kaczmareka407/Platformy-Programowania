
import java.io.IOException;
import java.nio.file.Paths;
import javax.xml.stream.XMLStreamException;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.store.SimpleFSDirectory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class Zadanie1
{

    public void zad1() throws IOException, ParseException
    {
        System.out.println("Zadanie 1: ");
        StandardAnalyzer analyzer = new StandardAnalyzer();

        Directory index = new SimpleFSDirectory(Paths.get("./dir"));
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter w = new IndexWriter(index, config);

        try ( ItemProvider provider = new ItemProvider("items.xml"))
        {
            while (provider.hasNext())
            {
                Item item = provider.next();
                // TODO index item

                Document doc = new Document();

                /*
                private int id;
                private float price;
                private String name;
                private String category;
                private String description;
                 */
                doc.add(new StringField("id", Integer.toString(item.getId()), Field.Store.YES));
                doc.add(new StringField("price", Float.toString(item.getPrice()), Field.Store.YES));
                if (item.getName() != null)
                {
                    doc.add(new TextField("name", item.getName(), Field.Store.YES));
                }
                if (item.getCategory() != null)
                {
                    doc.add(new TextField("category", item.getCategory(), Field.Store.YES));
                }
                if (item.getDescription() != null)
                {
                    doc.add(new TextField("description", item.getDescription(), Field.Store.YES));
                }
                w.addDocument(doc);

            }
            w.close();
        } catch (XMLStreamException | IOException ex)
        {
            ex.printStackTrace();
        }
        Query q = new QueryParser("name", analyzer).parse("Lustrzanka cyfrowa Sony Alpha DSLR-A230L + Obiektyw Sony DT18–55");
        int hitsPerPage = 10;
        IndexReader reader = DirectoryReader.open(index);
        IndexSearcher searcher = new IndexSearcher(reader);
        TopDocs docs = searcher.search(q, hitsPerPage);
        ScoreDoc[] hits = docs.scoreDocs;

        System.out.println("Found " + hits.length + " hits.");
        for (int i = 0; i < hits.length; ++i)
        {
            int docId = hits[i].doc;
            Document d = searcher.doc(docId);
            System.out.println((i + 1) + ". " + d.get("id") + "\t" + d.get("name") + "\t" + d.get("price") + "\t" /*+ d.get("category")+ "\t" + d.get("description")*/);
        }

    }
}
