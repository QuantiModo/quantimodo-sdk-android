
# Correlation

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**correlationCoefficient** | [**BigDecimal**](BigDecimal.md) | Pearson correlation coefficient between cause and effect measurements | 
**cause** | **String** | ORIGINAL variable name of the cause variable for which the user desires correlations. | 
**originalCause** | **String** | original name of the cause. |  [optional]
**effect** | **String** | ORIGINAL variable name of the effect variable for which the user desires correlations. | 
**originalEffect** | **String** | effect variable original name. |  [optional]
**onsetDelay** | **Double** | User estimated or default time after cause measurement before a perceivable effect is observed | 
**durationOfAction** | [**BigDecimal**](BigDecimal.md) | Time over which the cause is expected to produce a perceivable effect following the onset delay | 
**numberOfPairs** | [**BigDecimal**](BigDecimal.md) | Number of points that went into the correlation calculation | 
**effectSize** | **String** | Magnitude of the effects of a cause indicating whether it&#39;s practically meaningful. |  [optional]
**statisticalSignificance** | **String** | A function of the effect size and sample size |  [optional]
**timestamp** | [**BigDecimal**](BigDecimal.md) | Time at which correlation was calculated | 
**reverseCorrelation** | [**BigDecimal**](BigDecimal.md) | Correlation when cause and effect are reversed. For any causal relationship, the forward correlation should exceed the reverse correlation. |  [optional]
**causalityFactor** | [**BigDecimal**](BigDecimal.md) |  |  [optional]
**causeCategory** | **String** | Variable category of the cause variable. |  [optional]
**effectCategory** | **String** | Variable category of the effect variable. |  [optional]
**valuePredictingHighOutcome** | [**BigDecimal**](BigDecimal.md) | cause value that predicts an above average effect value (in default unit for cause variable) |  [optional]
**valuePredictingLowOutcome** | [**BigDecimal**](BigDecimal.md) | cause value that predicts a below average effect value (in default unit for cause variable) |  [optional]
**optimalPearsonProduct** | [**BigDecimal**](BigDecimal.md) | Optimal Pearson Product |  [optional]
**averageVote** | [**BigDecimal**](BigDecimal.md) | Average Vote |  [optional]
**userVote** | [**BigDecimal**](BigDecimal.md) | User Vote |  [optional]
**causeUnit** | **String** | Unit of the predictor variable |  [optional]
**causeUnitId** | **Integer** | Unit Id of the predictor variable |  [optional]



