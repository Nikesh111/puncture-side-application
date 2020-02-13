package com.example.abc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class Bitt_Detail extends AppCompatActivity {
    ListView list;
    TextView subtotal;

    String[] maintitle ={
            "Cocktail","Electric Ice Tea",
            "Berry Martini","Litchi And Lemon Grass Martini ",

    };



    String[] imgid={
            " 1"," 2",
            " 3"," 2",

    };
    String[] subtitle ={
            "430","860",
            "400","320",

    };

    String[] into;



    Integer t;
    Integer a=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newbill);


        subtotal=findViewById(R.id.subtotal);




        TextView date=findViewById(R.id.date);
        TextView time=findViewById(R.id.time);


        String currentDateTimeString = DateFormat.getDateInstance().format(new Date());
        date.setText(currentDateTimeString);

        String currentTimeString = DateFormat.getTimeInstance().format(Calendar.getInstance().getTime());
        time.setText(currentTimeString);




      into= new String[]{
             "254", "4674", "67","47",

//              String.valueOf(Integer.parseInt(subtitle[0]) * Integer.parseInt(imgid[0])),
//              String.valueOf(Integer.parseInt(subtitle[0]) * Integer.parseInt(imgid[0])),
//              String.valueOf(Integer.parseInt(subtitle[0]) * Integer.parseInt(imgid[0])),
//              String.valueOf(Integer.parseInt(subtitle[0]) * Integer.parseInt(imgid[0])),

      };


        final BillListAdapter adapter=new BillListAdapter(this, maintitle, subtitle,imgid,into);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);


        Integer a=Integer.parseInt(subtitle[0])+Integer.parseInt(subtitle[1])+Integer.parseInt(subtitle[2])+Integer.parseInt(subtitle[3]);
        String b=String.valueOf(a);


        subtotal.setText(b);






//
//        for(int i=0;i<subtitle.length;i++)
//        {
//            a=a+Integer.parseInt(subtitle[i]);
//
//
//        }
//        subtotal.setText(a);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {



            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {







                //t=Integer.parseInt(maintitle[position])+Integer.parseInt(imgid[position]);


                // TODO Auto-generated method stub
                {
                    if(position == 0) {
                        //code specific to first list item
                        Toast.makeText(getApplicationContext(),"Place Your First Option Code",Toast.LENGTH_SHORT).show();
                    }

                    else if(position == 1) {
                        //code specific to 2nd list item
                        Toast.makeText(getApplicationContext(),"Place Your Second Option Code",Toast.LENGTH_SHORT).show();
                    }

                    else if(position == 2) {

                        Toast.makeText(getApplicationContext(),"Place Your Third Option Code",Toast.LENGTH_SHORT).show();
                    }
                    else if(position == 3) {

                        Toast.makeText(getApplicationContext(),"Place Your Forth Option Code",Toast.LENGTH_SHORT).show();
                    }
                    else if(position == 4) {

                        Toast.makeText(getApplicationContext(),"Place Your Fifth Option Code",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });





    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Intent intent = new Intent(Bitt_Detail.this, Bitt_Detail.class);
        startActivity(intent);
    }
}
