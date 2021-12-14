package com.example.cv_dpr.model.tujuan;

import com.google.gson.annotations.SerializedName;

public class BM01ATIONGItem{

	@SerializedName("harga")
	private int harga;

	@SerializedName("pg")
	private int pg;

	@SerializedName("tgl")
	private String tgl;

	@SerializedName("id")
	private int id;

	@SerializedName("tujuan")
	private String tujuan;

	@SerializedName("transortir_id")
	private int transortirId;

	public void setHarga(int harga){
		this.harga = harga;
	}

	public int getHarga(){
		return harga;
	}

	public void setPg(int pg){
		this.pg = pg;
	}

	public int getPg(){
		return pg;
	}

	public void setTgl(String tgl){
		this.tgl = tgl;
	}

	public String getTgl(){
		return tgl;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setTujuan(String tujuan){
		this.tujuan = tujuan;
	}

	public String getTujuan(){
		return tujuan;
	}

	public void setTransortirId(int transortirId){
		this.transortirId = transortirId;
	}

	public int getTransortirId(){
		return transortirId;
	}

	@Override
 	public String toString(){
		return 
			"BM01ATIONGItem{" + 
			"harga = '" + harga + '\'' + 
			",pg = '" + pg + '\'' + 
			",tgl = '" + tgl + '\'' + 
			",id = '" + id + '\'' + 
			",tujuan = '" + tujuan + '\'' + 
			",transortir_id = '" + transortirId + '\'' + 
			"}";
		}
}