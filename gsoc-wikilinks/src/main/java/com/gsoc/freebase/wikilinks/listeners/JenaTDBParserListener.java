package com.gsoc.freebase.wikilinks.listeners;

import com.gsoc.freebase.wikilinks.exception.WikiLinksException;
import com.hp.hpl.jena.query.Dataset;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.tdb.TDBFactory;

public class JenaTDBParserListener extends JenaModelInMemoryParserListener
{
    public static final String DEFAULT_TDB_NAME = "default";
    
    private Dataset dataset;
    
    private String tdbLocation;
    
    private String modelName;
    
    
    /**
     * <p>Default Constructor</p>
     * <p>Uses {@link DEFAULT_TDB_NAME} as model name</p>
     */
    public JenaTDBParserListener(String directory)
    {
        this(directory, DEFAULT_TDB_NAME);
    }
    
    /**
     * <p>Creates or connect to a TDB Dataset and uses the modelName parameter to create or connect to a model in the dataset</p>
     * @param directory The directory where to create the TDB dataset and model
     * @param modelName The name of the model to be generated
     */
    public JenaTDBParserListener(String directory, String modelName) {
        this.tdbLocation = directory;
        this.modelName = modelName;
        //createAndSetModel();
    }

    /**
     * <p>Creates or connect to a model from the {@code Dataset} instance using the model name, 
     * and sets the model to be used in the on onWikiLinkItemRead method</p>
     */
    private void createAndSetModel() {
        dataset = TDBFactory.createDataset(this.tdbLocation);
        Model model = dataset.getNamedModel(this.modelName);
        this.setModel(model);
    }
    
    @Override
    /**
     * <p>Creates or connect to an existing TDB Dataset</p>
     */
    public void onStartParsing(String filename)
    {
        this.createAndSetModel();
    }
    
    @Override
    /**
     * <p>Closes the dataset being used to commit the pending changes</p>
     */
    public void onParseFinished(String filename)
    {
        this.dataset.close();
    }
    
    /**
     * <p>Sets the location of the TDB dataset</p>
     * @param directory the directory to be used
     * @throws WikiLinksException if the directory doesn't satisfy the required permissions (it is a directory and is writable)
     */
    public void setTdbLocation(String directory) throws WikiLinksException {
        checkDirectory(directory);
        this.tdbLocation = directory;
    }
    
    /**
     * <p>Gets the location of the TDB dataset</p>
     * @return
     */
    public String getTdbLocation() {
        return this.tdbLocation;
    }
    
    /**
     * <p>Sets the name of the model to be used in the dataset</p>
     * @param modelName the name of the model
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    
    /**
     * <p>Gets the name of the model being used</p>
     * @return the name of the model
     */
    public String getModelName() {
        return this.modelName;
    }
    
}
