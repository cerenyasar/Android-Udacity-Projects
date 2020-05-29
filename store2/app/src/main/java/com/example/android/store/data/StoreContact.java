package com.example.android.store.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public class StoreContact {
    public static final String CONTENT_AUTHORITY = "com.example.android.store";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_STORE = "store";
    private StoreContact() {}
    /**
     * Inner class that defines constant values for the pets database table.
     * Each entry in the table represents a single pet.
     */
    public static final class StoreEntry implements BaseColumns {
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_STORE);
        /**
         * The MIME type of the {@link #CONTENT_URI} for a list of pets.
         */
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_STORE;
        /**
         * The MIME type of the {@link #CONTENT_URI} for a single pet.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_STORE;


        public final static String TABLE_NAME = "inventory";

        public static final String _ID = BaseColumns._ID;

        public final static String COLUMN_PRODUCT_NAME = "productName";

        public final static String COLUMN_PRICE ="price";

        public final static String COLUMN_QUANTITY = "quantity";

        public final static String COLUMN_SUPPLIER_NAME = "supplierName";

        public final static String COLUMN_SUPPLIER_PHONE_NUMBER = "supplierPhoneNumber";

        public static final String DEFAULT_PHONE = "+90 000 000 00 00";
    }
}
