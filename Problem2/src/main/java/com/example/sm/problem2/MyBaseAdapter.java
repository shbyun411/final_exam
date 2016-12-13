package com.example.sm.problem2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;
import java.util.zip.Inflater;
//final exam
public class MyBaseAdapter extends BaseAdapter implements AdapterView.OnItemClickListener{

    Context mContext = null;
    ArrayList<Employee> mData = null;
    LayoutInflater mLayoutInflater = null;
    public int selected_position;
    int layout;



    MyBaseAdapter(  Context context, int alayout, ArrayList<Employee> data){
        mContext = context;
        mData = data;
        layout = alayout;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Employee employee = (Employee) parent.getItemAtPosition(position);

        String name = employee.getName();
        Integer age = employee.getAge();
        Integer salary = employee.getSalary();
        EditText edit_name = (EditText) view.getRootView().findViewById(R.id.edit_name);
        EditText edit_age = (EditText) view.getRootView().findViewById(R.id.edit_age);
        EditText edit_salary = (EditText) view.getRootView().findViewById(R.id.edit_salary);
        edit_name.setText(name);
        edit_age.setText(age.toString());
        edit_salary.setText(salary.toString());
        this.selected_position = position;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void add(Employee employee){
        mData.add(employee);
        notifyDataSetChanged();
    }

    public void delete(Employee employee){
        mData.remove(employee);
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView ==null){
            convertView =mLayoutInflater.inflate(layout,parent,false);
        }
        TextView employeeName = (TextView) convertView.findViewById(R.id.text_employeeName);
        employeeName.setText(mData.get(position).getName());

        TextView employeeAge = (TextView) convertView.findViewById(R.id.text_employeeAge);
        employeeAge.setText(mData.get(position).getAge());

        TextView employeeSalary = (TextView) convertView.findViewById(R.id.text_employeeSalary);
        employeeSalary.setText(mData.get(position).getSalary());
        return convertView;
    }
}
