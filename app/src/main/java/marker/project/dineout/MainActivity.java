package marker.project.dineout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button end_button = findViewById(R.id.end_button);

        end_button.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String email = "hassaan.elahi15@gmail.com";

            }
        });





    }


}
