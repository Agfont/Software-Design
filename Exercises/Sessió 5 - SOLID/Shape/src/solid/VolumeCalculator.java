package solid;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author anna
 */
public  class VolumeCalculator implements IVolumeCalculator {

    Messenger message;
    
    public VolumeCalculator() {
        message = new Messenger();
    }
    @Override
    public double CalculateVolume(ArrayList<IShape> shapes)
        {
            double totalVolume = 0;
            for (int i = 0; i < shapes.size(); i++)
            {
                totalVolume += shapes.get(i).getVolume();
            }
            message.Message(totalVolume);
            
            return totalVolume;
        }
}

