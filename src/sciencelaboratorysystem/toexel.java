/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sciencelaboratorysystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author Sadiqeen
 */
public class toexel {
    
    public void toExcel(JTable equipment, File file){
    try{
        TableModel model = equipment.getModel();
        FileWriter excel = new FileWriter(file);
        for(int i = 0; i < model.getColumnCount(); i++){
            excel.write(model.getColumnName(i) + "\t");
        }

        excel.write("\n");

        for(int i=0; i< model.getRowCount(); i++) {
            for(int j=0; j < model.getColumnCount(); j++) {
                if (model.getValueAt(i, j) == null){   
                    excel.write("0");
                } else {
                    excel.write(model.getValueAt(i,j).toString()+"\t");
                }
            }
            excel.write("\n");
        }

        excel.close();

    }catch(IOException e){ System.out.println(e); }
}
}
