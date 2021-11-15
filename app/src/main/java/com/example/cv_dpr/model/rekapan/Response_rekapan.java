package com.example.cv_dpr.model.rekapan;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Response_rekapan {

	@SerializedName("total_kasbon")
	private String totalKasbon;

	@SerializedName("total_uang_jalan")
	private String totalUangJalan;

	@SerializedName("total_bersih")
	private String totalBersih;

	@SerializedName("data_setoran")
	private List<DataSetoranItem> dataSetoran;

	@SerializedName("hasil_bersih")
	private String hasilBersih;

	@SerializedName("kode")
	private boolean kode;

	@SerializedName("data_kasbon")
	private List<DataKasbonItem> dataKasbon;

	@SerializedName("total_kotor")
	private String totalKotor;

	@SerializedName("message")
	private String message;

	public void setTotalKasbon(String totalKasbon){
		this.totalKasbon = totalKasbon;
	}

	public String getTotalKasbon(){
		return totalKasbon;
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

	public void setDataSetoran(List<DataSetoranItem> dataSetoran){
		this.dataSetoran = dataSetoran;
	}

	public List<DataSetoranItem> getDataSetoran(){
		return dataSetoran;
	}

	public void setHasilBersih(String hasilBersih){
		this.hasilBersih = hasilBersih;
	}

	public String getHasilBersih(){
		return hasilBersih;
	}

	public void setKode(boolean kode){
		this.kode = kode;
	}

	public boolean isKode(){
		return kode;
	}

	public void setDataKasbon(List<DataKasbonItem> dataKasbon){
		this.dataKasbon = dataKasbon;
	}

	public List<DataKasbonItem> getDataKasbon(){
		return dataKasbon;
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

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"total_kasbon = '" + totalKasbon + '\'' + 
			",total_uang_jalan = '" + totalUangJalan + '\'' + 
			",total_bersih = '" + totalBersih + '\'' + 
			",data_setoran = '" + dataSetoran + '\'' + 
			",hasil_bersih = '" + hasilBersih + '\'' + 
			",kode = '" + kode + '\'' + 
			",data_kasbon = '" + dataKasbon + '\'' + 
			",total_kotor = '" + totalKotor + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}