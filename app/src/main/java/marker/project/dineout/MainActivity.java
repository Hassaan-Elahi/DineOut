package marker.project.dineout;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import ReportingModule.EndOfDay_EventHandler;


public class MainActivity extends AppCompatActivity
{

    public Context context = this;

    /*
    public void Send_Mail()
    {
        try
        {
            GMailSender sender = new GMailSender("dineoutx@gmail.com","ShafaqAirlines78");

            sender.addAttachment(c.getFilesDir()+"/files/"+DEST);

            sender.sendMail( TypeOfReport, "This mail has been sent from android app along with sales report...This is auto generated email please donnot reply",

                    "dineoutx@gmail.com",

                    "arshadshafaq15@gmail.com");






        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }*/


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
                EndOfDay_EventHandler handler = new EndOfDay_EventHandler(context);
                handler.HandleCloseDayEvent();
                //print email sent

            }
        });





    }


}
