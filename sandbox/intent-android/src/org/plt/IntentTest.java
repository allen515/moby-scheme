package org.plt;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class IntentTest extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		LinearLayout ll = new LinearLayout(this);
		Button b = new Button(ll.getContext());
		b.setText("press to start activity");
		
		final Activity executor = this;

		b.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				String uri = "http://maps.google.com/maps?f=q&source=s_q&hl=en&geocode=&q=115+Waterman+St,+Providence,+RI+02906&sll=41.827339,-71.399626&sspn=0.008011,0.019312&ie=UTF8&ll=41.827795,-71.399632&spn=0.008011,0.019312&t=h&z=16&iwloc=A";
				org.plt.intent.Intent i = new org.plt.intent.android.View(uri);
				i.exec(executor);
			}
		});

		ll.addView(b);
		setContentView(ll);
	}
}