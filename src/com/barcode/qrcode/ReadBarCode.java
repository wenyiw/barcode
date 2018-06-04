package com.barcode.qrcode;

import jp.sourceforge.qrcode.QRCodeDecoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//does not decode correctly; zxing can decode
public class ReadBarCode {
    public static void main(String args[]) throws IOException {
        File file = new File("/Users/wuwenyi1/Documents/Google Drive/Programming/JAVA/bar_code/src/lib/qrcode.png");

        BufferedImage bufferedImage = ImageIO.read(file);

        QRCodeDecoder codeDecoder=new QRCodeDecoder();
        String result=new String(codeDecoder.decode(new QRCodeImageImpl(bufferedImage)),"UTF-8");

        System.out.println(result);
    }

}
