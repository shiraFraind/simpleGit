package geometries;

import java.util.List;

import primitives.*;

public class Tube extends RadialGeometry
{
	Ray axisRay;
	
	public Tube(double r,Ray ray) 
	{
		super(r);
		// TODO Auto-generated constructor stub
		axisRay=new Ray(ray);
	}
	
	public Ray getRay()
	{
		return axisRay;
	}


	public Vector getNormal(Point3D _point) 
	{
	   Point3D o=axisRay.getP0();
	   Vector v=axisRay.getDir();
	   double t=_point.subtract(o).dotProduct(v);
	   if(!primitives.Util.isZero(t))
	   {
		   o=o.add(v.scale(t));
	   }
	   return _point.subtract(o).normalize();
	   
	}

	@Override
	public String toString() 
    {
		 return "ray:"+axisRay.toString();
	}

	public List<Point3D> findIntersections(Ray ray) {
		// TODO Auto-generated method stub
		return null;
	} 
	

}
