package event;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//終了を行うクラス
public class WindowEventHandler extends WindowAdapter {

	public void windowClosing(WindowEvent event) {
		System.exit(0);
	}
}
