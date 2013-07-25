package com.gsoc.freebase.wikilinks.parser;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import org.apache.thrift.TBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gsoc.freebase.thrift.reader.ThriftReader;
import com.gsoc.freebase.wikilinks.interfaces.WikiLinksParserListener;
import com.gsoc.freebase.wikilinks.model.WikiLinkItem;

/**
 * <p>
 * WikiLinks parser
 * </p>
 * 
 * @author Antonio David Perez Morales <adperezmorales@gmail.com>
 * 
 */
public class WikiLinksParser
{
    /**
     * The logger
     */
    private Logger logger = LoggerFactory.getLogger(WikiLinksParser.class);

    /**
     * File containing the objects;
     */
    private File file;

    /**
     * The listener
     */
    private WikiLinksParserListener listener;

    /**
     * The creator for read objects
     */
    private WikiLinksCreator creator;

    /**
     * <p>
     * Default constructor
     * </p>
     * 
     * @param file the {@code File} instance
     */
    public WikiLinksParser(File file)
    {
        this.file = file;
        this.creator = new WikiLinksCreator();
    }

    /**
     * <p>
     * Builds an WikiLinksParser instance using the given file, listener and creator
     * </p>
     * 
     * @param file the {@code File} object containing the information
     * @param listener the {@code WikiLinksParserListener} to be used when a new WikiLinkItem is read
     */
    public WikiLinksParser(File file, WikiLinksParserListener listener)
    {
        this(file);
        this.listener = listener;
    }

    /**
     * <p>
     * Sets the listener to be executed when a new {@code WikiLinkItem} object is read
     * </p>
     * 
     * @param listener a {@code WikiLinksParserListener} instance to be used
     */
    public void setListener(WikiLinksParserListener listener)
    {
        this.listener = listener;
    }

    /**
     * <p>
     * Process the wiki links information
     * </p>
     * <p>
     * If the file is a directory, all files will be processed
     * </p>
     */
    public void process()
    {
        logger.info("Processing WikiLinks files");

        /**
         * Creating and initializing the reader
         */
        ThriftReader thriftReader = new ThriftReader(file);
        thriftReader.setCreator(this.creator);

        /*
         * Process the file
         */
        if (this.file.isDirectory())
        {
            logger.info(this.file + " is a directory. Processing directory");
            /*
             * Not process the files starting with dot
             */
            File[] files = this.file.listFiles(new FilenameFilter()
            {

                @Override
                public boolean accept(File dir, String name)
                {
                    if (name.startsWith("."))
                        return false;
                    else
                        return true;
                }
            });
            for (File f : files)
            {
                thriftReader.setFile(f);
                processFile(thriftReader, f);
            }
        }
        else
        {
            processFile(thriftReader, this.file);
        }

        try
        {
            thriftReader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    /**
     * <p>
     * Process the file
     * 
     * @param thriftReader
     */
    private void processFile(ThriftReader thriftReader, File f)
    {
        logger.info("Processing file " + f.getName());
        System.out.println("Processing file " + f.getName());
        try
        {
            if (this.listener != null)
                this.listener.onStartParsing(f.getName());

            thriftReader.open();
            while (thriftReader.hasNext())
            {
                WikiLinkItem wikiLinkItem = (WikiLinkItem) thriftReader.read();
                if (this.listener != null)
                    this.listener.onWikiLinkItemRead(wikiLinkItem);
            }

            thriftReader.close();
            logger.info("File " + f.getName() + " processed");
            System.out.println("File " + f.getName() + " processed");
            if (this.listener != null)
                this.listener.onParseFinished(f.getName());
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

   /**
     * <p>
     * WikiLinksCreator inner class responsible of creating WikiLinkItem instances to be used by {@link ThriftReader}
     * </p>
     * 
     * @author Antonio David Perez Morales <adperezmorales@gmail.com>
     * 
     */
    private class WikiLinksCreator implements ThriftReader.TBaseCreator
    {

        /**
         * <p>
         * Creates a new instance of WikiLinkItem to be populated
         * </p>
         */
        @Override
        public TBase create()
        {
            return new WikiLinkItem();
        }

    }

}
