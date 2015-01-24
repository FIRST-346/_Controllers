package org.usfirst.frc.team346._Mixers;

import org.usfirst.frc.team346._Controllers._SpeedController;

public class MixSpeedController<E extends _SpeedController> implements _SpeedController, MixOutput
{
	public E output;
	double outPercent;
	double outScale;
	
	public MixSpeedController(E output)
	{
		this.output = output;
	}
	
	public E getOutput()
	{
		return output;
	}
	
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------
	//_SpeedController Methods
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public double get() 
	{
		return output.get();
	}
	@Override
	public void set(double speed, byte syncGroup) 
	{
		//So this is ignored atm ...
		set(speed);
	}
	@Override
	public void set(double speed) 
	{
		//This is where we do our tom foolery
		setMixPercent(speed);
	}
	@Override
	public void disable() {
		output.disable();
	}
	
	@Override
	public void pidWrite(double output) {
		//Again tom foolery ...
		//Not sure if this is wise ...
		setMixPercent(output);
	}
	@Override
	public double getPercentOutput() {
		return output.getPercentOutput();
	}
	
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------
	//MixOutput Methods
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public void setMixPercent(double v) {
		outPercent = v;
	}
	@Override
	public double getMixPercent() {
		return outPercent;
	}
	@Override
	public void reset() {
		outPercent = 0;
	}
	@Override
	public void apply() {
		output.set(outPercent*outScale);
	}
	@Override
	public void setScale(double d) {
		outScale = d;
	}
	@Override
	public double getScale() {
		return outScale;
	}
}
