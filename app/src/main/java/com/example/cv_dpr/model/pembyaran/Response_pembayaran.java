package com.example.cv_dpr.model.pembyaran;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response_pembayaran {

	@SerializedName("total_kasbon")
	private String totalKasbon;

	@SerializedName("data_sopir")
	private List<DataSopirItem_data> dataSopir;

	@SerializedName("total_uang_jalan")
	private String totalUangJalan;

	@SerializedName("total_bersih")
	private String totalBersih;

	@SerializedName("data_setoran")
	private List<DataSetoranItem_pembayaran> dataSetoran;

	@SerializedName("kode")
	private boolean kode;

	@SerializedName("no_polisi")
	private String noPolisi;

	@SerializedName("data_kasbon")
	private List<DataKasbonItem> dataKasbon;

	@SerializedName("total_final_bersih")
	private String totalFinalBersih;

	@SerializedName("total_kotor")
	private String totalKotor;

	@SerializedName("message")
	private String message;

	@SerializedName("data_pemilik_mobil")
	private List<DataPemilikMobilItem_mobil> dataPemilikMobil;

	public void setTotalKasbon(String totalKasbon){
		this.totalKasbon = totalKasbon;
	}

	public String getTotalKasbon(){
		return totalKasbon;
	}

	public void setDataSopir(List<DataSopirItem_data> dataSopir){
		this.dataSopir = dataSopir;
	}

	public List<DataSopirItem_data> getDataSopir(){
		return dataSopir;
	}

	public void setTotalUangJalan(String totalUangJalan){
		this.totalUangJalan = totalUangJalan;
	}

	public String getTotalUangJalan(){
		return totalUangJalan;
	}

	public void setTotalBersih(String totalBersih){
		this.totalBersih = totalBersih;
	}

	public String getTotalBersih(){
		return totalBersih;
	}

	public void setDataSetoran(List<DataSetoranItem_pembayaran> dataSetoran){
		this.dataSetoran = dataSetoran;
	}

	public List<DataSetoranItem_pembayaran> getDataSetoran(){
		return dataSetoran;
	}

	public void setKode(boolean kode){
		this.kode = kode;
	}

	public boolean isKode(){
		return kode;
	}

	public void setNoPolisi(String noPolisi){
		this.noPolisi = noPolisi;
	}

	public String getNoPolisi(){
		return noPolisi;
	}

	public void setDataKasbon(List<DataKasbonItem> dataKasbon){
		this.dataKasbon = dataKasbon;
	}

	public List<DataKasbonItem> getDataKasbon(){
		return dataKasbon;
	}

	public void setTotalFinalBersih(String totalFinalBersih){
		this.totalFinalBersih = totalFinalBersih;
	}

	public String getTotalFinalBersih(){
		return totalFinalBersih;
	}

	public void setTotalKotor(String totalKotor){
		this.totalKotor = totalKotor;
	}

	public String getTotalKotor(){
		return totalKotor;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setDataPemilikMobil(List<DataPemilikMobilItem_mobil> dataPemilikMobil){
		this.dataPemilikMobil = dataPemilikMobil;
	}

	public List<DataPemilikMobilItem_mobil> getDataPemilikMobil(){
		return dataPemilikMobil;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"total_kasbon = '" + totalKasbon + '\'' + 
			",data_sopir = '" + dataSopir + '\'' + 
			",total_uang_jalan = '" + totalUangJalan + '\'' + 
			",total_bersih = '" + totalBersih + '\'' + 
			",data_setoran = '" + dataSetoran + '\'' + 
			",kode = '" + kode + '\'' + 
			",no_polisi = '" + noPolisi + '\'' + 
			",data_kasbon = '" + dataKasbon + '\'' + 
			",total_final_bersih = '" + totalFinalBersih + '\'' + 
			",total_kotor = '" + totalKotor + '\'' + 
			",message = '" + message + '\'' + 
			",data_pemilik_mobil = '" + dataPemilikMobil + '\'' + 
			"}";
		}
}