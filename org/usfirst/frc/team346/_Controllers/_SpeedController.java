package org.usfirst.frc.team346._Controllers;

import edu.wpi.first.wpilibj.SpeedController;

public interface _SpeedController extends SpeedController
{
	public double getPercentOutput();
	public void setScale(double scale);
}
