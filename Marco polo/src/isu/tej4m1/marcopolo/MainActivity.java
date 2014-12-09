package isu.tej4m1.marcopolo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;



public class MainActivity extends Activity {
	
	String Get_Name = "isu.tej4m1.marcopolo.new_item";
	
	static final int PICK_CONTACT_REQUEST = 0;
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final TextView item = (TextView) findViewById(R.id.textView4);
		item.setText("Hello");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	/** Called when the user clicks the Send button */
	public void new_device(View view) {
		Intent intent = new Intent(this, DisplayMessageActivity.class);
		startActivityForResult(intent, PICK_CONTACT_REQUEST);
	}
	
	public void onActivityResult (int requestCode, int resultCode, Intent data) {
		
		if(requestCode == PICK_CONTACT_REQUEST) {
			if (resultCode == Activity.RESULT_OK) {
		
				String name = data.getStringExtra(Get_Name);
				final TextView item = (TextView) findViewById(R.id.textView4);
				item.setText(name);
			}
		}
	}
}



