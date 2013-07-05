package com.database.shobadebaz;

public class Item {

	// private variables
	int _id;
	int _cid;
	String _title;
	String _body;
	String _image;
	String _link;

	// Empty constructor
	public Item() {

	}

	// constructor
	public Item(int id, int cid, String title, String body, String image,
			String link) {
		this._id = id;
		this._cid = cid;
		this._title = title;
		this._body = body;
		this._image = image;
		this._link = link;
	}

	// constructor
	public Item(int cid, String title, String body, String image, String link) {
		this._cid = cid;
		this._title = title;
		this._body = body;
		this._image = image;
		this._link = link;
	}

	// getting Id
	public int getId() {
		return this._id;
	}

	// setting Id
	public void setId(int id) {
		this._id = id;
	}

	// getting Cid
	public int getCid() {
		return this._cid;
	}

	// setting Cid
	public void setCid(int cid) {
		this._cid = cid;
	}

	// getting Title
	public String getTitle() {
		return this._title;
	}

	// setting Title
	public void setTitle(String title) {
		this._title = title;
	}

	// getting Body
	public String getBody() {
		return this._body;
	}

	// setting Body
	public void setBody(String body) {
		this._body = body;
	}

	// getting Image
	public String getImage() {
		return this._image;
	}

	// setting Image
	public void setImage(String image) {
		this._image = image;
	}

	// getting Link
	public String getLink() {
		return this._link;
	}

	// setting Link
	public void setLink(String link) {
		this._link = link;
	}
}
