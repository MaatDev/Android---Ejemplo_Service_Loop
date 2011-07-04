package com.ejemplo.services;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Ventana extends Activity implements OnClickListener{
	
	Button btn_Start;
	Button btn_Stop;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        btn_Start = (Button) findViewById(R.id.btn_Start);
        btn_Stop = (Button) findViewById(R.id.btn_Stop);
        
        btn_Start.setOnClickListener(this);
        btn_Stop.setOnClickListener(this);
        
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId()){
			case R.id.btn_Start:
				startService(new Intent(this, ServicioConteo.class));
			break;
			
			case R.id.btn_Stop:
				stopService(new Intent(this, ServicioConteo.class));
			break;
		
		
		}
		
		
	}
}