package config;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public interface ConfigLoader {
    void setConfig(HashMap<String, Object> configs);

    default <T extends ConfigLoader> void load(T t) throws IOException {
        File file = new File(getPath(t));
        ObjectMapper om = new ObjectMapper(new YAMLFactory());
        om.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        ConfigObject configObject = om.readValue(file, ConfigObject.class);
        HashMap<String, Object> configMap = parse(configObject, t);
        t.setConfig(configMap);
    }

    private  <T extends ConfigLoader> String getPath(T t){
        return  "src/main/resources/configs/" + t
                .getClass()
                .getName()
                .replace(".", "/")
                + ".yaml";
    }
    private <T extends ConfigLoader>  HashMap<String, Object> parse(ConfigObject config,T t ){
        HashMap<String, Object> returnObject = new HashMap<>( );

        for (ConfigObject value : config.getValues() ){
            Object object;
            switch (value.getType()){
                case NULL -> object = null;
                case string -> object = value.getData();
                case integer -> object = Integer.parseInt(value.getData());
                case bol -> object =  Boolean.parseBoolean(value.getData());
                default -> throw new IllegalStateException("unknown value: " + value.getType() + " in: " + getPath(t) + "\n Possible Types are: " + Arrays.toString(ConfigTypes.values()));
           }
            returnObject.put(value.getName(), object  );
        }
        return returnObject;
    }


}


