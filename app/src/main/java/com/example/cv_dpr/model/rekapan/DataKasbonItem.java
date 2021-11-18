package com.example.cv_dpr.model.rekapan;

import com.google.gson.annotations.SerializedName;

public class DataKasbonItem{

	@SerializedName("nama")
	private String nama;

	@SerializedName("pemilik_mobil_id")
	private int pemilikMobilId;





	@SerializedName("jumlah_uang")
	private int jumlahUang;

	@SerializedName("id")
	private int id;

	@SerializedName("tanggal")
	private String tanggal;

	@SerializedName("mobil_id")
	private int mobilId;

	@SerializedName("status")
	private String status;

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setPemilikMobilId(int pemilikMobilId){
		this.pemilikMobilId = pemilikMobilId;
	}

	public int getPemilikMobilId(){
		return pemilikMobilId;
	}

	public void setJumlahUang(int jumlahUang){
		this.jumlahUang = jumlahUang;
	}

	public int getJumlahUang(){
		return jumlahUang;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setTanggal(String tanggal){
		this.tanggal = tanggal;
	}

	public String getTanggal(){
		return tanggal;
	}

	public void setMobilId(int mobilId){
		this.mobilId = mobilId;
	}

	public int getMobilId(){
		return mobilId;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"DataKasbonItem{" + 
			"nama = '" + nama + '\'' + 
			",pemilik_mobil_id = '" + pemilikMobilId + '\'' + 
			",jumlah_uang = '" + jumlahUang + '\'' + 
			",id = '" + id + '\'' + 
			",tanggal = '" + tanggal + '\'' + 
			",mobil_id = '" + mobilId + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}