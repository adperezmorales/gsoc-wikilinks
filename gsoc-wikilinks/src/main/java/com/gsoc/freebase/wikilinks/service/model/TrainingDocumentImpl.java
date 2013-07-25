package com.gsoc.freebase.wikilinks.service.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * Class representing a document with training information
 * </p>
 * 
 * @author Antonio David Perez Morales <adperezmorales@gmail.com>
 * 
 */
public class TrainingDocumentImpl implements TrainingDocument
{
    /**
     * The id of the document
     */
    private String id;
    /**
     * <p>
     * Holds the document fields
     * </p>
     */
    private Map<String, Object> fields;

    /**
     * <p>
     * Default constructor
     * </p>
     */
    public TrainingDocumentImpl()
    {
        this.fields = new HashMap<String, Object>();
    };

    /**
     * <p>Constructs a new TrainingDocument object with the specified id</p> 
     * @param id the id of the document
     */
    public TrainingDocumentImpl(String id)
    {
        this();
        this.id = id;
    }
    
    /**
     * <p>Constructs a new TrainingDocument object with the specified id and fields</p> 
     * @param id the id of the document
     * @param fields the fields to add to the document
     */
    public TrainingDocumentImpl(String id, Map<String, Object> fields) {
        this.id = id;
        this.fields = fields;
    }

    /**
     * <p>
     * Sets the id of the document
     * </p>
     * 
     * @param id the id to set
     */
    public void setId(String id)
    {
        this.id = id;
    }

    /**
     * <p>
     * Gets the id of the document
     * </p>
     * 
     * @return the id of the document
     */
    public String getId()
    {
        return this.id;
    }

    /**
     * <p>
     * Sets the document fields
     * </p>
     * 
     * @param fields the {@code Map} object containing the document fields
     */
    public void setFields(Map<String, Object> fields)
    {
        this.fields = fields;
    }

    /**
     * <p>
     * Gets the document fields
     * </p>
     * 
     * @return the {@code Map} object containing the document fields
     */
    public Map<String, Object> getFields()
    {
        return this.fields;
    }

    /**
     * <p>
     * Adds a new value to a field
     * </p>
     * 
     * @param name the name of the field
     * @param value the value to add to the field
     */
    public void addField(String name, Object value)
    {
        this.fields.put(name, value);

    }

    /**
     * <p>
     * Gets the value of the field
     * </p>
     * 
     * @param name the name of the field
     * @return the value of the field or null if the field doesn't exists
     */
    public Object getField(String name)
    {
        if (existsField(name))
        {
            return this.fields.get(name);
        }

        return null;
    }

    /**
     * <p>
     * Checks if a field exists
     * </p>
     * 
     * @param name the name of the field
     * @return a {@code boolean} indicating whether the field exists or not
     */
    public boolean existsField(String name)
    {
        return this.fields.containsKey(name);
    }

    /**
     * <p>
     * Gets the name of fields in the document
     * </p>
     * 
     * @return a unmodifiable {@code Set} containing the name of the fields in the document
     */
    public Set<String> getFieldNames()
    {
        return Collections.unmodifiableSet(this.fields.keySet());
    }

}
