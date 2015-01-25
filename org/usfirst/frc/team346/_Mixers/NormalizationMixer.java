package org.usfirst.frc.team346._Mixers;

import java.util.ArrayList;

public class NormalizationMixer 
{
	public ArrayList<MixOutput> mixSet;
	
	public void init()
	{
		mixSet = new ArrayList<MixOutput>();
	}
	
	public NormalizationMixer()
	{
		init();
	}
	
	public void addToMix(MixOutput m)
	{
		mixSet.add(m);
	}
	
	//This should be called at the end of every loop
	public void apply()
	{
		//Normalize outputs of each controller
		//Apply outputs to each controller
		
		
		if(mixSet.size()>0)
		{
			//Get the min and max output SCALED of each output
			double max = -1;
			
			for(MixOutput m : mixSet)
			{
				//Everything needs to get pulled in
				//Using ABS allows us to keep the sinage of all the outputs and simplifies the code a tick
				if(Math.abs(m.getMixPercent()) > max)
					max = Math.abs(m.getMixPercent());
			}
			

			//For example consider 2 mixes with values of -1.1 and 0.5
			//Max will be 1.1
			//Motor 1 would be set to -1.1/1.1 = -1
			//Motor 2 would be set to 0.5/1.1 = .455
			for(MixOutput m : mixSet)
			{
				//If the max percent output is greater then 100% then scale all the outputs down
				if(max > 1)
					m.setMixPercentDirect(m.getMixPercent()/max);
				m.apply();
				m.reset();
			}
		}
	}
}
