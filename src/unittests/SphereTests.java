/**
 * 
 */
package unittests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import primitives.*;
import geometries.*;

/**
  * @author  shira postelnik & shira fraind
 *Unit tests for primitives.Sphere class
 */
public class SphereTests {

	/**
	 * Test method for {@link geometries.Sphere#getNormal(primitives.Point3D)}.
	 */
    @Test
    public void testgetNormal() {
        Sphere s = new Sphere(1, new Point3D(1, 0, 0));
        Vector check1=new Vector(s.getNormal(new Point3D(2,0,0)));
        Vector check2=new Vector(1,0,0);
        assertEquals("Wrong normal to sphere",check1,check2);
    }
    /**
     * Test method for {@link geometries.Sphere#findIntersections(primitives.Ray)}.
     */
    @Test
    public void testFindIntersections()
    {
        Sphere sphere = new Sphere(1d, new Point3D(1, 0, 0));

        // ============ Equivalence Partitions Tests ==============

        // TC01: Ray's line is outside the sphere (0 points)
        assertEquals("Ray's line out of sphere", null,sphere.findIntersections(new Ray(new Point3D(-1, 0, 0), new Vector(1, 1, 0))));

        // TC02: Ray starts before and crosses the sphere (2 points)
        Point3D p1 = new Point3D(0.0651530771650466, 0.355051025721682, 0);
        Point3D p2 = new Point3D(1.53484692283495, 0.844948974278318, 0);
        List<Point3D> result = sphere.findIntersections(new Ray(new Point3D(-1, 0, 0), new Vector(3, 1, 0)));
        assertEquals("Wrong number of points", 2, result.size());
        if (result.get(0).get_x().get() > result.get(1).get_x().get())
            result = List.of(result.get(1), result.get(0));
        assertEquals("Ray crosses sphere", List.of(p1, p2), result);
       
        // TC03: Ray starts inside the sphere (1 point)
        Point3D p3 = new Point3D(1.4114378277661475, 0.9114378277661476, 0.0);
        List<Point3D> result2 = sphere.findIntersections(new Ray(new Point3D(0.5, 0, 0), new Vector(1, 1, 0)));
        assertEquals("Wrong number of points",1, result2.size());
        assertEquals("Ray starts inside the sphere ", List.of(p3), result2);
   
        // TC04: Ray starts after the sphere (0 points)
        assertEquals("Ray starts after the sphere", null,sphere.findIntersections(new Ray(new Point3D(2.5, 0, 0), new Vector(0, 0, 1))));

        // =============== Boundary Values Tests ==================

       
        // **** Group: Ray's line crosses the sphere (but not the center)
        // TC11: Ray starts at sphere and goes inside (1 points)
        assertEquals("Ray starts at sphere and goes inside", List.of(p2), sphere.findIntersections(new Ray(new Point3D(p1), new Vector(3, 1, 0))));
       
        // TC12: Ray starts at sphere and goes outside (0 points)
       assertEquals("Ray starts at sphere and goes outside", null,sphere.findIntersections(new Ray(new Point3D(p2), new Vector(3,1,0))));
       

        // **** Group: Ray's line goes through the center
        // TC13: Ray starts before the sphere (2 points)
        Point3D p4 = new Point3D(1, 1, 0);
        Point3D p5 = new Point3D(1, -1, 0);
        List<Point3D> result4 = sphere.findIntersections(new Ray(new Point3D(1, 3, 0), new Vector(0, -1, 0)));
        assertEquals("Wrong number of points", 2, result4.size());
        if (result4.get(0).get_x().get() > result4.get(1).get_x().get())
            result4 = List.of(result4.get(1), result4.get(0));
        assertEquals("Ray starts befor the sphere and crosses the center of the sphere", List.of(p4, p5), result4);
       
        // TC14: Ray starts at sphere and goes inside (1 points)
        List<Point3D> result5 = sphere.findIntersections(new Ray(new Point3D(p4), new Vector(0, -1, 0)));
        assertEquals("Wrong number of points", 1, result5.size());
        assertEquals("Ray starts at the sphere and crosses the center of the sphere", List.of(p5), result5);
       
        // TC15: Ray starts inside (1 points)
        Point3D p6=new Point3D(1, 1, 0);
        List<Point3D> result6 = sphere.findIntersections(new Ray(new Point3D(1, -0.5, 0), new Vector(0, 1, 0)));
        assertEquals("Wrong number of points", 1, result6.size());
        assertEquals("Ray starts inside the sphere", List.of(p6), result6);
       
        // TC16: Ray starts at the center (1 points)
        Point3D p7=new Point3D(1, 1, 0);
        List<Point3D> result7 = sphere.findIntersections(new Ray(new Point3D(1, 0, 0), new Vector(0, 1, 0)));
        assertEquals("Wrong number of points", 1, result7.size());
        assertEquals("Ray starts at the center", List.of(p7), result7);
     
        // TC17: Ray starts at sphere and goes outside (0 points)
        assertEquals("Ray starts at sphere and goes outside", null,sphere.findIntersections(new Ray(new Point3D(1,1,0), new Vector(0, 1, 0))));

        // TC18: Ray starts after sphere (0 points)
        assertEquals("Ray starts after sphere", null,sphere.findIntersections(new Ray(new Point3D(1,1.5,0), new Vector(0, 1, 0))));

       
        // **** Group: Ray's line is tangent to the sphere (all tests 0 points)
        // TC19: Ray starts before the tangent point
        assertEquals("Tangent line, ray before sphere",null,sphere.findIntersections(new Ray(new Point3D(0, 1, 0), new Vector(1, 0, 0))));
             
        // TC20: Ray starts at the tangent point
        assertEquals("Tangent line, ray at sphere",null,sphere.findIntersections(new Ray(new Point3D(1, 1, 0), new Vector(1, 0, 0))));

        // TC21: Ray starts after the tangent point
        assertEquals( "Tangent line, ray after sphere",null,sphere.findIntersections(new Ray(new Point3D(2, 1, 0), new Vector(1, 0, 0))));


        // **** Group: Special cases
        // TC22: Ray's line is outside, ray is orthogonal to ray start to sphere's center line
        assertEquals("Ray is orthogonal to ray start to sphere's center line", null,sphere.findIntersections(new Ray(new Point3D(1, 3, 0), new Vector(0, 0, 1))));
    
          }

}



