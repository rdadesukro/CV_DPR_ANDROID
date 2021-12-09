package com.example.cv_dpr.view;


import com.example.cv_dpr.model.pencairan.DataSeotoranItem_cair;
import com.example.cv_dpr.model.trasnportir.DataTransportirItem;

import java.util.List;


/**
 * This class represents the country view interface.
 *
 * @author Jean Carlos (Github: @jeancsanchez)
 * @date 09/03/18.
 * Jesus loves you.
 */
public interface cair_view {


    void sukses(String pesan);
    void gagal(String pesan);
    void data_cair(List<DataSeotoranItem_cair> data_cair);
    void transportir(List<DataTransportirItem> transportir);
    void data(String total,String  total_do);


}
