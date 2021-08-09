/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiclesfactory;

/**
 *
 * @author anna
 */
public class Car implements Vehicle {

	/**
	 * 
	 */
	public Car() {
		System.out.println("I am building a Car"); // TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.globinch.pattern.factory.simple.Vehicle#drive()
	 */
	@Override
	public void drive() {
		System.out.println("I am driving a car!");

	}

}