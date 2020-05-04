/**
 * 
 */
package unittests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import geometries.*;
import primitives.*;
/**
 * @author  shira postelnik & shira fraind
 *
 */
public class GeometriesTests
{
	/**
     * Test method for intersection Points with ray and list of objects
     */
	@Test
	public void testFindIntersectionPoints()
	{
		Plane plane=new Plane(new Point3D(0,0,0), new Vector(1,0,0));
		   Triangle triangle=new Triangle(new Point3D(2,0,1),new Point3D(2,0,-1),new Point3D(2,1,0));
		   Sphere sphere=new Sphere(1d,new Point3D(4,0,0));
		   Geometries _geometries=new Geometries(plane,triangle, sphere);
		   Geometries _geometries2=new Geometries();//an empty list of geomatries
		// ============ Equivalence Partitions Tests ==============

		       //TC01: Some geometries have intersection points(3 points)
		       assertEquals("Some geometries have intersection points",1,
		        _geometries.findIntersections(new Ray(new Point3D(-1,2,0), new Vector(1, 0, 0))).size());

		     
		       // =============== Boundary Values Tests ==================
		       
		       // TC11: An empty list (0 points)
		        assertEquals("An empty list",null,
		        _geometries2.findIntersections(new Ray(new Point3D(1,1,0), new Vector(1, 0, 0))));
		       // TC12: Non geometry has intersection points(0 points)
		       assertEquals("Non geometry has intersection points",null,
		        _geometries.findIntersections(new Ray(new Point3D(-1,0,0), new Vector(0,1, 0))));
		      // TC13: All geometries has intersection points(4 points)
		       assertEquals("All geometries has intersection points", 4,
		        _geometries.findIntersections(new Ray(new Point3D(-1,0.5,0), new Vector(1,0,0))).size());
		       // TC14: one geometry has intersection points (2 points), we decided to intersection the sphere
		       assertEquals("one geometry has intersection points", 2,_geometries.findIntersections(new Ray(new Point3D(2.5,0,0), new Vector(4,0,0))).size());


    

	}    
}
