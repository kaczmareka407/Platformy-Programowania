
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import javax.xml.stream.XMLStreamException;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FloatPoint;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.FuzzyQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.WildcardQuery;
import org.apache.lucene.store.Directory;
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
public class Zadanie2
{

    public void wypisz(Directory index, Query q) throws IOException
    {
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
            System.out.println((i + 1) + ". " + d.get("id") + "\t" + d.get("name") + "\t" + d.get("price") + "\t" + d.get("category")/*+ "\t" + d.get("description")*/);
        }
    }

    public void zad2() throws IOException, ParseException
    {
        System.out.println("Zadanie 2: ");
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
                doc.add(new FloatPoint("price", item.getPrice()));
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

        boolean dzialanie = true;
        Query q = null;

        while (dzialanie == true)
        {
            System.out.println("Wybierz podpunkt (a-e): ");
            Scanner scan = new Scanner(System.in);
            String wybor_zadania = scan.nextLine();
            switch (wybor_zadania)
            {
                case "a":
                {
                    System.out.println("Podpunkt a:");
                    //Znajd?? przedmioty zawieraj??cy s??owo ????, a nie zawieraj??ce s??owa ???? w tytule. (Fields, Boolean Operators)             

                    System.out.println("Znajd?? przedmioty zawieraj??cy s??owo ????, a nie zawieraj??ce s??owa ???? w tytule.");
                    System.out.println("???? = czyszczenia matryc");
                    System.out.println("???? = XL");

                    String znajdz = "+name:czyszczenia matryc AND !name:XL";
                    q = new QueryParser("name", analyzer).parse(znajdz);
                    wypisz(index, q);
                    break;
                }
                case "b":
                {
                    System.out.println("Podpunkt b:");
                    //Znajd?? przedmioty zawieraj??cy zadan?? fraz?? ???? w nazwie oraz zadan?? list?? s????w ???? w
                    //opisie. (Phrase Terms, Grouping)

                    System.out.println("Znajd?? przedmioty zawieraj??cy zadan?? fraz?? ???? w nazwie oraz zadan?? list?? s????w ???? w opisie.");
                    System.out.println("???? = czyszczenia");
                    System.out.println("???? = temu, produkowane");

                    String znajdz = "+name:czyszczenia AND +description:(temu AND produkowane)";
                    q = new QueryParser("name", analyzer).parse(znajdz);
                    wypisz(index, q);
                    break;
                }
                case "c":
                {   //Znajd?? przedmioty zawieraj??ce wyra??enie zaczynaj??ce si?? od ???? w nazwie kategorii.
                    //(Wildcard Searches)

                    System.out.println("Podpunkt c:");
                    System.out.println("Znajd?? przedmioty zawieraj??ce wyra??enie zaczynaj??ce si?? od ???? w nazwie kategorii.");
                    System.out.println("???? = pilo*");
                    // String znajdz = "+category:Pilo*";
                    // q = new QueryParser("category", analyzer).parse(znajdz);
                    Term term = new Term("category", "pilo*");
                    q = new WildcardQuery(term);
                    wypisz(index, q);

                    break;
                }
                case "d":
                {
                    //Znajd?? przedmioty zawieraj??ce s??owa podobne (tj. r????ni??ce si?? maksymalnie 2 literami)
                    //do ???? w tytule (Fuzzy Searches).
                    System.out.println("Podpunkt d:");
                    System.out.println("Znajd?? przedmioty zawieraj??ce s??owa podobne (tj. r????ni??ce si?? maksymalnie 2 literami) do ???? w tytule.");
                    System.out.println("???? = zastew");
                    Term term = new Term("name", "zastew");
                    q = new FuzzyQuery(term, 2);
                    wypisz(index, q);

                    break;
                }
                case "e":
                {
                    //Znajd?? przedmioty, posortowane rosn??co wg ceny, kt??rych cena jest mniejsza ni?? ???? i
                    //wi??ksza ni?? ????. (Range Searches)
                    System.out.println("Podpunkt e:");
                    System.out.println("Znajd?? przedmioty zawieraj??ce s??owa podobne (tj. r????ni??ce si?? maksymalnie 2 literami) do ???? w tytule.");
                    System.out.println("???? = 0.0");
                    System.out.println("???? = 1200.0");
                    q = FloatPoint.newRangeQuery("price", Float.parseFloat("0.0"), Float.parseFloat("1200.0"));
                    wypisz(index, q);
                    break;

                }
                default:
                {
                    System.out.println("Wyjscie");
                    dzialanie = false;
                    break;
                }
            }
        }

    }
}
