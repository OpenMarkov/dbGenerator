import org.openmarkov.dbgenerator.localize.DBGeneratorResourceBundleProvider;

module org.openmarkov.dbgenerator {
	requires org.openmarkov.core;
	requires org.openmarkov.gui;
	requires org.apache.commons.io;
	requires swing.layout;
	
	exports org.openmarkov.dbgenerator;
	exports org.openmarkov.dbgenerator.gui;
	
	/*
	 * requires org.openmarkov.gui; requires org.jfree.jfreechart; requires
	 * org.openmarkov.inference.variableelimination; requires java.desktop; requires
	 * org.apache.logging.log4j;
	 */
	
	provides org.openmarkov.gui.localize.spi.LocalizeResourcesProvider with DBGeneratorResourceBundleProvider;

}
