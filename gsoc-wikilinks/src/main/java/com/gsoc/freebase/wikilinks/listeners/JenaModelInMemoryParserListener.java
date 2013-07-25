package com.gsoc.freebase.wikilinks.listeners;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

import com.gsoc.freebase.wikilinks.exception.WikiLinksException;
import com.gsoc.freebase.wikilinks.interfaces.WikiLinksParserListener;
import com.gsoc.freebase.wikilinks.model.Mention;
import com.gsoc.freebase.wikilinks.model.RareWord;
import com.gsoc.freebase.wikilinks.model.WikiLinkItem;
import com.gsoc.freebase.wikilinks.ontology.WikiLinksOntology;
import com.gsoc.freebase.wikilinks.utils.WikiLinksUtils;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.impl.PropertyImpl;

/**
 * <p>Jena-based listener which creates a new Jena Model with the parsed WikiLinks</p>
 * @author Antonio David Perez Morales <adperezmorales@gmail.com>
 *
 */
public class JenaModelInMemoryParserListener implements WikiLinksParserListener
{
    /**
     * The model
     */
    private Model model;

    /**
     * The directory where to save the generated model
     */
    private String outputModelDir;
    
    /**
     * Whether to encode the generated file as GZip or not
     */
    private boolean encodeGzip;
    
    /**
     * <p>Default constructor</p>
     * <p>The model, output directory and the encodeGzip must be set using the setter methods</p>
     */
    public JenaModelInMemoryParserListener() {}
    
    /**
     * <p>Generates the default model</p>
     * 
     * @param outputModel a {@code String} containing the path where the model will be stored once the parsing is finished
     * @param encodeGzip a {@code boolean} indicating whether the generated file will be gzip-encoded or not
     * @throws WikiLinksException 
     */
    public JenaModelInMemoryParserListener(String outputModelDir, boolean encodeGzip) throws WikiLinksException
    {
        checkDirectory(outputModelDir);
        
        this.outputModelDir = outputModelDir;
        this.encodeGzip = encodeGzip;
        this.createModel();
    }
    
    /**
     * <p>Default constructor</p>
     * <p>Generates the default model</p>
     * <p>By default, it sets the flag to encode as GZip the generated model
     * 
     * @param outputModel a {@code String} containing the path where the model will be stored once the parsing is finished
     * @throws WikiLinksException 
     */
    public JenaModelInMemoryParserListener(String outputModelDir) throws WikiLinksException
    {
        this(outputModelDir, true);
    }

    /**
     * <p>Checks if the given directory fulfills the required permissions</p>
     * @param directory the directory to be checked
     * @throws WikiLinksException
     */
    protected void checkDirectory(String directory) throws WikiLinksException {
        File f = new File(directory);
        if(!f.isDirectory())
            throw new WikiLinksException("The supplied path is not a valid directory");
        if(!f.canWrite())
            throw new WikiLinksException("The directory is not writable");
    }
    
    /**
     * <p>Initializes the {@code Model} object to be used</p>
     */
    private void createModel() {
        this.model = ModelFactory.createDefaultModel();
        this.model.setNsPrefix(WikiLinksOntology.WIKILINKITEM_PREFIX, WikiLinksOntology.WIKILINKITEM_URI);
    }
    
    /**
     * <p>Called when a WikiLinkItem is read</p>
     * <p>Creates a new resource for this WikiLink item in the model</p>
     */
    public void onWikiLinkItemRead(WikiLinkItem item)
    {
        if(item.doc_id == 0)
            return;
        Resource wikiLink = model.createResource(WikiLinksOntology.WIKILINKITEM_URI + item.getDoc_id());
        wikiLink.addProperty(WikiLinksOntology.DOC_ID, String.valueOf(item.getDoc_id()));
        if(item.getUrl() != null)
            wikiLink.addProperty(WikiLinksOntology.URL, item.getUrl());
        int i = 0;
        for (RareWord r : item.getRare_words())
        {
            i++;
            Resource rareWord = model.createResource(WikiLinksOntology.WIKILINKITEM_URI + item.getDoc_id()
                    + "/rare_word/" + i);
            rareWord.addProperty(WikiLinksOntology.RARE_WORD_WORD, r.getWord());
            rareWord.addProperty(WikiLinksOntology.RARE_WORD_OFFSET, String.valueOf(r.getOffset()));
            wikiLink.addProperty(new PropertyImpl(WikiLinksOntology.WIKILINKITEM_URI, "rare_word"), rareWord);
        }

        i = 0;
        for (Mention m : item.getMentions())
        {

            if (m.getFreebase_id() != null)
            {
                i++;
                Resource mention = model.createResource(WikiLinksOntology.WIKILINKITEM_URI + item.getDoc_id()
                        + "/mention/" + i);
                mention.addProperty(WikiLinksOntology.MENTION_ANCHOR_TEXT, m.getAnchor_text());
                mention.addProperty(WikiLinksOntology.MENTION_RAW_TEXT_OFFSET, String.valueOf(m.getRaw_text_offset()));
                String freebaseId = m.getFreebase_id();
                String mId = WikiLinksUtils.convertFreebaseId(freebaseId, false);

                mention.addProperty(WikiLinksOntology.MENTION_FREEBASE_ID, mId);
                mention.addProperty(WikiLinksOntology.MENTION_WIKI_URL, m.getWiki_url());
                wikiLink.addProperty(new PropertyImpl(WikiLinksOntology.WIKILINKITEM_URI, "mention"), mention);

            }
        }

    }

    /**
     * <p>Gets the current model</p>
     * @return the current {@code Model}
     */
    public Model getModel()
    {
        return this.model;
    }

    /**
     * <p>Sets the model to use</p>
     * @param model the {@code Model} to use
     */
    public void setModel(Model model)
    {
        this.model = model;
    }

    /**
     * <p>Sets the flag indicating whether to encode the output as GZip or not</p>
     * @param encode indicating whether to encode or not
     */
    public void setEncodeGzip(boolean encode) {
        this.encodeGzip = encode;
    }
    
    /**
     * <p>Gets the flag indicating whether the output must be GZip-encoded or not</p>
     * @return a {@code boolean} indicating whether to encoded the output as GZip or not
     */
    public boolean getEncodeGzip() {
        return this.encodeGzip;
    }
    
    /**
     * <p>Sets the output directory where the generated model will be stored</p>
     * @param dir the directory
     * @throws WikiLinksException if the dir parameter is not a directory or it can be written
     */
    public void setOutputDirectory(String dir) throws WikiLinksException {
        checkDirectory(dir);
        this.outputModelDir = dir;
    }
    
    /**
     * <p>Gets the output directory where the generated model will be stored</p>
     * @return the current output directory
     */
    public String getOutputDirectory() {
        return this.outputModelDir;
    }
    
    /**
     * <p>Called when the parsing of a file starts</p>
     * 
     * @param filename the {@code String} filename to be parsed
     */
    public void onStartParsing(String filename)
    {
        createModel();
    }

    /**
     * <p>Called when the parsing of a file finishes</p>
     * <p>Creates a file with the RDF representation of the model</p>
     * <p>The name of the generated file will be the same as the one processed</p>
     * 
     * @param filename the parsed filename
     */
    public void onParseFinished(String filename)
    {
        
        String outputFile = this.outputModelDir+File.separator+filename.substring(0, filename.lastIndexOf("."))+".rdf";
        outputFile += this.encodeGzip ? ".gz" : "";
        
        OutputStream os;
        try
        {
            os = this.encodeGzip ? new GZIPOutputStream(new FileOutputStream(new File(outputFile))) : new FileOutputStream(outputFile);
            this.model.write(os);
            this.model.close();
            os.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
         
    }
    
}
