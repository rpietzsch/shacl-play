package fr.sparna.rdf.shacl.app.validate;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import fr.sparna.cli.SpaceSplitter;

@Parameters(commandDescription = "Validate an input RDF data against the provided SHACL file, and writes the output in the given output file")
public class ArgumentsValidate {

	@Parameter(
			names = { "-i", "--input" },
			description = "Path to a local RDF file",
			required = true,
			variableArity = true
	)
	private List<File> input;
	
	@Parameter(
			names = { "-s", "--shapes" },
			description = "Path to an RDF file containing the shapes definitions to use",
			required = true
	)
	private File shapes;
	
	@Parameter(
			names = { "-x", "--extra" },
			description = "Extra data to use for validation - but not part of validated data itself. Typically ontology file with subClassOf predicates",
			required = false
	)
	private File extra;

	@Parameter(
			names = { "-o", "--output" },
			description = "Path to the output files (possibly multiple)",
			required = true,
			variableArity = true
	)
	private List<File> output;
	
	@Parameter(
			names = { "-c", "--copyInput" },
			description = "Path to the file where the input should be copied to be examined"
	)
	private File copyInput;
	
	@Parameter(
			names = { "-cd", "--createDetails" },
			description = "Asks the SHACL validator to create details for OrComponent and AndComponents. Defaults to false."
	)
	private boolean createDetails = false;
	
	@Parameter(
			names = "-ns",
			description = "Namespace prefixes, in the form <key1>,<ns1> <key2>,<ns2> e.g. skos,http://www.w3.org/2004/02/skos/core# dct,http://purl.org/dc/terms/",
			variableArity = true,
			splitter = SpaceSplitter.class
	)
	private List<String> namespaceMappingsStrings;

	public List<File> getInput() {
		return input;
	}

	public void setInput(List<File> input) {
		this.input = input;
	}

	public List<File> getOutput() {
		return output;
	}

	public void setOutput(List<File> output) {
		this.output = output;
	}

	public File getShapes() {
		return shapes;
	}

	public void setShapes(File shapes) {
		this.shapes = shapes;
	}

	public File getExtra() {
		return extra;
	}

	public void setExtra(File extra) {
		this.extra = extra;
	}

	public File getCopyInput() {
		return copyInput;
	}

	public void setCopyInput(File copyInput) {
		this.copyInput = copyInput;
	}

	public boolean isCreateDetails() {
		return createDetails;
	}

	public void setCreateDetails(boolean createDetails) {
		this.createDetails = createDetails;
	}
	
	public Map<String, String> getNamespaceMappings() {
		if(this.namespaceMappingsStrings == null) {
			return null;
		}
		Map<String, String> result = new HashMap<String, String>();
		for (String aMappingString : this.namespaceMappingsStrings) {
			result.put(aMappingString.split(",")[0],aMappingString.split(",")[1]);
		}
		return result;
	}
	
}