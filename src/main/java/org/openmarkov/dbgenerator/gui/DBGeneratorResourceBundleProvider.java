package org.openmarkov.dbgenerator.gui;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import org.openmarkov.gui.localize.spi.LocalizeResourcesProvider;

public class DBGeneratorResourceBundleProvider  implements LocalizeResourcesProvider {

	@Override
	public ResourceBundle getBundle(String baseName, Locale locale) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getInfixForPathGetBundles() {
		return getInfixForPathGetBundles("org.openmarkov.dbgenerator");
	}
	
	@Override
	public InputStream auxGetResourceAsStream(String name) throws IOException {
		Module m = this.getClass().getModule();
		return m.getResourceAsStream(name);
	}
	

	@Override
	public URL auxGetResource(String infix) {
		return this.getClass().getResource(infix);
	}


}
