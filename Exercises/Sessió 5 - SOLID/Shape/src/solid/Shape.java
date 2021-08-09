/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solid;

import java.util.ArrayList;

/**
 *
 * @author anna
 */
public class Shape {
        //TODO add more shapes if needed
        public static final  int SQUARE = 1;
        public static final  int CIRCLE = 2;
        public static final  int EQUILATERAL_TRIANGLE = 3;
        private double width;
        public int type = -1;
 
        public Shape(int type, double width)
        {
            this.type = type;
            this.width = width;
        }
 
        public double getArea() throws Exception
        {
            switch (type)
            {
                case SQUARE:
                    return width * width;
                case CIRCLE:
                    return Math.PI * (width / 2) * (width / 2);
                case EQUILATERAL_TRIANGLE:
                    return (Math.sqrt(3) / 4) * width * width;
            }
            throw new Exception("Can`t compute area of unknown shape");
        }
 
        public static double CalculateTotalArea(ArrayList<Shape> shapes) throws Exception
        {
            double totalArea = 0;
            
            for (int i = 0; i < shapes.size(); i++)
                {
                    if (shapes.get(i).type == SQUARE)
                    {
                        totalArea += shapes.get(i).getArea();
                    }
                    if (shapes.get(i).type == CIRCLE)
                    {
                        totalArea += shapes.get(i).getArea();
                    }
                    if (shapes.get(i).type == EQUILATERAL_TRIANGLE)
                    {
                        totalArea += shapes.get(i).getArea();
                    }
                }
            return totalArea;
        }
}