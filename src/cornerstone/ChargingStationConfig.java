package cornerstone;

public class ChargingStationConfig {
	
	public String defaultConfig;	
	public String ioMap;
	public final String sVersion = "V46.2.1";
	//V0.32 Auto clear old log, LPRS function added
	//V0.33 Time Selection function added, time sync to server, try to fix stuck at initialize
	//V0.35 Current more accurate, StopTransaction reason correction
	//V0.36 Add onboard RS485, Websocket check before close
	//V0.37 Fix multiple chrager state update
	//V0.38 Fix tid mismatch on overnight session
	//V0.39 Fix TimeSelection mode hang at time's up
	//V0.40 Add new UI
	//V0.42.01A0 : unlock button with new UI; NEC Lprs has been added;
	//V0.42.03A3 : Lprs improve reconnection to IPC when link lost
	//V0.43.00XX : QRcode with NEC LPRS; add PCB hardware version 1.5; add SPM91 version options; Note: This version is still under-development
	//V0.44 Add OCPP websocket encryption; Remove SPM91 power meter subversion option as production will only implement the standard version; GPIO update configure for V1.5 PCB
	//V0.45 Update time select function
    //V0.45.05 Update webcam capture function
	//V0.45.07 Update NEC LPRS: add time sync request message; add reading power factor from power meter
	public final String sVersionSim = "hwV2_5-2a chargic-AC off unlock-v5";
	public enum State {	
		Authorize,
		Authorized,
		Authorizing,
		Charging,
		CPError,
		Expire,
		Fault,
		Initialize,
		Locked,
		NetworkDown,
		Pause,
		Plugging,
		Ready,
		Replug,
		Unavailable,
		Unlock,
		Unlocked,
		Unplug,
		Unregister,
		Ventilation,
		Startup,			// added for avoid status as null whenever 1st call of setState
		CriticalFault;
	}
	
	public ChargingStationConfig() {

		
		defaultConfig = "{"
				+ "\"Admin Card\":{"
					+ "\"Authority\":\"Admin\","
					+ "\"Type\":\"Text\","
					+ "\"Value\":\"3B9BD872\"},"
//				+ "\"Time Slot 1\":{"
//					+ "\"Authority\":\"Everyone\","
//					+ "\"Type\":\"Text\","
//					+ "\"Value\":\"60\"},"
//				+ "\"Time Slot 2\":{"
//					+ "\"Authority\":\"Everyone\","
//					+ "\"Type\":\"Text\","
//					+ "\"Value\":\"120\"},"
//				+ "\"Time Slot 3\":{"
//					+ "\"Authority\":\"Everyone\","
//					+ "\"Type\":\"Text\","
//					+ "\"Value\":\"180\"},"
				+ "\"Time Slot Maximum (Min)\":{"
					+ "\"Authority\":\"Admin\","
					+ "\"Type\":\"Text\","
					+ "\"Value\":\"480\"},"
				+ "\"Time Select Fully Charge\":{"
					+ "\"Authority\":\"Admin\","
					+ "\"Type\":\"Selection\","
					+ "\"Value\":\"Hidden\","
					+ "\"Option\":[\"Show\",\"Hidden\"]},"
				+ "\"Time Select Stop Button\":{"
					+ "\"Authority\":\"Admin\","
					+ "\"Type\":\"Selection\","
					+ "\"Value\":\"Hidden\","
					+ "\"Option\":[\"Show\",\"Hidden\"]},"
				+ "\"Time Zone\":{"
					+ "\"Authority\":\"Admin\","
					+ "\"Type\":\"Range\","
					+ "\"Value\":\"8\","
					+ "\"Option\":[-12,13,1]},"
				+ "\"Clock\":{"
					+ "\"Authority\":\"Everyone\","
					+ "\"Type\":\"Selection\","
					+ "\"Value\":\"Hidden\","
					+ "\"Option\":[\"Show\",\"Hidden\"]},"
				+ "\"Charging detail\":{"
					+ "\"Authority\":\"Admin\","
					+ "\"Type\":\"Selection\","
					+ "\"Value\":\"Hidden\","
					+ "\"Option\":[\"Show\",\"Hidden\"]},"
				+ "\"Window\":{"
					+ "\"Authority\":\"Admin\","
					+ "\"Type\":\"Selection\","
					+ "\"Value\":\"Full\","
					+ "\"Option\":[\"Full\",\"Shrink\"]},"
				+ "\"Hardware Version\":{"
					+ "\"Authority\":\"Admin\","
					+ "\"Type\":\"Selection\","
					+ "\"Value\":\"V2_5\","
					+ "\"Option\":[\"V2_0\",\"V1_0\",\"V1_5\",\"V1_6\",\"V2_5\",\"V0_3\"]},"
				+ "\"Type\":{"
					+ "\"Authority\":\"Admin\","
					+ "\"Type\":\"Selection\","
					+ "\"Value\":\"Socket\","
					+ "\"Option\":[\"Socket\",\"Cable\"]},"
				+ "\"Phase\":{"
					+ "\"Authority\":\"Admin\","
					+ "\"Type\":\"Selection\","
					+ "\"Value\":\"3 Phase\","
					+ "\"Option\":[\"3 Phase\",\"1 Phase (L1)\",\"1 Phase (L2)\",\"1 Phase (L3)\"]},"
				+ "\"Maximum Capacity (A)\":{"
					+ "\"Authority\":\"Admin\","
					+ "\"Type\":\"Range\","
					+ "\"Value\":32,"
					+ "\"Option\":[0,32,1]},"
				+ "\"Default Capacity (A)\":{"
					+ "\"Authority\":\"Everyone\","
					+ "\"Type\":\"Range\","
					+ "\"Value\":32,"
					+ "\"Option\":[0,32,1]},"
				+ "\"CP PWM offset(mA)\":{"
					+ "\"Authority\":\"Admin\","
					+ "\"Type\":\"Range\","
					+ "\"Value\":0,"
					+ "\"Option\":[0,3000,100]},"	
				+ "\"Authentication\":{"
					+ "\"Authority\":\"Admin\","
					+ "\"Type\":\"Selection\","
					+ "\"Value\":\"NFC\","
					+ "\"Option\":[\"Plug & Charge\",\"Key\",\"SmartPad\",\"TimeSelect\",\"NFC\",\"Subscription\",\"Monthly\",\"Kiosk\",\"Autotoll\"]},"
				+ "\"Server Path\":{"
					+ "\"Authority\":\"Everyone\","
					+ "\"Type\":\"Text\","
					+ "\"Value\":\"ws://127.0.0.1:8086/ocpp/\"},"
				+ "\"Remote OCPP Server Path\":{"
					+ "\"Authority\":\"Everyone\","
					+ "\"Type\":\"Text\","
					+ "\"Value\":\"\"},"
				+ "\"Remote OCPP Server Username\":{"
					+ "\"Authority\":\"Everyone\","
					+ "\"Type\":\"Text\","
					+ "\"Value\":\"\"},"
				+ "\"Remote OCPP Server Password\":{"
					+ "\"Authority\":\"Everyone\","
					+ "\"Type\":\"Text\","
					+ "\"Value\":\"\"},"
				+ "\"Backdoor Server\":{"
					+ "\"Authority\":\"Admin\","
					+ "\"Type\":\"Text\","
					+ "\"Value\":\"ws://13.251.111.103:8080/cpms/ocpp/\"},"
				+ "\"Serial No\":{"
					+ "\"Authority\":\"Admin\","
					+ "\"Type\":\"Text\","
					+ "\"Value\":\"0\"},"
				+ "\"Station Name\":{"
					+ "\"Authority\":\"Everyone\","
					+ "\"Type\":\"Text\","
					+ "\"Value\":\"CP01\"},"
				+ "\"Network Timeout (ms)\":{"
					+ "\"Authority\":\"Everyone\","
					+ "\"Type\":\"Range\","
					+ "\"Value\":5000,"
					+ "\"Option\":[500,30000,500]},"
				+ "\"Auto Unlock Interval (ms)\":{"
					+ "\"Authority\":\"Everyone\","
					+ "\"Type\":\"Range\","
					+ "\"Value\":0,"
					+ "\"Option\":[0,10000,100]},"
				+ "\"UART Port\":{"
					+ "\"Authority\":\"Admin\","
					+ "\"Type\":\"Selection\","
					+ "\"Value\":\"RS485\","
					+ "\"Option\":[\"RS232\",\"RS485\"]},"
				+ "\"LPRS Engine\":{"
					+ "\"Authority\":\"Admin\","
					+ "\"Type\":\"Text\","
					+ "\"Value\":\"0.0.0.0\"},"
				+ "\"LPRS Engine Port\":{"
					+ "\"Authority\":\"Admin\","
					+ "\"Type\":\"Range\","
					+ "\"Value\":4445,"
					+ "\"Option\":[0,4500,1]},"	
				+ "\"LPRS\":{"
					+ "\"Authority\":\"Admin\","
					+ "\"Type\":\"Text\","
					+ "\"Value\":\"0.0.0.0\"},"
				+ "\"End upon state A\":{"
					+ "\"Authority\":\"Admin\","
					+ "\"Type\":\"Selection\","
					+ "\"Value\":\"Yes\","
					+ "\"Option\":[\"Yes\",\"No\"]},"
					
				+ "\"Total LEDs number\":{"
					+ "\"Authority\":\"Everyone\","
					+ "\"Type\":\"Range\","
					+ "\"Value\":16,"
					+ "\"Option\":[0,500,1]},"		

				+ "\"LED strips\":{"
					+ "\"Authority\":\"Everyone\","
					+ "\"Type\":\"Range\","
					+ "\"Value\":1,"
					+ "\"Option\":[0,10,1]},"					
				
				+ "\"Over-Current Protection\":{"
					+ "\"Authority\":\"Admin\","
					+ "\"Type\":\"Selection\","
					+ "\"Value\":\"No\","
					+ "\"Option\":[\"Yes\",\"No\"]},"	

				+ "\"Over-Current Margin(%)\":{"
					+ "\"Authority\":\"Admin\","
					+ "\"Type\":\"Range\","
					+ "\"Value\":0,"
					+ "\"Option\":[0,30,1]},"					
				
				+ "\"Charger current consumption(mA)\":{"
					+ "\"Authority\":\"Admin\","
					+ "\"Type\":\"Range\","
					+ "\"Value\":200,"
					+ "\"Option\":[0,1000,1]},"		

				+ "\"CardReader Type\":{"
					+ "\"Authority\":\"Admin\","
					+ "\"Type\":\"Selection\","
					+ "\"Value\":\"ACR122U\","
					+ "\"Option\":[\"ACR122U\",\"CLRC663\"]},"		
				
				+ "\"Powermeter Type\":{"
					+ "\"Authority\":\"Admin\","
					+ "\"Type\":\"Selection\","
					+ "\"Value\":\"ADE7754\","
//					+ "\"Option\":[\"ADE7754\",\"SPM91_Factor_10\",\"SPM91_Factor_100\",\"SPM93\"]},"
					+ "\"Option\":[\"ADE7754\",\"SPM91\",\"SPM93\"]},"
				+ "\"Offboard Powermeter Link\":{"
					+ "\"Authority\":\"Admin\","
					+ "\"Type\":\"Selection\","
					+ "\"Value\":\"USB\","
					+ "\"Option\":[\"USB\",\"RS485\"]},"
					
				+ "\"Powermeter ID\":{"
					+ "\"Authority\":\"Admin\","
					+ "\"Type\":\"Text\","
					+ "\"Value\":\"99\"}"
				+ "}";	
		
		
		ioMap = "{"
				+ "\"V0_3\":{"
					+ "\"ADC_REFERENCE\":3400,"
					+ "\"PROXIMITY_PULLUP\":390,"
					+ "\"ADC\":7,"
					+ "\"ADC_CP\":3,"
					+ "\"ADC_PP\":2,"
					+ "\"ADC_TEMP\":4,"
					+ "\"CP\":0,"
					+ "\"PowerMeter\":22,"
					+ "\"Enable1\":5,"
					+ "\"Enable2\":10,"
					+ "\"Enable3\":4,"
					+ "\"Enable31\":3,"
					+ "\"Enable21\":6,"
					+ "\"Lock\":8,"
					+ "\"LockState\":9,"
					+ "\"Input1\":29,"
					+ "\"Input2\":28,"
					+ "\"Input3\":25,"
					+ "\"Input4\":27,"
					+ "\"Output1\":24,"
					+ "\"Output2\":23,"
					+ "\"Output3\":26},"
				+ "\"V1_0\":{"									
					+ "\"ADC_REFERENCE\":5000,"
					+ "\"PROXIMITY_PULLUP\":390,"
					+ "\"ADC\":9,"
					+ "\"ADC_CP\":1,"
					+ "\"ADC_PP\":0,"
					+ "\"ADC_TEMP\":3,"
					+ "\"CP\":0,"
					+ "\"PowerMeter\":8,"
					+ "\"Enable1\":5,"
					+ "\"Enable2\":3,"
					+ "\"Enable3\":3,"
					+ "\"Enable31\":6,"
					+ "\"Enable21\":4,"
					+ "\"Lock\":2,"
					+ "\"LockState\":0,"
					+ "\"Input1\":11,"
					+ "\"Input2\":21,"
					+ "\"Input3\":26,"
					+ "\"Input4\":22,"
					+ "\"Output1\":27,"
					+ "\"Output2\":24,"
					+ "\"Output3\":28},"
				+ "\"V1_5\":{"									
					+ "\"ADC_REFERENCE\":5000,"
					+ "\"PROXIMITY_PULLUP\":390,"
					+ "\"ADC\":9,"
					+ "\"ADC_CP\":1,"
					+ "\"ADC_PP\":0,"
					+ "\"ADC_TEMP\":3,"
					+ "\"CP\":0,"
					+ "\"PowerMeter\":8,"
					+ "\"EnableN\":4,"
					+ "\"EnableL1\":5,"
					+ "\"EnableL2L3\":3,"
					+ "\"Enable31\":6,"
					+ "\"Enable21\":4,"
					+ "\"Lock\":2,"
					+ "\"LockState\":0,"
					+ "\"Input1\":11,"
					+ "\"Input2\":21,"
					+ "\"Input3\":26,"
					+ "\"Input4\":22,"
					+ "\"Output1\":27,"
					+ "\"Output2\":24,"
					+ "\"Output3\":28},"				
				+ "\"V1_6\":{"									
					+ "\"ADC_REFERENCE\":5000,"
					+ "\"PROXIMITY_PULLUP\":390,"
					+ "\"ADC\":9,"
					+ "\"ADC_CP\":1,"
					+ "\"ADC_PP\":0,"
					+ "\"ADC_TEMP\":3,"
					+ "\"CP\":0,"
					+ "\"PowerMeter\":8,"
					+ "\"EnableN\":4,"
					+ "\"EnableL1\":5,"
					+ "\"EnableL2L3\":3,"
					+ "\"Enable31\":6,"
					+ "\"Enable21\":4,"
					+ "\"Lock\":2,"
					+ "\"LockState\":0,"
					+ "\"RS485_DIR\":7,"
					+ "\"Input1\":11,"
					+ "\"Input2\":21,"
					+ "\"Input3\":26,"
					+ "\"Input4\":22,"
					+ "\"Output1\":27,"
					+ "\"Output2\":24,"
					+ "\"Output3\":28},"
				+ "\"V2_0\":{"
					+ "\"ADC_REFERENCE\":5000,"
					+ "\"PROXIMITY_PULLUP\":390,"
					+ "\"ADC\":8,"
					+ "\"ADC_CP\":1,"
					+ "\"ADC_PP\":0,"
					+ "\"ADC_TEMP\":3,"
					+ "\"CP\":0,"
					+ "\"PowerMeter\":9,"
					+ "\"Enable1\":4,"
					+ "\"Enable2\":5,"
					+ "\"Enable3\":5,"
					+ "\"Enable31\":2,"
					+ "\"Enable21\":3,"
					+ "\"Lock\":0,"
					+ "\"LockState\":21,"
					+ "\"RCD\":11,"
					+ "\"RCDRST\":6,"
					+ "\"Input1\":24,"
					+ "\"Input2\":28,"
					+ "\"Input3\":25,"
					+ "\"Input4\":29,"
					+ "\"Output1\":26,"
					+ "\"Output2\":23,"
					+ "\"Output3\":27},"

				+ "\"V2_5\":{"									
					+ "\"ADC_REFERENCE\":5000,"
					+ "\"PROXIMITY_PULLUP\":330,"
					+ "\"ADC\":28,"
					+ "\"ADC_CP\":1,"
					+ "\"ADC_PP\":0,"
					+ "\"ADC_TEMP\":2,"
					+ "\"ADC_P12VSENSE\":3,"
					+ "\"ADC_N12VSENSE\":4,"
					+ "\"CP\":0,"
					+ "\"ADE7854A_CS\":27,"
					+ "\"RL1_EN\":4,"
					+ "\"RL2_EN\":3,"
					+ "\"Lock\":8,"
					+ "\"Lock2\":9,"
					+ "\"LockState\":7,"
					+ "\"RL1_STATUS\":5,"
					+ "\"RL2_STATUS\":2,"
					+ "\"Input3\":26,"
					+ "\"AC_OK\":6,"
					+ "\"12V_OK\":10,"
					+ "\"ADE7854A_IRQ0\":21,"
					+ "\"ADE7854A_IRQ1\":11,"
					+ "\"ADE7854A_RST\":24,"
					+ "\"CLRC663_CS\":25,"
					+ "\"RS485_DIR\":0,"
					+ "\"ESTOP\":22,"
					+ "\"Input4\":29,"
					+ "\"Output1\":27,"
					+ "\"Output3\":28}}";	
	}

}
