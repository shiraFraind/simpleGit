/**
 * 
 */
package geometries;

import java.util.ArrayList;
import java.util.List;

import primitives.Point3D;
import primitives.Ray;

/**
 * @author shira postelnik & shira fraind
 *
 */
public class Geometries implements Intersectable 
{
private List<Intersectable> _geometries = new ArrayList<Intersectable>();



public Geometries(Intersectable... _geometries) {

    add( _geometries);

}



public void add(Intersectable... geometries) {

    for (Intersectable geo : geometries )
    {
        _geometries.add(geo);
    }
}
/**
 * 
 * @param ray
 * @return list of Point3D that intersect the collection
 */

@Override

public List<Point3D> findIntersections(Ray ray) {

    List<Point3D> intersections = null;

    for (Intersectable geo : _geometries) 
    {
        List<Point3D> tempIntersections = geo.findIntersections(ray);
        if (tempIntersections != null) 
        {
            if (intersections == null)
                intersections = new ArrayList<Point3D>();
            intersections.addAll(tempIntersections);
        }
    }
    return intersections;
 }

}
