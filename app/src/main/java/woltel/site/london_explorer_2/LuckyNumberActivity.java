package woltel.site.london_explorer_2;




import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class LuckyNumberActivity extends AppCompatActivity {
    TextView welcomeTxt, luckyNumberTxt;
    Button share_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_number);

        welcomeTxt = findViewById(R.id.textView2);
        luckyNumberTxt = findViewById(R.id.lucky_number_txt);
        share_btn = findViewById(R.id.share_number_btn);

//Username
        Intent i = getIntent();
        String userName = i.getStringExtra("name");

        //Toast.makeText(this,
        //"Username: "+userName,
        // Toast.LENGTH_SHORT).show();



        //Random Number Generated

        int random_Num = generateRandomNumber();

        luckyNumberTxt.setText(""+random_Num);




        //Share buttom code

        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData (userName, random_Num);
            }
        });



    }

    public int generateRandomNumber(){
        Random random = new Random();
        int upper_limit = 1000000;

        int randomNumberGenerated = random.nextInt(upper_limit);
        return randomNumberGenerated;

    }

    public void shareData (String username, int randomNum){


        //Implicit intents
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");


//convert the int to string
        String number = String.valueOf(randomNum);

        i.putExtra(Intent.EXTRA_SUBJECT, username + " , thank you for booking with London Explorer site viewing. We are sending your unique reference number below. We see you there!");
//i.putExtra(Intent.EXTRA_TEXT,   randomNum); here we are changing the random number to a string, as code bellow
        i.putExtra(Intent.EXTRA_TEXT, "Your reference number is: " + number);


        startActivity (Intent.createChooser(i,"Choose a platform"));


    }





}
