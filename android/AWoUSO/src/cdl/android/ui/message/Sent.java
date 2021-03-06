package cdl.android.ui.message;

import java.util.ArrayList;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import cdl.android.R;
import cdl.android.model.MessageItem;
import cdl.android.server.ApiRequests;
import cdl.android.ui.bazaar.BazaarAdapter;

public class Sent extends Activity {
	private ArrayList<MessageItem> mItems;
	SharedPreferences mPreferences;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.received);
		
		ListView mListView = (ListView) findViewById(android.R.id.list);
		mListView.setEmptyView(findViewById(android.R.id.empty));
		mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
		String username = mPreferences.getString("username", null);
		
		ApiRequests req = new ApiRequests();
		mItems = req.getSent(username);
		
		mListView.setAdapter(new MessageAdapter(this, mItems, new OnClickListener() {
			public void onClick(View v) {
			}
		}));
	}
}