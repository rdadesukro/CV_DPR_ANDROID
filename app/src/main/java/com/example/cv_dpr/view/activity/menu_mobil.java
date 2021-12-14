package com.example.cv_dpr.view.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cv_dpr.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;
import com.krishna.fileloader.FileLoader;
import com.krishna.fileloader.listener.FileRequestListener;
import com.krishna.fileloader.pojo.FileResponse;
import com.krishna.fileloader.request.FileLoadRequest;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.net.ssl.SSLContext;

import es.voghdev.pdfviewpager.library.RemotePDFViewPager;
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter;
import es.voghdev.pdfviewpager.library.remote.DownloadFile;
import es.voghdev.pdfviewpager.library.util.FileUtil;

public class menu_mobil extends AppCompatActivity implements DownloadFile.Listener, OnLoadCompleteListener, OnPageErrorListener {

    private PDFView idPDFView;
    String pdfurl = "http://192.168.43.48/cv_dpr/public/api/tampil_pencairan_pdf?jenis=";
    private ProgressBar progressBar;
    private LinearLayout pdfLayout;

    private RemotePDFViewPager remotePDFViewPager;

    private PDFPagerAdapter pdfPagerAdapter;

    private String url;
    String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_mobil);
        initView();
        Intent iin = getIntent();
        Bundle b = iin.getExtras();
        final PDFView pdfView= findViewById(R.id.pdfView);
        if (b != null) {
            id = (String) b.get("id");



        }
        try {
            ProviderInstaller.installIfNeeded(menu_mobil.this);
            SSLContext sslContext;
            sslContext = SSLContext.getInstance("TLSv1.2");
            sslContext.init(null, null, null);
            sslContext.createSSLEngine();
        } catch (GooglePlayServicesRepairableException | GooglePlayServicesNotAvailableException
                | NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        String currentDateandTime = sdf.format(new Date());
      //  new RetrivePDFfromUrl().execute(pdfurl+id);
       // remotePDFViewPager = new RemotePDFViewPager(this, pdfurl+id, this);
        FileLoader.with(menu_mobil.this)
                .load(id+"?time="+currentDateandTime,false) //2nd parameter is optioal, pass true to force load from network
                .fromDirectory("My_PDFs", FileLoader.DIR_INTERNAL)
                .asFile(new FileRequestListener<File>() {
                    @Override
                    public void onLoad(FileLoadRequest request, FileResponse<File> response) {

                        File pdfFile = response.getBody();
                       // pdfViewProgressBar.setVisibility(View.GONE);
                        try {

                            pdfView.fromFile(pdfFile)
                                    .defaultPage(1)
                                    .enableAnnotationRendering(true)
                                    .onLoad(menu_mobil.this)
                                    .scrollHandle(new DefaultScrollHandle(menu_mobil.this))
                                    .spacing(10) // in dp
                                    .load();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    @Override
                    public void onError(FileLoadRequest request, Throwable t) {
                       // pdfViewProgressBar.setVisibility(View.GONE);
                        Toast.makeText(menu_mobil.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }

    private void initView() {
        //idPDFView = findViewById(R.id.idPDFView);
        progressBar = findViewById(R.id.progressBar);
        pdfLayout = findViewById(R.id.pdf_layout);
    }

    @Override
    public void onSuccess(String url, String destinationPath) {
        // That's the positive case. PDF Download went fine
        pdfPagerAdapter = new PDFPagerAdapter(this, FileUtil.extractFileNameFromURL(url));
        remotePDFViewPager.setAdapter(pdfPagerAdapter);
        updateLayout();
        progressBar.setVisibility(View.GONE);
    }
    private void updateLayout() {

        pdfLayout.addView(remotePDFViewPager,
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
    }
    @Override
    public void onFailure(Exception e) {

    }

    @Override
    public void onProgressUpdate(int progress, int total) {

    }
    @Override
    public void onDestroy() {
        super.onDestroy();

        if (pdfPagerAdapter != null) {
            pdfPagerAdapter.close();
        }
    }

    @Override
    public void loadComplete(int nbPages) {

    }

    @Override
    public void onPageError(int page, Throwable t) {

    }

    class RetrivePDFfromUrl extends AsyncTask<String, Void, InputStream> {
        @Override
        protected InputStream doInBackground(String... strings) {
            // we are using inputstream
            // for getting out PDF.
            InputStream inputStream = null;
            try {
                URL url = new URL(strings[0]);
                // below is the step where we are
                // creating our connection.
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                if (urlConnection.getResponseCode() == 200) {
                    //progressBar.setVisibility(View.GONE);
                    // response is success.
                    // we are getting input stream from url
                    // and storing it in our variable.
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
                }

            } catch (IOException e) {
                // this is the method
                // to handle errors.
                e.printStackTrace();
                return null;
            }
            return inputStream;
        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            // after the execution of our async
            // task we are loading our pdf in our pdf view.
            idPDFView.fromStream(inputStream).load();
        }
    }

}