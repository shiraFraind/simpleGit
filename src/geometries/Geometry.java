package geometries;
import primitives.*;

public interface Geometry extends Intersectable
{
	Vector getNormal(Point3D p);

}
