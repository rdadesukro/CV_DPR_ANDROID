package com.example.cv_dpr.model.trasnportir;

import com.google.gson.annotations.SerializedName;

public class DataTransportirItem{

	@SerializedName("nama_transportir")
	private String namaTransportir;

	@SerializedName("id")
	private int id;

	public void setNamaTransportir(String namaTransportir){
		this.namaTransportir = namaTransportir;
	}

	public String getNamaTransportir(){
		return namaTransportir;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"DataTransportirItem{" + 
			"nama_transportir = '" + namaTransportir + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}