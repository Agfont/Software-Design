
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maria, anna
 */
  
public class BeatController implements ControllerInterface {

	private volatile static BeatController uniqueInstance;

	BeatModel model;
	DJView view;

	private BeatController() {
	}


	public static BeatController getInstance(BeatModel model) {
		if (uniqueInstance == null) {
			synchronized (BeatController.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new BeatController();
					uniqueInstance.model = model;
					uniqueInstance.view = new DJView(uniqueInstance, model);
					uniqueInstance.view.createView();
					uniqueInstance.view.createControls();
					uniqueInstance.view.disableStopMenuItem();
					uniqueInstance.view.enableStartMenuItem();
					model.initialize();
				}
			}
		}
		return uniqueInstance;
	}
  
	public void start() {
		model.on();
		view.disableStartMenuItem();
		view.enableStopMenuItem();
	}
  
	public void stop() {
		model.off();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
	}
    
	public void increaseBPM() {
        int bpm = model.getBPM();
        model.setBPM(bpm + 1);
	}
    
	public void decreaseBPM() {
        int bpm = model.getBPM();
        model.setBPM(bpm - 1);
  	}
  
 	public void setBPM(int bpm) {
		model.setBPM(bpm);
	}
}
