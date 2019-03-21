import java.util.ArrayList;

public class CityRef {

    private static ArrayList cities = new ArrayList<City>();

    public static final String CITIES [] = {"Brighton", "Bristol", "Cambridge", "Glasgow", "Liverpool", "London", "Manchester", "Oxford"};

    public static final int distances [][] = {
      {0,172,145,607,329,72,312,120},
      {172,0,192,494,209,158,216,92},
      {145,192,0,490,237,75,205,100},
      {607,494,490,0,286,545,296,489},
      {329,209,237,286,0,421,49,208},
      {72,158,75,545,421,0,249,75},
      {312,216,205,296,49,249,0,194},
      {120,92,100,489,108,75,194,0}
      };

    public static void addCity(City city) {
        cities.add(city);
    }

    public static City getCity(int index){
        return (City)cities.get(index);
    }

    public static int numCities(){
        return cities.size();
    }
}
