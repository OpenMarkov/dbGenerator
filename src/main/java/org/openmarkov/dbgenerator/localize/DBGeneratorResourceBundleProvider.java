package org.openmarkov.dbgenerator.localize;

import org.jetbrains.annotations.NotNull;
import org.openmarkov.gui.localize.spi.LocalizeResourcesProvider;

public class DBGeneratorResourceBundleProvider  implements LocalizeResourcesProvider {
	
	@Override
	public @NotNull String getRootOfResources() {
		return "/dbgenerator";
	}
	
	
}
