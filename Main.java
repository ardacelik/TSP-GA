public class Main {

    public static void main(String[] args) {

        City city1 = new City(0);
        City city2 = new City(1);
        City city3 = new City(2);
        City city4 = new City(3);
        City city5 = new City(4);
        City city6 = new City(5);
        City city7 = new City(6);
        City city8 = new City(7);
        CityRef.addCity(city1);
        CityRef.addCity(city2);
        CityRef.addCity(city3);
        CityRef.addCity(city4);
        CityRef.addCity(city5);
        CityRef.addCity(city6);
        CityRef.addCity(city7);
        CityRef.addCity(city8);

        Population pop = new Population(500, true);
        pop = GA.evolvePopulation(pop);
        for (int i = 0; i < 10000; i++) {
            pop = TSP.singleBreed(pop);
        }
        System.out.println("Final distance: " + pop.getFittest().getDistance());
        System.out.println("Path:");
        System.out.println(pop.getFittest());
    }
}
