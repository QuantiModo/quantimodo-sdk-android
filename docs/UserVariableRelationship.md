
# UserVariableRelationship

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Integer** | id |  [optional]
**confidenceLevel** | **String** | Our confidence that a consistent predictive relationship exists based on the amount of evidence, reproducibility, and other factors | 
**confidenceScore** | **Float** | A quantitative representation of our confidence that a consistent predictive relationship exists based on the amount of evidence, reproducibility, and other factors | 
**direction** | **String** | Direction is positive if higher predictor values generally precede higher outcome values. Direction is negative if higher predictor values generally precede lower outcome values. | 
**durationOfAction** | **Integer** | Number of seconds over which the predictor variable event is expected to produce a perceivable effect following the onset delay | 
**errorMessage** | **String** | error_message |  [optional]
**onsetDelay** | **Integer** | User estimated (or default number of seconds) after cause measurement before a perceivable effect is observed |  [optional]
**outcomeVariableId** | **Integer** | Variable ID for the outcome variable | 
**predictorVariableId** | **Integer** | Variable ID for the predictor variable | 
**predictorUnitId** | **Integer** | ID for default unit of the predictor variable | 
**sinnRank** | **Float** | A value representative of the relevance of this predictor relative to other predictors of this outcome.  Usually used for relevancy sorting. | 
**strengthLevel** | **String** | Can be weak, medium, or strong based on the size of the effect which the predictor appears to have on the outcome relative to other variable relationship strength scores. | 
**strengthScore** | **Float** | A value represented to the size of the effect which the predictor appears to have on the outcome. | 
**userId** | **Integer** | user_id |  [optional]
**vote** | **String** | vote |  [optional]
**valuePredictingHighOutcome** | **Float** | Value for the predictor variable (in it&#39;s default unit) which typically precedes an above average outcome value | 
**valuePredictingLowOutcome** | **Float** | Value for the predictor variable (in it&#39;s default unit) which typically precedes a below average outcome value | 



