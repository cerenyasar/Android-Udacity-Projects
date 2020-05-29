package com.example.android.store;

import android.app.AlertDialog;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.store.data.StoreContact;

public class ProductDetailActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final int EXISTING_INVENTORY_LOADER = 0;
    private Uri mCurrentDataUri;

    private TextView mProductNameViewText;
    private TextView mProductPriceViewText;
    private TextView mProductQuantityViewText;
    private TextView mProductSupplieNameText;
    private TextView mProductSupplierPhoneNumberViewText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        mProductNameViewText = (TextView) findViewById(R.id.product_name_val);
        mProductPriceViewText = (TextView) findViewById(R.id.product_price_val);
        mProductQuantityViewText = (TextView) findViewById(R.id.product_quantity_val);
        mProductSupplieNameText = (TextView) findViewById(R.id.product_sup_name_val);
        mProductSupplierPhoneNumberViewText = (TextView) findViewById(R.id.product_sup_phone_val);

        Intent intent = getIntent();
        mCurrentDataUri = intent.getData();
        if (mCurrentDataUri == null) {
            invalidateOptionsMenu();
        } else {
            getLoaderManager().initLoader(EXISTING_INVENTORY_LOADER, null, this);
        }


    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        String[] projection = {
                StoreContact.StoreEntry._ID,
                StoreContact.StoreEntry.COLUMN_PRODUCT_NAME,
                StoreContact.StoreEntry.COLUMN_QUANTITY,
                StoreContact.StoreEntry.COLUMN_PRICE,
                StoreContact.StoreEntry.COLUMN_SUPPLIER_NAME,
                StoreContact.StoreEntry.COLUMN_SUPPLIER_PHONE_NUMBER
        };
        return new CursorLoader(this,
                mCurrentDataUri,
                projection,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (cursor == null || cursor.getCount() < 1) {
            return;
        }
        if (cursor.moveToFirst()) {


            int nameColumnIndex = cursor.getColumnIndex(StoreContact.StoreEntry.COLUMN_PRODUCT_NAME);
            int quantityColumnIndex = cursor.getColumnIndex(StoreContact.StoreEntry.COLUMN_QUANTITY);
            int priceColumnIndex = cursor.getColumnIndex(StoreContact.StoreEntry.COLUMN_PRICE);
            int supplierNameColumnIndex = cursor.getColumnIndex(StoreContact.StoreEntry.COLUMN_SUPPLIER_NAME);
            int supplierPhoneColumnIndex = cursor.getColumnIndex(StoreContact.StoreEntry.COLUMN_SUPPLIER_PHONE_NUMBER);

            String currentName = cursor.getString(nameColumnIndex);
            final float currentPrice = cursor.getFloat(priceColumnIndex);
            final int currentQuantity = cursor.getInt(quantityColumnIndex);
            String ccurrentSupplierName = cursor.getString(supplierNameColumnIndex);
            final String currentSupplierPhone = cursor.getString(supplierPhoneColumnIndex);

            mProductNameViewText.setText(currentName);
            mProductPriceViewText.setText(Float.toString(currentPrice));
            mProductQuantityViewText.setText(Integer.toString(currentQuantity));
            mProductSupplierPhoneNumberViewText.setText(currentSupplierPhone);
            mProductSupplieNameText.setText(ccurrentSupplierName);


            Button productDecreaseButton = (Button) findViewById(R.id.minus);
            productDecreaseButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    decreaseCount( currentQuantity);
                }
            });

            Button productIncreaseButton = (Button) findViewById(R.id.plus);
            productIncreaseButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    increaseCount( currentQuantity);
                }
            });

            Button productDeleteButton = (Button) findViewById(R.id.delete);
            productDeleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDeleteConfirmationDialog();
                }
            });

            Button phoneButton = (Button) findViewById(R.id.call_sup);
            phoneButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", currentSupplierPhone, null));
                    if (intent.resolveActivity(getPackageManager()) != null) {

                        startActivity(intent);

                    }
                }
            });

        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mProductNameViewText.setText("");
        mProductPriceViewText.setText("");
        mProductQuantityViewText.setText("");
        mProductSupplierPhoneNumberViewText.setText("");
        mProductSupplieNameText.setText("");
    }

    public void decreaseCount( int productQuantity) {
        productQuantity = productQuantity - 1;
        if (productQuantity >= 0) {
            updateData(productQuantity);
            Toast.makeText(this, getString(R.string.quantity_change_message), Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, getString(R.string.quantity_finish_message), Toast.LENGTH_SHORT).show();
        }
    }

    public void increaseCount( int productQuantity) {
        productQuantity = productQuantity + 1;
        if (productQuantity >= 0) {
            updateData(productQuantity);
            Toast.makeText(this, getString(R.string.quantity_change_message), Toast.LENGTH_SHORT).show();

        }
    }


    private void updateData(int productQuantity) {
        if (mCurrentDataUri == null) {
            return;
        }
        ContentValues values = new ContentValues();
        values.put(StoreContact.StoreEntry.COLUMN_QUANTITY, productQuantity);

        if (mCurrentDataUri == null) {
            Uri newUri = getContentResolver().insert(StoreContact.StoreEntry.CONTENT_URI, values);
            if (newUri == null) {
                Toast.makeText(this, getString(R.string.editor_insert_failed),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, getString(R.string.editor_insert_successful),
                        Toast.LENGTH_SHORT).show();
            }
        } else {
            int rowsAffected = getContentResolver().update(mCurrentDataUri, values, null, null);
            if (rowsAffected == 0) {
                Toast.makeText(this, getString(R.string.editor_update_failed),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, getString(R.string.editor_update_successful),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    /**
     * Prompt the user to confirm that they want to delete this pet.
     */
    private void showDeleteConfirmationDialog() {
        // Create an AlertDialog.Builder and set the message, and click listeners
        // for the postivie and negative buttons on the dialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.delete_dialog_msg);
        builder.setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked the "Delete" button, so delete the pet.
                deleteData();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked the "Cancel" button, so dismiss the dialog
                // and continue editing the pet.
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });
        // Create and show the AlertDialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    /**
     * Perform the deletion of the pet in the database.
     */
    private void deleteData() {
        // Only perform the delete if this is an existing pet.
        if (mCurrentDataUri != null) {
            // Call the ContentResolver to delete the pet at the given content URI.
            // Pass in null for the selection and selection args because the mCurrentPetUri
            // content URI already identifies the pet that we want.
            int rowsDeleted = getContentResolver().delete(mCurrentDataUri, null, null);
            // Show a toast message depending on whether or not the delete was successful.
            if (rowsDeleted == 0) {
                // If no rows were deleted, then there was an error with the delete.
                Toast.makeText(this, getString(R.string.editor_delete_data_failed),
                        Toast.LENGTH_SHORT).show();
            } else {
                // Otherwise, the delete was successful and we can display a toast.
                Toast.makeText(this, getString(R.string.editor_delete_data_successful),
                        Toast.LENGTH_SHORT).show();
            }
        }
        // Close the activity
        finish();
    }

}
