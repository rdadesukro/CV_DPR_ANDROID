package com.example.cv_dpr.model.tujuan;

import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("kode")
	private boolean kode;

	@SerializedName("data_harga")
	private DataHarga dataHarga;

	@SerializedName("message")
	private String message;

	public void setKode(boolean kode){
		this.kode = kode;
	}

	public boolean isKode(){
		return kode;
	}

	public void setDataHarga(DataHarga dataHarga){
		this.dataHarga = dataHarga;
	}

	public DataHarga getDataHarga(){
		return dataHarga;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"kode = '" + kode + '\'' + 
			",data_harga = '" + dataHarga + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}