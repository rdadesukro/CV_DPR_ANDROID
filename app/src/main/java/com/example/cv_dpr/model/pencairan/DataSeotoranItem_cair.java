package com.example.cv_dpr.model.pencairan;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataSeotoranItem_cair {

	@SerializedName("jumlah_kotor")
	private int jumlahKotor;

	@SerializedName("berat_muat")
	private int beratMuat;

	@SerializedName("uang_jalan")
	private int uangJalan;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("tgl_ambil_uang_jalan")
	private String tglAmbilUangJalan;

	@SerializedName("berat_bongkar_new")
	private String beratBongkarNew;

	@SerializedName("uang_jalan_new")
	private String uangJalanNew;

	@SerializedName("transporir")
	private List<TransporirItem> transporir;

	@SerializedName("mobil")
	private Mobil mobil;

	@SerializedName("pemilik_mobil_id")
	private int pemilikMobilId;

	@SerializedName("harga")
	private int harga;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("status_pembayaran")
	private String statusPembayaran;

	@SerializedName("berat")
	private String berat;

	@SerializedName("tgl_bongkar")
	private String tglBongkar;

	@SerializedName("totalpencairan")
	private int totalpencairan;

	@SerializedName("id")
	private int id;

	@SerializedName("transportir_id")
	private int transportirId;

	@SerializedName("berat_bongkar")
	private int beratBongkar;

	@SerializedName("mobil_id")
	private int mobilId;

	@SerializedName("tgl_muat")
	private String tglMuat;

	@SerializedName("tujuan")
	private String tujuan;

	@SerializedName("berat_muat_new")
	private String beratMuatNew;

	@SerializedName("jumlah_kotor_new")
	private String jumlahKotorNew;

	@SerializedName("foto")
	private String foto;

	@SerializedName("jumlah_bersih")
	private int jumlahBersih;

	@SerializedName("status_pencairan")
	private String statusPencairan;

	@SerializedName("jumlah_bersih_new")
	private String jumlahBersihNew;

	public void setJumlahKotor(int jumlahKotor){
		this.jumlahKotor = jumlahKotor;
	}

	public int getJumlahKotor(){
		return jumlahKotor;
	}

	public void setBeratMuat(int beratMuat){
		this.beratMuat = beratMuat;
	}

	public int getBeratMuat(){
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

	public void setBeratBongkarNew(String beratBongkarNew){
		this.beratBongkarNew = beratBongkarNew;
	}

	public String getBeratBongkarNew(){
		return beratBongkarNew;
	}

	public void setUangJalanNew(String uangJalanNew){
		this.uangJalanNew = uangJalanNew;
	}

	public String getUangJalanNew(){
		return uangJalanNew;
	}

	public void setTransporir(List<TransporirItem> transporir){
		this.transporir = transporir;
	}

	public List<TransporirItem> getTransporir(){
		return transporir;
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

	public void setStatusPembayaran(String statusPembayaran){
		this.statusPembayaran = statusPembayaran;
	}

	public String getStatusPembayaran(){
		return statusPembayaran;
	}

	public void setBerat(String berat){
		this.berat = berat;
	}

	public String getBerat(){
		return berat;
	}

	public void setTglBongkar(String tglBongkar){
		this.tglBongkar = tglBongkar;
	}

	public String getTglBongkar(){
		return tglBongkar;
	}

	public void setTotalpencairan(int totalpencairan){
		this.totalpencairan = totalpencairan;
	}

	public int getTotalpencairan(){
		return totalpencairan;
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

	public void setBeratBongkar(int beratBongkar){
		this.beratBongkar = beratBongkar;
	}

	public int getBeratBongkar(){
		return beratBongkar;
	}

	public void setMobilId(int mobilId){
		this.mobilId = mobilId;
	}

	public int getMobilId(){
		return mobilId;
	}

	public void setTglMuat(String tglMuat){
		this.tglMuat = tglMuat;
	}

	public String getTglMuat(){
		return tglMuat;
	}

	public void setTujuan(String tujuan){
		this.tujuan = tujuan;
	}

	public String getTujuan(){
		return tujuan;
	}

	public void setBeratMuatNew(String beratMuatNew){
		this.beratMuatNew = beratMuatNew;
	}

	public String getBeratMuatNew(){
		return beratMuatNew;
	}

	public void setJumlahKotorNew(String jumlahKotorNew){
		this.jumlahKotorNew = jumlahKotorNew;
	}

	public String getJumlahKotorNew(){
		return jumlahKotorNew;
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

	public void setStatusPencairan(String statusPencairan){
		this.statusPencairan = statusPencairan;
	}

	public String getStatusPencairan(){
		return statusPencairan;
	}

	public void setJumlahBersihNew(String jumlahBersihNew){
		this.jumlahBersihNew = jumlahBersihNew;
	}

	public String getJumlahBersihNew(){
		return jumlahBersihNew;
	}

	@Override
 	public String toString(){
		return 
			"DataSeotoranItem{" + 
			"jumlah_kotor = '" + jumlahKotor + '\'' + 
			",berat_muat = '" + beratMuat + '\'' + 
			",uang_jalan = '" + uangJalan + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",tgl_ambil_uang_jalan = '" + tglAmbilUangJalan + '\'' + 
			",berat_bongkar_new = '" + beratBongkarNew + '\'' + 
			",uang_jalan_new = '" + uangJalanNew + '\'' + 
			",transporir = '" + transporir + '\'' + 
			",mobil = '" + mobil + '\'' + 
			",pemilik_mobil_id = '" + pemilikMobilId + '\'' + 
			",harga = '" + harga + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",status_pembayaran = '" + statusPembayaran + '\'' + 
			",berat = '" + berat + '\'' + 
			",tgl_bongkar = '" + tglBongkar + '\'' + 
			",totalpencairan = '" + totalpencairan + '\'' + 
			",id = '" + id + '\'' + 
			",transportir_id = '" + transportirId + '\'' + 
			",berat_bongkar = '" + beratBongkar + '\'' + 
			",mobil_id = '" + mobilId + '\'' + 
			",tgl_muat = '" + tglMuat + '\'' + 
			",tujuan = '" + tujuan + '\'' + 
			",berat_muat_new = '" + beratMuatNew + '\'' + 
			",jumlah_kotor_new = '" + jumlahKotorNew + '\'' + 
			",foto = '" + foto + '\'' + 
			",jumlah_bersih = '" + jumlahBersih + '\'' + 
			",status_pencairan = '" + statusPencairan + '\'' + 
			",jumlah_bersih_new = '" + jumlahBersihNew + '\'' + 
			"}";
		}
}