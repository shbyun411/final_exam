package com.example.sm.problem2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MyBaseAdapter adapter;
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // need something here

        adapter = new MyBaseAdapter(this, null);
        listview = (ListView) findViewById(R.id.listView1) ;
        listview.setAdapter(adapter);
        listview.setOnItemClickListener((AdapterView.OnItemClickListener)adapter);
    }
    @Override
    public void onClick(View v){
        EditText edit_name = (EditText) findViewById(R.id.edit_name);
        EditText edit_age = (EditText) findViewById(R.id.edit_age);
        EditText edit_salary = (EditText) findViewById(R.id.edit_salary);

        Employee employee = null;

        switch (v.getId()){
            case R.id.btn_inc:
                employee.getSalary(10000);
                break;

            case R.id.btn_dec:
                employee.getSalary(-10000);
                break;

            case R.id.btn_store:
                adapter.add(employee);
                break;

            case R.id.btn_modify:

                break;

            case R.id.btn_delete:
                adapter.delete(0);
                break;
        }
    }

}

interface Payment {
    void increase();
    void decrease();
}
