package PDF;

import Beans.Medicamento;
import Beans.MedicoBean;
import Beans.Paciente;
import Beans.RecetaMedicaBean;
import Clases.Prediagnostico;
import Imagenes.imagenes;
import com.itextpdf.text.Chunk;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Informe {
         
         
         public Informe(){} ;
         public void generarRecetaPDF(RecetaMedicaBean recetaMB,String ruta) throws FileNotFoundException, DocumentException
	{
            URL tmp;
                tmp=imagenes.class.getResource("receta.jpg");
		FileOutputStream archivo = new FileOutputStream(ruta+"Receta.pdf");
		Document documento = new Document();
		PdfWriter.getInstance(documento, archivo);
		documento.open();
		
                try
                {
                //  URL url= this.getClass().getResource("C:\\Users\\Sergio\\Desktop\\receta.jpg");
                  Image foto = Image.getInstance(tmp.toString());
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
                documento.add(new Paragraph("Nombre Completo del Paciente: "+ recetaMB.getNombrePaciente()));
		documento.add(new Paragraph("Fecha de la Consulta: "+recetaMB.getFecha()));
		documento.add(new Paragraph(" "));
                for (Medicamento medicamento: recetaMB.getMedicamentos())
                    documento.add(new Paragraph("Medicamento :"+medicamento.getNombre() +"Presentación: "+medicamento.getPresentacion()+ "Dosis: "+medicamento.getDosis()));
               

                documento.add(new Paragraph(" "));
                documento.add(new Paragraph("Proxíma Cita: "+recetaMB.getProximaCita()));
                documento.add(new Paragraph("Nombre del Responsable: "+recetaMB.getNombreResponsable()));
                documento.add(new Paragraph("Especialidad: "+ recetaMB.getEspecialidadResp()+ "                               Cedula Profesional: "+recetaMB.getCedulaResp())) ;
                documento.close();
	}
         public void generarReporteMelCat(String ruta,Paciente paciente,MedicoBean medico,Prediagnostico prediagnostico){
             try {
                 FileOutputStream archivo = null;
                 try {
                     archivo = new FileOutputStream(ruta+"Reporte.pdf");
                 } catch (FileNotFoundException ex) {
                     Logger.getLogger(Informe.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 Document documento = new Document(PageSize.LETTER);
                 try {
                     PdfWriter.getInstance(documento, archivo);
                 } catch (DocumentException ex) {
                     Logger.getLogger(Informe.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 documento.open();
                 
                 
                 
                 try
                 {
                     
                     Image foto = Image.getInstance(imagenes.class.getResource("receta.jpg"));
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
                 documento.add(new Paragraph("Nombre Completo del Paciente: "+"   "+paciente.getNombre()+" "+paciente.getApellidoPaterno()+" "+paciente.getApellidoMaterno() ));
                 documento.add(new Paragraph("CURP: "+"   "+paciente.getCurp()  ));
                 documento.add(new Paragraph("Sexo: "+"   "+paciente.getSexo() ));
                 documento.add(new Paragraph("Tipo de Sangre: "+"   "+paciente.getTipoSangre()  ));
                 documento.add(new Paragraph("Fecha de Nacimiento: "+"  "+paciente.getFechaNacimiento() ));
                 documento.add(new Paragraph("Telefono: "+"   "+paciente.getTelefono()  ));
                 documento.add(new Paragraph("Dirección: "+"   "+paciente.getDireccion() ));
                 
                 documento.add(new Paragraph("Fecha de la Consulta: "+Integer.toString(c.get(Calendar.DATE))+"-"+Integer.toString(c.get(Calendar.MONTH))+"-"+Integer.toString(c.get(Calendar.YEAR))+"         Hora: "+fecha.getHours()+":"+fecha.getMinutes()+":"+fecha.getSeconds()));
                 documento.add(new Paragraph(" "));
                 
                 documento.add(new Paragraph("PRE-DIAGNOSTICO DE PATOLOGÍAS OCULARES"));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph("OBSERVACIONES DEL MEDICO"));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(prediagnostico.getObservaciones()));

                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph("                      Imagen del ojo Izquierdo                                   Imagen del Ojo Derecho"));
                 
                 try
                 {
                     
                     Image foto = Image.getInstance(prediagnostico.getOjoIzquierdo().getRuta());
                     foto.scaleToFit(200, 200);
                     // foto.setAlignment(Chunk.ALIGN_MIDDLE);
                     foto.setAbsolutePosition(100f, 50f);
                     documento.add(foto);
                     Image foto1 = Image.getInstance(prediagnostico.getOjoDerecho().getRuta());
                     foto1.scaleToFit(200, 200);
                     
                     //foto1.setAlignment(Chunk.ALIGN_MIDDLE);
                     foto1.setAbsolutePosition(350f, 50f);
                     documento.add(foto1);
                 }
                 catch ( Exception e )
                 {
                     e.printStackTrace();
                 }
                 
                 documento.newPage();
                 try
                 {
                     
                     Image foto = Image.getInstance(imagenes.class.getResource("receta.jpg"));
                     foto.scaleToFit(550, 550);
                     foto.setAlignment(Chunk.ALIGN_MIDDLE);
                     documento.add(foto);
                 }
                 catch ( Exception e )
                 {
                     e.printStackTrace();
                 }
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph("                    Se obtuvieron los siguientes resultados para la patología MELANOMA DE IRIS:"));
                 
                 
                 try
                 {
                     
                     Image foto = Image.getInstance(prediagnostico.getImgOIM().getRuta());
                     foto.scaleToFit(200, 200);
                     foto.setAbsolutePosition(100f, 380f);
                     documento.add(foto);
                     
                     Image foto1 = Image.getInstance(prediagnostico.getImgODM().getRuta());
                     foto1.scaleToFit(200, 200);
                     foto1.setAbsolutePosition(350f, 380f);
                     documento.add(foto1);
                     
                     Image foto2 = Image.getInstance(prediagnostico.getImgOIC().getRuta());
                     foto2.scaleToFit(200, 200);
                     foto2.setAbsolutePosition(100f, 100f);
                     documento.add(foto2);
                     
                     Image foto3 = Image.getInstance(prediagnostico.getImgODC().getRuta());
                     foto3.scaleToFit(200, 200);
                     foto3.setAbsolutePosition(350f, 100f);
                     documento.add(foto3);
                 }
                 catch ( Exception e )
                 {
                     e.printStackTrace();
                 }
                 double[] resultados=prediagnostico.getResultado();
                 documento.add(new Paragraph("                      Imagen del ojo Izquierdo                                   Imagen del Ojo Derecho"));
                 documento.add(new Paragraph("                      Área afectada: "+new DecimalFormat("#.##").format(resultados[2])+"%                                              Área afectada: "+new DecimalFormat("#.##").format(resultados[3])+"%"));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph("                          Se obtuvieron los siguientes resultados para la patología CATARATA:"));
                 documento.add(new Paragraph("                      Imagen del ojo Izquierdo                                   Imagen del Ojo Derecho"));
                 documento.add(new Paragraph("                      Área afectada: "+new DecimalFormat("#.##").format(resultados[0])+"%                                              Área afectada: "+new DecimalFormat("#.##").format(resultados[1])+"%"));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph("Nombre del Responsable: "+"   Dr. "+medico.getNombre()+" "+medico.getApellidoPaterno()+" "+medico.getApellidoMaterno()));
                 documento.add(new Paragraph("Especialidad: "+medico.getEspecialidad()+ "                               Cedula Profesional: "+medico.getCedulaProfesional())) ;
                 documento.close();
             } catch (DocumentException ex) {
                 Logger.getLogger(Informe.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         public void generarReportePte(String ruta,Paciente paciente,MedicoBean medico,Prediagnostico prediagnostico){
             try {
                 FileOutputStream archivo = null;
                 try {
                     archivo = new FileOutputStream(ruta+"Reporte.pdf");
                 } catch (FileNotFoundException ex) {
                     Logger.getLogger(Informe.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 Document documento = new Document(PageSize.LETTER);
                 try {
                     PdfWriter.getInstance(documento, archivo);
                 } catch (DocumentException ex) {
                     Logger.getLogger(Informe.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 documento.open();
                 
                 
                 
                 try
                 {
                     
                     Image foto = Image.getInstance(imagenes.class.getResource("receta.jpg"));
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
                 documento.add(new Paragraph("Nombre Completo del Paciente: "+"   "+paciente.getNombre()+" "+paciente.getApellidoPaterno()+" "+paciente.getApellidoMaterno() ));
                 documento.add(new Paragraph("CURP: "+"   "+paciente.getCurp()  ));
                 documento.add(new Paragraph("Sexo: "+"   "+paciente.getSexo() ));
                 documento.add(new Paragraph("Tipo de Sangre: "+"   "+paciente.getTipoSangre()  ));
                 documento.add(new Paragraph("Fecha de Nacimiento: "+"  "+paciente.getFechaNacimiento() ));
                 documento.add(new Paragraph("Telefono: "+"   "+paciente.getTelefono()  ));
                 documento.add(new Paragraph("Dirección: "+"   "+paciente.getDireccion() ));
                 
                 documento.add(new Paragraph("Fecha de la Consulta: "+Integer.toString(c.get(Calendar.DATE))+"-"+Integer.toString(c.get(Calendar.MONTH))+"-"+Integer.toString(c.get(Calendar.YEAR))+"         Hora: "+fecha.getHours()+":"+fecha.getMinutes()+":"+fecha.getSeconds()));
                 documento.add(new Paragraph(" "));
                 
                 documento.add(new Paragraph("PRE-DIAGNOSTICO DE PATOLOGÍAS OCULARES"));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph("OBSERVACIONES DEL MEDICO"));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(prediagnostico.getObservaciones()));

                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph("                      Imagen del ojo Izquierdo                                   Imagen del Ojo Derecho"));
                 
                 try
                 {
                     
                     Image foto = Image.getInstance(prediagnostico.getOjoIzquierdo().getRuta());
                     foto.scaleToFit(200, 200);
                     // foto.setAlignment(Chunk.ALIGN_MIDDLE);
                     foto.setAbsolutePosition(100f, 50f);
                     documento.add(foto);
                     Image foto1 = Image.getInstance(prediagnostico.getOjoDerecho().getRuta());
                     foto1.scaleToFit(200, 200);
                     
                     //foto1.setAlignment(Chunk.ALIGN_MIDDLE);
                     foto1.setAbsolutePosition(350f, 50f);
                     documento.add(foto1);
                 }
                 catch ( Exception e )
                 {
                     e.printStackTrace();
                 }
                 
                 documento.newPage();
                 try
                 {
                     
                     Image foto = Image.getInstance(imagenes.class.getResource("receta.jpg"));
                     foto.scaleToFit(550, 550);
                     foto.setAlignment(Chunk.ALIGN_MIDDLE);
                     documento.add(foto);
                 }
                 catch ( Exception e )
                 {
                     e.printStackTrace();
                 }
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph("                    Se obtuvieron los siguientes resultados para la patología PTERIGION:"));
                 
                 
                 try
                 {
                     
                     Image foto = Image.getInstance(prediagnostico.getImgOIP().getRuta());
                     foto.scaleToFit(200, 200);
                     foto.setAbsolutePosition(100f, 380f);
                     documento.add(foto);
                     
                     Image foto1 = Image.getInstance(prediagnostico.getImgODP().getRuta());
                     foto1.scaleToFit(200, 200);
                     foto1.setAbsolutePosition(350f, 380f);
                     documento.add(foto1);
                 }
                 catch ( Exception e )
                 {
                     e.printStackTrace();
                 }
                 double[] resultados=prediagnostico.getResultado();
                 documento.add(new Paragraph("                      Imagen del ojo Izquierdo                                   Imagen del Ojo Derecho"));
                 documento.add(new Paragraph("                      Área afectada: "+new DecimalFormat("#.##").format(resultados[0])+"%                                              Área afectada: "+new DecimalFormat("#.##").format(resultados[1])+"%"));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 /*documento.add(new Paragraph("                          Se obtuvieron los siguientes resultados para la patología CATARATA:"));
                 documento.add(new Paragraph("                      Imagen del ojo Izquierdo                                   Imagen del Ojo Derecho"));
                 documento.add(new Paragraph("                      Área afectada: "+new DecimalFormat("#.##").format(resultados[0])+"%                                              Área afectada: "+new DecimalFormat("#.##").format(resultados[1])+"%"));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));
                 documento.add(new Paragraph(" "));*/
                 documento.add(new Paragraph("Nombre del Responsable: "+"   Dr. "+medico.getNombre()+" "+medico.getApellidoPaterno()+" "+medico.getApellidoMaterno()));
                 documento.add(new Paragraph("Especialidad: "+medico.getEspecialidad()+ "                               Cedula Profesional: "+medico.getCedulaProfesional())) ;
                 documento.close();
             } catch (DocumentException ex) {
                 Logger.getLogger(Informe.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
    /*public static void main(String[] a3d) throws FileNotFoundException, DocumentException//, DocumentException
	{
		FileOutputStream archivo = new FileOutputStream("C:\\Users\\Sergio\\Desktop\\Receta.pdf");
		Document documento = new Document();
		PdfWriter.getInstance(documento, archivo);
		documento.open();
		
                  
                 
                try
                {
                   
                  Image foto = Image.getInstance("C:\\Users\\Sergio\\Desktop\\Receta.pdf");
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
	}*/
}
