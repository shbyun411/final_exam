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

        ArrayList<Employee> emp_list = new ArrayList<Employee>();
        adapter = new MyBaseAdapter(this, R.layout.list_view_item_layout,emp_list);
        listview = (ListView) findViewById(R.id.listView1) ;
        listview.setAdapter(adapter);
        listview.setOnItemClickListener((AdapterView.OnItemClickListener)adapter);
    }
    @Override
    public void onClick(View v){
        EditText edit_name = (EditText) findViewById(R.id.edit_name);
        EditText edit_age = (EditText) findViewById(R.id.edit_age);
        EditText edit_salary = (EditText) findViewById(R.id.edit_salary);

        String name = edit_name.getText().toString();
        String Age = edit_age.getText().toString();
        int age = Integer.parseInt(Age);
        String Salary = edit_salary.getText().toString();
        int salary = Integer.parseInt(Salary);


        Employee employee= new Employee(name,age,salary);

        switch (v.getId()){
            case R.id.btn_inc:
                employee.increase();
                break;

            case R.id.btn_dec:
                employee.decrease();
                break;

            case R.id.btn_store:
                adapter.add(employee);
                // need something here
                break;

            case R.id.btn_modify:

                break;

            case R.id.btn_delete:
                adapter.delete(employee);
                // need something here
                break;
        }
    }
}

interface Payment {
    void increase();
    void decrease();
}
