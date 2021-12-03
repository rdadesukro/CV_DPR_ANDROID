package com.example.cv_dpr.model.pembyaran;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataSopirItem_data {

	@SerializedName("pemilik_mobil_id")
	private int pemilikMobilId;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("jenis")
	private String jenis;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("nama_sopir")
	private String namaSopir;

	@SerializedName("pemilik_mobil")
	private List<PemilikMobilItem_data> pemilikMobil;

	@SerializedName("nopol")
	private String nopol;

	public void setPemilikMobilId(int pemilikMobilId){
		this.pemilikMobilId = pemilikMobilId;
	}

	public int getPemilikMobilId(){
		return pemilikMobilId;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setJenis(String jenis){
		this.jenis = jenis;
	}

	public String getJenis(){
		return jenis;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setNamaSopir(String namaSopir){
		this.namaSopir = namaSopir;
	}

	public String getNamaSopir(){
		return namaSopir;
	}

	public void setPemilikMobil(List<PemilikMobilItem_data> pemilikMobil){
		this.pemilikMobil = pemilikMobil;
	}

	public List<PemilikMobilItem_data> getPemilikMobil(){
		return pemilikMobil;
	}

	public void setNopol(String nopol){
		this.nopol = nopol;
	}

	public String getNopol(){
		return nopol;
	}

	@Override
 	public String toString(){
		return 
			"DataSopirItem{" + 
			"pemilik_mobil_id = '" + pemilikMobilId + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",jenis = '" + jenis + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",nama_sopir = '" + namaSopir + '\'' + 
			",pemilik_mobil = '" + pemilikMobil + '\'' + 
			",nopol = '" + nopol + '\'' + 
			"}";
		}
}