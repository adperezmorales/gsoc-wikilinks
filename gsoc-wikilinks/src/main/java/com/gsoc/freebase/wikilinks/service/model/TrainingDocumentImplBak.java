package com.gsoc.freebase.wikilinks.service.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
public class TrainingDocumentImplBak
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
    private Map<String, List<String>> fields;

    /**
     * <p>
     * Default constructor
     * </p>
     */
    public TrainingDocumentImplBak()
    {
        this.fields = new HashMap<String, List<String>>();
    };

    /**
     * <p>Sets the id of the document</p>
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * <p>Gets the id of the document</p>
     * @return the id of the document
     */
    public String getId() {
        return this.id;
    }
    /**
     * <p>
     * Sets the document fields
     * </p>
     * 
     * @param fields the {@code Map} object containing the document fields
     */
    public void setFields(Map<String, List<String>> fields)
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
    public Map<String, List<String>> getFields()
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
    public void addField(String name, String value)
    {
        if (!this.fields.containsKey(name))
            this.fields.put(name, new ArrayList<String>());
        this.fields.get(name).add(value);
    }

    /**
     * <p>
     * Sets the values of a field
     * </p>
     * 
     * @param name the name of the field
     * @param values the values to be put
     */
    public void setField(String name, List<String> values)
    {
        this.fields.put(name, values);
    }

    /**
     * <p>
     * Sets the value of a field
     * </p>
     * 
     * @param name the name of the field
     * @param value the value to be put
     */
    public void setField(String name, String value)
    {
        List<String> values = new ArrayList<String>();
        values.add(value);
        this.fields.put(name, values);
    }

    /**
     * <p>
     * Gets the value of the field. If the field is a single value it returns the value. If the field is multivalued
     * then it returns the first value. Otherwise it returns null
     * </p>
     * 
     * @param name the name of the field
     * @return the value of the field or null if the field doesn't exists
     */
    public String getFieldValue(String name)
    {
        if(existsField(name) && this.fields.get(name).size() > 0) {
            return this.fields.get(name).get(0);
        }
        
        return null;
    }
    
    /**
     * <p>Gets the values of the field as {@code List}</p>
     * @param name the name of the field
     * @return the values of the field as list or null if the field doesn't exist
     */
    public List<String> getFieldValues(String name) {
        if(existsField(name))
            return this.fields.get(name);
        return null;
    }

    /**
     * <p>Checks if a field is multivalued</p>
     * @param name the name of the field
     * @return true if the field is multivalued and false otherwise
     */
    public boolean isMultivaluedField(String name) {
        return this.existsField(name) && this.fields.get(name).size() > 1;
    }
    
    /**
     * <p>Checks if a field exists</p>
     * @param name the name of the field
     * @return a {@code boolean} indicating whether the field exists or not
     */
    public boolean existsField(String name) {
        return this.fields.containsKey(name);
    }
    /**
     * <p>
     * Gets the name of fields in the document
     * </p>
     * 
     * @return a {@code Set} containing the name of the fields in the document
     */
    public Set<String> getFieldNames()
    {
        return this.fields.keySet();
    }

}
