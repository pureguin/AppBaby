/*package com.example.appbaby;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AlphabetEng extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet_eng);
    }
}


*/

package com.example.appbaby;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.appbaby.adapter.RecyclerViewAdapter;
import com.example.appbaby.db.DatabaseHelper;
import com.example.appbaby.model.app;

import java.util.ArrayList;
import java.util.List;

import static com.example.appbaby.db.DatabaseHelper.COL_DESCRIPTION;
import static com.example.appbaby.db.DatabaseHelper.COL_ID;
import static com.example.appbaby.db.DatabaseHelper.COL_IMAGE;
import static com.example.appbaby.db.DatabaseHelper.COL_CATEGORY;
import static com.example.appbaby.db.DatabaseHelper.TABLE_App;

public class AlphabetEng extends AppCompatActivity {


    private List<app> mAppList = new ArrayList<>();
    private RecyclerViewAdapter mAdapter;

    private DatabaseHelper mDbHepler;
    private SQLiteDatabase mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //    populateData();
        mDbHepler = new DatabaseHelper(AlphabetEng.this);
        mDatabase = mDbHepler.getWritableDatabase();

        readformDb();


        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        mAdapter = new RecyclerViewAdapter(
                AlphabetEng.this,
                R.layout.item_app,
                mAppList

        );

        LinearLayoutManager lm = new LinearLayoutManager(this );


        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(mAdapter);

     /*   Button addAppButton =  findViewById(R.id.add_category_button);
        addAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo : อ่านข้อมูลจาก place_name_edit_text แล้ว  insert ลง database

                //อ่านข้อมูลจาก place_name_edit_text มาำักเก็ยลงตัวแปร name
                EditText AppNameEditText  = findViewById(R.id.category_name_edit_text);
                String name =  AppNameEditText.getText().toString();

                // เอาตัสแปร name ไป insert ลง database
                ContentValues cv = new ContentValues();
                cv.put(COL_CATEGORY, "name");
                cv.put(COL_DESCRIPTION, "description");
                cv.put(COL_IMAGE, R.mipmap.ic_launcher);
                mDatabase.insert(TABLE_App,null,cv);

                readformDb();
                mAdapter.notifyDataSetChanged();

            }
        });

        */ //ปุ่ม insert
    }

    private void readformDb() {

        mAppList.clear();
        Cursor cursor = mDatabase.query(TABLE_App,null, null,null,null,null,null);

        while (cursor.moveToNext()){
            int id=  cursor.getInt(cursor.getColumnIndex(COL_ID));
            String category = cursor.getString(cursor.getColumnIndex(COL_CATEGORY));
            String description = cursor.getString(cursor.getColumnIndex(COL_DESCRIPTION));
            int image  = cursor.getInt(cursor.getColumnIndex(COL_IMAGE));

            app app = new app(id,category,description,image);
            mAppList.add(app);
        }
    }

    private void populateData() {


/*        app place = new app("พระปฐมเจดีย์","เมือง",R.drawable.ongpha);
        mAppList.add(place);

        place = new app("บ้านปายนา","นครชัยศรี",R.drawable.paina1);
        mAppList.add(place);

        place = new app("พิพิธภัณฑ์รถเก่า","นครชัยศรี",R.drawable.jesadatechnikmuseum);
        mAppList.add(place);

        place = new app("ตลาดท่านา","นครชัยศรี",R.drawable.thana);
        mAppList.add(place);

        place = new app("วัดกลางบางแก้ว","นครชับศรี",R.drawable.watklangbangkaew);
        mAppList.add(place);

        place = new app("ตลาดน้ำลำพญา","บางเลน",R.drawable.lamphaya);
        mAppList.add(place);

        place = new app("ตลาดน้ำทุ่งบัวแดง","บางเลน",R.drawable.tungbuadang);
        mAppList.add(place);

        place = new app("Tree & Tide Riverside","บางเลน",R.drawable.treetideriverside);
        mAppList.add(place);
     */
    }

}

