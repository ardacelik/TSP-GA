import java.util.ArrayList;
import java.util.Collections;

public class Path{

    private ArrayList path = new ArrayList<City>();
    private double fitness = 0;
    private int distance = 0;

    public Path(){
        for (int i = 0; i < CityRef.numCities(); i++) {
            path.add(null);
        }
    }

    public void randomizePath() {
        for (int i = 0; i < CityRef.numCities(); i++) {
          setCity(i, CityRef.getCity(i));
        }
        Collections.shuffle(path);
    }

    public City getCity(int pathPosition) {
        return (City)path.get(pathPosition);
    }

    public void setCity(int pathPosition, City city) {
        path.set(pathPosition, city);
        fitness = 0;
        distance = 0;
    }

    public double getFitness() {
        if (fitness == 0) {
            fitness = 1/(double)getDistance();
        }
        return fitness;
    }

        public int pathSize() {
            return path.size();
        }

        public boolean containsCity(City city){
            return path.contains(city);
        }

    public int getDistance(){
        if (distance == 0) {
            int pathDistance = 0;
            for (int i=0; i < pathSize(); i++) {
                City originCity = getCity(i);
                City destinationCity;
                if(i+1 < pathSize()){
                    destinationCity = getCity(i+1);
                }
                else{
                    destinationCity = getCity(0);
                }
                pathDistance += originCity.distanceTo(destinationCity);
            }
            distance = pathDistance;
        }
        return distance;
    }


    @Override
    public String toString() {
        String geneString = "";
        for (int i = 0; i < pathSize(); i++) {
            geneString += getCity(i)+" => ";
        }
        return geneString;
    }
}
