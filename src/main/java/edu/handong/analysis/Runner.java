package edu.handong.analysis;

import java.io.File;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

//-fullpath -v -p /Users/eyuuo/Documents/
public class Runner {
	
	String input;
	String output;
	String analysis;
	boolean coursecode;
	boolean startyear;
	boolean endyear;
	boolean help;



	public void runOption(String[] args) {
		String[] arg = new String[2];
		Options options = createOptions();
		
		if(parseOptions(options, args)){
			if (help){
				printHelp(options);
				return;
			}
			
			arg[0]= input;
			arg[1]= output;
			
			HGUCoursePatternAnalyzer analyzer = new HGUCoursePatternAnalyzer();
			analyzer.run(arg);
			
			
			System.out.println("analysis number is " +analysis);
			System.out.println("input is " +arg[0]);
			System.out.println("output number is " +arg[1]);
 			
			if(analysis.equals("2")){
				if(coursecode) {
					System.out.println("This is coursecode option\n");
				}	
			}
			
			
			if(startyear) {
				System.out.println("This is startyear option\n");
			}
			
			if(endyear) {
				System.out.println("This is endyear option\n");
			}
	
			
		}
	}

	private boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();

		try {

			CommandLine cmd = parser.parse(options, args);
			
			analysis= cmd.getOptionValue("a");
			input= cmd.getOptionValue("i");
			output = cmd.getOptionValue("o");
			coursecode= cmd.hasOption("c");
			startyear= cmd.hasOption("s");
			endyear = cmd.hasOption("e");
			help = cmd.hasOption("h");

			
		} catch (Exception e) {
			printHelp(options);
			return false;
		}

		return true;
	}

	// Definition Stage
	private Options createOptions() {
		Options options = new Options();

		// add options by using OptionBuilder
		options.addOption(Option.builder("a").longOpt("analysis")
				.desc("1: Count courses per semester, \n2: Count per course name and year")
				.hasArg()
				.argName("Analysis option")
				.required()
				.build());


		// add options by using OptionBuilder
		options.addOption(Option.builder("i").longOpt("input")
				.desc("Set an input file path")
				.hasArg()
				.argName("Input path")
				.required()
				.build());
		
		// add options by using OptionBuilder
		options.addOption(Option.builder("o").longOpt("output")
				.desc("Set an output file path")
				.hasArg()
				.argName("Output path")
				.required()
				.build());
		
		// add options by using OptionBuilder
		options.addOption(Option.builder("c").longOpt("coursecode")
				.desc("Course code for '-a 2' option")
				.argName("course code")
				.build());
				
		// add options by using OptionBuilder
		options.addOption(Option.builder("s").longOpt("startyear")
				.desc("Set the start year for analysis e.g., -s 2002")
				.argName("Start year for analysis")
				.build());
				
		// add options by using OptionBuilder
		options.addOption(Option.builder("e").longOpt("endyear")
				.desc("Set the end year for analysis e.g., -e 2005")
				.argName("End year for analysis")
				.build());
		
		// add options by using OptionBuilder
		options.addOption(Option.builder("h").longOpt("help")
				.desc("Show a Help page")
				.argName("Help")
				.build());				
			
		return options;
	}
	
	private void printHelp(Options options) {
		// automatically generate the help statement
		HelpFormatter formatter = new HelpFormatter();
		String header = "HGU Course Analyzer";
		String footer =""; // Leave this empty.
		formatter.printHelp("CLI option", header, options, footer, true);
	}

}
