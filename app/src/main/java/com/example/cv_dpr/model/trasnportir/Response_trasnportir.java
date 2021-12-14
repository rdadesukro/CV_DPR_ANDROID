package com.example.cv_dpr.model.trasnportir;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response_trasnportir {

	@SerializedName("kode")
	private boolean kode;

	@SerializedName("message")
	private String message;

	@SerializedName("data_transportir")
	private List<DataTransportirItem> dataTransportir;

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

	public void setDataTransportir(List<DataTransportirItem> dataTransportir){
		this.dataTransportir = dataTransportir;
	}

	public List<DataTransportirItem> getDataTransportir(){
		return dataTransportir;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"kode = '" + kode + '\'' + 
			",message = '" + message + '\'' + 
			",data_transportir = '" + dataTransportir + '\'' + 
			"}";
		}
}