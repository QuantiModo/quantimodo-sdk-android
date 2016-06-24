
# Variable

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Integer** | Variable ID |  [optional]
**name** | **String** | User-defined variable display name. | 
**originalName** | **String** | Name used when the variable was originally created in the &#x60;variables&#x60; table. | 
**category** | **String** | Variable category like Mood, Sleep, Physical Activity, Treatment, Symptom, etc. | 
**abbreviatedUnitName** | **String** | Abbreviated name of the default unit for the variable | 
**abbreviatedUnitId** | **Integer** | Id of the default unit for the variable | 
**sources** | **String** | Comma-separated list of source names to limit variables to those sources | 
**minimumValue** | **Double** | Minimum reasonable value for this variable (uses default unit) | 
**maximumValue** | **Double** | Maximum reasonable value for this variable (uses default unit) | 
**combinationOperation** | [**CombinationOperationEnum**](#CombinationOperationEnum) | Way to aggregate measurements over time. Options are \&quot;MEAN\&quot; or \&quot;SUM\&quot;.  SUM should be used for things like minutes of exercise.  If you use MEAN for exercise, then a person might exercise more minutes in one day but add separate measurements that were smaller.  So when we are doing correlational analysis, we would think that the person exercised less that day even though they exercised more.  Conversely, we must use MEAN for things such as ratings which cannot be SUMMED. | 
**fillingValue** | **Double** | Value for replacing null measurements | 
**joinWith** | **String** | The Variable this Variable should be joined with. If the variable is joined with some other variable then it is not shown to user in the list of variables. | 
**joinedVariables** | [**List&lt;Variable&gt;**](Variable.md) | Array of Variables that are joined with this Variable | 
**parent** | **Integer** | Id of the parent variable if this variable has any parent | 
**subVariables** | [**List&lt;Variable&gt;**](Variable.md) | Array of Variables that are sub variables to this Variable | 
**onsetDelay** | **Integer** | How long it takes for a measurement in this variable to take effect | 
**durationOfAction** | **Integer** | How long the effect of a measurement in this variable lasts | 
**earliestMeasurementTime** | **Integer** | Earliest measurement time | 
**latestMeasurementTime** | **Integer** | Latest measurement time | 
**updated** | **Integer** | When this variable or its settings were last updated | 
**causeOnly** | **Integer** | A value of 1 indicates that this variable is generally a cause in a causal relationship.  An example of a causeOnly variable would be a variable such as Cloud Cover which would generally not be influenced by the behaviour of the user. | 
**numberOfCorrelations** | **Integer** | Number of correlations | 
**outcome** | **Integer** | Outcome variables (those with &#x60;outcome&#x60; &#x3D;&#x3D; 1) are variables for which a human would generally want to identify the influencing factors.  These include symptoms of illness, physique, mood, cognitive performance, etc.  Generally correlation calculations are only performed on outcome variables. | 
**measurementsAtLastAnalysis** | **Integer** | The number of measurements that a given user had for this variable the last time a correlation calculation was performed. Generally correlation values are only updated once the current number of measurements for a variable is more than 10% greater than the measurementsAtLastAnalysis.  This avoids a computationally-demanding recalculation when there&#39;s not enough new data to make a significant difference in the correlation. | 
**numberOfMeasurements** | **Integer** | Number of measurements | 
**lastUnit** | **String** | Last unit | 
**lastValue** | **Integer** | Last value | 
**mostCommonValue** | **Integer** | Most common value | 
**mostCommonUnit** | **String** | Most common unit | 
**lastSource** | **Integer** | Last source | 


<a name="CombinationOperationEnum"></a>
## Enum: CombinationOperationEnum
Name | Value
---- | -----



