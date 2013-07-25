package com.gsoc.freebase.wikilinks.service.model;

import java.util.ArrayList;
import java.util.List;

import com.gsoc.freebase.wikilinks.model.Mention;
import com.gsoc.freebase.wikilinks.model.PageContentItem;
import com.gsoc.freebase.wikilinks.model.RareWord;

/**
 * <p>
 * Class implementing TrainingDocument interface
 * </p>
 * 
 * @author Antonio David Perez Morales <adperezmorales@gmail.com>
 * 
 */
public class WikiLinkTrainingDocument extends TrainingDocumentImpl
{
    public static final String MENTIONS_FIELD = "mentions";

    public static final String RARE_WORDS_FIELD = "rare_words";

    public static final String PAGE_CONTENT_ITEM_FIELD = "page_content_item";

    public static final String URL_FIELD = "url";
    /**
     * <p>Default constructor</p>
     */
    public WikiLinkTrainingDocument()
    {
    }

    /**
     * <p>Creates a new instance with the specified id</p>
     * @param docId
     */
    public WikiLinkTrainingDocument(String docId)
    {
        super(docId);
    }

    /**
     * <p>
     * Gets the mentions of the document
     * </p>
     * 
     * @return a {@code List} of {@code Mentions}
     */
    @SuppressWarnings("unchecked")
    public List<Mention> getMentions()
    {
        return (List<Mention>) this.getField(MENTIONS_FIELD);
    }

    /**
     * <p>
     * Sets the mentions of the document
     * </p>
     * 
     * @param mentions a {@code List} of {@code Mention}
     */
    public void setMentions(List<Mention> mentions)
    {
        this.addField(MENTIONS_FIELD, mentions);
    }

    /**
     * <p>
     * Add a new mention to the document mentions
     * </p>
     * 
     * @param mention the {@code Mention} to add
     */
    public void addMention(Mention mention)
    {
        if (!this.existsField(MENTIONS_FIELD))
            this.getFields().put(MENTIONS_FIELD, new ArrayList<Mention>());

        @SuppressWarnings("unchecked")
        List<Mention> list = (List<Mention>) this.getFields().get(MENTIONS_FIELD);
        list.add(mention);
    }

    /**
     * <p>
     * Gets the rare words of the document
     * </p>
     * 
     * @return a {@code List} of {@code Mentions}
     */
    @SuppressWarnings("unchecked")
    public List<RareWord> getRareWords()
    {
        return (List<RareWord>) this.getField(RARE_WORDS_FIELD);
    }

    /**
     * <p>
     * Sets the rare words of the document
     * </p>
     * 
     * @param rareWords a {@code List} of {@code RareWord}
     */
    public void setRareWords(List<RareWord> rareWords)
    {
        this.addField(RARE_WORDS_FIELD, rareWords);
    }

    /**
     * <p>
     * Add a new rare word to the document words
     * </p>
     * 
     * @param rareWord the {@code RareWord} to add
     */
    public void addMention(RareWord rareWord)
    {
        if (!this.getFields().containsKey(RARE_WORDS_FIELD))
            this.getFields().put(RARE_WORDS_FIELD, new ArrayList<RareWord>());

        @SuppressWarnings("unchecked")
        List<RareWord> list = (List<RareWord>) this.getFields().get(RARE_WORDS_FIELD);
        list.add(rareWord);
    }

    /**
     * <p>
     * Gets the {@code PageContentItem} of the document
     * </p>
     * 
     * @return the {@code PageContentItem} or null if it doesn't exist
     */
    public PageContentItem getPageContentItem()
    {
        return (PageContentItem) this.getField(PAGE_CONTENT_ITEM_FIELD);
    }

    /**
     * <p>
     * Sets the {@code PageContentItem} of the document
     * </p>
     * 
     * @param pageContentItem the {@code PageContentItem} to set
     */
    public void setPageContentItem(PageContentItem pageContentItem)
    {
        this.addField(PAGE_CONTENT_ITEM_FIELD, pageContentItem);
    }
    
    /**
     * <p>Sets the url of the document</p>
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.addField(URL_FIELD, url);
    }
    
    /**
     * <p>Gets the url of the document</p>
     * @return the url of the document
     */
    public String getUrl() {
        return (String) this.getField(URL_FIELD);
    }
}
