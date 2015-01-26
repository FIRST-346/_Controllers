package org.usfirst.frc.team346._Controllers;

public class GenericSpeedController<E extends _SpeedController> implements _SpeedController 
{
	//
	public double scale = 1;
	public void setScale(double scale)
	{
		this.scale = scale;
	}
	
	E out;
	public GenericSpeedController(E out)
	{
		this.out = out;
	}
	
	@Override
	public double get() 
	{
		return out.get();
	}

	@Override
	public void set(double speed, byte syncGroup) 
	{
		out.set(speed*scale, syncGroup);
	}

	@Override
	public void set(double speed) 
	{
		out.set(speed*scale);
	}

	@Override
	public void disable() 
	{
		out.disable();
	}

	@Override
	public void pidWrite(double output) 
	{
		out.pidWrite(output);

	}

	@Override
	public double getPercentOutput() 
	{
		return out.getPercentOutput();
	}

}
