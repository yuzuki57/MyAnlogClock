package clock;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;

import alarmClock.Alarm;
import calc.CalcCalendar;
import circle.CalcCircle;

public class SubClockField extends ClockField {

	private int imgY = 1;
	private int imgX = (int)(Math.random()*490);
	//アラート時間の設定
	private static String alarm = "08:00:00";

	@Override
	public void paint(Graphics screen){

		super.paint(screen);
		int j;
		try{
			BufferedImage backgroundImg = ImageIO.read(new File("1000132401_1-440x440.jpg"));
			BufferedImage MoveImg = ImageIO.read(new File("Gundamu001.png"));
			BufferedImage IconImg = ImageIO.read(new File("5352E8BF91E382A.png"));
			//背景画像の設定
			screen.drawImage(backgroundImg, 0,0, 490,530, null);

			//ここで円を描画している(目盛り)
			for(int i = 0; i < 360; i += 6){
				if(i % 5 == 0){
					j = 17;
				}else{
					j = 10;
				}

				CalcCircle circle2 = new CalcCircle(r, i);
				double x2 = circle2.calcXPos();
				double y2 = circle2.calcYPos();
				//ランダムに色を変更
				screen.setColor(new Color((int)(Math.random()*255),
						(int)(Math.random()*255), (int)(Math.random()*255)));
				screen.fillOval((int)(x2 + 243), (int)(y2 + 243), (int)j, (int)j);
			}

			//ここから秒針、分針、時針の描画を行う
			Calendar nowTime = Calendar.getInstance();
			int hour = nowTime.get(Calendar.HOUR);
			int min = nowTime.get(Calendar.MINUTE);
			int sec = nowTime.get(Calendar.SECOND);

			Graphics2D screen2 = (Graphics2D)screen;
			BasicStroke bs = new BasicStroke(5);
			screen2.setStroke(bs);

			CalcCalendar calcCalendar = new CalcCalendar();
			screen.setColor(new Color (255,51,51));

			//フォントの設定
			Font font3 = new Font("HGP創英角ﾎﾟｯﾌﾟ体",Font.ITALIC,30);
			screen.setFont(font3);

			//現在日時の描画
			screen.drawString(calcCalendar.doYear() + "年", 130, 190);
			screen.drawString(calcCalendar.doMonth() + "月", 240, 190);
			screen.drawString(calcCalendar.doDay() + "日", 290, 190);
			screen.drawString("<" + calcCalendar.doWeeks() + ">", 160, 230);
			//デジタル描画
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 E曜日");
			sdf.applyPattern("HH:mm:ss");
			screen.setColor(new Color (0,255,255));
			screen.drawString("<Now Time>", 150, 390);
			screen.drawString(sdf.format(nowTime.getTime()), 180, 430);

			//アラーム時間表示
			screen.setColor(new Color (255,255,255));
			screen.drawString("<Alarm clock>", 150, 300);
			screen.drawString(alarm, 180, 340);


			//分針の描画
			double rad = (Math.PI * 2 / 60) * min + (Math.PI * 2 / 3600) * sec;
			int x = (int)(minLen * Math.cos(rad + mRad)) + 250;
			int y = (int)(minLen * Math.sin(rad + mRad)) + 250;
			screen.setColor(new Color (255,140,0));
			screen.drawLine(250, 250, x, y);

			//時針の描画
			rad = (Math.PI * 2 / 12) * (hour % 12) + (Math.PI * 2 / 720) * min;
			rad += (Math.PI * 2 / 43200) * sec;
			x = (int)(hourLen * Math.cos(rad + mRad)) + 250;
			y = (int)(hourLen * Math.sin(rad + mRad)) + 250;
			screen.drawLine(250, 250, x, y);

			//秒針の描画
			rad = (Math.PI * 2 / 60) * sec;
			x = (int)(secLen * Math.cos(rad + mRad)) + 250;
			y = (int)(secLen * Math.sin(rad + mRad)) + 250;
			screen.setColor(new Color(255, 255, 0));
			screen.drawLine(250, 250, x, y);
			screen.drawImage(IconImg, 220, 230, 50,50, null);

			//画像を表示して動かす
			screen.drawImage(MoveImg, imgX, imgY, 90,90, null);

			//アラーム起動
			Alarm.toAlarm();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String getAlarm() {
		return alarm;
	}

	public void setAlarm(String alarm) {
		this.alarm = alarm;
	}

	public int getImgX() {
		return imgX;
	}

	public void setImgX(int imgX) {
		this.imgX = imgX;
	}

	public int getImgY() {
		return imgY;
	}

	public void setImgY(int imgY) {
		this.imgY = imgY;
	}

}
