public class Population {

    Path[] paths;
    public Population(int populationSize, boolean initialise) {
        paths = new Path[populationSize];
        if (initialise) {
            for (int i = 0; i < populationSize(); i++) {
                Path newPath = new Path();
                newPath.randomizePath();
                savePath(i, newPath);
            }
        }
    }

    public Path getFittest() {
        Path fittest = paths[0];
        for (int i = 1; i < populationSize(); i++) {
            if (fittest.getFitness() <= getPath(i).getFitness()) {
                fittest = getPath(i);
            }
        }
        return fittest;
    }

    public int populationSize() {
        return paths.length;
    }

    public void savePath(int index, Path path) {
        paths[index] = path;
    }

    public Path getPath(int index) {
        return paths[index];
    }
}
