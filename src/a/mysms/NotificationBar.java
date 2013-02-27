package a.mysms;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;

public class NotificationBar extends Activity {
	

	private static final int NOTIFY_ID = 1; 
											

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.notifiation);
		NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); 
		int icon = android.R.drawable.sym_action_email; 
		CharSequence tickerText = "Hello Habrahabr"; 
		long when = System.currentTimeMillis(); 
		Notification notification = new Notification(icon, tickerText, when);
		//звук
		notification.defaults = Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE;
		Uri ringURI =  RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);		
		notification.sound = ringURI;
		//вибро
		long[] vibrate = new long[] { 3000, 1000, 2000, 1000, 1000 };
		notification.vibrate = vibrate;
		
		Context context = getApplicationContext();
		CharSequence contentTitle = "Habrahabr"; // Текст заголовка уведомления
													// при развернутой строке
													// статуса
		CharSequence contentText = "Пример простого уведомления"; 
		Intent notificationIntent = new Intent(this, NotificationBar.class); 
		PendingIntent contentIntent = PendingIntent.getActivity(this, 0,notificationIntent, 0); 
		notification.setLatestEventInfo(context, contentTitle, contentText,	contentIntent); // Передаем в наше уведомление параметры вида
								// при развернутой строке состояния
		mNotificationManager.notify(NOTIFY_ID, notification); 
	}
}