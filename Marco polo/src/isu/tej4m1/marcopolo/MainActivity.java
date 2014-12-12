package isu.tej4m1.marcopolo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;



public class MainActivity extends ListActivity {
	
	String Get_Name = "isu.tej4m1.marcopolo.new_item";
	
	static final int PICK_CONTACT_REQUEST = 0;
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
	
	ArrayList<String> item_list = new ArrayList<String>();
	ArrayAdapter<String> adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		 
		//setContentView(R.layout.activity_main);
		
		SharedPreferences sharedPref = MainActivity.this.getPreferences(Context.MODE_PRIVATE);
		String defaultValue = getResources().getString(R.string.save);
		Set defaultValue1=new HashSet(item_list);
		Set<String> name1 = sharedPref.getStringSet("isu.tej4m1.marcopolo.MainActivity.onActivityResult",defaultValue1); 
		
		name1.addAll(item_list);
		item_list.clear();
		item_list.addAll(name1);
		
	   adapter = new ArrayAdapter<String>(this,
	        android.R.layout.simple_list_item_1, item_list);
	   setListAdapter(adapter);
	  }

	  @Override
	  protected void onListItemClick(ListView l, View v, int position, long id) {
	    String item = (String) getListAdapter().getItem(position);
	    Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();
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
		if (id == R.id.action_new) {
			new_device();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	/** Called when the user clicks the Send button */
	public void new_device() {
		Intent intent = new Intent(this, DisplayMessageActivity.class);
		startActivityForResult(intent, PICK_CONTACT_REQUEST);
	}
	
	public void onActivityResult (int requestCode, int resultCode, Intent data) {
		
		if(requestCode == PICK_CONTACT_REQUEST) {
			if (resultCode == Activity.RESULT_OK) {
		
				String name = data.getStringExtra(Get_Name);
				//final TextView item = (TextView) findViewById(R.id.textView4);
				//item.setText(name);
				//Code for ArrayAdapter
				item_list.add(name);
				adapter.notifyDataSetChanged(); 
				
				SharedPreferences sharedPref = MainActivity.this.getPreferences(Context.MODE_PRIVATE);
				SharedPreferences.Editor editor = sharedPref.edit();
				Set set = new HashSet(item_list);
				editor.putStringSet("isu.tej4m1.marcopolo.MainActivity.onActivityResult",set);
				editor.commit();
			}
		}
		
		
	}
	
}

