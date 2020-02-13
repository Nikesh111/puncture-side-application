package com.example.abc;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class Cart extends AppCompatActivity {


    TextView product, table, quntity, newt;
    ListView list;


    cartAdapter adapter2;
    ArrayList<String> arrayList;

    Button Confirmed_order;

    DatabaseReference databaseReference;
    saveData1 saveData1;
    SharedPreferences bb;

    String[] maintitle;
    String[] price;
   String[] qty;
    String[] total;


//
//    String[] maintitle = {
//            "BLUE FROG",
//    };


    //    String[] price ={
//            "310","110"
//    };
//
//    String[] qty ={
//            "1","1"
//    };
    Integer[] imgid = {
            R.drawable.cancel,
    };
    static HashMap<String, String> selected_product;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


        databaseReference = FirebaseDatabase.getInstance().getReference().child("Order_Detail");

        product = findViewById(R.id.pn);
        table = findViewById(R.id.tn);

        table.setVisibility(table.INVISIBLE);
      quntity = findViewById(R.id.Q);
        quntity.setVisibility(quntity.INVISIBLE);

        Confirmed_order = findViewById(R.id.po);

        Confirmed_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AddData();

                Intent intent = new Intent();


             intent.putExtra("T", bb.getString("TextValue"," "));
             intent.putExtra("P",bb.getString("Num"," "));
                //  intent.putExtra("total", t.getText().toString());
                intent.setClass(Cart.this, OrderDetail.class);
                startActivity(intent);

                Toast.makeText(Cart.this, "Order Confirmed", Toast.LENGTH_SHORT).show();
//                Intent intent=new Intent(Cart.this,OrderDetail.class);
//                startActivity(intent);

            }
        });


        table.setVisibility(table.INVISIBLE);
//        adapter2 = new cartAdapter(this,
//                maintitle,price,qty,imgid);


   bb = getSharedPreferences("my_prefs", 0);




            maintitle = new String[]
                    {


                         bb.getString("TextValue"," "),
                            //getIntent().getStringExtra("TextValue"),
                    };


            price =
                    new String[]{
                         bb.getString("Price",""),
                            //  getIntent().getStringExtra("Price"),

                    };

            qty =
                    new String[]{
                          bb.getString("Qty", ""),

                            // getIntent().getStringExtra("Num"),

                    };
            total =
                    new String[]{
                            bb.getString("Total", ""),

                            //  getIntent().getStringExtra("Total"),
                    };













            adapter2 = new cartAdapter(this, maintitle, price, qty, imgid, total);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter2);


        adapter2.notifyDataSetChanged();






        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, final long id) {


                list.removeAllViews();
                String value = adapter2.getItem(position);
                product.setText(value);
                product.setVisibility(product.INVISIBLE);

                table.setVisibility(table.INVISIBLE);
                quntity.setText(qty[position]);
                quntity.setVisibility(quntity.INVISIBLE);









                String selectedItem = (String) parent.getItemAtPosition(position);
                //       updateListView();
              //  adapter2.remove(selectedItem);


                // TODO Auto-generated method stub
                if (position == 0) {



                    //code specific to first list item
                    Toast.makeText(getApplicationContext(), "Place Your First Option Code", Toast.LENGTH_SHORT).show();
                } else if (position == 1) {
                    adapter2.add(value);
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

            private void updateListView() {

                Bundle bundle = getIntent().getExtras();
                Intent intent = getIntent();
                if (bundle != null) {

                    //listItems.add(a);
                    adapter2.add(String.valueOf(maintitle));
                    adapter2.add(String.valueOf(price));
                    adapter2.add(String.valueOf(qty));
                    adapter2.add(String.valueOf(imgid));
                    adapter2.notifyDataSetChanged();
                }
            }
        });


    }


    private void AddData() {

        String Order =   bb.getString("TextValue"," ");
        String Table_No = table.getText().toString().trim();
        String Qty = quntity.getText().toString().trim();

        saveData1 = new saveData1(Order, Table_No, Qty);
        databaseReference.push().setValue(saveData1);
        Toast.makeText(this, "Data save Successfully", Toast.LENGTH_LONG).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.m, menu);


        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.action_refresh:
                Toast.makeText(this, "home", Toast.LENGTH_SHORT)
                        .show();


                Intent intent = new Intent(Cart.this, MainActivity.class);
                startActivity(intent);
                break;

            case R.id.cartBuget:
                Toast.makeText(this, "cart", Toast.LENGTH_SHORT)
                        .show();


                break;
            // action with ID action_settings was selected
//            case R.id.action_settings:
//                Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT)
//                        .show();
//                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        adapter2.notifyDataSetChanged();
        super.onBackPressed();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


//
//            if (resultCode == Activity.RESULT_OK) {
//
//                if (data != null) {
//
//                    bb.getString("Price", ""),
//                    maintitle a = new main(data.getStringExtra("city"), data.getStringExtra("country"), "/", "/", "/", "/", "/");
//                    listItems.add(a);
//                    adapter.add(a);
//                    adapter.notifyDataSetChanged();
//
//
//                }}}


    }

        }
