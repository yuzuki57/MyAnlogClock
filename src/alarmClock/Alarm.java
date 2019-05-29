package alarmClock;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import clock.SubClockField;
//アラーム判定を行うクラス
public class Alarm {

	public static void toAlarm(){
		Calendar nowTime = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 E曜日");
		sdf.applyPattern("HH:mm:ss");

		try{
			//設定時間と現在時間を比較、一致したらアラームを鳴らす
			if (SubClockField.getAlarm().equals(sdf.format(nowTime.getTime()))) {
				AudioClip audioclip = Applet.newAudioClip(new File("sample.wav").toURI().toURL());
				audioclip.play();
			}

		}catch (Exception e) {
			e.printStackTrace();
		}

	}
}
