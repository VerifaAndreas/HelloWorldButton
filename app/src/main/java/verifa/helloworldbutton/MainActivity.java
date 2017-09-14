package verifa.helloworldbutton;

import android.content.Intent;
import android.os.ParcelFileDescriptor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.graphics.pdf.PdfRenderer;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        addListenerOnButton();
    }
    
    public static void sayHello() {
    	System.out.println("HELLO!!!");
    }
    public static int getIntStatic() {
    	return 5;
    }
    public int getIntNormal() {
    	return 5;
    }

    public void addListenerOnButton() {

        final View button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //When the button is clicked, start the login activity
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }

        });
    }

}
