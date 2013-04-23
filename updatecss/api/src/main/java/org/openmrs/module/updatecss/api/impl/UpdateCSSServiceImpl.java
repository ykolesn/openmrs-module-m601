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
package org.openmrs.module.updatecss.api.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import org.openmrs.api.impl.BaseOpenmrsService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.openmrs.module.updatecss.UpdateCSS;
import org.openmrs.module.updatecss.api.UpdateCSSService;
import org.openmrs.module.updatecss.api.db.UpdateCSSDAO;


/**
 * It is a default implementation of {@link UpdateCSSService}.
 */
public class UpdateCSSServiceImpl extends BaseOpenmrsService implements UpdateCSSService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private UpdateCSSDAO dao;
	
	/**
     * @param dao the dao to set
     */
    public void setDao(UpdateCSSDAO dao) {
	    this.dao = dao;
    }
    
    /**
     * @return the dao
     */
    public UpdateCSSDAO getDao() {
	    return dao;
    }
    
    public void saveData(UpdateCSS updateCSS){
    	dao.saveCSSData(updateCSS);
	}
    
    public UpdateCSS getData() {
    	return dao.getCSSData();
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
		UpdateCSS updateCSS = getData();
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