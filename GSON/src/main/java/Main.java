import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.slf4j.*;
public class Main {

    private final static Logger logger = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args){

        String json = "{\"name\": \"hendrik\"}";
        //String json = "";
        logger.info("Application starts..");
        System.out.println(getNameFromJson(json));
        logger.info("Name: {}", getNameFromJson(json));
    }

    public static String getNameFromJson(String json){
        if(json == null) {
            throw new NullPointerException("Json ist null");
        }
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(json);
        JsonObject object = element.getAsJsonObject();
        String name = object.get("name").getAsString();

        return name;
    }
}
