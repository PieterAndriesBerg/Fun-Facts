package nl.pieterandriesberg.funfacts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FunFactsActivity extends AppCompatActivity {
    public static final String TAG = FunFactsActivity.class.getSimpleName();
    private ColorWheel colorWheel = new ColorWheel(); //  creating a new ColorWheel
    private FactBook factBook = new FactBook(); // creating a new FactBook

    // Declare our view variables
    private TextView factTextView;
    private Button showFactButton;
    private RelativeLayout relativeLayout;


    //The onCreate() method is called when our activity is first created (started)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts); // Tells which layout file to use for the screen (activity_fun_facts)

        // Assign the views from the layout file to the corresponding variables
        factTextView = findViewById(R.id.factTextView);
        showFactButton = findViewById(R.id.showFactButton);
        relativeLayout = findViewById(R.id.relativeLayout);

        View.OnClickListener listener = new View.OnClickListener() { // creating a onClickListener names listener
            @Override
            public void onClick(View v) {
                String fact = factBook.getFact();

                // Update the screen with our new fact from FactBook class
                factTextView.setText(fact);

                // Change background color when button gets clicked
                int color = colorWheel.getColor();
                relativeLayout.setBackgroundColor(color);
                showFactButton.setTextColor(color);
            }
        };
        showFactButton.setOnClickListener(listener); // using the onClickListener above (listener)

//        Toast.makeText(this,"Yay! Our Activity was created!",Toast.LENGTH_SHORT).show();
        Log.d(TAG, "We're logging from the onCreate() method!");
    }
}
