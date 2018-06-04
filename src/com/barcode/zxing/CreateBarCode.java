package com.barcode.zxing;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;

public class CreateBarCode {
    public static void main(String args[]) {
        int width = 300;
        int height = 300;

        String suffix = "png";

        String content = "my first bar code made using zxing";

        HashMap hints = new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hints.put(EncodeHintType.MARGIN, 2);

        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
            Path path = new File("/Users/wuwenyi1/Documents/Google Drive/Programming/JAVA/bar_code/src/lib/zxing.png").toPath();
            MatrixToImageWriter.writeToPath(bitMatrix, suffix, path);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
