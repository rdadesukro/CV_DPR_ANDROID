package com.example.cv_dpr.model.buat_pdf;

import com.google.gson.annotations.SerializedName;

public class Response_pdf {

	@SerializedName("lokasi")
	private String lokasi;

	@SerializedName("kode")
	private boolean kode;

	@SerializedName("message")
	private String message;

	public void setLokasi(String lokasi){
		this.lokasi = lokasi;
	}

	public String getLokasi(){
		return lokasi;
	}

	public void setKode(boolean kode){
		this.kode = kode;
	}

	public boolean isKode(){
		return kode;
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
			"lokasi = '" + lokasi + '\'' + 
			",kode = '" + kode + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}