package com.gsoc.freebase.wikilinks.service.builder;

import java.util.ArrayList;
import java.util.List;

import com.gsoc.freebase.wikilinks.model.Mention;
import com.gsoc.freebase.wikilinks.model.PageContentItem;
import com.gsoc.freebase.wikilinks.model.RareWord;
import com.gsoc.freebase.wikilinks.ontology.WikiLinksOntology;
import com.gsoc.freebase.wikilinks.service.model.WikiLinkTrainingDocument;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;

/**
 * <p>
 * Builder class to generate {@code WikiLinkTrainingDocument} instances
 * </p>
 * 
 * @author Antonio David Perez Morales <adperezmorales@gmail.com>
 * 
 */
public class WikiLinkTrainingDocumentBuilder
{

    /**
     * <p>Builds a new {@code WikiLinkTrainingDocument} instance from a Jena Resource</p>
     * @param resource the resource containing the information of the document
     * @return the generated WikiLinkTrainingDocument object 
     */
    public static WikiLinkTrainingDocument build(Resource resource)
    {
        WikiLinkTrainingDocument doc = new WikiLinkTrainingDocument();
        doc.setId(resource.getProperty(WikiLinksOntology.DOC_ID).getString());
        doc.setUrl(resource.getProperty(WikiLinksOntology.URL).getString());

        doc.setRareWords(processRareWords(resource));
        doc.setMentions(processMentions(resource));
        doc.setPageContentItem(processPageContentItem(resource));

        return doc;
    }

    /**
     * <p>
     * Process the rare words of a WikiLink item represented as {@code Resource}
     * </p>
     * 
     * @param resource the Resource which to extract the rare words from
     * @return a {@code List<RareWord>} containing the rare words of an WikiLink item
     */
    private static List<RareWord> processRareWords(Resource resource)
    {
        StmtIterator stmtIt = resource.listProperties(WikiLinksOntology.RARE_WORD_PROP);
        List<RareWord> rw = new ArrayList<RareWord>();

        while (stmtIt.hasNext())
        {
            Statement statement = stmtIt.next();
            Resource rareWordResource = resource.getModel().getResource(statement.getObject().asResource().getURI());
            RareWord rareWord = new RareWord();
            rareWord.setWord(rareWordResource.getProperty(WikiLinksOntology.RARE_WORD_WORD).getString());
            rareWord.setOffset(rareWordResource.getProperty(WikiLinksOntology.RARE_WORD_OFFSET).getInt());
            rw.add(rareWord);
        }
        
        return rw;
    }

    /**
     * <p>
     * Process the mentions of a WikiLink item represented as {@code Resource}
     * </p>
     * 
     * @param resource the Resource which to extract the mentions from
     * @return a {@code List<Mention>} containing the mentions of an WikiLink item
     */
    private static List<Mention> processMentions(Resource resource)
    {
        List<Mention> mentions = new ArrayList<Mention>();
        StmtIterator stmtIt = resource.listProperties(WikiLinksOntology.MENTION_PROP);
        while(stmtIt.hasNext()) {
            Statement statement = stmtIt.next();
            Resource mentionResource = resource.getModel().getResource(statement.getObject().asResource().getURI());
            Mention mention = new Mention();
            mention.setAnchor_text(mentionResource.getProperty(WikiLinksOntology.MENTION_ANCHOR_TEXT).getString());
            mention.setFreebase_id(mentionResource.getProperty(WikiLinksOntology.MENTION_FREEBASE_ID).getString());
            mention.setRaw_text_offset(mentionResource.getProperty(WikiLinksOntology.MENTION_RAW_TEXT_OFFSET).getInt());
            mention.setWiki_url(mentionResource.getProperty(WikiLinksOntology.MENTION_WIKI_URL).getString());
            //TODO add mention context when the wikilinks extended dataset contains the context of the mentions
            mentions.add(mention);
        }
        
        return mentions;
    }

    /**
     * <p>
     * Process the PageContentItem of a WikiLink item represented as {@code Resource}
     * </p>
     * 
     * @param resource the Resource which to extract the page content item from
     * @return a {@code List<RareWord>} containing the rare words of an WikiLink item
     */
    private static PageContentItem processPageContentItem(Resource resource)
    {
        //TODO when the wikilinks extended dataset contains the page content item
        return null;
    }

}
