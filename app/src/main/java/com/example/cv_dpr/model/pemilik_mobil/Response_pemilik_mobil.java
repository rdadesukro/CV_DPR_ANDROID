package com.example.cv_dpr.model.pemilik_mobil;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Response_pemilik_mobil {

	@SerializedName("kode")
	private boolean kode;

	@SerializedName("message")
	private String message;

	@SerializedName("data_pemilik_mobil")
	private List<DataPemilikMobilItem> dataPemilikMobil;

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

	public void setDataPemilikMobil(List<DataPemilikMobilItem> dataPemilikMobil){
		this.dataPemilikMobil = dataPemilikMobil;
	}

	public List<DataPemilikMobilItem> getDataPemilikMobil(){
		return dataPemilikMobil;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"kode = '" + kode + '\'' + 
			",message = '" + message + '\'' + 
			",data_pemilik_mobil = '" + dataPemilikMobil + '\'' + 
			"}";
		}
}