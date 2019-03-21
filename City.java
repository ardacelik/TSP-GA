public class City {
    int x;
    int y;
    int id;

    public City(int x, int y){
        this.x = x;
        this.y = y;
        this.id = -1;
    }

    public City (int id){
      this.id = id;
    }

    public int getid(){
      return this.id;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public double distanceTo(City city){
      double distance = 0;
        if (this.id == -1){
        int xDistance = Math.abs(getX() - city.getX());
        int yDistance = Math.abs(getY() - city.getY());
        distance = Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) );
      }
      else{
        distance= (double)(CityRef.distances[this.id][city.getid()]);
      }
        return distance;
    }

    @Override
    public String toString(){
        if (this.id == -1){
        return getX()+", "+getY();
      }
      else{
        return "" + CityRef.CITIES[this.id];
      }
    }
}
