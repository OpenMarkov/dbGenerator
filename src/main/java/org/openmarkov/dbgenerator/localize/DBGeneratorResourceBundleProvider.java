package org.openmarkov.dbgenerator.localize;

import org.jetbrains.annotations.NotNull;
import org.openmarkov.annotation_processing.localization_bindings.BindLocalizations;
import org.openmarkov.gui.localize.spi.LocalizeResourcesProvider;

@BindLocalizations(filePath = "dbgenerator/localize")
public class DBGeneratorResourceBundleProvider  implements LocalizeResourcesProvider {
	
	@Override
	public @NotNull String getRootOfResources() {
		return "/dbgenerator";
	}
	
}
