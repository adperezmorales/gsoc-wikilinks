package com.gsoc.freebase.wikilinks.service;

import java.util.List;
import java.util.Set;

import com.gsoc.freebase.wikilinks.service.model.TrainingDocument;

/**
 * <p>Service interface used to retrieve information about entities</p>
 * @author Antonio David Perez Morales <adperezmorales@gmail.com>
 *
 */
public interface TrainingDataDictionary
{
    /**
     * <p>Gets a list of {@code TrainingDocuments} objects containing information about the entity</p>
     * <p>This information can be used as disambiguation information</p>
     * @param entityId the id of the entity to obtain information 
     * @return a {@code List} of TrainingDocument containing the requested information
     */
    public List<TrainingDocument> getDisambiguationData(String entityId);
    
    /**
     * <p>Gets a list of {@code TrainingDocuments} object which contains the given word</p>
     * @param word The word to search
     * @return a {@code List} of TrainingDocument containing the requested information
     */
    public List<TrainingDocument> getDocumentsByWord(String word);
    
    /**
     * <p>Gets a list of entity ids whose document which belong to contains the given word</p>
     * @param word The word to search
     * @return a {@code Set} of entity ids
     */
    public Set<String> getEntityIdsByWord(String word);
}
