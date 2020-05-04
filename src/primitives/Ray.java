package primitives;

public class Ray
{
	Point3D _P0;
	Vector _Dir;
	
//get functions	
	public Point3D getP0()
	{
		return _P0;
	}
	public Vector getDir()
	{
		return _Dir;
		
	}
//constructor	
    public Ray(Ray _ray)
    {
    	_P0=_ray._P0;
    	_Dir=_ray._Dir;	
    }
    public Ray(Point3D _p0,Vector _dir)//throws IllegalArgumentException
    {
    	if(_dir.normalized()!=_dir)
    		//throw new IllegalArgumentException("the vector is not normelized");
    		_dir=_dir.normalize();
    	_P0=new Point3D(_p0);
    	_Dir=new Vector(_dir);	
    }
    public Point3D getPoint(double t)
    {
    	return new Point3D(_P0.add(_Dir.scale(t)));
    }
    
    //OVERRIDE FUNCTIONS
    @Override
    public boolean equals(Object obj) {
       if (this == obj) return true;
       if (obj == null) return false;
       if (!(obj instanceof Ray)) return false;
       Ray oth = (Ray)obj;
       return _P0.equals(oth._P0) && _Dir.equals(oth._Dir);
    }
    @Override
    public String toString()
    {
    	return "P0: "+_P0.toString()+", Direction: "+_Dir.toString();
    }

}