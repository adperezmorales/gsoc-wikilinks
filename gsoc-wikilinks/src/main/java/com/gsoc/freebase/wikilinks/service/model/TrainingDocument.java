package com.gsoc.freebase.wikilinks.service.model;

import java.util.Map;
import java.util.Set;

/**
 * <p>
 * Interface representing a document with training information
 * </p>
 * 
 * @author Antonio David Perez Morales <adperezmorales@gmail.com>
 * 
 */
public interface TrainingDocument
{

    /**
     * <p>Sets the id of the document</p>
     * @param id the id to set
     */
    public void setId(String id);
    
    
    
    /**
     * <p>Gets the id of the document</p>
     * @return the id of the document
     */
    public String getId();
    
    
    /**
     * <p>
     * Sets the document fields
     * </p>
     * 
     * @param fields the {@code Map} object containing the document fields
     */
    public void setFields(Map<String, Object> fields);
    

    /**
     * <p>
     * Gets the document fields
     * </p>
     * 
     * @return the {@code Map} object containing the document fields
     */
    public Map<String, Object> getFields();

    /**
     * <p>
     * Adds a new value to a field
     * </p>
     * 
     * @param name the name of the field
     * @param value the value to add to the field
     */
    public void addField(String name, Object value);
    
    /**
     * <p>
     * Gets the value of the field
     * </p>
     * @param name the name of the field
     * @return the value of the field or null if the field doesn't exists
     */
    public Object getField(String name);
    
  
    /**
     * <p>Checks if a field exists</p>
     * @param name the name of the field
     * @return a {@code boolean} indicating whether the field exists or not
     */
    public boolean existsField(String name);
    
    /**
     * <p>
     * Gets the name of fields in the document
     * </p>
     * 
     * @return a {@code Set} containing the name of the fields in the document
     */
    public Set<String> getFieldNames();

}
