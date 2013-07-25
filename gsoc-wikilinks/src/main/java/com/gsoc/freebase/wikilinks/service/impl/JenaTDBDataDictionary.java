package com.gsoc.freebase.wikilinks.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.gsoc.freebase.wikilinks.listeners.JenaTDBParserListener;
import com.gsoc.freebase.wikilinks.ontology.WikiLinksOntology;
import com.gsoc.freebase.wikilinks.service.TrainingDataDictionary;
import com.gsoc.freebase.wikilinks.service.builder.WikiLinkTrainingDocumentBuilder;
import com.gsoc.freebase.wikilinks.service.model.TrainingDocument;
import com.gsoc.freebase.wikilinks.service.model.WikiLinkTrainingDocument;
import com.hp.hpl.jena.query.Dataset;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ResIterator;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.tdb.TDBFactory;

/**
 * <p>
 * Implementation of {@code TrainingDataDictionary} interface using Jena TDB as backend
 * </p>
 * 
 * @author Antonio David Perez Morales <adperezmorales@gmail.com>
 * 
 */
public class JenaTDBDataDictionary implements TrainingDataDictionary
{
    private String tdbDirectory;

    private String modelName;

    private Dataset dataset;

    private Model model;

    /**
     * <p>
     * Constructor
     * </p>
     * 
     * @param tdbDirectory the directory where Jena TDB is located
     * @param name the name of the model to be used
     */
    public JenaTDBDataDictionary(String tdbDirectory, String modelName)
    {
        this.tdbDirectory = tdbDirectory;
        this.modelName = modelName;

        initDatasetAndModel();
    }

    /**
     * <p>
     * Constructor. It uses the default name for the model ('default')
     * </p>
     * 
     * @param tdbDirectory the directory where Jena TDB is located
     */
    public JenaTDBDataDictionary(String tdbDirectory)
    {
        this.tdbDirectory = tdbDirectory;
        this.modelName = JenaTDBParserListener.DEFAULT_TDB_NAME;

        initDatasetAndModel();
    }

    /**
     * <p>
     * Initializes the Jena TDB Dataset and Model to be used in subsequent searches
     * </p>
     */
    private void initDatasetAndModel()
    {
        this.dataset = TDBFactory.createDataset(this.tdbDirectory);
        this.model = dataset.getNamedModel(this.modelName);
    }

    /**
     * <p>
     * Gets a list of {@code TrainingDocuments} objects containing information about the freebase entity id
     * </p>
     * <p>
     * This information can be used as disambiguation information
     * </p>
     * 
     * @param freebaseEntityId the freebase entity id (the part after the /m/ in the freebase URI)
     * @return a list of {@code TrainingDocument}
     */
    public List<TrainingDocument> getDisambiguationData(String freebaseEntityId)
    {
        /*
         * Initializes the dataset and model in case the model has been closed
         */
        if (this.model.isClosed())
            initDatasetAndModel();

        List<TrainingDocument> docs = new ArrayList<TrainingDocument>();

        ResIterator resIt = this.model.listSubjectsWithProperty(WikiLinksOntology.MENTION_FREEBASE_ID, freebaseEntityId);

        while (resIt.hasNext())
        {
            Resource res = resIt.next();
            ResIterator subIt = this.model.listSubjectsWithProperty(WikiLinksOntology.MENTION_PROP, res);

            while (subIt.hasNext())
            {
                Resource resDoc = subIt.next();
                WikiLinkTrainingDocument doc = WikiLinkTrainingDocumentBuilder.build(resDoc);
                docs.add(doc);
            }
        }

        return docs;
    }

    /**
     * <p>
     * Gets a list of {@code TrainingDocuments} object which contains the given word
     * </p>
     * 
     * @param word The word to search
     * @return a {@code List} of TrainingDocument containing the requested information
     */
    public List<TrainingDocument> getDocumentsByWord(String word)
    {
        /*
         * Initializes the dataset and model in case the model has been closed
         */
        if (this.model.isClosed())
            initDatasetAndModel();

        List<TrainingDocument> docs = new ArrayList<TrainingDocument>();

        ResIterator resIt = this.model.listSubjectsWithProperty(WikiLinksOntology.RARE_WORD_WORD, word);

        while (resIt.hasNext())
        {
            Resource res = resIt.next();
            ResIterator subIt = this.model.listSubjectsWithProperty(WikiLinksOntology.RARE_WORD_PROP, res);

            while (subIt.hasNext())
            {
                Resource resDoc = subIt.next();
                WikiLinkTrainingDocument doc = WikiLinkTrainingDocumentBuilder.build(resDoc);
                docs.add(doc);
            }
        }

        return docs;
    }

    /**
     * <p>
     * Given a word, it obtains the documents containing the word and then returns the freebase id of the mentions in
     * the document
     * </p>
     * 
     * @param word The word to search
     * @return a {@code List} of freebase ids
     */
    public Set<String> getEntityIdsByWord(String word)
    {
        /*
         * Initializes the dataset and model in case the model has been closed
         */
        if (this.model.isClosed())
            initDatasetAndModel();

        Set<String> ids = new TreeSet<String>();

        String queryString = "PREFIX " + WikiLinksOntology.WIKILINKITEM_PREFIX + ": <"
                + WikiLinksOntology.WIKILINKITEM_URI + "> SELECT DISTINCT ?m WHERE { ?x "
                + WikiLinksOntology.WIKILINKITEM_PREFIX + ":word '" + word + "' . ?y "
                + WikiLinksOntology.WIKILINKITEM_PREFIX + ":rare_word ?x ." + "?y "
                + WikiLinksOntology.WIKILINKITEM_PREFIX + ":mention ?m }";

        Query query = QueryFactory.create(queryString);

        QueryExecution qe = QueryExecutionFactory.create(query, this.model);

        ResultSet rs = qe.execSelect();

        while (rs.hasNext())
        {
            QuerySolution qs = rs.next();
            Resource resource = qs.getResource("m");
            String freebaseId = resource.getProperty(WikiLinksOntology.MENTION_FREEBASE_ID).getString();
            ids.add(freebaseId);
        }

        return ids;

    }

}
