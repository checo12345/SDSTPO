package PDF;

import com.itextpdf.text.Chunk;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;



public class Informe {
    public static void main(String[] a3d) throws FileNotFoundException, DocumentException
	{
		FileOutputStream archivo = new FileOutputStream("C:\\Users\\Sergio\\Desktop\\Receta.pdf");
		Document documento = new Document();
		PdfWriter.getInstance(documento, archivo);
		documento.open();
		
                try
                {
                  Image foto = Image.getInstance("C:\\Users\\Sergio\\Desktop\\receta.jpg");
                  foto.scaleToFit(550, 550);
                  foto.setAlignment(Chunk.ALIGN_MIDDLE);
                  documento.add(foto);
                }
                catch ( Exception e )
                {
                      e.printStackTrace();
                }
                documento.add(new Paragraph(" "));
                Calendar c = new GregorianCalendar();
                Date fecha = new Date();
                documento.add(new Paragraph("Nombre Completo del Paciente: "+"   Sergio Daniel Rojas Galindo " ));
		documento.add(new Paragraph("Fecha de la Consulta: "+Integer.toString(c.get(Calendar.DATE))+"-"+Integer.toString(c.get(Calendar.MONTH))+"-"+Integer.toString(c.get(Calendar.YEAR))+"         Hora: "+fecha.getHours()+":"+fecha.getMinutes()+":"+fecha.getSeconds()));
		documento.add(new Paragraph(" "));
                documento.add(new Paragraph("Nombre del Medicamento :"+ "      Paracetamol de 100 mg" +"      Cada: "+ "8 horas"+ "     Por:"+ " 5 dias"));
                documento.add(new Paragraph("Nombre del Medicamento :"+ "      Paracetamol de 100 mg" +"      Cada: "+ "8 horas"+ "     Por:"+ " 5 dias"));
                documento.add(new Paragraph("Nombre del Medicamento :"+ "      Paracetamol de 100 mg" +"      Cada: "+ "8 horas"+ "     Por:"+ " 5 dias"));
                documento.add(new Paragraph("Nombre del Medicamento :"+ "      Paracetamol de 100 mg" +"      Cada: "+ "8 horas"+ "     Por:"+ " 5 dias"));
                documento.add(new Paragraph("Nombre del Medicamento :"+ "      Paracetamol de 100 mg" +"      Cada: "+ "8 horas"+ "     Por:"+ " 5 dias"));
                documento.add(new Paragraph(" "));
                documento.add(new Paragraph("Proxíma Cita: "+Integer.toString(c.get(Calendar.DATE))+"-"+Integer.toString(c.get(Calendar.MONTH))+"-"+Integer.toString(c.get(Calendar.YEAR))+"               Hora: "+fecha.getHours()+":"+fecha.getMinutes()+":"+fecha.getSeconds()));
                documento.add(new Paragraph("Nombre del Responsable: "+"   Dr. Leopoldo Juarez Rodriguez"));
                 documento.add(new Paragraph("Especialidad: "+ "Medico Optometrista"+ "                               Cedula Profesional: "+"12345")) ;
                documento.close();
	}
}
