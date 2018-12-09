package com.mateo.andrea.projectmateosantos.com.main;

import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.mateo.andrea.projectmateosantos.R;
import com.mateo.andrea.projectmateosantos.com.logics.DBHelper;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class LogView extends AppCompatActivity {

    DBHelper dbhelper;
    ArrayAdapter<String> SAdapter;
    ListView firstlog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_view);

        dbhelper = new DBHelper(this);

        firstlog = (ListView) findViewById(R.id.firstlog);

        loadLogsList();
    }

    private void loadLogsList() {
        ArrayList<String> logList = dbhelper.getLogsList();
        if (SAdapter == null) {
            SAdapter = new ArrayAdapter<String>(this, R.layout.row, R.id.log_dsply, logList);
            firstlog.setAdapter(SAdapter);
        }
        else{
            SAdapter.clear();
            SAdapter.addAll(logList);
            SAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        Drawable icon = menu.getItem(0).getIcon();
        icon.mutate();
        icon.setColorFilter(getResources().getColor(android.R.color.black), PorterDuff.Mode.SRC_IN);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add_log:
                final EditText logEditText = new EditText(this);
                AlertDialog dialog = new AlertDialog.Builder(this)
                        .setTitle("Add New Log")
                        .setMessage("Type a new log from your breast self exam")
                        .setView(logEditText)
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String log = String.valueOf(logEditText.getText());
                                dbhelper.InsertNewLog(log);
                                loadLogsList();
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();
                dialog.show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void deleteLog (View view){
        View parent = (View)view.getParent();
        TextView logTestView = (TextView) findViewById(R.id.log_dsply);
        String log = String.valueOf(logTestView.getText());
        dbhelper.deletelgs(log);
        loadLogsList();
    }
}
