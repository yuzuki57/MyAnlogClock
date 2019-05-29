package clock;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Calendar;

import javax.swing.JPanel;

import circle.CalcCircle;
//時計描画クラス
public class ClockField extends JPanel implements InterfaceClock{


	public ClockField(){
		this.setSize(480,480);
		this.setBackground(new Color(105,105,105));
	}
	@Override
	public void paint(Graphics screen){

		super.paint(screen);
		int j;

		//ここで円を描画している(目盛り)
		for(int i = 0; i < 360; i += 6){
			if(i % 5 == 0){
				j = 15;
			}else{
				j = 10;
			}
			CalcCircle circle1 = new CalcCircle(r - j, i);
			double x1 = circle1.calcXPos();
			double y1 = circle1.calcYPos();
			CalcCircle circle2 = new CalcCircle(r, i);
			double x2 = circle2.calcXPos();
			double y2 = circle2.calcYPos();
			screen.setColor(new Color((int)(Math.random()*255),
					(int)(Math.random()*255), (int)(Math.random()*255)));
			screen.drawLine((int)(x1+250), (int)(y1+250), (int)(x2+250), (int)(y2+250));
		}

		//ここから長針、短針の描画を行う
		Calendar nowTime = Calendar.getInstance();
		int hour = nowTime.get(Calendar.HOUR);
		int min = nowTime.get(Calendar.MINUTE);
		int sec = nowTime.get(Calendar.SECOND);

		//秒針の描画
		double rad = (Math.PI * 2 / 60) * sec;
		int x = (int)(secLen * Math.cos(rad + mRad)) + 250;
		int y = (int)(secLen * Math.sin(rad + mRad)) + 250;
		screen.setColor(new Color(255, 255, 0));
		screen.drawLine(250, 250, x, y);

		//分針の描画
		rad = (Math.PI * 2 / 60) * min + (Math.PI * 2 / 3600) * sec;
		x = (int)(minLen * Math.cos(rad + mRad)) + 250;
		y = (int)(minLen * Math.sin(rad + mRad)) + 250;
		screen.setColor(Color.white);
		screen.drawLine(250, 250, x, y);

		//時針の描画
		rad = (Math.PI * 2 / 12) * (hour % 12) + (Math.PI * 2 / 720) * min;
		rad += (Math.PI * 2 / 43200) * sec;
		x = (int)(hourLen * Math.cos(rad + mRad)) + 250;
		y = (int)(hourLen * Math.sin(rad + mRad)) + 250;
		screen.drawLine(250, 250, x, y);

	}

}
