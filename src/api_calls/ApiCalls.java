package api_calls;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

public class ApiCalls {
	
                      private final String data_sourse_url = "https://api.openweathermap.org/data/2.5/weather?q=";
                      private final String apiKey = "&appid=5b197b085c48fe52e19f36d6f22495c0";
                      
	public JSONObject fetchData(String location) throws IOException, JSONException{

		String url = data_sourse_url + location +  apiKey;
                                            System.out.println("api_calls.ApiCalls.fetchData()" + url);
                                            JSONObject json_obj=null;
		try{
                                                    json_obj = readJsonFromUrl(url);
                                            }catch(IOException e){
                                                System.out.println("An IOException occurred at fetchData function " + e.getMessage());
                                                throw e;
                                            }catch(JSONException e){
                                                System.out.println("An JSONException occurred at fetchData function " + e.getMessage());
                                                throw e;
                                            }
		return json_obj;
	}
                        
                      private static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
                          
                          InputStream input_string = new URL(url).openStream();
                          JSONObject json_obj = null;
                          try {
                                    StringBuilder string_builder = new StringBuilder();
                                    int character_pointer;
                                    BufferedReader reader = new BufferedReader(new InputStreamReader(input_string, Charset.forName("UTF-8")));
                                    while ((character_pointer = reader.read()) != -1)
                                        string_builder.append((char) character_pointer);
                                    
                                    String jsonText = string_builder.toString();
                                    json_obj = new JSONObject(jsonText);
                                }catch(IOException e){
                                    System.out.println("An IOException occurred at readJsonFromUrl function " + e.getMessage());
                                    throw e;
                                }catch(JSONException e){
                                    System.out.println("An JSONException occurred at readJsonFromUrl function " + e.getMessage());
                                    throw e;
                                }finally {
                                    input_string.close();
                                }
                          return json_obj;
                      }
}