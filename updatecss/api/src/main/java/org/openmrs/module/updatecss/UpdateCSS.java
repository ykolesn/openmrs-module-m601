/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.updatecss;

import java.io.Serializable;
import org.openmrs.BaseOpenmrsObject;
import org.openmrs.BaseOpenmrsMetadata;

import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openmrs.api.context.Context;
import org.openmrs.module.updatecss.api.UpdateCSSService;
import org.openmrs.util.OpenmrsUtil;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
//import org.openmrs.module.updatecss.api.UpdateCSSService;


/**
 * It is a model class. It should extend either {@link BaseOpenmrsObject} or {@link BaseOpenmrsMetadata}.
 */
public class UpdateCSS extends BaseOpenmrsObject implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String homeDirectory;
	private String cssData;
	
	@Override
	public Integer getId() {
		return id;
	}
	
	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getHomeDirectory() {
		return homeDirectory;
	}

	public void setHomeDirectory(String homeDirectory) {
		this.homeDirectory = homeDirectory;
	}

	public String getCssData() {
		return cssData;
	}

	public void setCssData(String cssData) {
		this.cssData = cssData;
	}
	
	/**
	 * Replaces the text of the specified CSS file in the
	 * specified directory with the specified text
	 */
	public void copyCssDataToTomcatDirectory(String directory, String cssText) {
		File cssFile = new File(directory);
		if (cssFile.exists()) {
			writeDataToFile(cssFile, cssText);
		}
	}
	
	/**
	 * Copies the data stored in the DB into the CSS file that is saved in the 
	 * directory column of the css_properties table
	 */
	public void copyCssDataToTomcatDirectory() {
		UpdateCSSService cssService = Context.getService(UpdateCSSService.class);
		UpdateCSS updateCSS = cssService.getData();
		String cssDirectory = updateCSS.getHomeDirectory();
		String cssText = updateCSS.getCssData();
		copyCssDataToTomcatDirectory(cssDirectory, cssText);
	}
	
	/**
	 * Writes the specified text to the specified CSS file
	 */
	public void writeDataToFile(File cssFile, String cssText) {
		try {
			if (cssFile.exists()) {
				PrintWriter writer = new PrintWriter(cssFile);
				writer.print(cssText);
				writer.close();
			}
		} catch (FileNotFoundException ex) {
			
		}
	}
	
	/**
	 * Reads the data in the file at the specified path and returns
	 * a String with the contents. If the file doesn't exist
	 * then it returns an empty string
	 */
	public String getCssTextFromFile(String filePath) {
		String cssText = "";
		try {
			File cssFile = new File(filePath);
			if (cssFile.exists()) {
				cssText = FileUtils.readFileToString(cssFile);
			}	
		} catch (IOException ex) {
		
		}
		return cssText;
	}
	
}