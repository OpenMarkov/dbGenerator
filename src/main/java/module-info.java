module org.openmarkov.dbgenerator {
	requires org.openmarkov.core;
	requires org.openmarkov.gui;
	requires org.apache.commons.io;
	requires swing.layout;
	/*
	 * requires org.openmarkov.gui; requires org.jfree.jfreechart; requires
	 * org.openmarkov.inference.variableelimination; requires java.desktop; requires
	 * org.apache.logging.log4j;
	 */
	
	provides org.openmarkov.gui.localize.spi.LocalizeResourcesProvider with org.openmarkov.dbgenerator.gui.DBGeneratorResourceBundleProvider;

}
