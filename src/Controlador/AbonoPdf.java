/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import Modelo.DatosTransaccion;
import Vista.VAbono;
import Vista.VTransaccion;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.cj.protocol.Resultset;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Angelica Guerrero
 */
public class AbonoPdf {

    private String nombreCliente;
    private String telefonoCliente;
    private String fechaActual = "";
    private String nombreArchivo = "";
    private int idDatosAbono;
    private int idDatosTransaccion;
    
    //obtener datos del cliente
    public void DatosCliente(int idCliente) {
        Connection cn = Conexion.Conectar();
        String sql = "SELECT * FROM cliente WHERE id_cliente='" + idCliente + "'";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                nombreCliente = rs.getString("nombre_cliente") + " " + rs.getString("apellidos_cliente");
                
            }
            String sqlAbono = "SELECT * FROM abonos WHERE id_cliente=" + idCliente + " ORDER BY id_abono DESC LIMIT 1";
            ResultSet rsAbono = st.executeQuery(sqlAbono);
            if (rsAbono.next()) {
                idDatosAbono = rsAbono.getInt("id_abono");
                idDatosTransaccion=rsAbono.getInt("id_datosTransaccion");
             }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener datos del cliente");
        }
    }

    public void generarAbonoPDF() {
        try {
            //cargar la fecha
            Date date = new Date();
            fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);
            //cambiar formato de la fecha de / a _
            String fechaNueva = "";
            for (int i = 0; i < fechaActual.length(); i++) {
                if (fechaActual.charAt(i) == '/') {
                    fechaNueva = fechaActual.replace("/", "_");
                }
            }
            nombreArchivo = "Abono_" + nombreCliente + "_" + fechaNueva + ".pdf";
            
            //crear pdf
            FileOutputStream archivo;
            File file = new File("src/pdfAbono/" + nombreArchivo);
            archivo = new FileOutputStream(file);
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            Image img = Image.getInstance("src/imagenes/ventass.jpeg");
            img.scaleToFit(155, 75); // Ajustar tamaño de la imagen (200x200)
            
            
            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD, BaseColor.BLUE);
            fecha.add(Chunk.NEWLINE);//agregar nueva linea
            fecha.add("Recibo: " +idDatosAbono +"\nFecha: " + fechaActual + "\n\n");
            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);//quitar borde de la tabla
            
            PdfPCell cell = new PdfPCell();
            cell.addElement(img);
            cell.setBorder(0);
            Encabezado.addCell(cell);
           
            //tamaño de las celdas
            float[] ColumnaEncabezada = new float[]{20f, 30f, 70f, 40f};
            Encabezado.setWidths(ColumnaEncabezada);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            //agregar celdas
           
            String nombre = "Muebleria la victoria";
            String direccion = "Calle Morelos No.102-c Col.Centro C.P 42000 Pachuca,Hgo";
            String telefono = "771 715 4601";
            Encabezado.addCell("");//celda vacia
            Encabezado.addCell("Nombre: " + nombre + "\nDireccion: " + direccion + "\nTelefono: " + telefono);
            Encabezado.addCell(fecha);
            doc.add(Encabezado);

            
            Font letra = new Font(Font.FontFamily.HELVETICA, 16, Font.NORMAL, BaseColor.BLACK);
            
            //nombre cliente
            Paragraph cte=new Paragraph();
            cte.add(Chunk.NEWLINE);
            cte.setFont(letra);
            cte.add("Recibi de: "+nombreCliente);
            cte.setAlignment(Element.ALIGN_CENTER);
            doc.add(cte);
            //abono
            Paragraph abono=new Paragraph();
            abono.add(Chunk.NEWLINE);
            abono.setFont(letra);
            abono.add("La cantidad de: $"+VAbono.text_abono.getText());
            abono.setAlignment(Element.ALIGN_CENTER);
            doc.add(abono);
            //Nota
            Paragraph nota=new Paragraph();
            nota.add(Chunk.NEWLINE);
            nota.setFont(letra);
            nota.add("No. DE NOTA: "+idDatosTransaccion);
            nota.setAlignment(Element.ALIGN_CENTER);
            doc.add(nota);
            //FIRMA
            Paragraph firma=new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.setFont(letra);
            firma.add("Recibío\n\n");
            firma.add("_________________");
            firma.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);

            //cerrar el archivo y documento
            doc.close();
            archivo.close();
            //automaticamente se abra el navegador con el archivo
            Desktop.getDesktop().open(file);
        } catch (DocumentException | IOException e) {
            System.out.println("Error en: " + e);
        }
    }
}
