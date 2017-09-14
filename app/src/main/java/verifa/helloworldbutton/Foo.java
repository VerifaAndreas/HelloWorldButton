package verifa.helloworldbutton;


import android.graphics.pdf.PdfRenderer;
import android.os.ParcelFileDescriptor;

import java.io.File;

public class Foo {

    public int foo() {
        PdfRenderer pdfRenderer;
        try {
            ParcelFileDescriptor parcelFileDescriptor = ParcelFileDescriptor.open(new File("C:\\Temp\\test.pdf"), ParcelFileDescriptor.MODE_READ_ONLY);
            pdfRenderer = new PdfRenderer(parcelFileDescriptor);
            int pageCount = pdfRenderer.getPageCount();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return -1;
        }
        return 4;
    }

}
