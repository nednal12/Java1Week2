package com.bmarohnic.java1week2;

import com.bmarohnic.JSONData.JSON;
import com.bmarohnic.lib.FormThings;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

	String[] mListItems;
	Context _context = this;
	RadioGroup restaurantList;
	TextView result;
	Button b;
	LinearLayout ll;
	LinearLayout.LayoutParams lp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Create Linear Layout
		ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        
        lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ll.setLayoutParams(lp);
		
		//                 LinearLayout entryBox = FormThings.singleEntryWithButtonLayout(this, "Type Something", "Go");
		
		
		
		// setContentView(ll);
		
		// Initialize Constants
		
		mListItems = getResources().getStringArray(R.array.view_array);
		
		// Spinner Adaptor
		ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mListItems);
		spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		// Create the spinner
		Spinner viewSpinner = new Spinner(this);
		viewSpinner.setAdapter(spinnerAdapter);
		
		//LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		viewSpinner.setLayoutParams(lp);
		
		//                   entryBox.addView(viewSpinner);
		//setContentView(entryBox);
		
		//String[] restaurantNames = new String[getResources().getStringArray(R.array.restaurant_array).length];
		
		String[] restaurantNames;
		restaurantNames = getResources().getStringArray(R.array.restaurant_array);
		
		restaurantList = FormThings.getOptions(this, restaurantNames);
		
		
		// Button
		
		b = new Button(this);
		
		
		b.setText("Get JSON");
		
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Get info from JSON
				int selectedRadioId = restaurantList.getCheckedRadioButtonId();
				RadioButton selectedRadio = (RadioButton) restaurantList.findViewById(selectedRadioId);
				String selected = selectedRadio.getText().toString();
				result.setText(JSON.readJSON(selected));
				
			}
		});
		
		//                   ll.addView(entryBox);
		
		//ll.addView(viewSpinner);
		
		ll.addView(restaurantList);
		ll.addView(b);
		
		
		// Set Result View
		result = new TextView(this);
		result.setLayoutParams(lp);
		ll.addView(result);
		
		// Set Content View
		setContentView(ll);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
