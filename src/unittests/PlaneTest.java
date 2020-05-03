/**
 * 
 */
package unittests;

import static org.junit.Assert.*;
import primitives.*;
import geometries.*;
import org.junit.Test;

/**
  * @author 
 *Unit tests for primitives.Plane class
 */
public class PlaneTest {

	/**
	 * Test method for {@link geometries.Plane#getNormal(primitives.Point3D)}.
	 */
	@Test
	public void testGetNormalPoint3D() 
    {
        Vector v=new Vector(1,1,1);
        Point3D p=new Point3D(2,2,2);
        Plane plane=new Plane(p,v);
        Vector normal=new Vector(plane.getNormal(p));
        assertEquals(v,normal);
    
    }
}
