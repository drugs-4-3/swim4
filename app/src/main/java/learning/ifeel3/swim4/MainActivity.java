package learning.ifeel3.swim4;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText textView1;
    EditText textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (EditText)findViewById(R.id.textview1);
        textView2 = (EditText)findViewById(R.id.textview2);
        registerForContextMenu(textView1);
        registerForContextMenu(textView2);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.allToRedItem:
                textView1.setTextColor(Color.RED);
                textView2.setTextColor(Color.RED);
                return true;
            case R.id.allToGreenItem:
                textView1.setTextColor(Color.GREEN);
                textView2.setTextColor(Color.GREEN);
                return true;
            case R.id.allToBlueItem:
                textView1.setTextColor(Color.BLUE);
                textView2.setTextColor(Color.BLUE);
                return true;

            case R.id.tv2ToRedItem:
                textView2.setTextColor(Color.RED);
                return true;
            case R.id.tv2ToGreenItem:
                textView2.setTextColor(Color.GREEN);
                return true;
            case R.id.tv2ToBlueItem:
                textView2.setTextColor(Color.BLUE);
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        if(v.getId() == R.id.textview1) {
            inflater.inflate(R.menu.context_menu, menu);
        }
        else if(v.getId() == R.id.textview2) {
            inflater.inflate(R.menu.context_menu2, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.smallFontItem:
                textView1.setTextSize(15);
                return true;
            case R.id.mediumFontItem:
                textView1.setTextSize(18);
                return true;
            case R.id.bigFontItem:
                textView1.setTextSize(23);
                return true;

            case R.id.boldFontItem:
                textView2.setTypeface(null, Typeface.BOLD);
                return true;
            case R.id.regularFontItem:
                textView2.setTypeface(null, Typeface.NORMAL);
                return true;
            case R.id.italicFontItem:
                textView2.setTypeface(null, Typeface.ITALIC);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
