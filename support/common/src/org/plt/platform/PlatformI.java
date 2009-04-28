package org.plt.platform;

import org.plt.lib.LocationService;
import org.plt.lib.TiltService;
import org.plt.lib.SmsService;
import org.plt.lib.NetworkService;
import org.plt.lib.IntentService;

public interface PlatformI {
    String getName();

    LocationService getLocationService();
    TiltService getTiltService();
    SmsService getSmsService();
    NetworkService getNetworkService();
	IntentService getIntentService(String action, String data);
}
