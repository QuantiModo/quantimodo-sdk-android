
# Measurement

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**variable** | **String** | ORIGINAL Name of the variable for which we are creating the measurement records | 
**source** | **String** | Application or device used to record the measurement values | 
**startTime** | **String** | Start Time for the measurement event in ISO 8601 | 
**humanTime** | [**HumanTime**](HumanTime.md) | Start Time for the measurement event in ISO 8601 |  [optional]
**value** | **Double** | Converted measurement value in requested unit | 
**unit** | **String** | Unit of measurement as requested in GET request | 
**originalValue** | **Integer** | Original value |  [optional]
**storedValue** | **Double** | Measurement value in the unit as orignally submitted |  [optional]
**storedAbbreviatedUnitName** | **String** | Unit of measurement as originally submitted |  [optional]
**originalAbbreviatedUnitName** | **String** | Original Unit of measurement as originally submitted |  [optional]
**abbreviatedUnitName** | **String** | Unit of measurement as originally submitted |  [optional]
**note** | **String** | Note of measurement |  [optional]



