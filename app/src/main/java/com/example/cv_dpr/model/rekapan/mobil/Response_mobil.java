package com.example.cv_dpr.model.rekapan.mobil;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Response_mobil {

	@SerializedName("kode")
	private boolean kode;

	@SerializedName("message")
	private String message;

	@SerializedName("data_mobil")
	private List<DataMobilItem> dataMobil;

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

	public void setDataMobil(List<DataMobilItem> dataMobil){
		this.dataMobil = dataMobil;
	}

	public List<DataMobilItem> getDataMobil(){
		return dataMobil;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"kode = '" + kode + '\'' + 
			",message = '" + message + '\'' + 
			",data_mobil = '" + dataMobil + '\'' + 
			"}";
		}
}