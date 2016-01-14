package io.swagger.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import io.swagger.client.model.*;

public class JsonUtil {
  public static GsonBuilder gsonBuilder;

  static {
    gsonBuilder = new GsonBuilder();
    gsonBuilder.serializeNulls();
    gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss'+'SSSS");
  }

  public static Gson getGson() {
    return gsonBuilder.create();
  }

  public static String serialize(Object obj){
    return getGson().toJson(obj);
  }

  public static <T> T deserializeToList(String jsonString, Class cls){
    return getGson().fromJson(jsonString, getListTypeForDeserialization(cls));
  }

  public static <T> T deserializeToObject(String jsonString, Class cls){
    return getGson().fromJson(jsonString, getTypeForDeserialization(cls));
  }

  public static Type getListTypeForDeserialization(Class cls) {
    String className = cls.getSimpleName();
    
    if ("MeasurementValue".equalsIgnoreCase(className)) {
      return new TypeToken<List<MeasurementValue>>(){}.getType();
    }
    
    if ("MeasurementPost".equalsIgnoreCase(className)) {
      return new TypeToken<List<MeasurementPost>>(){}.getType();
    }
    
    if ("AggregatedCorrelation".equalsIgnoreCase(className)) {
      return new TypeToken<List<AggregatedCorrelation>>(){}.getType();
    }
    
    if ("CommonVariableRelationship".equalsIgnoreCase(className)) {
      return new TypeToken<List<CommonVariableRelationship>>(){}.getType();
    }
    
    if ("Connection".equalsIgnoreCase(className)) {
      return new TypeToken<List<Connection>>(){}.getType();
    }
    
    if ("Connector".equalsIgnoreCase(className)) {
      return new TypeToken<List<Connector>>(){}.getType();
    }
    
    if ("Correlation".equalsIgnoreCase(className)) {
      return new TypeToken<List<Correlation>>(){}.getType();
    }
    
    if ("Credential".equalsIgnoreCase(className)) {
      return new TypeToken<List<Credential>>(){}.getType();
    }
    
    if ("Measurement".equalsIgnoreCase(className)) {
      return new TypeToken<List<Measurement>>(){}.getType();
    }
    
    if ("MeasurementExport".equalsIgnoreCase(className)) {
      return new TypeToken<List<MeasurementExport>>(){}.getType();
    }
    
    if ("Source".equalsIgnoreCase(className)) {
      return new TypeToken<List<Source>>(){}.getType();
    }
    
    if ("TrackingReminder".equalsIgnoreCase(className)) {
      return new TypeToken<List<TrackingReminder>>(){}.getType();
    }
    
    if ("Unit".equalsIgnoreCase(className)) {
      return new TypeToken<List<Unit>>(){}.getType();
    }
    
    if ("UnitCategory".equalsIgnoreCase(className)) {
      return new TypeToken<List<UnitCategory>>(){}.getType();
    }
    
    if ("UnitConversion".equalsIgnoreCase(className)) {
      return new TypeToken<List<UnitConversion>>(){}.getType();
    }
    
    if ("Update".equalsIgnoreCase(className)) {
      return new TypeToken<List<Update>>(){}.getType();
    }
    
    if ("UserVariable".equalsIgnoreCase(className)) {
      return new TypeToken<List<UserVariable>>(){}.getType();
    }
    
    if ("UserVariableRelationship".equalsIgnoreCase(className)) {
      return new TypeToken<List<UserVariableRelationship>>(){}.getType();
    }
    
    if ("Variable".equalsIgnoreCase(className)) {
      return new TypeToken<List<Variable>>(){}.getType();
    }
    
    if ("VariableCategory".equalsIgnoreCase(className)) {
      return new TypeToken<List<VariableCategory>>(){}.getType();
    }
    
    if ("VariableUserSource".equalsIgnoreCase(className)) {
      return new TypeToken<List<VariableUserSource>>(){}.getType();
    }
    
    if ("Vote".equalsIgnoreCase(className)) {
      return new TypeToken<List<Vote>>(){}.getType();
    }
    
    if ("InlineResponse200".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse200>>(){}.getType();
    }
    
    if ("InlineResponse2001".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse2001>>(){}.getType();
    }
    
    if ("InlineResponse2002".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse2002>>(){}.getType();
    }
    
    if ("InlineResponse2003".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse2003>>(){}.getType();
    }
    
    if ("InlineResponse2004".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse2004>>(){}.getType();
    }
    
    if ("InlineResponse2005".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse2005>>(){}.getType();
    }
    
    if ("InlineResponse2006".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse2006>>(){}.getType();
    }
    
    if ("InlineResponse2007".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse2007>>(){}.getType();
    }
    
    if ("InlineResponse2008".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse2008>>(){}.getType();
    }
    
    if ("InlineResponse2009".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse2009>>(){}.getType();
    }
    
    if ("InlineResponse20010".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse20010>>(){}.getType();
    }
    
    if ("InlineResponse20011".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse20011>>(){}.getType();
    }
    
    if ("InlineResponse20012".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse20012>>(){}.getType();
    }
    
    if ("InlineResponse20013".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse20013>>(){}.getType();
    }
    
    if ("InlineResponse20014".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse20014>>(){}.getType();
    }
    
    if ("InlineResponse20015".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse20015>>(){}.getType();
    }
    
    if ("InlineResponse20016".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse20016>>(){}.getType();
    }
    
    if ("InlineResponse20017".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse20017>>(){}.getType();
    }
    
    if ("InlineResponse20018".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse20018>>(){}.getType();
    }
    
    if ("InlineResponse20019".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse20019>>(){}.getType();
    }
    
    if ("InlineResponse20020".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse20020>>(){}.getType();
    }
    
    if ("InlineResponse20021".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse20021>>(){}.getType();
    }
    
    if ("InlineResponse20022".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse20022>>(){}.getType();
    }
    
    if ("InlineResponse20023".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse20023>>(){}.getType();
    }
    
    if ("InlineResponse20024".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse20024>>(){}.getType();
    }
    
    if ("InlineResponse20025".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse20025>>(){}.getType();
    }
    
    if ("InlineResponse20026".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse20026>>(){}.getType();
    }
    
    if ("InlineResponse20027".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse20027>>(){}.getType();
    }
    
    if ("InlineResponse20028".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse20028>>(){}.getType();
    }
    
    if ("InlineResponse20029".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse20029>>(){}.getType();
    }
    
    if ("InlineResponse20030".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse20030>>(){}.getType();
    }
    
    if ("InlineResponse20031".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse20031>>(){}.getType();
    }
    
    if ("InlineResponse20032".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse20032>>(){}.getType();
    }
    
    if ("InlineResponse20033".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse20033>>(){}.getType();
    }
    
    if ("InlineResponse20034".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse20034>>(){}.getType();
    }
    
    if ("InlineResponse20035".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse20035>>(){}.getType();
    }
    
    if ("InlineResponse20036".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse20036>>(){}.getType();
    }
    
    return new TypeToken<List<Object>>(){}.getType();
  }

  public static Type getTypeForDeserialization(Class cls) {
    String className = cls.getSimpleName();
    
    if ("MeasurementValue".equalsIgnoreCase(className)) {
      return new TypeToken<MeasurementValue>(){}.getType();
    }
    
    if ("MeasurementPost".equalsIgnoreCase(className)) {
      return new TypeToken<MeasurementPost>(){}.getType();
    }
    
    if ("AggregatedCorrelation".equalsIgnoreCase(className)) {
      return new TypeToken<AggregatedCorrelation>(){}.getType();
    }
    
    if ("CommonVariableRelationship".equalsIgnoreCase(className)) {
      return new TypeToken<CommonVariableRelationship>(){}.getType();
    }
    
    if ("Connection".equalsIgnoreCase(className)) {
      return new TypeToken<Connection>(){}.getType();
    }
    
    if ("Connector".equalsIgnoreCase(className)) {
      return new TypeToken<Connector>(){}.getType();
    }
    
    if ("Correlation".equalsIgnoreCase(className)) {
      return new TypeToken<Correlation>(){}.getType();
    }
    
    if ("Credential".equalsIgnoreCase(className)) {
      return new TypeToken<Credential>(){}.getType();
    }
    
    if ("Measurement".equalsIgnoreCase(className)) {
      return new TypeToken<Measurement>(){}.getType();
    }
    
    if ("MeasurementExport".equalsIgnoreCase(className)) {
      return new TypeToken<MeasurementExport>(){}.getType();
    }
    
    if ("Source".equalsIgnoreCase(className)) {
      return new TypeToken<Source>(){}.getType();
    }
    
    if ("TrackingReminder".equalsIgnoreCase(className)) {
      return new TypeToken<TrackingReminder>(){}.getType();
    }
    
    if ("Unit".equalsIgnoreCase(className)) {
      return new TypeToken<Unit>(){}.getType();
    }
    
    if ("UnitCategory".equalsIgnoreCase(className)) {
      return new TypeToken<UnitCategory>(){}.getType();
    }
    
    if ("UnitConversion".equalsIgnoreCase(className)) {
      return new TypeToken<UnitConversion>(){}.getType();
    }
    
    if ("Update".equalsIgnoreCase(className)) {
      return new TypeToken<Update>(){}.getType();
    }
    
    if ("UserVariable".equalsIgnoreCase(className)) {
      return new TypeToken<UserVariable>(){}.getType();
    }
    
    if ("UserVariableRelationship".equalsIgnoreCase(className)) {
      return new TypeToken<UserVariableRelationship>(){}.getType();
    }
    
    if ("Variable".equalsIgnoreCase(className)) {
      return new TypeToken<Variable>(){}.getType();
    }
    
    if ("VariableCategory".equalsIgnoreCase(className)) {
      return new TypeToken<VariableCategory>(){}.getType();
    }
    
    if ("VariableUserSource".equalsIgnoreCase(className)) {
      return new TypeToken<VariableUserSource>(){}.getType();
    }
    
    if ("Vote".equalsIgnoreCase(className)) {
      return new TypeToken<Vote>(){}.getType();
    }
    
    if ("InlineResponse200".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse200>(){}.getType();
    }
    
    if ("InlineResponse2001".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse2001>(){}.getType();
    }
    
    if ("InlineResponse2002".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse2002>(){}.getType();
    }
    
    if ("InlineResponse2003".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse2003>(){}.getType();
    }
    
    if ("InlineResponse2004".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse2004>(){}.getType();
    }
    
    if ("InlineResponse2005".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse2005>(){}.getType();
    }
    
    if ("InlineResponse2006".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse2006>(){}.getType();
    }
    
    if ("InlineResponse2007".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse2007>(){}.getType();
    }
    
    if ("InlineResponse2008".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse2008>(){}.getType();
    }
    
    if ("InlineResponse2009".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse2009>(){}.getType();
    }
    
    if ("InlineResponse20010".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse20010>(){}.getType();
    }
    
    if ("InlineResponse20011".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse20011>(){}.getType();
    }
    
    if ("InlineResponse20012".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse20012>(){}.getType();
    }
    
    if ("InlineResponse20013".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse20013>(){}.getType();
    }
    
    if ("InlineResponse20014".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse20014>(){}.getType();
    }
    
    if ("InlineResponse20015".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse20015>(){}.getType();
    }
    
    if ("InlineResponse20016".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse20016>(){}.getType();
    }
    
    if ("InlineResponse20017".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse20017>(){}.getType();
    }
    
    if ("InlineResponse20018".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse20018>(){}.getType();
    }
    
    if ("InlineResponse20019".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse20019>(){}.getType();
    }
    
    if ("InlineResponse20020".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse20020>(){}.getType();
    }
    
    if ("InlineResponse20021".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse20021>(){}.getType();
    }
    
    if ("InlineResponse20022".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse20022>(){}.getType();
    }
    
    if ("InlineResponse20023".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse20023>(){}.getType();
    }
    
    if ("InlineResponse20024".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse20024>(){}.getType();
    }
    
    if ("InlineResponse20025".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse20025>(){}.getType();
    }
    
    if ("InlineResponse20026".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse20026>(){}.getType();
    }
    
    if ("InlineResponse20027".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse20027>(){}.getType();
    }
    
    if ("InlineResponse20028".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse20028>(){}.getType();
    }
    
    if ("InlineResponse20029".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse20029>(){}.getType();
    }
    
    if ("InlineResponse20030".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse20030>(){}.getType();
    }
    
    if ("InlineResponse20031".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse20031>(){}.getType();
    }
    
    if ("InlineResponse20032".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse20032>(){}.getType();
    }
    
    if ("InlineResponse20033".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse20033>(){}.getType();
    }
    
    if ("InlineResponse20034".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse20034>(){}.getType();
    }
    
    if ("InlineResponse20035".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse20035>(){}.getType();
    }
    
    if ("InlineResponse20036".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse20036>(){}.getType();
    }
    
    return new TypeToken<Object>(){}.getType();
  }

};
