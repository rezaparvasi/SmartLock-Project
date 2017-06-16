package com.smartlock.smartlock;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button lockButton = (Button) findViewById(R.id.lock_button_main);
        lockButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {

                        ImageView lockImage = (ImageView) findViewById(R.id.lockImage_main);
                        lockImage.setImageResource(R.drawable.locked);
                        lockImage.setColorFilter(Color.argb(255, 39, 196, 8));

                        TextView status_text = (TextView)findViewById(R.id.status_textview_main);
                        status_text.setText("Status: LOCKED");

                        /*-----------------------------------------------------------------*/
                        // add here all the code to send the request to the raspberry pi   //
                        /*-----------------------------------------------------------------*/

                    }
                }

        );

        Button unlockButton = (Button) findViewById(R.id.u_button_main);
        unlockButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){

                        ImageView lockImage = (ImageView)findViewById(R.id.lockImage_main);
                        lockImage.setImageResource(R.drawable.unlocked);
                        lockImage.setColorFilter(Color.argb(255,207,12,29));

                        TextView status_text = (TextView)findViewById(R.id.status_textview_main);
                        status_text.setText("Status: UNLOCKED");



                        /*---------------------------------------------------------------------*/
                        // add here all the code to send the UNLOCK request to the raspberry pi//
                        /*---------------------------------------------------------------------*/
                    }
                }

        );


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.smartlock.smartlock/http/host/path")
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
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.smartlock.smartlock/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
