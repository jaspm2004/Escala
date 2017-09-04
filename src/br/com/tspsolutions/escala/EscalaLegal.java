package br.com.tspsolutions.escala;

/**
 * Classe para determinar os valores da escala
 * 
 * @author José San Pedro
 */
public class EscalaLegal {

    private final double minPoint;
    private final double maxPoint;
    private final double maxTicks;
    private double tickSpacing;
    private double range;
    private double niceMin;
    private double niceMax;

    /**
     * Instantiates a new instance of the NiceScale class.
     *
     * @param min       mínimo valor da escala
     * @param max       máximo valor da escala
     * @param maxTicks  máximo de divisões da escala
     */
    public EscalaLegal(double min, double max, double maxTicks) {
        this.minPoint = min;
        this.maxPoint = max;
        this.maxTicks = maxTicks;
        
        calculate();
    }

    /**
     * Calcula o incremento mínino, o valor mínimo e máximo da escala utilizando números "redondos"
     */
    private void calculate() {
        this.range = niceNum(maxPoint - minPoint, false);
        this.tickSpacing = niceNum(range / (maxTicks - 1), true);
        //this.tickSpacing = niceNum(range / (maxTicks), true);
        this.niceMin = roundUp(Math.floor(minPoint / tickSpacing) * tickSpacing);
        this.niceMax = roundUp((Math.ceil(maxPoint / tickSpacing) * tickSpacing));
    }
    
    public double roundUp(double number) {
        return Math.round(number * 100.0) / 100.0;
    }

    /**
     * Retorna o número redondo mais próximo do range
     *
     * Se <code>round = true</code>, o retorno é arredodando
     * Se <code>round = false</code>, retorna o teto
     *
     * @param range o range de valores
     * @param round indica se precisa ou não arredondar o resultado
     *
     * @return
     */
    private double niceNum(double range, boolean round) {
        // exponente do range
        double exponent;
        // parte fracionára do range
        double fraction;
        // fração arredondada
        double niceFraction;
        
        exponent = Math.floor(Math.log10(range));
        fraction = range / Math.pow(10, exponent);

        if (round) {
            if (fraction < 1.5) {
                niceFraction = 1;
            } else if (fraction < 3) {
                niceFraction = 2;
            } else if (fraction < 7) {
                niceFraction = 5;
            } else {
                niceFraction = 10;
            }
        } else {
            if (fraction <= 1) {
                niceFraction = 1;
            } else if (fraction <= 2) {
                niceFraction = 2;
            } else if (fraction <= 5) {
                niceFraction = 5;
            } else {
                niceFraction = 10;
            }
        }

        return niceFraction * Math.pow(10, exponent);
    }

    /**
     * Retorna o valor "redondo" do incremento mínino da escala
     *
     * @return
     */
    public double getTickSpacing() {
        return tickSpacing;
    }

    /**
     * Retorna o valor "redondo" mínimo da escala
     *
     * @return 
     */
    public double getNiceMin() {
        return niceMin;
    }

    /**
     * Retorna o valor "redondo" máximo da escala
     *
     * @return 
     */
    public double getNiceMax() {
        return niceMax;
    }
}