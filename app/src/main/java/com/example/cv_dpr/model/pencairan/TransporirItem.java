package com.example.cv_dpr.model.pencairan;

import com.google.gson.annotations.SerializedName;

public class TransporirItem{

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
			"TransporirItem{" + 
			"nama_transportir = '" + namaTransportir + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}