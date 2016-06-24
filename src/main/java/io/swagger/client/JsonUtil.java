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
    gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
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
    
    if ("CommonResponse".equalsIgnoreCase(className)) {
      return new TypeToken<List<CommonResponse>>(){}.getType();
    }
    
    if ("Connection".equalsIgnoreCase(className)) {
      return new TypeToken<List<Connection>>(){}.getType();
    }
    
    if ("Connector".equalsIgnoreCase(className)) {
      return new TypeToken<List<Connector>>(){}.getType();
    }
    
    if ("ConnectorInfo".equalsIgnoreCase(className)) {
      return new TypeToken<List<ConnectorInfo>>(){}.getType();
    }
    
    if ("ConnectorInfoHistoryItem".equalsIgnoreCase(className)) {
      return new TypeToken<List<ConnectorInfoHistoryItem>>(){}.getType();
    }
    
    if ("ConnectorInstruction".equalsIgnoreCase(className)) {
      return new TypeToken<List<ConnectorInstruction>>(){}.getType();
    }
    
    if ("ConversionStep".equalsIgnoreCase(className)) {
      return new TypeToken<List<ConversionStep>>(){}.getType();
    }
    
    if ("Correlation".equalsIgnoreCase(className)) {
      return new TypeToken<List<Correlation>>(){}.getType();
    }
    
    if ("Credential".equalsIgnoreCase(className)) {
      return new TypeToken<List<Credential>>(){}.getType();
    }
    
    if ("HumanTime".equalsIgnoreCase(className)) {
      return new TypeToken<List<HumanTime>>(){}.getType();
    }
    
    if ("InlineResponse200".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse200>>(){}.getType();
    }
    
    if ("InlineResponse2001".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse2001>>(){}.getType();
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
    
    if ("JsonErrorResponse".equalsIgnoreCase(className)) {
      return new TypeToken<List<JsonErrorResponse>>(){}.getType();
    }
    
    if ("Measurement".equalsIgnoreCase(className)) {
      return new TypeToken<List<Measurement>>(){}.getType();
    }
    
    if ("MeasurementDelete".equalsIgnoreCase(className)) {
      return new TypeToken<List<MeasurementDelete>>(){}.getType();
    }
    
    if ("MeasurementRange".equalsIgnoreCase(className)) {
      return new TypeToken<List<MeasurementRange>>(){}.getType();
    }
    
    if ("MeasurementSet".equalsIgnoreCase(className)) {
      return new TypeToken<List<MeasurementSet>>(){}.getType();
    }
    
    if ("MeasurementSource".equalsIgnoreCase(className)) {
      return new TypeToken<List<MeasurementSource>>(){}.getType();
    }
    
    if ("Pairs".equalsIgnoreCase(className)) {
      return new TypeToken<List<Pairs>>(){}.getType();
    }
    
    if ("Permission".equalsIgnoreCase(className)) {
      return new TypeToken<List<Permission>>(){}.getType();
    }
    
    if ("PostCorrelation".equalsIgnoreCase(className)) {
      return new TypeToken<List<PostCorrelation>>(){}.getType();
    }
    
    if ("PostVote".equalsIgnoreCase(className)) {
      return new TypeToken<List<PostVote>>(){}.getType();
    }
    
    if ("TrackingReminder".equalsIgnoreCase(className)) {
      return new TypeToken<List<TrackingReminder>>(){}.getType();
    }
    
    if ("TrackingReminderDelete".equalsIgnoreCase(className)) {
      return new TypeToken<List<TrackingReminderDelete>>(){}.getType();
    }
    
    if ("TrackingReminderNotification".equalsIgnoreCase(className)) {
      return new TypeToken<List<TrackingReminderNotification>>(){}.getType();
    }
    
    if ("TrackingReminderNotificationSkip".equalsIgnoreCase(className)) {
      return new TypeToken<List<TrackingReminderNotificationSkip>>(){}.getType();
    }
    
    if ("TrackingReminderNotificationSnooze".equalsIgnoreCase(className)) {
      return new TypeToken<List<TrackingReminderNotificationSnooze>>(){}.getType();
    }
    
    if ("TrackingReminderNotificationTrack".equalsIgnoreCase(className)) {
      return new TypeToken<List<TrackingReminderNotificationTrack>>(){}.getType();
    }
    
    if ("Unit".equalsIgnoreCase(className)) {
      return new TypeToken<List<Unit>>(){}.getType();
    }
    
    if ("UnitCategory".equalsIgnoreCase(className)) {
      return new TypeToken<List<UnitCategory>>(){}.getType();
    }
    
    if ("Update".equalsIgnoreCase(className)) {
      return new TypeToken<List<Update>>(){}.getType();
    }
    
    if ("User".equalsIgnoreCase(className)) {
      return new TypeToken<List<User>>(){}.getType();
    }
    
    if ("UserTag".equalsIgnoreCase(className)) {
      return new TypeToken<List<UserTag>>(){}.getType();
    }
    
    if ("UserTokenFailedResponse".equalsIgnoreCase(className)) {
      return new TypeToken<List<UserTokenFailedResponse>>(){}.getType();
    }
    
    if ("UserTokenRequest".equalsIgnoreCase(className)) {
      return new TypeToken<List<UserTokenRequest>>(){}.getType();
    }
    
    if ("UserTokenRequestInnerUserField".equalsIgnoreCase(className)) {
      return new TypeToken<List<UserTokenRequestInnerUserField>>(){}.getType();
    }
    
    if ("UserTokenSuccessfulResponse".equalsIgnoreCase(className)) {
      return new TypeToken<List<UserTokenSuccessfulResponse>>(){}.getType();
    }
    
    if ("UserTokenSuccessfulResponseInnerUserField".equalsIgnoreCase(className)) {
      return new TypeToken<List<UserTokenSuccessfulResponseInnerUserField>>(){}.getType();
    }
    
    if ("UserVariable".equalsIgnoreCase(className)) {
      return new TypeToken<List<UserVariable>>(){}.getType();
    }
    
    if ("UserVariableRelationship".equalsIgnoreCase(className)) {
      return new TypeToken<List<UserVariableRelationship>>(){}.getType();
    }
    
    if ("UserVariables".equalsIgnoreCase(className)) {
      return new TypeToken<List<UserVariables>>(){}.getType();
    }
    
    if ("ValueObject".equalsIgnoreCase(className)) {
      return new TypeToken<List<ValueObject>>(){}.getType();
    }
    
    if ("Variable".equalsIgnoreCase(className)) {
      return new TypeToken<List<Variable>>(){}.getType();
    }
    
    if ("VariableCategory".equalsIgnoreCase(className)) {
      return new TypeToken<List<VariableCategory>>(){}.getType();
    }
    
    if ("VariableNew".equalsIgnoreCase(className)) {
      return new TypeToken<List<VariableNew>>(){}.getType();
    }
    
    if ("VariableUserSource".equalsIgnoreCase(className)) {
      return new TypeToken<List<VariableUserSource>>(){}.getType();
    }
    
    if ("VariablesNew".equalsIgnoreCase(className)) {
      return new TypeToken<List<VariablesNew>>(){}.getType();
    }
    
    if ("Vote".equalsIgnoreCase(className)) {
      return new TypeToken<List<Vote>>(){}.getType();
    }
    
    if ("VoteDelete".equalsIgnoreCase(className)) {
      return new TypeToken<List<VoteDelete>>(){}.getType();
    }
    
    return new TypeToken<List<Object>>(){}.getType();
  }

  public static Type getTypeForDeserialization(Class cls) {
    String className = cls.getSimpleName();
    
    if ("CommonResponse".equalsIgnoreCase(className)) {
      return new TypeToken<CommonResponse>(){}.getType();
    }
    
    if ("Connection".equalsIgnoreCase(className)) {
      return new TypeToken<Connection>(){}.getType();
    }
    
    if ("Connector".equalsIgnoreCase(className)) {
      return new TypeToken<Connector>(){}.getType();
    }
    
    if ("ConnectorInfo".equalsIgnoreCase(className)) {
      return new TypeToken<ConnectorInfo>(){}.getType();
    }
    
    if ("ConnectorInfoHistoryItem".equalsIgnoreCase(className)) {
      return new TypeToken<ConnectorInfoHistoryItem>(){}.getType();
    }
    
    if ("ConnectorInstruction".equalsIgnoreCase(className)) {
      return new TypeToken<ConnectorInstruction>(){}.getType();
    }
    
    if ("ConversionStep".equalsIgnoreCase(className)) {
      return new TypeToken<ConversionStep>(){}.getType();
    }
    
    if ("Correlation".equalsIgnoreCase(className)) {
      return new TypeToken<Correlation>(){}.getType();
    }
    
    if ("Credential".equalsIgnoreCase(className)) {
      return new TypeToken<Credential>(){}.getType();
    }
    
    if ("HumanTime".equalsIgnoreCase(className)) {
      return new TypeToken<HumanTime>(){}.getType();
    }
    
    if ("InlineResponse200".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse200>(){}.getType();
    }
    
    if ("InlineResponse2001".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse2001>(){}.getType();
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
    
    if ("JsonErrorResponse".equalsIgnoreCase(className)) {
      return new TypeToken<JsonErrorResponse>(){}.getType();
    }
    
    if ("Measurement".equalsIgnoreCase(className)) {
      return new TypeToken<Measurement>(){}.getType();
    }
    
    if ("MeasurementDelete".equalsIgnoreCase(className)) {
      return new TypeToken<MeasurementDelete>(){}.getType();
    }
    
    if ("MeasurementRange".equalsIgnoreCase(className)) {
      return new TypeToken<MeasurementRange>(){}.getType();
    }
    
    if ("MeasurementSet".equalsIgnoreCase(className)) {
      return new TypeToken<MeasurementSet>(){}.getType();
    }
    
    if ("MeasurementSource".equalsIgnoreCase(className)) {
      return new TypeToken<MeasurementSource>(){}.getType();
    }
    
    if ("Pairs".equalsIgnoreCase(className)) {
      return new TypeToken<Pairs>(){}.getType();
    }
    
    if ("Permission".equalsIgnoreCase(className)) {
      return new TypeToken<Permission>(){}.getType();
    }
    
    if ("PostCorrelation".equalsIgnoreCase(className)) {
      return new TypeToken<PostCorrelation>(){}.getType();
    }
    
    if ("PostVote".equalsIgnoreCase(className)) {
      return new TypeToken<PostVote>(){}.getType();
    }
    
    if ("TrackingReminder".equalsIgnoreCase(className)) {
      return new TypeToken<TrackingReminder>(){}.getType();
    }
    
    if ("TrackingReminderDelete".equalsIgnoreCase(className)) {
      return new TypeToken<TrackingReminderDelete>(){}.getType();
    }
    
    if ("TrackingReminderNotification".equalsIgnoreCase(className)) {
      return new TypeToken<TrackingReminderNotification>(){}.getType();
    }
    
    if ("TrackingReminderNotificationSkip".equalsIgnoreCase(className)) {
      return new TypeToken<TrackingReminderNotificationSkip>(){}.getType();
    }
    
    if ("TrackingReminderNotificationSnooze".equalsIgnoreCase(className)) {
      return new TypeToken<TrackingReminderNotificationSnooze>(){}.getType();
    }
    
    if ("TrackingReminderNotificationTrack".equalsIgnoreCase(className)) {
      return new TypeToken<TrackingReminderNotificationTrack>(){}.getType();
    }
    
    if ("Unit".equalsIgnoreCase(className)) {
      return new TypeToken<Unit>(){}.getType();
    }
    
    if ("UnitCategory".equalsIgnoreCase(className)) {
      return new TypeToken<UnitCategory>(){}.getType();
    }
    
    if ("Update".equalsIgnoreCase(className)) {
      return new TypeToken<Update>(){}.getType();
    }
    
    if ("User".equalsIgnoreCase(className)) {
      return new TypeToken<User>(){}.getType();
    }
    
    if ("UserTag".equalsIgnoreCase(className)) {
      return new TypeToken<UserTag>(){}.getType();
    }
    
    if ("UserTokenFailedResponse".equalsIgnoreCase(className)) {
      return new TypeToken<UserTokenFailedResponse>(){}.getType();
    }
    
    if ("UserTokenRequest".equalsIgnoreCase(className)) {
      return new TypeToken<UserTokenRequest>(){}.getType();
    }
    
    if ("UserTokenRequestInnerUserField".equalsIgnoreCase(className)) {
      return new TypeToken<UserTokenRequestInnerUserField>(){}.getType();
    }
    
    if ("UserTokenSuccessfulResponse".equalsIgnoreCase(className)) {
      return new TypeToken<UserTokenSuccessfulResponse>(){}.getType();
    }
    
    if ("UserTokenSuccessfulResponseInnerUserField".equalsIgnoreCase(className)) {
      return new TypeToken<UserTokenSuccessfulResponseInnerUserField>(){}.getType();
    }
    
    if ("UserVariable".equalsIgnoreCase(className)) {
      return new TypeToken<UserVariable>(){}.getType();
    }
    
    if ("UserVariableRelationship".equalsIgnoreCase(className)) {
      return new TypeToken<UserVariableRelationship>(){}.getType();
    }
    
    if ("UserVariables".equalsIgnoreCase(className)) {
      return new TypeToken<UserVariables>(){}.getType();
    }
    
    if ("ValueObject".equalsIgnoreCase(className)) {
      return new TypeToken<ValueObject>(){}.getType();
    }
    
    if ("Variable".equalsIgnoreCase(className)) {
      return new TypeToken<Variable>(){}.getType();
    }
    
    if ("VariableCategory".equalsIgnoreCase(className)) {
      return new TypeToken<VariableCategory>(){}.getType();
    }
    
    if ("VariableNew".equalsIgnoreCase(className)) {
      return new TypeToken<VariableNew>(){}.getType();
    }
    
    if ("VariableUserSource".equalsIgnoreCase(className)) {
      return new TypeToken<VariableUserSource>(){}.getType();
    }
    
    if ("VariablesNew".equalsIgnoreCase(className)) {
      return new TypeToken<VariablesNew>(){}.getType();
    }
    
    if ("Vote".equalsIgnoreCase(className)) {
      return new TypeToken<Vote>(){}.getType();
    }
    
    if ("VoteDelete".equalsIgnoreCase(className)) {
      return new TypeToken<VoteDelete>(){}.getType();
    }
    
    return new TypeToken<Object>(){}.getType();
  }

};
