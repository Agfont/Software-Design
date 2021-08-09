/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiclesfactory;

/**
 * VehicleFactory.
 * 
 * @author Binu George
 * @since 2013
 * @version 1.0
 */
import java.util.HashMap;
import java.util.Map;


public enum VehicleFactory {
	INSTANCE;

	private Map<String, Vehicle> vehicles = new HashMap<String, Vehicle>();
	/**
	 * Method to create vehicle types
	 * @param vehicleType
	 * @return Vehicle
	 * @throws Exception
	 */
	public Vehicle createVehicle(String vehicleType)
			throws Exception {
		Vehicle vehicle = vehicles.get(vehicleType);
		if (vehicle != null) {
				return vehicle;
		} else {
			try {
				String name = Vehicle.class.getPackage().getName();
				vehicle = (Vehicle) Class.forName(name+"."+vehicleType).newInstance();
				vehicles.put(vehicleType, vehicle);
				return vehicle;
			} catch (Exception e) {
					throw new Exception("The vehicle type is unknown!");
			}
		}

	}
}