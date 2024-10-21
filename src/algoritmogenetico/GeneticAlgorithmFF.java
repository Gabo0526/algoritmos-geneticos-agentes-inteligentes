package algoritmogenetico;

import org.jgap.*;
import org.jgap.impl.IntegerGene;
import utilidades.ShowChromosome;
import utilidades.funciones.MathFunction;

public class GeneticAlgorithmFF extends FitnessFunction {
    private final MathFunction mathFunction;

    public GeneticAlgorithmFF(MathFunction mathFunction) {
        this.mathFunction = mathFunction;
    }

    @Override
    protected double evaluate(IChromosome iChromosome) {
        return mathFunction.evaluate(ShowChromosome.getChromosomeContent(iChromosome));
    }

    public static Genotype initializeGeneticAlgorithm(Configuration conf, int populationSize) throws Exception {
        Gene[] sampleGenes = new Gene[24];

        sampleGenes[0] = new IntegerGene(conf, 0, 1);

        sampleGenes[1] = new IntegerGene(conf, 0, 1);
        sampleGenes[2] = new IntegerGene(conf, 0, 1);
        sampleGenes[3] = new IntegerGene(conf, 0, 1);
        sampleGenes[4] = new IntegerGene(conf, 0, 1);
        sampleGenes[5] = new IntegerGene(conf, 0, 1);
        sampleGenes[6] = new IntegerGene(conf, 0, 1);
        sampleGenes[7] = new IntegerGene(conf, 0, 1);
        sampleGenes[8] = new IntegerGene(conf, 0, 1);
        sampleGenes[9] = new IntegerGene(conf, 0, 1);
        sampleGenes[10] = new IntegerGene(conf, 0, 1);
        sampleGenes[11] = new IntegerGene(conf, 0, 1);

        sampleGenes[12] = new IntegerGene(conf, 0, 1);

        sampleGenes[13] = new IntegerGene(conf, 0, 1);
        sampleGenes[14] = new IntegerGene(conf, 0, 1);
        sampleGenes[15] = new IntegerGene(conf, 0, 1);
        sampleGenes[16] = new IntegerGene(conf, 0, 1);
        sampleGenes[17] = new IntegerGene(conf, 0, 1);
        sampleGenes[18] = new IntegerGene(conf, 0, 1);
        sampleGenes[19] = new IntegerGene(conf, 0, 1);
        sampleGenes[20] = new IntegerGene(conf, 0, 1);
        sampleGenes[21] = new IntegerGene(conf, 0, 1);
        sampleGenes[22] = new IntegerGene(conf, 0, 1);
        sampleGenes[23] = new IntegerGene(conf, 0, 1);

        Chromosome sampleChromosome = new Chromosome(conf, sampleGenes);
        conf.setSampleChromosome(sampleChromosome);
        conf.setPopulationSize(populationSize);

        return Genotype.randomInitialGenotype(conf);
    }

    public static void evolveWithParameters(Genotype population, int numGenerations) {
        for (int i = 0; i < numGenerations; i++) {
            population.evolve();
        }
    }

}
