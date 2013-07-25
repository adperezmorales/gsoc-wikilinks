package com.gsoc.freebase.wikilinks.main;

import java.io.File;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

import com.gsoc.freebase.wikilinks.interfaces.WikiLinksParserListener;
import com.gsoc.freebase.wikilinks.listeners.JenaTDBParserListener;
import com.gsoc.freebase.wikilinks.parser.WikiLinksParser;

/**
 * <p>
 * Main class to parse WikiLinks extended dataset and generate a Jena TDB database
 * </p>
 * 
 * @author Antonio David Perez Morales <adperezmorales@gmail.com>
 * 
 */
public class Main
{
    public static final String JAR_NAME = "gsoc-wikilinks-{*}-jar-with-dependencies.jar";
    private static final Options options;
    static
    {
        options = new Options();
        options.addOption("h", "help", false, "display this help and exit");
        options.addOption("i", "inputDirectory", true,
                "the WikiLinks dataset file to be processed or the input directory containing the WikiLinks extended dataset files");
        options.addOption("o", "outputDirectory", true, "the output directory where the Jena TDB wil be generated");

    }

    /**
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException
    {
        CommandLineParser parser = new PosixParser();
        CommandLine cmd = parser.parse(options, args);

        if (cmd.hasOption("h") || args.length <= 0)
        {
            printHelp();
            System.exit(0);
        }

        if (!cmd.hasOption("i") && cmd.getOptionValue("i").equals(""))
        {
            System.out.println("The parameter i is missing or the value is empty");
            System.exit(0);
        }

        if (!cmd.hasOption("o") && cmd.getOptionValue("o").equals(""))
        {
            System.out.println("The parameter o is missing or the value is empty");
            System.exit(0);
        }

        String inputDirectory = cmd.getOptionValue("i");
        String outputDirectory = cmd.getOptionValue("o");

        // Checking if the inputs are directories
        File inputDir = new File(inputDirectory);
        File outputDir = new File(outputDirectory);

        if (inputDir.isFile())
        {
            System.out.println(inputDirectory + " is a file. Please enter a valid directory");
            System.exit(0);
        }

        if (outputDir.isFile())
        {
            System.out.println(outputDirectory + " is a file. Please enter a valid directory");
            System.exit(0);
        }

        if (!inputDir.exists())
        {
            System.out.println(inputDirectory + " doesn't exist. Please enter a valid directory");
            System.exit(0);
        }

        if (!outputDir.exists())
        {
            System.out.println(outputDirectory + " doesn't exist. Trying to create the directory");
            if (!outputDir.mkdirs())
            {
                System.out.println("Could not create the directory. Please create manually the directory or execute the script with more privileges");
                System.exit(0);
            }
            System.out.println(outputDirectory + " created succesfully");
        }

        WikiLinksParser wlParser = new WikiLinksParser(inputDir);
        WikiLinksParserListener listener = new JenaTDBParserListener(outputDirectory);
        wlParser.setListener(listener);

        /* Run the parser process */
        wlParser.process();

        System.out.println("Parser process finished");
        System.exit(0);
    }

    /**
     * <p>
     * Print the help
     * </p>
     */
    private static void printHelp()
    {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("java -Xmx{size} -jar " + JAR_NAME + " [options] \n",
                "Wikilinks Extended Dataset Parsing Utility \n", options, null);
    }

}
