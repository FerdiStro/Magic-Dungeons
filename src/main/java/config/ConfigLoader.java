package config;
import bussystem.BusSystem;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import config.types.ConfigTypes;
import config.types.ScopeType;
import model.player.Movement;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public interface ConfigLoader {
    void setConfig(HashMap<String, Object> configs);

    String DEFAULT_PATH = "src/main/resources/configs/";
    String FILE_ENDING = ".yaml";



    default  <T extends  ConfigLoader> void load(T t, BusSystem busSystem, String path) throws IOException {
        File file = new File(DEFAULT_PATH+path+ FILE_ENDING);


        setConfigs(t, file, busSystem);
    }

    default <T extends ConfigLoader> void load(T t, BusSystem busSystem) throws IOException {
        File file = new File(getPath(t));
        setConfigs(t, file, busSystem);
    }

    private <T extends ConfigLoader> void setConfigs(T t, File file, BusSystem busSystem) throws IOException {
        ObjectMapper om = new ObjectMapper(new YAMLFactory());
        om.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        ConfigObject configObject = om.readValue(file, ConfigObject.class);
        HashMap<String, Object> configMap = parse(configObject, t , busSystem);
        t.setConfig(configMap);
    }


    private  <T extends ConfigLoader> String getPath(T t){
        return   DEFAULT_PATH+ t
                .getClass()
                .getName()
                .replace(".", "/")
                + FILE_ENDING;
    }
    private <T extends ConfigLoader>  HashMap<String, Object> parse(ConfigObject config,T t , BusSystem busSystem ){
        HashMap<String, Object> returnObject = new HashMap<>( );

        for (ConfigObject value : config.getValues() ){
            Object object;
            switch (value.getType()){
                case NULL -> object = null;
                case string -> object = value.getData();
                case integer -> object = Integer.parseInt(value.getData());
                case bol -> object =  Boolean.parseBoolean(value.getData());
                case pic -> object =  ImageLoader.loadImage("IMG" + value.getData());
                default -> throw new IllegalStateException("unknown value: " + value.getType() + " in: " + getPath(t) + "\n Possible Types are: " + Arrays.toString(ConfigTypes.values()));
           }
           if(ScopeType.global == value.getScope()){
               String name = value.getName();
               if (busSystem == null){
                   throw new IllegalStateException("global State is defined, so you need to add a bussystem to your model object");
               }
               switch (value.getType()){
                   case NULL    -> busSystem.save(name,null);
                   case string  -> busSystem.save(name, value.getData());
                   case integer -> busSystem.save(name, Integer.parseInt(value.getData()));
                   case bol     -> busSystem.save(name, Boolean.parseBoolean(value.getData()));
                   case pic     -> busSystem.save(name, ImageLoader.loadImage(value.getData()));

                   default -> throw new IllegalStateException("unknown value: " + value.getType() + " in: " + getPath(t) + "\n Possible Types are: " + Arrays.toString(ConfigTypes.values()));
               }
           }
            returnObject.put(value.getName(), object  );
        }
        return returnObject;
    }




}


