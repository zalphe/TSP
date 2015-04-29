/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

import java.io.File;
import java.io.IOException;
import jxl.*;
import jxl.read.biff.BiffException;

/**
 *
 * @author zalphe
 */
public class TSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, BiffException {
        // TODO code application logic here
        // Create and add our cities
        City[] kota = new City[1000];       
        Workbook w;

        w = Workbook.getWorkbook(new File("C:/Users/zalphe/Documents/TSP.xls"));        
        Sheet sheet = w.getSheet(0);        

        for (int i = 0; i < sheet.getRows(); i++) {
            Cell cell0 = sheet.getCell(0, i);
            Cell cell1 = sheet.getCell(1, i);
            Cell cell2 = sheet.getCell(2, i); 
            double a = Double.parseDouble(cell1.getContents());
            double b = Double.parseDouble(cell2.getContents());            
            kota[i] = new City();
            kota[i].setId(cell0.getContents());
            kota[i].setX(a);            
            kota[i].setY(b);
            TourManager.addCity(kota[i]);
        }
                
        // Initialize population
        Population pop = new Population(50, true);
        System.out.println("Jarak sebelum GA : " + pop.getFittest().getDistance());

        // Evolve population for 100 generations
        pop = GA.evolvePopulation(pop);
        for (int i = 0; i < 100; i++) {
            pop = GA.evolvePopulation(pop);
        }

        // Print final results        
        System.out.println("Jarak setelah GA : " + pop.getFittest().getDistance());
        System.out.println("Solusi jalur : ");
        System.out.println(pop.getFittest());
    }

}