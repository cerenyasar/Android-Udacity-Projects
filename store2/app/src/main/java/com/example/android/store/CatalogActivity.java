package com.example.android.store;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.app.LoaderManager;

import com.example.android.store.data.StoreContact;
import com.example.android.store.data.StoreContact.StoreEntry;
import com.example.android.store.data.StoreDbHelper;
import com.example.android.store.data.StoreDbHelper;

/**
 * Displays list of pets that were entered and stored in the app.
 */
public class CatalogActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>{

    /** Database helper that will provide us access to the database */
    private static final int DATA_LOADER = 0;
    StoreCursorAdapter mCursorAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        // Setup FAB to open EditorActivity
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CatalogActivity.this, EditorActivity.class);
                startActivity(intent);
            }
        });
        // Find the ListView which will be populated with the pet data
        ListView petListView = (ListView) findViewById(R.id.list_1);
        // Find and set empty view on the ListView, so that it only shows when the list has 0 items.
        View emptyView = findViewById(R.id.empty_view);
        petListView.setEmptyView(emptyView);

        mCursorAdapter = new StoreCursorAdapter(this,null);
        petListView.setAdapter(mCursorAdapter);
        petListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(CatalogActivity.this,EditorActivity.class);
                Uri currentDataUri = ContentUris.withAppendedId(StoreContact.StoreEntry.CONTENT_URI,l);
                intent.setData(currentDataUri);
                startActivity(intent);
            }
        });
        getLoaderManager().initLoader(DATA_LOADER, null, this);
    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    /**
     * Helper method to insert hardcoded pet data into the database. For debugging purposes only.
     */
    private void insertData() {
        // Create a ContentValues object where column names are the keys,
        // and Toto's pet attributes are the values.
        ContentValues values = new ContentValues();
        values.put(StoreContact.StoreEntry.COLUMN_PRODUCT_NAME, "Pen");
        values.put(StoreContact.StoreEntry.COLUMN_PRICE, 0.6);
        values.put(StoreContact.StoreEntry.COLUMN_QUANTITY,5);
        values.put(StoreContact.StoreEntry.COLUMN_SUPPLIER_NAME , "Admin");
        values.put(StoreContact.StoreEntry.COLUMN_SUPPLIER_PHONE_NUMBER ,StoreContact.StoreEntry.DEFAULT_PHONE);
        getContentResolver().insert(StoreEntry.CONTENT_URI, values);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_catalog.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_catalog, menu);
        return true;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        // Since the editor shows all pet attributes, define a projection that contains
        // all columns from the pet table
        String[] projection = {
                StoreContact.StoreEntry._ID,
                StoreContact.StoreEntry.COLUMN_PRODUCT_NAME,
                StoreContact.StoreEntry.COLUMN_QUANTITY,
                StoreContact.StoreEntry.COLUMN_PRICE,
                StoreContact.StoreEntry.COLUMN_SUPPLIER_NAME,
                StoreContact.StoreEntry.COLUMN_SUPPLIER_PHONE_NUMBER
        };
        return new CursorLoader(this,
                StoreEntry.CONTENT_URI,
                projection,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mCursorAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mCursorAdapter.swapCursor(null);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app     bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Insert dummy data" menu option
            case R.id.action_insert_dummy_data:
                insertData();
                return true;
            // Respond to a click on the "Delete all entries" menu option
            case R.id.action_delete_all_entries:
                deleteAllPets();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    /**
     * Helper method to delete all pets in the database.
     */
    private void deleteAllPets() {
        getContentResolver().delete(StoreEntry.CONTENT_URI, null, null);

    }
}