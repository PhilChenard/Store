package Phili.MainEngine;

import java.awt.Color;
import java.util.List;
import java.util.Vector;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;


/**
 * @author phili
 *
 */





public class Logic
{
        
    public void ClearCheckQuery(javax.swing.JTable table, javax.swing.JButton button1, javax.swing.JButton button2, List<Product> list)
    {
        table.clearSelection();
        
        CheckTableSelectionValidity(table, button1, button2);
        
        Query(table, list);
    }
    
    public void DeleteAllRows(javax.swing.JTable table)
    {
        DefaultTableModel defaultModel = (DefaultTableModel) table.getModel();
        
        defaultModel.setRowCount(1);
    }
    
    public void Query(javax.swing.JTable table, List<Product> list)
    {
        int tableType = table.getColumnCount();
        
        DeleteAllRows(table);
        
        //loop
        for(int i = 0; i < table.getRowCount(); i++)
        {
            for(int j = 0; j < table.getColumnCount(); j++)
            {
                table.setValueAt(null, i, j);
            }
        }
        
        
        
        
  
        if(tableType == 5)
        {
            for(int i = 0; i < list.size(); i++)
            {
                char [] name = RemoveUnderline(list.get(i).getName());
                char [] desc = RemoveUnderline(list.get(i).getDescription());
                char [] category = RemoveUnderline(list.get(i).getCategory());
    
                table.setValueAt(String.copyValueOf(name), i, 0);
                table.setValueAt(String.copyValueOf(desc), i, 1);
                table.setValueAt(list.get(i).getPrice(), i, 2);
                table.setValueAt(String.copyValueOf(category), i, 3);
                table.setValueAt(list.get(i).getQuantity(), i, 4);
                
                if(i != list.size() - 1)
                    DynamicallyAddNewRow(table);
            }
        }
        else // Orders Table
        {
            for(int i = 0; i < list.size(); i++)
            {
                char [] name = RemoveUnderline(list.get(i).getName());
                
                table.setValueAt(String.copyValueOf(name), i, 0);
                table.setValueAt(list.get(i).getPrice(), i, 1);
                table.setValueAt(list.get(i).getQuantity(), i, 2);
                
                if(i != list.size() - 1)
                    DynamicallyAddNewRow(table);
            }
        }
    }
    
    
    
    //
    public void DynamicallyAddNewRow(javax.swing.JTable table)
    {
        DefaultTableModel defaultModel = (DefaultTableModel) table.getModel();
        
        Vector newRow = new Vector();
        
        for(int i = 0; i < table.getColumnCount(); i++)
        {
            newRow.add(null);
        }
        
        defaultModel.addRow(newRow);
    }
    
    
    public void CheckTableSelectionValidity(javax.swing.JTable table, javax.swing.JButton button1, javax.swing.JButton button2)
    {
        if(table.getSelectedRow()!=-1 && table.getValueAt(table.getSelectedRow(), 1)!=null && table.getSelectedRowCount()==1)
        {
            button1.setEnabled(true);
            button2.setEnabled(true);
        }
        else
        {
            button1.setEnabled(false);
            button2.setEnabled(false);
        }
    }
    
    
    
    public Product GetSelectedTableItem(javax.swing.JTable table)
    {
        int index = table.getSelectedRow();
        
        Product product = new Product();
        
        product.setName(String.copyValueOf(AddUnderline(table.getValueAt(index, 0).toString())));
        product.setDescription(String.copyValueOf(AddUnderline(table.getValueAt(index, 1).toString())));
        product.setPrice(Double.parseDouble(table.getValueAt(index, 2).toString()));
        product.setCategory(String.copyValueOf(AddUnderline(table.getValueAt(index, 3).toString())));
        product.setQuantity(Integer.parseInt(table.getValueAt(index, 4).toString()));
        
        return product;
    }
    
    
    
    public void InitializeSpinner(javax.swing.JSpinner spinner)
    {
        ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField().setEditable(false);
        ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField().setBackground(Color.white);
    }
    
    
    
    public Product GetFrameContent (javax.swing.JTextField txtName,
                                    javax.swing.JTextArea txtDesc,
                                    javax.swing.JTextField txtPrice,
                                    javax.swing.JComboBox comboBoxCategory,
                                    javax.swing.JSpinner spinnerQuantity)
    {
        Product product = new Product();
        
        product.setName(String.copyValueOf(AddUnderline(txtName.getText())));
        product.setDescription(String.copyValueOf(AddUnderline(txtDesc.getText())));
        product.setPrice(Double.parseDouble(txtPrice.getText()));
        product.setCategory(String.copyValueOf(AddUnderline(comboBoxCategory.getSelectedItem().toString())));
        product.setQuantity(Integer.parseInt(spinnerQuantity.getValue().toString()));
        
        return product;
    }
    
    
    
    public char [] RemoveUnderline(String textString)
    {
        char[] text = textString.toCharArray();
                
            for(int j = 0; j < text.length; j++)
            {
                if(text[j] == '_')
                {
                    text[j] = ' ';
                }
            }
        return text;
    }
    
    
    
    public char [] AddUnderline(String textString)
    {
        char[] text = textString.toCharArray();
                
            for(int j = 0; j < text.length; j++)
            {
                if(text[j] == ' ')
                {
                    text[j] = '_';
                }
            }
        return text;
    }

}
