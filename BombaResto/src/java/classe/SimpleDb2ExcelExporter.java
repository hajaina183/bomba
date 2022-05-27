/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;

import bdd.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Timestamp;

/**
 *
 * @author Rado
 */
public class SimpleDb2ExcelExporter {
    
    public void export() {
        Connection con = null;
 
        String excelFilePath = "D:\\fianarana\\s6\\Mme Baovola\\bomba\\BombaResto\\liste.xlsx";
 
        try{
            System.out.println("atiiiiiiiiiiiiiiiii");
            con = Connexion.getConnexion();
            String sql = "SELECT * FROM Seuille";
            
            
            java.sql.Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(sql);
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Reviews");
            writeHeaderLine(sheet);
            writeDataLines(result, workbook, sheet);
            System.out.println("atoooooooooooooooooooooo");
            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            workbook.close();
 
            statement.close();
 
        } catch (Exception e) {
            System.out.println("Datababse error:");
            e.printStackTrace();
        }
    }
    
    private void writeHeaderLine(XSSFSheet sheet) {
 
        Row headerRow = sheet.createRow(0);
 
        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("Numéro");
 
        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("Nom ingredient");

    }
    private void writeDataLines(ResultSet result, XSSFWorkbook workbook,
            XSSFSheet sheet) throws Exception {
        int rowCount = 1;
 
        while (result.next()) {
            String courseName = result.getString("id_ingredient");
            String studentName = result.getString("nom");
            Row row = sheet.createRow(rowCount++);
 
            int columnCount = 0;
            Cell cell = row.createCell(columnCount++);
            cell.setCellValue(courseName);
 
            cell = row.createCell(columnCount++);
            cell.setCellValue(studentName);

 
        }
    }
}
