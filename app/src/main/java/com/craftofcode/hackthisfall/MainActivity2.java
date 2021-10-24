package com.craftofcode.hackthisfall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import org.json.*;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.sawolabs.androidsdk.ConstantsKt;

import org.json.JSONObject;

import java.util.Hashtable;


public class MainActivity2 extends AppCompatActivity {
    ImageView qrImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

     //   TextView responseTxt=findViewById(R.id.responseTxt);
        qrImage = (ImageView)findViewById(R.id.qrImage);

        Intent intent = getIntent();
        String message = intent.getStringExtra(ConstantsKt.LOGIN_SUCCESS_MESSAGE);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        JSONObject json;

        try {
            json = new JSONObject(message);
         //   responseTxt.setText(json.toString());
         //   responseTxt.setText(json.getString("user_id"));
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<>();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);


            QRCodeWriter qrCodeEncoder = new QRCodeWriter();
            BitMatrix bitMatrix = null;
            try {
                bitMatrix = qrCodeEncoder.encode(json.getString("user_id"), BarcodeFormat.QR_CODE,
                        250, 250, hintMap);
            } catch (WriterException e) {
                e.printStackTrace();
            }

            int height = bitMatrix.getHeight();
            int width = bitMatrix.getWidth();

            final Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);

            for (int x = 0; x < width; x++){
                for (int y = 0; y < height; y++){
                    bmp.setPixel(x, y, bitMatrix.get(x,y) ? android.graphics.Color.WHITE : android.graphics.Color.BLACK);
                }
            }


            //  ImageView myImage = (ImageView) findViewById(R.id.qr_code);
            qrImage.setImageBitmap(bmp);




    } catch (JSONException e) {
            e.printStackTrace();
          //  responseTxt.setText("Error in parsing data");

        }

// continue with your implementation
    }
}