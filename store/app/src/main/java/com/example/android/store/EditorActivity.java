package com.example.android.store;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.android.store.data.StoreContact;
import com.example.android.store.data.StoreDbHelper;

public class EditorActivity  extends AppCompatActivity {

    private EditText mNameEditText;
    private EditText mQuantityEditText;
    private EditText mPriceEditText;
    private EditText mSupName;
    private EditText mSupPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        // Find all relevant views that we will need to read user input from
        mNameEditText = (EditText) findViewById(R.id.edit_store_name);
        mQuantityEditText = (EditText) findViewById(R.id.edit_store_quantity);
        mPriceEditText = (EditText) findViewById(R.id.edit_store_price);
        mSupName = (EditText) findViewById(R.id.edit_store_supplier_name);
        mSupPhone = (EditText) findViewById(R.id.edit_store_supplier_phone_number);

    }
    /**
     * Get user input from editor and save new data into database.
     */
    private void insertData() {
        // Read from input fields
        // Use trim to eliminate leading or trailing white space
        String nameString = mNameEditText.getText().toString().trim();
        String quantityString = mQuantityEditText.getText().toString().trim();
        String priceString = mPriceEditText.getText().toString().trim();
        String supNameString = mSupName.getText().toString().trim();
        String supPhoneString = mSupPhone.getText().toString().trim();
        // Create database helper
        StoreDbHelper mDbHelper = new StoreDbHelper(this);
        // Gets the database in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        // Create a ContentValues object where column names are the keys,
        // and pet attributes from the editor are the values.
        ContentValues values = new ContentValues();
        values.put(StoreContact.StoreEntry.COLUMN_PRODUCT_NAME, nameString);
        values.put(StoreContact.StoreEntry.COLUMN_QUANTITY, quantityString);
        values.put(StoreContact.StoreEntry.COLUMN_PRICE, priceString);
        values.put(StoreContact.StoreEntry.COLUMN_SUPPLIER_NAME, supNameString);
        values.put(StoreContact.StoreEntry.COLUMN_SUPPLIER_PHONE_NUMBER, supPhoneString);
        // Insert a new row for pet in the database, returning the ID of that new row.
        long newRowId = db.insert(StoreContact.StoreEntry.TABLE_NAME, null, values);
        // Show a toast message depending on whether or not the insertion was successful
        if (newRowId == -1) {
            // If the row ID is -1, then there was an error with insertion.
            Toast.makeText(this, "Error with saving pet", Toast.LENGTH_SHORT).show();
        } else {
            // Otherwise, the insertion was successful and we can display a toast with the row ID.
            Toast.makeText(this, "Pet saved with row id: " + newRowId, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_editor.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Save" menu option
            case R.id.action_save:
                // Save pet to database
                insertData();
                // Exit activity
                finish();
                return true;
            // Respond to a click on the "Delete" menu option
            case R.id.action_delete:
                // Do nothing for now
                return true;
            // Respond to a click on the "Up" arrow button in the app bar
            case android.R.id.home:
                // Navigate back to parent activity (CatalogActivity)
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}