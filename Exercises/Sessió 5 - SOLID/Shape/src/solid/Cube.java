package solid;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anna
 */
public class Cube implements IShape {
   
    private int width;

    public Cube(int w) {
        width = w;
    }
 
    @Override
    public double getArea()
    {
        return 6 * width * width;
    }
 
    @Override
    public double getVolume()
    {
            return width * width * width;
    }        
}
