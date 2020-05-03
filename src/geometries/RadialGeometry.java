package geometries;

public abstract class RadialGeometry 
{
	double _radius;
	
	//constructors
	public RadialGeometry(double r)
	{
		_radius=r;
	}
	public RadialGeometry(RadialGeometry rg)
	{
		_radius=rg._radius;
	}
	
	public double getR()
	{
		return this._radius;
	}

}
