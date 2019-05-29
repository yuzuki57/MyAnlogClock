package circle;

//外周部分の円の描画支援ｓを行うクラス
public class CalcCircle extends AbstractCalcCirde{

	private static double r;
	private static double deg;

	public CalcCircle(){
		this(1.0,1.0);
	}
	public CalcCircle(double r){
		this.r = r;
	}
	public CalcCircle(double r, double d){
		this.r = r;
		this.deg = d;
	}
	@Override
	public double calcArea(){
		double area = this.r * this.r * Math.PI;
		return area;
	}
	@Override
	public double calcCircumference(){
		double circumference = this.r * 2 * Math.PI;
		return circumference;
	}
	@Override
	public double calcXPos(){
		double rad = deg2rad();
		return this.r * Math.cos(rad);
	}
	@Override
	public double calcYPos(){
		double rad = deg2rad();
		return this.r * Math.sin(rad);
	}
	@Override
	public double deg2rad(){
		return Math.toRadians(deg);
	}
}
