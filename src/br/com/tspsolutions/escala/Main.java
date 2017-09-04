package br.com.tspsolutions.escala;

/**
 * Classe principal
 * 
 * @author José San Pedro
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double ticks;
        EscalaLegal numScale;
        //EscalaLegal numScale = new EscalaLegal(1.975, 2.66, ticks);
        ticks = 4;
        //numScale = new EscalaLegal(100000, 100100, ticks);
        numScale = new EscalaLegal(1.975, 2.66, ticks);
        printScale(numScale, ticks);
        System.out.println();
        
        ticks = 5;
        //numScale = new EscalaLegal(100000, 100100, ticks);
        numScale = new EscalaLegal(1.975, 2.66, ticks);
        printScale(numScale, ticks);
        System.out.println();
        
        ticks = 6;
        //numScale = new EscalaLegal(100000, 100100, ticks);
        numScale = new EscalaLegal(1.975, 2.66, ticks);
        printScale(numScale, ticks);
        System.out.println();
        
        ticks = 7;
        //numScale = new EscalaLegal(100000, 100100, ticks);
        numScale = new EscalaLegal(1.975, 2.66, ticks);
        printScale(numScale, ticks);
        System.out.println();
        
        ticks = 9;
        //numScale = new EscalaLegal(100000, 100100, ticks);
        numScale = new EscalaLegal(1.975, 2.66, ticks);
        printScale(numScale, ticks);
        System.out.println();        
    }
    
    public static void printScale(EscalaLegal numScale, double ticks) {
        double niceMin = numScale.getNiceMin();
        double niceMax = numScale.getNiceMax();
        double tick = numScale.getTickSpacing();
        
        System.out.println(niceMin);
        double value = niceMin;
        
        while (value < niceMax) {
            value += tick;
            System.out.println(numScale.roundUp(value));
        }
    }
}