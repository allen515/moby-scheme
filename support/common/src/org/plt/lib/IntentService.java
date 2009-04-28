package org.plt.lib;

public interface IntentService {
	IntentService getIntent(String action, String data);

	void exec(Object exec);
}
