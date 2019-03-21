public class TSP {

    private static final double mutationRate = 0.015;
    private static final int poolSize = 5;

        public static Path crossover(Path parent1, Path parent2) {
            Path child = new Path();
            int startPos = 0;
            int endPos = 0;

            while (!(startPos<endPos)){
            startPos = (int) (Math.random() * parent1.pathSize());
            endPos = (int) (Math.random() * parent1.pathSize());
            }

            for (int i = 0; i < child.pathSize(); i++) {
                if (startPos < endPos && i > startPos && i < endPos) {
                    child.setCity(i, parent1.getCity(i));
                }
            }

            for (int i = 0; i < parent2.pathSize(); i++) {
                if (!child.containsCity(parent2.getCity(i))) {
                    for (int ii = 0; ii < child.pathSize(); ii++) {
                        if (child.getCity(ii) == null) {
                            child.setCity(ii, parent2.getCity(i));
                            break;
                        }
                    }
                }
            }
            return child;
        }

    private static Path natSelect(Population pop) {
        Population pool = new Population(poolSize, false);
        for (int i = 0; i < poolSize; i++) {
            int randomId = (int) (Math.random() * pop.populationSize());
            pool.savePath(i, pop.getPath(randomId));
        }
        Path fittest = pool.getFittest();
        return fittest;
    }


    public static Population singleBreed(Population pop) {
        Population newPopulation = new Population(pop.populationSize(), false);

        int offset = 0;
        if (true) {
            newPopulation.savePath(0, pop.getFittest());
            offset = 1;
        }

        for (int i = offset; i < newPopulation.populationSize(); i++) {
            Path parent1 = natSelect(pop);
            Path parent2 = natSelect(pop);
            Path child = crossover(parent1, parent2);
            newPopulation.savePath(i, child);
        }

        for (int i = offset; i < newPopulation.populationSize(); i++) {
            mutate(newPopulation.getPath(i));
        }
        return newPopulation;
    }

        private static void mutate(Path path) {
            for(int i=0; i < path.pathSize(); i++){
                if(Math.random() < mutationRate){
                    int pathPos2 = (int) (path.pathSize() * Math.random());
                    City city1 = path.getCity(i);
                    City city2 = path.getCity(pathPos2);
                    path.setCity(pathPos2, city1);
                    path.setCity(i, city2);
                }
            }
        }


}
