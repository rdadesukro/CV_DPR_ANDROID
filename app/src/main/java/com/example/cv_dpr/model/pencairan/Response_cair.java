package com.example.cv_dpr.model.pencairan;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response_cair {

	@SerializedName("total_do")
	private int totalDo;

	@SerializedName("transportir")
	private String transportir;

	@SerializedName("kode")
	private boolean kode;

	@SerializedName("data_seotoran")
	private List<DataSeotoranItem_cair> dataSeotoran;

	@SerializedName("hasil")
	private String hasil;

	@SerializedName("message")
	private String message;

	public void setTotalDo(int totalDo){
		this.totalDo = totalDo;
	}

	public int getTotalDo(){
		return totalDo;
	}

	public void setTransportir(String transportir){
		this.transportir = transportir;
	}

	public String getTransportir(){
		return transportir;
	}

	public void setKode(boolean kode){
		this.kode = kode;
	}

	public boolean isKode(){
		return kode;
	}

	public void setDataSeotoran(List<DataSeotoranItem_cair> dataSeotoran){
		this.dataSeotoran = dataSeotoran;
	}

	public List<DataSeotoranItem_cair> getDataSeotoran(){
		return dataSeotoran;
	}

	public void setHasil(String hasil){
		this.hasil = hasil;
	}

	public String getHasil(){
		return hasil;
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
			"total_do = '" + totalDo + '\'' + 
			",transportir = '" + transportir + '\'' + 
			",kode = '" + kode + '\'' + 
			",data_seotoran = '" + dataSeotoran + '\'' + 
			",hasil = '" + hasil + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}