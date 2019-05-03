package c346.rp.edu.sg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    TextView tvResult, tvTotal;
    Button btnCalc;
    EditText etAmt,etPax;
    ToggleButton tbtnGST,tbtnSC;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult=findViewById(R.id.tvResult);
        btnCalc=findViewById(R.id.calc);
        etAmt=findViewById(R.id.etAmount);
        etPax=findViewById(R.id.etPax);
        tbtnGST=findViewById(R.id.toggleGST);
        tbtnSC=findViewById(R.id.toggleSC);
        tvTotal=findViewById(R.id.tvTotal);


         btnCalc.setOnClickListener( new View.OnClickListener(){
             @Override
             public void onClick(View v){
                 String data=etAmt.getText().toString();
                 double amt=Double.parseDouble(data);
                 int pax=Integer.parseInt(etPax.getText().toString());

                 if(tbtnSC.isChecked()==true){
                     amt=amt*1.10;
                 }
                 if(tbtnGST.isChecked()==true){
                     amt=amt*1.07;
                 }

                 double ave = amt/pax;

                 tvTotal.setText("Total Amount $" + amt);
                 tvResult.setText("Each pax pays "+ave);


                }
            });

        }
    }