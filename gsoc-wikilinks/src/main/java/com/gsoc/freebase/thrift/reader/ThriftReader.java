package com.gsoc.freebase.thrift.reader;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.thrift.TBase;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TIOStreamTransport;

/**
 * <p>
 * Class to read Thrift files
 * </p>
 * 
 * @author Antonio David Perez Morales <adperezmorales@gmail.com>
 * 
 */
public class ThriftReader
{
    private static final String GZ_EXT = "gz";

    /**
     * <p>
     * Thrift deserializes by taking an existing object and populating it. ThriftReader needs a way of obtaining
     * instances of the class to be populated and this interface defines the mechanism by which a client provides these
     * instances.
     * </p>
     */
    public interface TBaseCreator
    {
        TBase create();
    }

    /**
     * <p>
     * Listener interface to called when an object has been read and desereialized by Thrift
     * </p>
     * 
     * @author Antonio David Perez Morales <adperezmorales@gmail.com>
     * 
     */
    public static interface ThriftReaderListener
    {
        public void onObjectRead(TBase object);
    }

    /**
     * File containing the objects.
     */
    protected File file;

    /**
     * Used to create empty objects that will be initialized with values from the file.
     */
    protected TBaseCreator creator;

    /**
     * Buffer For reading the file.
     */
    private BufferedInputStream bufferedIn;

    /**
     * For reading the binary thrift objects.
     */
    private TBinaryProtocol binaryIn;

    /**
     * Listener for read Thrift objects
     */
    private ThriftReaderListener listener;

    /**
     * <p>
     * Default constructor
     * </p>
     */
    public ThriftReader(File file)
    {
        this.file = file;
    }

    /**
     * <p>
     * Constructor with file and creator
     * </p>
     * 
     * @param file the {@code File} object to be read
     * @param creator the {@code TBaseCreator} instance
     */
    public ThriftReader(File file, TBaseCreator creator)
    {
        this.file = file;
        this.creator = creator;
    }

    /**
     * <p>Sets the file to use</p>
     * <p>It closes the current buffer if open, so it's necessary to recall open before read</p>
     * @param file
     */
    public void setFile(File file) {
        this.file = file;
        if(isOpen())
            try
            {
                bufferedIn.close();
                bufferedIn = null;
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        
    }
    /**
     * <p>
     * Opens the file for reading. Must be called before {@link read()}.
     * </p>
     * <p>
     * It supports files compressed by gzip
     * </p>
     * 
     * @throws IOException
     */
    public void open() throws IOException
    {
        bufferedIn = FilenameUtils.getExtension(file.getName()).equals(GZ_EXT) ? new BufferedInputStream(
                new GZIPInputStream(new FileInputStream(file)), 2048) : new BufferedInputStream(new FileInputStream(
                file), 2048);
        binaryIn = new TBinaryProtocol(new TIOStreamTransport(bufferedIn));
    }

    /**
     * <p>
     * Checks if another objects is available by attempting to read another byte from the stream
     * </p>
     */
    public boolean hasNext() throws IOException
    {
        bufferedIn.mark(1);
        int val = bufferedIn.read();
        bufferedIn.reset();
        return val != -1;
    }

    /**
     * <p>
     * Reads the next object from the file
     * </p>
     */
    public TBase read() throws IOException
    {
        TBase t = creator.create();
        try
        {
            t.read(binaryIn);
        }
        catch (TException e)
        {
            throw new IOException(e);
        }

        /*
         * Calls the listener before returning the object
         */
        if (listener != null)
            listener.onObjectRead(t);

        return t;
    }

    /**
     * <p>
     * Close the file.
     * </p>
     */
    public ThriftReader close() throws IOException
    {
        bufferedIn.close();
        return this;
    }

    public void setCreator(TBaseCreator creator)
    {
        this.creator = creator;
    }

    /**
     * <p>
     * Sets the listener
     * </p>
     * 
     * @param listener a {@code ThriftReaderListener} instance
     */
    public void setListener(ThriftReaderListener listener)
    {
        this.listener = listener;
    }

    /**
     * <p>
     * Checks whether the reader has been initialized, that is to say, if the creator attribute has been set
     * </p>
     * 
     * @return a {@code Boolean} indicating whether the reader has been initialized or not
     */
    public boolean isInitialized()
    {
        return this.creator != null;
    }
    
    /**
     * <p>Checks whether the reader is already open</p>
     * @return a {@code Boolean} indicating whether the reader is open or not
     */
    public boolean isOpen() {
        return this.bufferedIn != null;
    }

}
