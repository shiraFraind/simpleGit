package geometries;
import primitives.*;

public class Plane implements Geometry
{
	Point3D p;
	Vector normal;

	//constructors
	public Plane(Point3D _p,Vector _normal)
	{
		p=_p;
		normal=_normal;
	}
	public Plane(Point3D p1,Point3D p2,Point3D p3)
	{
		p=p1;
		normal=(p3.subtract(p2)).crossProduct((p1.subtract(p2)));
	}
	
	//getters
	public Point3D getP()
	{
		return p;
	}

	public Vector getNormal(Point3D p) {
		// TODO Auto-generated method stub
		return this.normal;
	}


	@Override
	public String toString()
	{
		return "point: "+p.toString()+", normal: "+normal.toString();
	}

}
