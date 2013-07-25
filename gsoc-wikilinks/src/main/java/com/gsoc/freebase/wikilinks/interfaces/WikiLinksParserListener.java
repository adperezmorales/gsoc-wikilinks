package com.gsoc.freebase.wikilinks.interfaces;

import com.gsoc.freebase.wikilinks.model.WikiLinkItem;

/**
 * <p>Interface used to receive read {@code WikiLinkItem} objects</p>
 * @author Antonio David Perez Morales <adperezmorales@gmail.com>
 *
 */
public interface WikiLinksParserListener
{

    /**
     * <p>Called when a WikiLinkItem object is read by the parser</p>
     * @param item the read {@code WikiLinkItem} instance
     */
    public void onWikiLinkItemRead(WikiLinkItem item);
   
    /**
     * <p>Called when the parsing of a file starts</p>
     */
    public void onStartParsing(String filename);
    
    /**
     * <p>Called when the parsing of a file finishes
     */
    public void onParseFinished(String filename);
}
