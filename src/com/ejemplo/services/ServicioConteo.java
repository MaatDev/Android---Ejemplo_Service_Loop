package com.ejemplo.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class ServicioConteo extends Service{
	
	private final int tempo = 1*1000;
	
	private boolean isRunning = false;
	
	private miTarea task;
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		task = new miTarea();
		Log.v("Droidnova","Se creó el servicio");
	}
	
	@Override
	public synchronized void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
		Log.v("Droidnova", "Comenzó el onStart");
		
		if(!isRunning){
			isRunning = true;
			task.start();
			
		}
	}
	
	@Override
	public synchronized void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.v("Droidnova","Termino service ");
		
		if(isRunning){
			
	
		task.interrupt();
		
		
		}
		task = null;
	}
	

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	class miTarea extends Thread{
		@Override
		public void run() {
			int time_limiter = 20;
			int counter =0;
			Log.v("Droidnova","Estoy ejecutando mi tarea");
			while(isRunning && counter != time_limiter+1){
				try {
					Log.v("Droidnova","Segundos: "+counter);
					counter++;
					Thread.sleep(tempo);
				} catch (InterruptedException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
					isRunning = false;
				}
			}
			isRunning = false;
			
		}
		
		
	}

}
