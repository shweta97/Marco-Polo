package isu.tej4m1.marcopolo;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;

public class SettingsActivity extends PreferenceActivity {
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferenceFragment()).commit();
  }

  public static class MyPreferenceFragment extends PreferenceFragment
  {
      @Override
      public void onCreate(final Bundle savedInstanceState)
      {
          super.onCreate(savedInstanceState);
          addPreferencesFromResource(R.xml.mypreference);
      }
  }
}