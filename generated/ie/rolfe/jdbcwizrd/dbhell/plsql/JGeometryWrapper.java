package ie.rolfe.jdbcwizrd.dbhell.plsql;
import java.io.Serializable;
import oracle.spatial.geometry.JGeometry;
public class JGeometryWrapper implements Serializable {
   
public JGeometryWrapper() {}

private int gtype;
private int srid;
private double x;
private double y;
private double z;
private int[] elemInfo;
private double[] ordinates;

public int getGtype() 
{
  return gtype;
}
    public void setGtype(int gtype) {
        this.gtype = gtype;

    }

    public int getSrid() {

        return srid;

    }

    public void setSrid(int srid) {

        this.srid = srid;

    }

    public double getX() {

        return x;

    }

    public void setX(double x) {

        this.x = x;

    }

    public double getY() {

        return y;

    }

    public void setY(double y) {

        this.y = y;

    }

    public double getZ() {

        return z;

    }

    public void setZ(double z) {

        this.z = z;

    }

    public int[] getElemInfo() {

        return elemInfo;

    }

    public void setElemInfo(int[] elemInfo) {

        this.elemInfo = elemInfo;

    }

    public double[] getOrdinates() {

        return ordinates;

    }

    public void setOrdinates(double[] ordinates) {

        this.ordinates = ordinates;

    }

public String toString()           
{                                 
String stringRep = "JGeometryWrapper: gtype="  
+ gtype + ", srid="          
+ srid + ", xyz=[" 
+ x + " "          
+ y + " "          
+ y + "], eleminfo=["; 
                     
if (elemInfo != null)    
{                      
for (int i=0; i < elemInfo.length; i++)   
{                 
stringRep = stringRep + elemInfo[i] + " "; 
}             
}             
             
stringRep = stringRep + "], ordinates=["; 
                
if (ordinates != null)   
{                  
for (int i=0; i < ordinates.length; i++)  
{                
stringRep = stringRep + ordinates[i] + " ";
}              
}             
                
stringRep = stringRep + "]"; 
          
return (stringRep);   
       
}        
   
    public static JGeometryWrapper createWrappedClass(oracle.spatial.geometry.JGeometry sdo)

    {
        if (sdo == null) return null;
        JGeometryWrapper newWrapper =  new JGeometryWrapper();

       
        newWrapper.gtype = sdo.getType();
        newWrapper.srid = sdo.getSRID();
        newWrapper.x = sdo.getLabelPointXYZ()[0];
        newWrapper.y = sdo.getLabelPointXYZ()[1];
        newWrapper.z = sdo.getLabelPointXYZ()[2];
        newWrapper.elemInfo = sdo.getElemInfo();
        newWrapper.ordinates = sdo.getOrdinatesArray();
       
        return newWrapper;

       
    }

   
    public static oracle.spatial.geometry.JGeometry jGeometryUnWrapper(JGeometryWrapper sdo)

    {

        if (sdo == null) return null;
        oracle.spatial.geometry.JGeometry newSdo = new oracle.spatial.geometry.JGeometry

        (sdo.gtype, sdo.srid, sdo.x, sdo.y, sdo.z, sdo.elemInfo, sdo.ordinates);

       
        return newSdo;

       
    }

}

