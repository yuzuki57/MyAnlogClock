package clock;

//時計再描画クラス
public class ClockDriver extends Thread{

	private SubClockField drivenClock;

	public ClockDriver(SubClockField clock){
		drivenClock = clock;
	}
	public void run(){
		int i = 1;
		while(true){

			//画像操作
			if (drivenClock.getImgY() <= 450) {
				drivenClock.setImgY(i);
				i += 8;
			} else {
				i = 0;
				drivenClock.setImgY(i);
				drivenClock.setImgX((int)(Math.random()*490));
			}
			//再描画
			drivenClock.repaint();
			try{

				sleep(100);
			}catch(InterruptedException e){}

		}
	}
}
