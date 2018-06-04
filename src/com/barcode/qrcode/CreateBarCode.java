package com.barcode.qrcode;

import com.swetake.util.Qrcode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CreateBarCode {
    public static void main(String args[]) throws IOException {
        int width = 67 + 12*(7-1); //version: 7
        int height = 67 + 12*(7-1);

        Qrcode qrcode = new Qrcode();

        qrcode.setQrcodeErrorCorrect('M');
        qrcode.setQrcodeEncodeMode('B'); //B represents other characters (N represents numbers, A represents letters)
        qrcode.setQrcodeVersion(7);

        String content = "my first bar code made by qrcode";

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graph = bufferedImage.createGraphics();
        graph.setBackground(Color.WHITE);
        graph.setColor(Color.BLACK);
        graph.clearRect(0, 0, width, height);

        int offset = 2; //this is a must; otherwise QRCodeDecoder.decode will report index out of bound

        byte[] result = content.getBytes("UTF-8"); //content.getBytes("gb2312") if for Chinese characters

        if (result.length>0 && result.length<120) {
            boolean[][] temp = qrcode.calQrcode(result);
            for (int i=0; i<temp.length; i++) {
                for (int j=0; j<temp.length; j++) {
                    if (temp[i][j]) graph.fillRect(j*3+offset, i*3+offset, 3, 3);
                }
            }
        }

        graph.dispose();
        bufferedImage.flush();
        ImageIO.write(bufferedImage, "png", new File("/Users/wuwenyi1/Documents/Google Drive/Programming/JAVA/bar_code/src/lib/qrcode.png"));
    }
}
