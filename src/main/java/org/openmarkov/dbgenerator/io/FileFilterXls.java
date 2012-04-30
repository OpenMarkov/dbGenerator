/*
* Copyright 2011 CISIAD, UNED, Spain
*
* Licensed under the European Union Public Licence, version 1.1 (EUPL)
*
* Unless required by applicable law, this code is distributed
* on an "AS IS" basis, WITHOUT WARRANTIES OF ANY KIND.
*/

package org.openmarkov.dbgenerator.io;

import java.io.File;

import org.openmarkov.core.gui.dialog.io.FileFilterBasic;
import org.openmarkov.core.gui.localize.StringResource;
import org.openmarkov.core.gui.localize.StringResourceLoader;

/**
 * Class that filter only the files that contain Excel databases.
 * 
 * @author joliva
 * @author manuel      
 * @author fjdiez          
 * @version 1.0
 * @since OpenMarkov 1.0 */
public class FileFilterXls extends FileFilterBasic {
    /**
     * String resource.
     */
    private StringResource stringResource;

    /**
     * Extension of the files that match this filter.
     */
    private String filterExtension = "xls";


    /**
     * Create a new instance and create a new string resource.
     */
    public FileFilterXls() {
        super();
        stringResource =
            StringResourceLoader.getUniqueInstance().getBundleDialogs();
    }


    /**
     * Accepts all the directories (by default in CarmentFileFilter) and 
     * whose extension is 'xls'.
     */
    @Override
    public boolean accept(File file) {
        boolean result = super.accept(file);
        String fileExtension;

        if (! result) {
            fileExtension = getExtension(file);
            return (fileExtension.equals(filterExtension));
        }
        return true;
    }


    /**
     * Returns the description of the Excel files
     * 
     * @return a string representing the description of the files type
     */
    @Override
    public String getDescription() {
        return stringResource.getString("FileExtension.Excel.Description")
            + " (*." + filterExtension + ")";
    }


    /**
     * Returns the extension of the files that match this filter.
     * 
     * @return accepted extension by the filter.
     */
    @Override
    public String getFilterExtension() {
        return filterExtension;
    }
}
