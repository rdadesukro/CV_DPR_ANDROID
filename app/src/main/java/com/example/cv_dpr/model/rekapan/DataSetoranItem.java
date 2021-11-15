package com.example.cv_dpr.model.rekapan;

import com.google.gson.annotations.SerializedName;

public class DataSetoranItem{

	@SerializedName("tgl_muat")
	private String tglMuat;

	@SerializedName("jumlah_kotor")
	private int jumlahKotor;

	@SerializedName("berat_muat")
	private String beratMuat;

	@SerializedName("uang_jalan")
	private int uangJalan;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("tgl_ambil_uang_jalan")
	private String tglAmbilUangJalan;

	@SerializedName("tujuan")
	private String tujuan;

	@SerializedName("mobil")
	private Mobil mobil;

	@SerializedName("pemilik_mobil_id")
	private int pemilikMobilId;

	@SerializedName("harga")
	private int harga;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("foto")
	private String foto;

	@SerializedName("jumlah_bersih")
	private int jumlahBersih;

	@SerializedName("tgl_bongkar")
	private String tglBongkar;

	@SerializedName("id")
	private int id;

	@SerializedName("transportir_id")
	private int transportirId;

	@SerializedName("berat_bongkar")
	private String beratBongkar;

	@SerializedName("mobil_id")
	private int mobilId;

	@SerializedName("status")
	private String status;

	public void setTglMuat(String tglMuat){
		this.tglMuat = tglMuat;
	}

	public String getTglMuat(){
		return tglMuat;
	}

	public void setJumlahKotor(int jumlahKotor){
		this.jumlahKotor = jumlahKotor;
	}

	public int getJumlahKotor(){
		return jumlahKotor;
	}

	public void setBeratMuat(String beratMuat){
		this.beratMuat = beratMuat;
	}

	public String getBeratMuat(){
		return beratMuat;
	}

	public void setUangJalan(int uangJalan){
		this.uangJalan = uangJalan;
	}

	public int getUangJalan(){
		return uangJalan;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setTglAmbilUangJalan(String tglAmbilUangJalan){
		this.tglAmbilUangJalan = tglAmbilUangJalan;
	}

	public String getTglAmbilUangJalan(){
		return tglAmbilUangJalan;
	}

	public void setTujuan(String tujuan){
		this.tujuan = tujuan;
	}

	public String getTujuan(){
		return tujuan;
	}

	public void setMobil(Mobil mobil){
		this.mobil = mobil;
	}

	public Mobil getMobil(){
		return mobil;
	}

	public void setPemilikMobilId(int pemilikMobilId){
		this.pemilikMobilId = pemilikMobilId;
	}

	public int getPemilikMobilId(){
		return pemilikMobilId;
	}

	public void setHarga(int harga){
		this.harga = harga;
	}

	public int getHarga(){
		return harga;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setFoto(String foto){
		this.foto = foto;
	}

	public String getFoto(){
		return foto;
	}

	public void setJumlahBersih(int jumlahBersih){
		this.jumlahBersih = jumlahBersih;
	}

	public int getJumlahBersih(){
		return jumlahBersih;
	}

	public void setTglBongkar(String tglBongkar){
		this.tglBongkar = tglBongkar;
	}

	public String getTglBongkar(){
		return tglBongkar;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setTransportirId(int transportirId){
		this.transportirId = transportirId;
	}

	public int getTransportirId(){
		return transportirId;
	}

	public void setBeratBongkar(String beratBongkar){
		this.beratBongkar = beratBongkar;
	}

	public String getBeratBongkar(){
		return beratBongkar;
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
			"DataSetoranItem{" + 
			"tgl_muat = '" + tglMuat + '\'' + 
			",jumlah_kotor = '" + jumlahKotor + '\'' + 
			",berat_muat = '" + beratMuat + '\'' + 
			",uang_jalan = '" + uangJalan + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",tgl_ambil_uang_jalan = '" + tglAmbilUangJalan + '\'' + 
			",tujuan = '" + tujuan + '\'' + 
			",mobil = '" + mobil + '\'' + 
			",pemilik_mobil_id = '" + pemilikMobilId + '\'' + 
			",harga = '" + harga + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",foto = '" + foto + '\'' + 
			",jumlah_bersih = '" + jumlahBersih + '\'' + 
			",tgl_bongkar = '" + tglBongkar + '\'' + 
			",id = '" + id + '\'' + 
			",transportir_id = '" + transportirId + '\'' + 
			",berat_bongkar = '" + beratBongkar + '\'' + 
			",mobil_id = '" + mobilId + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}