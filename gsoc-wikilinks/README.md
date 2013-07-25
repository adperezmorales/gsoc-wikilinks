# WikiLinks Parser and Jena TDB Generator #

WikiLinks Parser and TDB Generator using the [WikiLinks extended dataset][1] serialized with [Apache Thrift][2]

The aim of this tool is to create a [Jena TDB Database][3] with the information of the dataset in order to be used in other tasks like Entity Tagging, Entity Disambiguation, Entity Linking etc.  

Moreover this tool provides a service to query and retrieve such information.

## How to use the parser ##

In order to use the Wikilinks parser tool to create the Jena TDB database, do the following:

1. Download the code
2. Run `'mvn package'` command
3. In the *target/* directory, run the command `java -Xmx1g -jar gsoc-wikilinks-{version}-jar-with-dependencies.jar`. It will show the help.

The tool supports the following params:

* -h,--help                   Display this help and exit  

* -i,--inputDirectory <arg>   The WikiLinks dataset file to be processed
                              or the input directory containing the
                              WikiLinks extended dataset files
* -o,--outputDirectory <arg>  The output directory where the Jena TDB wil
                              be generated

In order to parse and create a Jena TDB database, the command to be run is:  
`java -Xmx1g -jar gsoc-wikilinks-{version}-jar-with-dependencies.jar -i "input_directory" -o "output_directory" -g -r`

It will create a Jena TDB database in the output directory which will can be queried in order to obtain the information

## How to use the service to query the data ##

### Add the dependency ###

This library must be included in your projects as a dependency. Here there are several options: 

* Compile the library and use the jar as dependency  
* Download the code and execute `mvn install` command to install the library in your local repository. Then add the maven dependency to your project.  

The dependency information is as follow: 

    <dependency>  
        <groupId>com.gsoc.freebase</groupId>  
        <artifactId>gsoc-wikilinks</artifactId>  
        <version>1.0-SNAPSHOT</version>  
    </dependency>

### Use the service ###

The library provides the interface *TrainingDataDictionary* which exposes methods for:

* getDisambiguationData(String entityId) : returns a list of *TrainingDocument* for the entityId passed as parameter
* getDocumentsByWord(String word) : returns a list of *TrainingDocument* objects containing the word passed as parameter
* getEntityIdsByWord(String word) : return a list of entity ids (*String*) which contain the word passed as parameter

Moreover it provides an implementation of it, called *JenaTDBDataDictionary* which uses the TDB created with the parser to query the information.

This implementation creates *WikiLinkTrainingDocument* objects which are returned as *TrainingDocument* (the interface). So to take advantage of the information contained in the *WikiLinkTrainingDocument*, these objects need to be casted to a *WikiLinkTrainingDocument*.  

**Example:** 


    TrainingDataDictionary dictionaryService = new JenaTDBDataDictionary("/dir/to/jenatdb");

    List<TrainingDocument> docs = dictionaryService.getDisambiguationData("04n7dpf"); // where "04n7dpf" is the freebase id of the searched entity disambiguation data

    System.out.println(docs.size()); // print the number of returned documents

    List<TrainingDocument> docWords = dictionaryService.getDocumentsByWord("Guinness");

    System.out.println(docWords.size());

    // Get the first training document
    TrainingDocument td = docs.get(0);

    // Pass to a WikiLinkTrainingDocument because JenaTDBDataDictionary generates this type of objects
    WikiLinkTrainingDocument wtd = (WikiLinkTrainingDocument) td;

    // Get the mentions of this WikiLink item
    List<Mention> mentions = wtd.getMentions();


## License

GSoC WikiLinks Parser is distributed under the terms of the [Apache License, 2.0](http://www.apache.org/licenses/LICENSE-2.0.html).

[1]: http://www.iesl.cs.umass.edu/data/wiki-links
[2]: http://blueprints.tinkerpop.com
[3]: http://jena.apache.org/documentation/tdb/
