package com.gsoc.freebase.wikilinks.ontology;

import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.impl.PropertyImpl;
import com.hp.hpl.jena.rdf.model.impl.ResourceImpl;

public class WikiLinksOntology
{

    public static final String WIKILINKITEM_URI = "http://edu.umass.cs.iesl.wikilinks/item/";
    public static final String WIKILINKITEM_PREFIX = "wli";

    public static final Property DOC_ID = new PropertyImpl(WIKILINKITEM_URI, "doc_id");

    public static final Property URL = new PropertyImpl(WIKILINKITEM_URI, "url");

    // content
    public static final Resource CONTENT = new ResourceImpl(WIKILINKITEM_URI, "content");
    // rare_words
    public static final Resource RARE_WORD = new ResourceImpl(WIKILINKITEM_URI, "rare_word");
    // mentions
    public static final Resource MENTION = new ResourceImpl(WIKILINKITEM_URI, "mention");

    /* Content Properties */
    public static final Property CONTENT_PROP = new PropertyImpl(WIKILINKITEM_URI, "content");
    public static final Property CONTENT_RAW = new PropertyImpl(WIKILINKITEM_URI, "raw");
    public static final Property CONTENT_FULL_TEXT = new PropertyImpl(WIKILINKITEM_URI, "full_text");
    public static final Property CONTENT_ARTICLE_TEXT = new PropertyImpl(WIKILINKITEM_URI, "article_text");
    public static final Property CONTENT_DOM = new PropertyImpl(WIKILINKITEM_URI, "dom");

    /* Rare_words Properties */
    public static final Property RARE_WORD_PROP = new PropertyImpl(WIKILINKITEM_URI, "rare_word");
    public static final Property RARE_WORD_WORD = new PropertyImpl(WIKILINKITEM_URI, "word");
    public static final Property RARE_WORD_OFFSET = new PropertyImpl(WIKILINKITEM_URI, "offset");
    
    /* Mention properties */
    public static final Property MENTION_PROP = new PropertyImpl(WIKILINKITEM_URI, "mention");
    public static final Property MENTION_WIKI_URL = new PropertyImpl(WIKILINKITEM_URI, "wiki_url");
    public static final Property MENTION_ANCHOR_TEXT = new PropertyImpl(WIKILINKITEM_URI, "anchor_text");
    public static final Property MENTION_RAW_TEXT_OFFSET = new PropertyImpl(WIKILINKITEM_URI, "raw_text_offset");
    public static final Property MENTION_FREEBASE_ID = new PropertyImpl(WIKILINKITEM_URI, "freebase_id");


}
