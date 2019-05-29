package listener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import clock.ClockDriver;
import clock.SubClockField;
import event.WindowEventHandler;

public class MyListener implements ActionListener{

	SubClockField clockfield = new SubClockField();
	JTextField text1 = new JTextField("ここにアラーム時間を入力　例）06:00:00");

	public void toMyListener(){

		JFrame frame = new JFrame("The Analog Clock After");
		frame.addWindowListener(new WindowEventHandler());
		frame.add(clockfield, BorderLayout.CENTER);
		frame.setSize(500, 590);
		frame.setLocationRelativeTo(null);

		//入力フォームの設定
		text1.setOpaque(false);
		text1.setForeground(new Color (72,61,139));

		//入力フォームのフォント設定
		text1.setFont(new Font("HGP創英角ﾎﾟｯﾌﾟ体", Font.PLAIN, 25));
		text1.addActionListener(this);
		frame.add(text1, BorderLayout.SOUTH);
	    frame.setVisible(true);

	    //スレッドの起動
		Thread thread = new Thread(new ClockDriver(clockfield));
		thread.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//アラーム時間を入力し、設定する
		clockfield.setAlarm(text1.getText());


	}


}
