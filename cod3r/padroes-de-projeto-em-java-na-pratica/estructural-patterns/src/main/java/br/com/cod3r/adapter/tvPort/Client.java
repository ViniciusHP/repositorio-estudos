package br.com.cod3r.adapter.tvPort;

import br.com.cod3r.adapter.tvPort.adapters.HDMIToOldMonitorAdapter;
import br.com.cod3r.adapter.tvPort.adapters.HDMIToVGAAdapter;
import br.com.cod3r.adapter.tvPort.devices.Computer;
import br.com.cod3r.adapter.tvPort.devices.OldMonitor;
import br.com.cod3r.adapter.tvPort.devices.TV;

public class Client {

	public static void main(String[] args) {
		String image = "Starcraft II game";
		String sound = "Heaven's Devils";
		Computer pc = new Computer();
		TV tv = new TV();
		pc.connectPort(tv);
		pc.sendImageAndSound(image, sound);
		
		System.out.println("------ Monitor ----------");
		OldMonitor oldMonitor = new OldMonitor();
		Computer pc2 = new Computer();
		pc2.connectPort(new HDMIToVGAAdapter(oldMonitor));
		pc2.sendImageAndSound(image, sound);

		System.out.println("------ Monitor Class Adapter ----------");
		HDMIToOldMonitorAdapter hdmiToOldMonitorAdapter = new HDMIToOldMonitorAdapter();
		Computer pc3 = new Computer();
		pc3.connectPort(hdmiToOldMonitorAdapter);
		pc3.sendImageAndSound(image, sound);

	}
}
