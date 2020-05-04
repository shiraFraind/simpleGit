package geometries;

import java.util.List;
import primitives.*;
	//import geometries.*;

	public class Sphere extends RadialGeometry
	{
		Point3D _center;
		
		public Sphere(double r,Point3D _p)
		{
			super(r);
			// TODO Auto-generated constructor stub
			_center=new Point3D(_p);
	    }

		public Vector getNormal(Point3D point) 
		{
		        return new Vector(
		        		new Point3D(
		        				point.get_x().get()-_center.get_x().get(),
		        				point.get_y().get()-_center.get_y().get(),
		        				point.get_z().get()-_center.get_z().get())).normalize();
		}
		
		public Point3D getC()
		{
			return _center;
		}
		 @Override
		    public String toString() 
			{
			        return "center:"+_center.toString();
			}

			 @Override

			    public List<Point3D> findIntersections(Ray ray) {

			        Point3D p0 = ray.getP0();

			        Vector v = ray.getDir();

			        Vector u;

			        try {

			            u = _center.subtract(p0);   // p0 == _center

			        } catch (IllegalArgumentException e) {

			            return List.of(ray.getPoint(_radius));

			        }

			        double tm = primitives.Util.alignZero(v.dotProduct(u));

			        double dSquared = (tm == 0) ? u.lengthSquared() : u.lengthSquared() - tm * tm;

			        double thSquared = primitives.Util.alignZero(_radius * _radius - dSquared);


			        if (thSquared <= 0) return null;


			        double th = primitives.Util.alignZero(Math.sqrt(thSquared));

			        if (th == 0) return null;

			        double t1 = primitives.Util.alignZero(tm - th);

			        double t2 = primitives.Util.alignZero(tm + th);

			        if (t1 <= 0 && t2 <= 0) return null;

			        if (t1 > 0 && t2 > 0) return List.of(ray.getPoint(t1), ray.getPoint(t2)); //P1 , P2

			        if (t1 > 0)

			            return List.of(ray.getPoint(t1));

			        else

			            return List.of(ray.getPoint(t2));

			    }


		    

		

	}
