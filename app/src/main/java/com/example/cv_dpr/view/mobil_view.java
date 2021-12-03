package com.example.cv_dpr.view;


import com.example.cv_dpr.model.pembyaran.DataKasbonItem;
import com.example.cv_dpr.model.pembyaran.DataPemilikMobilItem_mobil;
import com.example.cv_dpr.model.pembyaran.DataSetoranItem_pembayaran;
import com.example.cv_dpr.model.pembyaran.DataSopirItem_data;

import java.util.List;


/**
 * This class represents the country view interface.
 *
 * @author Jean Carlos (Github: @jeancsanchez)
 * @date 09/03/18.
 * Jesus loves you.
 */
public interface mobil_view {

    void data_sopir(String nama_sopir, String nama_pemilik_mobil,int pemilik_mobil_id,int mobil_id);

    void sukses(String pesan);
    void gagal(String pesan);
    void kasbon(List<DataKasbonItem> kasbon);
    void pembayaran(List<DataSetoranItem_pembayaran> pembayaran);
    String data_pembayaran (String  totol_setoran,String total_uang_jalan,String total_bersih,String total_kasbon,String total_finis );
    void  data_sopir(List<DataSopirItem_data> sopir);
    void  data_pemilik_mobil(List<DataPemilikMobilItem_mobil> pemilik_mobil);


}
