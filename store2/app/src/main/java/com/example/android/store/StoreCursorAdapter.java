package com.example.android.store;

import android.app.Activity;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.store.data.StoreContact;

public class StoreCursorAdapter extends CursorAdapter {
    /**
     * Constructs a new {
     *
     * @param context The context
     * @param c       The cursor from which to get the data.
     */
    public StoreCursorAdapter(Context context, Cursor c) {
        super(context, c, 0 /* flags */);
    }
    /**
     * Makes a new blank list item view. No data is set (or bound) to the views yet.
     *
     * @param context app context
     * @param cursor  The cursor from which to get the data. The cursor is already
     *                moved to the correct position.
     * @param parent  The parent to which the new view is attached to
     * @return the newly created list item view.
     */
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // Inflate a list item view using the layout specified in list_item.xml
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }
    /**
     * This method binds the pet data (in the current row pointed to by cursor) to the given
     * list item layout. For example, the name for the current pet can be set on the name TextView
     * in the list item layout.
     *
     * @param view    Existing view, returned earlier by newView() method
     * @param context app context
     * @param cursor  The cursor from which to get the data. The cursor is already moved to the
     *                correct row.
     */
    @Override
    public void bindView(final View view, final Context context, Cursor cursor) {
        // Find individual views that we want to modify in the list item layout
        TextView nameTextView = (TextView) view.findViewById(R.id.name);
        TextView priceTextView = (TextView) view.findViewById(R.id.price);
        TextView quantityTextView = (TextView) view.findViewById(R.id.quantity);
        Button productSaleButton = view.findViewById(R.id.sale);

        // Find the columns of pet attributes that we're interested in
        // Figure out the index of each column
        int nameColumnIndex = cursor.getColumnIndex(StoreContact.StoreEntry.COLUMN_PRODUCT_NAME);
        int quantityColumnIndex = cursor.getColumnIndex(StoreContact.StoreEntry.COLUMN_QUANTITY);
        int priceColumnIndex = cursor.getColumnIndex(StoreContact.StoreEntry.COLUMN_PRICE);
        // column number of "_ID"
        int productIdColumIndex = cursor.getColumnIndex(StoreContact.StoreEntry._ID);
        // Read the pet attributes from the Cursor for the current pet
        String productName = cursor.getString(nameColumnIndex);
        final long productIdValue = Integer.parseInt(cursor.getString(productIdColumIndex));
        final int productQuantity = cursor.getInt(quantityColumnIndex);
        String productPrice = cursor.getString(priceColumnIndex);


        // Update the TextViews with the attributes for the current pet
        nameTextView.setText(productName);
        priceTextView.setText(productPrice);
        quantityTextView.setText(Integer.toString(productQuantity));

        productSaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri currentUri = ContentUris.withAppendedId(StoreContact.StoreEntry.CONTENT_URI, productIdValue);

                int updatedQuantity = productQuantity - 1;

                if(updatedQuantity>=0){
                    String newQuantity = String.valueOf(updatedQuantity);
                    ContentValues values = new ContentValues();
                    values.put(StoreContact.StoreEntry.COLUMN_QUANTITY,newQuantity);
                    context.getContentResolver().update(currentUri,values,null,null);
                }
            }
        });
        Button productDetailButton = view.findViewById(R.id.detail);
        productDetailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), ProductDetailActivity.class);
                Uri currentProducttUri = ContentUris.withAppendedId(StoreContact.StoreEntry.CONTENT_URI, productIdValue);
                intent.setData( currentProducttUri);
                context.startActivity(intent);
            }
        });
    }
}
