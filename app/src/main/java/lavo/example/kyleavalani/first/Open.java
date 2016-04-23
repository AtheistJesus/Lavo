package lavo.example.kyleavalani.first;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kyleavalani.lavo.R;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;


public class Open extends ActionBarActivity {
    ListView listview;
    List<ParseObject> ob;
    ProgressDialog mProgressDialog;
    ArrayAdapter<String> adapter;


    TextView evntname;
    TextView txtname;
    TextView locat;
    TextView date;
    TextView time;
    String evntnam;
    String addr;
    String name;
    String dat;
    String tim;
    ImageButton going;
    ImageButton map;

    TextView actbar;
    Button logout;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events);

        Parse.initialize(this, "howoPxDk45oOAjw9hFzFqtbmBwYeYuHNlTgkV1IN", "HjWYmxK9w1bJ8KTFtzUPZpuZBCO2RhEcdFvVAeZK");

        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayOptions(android.app.ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0B8500")));
        actionBar.setCustomView(R.layout.homeactbar);
        actbar = (TextView) findViewById(R.id.actbarname);


        Typeface type = Typeface.createFromAsset(getAssets(), "Righteous-Regular.ttf");
        actbar.setTypeface(type);


        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();

        defaultACL.setPublicReadAccess(true);

        ParseACL.setDefaultACL(defaultACL, true);

/*


        ParseQuery<ParseObject> query = ParseQuery.getQuery("Event");
        query.orderByDescending("_created_at");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> eventList, ParseException e) {
                if (e == null) {
                    if (eventList.size()>0) {

                        for (int j = 0; j < eventList.size(); j++) {

                            ParseObject i = eventList.get(j);
                            name = i.getString("description");

                            txtname = (TextView) findViewById(R.id.description);
                            txtname.setText(name);
                            evntname = (TextView) findViewById(R.id.eventnamme);
                            evntnam = i.getString("name");
                            evntname.setText(evntnam);

                            locat = (TextView) findViewById(R.id.location);
                            addr = i.getString("Address");
                            locat.setText(addr);

                            date = (TextView) findViewById(R.id.date1);
                            dat = i.getString("Date");
                            date.setText(dat);

                            time = (TextView) findViewById(R.id.time1);
                            tim = i.getString("Time");
                            time.setText(tim);
                        } }

                }
                else {
                    Log.d("score", "Error: " + e.getMessage());
                    // Alert.alertOneBtn(getActivity(),"Something went wrong!");
                }
            }
        });

*/


        ParseUser.enableAutomaticUser();

        defaultACL.setPublicReadAccess(true);

        ParseACL.setDefaultACL(defaultACL, true);




/*
        going = (ImageButton) findViewById(R.id.imageButton);
        going.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                Intent intent = new Intent(Intent.ACTION_INSERT)
                        .setData(CalendarContract.Events.CONTENT_URI)
                        .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, dat)
                        .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, tim)
                        .putExtra(CalendarContract.Events.TITLE, evntnam)
                        .putExtra(CalendarContract.Events.DESCRIPTION, name)
                        .putExtra(CalendarContract.Events.EVENT_LOCATION, addr)
                        .putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY);
                startActivity(intent);
            }
        });
*/

        new RemoteDataTask().execute();
/*
        map = (ImageButton) findViewById(R.id.map1);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String map = "http://maps.google.co.in/maps?q=" + addr;
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                startActivity(i);

            }
        });

*/


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Open Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://lavo.example.kyleavalani.first/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Open Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://lavo.example.kyleavalani.first/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }


    private class RemoteDataTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(Open.this);
            mProgressDialog.setTitle("Loading local events...");
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Event");
            //query.whereEqualTo("Type", "outdoor");
            query.orderByDescending("_created_at");
            try {
                ob = query.find();
            } catch (ParseException e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            listview = (ListView) findViewById(android.R.id.list);
            adapter = new ArrayAdapter<String>(Open.this,
                    R.layout.list_item_layout);
            for (ParseObject event : ob) {
                adapter.add((String) event.get("name"));


            }
            listview.setAdapter(adapter);
            mProgressDialog.dismiss();

            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    Intent i = new Intent(Open.this,
                            SingleItemView.class);
                    i.putExtra("description", ob.get(position).getString("description")
                            .toString());
                    i.putExtra("Address", ob.get(position).getString("Address").toString());
                    i.putExtra("Date", ob.get(position).getString("Date").toString());
                    i.putExtra("Time", ob.get(position).getString("Time").toString());

                    i.putExtra("Email", ob.get(position).getString("Email").toString());

                    startActivity(i);
                }
            });

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(Open.this, Settings.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }
}



