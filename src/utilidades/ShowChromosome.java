package utilidades;

import org.jgap.IChromosome;

public class ShowChromosome {
    public static double[] getChromosomeContent(IChromosome iChromosome) {
        int genesNum = iChromosome.size();
        double[] variables = new double[2];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < genesNum / 2; i++) {
            if (i != 0) {
                sb.append(((Integer) iChromosome.getGene(i).getAllele()).toString());
            }
        }

        variables[0] = Integer.parseInt(sb.toString(), 2);

        sb = new StringBuilder();

        for (int i = 12; i < genesNum; i++) {
            if (i != 12) {
                sb.append(((Integer) iChromosome.getGene(i).getAllele()).toString());
            }
        }

        variables[1] = Integer.parseInt(sb.toString(), 2);

        if (iChromosome.getGene(0).getAllele().equals(0)) {
            variables[0] = -variables[0];
        }

        if (iChromosome.getGene(12).getAllele().equals(0)) {
            variables[1] = -variables[1];
        }

        return variables;
    }
}
