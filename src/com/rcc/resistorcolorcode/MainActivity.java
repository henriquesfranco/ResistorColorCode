package com.rcc.resistorcolorcode;

import android.app.Activity;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.rcc.resistorcolorcode.ColorArrays;
import com.rcc.resistorcolorcode.Code;


public class MainActivity extends Activity {

	ColorArrays spres = new ColorArrays();

	private Spinner sp1;
	private String Digit1Color;

	private Spinner sp2;
	private String Digit2Color;

	private Spinner sp3;
	private String Digit3Color;
	
	private Spinner sp4;
	private String Multiplier;
	
	private Spinner sp5;
	private String Tolerance;
	
	private Spinner sp6;
	private String TemperatureCoefficient;
	
	private RadioGroup radioCodeGroup;
	private String code = "Code 4";
	
	private Button btn1;
	
	private TextView resistance;

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        InitComponents();

        radioCodeGroup.setOnCheckedChangeListener(radioListener);
        
        btn1.setOnClickListener(buttonListener);
        
        setSpinnersListeners();
    }
    
    public void InitComponents(){
        sp1 = (Spinner) findViewById(R.id.sp1); //Digit 1
        sp2 = (Spinner) findViewById(R.id.sp2); //Digit 2
        sp3 = (Spinner) findViewById(R.id.sp3); //Digit 3
        sp4 = (Spinner) findViewById(R.id.sp4); //Multiplier
        sp5 = (Spinner) findViewById(R.id.sp5); //Tolerance
        sp6 = (Spinner) findViewById(R.id.sp6); //Temperature Coefficient
        
        ArrayAdapter<String> arrayAdapterDigit1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spres.getDigit1());
        ArrayAdapter<String> spinnerArrayAdapterDigit1 = arrayAdapterDigit1;
        spinnerArrayAdapterDigit1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        sp1.setAdapter(spinnerArrayAdapterDigit1);

        ArrayAdapter<String> arrayAdapterDigit2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spres.getDigit2());
        ArrayAdapter<String> spinnerArrayAdapterDigit2 = arrayAdapterDigit2;
        spinnerArrayAdapterDigit2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        sp2.setAdapter(spinnerArrayAdapterDigit2);

        ArrayAdapter<String> arrayAdapterDigit3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spres.getDigit3());
        ArrayAdapter<String> spinnerArrayAdapterDigit3 = arrayAdapterDigit3;
        spinnerArrayAdapterDigit3.setDropDownViewResource(android.R.layout.simple_spinner_item);
        sp3.setAdapter(spinnerArrayAdapterDigit3);

        ArrayAdapter<String> arrayAdapterMultiplier = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spres.getMultiplier());
        ArrayAdapter<String> spinnerArrayAdapterMultiplier = arrayAdapterMultiplier;
        spinnerArrayAdapterMultiplier.setDropDownViewResource(android.R.layout.simple_spinner_item);
        sp4.setAdapter(spinnerArrayAdapterMultiplier);

        ArrayAdapter<String> arrayAdapterTolerance = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spres.getTolerance());
        ArrayAdapter<String> spinnerArrayAdapterTolerance = arrayAdapterTolerance;
        spinnerArrayAdapterTolerance.setDropDownViewResource(android.R.layout.simple_spinner_item);
        sp5.setAdapter(spinnerArrayAdapterTolerance);

        ArrayAdapter<String> arrayAdapterTemperatureCoefficient = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spres.getTemperatureCoefficient());
        ArrayAdapter<String> spinnerArrayAdapterTemperatureCoefficient= arrayAdapterTemperatureCoefficient;
        spinnerArrayAdapterTemperatureCoefficient.setDropDownViewResource(android.R.layout.simple_spinner_item);
        sp6.setAdapter(spinnerArrayAdapterTemperatureCoefficient);
        
        sp3.setVisibility(View.INVISIBLE);
        sp6.setVisibility(View.INVISIBLE);
        
        radioCodeGroup = (RadioGroup) findViewById(R.id.radioGroup1);
        
        btn1 = (Button) findViewById(R.id.btn1);
        
        resistance = (TextView) findViewById(R.id.txtv1);
    }
    
    public void RadioSelectedCode(String id){
    	if(id.equals("4 Code")){
            sp3.setVisibility(View.INVISIBLE);
            sp6.setVisibility(View.INVISIBLE);
            code = "Code 4";
    	}

    	if(id.equals("5 Code")){
    		sp3.setVisibility(View.VISIBLE);
            sp6.setVisibility(View.INVISIBLE);
            code = "Code 5";
    	}
    	
    	if(id.equals("6 Code")){
    		sp3.setVisibility(View.VISIBLE);
            sp6.setVisibility(View.VISIBLE);
            code = "Code 6";
    	}
    }
    
    private OnCheckedChangeListener radioListener = new OnCheckedChangeListener() {
    	
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			int id=group.getCheckedRadioButtonId();
			RadioButton selectedRadioButton = (RadioButton) findViewById(id);
			Toast.makeText(getApplicationContext(), "You have selected "+ selectedRadioButton.getText().toString() , Toast.LENGTH_LONG).show();
			RadioSelectedCode(selectedRadioButton.getText().toString());
		}
	};
    
	private OnClickListener buttonListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			String text_resistance = "";
			
			if(code.equals("Code 4")) text_resistance = Code4Text();
			if(code.equals("Code 5")) text_resistance = Code5Text();
			if(code.equals("Code 6")) text_resistance = Code6Text();
			
			resistance.setText(text_resistance);
		}
	};
    
	private void setSpinnersListeners(){
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {
				Digit1Color = parent.getItemAtPosition(posicao).toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
	
			}
		});
        
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {
				Digit2Color = parent.getItemAtPosition(posicao).toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
	
			}
		});

        sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {
				Digit3Color = parent.getItemAtPosition(posicao).toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
	
			}
		});

        sp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {
				Multiplier = parent.getItemAtPosition(posicao).toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
	
			}
		});

        sp5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {
				Tolerance = parent.getItemAtPosition(posicao).toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
	
			}
		});

        sp6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {
				TemperatureCoefficient = parent.getItemAtPosition(posicao).toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
	
			}
		});
	}
	
	private String Code4Text(){
		String txtResistance;

		Code cd = new Code(4, spres.getDigit1().indexOf(Digit1Color), spres.getDigit2().indexOf(Digit2Color), spres.getMultiplier().indexOf(Multiplier), spres.getTolerance().indexOf(Tolerance));
		txtResistance = cd.getResistance();
		
		return txtResistance;
	}

	private String Code5Text(){
		String txtResistance;
		
		Code cd = new Code(5, spres.getDigit1().indexOf(Digit1Color), spres.getDigit2().indexOf(Digit2Color), spres.getDigit3().indexOf(Digit3Color), spres.getMultiplier().indexOf(Multiplier), spres.getTolerance().indexOf(Tolerance));
		txtResistance = cd.getResistance();
		
		return txtResistance;
	}

	private String Code6Text(){
		String txtResistance;
		
		Code cd = new Code(6, spres.getDigit1().indexOf(Digit1Color), spres.getDigit2().indexOf(Digit2Color), spres.getDigit3().indexOf(Digit3Color), spres.getMultiplier().indexOf(Multiplier), spres.getTolerance().indexOf(Tolerance), spres.getTemperatureCoefficient().indexOf(TemperatureCoefficient));
		txtResistance = cd.getResistance();
		
		return txtResistance;
	}
}