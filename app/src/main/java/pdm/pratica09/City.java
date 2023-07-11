package pdm.pratica09;

public class City {

    private String name;
    private String weather=null;
    public City(String name) {
        this.name = name;
        //this.weather = weather;
    }
    public String getName() {return this.name;}
    public String getWeather() {return this.weather;}

    public void setWeather(String weatherStr) {
    }
}
