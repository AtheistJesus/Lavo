package lavo.example.kyleavalani.first;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.kyleavalani.lavo.R;
import com.parse.ParseObject;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Lotan on 7/19/2015.
 */
public class SingleItemView extends Activity {
    TextView evntname;
    TextView txtname;
    TextView locat;
    TextView date;
    TextView time;

    TextView email;

    String emaill;

    String evntnam;
    String addr;
    String name;
    String dat;
    String tim;
    ImageButton going;
    ImageButton map;
    ImageButton sendEmail;
    List<ParseObject> ob;

    ArrayAdapter<String> adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from singleitemview.xml
        setContentView(R.layout.singleitemview);

        Intent i = getIntent();

        name = i.getStringExtra("description");
        txtname = (TextView) findViewById(R.id.description);
        txtname.setText(name);

        evntname = (TextView)findViewById(R.id.eventnamme);
        evntnam = i.getStringExtra("name");
        evntname.setText(evntnam);

        locat = (TextView) findViewById(R.id.location);
        addr = i.getStringExtra("Address");
        locat.setText(addr);

        date = (TextView) findViewById(R.id.date1);
        dat = i.getStringExtra("Date");
        date.setText(dat);

        time = (TextView) findViewById(R.id.time1);
        tim = i.getStringExtra("Time");
        time.setText(tim);

        email = (TextView) findViewById(R.id.email1);
        emaill = i.getStringExtra("Email");
        email.setText(emaill);


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



        map = (ImageButton) findViewById(R.id.map1);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String map = "http://maps.google.co.in/maps?q=" + addr;
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                startActivity(i);

            }
        });


        sendEmail = (ImageButton) findViewById(R.id.sendingEmail);
        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri data = Uri.parse("mailto:?subject=" + emaill);
                intent.setData(data);
                startActivity(intent);

            }
        });


    }


}

