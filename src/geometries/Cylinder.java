package geometries;
import java.util.List;

import primitives.*;


public class Cylinder extends Tube
{
	double _height;

	public Cylinder(double r, Ray ray,double height) {
		super(r, ray);
		// TODO Auto-generated constructor stub
		_height=height;
	}
		@Override
		public Vector getNormal(Point3D p){return super.getNormal(p);}

	
	public double getH()
	{
		return _height;
	}
	@Override
	public String toString() 
	{
		 return "height:"+_height;
	} 
	    
	@Override
	public List<Point3D> findIntersections(Ray ray) {
		// TODO Auto-generated method stub
		return null;
	} 
	
	

}
