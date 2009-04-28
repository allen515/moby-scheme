package org.plt.lib;

import org.plt.types.*;
import org.plt.platform.Platform;

public class Intent {	
	public static void executeIntent(String action, String data){
		IntentService service = Platform.getInstance().getIntentService(action, data);
		service.executeIntent(action, data);
	}
}