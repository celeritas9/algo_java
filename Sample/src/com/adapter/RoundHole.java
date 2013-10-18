/**
 * 
 */
package com.adapter;

/**
 * @author dshah
 *
 */
public class RoundHole 
{
	private int radius;
	
	public RoundHole(int r)
	{
		radius = r;
		System.out.println("RoundHole max squarePeg is: " +r*Math.sqrt(r));
	}

	/**
	 * @return the radius
	 */
	public int getRadius() {
		return radius;
	}
	
	
}
