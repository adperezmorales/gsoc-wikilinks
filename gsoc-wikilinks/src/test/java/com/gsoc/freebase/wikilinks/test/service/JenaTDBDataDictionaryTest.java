package com.gsoc.freebase.wikilinks.test.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.gsoc.freebase.wikilinks.service.TrainingDataDictionary;
import com.gsoc.freebase.wikilinks.service.impl.JenaTDBDataDictionary;
import com.gsoc.freebase.wikilinks.service.model.TrainingDocument;

/**
 * <p>Test the JenaTDBDataDictionary class</p>
 * @author Antonio David Perez Morales <adperezmorales@gmail.com>
 *
 */
public class JenaTDBDataDictionaryTest
{
    private static final String modelName = "testModel";
    private static final String testTdbDirectory = "/tmp/wltesttdb";

    private static File tempDir;
    
    private TrainingDataDictionary dataDictionaryService;

    @BeforeClass
    public static void setUpClass() {
        tempDir = new File(testTdbDirectory);
        if(!tempDir.exists()) {
            System.out.println("Error setting up the WikiLinks TDB Directory");
            throw new RuntimeException("Error setting up the WikiLinks TDB Directory");
        }
    }
    
    @Before
    public void setUp() {
        dataDictionaryService = new JenaTDBDataDictionary(testTdbDirectory, modelName);
    }
    
    @After
    public void tearDown() {
        dataDictionaryService = null;
    }
    
    /**
     * <p>Test get disambiguation data</p>
     */
    @Test
    public void testGetDisambiguationData() {
        List<TrainingDocument> tds = dataDictionaryService.getDisambiguationData("01wk6k");
        assertEquals(3, tds.size());
    }
    
    /**
     * <p>Test get documents by word</p>
     */
    @Test
    public void testGetDocumentsByWord() {
        List<TrainingDocument> tds = dataDictionaryService.getDocumentsByWord("Trust");
        //WikiLinkTrainingDocument wd = (WikiLinkTrainingDocument) tds.get(0);
        assertEquals(174, tds.size());
    }
}
