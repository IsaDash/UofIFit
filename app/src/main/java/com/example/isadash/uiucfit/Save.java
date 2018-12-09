package com.example.isadash.uiucfit;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Save {
    private Context context;
    private String folderName = "picture_gallery";
    private String fileName = "picture";

    public void saveImage(Context context, Bitmap image) {
        this.context = context;
        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + folderName;
        String dateAndTime = getCurrentDateAndTime();
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File file = new File(dir, fileName + dateAndTime + ".jpg");

        try {
            FileOutputStream fOut = new FileOutputStream(file);
            image.compress(Bitmap.CompressFormat.JPEG, 85, fOut);
            fOut.flush();
            fOut.close();
            fileExists(file);
            Toast.makeText(context, "Picture Saved", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            Toast.makeText(context, "Unable to save Picture", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(context, "Unable to save Picture", Toast.LENGTH_SHORT).show();
        }
    }

    public void fileExists(File file) {
        MediaScannerConnection.scanFile(context, new String[]{file.toString()}, null,
                new MediaScannerConnection.OnScanCompletedListener() {
                    @Override
                    public void onScanCompleted(String path, Uri uri) {
                        Log.e("ExternalStorage", "Scanned " + path + ":");
                        Log.e("ExternalStorage", "-> uri=" + uri);
                    }
                });
    }

    public String getCurrentDateAndTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String date = dateFormat.format(calendar.getTime());
        return date;
    }


}
