package com.example.cv_dpr.view;


import com.example.cv_dpr.model.trasnportir.DataTransportirItem;

import java.util.List;

/**
 * This class represents the country view interface.
 *
 * @author Jean Carlos (Github: @jeancsanchez)
 * @date 09/03/18.
 * Jesus loves you.
 */
public interface trasnportir_view {

    void data_transportir(String nama,int id);
    void sukses(String pesan);
    void gagal(String pesan);
    void transportir(List<DataTransportirItem> transportir);


}
