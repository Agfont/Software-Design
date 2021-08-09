/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solid;

/**
 *
 * @author anna
 */
public class Square implements IShape {

    private int width;
    
    public Square (int w) {
        width = w;
    }
    @Override
    public double getArea() {
        double area = width * width;
            return area;
    }

    @Override
    public double getVolume() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }  
}
