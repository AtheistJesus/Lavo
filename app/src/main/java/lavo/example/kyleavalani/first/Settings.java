package lavo.example.kyleavalani.first;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.kyleavalani.lavo.R;


/**
 * Created by Lotan on 8/6/2015.
 */
public class Settings extends AppCompatActivity {
    ImageButton contact;
    TextView actbar;
    String url = "http://www.sinnovoapps.com";
    Button logout = null;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayOptions(android.app.ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0B8500")));
        actionBar.setCustomView(R.layout.homeactbar);
        actbar = (TextView)findViewById(R.id.actbarname);


        Typeface type = Typeface.createFromAsset(getAssets(),"Righteous-Regular.ttf");
        actbar.setTypeface(type);
        contact = (ImageButton)findViewById(R.id.contactus);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uriUrl = Uri.parse(url);
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(launchBrowser);
            }
        });

    }
}


