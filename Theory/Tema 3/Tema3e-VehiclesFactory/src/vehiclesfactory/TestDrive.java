/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiclesfactory;

/**
 * Test VehicleFactory.
 * 
 * @author Binu George
 * @since 2013
 * @version 1.0
 */
public class TestDrive {

	/**
	 * 
	 */
	public TestDrive() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Main test method
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			VehicleFactory factory = VehicleFactory.INSTANCE;
			Vehicle  vehicle = factory.createVehicle(VehicleTypes.Car.name());
			vehicle.drive();
			vehicle = factory.createVehicle(VehicleTypes.Truck.name());
			vehicle.drive();
			vehicle = factory.createVehicle(VehicleTypes.Car.name());
			vehicle.drive();
			vehicle = factory.createVehicle("Truck2");
			vehicle.drive();
		} catch (Exception e) {
				System.out.println(e.getMessage());
		}
	}

}