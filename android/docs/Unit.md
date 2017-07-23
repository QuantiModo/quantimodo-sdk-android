
# Unit

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **String** | Unit name | 
**abbreviatedName** | **String** | Unit abbreviation | 
**category** | [**CategoryEnum**](#CategoryEnum) | Unit category | 
**minimumAllowedValue** | **Double** | The minimum allowed value for measurements. While you can record a value below this minimum, it will be excluded from the correlation analysis. |  [optional]
**maximumAllowedValue** | **Double** | The maximum allowed value for measurements. While you can record a value above this maximum, it will be excluded from the correlation analysis. |  [optional]
**conversionSteps** | [**List&lt;ConversionStep&gt;**](ConversionStep.md) | Conversion steps list | 


<a name="CategoryEnum"></a>
## Enum: CategoryEnum
Name | Value
---- | -----



