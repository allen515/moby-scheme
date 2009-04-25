package org.plt.intent.android;

import android.net.Uri;
import android.app.Activity;

public class View extends org.plt.intent.View {
	public View(Object data) {
		this.data = data;
	}

	public void exec(Object executor) {
		Activity exec = (Activity) executor;
		Uri uri = Uri.parse((String) data);
		android.content.Intent i = new android.content.Intent(
				android.content.Intent.ACTION_VIEW, uri);
		exec.startActivity(i);
	}
}