	package geometries;

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
		    

		

	}
