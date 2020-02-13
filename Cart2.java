package com.example.abc;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class Cart2 extends AppCompatActivity {
    ListView listView;
     LstViewAdapter adapter;
     Button  Confirmed_order;

     SharedPreferences bb;
//    ArrayList<String> item_productName = new ArrayList<String>();
//
//    ArrayList<String> item_quantity = new ArrayList<String>();
//    ArrayList<String> item_price = new ArrayList<String>();
//    ArrayList<HashMap<String, String>> masterlist = null;


    ArrayList<String> item_productName = new ArrayList<String>();

    ArrayList<String> item_quantity = new ArrayList<String>();
    ArrayList<String> item_price = new ArrayList<String>();
    ArrayList<HashMap<String, String>> masterlist = null;


    static final ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();


//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart2);

        bb = getSharedPreferences("my_prefs", 0);



  // item_productName.add(getIntent().getStringExtra("TextValue"));
//        item_quantity.add(getIntent().getStringExtra("Num"));
//        item_price.add(getIntent().getStringExtra("Price"));

        setResult(1);



        Confirmed_order = findViewById(R.id.co);

        Confirmed_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent();


                intent.putExtra("T", getIntent().getStringExtra("TextValue"));
                intent.putExtra("P",getIntent().getStringExtra("Num"));
                //  intent.putExtra("total", t.getText().toString());
                intent.setClass(Cart2.this, OrderDetail.class);
                startActivity(intent);
//                Intent intent=new Intent(Cart.this,OrderDetail.class);
//                startActivity(intent);

            }



        });





        listView = findViewById(R.id.list);


        adapter = new LstViewAdapter(this, R.layout.carttwolist, R.id.txt, item_productName, item_quantity, item_price);
        // Bind data to the ListView
        listView.setAdapter(adapter);
//        sddData();
        adapter.notifyDataSetChanged();


        //code to delete listviews items
//        SwipeDismissListViewTouchListener touchListener =
//                new SwipeDismissListViewTouchListener(
//                        listView,
//                        new SwipeDismissListViewTouchListener.DismissCallbacks() {
//                            @Override
//                            public boolean canDismiss(int position) {
//                                return true;
//                            }
//
//                            @Override
//                            public void onDismiss(ListView listView, int[] reverseSortedPositions) {
//                                for (int position : reverseSortedPositions) {
//                                    adapter.remove(adapter.getItem(position));
//                                }
//                                adapter.notifyDataSetChanged();
//                            }
//                        });
//        listView.setOnTouchListener(touchListener);
//        listView.setOnScrollListener(touchListener.makeScrollListener());

//        listView.setEmptyView(findViewById(R.id.emptyElement));

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(final AdapterView<?> parent, View view, final int position, long id) {
//                String selectedItem = (String) parent.getItemAtPosition(position);
//
//              Toast.makeText(Cart2.this," "+item_productName,Toast.LENGTH_LONG).show();
//           //   adapter.remove(a);
//
//            }
//        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, final long id) {


                //       updateListView();


                // TODO Auto-generated method stub
                if (position == 0) {

                    //code specific to first list item
                    Toast.makeText(Cart2.this, "Place Your First Option Code", Toast.LENGTH_SHORT).show();
                } else if (position == 1) {

                    //code specific to 2nd list item
                    Toast.makeText(getApplicationContext(), "Place Your Second Option Code", Toast.LENGTH_SHORT).show();
                } else if (position == 2) {

                    Toast.makeText(getApplicationContext(), "Place Your Third Option Code", Toast.LENGTH_SHORT).show();
                } else if (position == 3) {

                    Toast.makeText(getApplicationContext(), "Place Your Forth Option Code", Toast.LENGTH_SHORT).show();
                } else if (position == 4) {

                    Toast.makeText(getApplicationContext(), "Place Your Fifth Option Code", Toast.LENGTH_SHORT).show();
                }

            }


        });
    }

//




}
