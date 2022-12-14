package Phili.MainEngine;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class Model
{

    private final List<User> userList = new ArrayList<>();
    private final List<Product> productList = new ArrayList<>();
    private final List<Product> precommandsList = new ArrayList<>();
    private final List<Product> commandsList = new ArrayList<>();

    public Model()
    {
        ReadUsers();
        ReadDB();
        ReadPrecommands();
        ReadCommands();
    }

    public List<User> getUserList()
    {
        return userList;
    }

    public List<Product> getProductList()
    {
        return productList;
    }

    public List<Product> getPrecommandsList()
    {
        return precommandsList;
    }

    public List<Product> getCommandsList()
    {
        return commandsList;
    }

    public void ReadUsers()
    {
        try
        {
            Scanner readFromFile = new Scanner(new File("users.txt"));

            while (readFromFile.hasNext())
            {
                User dummy = new User();
                dummy.setUsername(readFromFile.next());
                dummy.setPassword(readFromFile.next());
                dummy.setType(readFromFile.next());
                userList.add(dummy);
            }
            
            readFromFile.close();
        }
        catch (FileNotFoundException ex)
        {
        }
    }

    public void ReadDB()
    {
        File folder = new File("db");
        File[] listOfCategories = folder.listFiles();

        ReadProducts(listOfCategories);
        
    }

    
    
    //Scanner Method
    public void ReadProducts(File[] listOfCategories)
    {
        try
        {
            for (File listOfCategorie : listOfCategories)
            {
                File folder = new File("db\\"+ listOfCategorie.getName());
                File[] listOfProductsInFolder = folder.listFiles();
                for (File listOfProductsInFolder1 : listOfProductsInFolder)
                {
                    Scanner readFromFile = new Scanner(new File("db\\" + listOfCategorie.getName() + "\\" + listOfProductsInFolder1.getName()));
                    while (readFromFile.hasNext())
                    {
                        Product dummy = new Product();
                        dummy.setName(readFromFile.next());
                        dummy.setCategory(readFromFile.next());
                        dummy.setPrice(Double.parseDouble(readFromFile.next()));
                        dummy.setQuantity(readFromFile.nextInt());
                        dummy.setDescription(readFromFile.next());
                        productList.add(dummy);
                    }
                    readFromFile.close();
                }
            }
        }
        catch (FileNotFoundException ex)
        {
        }
    }

    
    
    public void PlacePreCommand(Product product, int quantity)
    {
        try
        {
            File myFile = new File("pre\\precommands.txt");
            FileWriter fileWriter = new FileWriter(myFile, true);
            BufferedWriter buffer = new BufferedWriter(fileWriter);
            try (PrintWriter printWriter = new PrintWriter(buffer))
            {
                printWriter.print(product.getName() + "\r\n" + product.getCategory() + "\r\n" + product.getPrice() + "\r\n" + quantity + "\r\n" + product.getDescription()+"\r\n");
                printWriter.close();
            }
            buffer.close();
            fileWriter.close();
        }
        catch (IOException ex)
        {

        }

    }

    
    
    
    public void ReadPrecommands()
    {
        try
        {
            Scanner readFromFile = new Scanner(new File("pre\\precommands.txt"));
            while (readFromFile.hasNext())
            {
                Product dummy = new Product();
                dummy.setName(readFromFile.next());
                dummy.setCategory(readFromFile.next());
                dummy.setPrice(Double.parseDouble(readFromFile.next()));
                dummy.setQuantity(readFromFile.nextInt());
                dummy.setDescription(readFromFile.next());
                precommandsList.add(dummy);
            }
            readFromFile.close();
        }
        catch (FileNotFoundException ex)
        {
        }
    }

    public void PlaceCommand(Product product)
    {
        try
        {
            File myFile = new File("pre\\commands.txt");
            FileWriter fileWriter = new FileWriter(myFile, true);
            BufferedWriter buffer = new BufferedWriter(fileWriter);
            try (PrintWriter printWriter = new PrintWriter(buffer))
            {
                printWriter.print(product.getName() + " " + product.getCategory() + " " + product.getPrice() + " " + product.getQuantity() + " " + product.getDescription()+"\r\n");
                printWriter.close();
            }
            buffer.close();
            fileWriter.close();

        }
        catch (IOException ex)
        {

        }

    }
    
    
    
    

    public void SaveListOfProducts(List<Product> listOfProducts)
    {
        try
        {
            DeleteDB();
            for (Product product : listOfProducts)
            {
                FileWriter writeToFile = new FileWriter("db\\" + product.getCategory() + "\\" + product.getName() + ".txt");
                BufferedWriter buffer = new BufferedWriter(writeToFile);
                try(PrintWriter printWriter = new PrintWriter(buffer))
                {
                printWriter.print(product.getName()+"\r\n");
                printWriter.print(product.getCategory()+"\r\n");
                printWriter.print(product.getPrice()+"\r\n");
                printWriter.print(product.getQuantity()+"\r\n");
                printWriter.print(product.getDescription()+"\r\n");
                printWriter.close();
                }
                buffer.close();
                writeToFile.close();
            }
        }
        catch (IOException e)
        {
        }
    }

    
    
    
    
    public void SaveListOfPrecommands(List<Product> listOfPrecommands)
    {
        try
        {
            try (
                    FileWriter writeToFile = new FileWriter("pre\\precommands.txt")
                )
            {
                for (Product product : listOfPrecommands)
                {
                    writeToFile.write(product.getName() + " " + product.getCategory() + " " + product.getPrice() + " " + product.getQuantity() + " " + product.getDescription()+"\r\n");
                }
            }
        }
        catch (IOException e)
        {
        }
    }

    public void ReadCommands()
    {
        try
        {
            Scanner readFromFile = new Scanner(new File("pre\\commands.txt"));
            while (readFromFile.hasNext())
            {
                Product dummy = new Product();
                dummy.setName(readFromFile.next());
                dummy.setCategory(readFromFile.next());
                dummy.setPrice(Double.parseDouble(readFromFile.next()));
                dummy.setQuantity(readFromFile.nextInt());
                dummy.setDescription(readFromFile.next());
                commandsList.add(dummy);
            }
        }
        catch (FileNotFoundException ex)
        {
        }
    }
    
    public void DeleteDB()
    {
        boolean check;
        try
        {
        File f=new File("db");
        if(f.isDirectory())
        {
            for(File c:f.listFiles())
                if(c.isDirectory())
                {
                    for(File d:c.listFiles())
                    {
                        d.delete();
                    }
                    
                }
                else
                    c.delete();
        }
        }
        catch (Exception e)
        {
        }   
    }
}
