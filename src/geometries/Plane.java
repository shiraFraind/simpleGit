package geometries;
import java.util.List;

import primitives.*;

public class Plane implements Geometry
{
	Point3D _p;
	Vector _normal;

	//constructors
	public Plane(Point3D p,Vector normal)
	{
		_p=p;
		_normal=normal;
	}
	public Plane(Point3D p1,Point3D p2,Point3D p3)
	{
		_p=p1;
		_normal=(p3.subtract(p2)).crossProduct((p1.subtract(p2)));
	}
	
	//getters
	public Point3D getP()
	{
		return _p;
	}

	public Vector getNormal(Point3D p) {
		// TODO Auto-generated method stub
		return this._normal;
	}


	@Override
	public String toString()
	{
		return "point: "+_p.toString()+", normal: "+_normal.toString();
	}
	//@Override
	    public List<Point3D> findIntersections(Ray ray) {

	        Vector p0Q;

	        try 
	        {
	            p0Q = _p.subtract(ray.getP0());    
	        } 
	        catch (IllegalArgumentException e) 
	        {
	            return null; // ray starts from point Q - no intersections
	        }
	
	        double nv = _normal.dotProduct(ray.getDir());

	        if (primitives.Util.isZero(nv)) // ray is parallel to the plane - no intersections
	            return null;
	        
	        double t = primitives.Util.alignZero(_normal.dotProduct(p0Q) / nv);
	        return t <= 0 ? null : List.of(ray.getPoint(t));

	    }



}
