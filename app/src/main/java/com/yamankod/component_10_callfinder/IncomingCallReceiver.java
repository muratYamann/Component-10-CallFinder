package com.yamankod.component_10_callfinder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class IncomingCallReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		
		 Bundle bundle = intent.getExtras();     
         if(null == bundle)         return;
         Log.i("IncomingCallReceiver",bundle.toString());
         String state = bundle.getString(TelephonyManager.EXTRA_STATE);
         Log.i("IncomingCallReceiver","Telefonun Durumu: "+ state);
          
         if(state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_RINGING))
         {
                 String phonenumber = bundle.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);                          
                 Log.i("IncomingCallReceiver","Arayan Numara: " + phonenumber);                  
                 String info = "Arama Tespit edildi. \n Arayan Numara: " + phonenumber;
                 Toast.makeText(context, info, Toast.LENGTH_LONG).show();
         }
	}
}


