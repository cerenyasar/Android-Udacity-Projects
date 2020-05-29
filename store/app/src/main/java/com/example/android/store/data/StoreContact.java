package com.example.android.store.data;

import android.provider.BaseColumns;

public class StoreContact {
    private StoreContact() {}
    /**
     * Inner class that defines constant values for the pets database table.
     * Each entry in the table represents a single pet.
     */
    public static final class StoreEntry implements BaseColumns {
        /** Name of database table for inventory */

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
