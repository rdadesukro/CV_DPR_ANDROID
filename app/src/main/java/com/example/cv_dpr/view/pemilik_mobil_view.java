package com.example.cv_dpr.view;


import com.example.cv_dpr.model.pemilik_mobil.DataPemilikMobilItem;

import java.util.List;


/**
 * This class represents the country view interface.
 *
 * @author Jean Carlos (Github: @jeancsanchez)
 * @date 09/03/18.
 * Jesus loves you.
 */
public interface pemilik_mobil_view {



    void sukses(String pesan);
    void gagal(String pesan);
    void pemilik_mobil(List<DataPemilikMobilItem> pemilik_mobil);



}
