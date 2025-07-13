package Controlador;

import Conexion.Conexion;
import Vista.VLiquidacion;
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
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Angelica Guerrero
 */
public class LiquidacionPdf {

    private String nombreCliente;
    private String telefonoCliente;
    private String direccionCliente;
    private String fechaActual = "";
    private String tipoTransaccion;
    private String nombreArchivo = "";
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
            telefonoCliente = rs.getString("telefono_cliente");
            direccionCliente = rs.getString("colonia_cliente") + " " + rs.getString("calle_cliente") + " #" + rs.getString("numero_ext_cliente") + " C.P " + rs.getString("codigo_postal_cliente");
        }
        String sqlTransaccion = "SELECT * FROM datos_transaccion WHERE id_cliente=" + idCliente + " ORDER BY id_datosTransaccion DESC LIMIT 1";
            ResultSet rsTransaccion = st.executeQuery(sqlTransaccion);
            if (rsTransaccion.next()) {
                idDatosTransaccion = rsTransaccion.getInt("id_datosTransaccion");
                tipoTransaccion=rsTransaccion.getString("tipo_transaccion");
            }
    
        cn.close();
    } catch (SQLException e) {
        System.out.println("Error al obtener datos del cliente");
    }
}
   public List<String> DatosArticulos(int idCliente) {
    List<String> articulosComprados = new ArrayList<>();
    Connection cn = Conexion.Conectar();
    String sql = "SELECT CONCAT(a.nombre_articulo,'-',a.descripcion_articulo) AS articulos_comprados, tr.cantidad, a.precio_articulo, tr.importe FROM datos_transaccion dt JOIN transacciones tr ON dt.id_datosTransaccion = tr.id_datosTransaccion JOIN articulos a ON tr.id_articulo = a.id_articulo WHERE dt.id_cliente=" + idCliente + " ORDER BY dt.id_datosTransaccion DESC";
    try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            String articulo = rs.getString("articulos_comprados");
            int cantidad = rs.getInt("cantidad");
            double precio = rs.getDouble("precio_articulo");
            double importe = rs.getDouble("importe");
            String datosArticulo = String.format("%s -  %d -  %.2f -  %.2f",
                    articulo, cantidad, precio, importe);
            articulosComprados.add(datosArticulo);
        }
        // Cerrar ResultSet, Statement y Connection
        rs.close();
        st.close();
        cn.close();
    } catch (SQLException e) {
        System.out.println("Error al obtener datos del artículo: " + e.getMessage());
    }
    return articulosComprados;
}

    //metodo para generar factura
    public void generarLiquidacionPDF(List<String> articleData) {
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
            nombreArchivo = "Liquidacion_" + nombreCliente + "_" + fechaNueva + ".pdf";
            
            //crear pdf
            FileOutputStream archivo;
            File file = new File("src/pdfLiquidacion/" + nombreArchivo);
            archivo = new FileOutputStream(file);
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            
            Image img = Image.getInstance("src/imagenes/ventass.jpeg");
            img.scaleToFit(155, 75); // Ajustar tamaño de la imagen (200x200)
            
            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD, BaseColor.BLUE);
            fecha.add(Chunk.NEWLINE);//agregar nueva linea
            fecha.add("Recibo: " +idDatosTransaccion +"\nFecha: " + fechaActual + "\n"+tipoTransaccion+"\n\n");
            //crear tabla
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

            //cuerpo
            Paragraph cliente = new Paragraph();
            cliente.add(Chunk.NEWLINE);
            cliente.add("Datos del cliente" + "\n\n");
            doc.add(cliente);
            //datos del cliente
            PdfPTable tablaCliente = new PdfPTable(3);
            tablaCliente.setWidthPercentage(100);
            tablaCliente.getDefaultCell().setBorder(0);
            float[] ColumnaCliente = new float[]{45f, 65f, 30f};
            tablaCliente.setWidths(ColumnaCliente);
            tablaCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cliente1 = new PdfPCell(new Phrase("Cliente: ", negrita));
            PdfPCell cliente2 = new PdfPCell(new Phrase("Direccion: ", negrita));
            PdfPCell cliente3 = new PdfPCell(new Phrase("Telefono: ", negrita));
            //quitar bordes
            cliente1.setBorder(0);
            cliente2.setBorder(0);
            cliente3.setBorder(0);
            //6 celdas nombre y abajo nombre
            tablaCliente.addCell(cliente1);
            tablaCliente.addCell(cliente2);
            tablaCliente.addCell(cliente3);
            tablaCliente.addCell(nombreCliente);
            tablaCliente.addCell(direccionCliente);
            tablaCliente.addCell(telefonoCliente);
            //agregar al documento
            doc.add(tablaCliente);
            //espacio en blanco
            Paragraph espacio = new Paragraph();
            espacio.add(Chunk.NEWLINE);
            espacio.add("");
            espacio.setAlignment(Element.ALIGN_CENTER);
            doc.add(espacio);

            //agregar los productos
            PdfPTable tablaProductos = new PdfPTable(4);
            tablaProductos.setWidthPercentage(100);
            tablaProductos.getDefaultCell().setBorder(0);
            //tamaño de celda
            float[] ColumnaProducto = new float[]{15f, 50f, 15f, 20f};
            tablaProductos.setWidths(ColumnaProducto);
            tablaProductos.setHorizontalAlignment(Element.ALIGN_LEFT);
            //agregar celda
            PdfPCell producto1 = new PdfPCell(new Phrase("Cantidad", negrita));
            PdfPCell producto2 = new PdfPCell(new Phrase("Descripción", negrita));
            PdfPCell producto3 = new PdfPCell(new Phrase("Precio unitario", negrita));
            PdfPCell producto4 = new PdfPCell(new Phrase("Importe", negrita));
            //quitar bordes
            producto1.setBorder(0);
            producto2.setBorder(0);
            producto3.setBorder(0);
            producto4.setBorder(0);
            //agregar el color al encabezado de producto
            producto1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto4.setBackgroundColor(BaseColor.LIGHT_GRAY);
            //agregar celda a la tabla
            tablaProductos.addCell(producto1);
            tablaProductos.addCell(producto2);
            tablaProductos.addCell(producto3);
            tablaProductos.addCell(producto4);
            //debe estar publico y estatico el campo de tabla y de importe
             for (String data : articleData) {
                // Split los datos del artículo
                String[] parts = data.split(" - ");
                // Añadir a la tabla de productos
                tablaProductos.addCell(parts[1]); // Cantidad
                tablaProductos.addCell(parts[0]); // Descripción
                tablaProductos.addCell(parts[3]); // Precio unitario
                tablaProductos.addCell(parts[2]); // Importe
            }
            //agregar al documente
            doc.add(tablaProductos);
            //total a pagar
            Paragraph info=new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("Importe total: "+VLiquidacion.text_importeTotal.getText());
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);
            //a cuenta
            Paragraph cuenta=new Paragraph();
            cuenta.add(Chunk.NEWLINE);
            cuenta.add("A cuenta: "+VLiquidacion.text_cuenta.getText());
            cuenta.setAlignment(Element.ALIGN_RIGHT);
            doc.add(cuenta);
            //por cobrar
            Paragraph cobrar=new Paragraph();
            cobrar.add(Chunk.NEWLINE);
            cobrar.add("Por cobrar: "+VLiquidacion.text_cobrar.getText());
            cobrar.setAlignment(Element.ALIGN_RIGHT);
            doc.add(cobrar);
            
            Paragraph abono=new Paragraph();
            abono.add(Chunk.NEWLINE);
            abono.add(VLiquidacion.text_abonos.getText());
            abono.setAlignment(Element.ALIGN_RIGHT);
            doc.add(abono);
            
            Paragraph liquidacion=new Paragraph();
            liquidacion.add(Chunk.NEWLINE);
            liquidacion.add("\nLiquida con: $"+VLiquidacion.text_liquidacion.getText()+" el "+fechaActual);
            liquidacion.setAlignment(Element.ALIGN_CENTER);
            doc.add(liquidacion);
            
            //FIRMA
            Paragraph firma=new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.add("\nFirma\n\n");
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