package api_calls;

import org.json.JSONException;
import org.json.JSONObject;

public class CityDetails {
    
    private  String name = null;
    private  Number id = null;
    private  Number temperature = null;
    private  Number pressure = null;
    private  Number humidity = null;
    private  Number temperature_min = null;
    private  Number temperature_max = null;
    private  Number wind_speed = null;
    private  Number wind_direction = null;
    
    public CityDetails(JSONObject citydata) throws JSONException{
       
        try {
                name = (String) citydata.get("name");
                id = (Number) citydata.get("id");
                JSONObject main = (JSONObject) citydata.get("main");
                temperature = (Number) main.get("temp");
                pressure = (Number) main.get("pressure");
                humidity = (Number) main.get("humidity");
                temperature_min = (Number) main.get("temp_min");
                temperature_max = (Number) main.get("temp_max");
                JSONObject wind = (JSONObject) citydata.get("wind");
                wind_speed = (Number) wind.get("speed");
                wind_direction = (Number) wind.get("deg");
        } catch (JSONException e) {
            System.out.println("An JSONException occurred at City Details function: " + e.getMessage());
            throw e;
        }
    }
    
    public String getName(){
        return this.name;
    }
    public Number getId(){
        return this.id;
    }
    public Number getTemperature(){
        return this.temperature;
    }
    public Number getPressure(){
        return this.pressure;
    }
    public Number getHumidity(){
        return this.humidity;
    }
    public Number getMinTemperature(){
        return this.temperature_min;
    }
    public Number getMaxTemperature(){
        return this.temperature_max;
    }
    public Number getWindSpeed(){
        return this.wind_speed;
    }
    public Number getWindDirc(){
        return this.wind_direction;
    }
}
