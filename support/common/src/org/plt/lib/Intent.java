package org.plt.lib;

import org.plt.types.*;
import org.plt.platform.Platform;

public class Intent {	
	public static Object executeIntent(String action, Object data){
		IntentService service = Platform.getInstance().getIntentService(action, (String)data);
		service.executeIntent(action, (String)data);
		return data;
	}
}