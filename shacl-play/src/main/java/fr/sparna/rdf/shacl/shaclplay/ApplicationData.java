package fr.sparna.rdf.shacl.shaclplay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;


/**
 * Everything that needs to be loaded at an application-wide level
 * 
 * @author Thomas Francart
 */
public class ApplicationData {

	private Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	protected String buildVersion;	
	protected String buildTimestamp;
	
	@Value("${shaclplay.largeInput.threshold:100}")
	private int largeInputThreshold;
	
	@Value("${shaclplay.baseUrl:#{null}}")
	private String applicationBaseUrl;
	
	public ApplicationData() {
		super();	
	}

	public String getBuildVersion() {
		return buildVersion;
	}

	public void setBuildVersion(String buildVersion) {
		this.buildVersion = buildVersion;
	}

	public String getBuildTimestamp() {
		return buildTimestamp;
	}

	public void setBuildTimestamp(String buildTimestamp) {
		this.buildTimestamp = buildTimestamp;
	}
	
	public String getApplicationBaseUrl() {
		return applicationBaseUrl;
	}

	public void setApplicationBaseUrl(String applicationBaseUrl) {
		this.applicationBaseUrl = applicationBaseUrl;
	}
	
	public int getLargeInputThreshold() {
		return largeInputThreshold;
	}

	public void setLargeInputThreshold(int largeInputThreshold) {
		this.largeInputThreshold = largeInputThreshold;
	}
	
}