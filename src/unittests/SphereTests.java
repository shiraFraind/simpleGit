/**
 * 
 */
package unittests;

import static org.junit.Assert.*;
import org.junit.Test;
import primitives.*;
import geometries.*;

/**
 
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
}
//(new Vector(1,0,0)).equals(s.getNormal(new Point3D(2,0,0)))



