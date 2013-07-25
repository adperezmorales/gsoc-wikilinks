package com.gsoc.freebase.wikilinks.test.parser;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.net.URL;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.gsoc.freebase.wikilinks.interfaces.WikiLinksParserListener;
import com.gsoc.freebase.wikilinks.listeners.JenaTDBParserListener;
import com.gsoc.freebase.wikilinks.ontology.WikiLinksOntology;
import com.gsoc.freebase.wikilinks.parser.WikiLinksParser;
import com.hp.hpl.jena.query.Dataset;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ResIterator;
import com.hp.hpl.jena.tdb.TDBFactory;

/**
 * <p>Class to test WikiLinksParser</p>
 * @author Antonio David Perez Morales <adperezmorales@gmail.com>
 *
 */
public class WikiLinksParserTest
{
    private static final String modelName = "testModel";
    private static final String wikiLinkTestFile = "107.gz";
    private static final String testTdbDirectory = "/tmp/wltesttdb";
    private static File tempDir;
    private static File testFile;
    private static WikiLinksParser parser;

    private Dataset dataset;
    
    @BeforeClass
    public static void oneTimeSetUp()
    {
        System.out.println("Preparing WikiLinksParserTest tests");

        URL url = WikiLinksParserTest.class.getClassLoader().getResource(wikiLinkTestFile);
        
        tempDir = new File(testTdbDirectory);
        
        testFile = new File(url.getFile());
        parser = new WikiLinksParser(testFile);
        
        WikiLinksParserListener listener = new JenaTDBParserListener(testTdbDirectory, modelName);
        parser.setListener(listener);
    }

    @AfterClass
    public static void oneTimeTearDown()
    {
        System.out.println("Finishing WikiLinksParserTest tests");
        if (!tempDir.delete())
            System.out.println("Error deleting the tmp directory");
    }

    @Before
    public void setUp()
    {
        //dataset = TDBFactory.createDataset(testTdbDirectory);
    }
    
    @After
    public void tearDown() {
        if(dataset != null)
            dataset.close();
    }
    
    /**
     * <p>Test if the parser process is correct</p>
     */
    @Test
    public void testProcessFile() {
        // Creating temp directory 
        
        if (tempDir.exists())
        {
            tempDir.delete();
        }

        System.out.println("Creating Directory");
        if (!tempDir.mkdir())
            System.out.println("Error creating temp directory at " + tempDir.toString());
        
        System.out.println("Process Test File");
        parser.process();
        Dataset ds = TDBFactory.createDataset(testTdbDirectory);
        assertEquals(true, ds.containsNamedModel(modelName));
        ds.close();
    }
    
    /**
     * <p>Test the wikiLinks item size</p>
     */
    @Test
    public void testWikiLinksItemsSize() {
        dataset = TDBFactory.createDataset(testTdbDirectory);
        Model m = dataset.getNamedModel(modelName);
        ResIterator resIt = m.listSubjectsWithProperty(WikiLinksOntology.DOC_ID);
        int size = resIt.toList().size();
        assertEquals(83937, size);
    }
    
    /**
     * <p>Test the size of the mentions list</p>
     */
    @Test
    public void testMentionsSize() {
        dataset = TDBFactory.createDataset(testTdbDirectory);
        Model m = dataset.getNamedModel(modelName);
        ResIterator resIt = m.listSubjectsWithProperty(WikiLinksOntology.MENTION_FREEBASE_ID);
        int size = resIt.toList().size();
        assertEquals(172703, size);
    }
    
    /**
     * <p>Test the size of the rare words list</p>
     */
    @Test
    public void testRareWordsSize() {
        dataset = TDBFactory.createDataset(testTdbDirectory);
        Model m = dataset.getNamedModel(modelName);
        ResIterator resIt = m.listSubjectsWithProperty(WikiLinksOntology.RARE_WORD_WORD);
        int size = resIt.toList().size();
        assertEquals(842066, size);
    }

}
