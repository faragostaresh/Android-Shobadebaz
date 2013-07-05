package com.database.shobadebaz;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "shobadebaz";

	// Contacts table name
	private static final String TABLE_ITEM = "item";

	// Contacts Table Columns names
	private static final String KEY_ID = "id";
	private static final String KEY_CID = "cid";
	private static final String KEY_TITLE = "title";
	private static final String KEY_BODY = "body";
	private static final String KEY_IMAGE = "image";
	private static final String KEY_LINK = "link";

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_ITEM_TABLE = "CREATE TABLE " + TABLE_ITEM + "(" + KEY_ID
				+ " INTEGER PRIMARY KEY," + KEY_CID + " INTEGER," + KEY_TITLE
				+ " TEXT," + KEY_BODY + " TEXT, " + KEY_IMAGE + " TEXT, "
				+ KEY_LINK + " TEXT" + ")";
		db.execSQL(CREATE_ITEM_TABLE);
	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEM);

		// Create tables again
		onCreate(db);
	}

	/**
	 * All CRUD(Create, Read, Update, Delete) Operations
	 */

	// Adding new item
	public void addItem(Item item) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_CID, item.getCid());
		values.put(KEY_TITLE, item.getTitle());
		values.put(KEY_BODY, item.getBody());
		values.put(KEY_IMAGE, item.getImage());
		values.put(KEY_LINK, item.getLink());

		// Inserting Row
		db.insert(TABLE_ITEM, null, values);
		db.close(); // Closing database connection
	}

	// Getting single item
	public Item getItem(int id) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TABLE_ITEM, new String[] { KEY_ID, KEY_CID,
				KEY_TITLE, KEY_BODY, KEY_IMAGE, KEY_LINK }, KEY_ID + "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();

		Item item = new Item(Integer.parseInt(cursor.getString(0)),
				Integer.parseInt(cursor.getString(1)), cursor.getString(2),
				cursor.getString(3), cursor.getString(4), cursor.getString(5));
		// return contact
		return item;
	}

	// Getting All Contacts
	public List<Item> getAllItemCid(int cid) {
		List<Item> itemList = new ArrayList<Item>();
		// Select All Query
		String selectQuery = "SELECT * FROM " + TABLE_ITEM;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Item item = new Item();
				item.setId(Integer.parseInt(cursor.getString(0)));
				item.setCid(Integer.parseInt(cursor.getString(1)));
				item.setTitle(cursor.getString(2));
				item.setBody(cursor.getString(3));
				item.setImage(cursor.getString(4));
				item.setLink(cursor.getString(5));
				// Adding contact to list
				itemList.add(item);
			} while (cursor.moveToNext());
		}

		// return contact list
		return itemList;
	}

	// Updating single contact
	public int updateItem(Item item) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_CID, item.getCid());
		values.put(KEY_TITLE, item.getTitle());
		values.put(KEY_BODY, item.getBody());
		values.put(KEY_IMAGE, item.getImage());
		values.put(KEY_LINK, item.getLink());

		// updating row
		return db.update(TABLE_ITEM, values, KEY_ID + " = ?",
				new String[] { String.valueOf(item.getId()) });
	}

	// Deleting single contact
	public void deleteContact(Item item) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_ITEM, KEY_ID + " = ?",
				new String[] { String.valueOf(item.getId()) });
		db.close();
	}

	// Getting contacts Count
	public int getItemCount() {
		String countQuery = "SELECT  * FROM " + TABLE_ITEM;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		cursor.close();

		// return count
		return cursor.getCount();
	}

}
