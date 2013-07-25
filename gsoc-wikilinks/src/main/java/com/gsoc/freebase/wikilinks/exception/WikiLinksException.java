package com.gsoc.freebase.wikilinks.exception;

/**
 * <p>
 * WikiLinksException class
 * </p>
 * 
 * @author Antonio David Perez Morales <adperezmorales@gmail.com>
 * 
 */
public class WikiLinksException extends Exception
{

    /**
     * <p>
     * Serial Version UID
     * </p>
     */
    private static final long serialVersionUID = 3597628998889348425L;

    public WikiLinksException(String message)
    {
        super(message);
    }

    public WikiLinksException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public WikiLinksException(Throwable cause)
    {
        super(cause);
    }
}
