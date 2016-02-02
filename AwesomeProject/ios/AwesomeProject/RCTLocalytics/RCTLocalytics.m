#import "RCTLocalytics.h"
#import "Localytics.h"
#import "RCTConvert.h"
#import "RCTLog.h"

@implementation RCTLocalytics

RCT_EXPORT_MODULE();

RCT_EXPORT_METHOD(tagEvent:(NSString *)eventName)
{
 [Localytics tagEvent:eventName];
}

RCT_EXPORT_METHOD(tagEventWithAttr:(NSString *)eventName attributes:(NSDictionary *)attributes)
{
 [Localytics tagEvent:eventName attributes:attributes];
}

RCT_EXPORT_METHOD(tagRevenueEvent:(NSString *)eventName attributes:(NSDictionary *)attributes customerValueIncrease:(NSNumber *)customerValueIncrease)
{
 [Localytics tagEvent:eventName attributes:attributes customerValueIncrease: customerValueIncrease];
}

RCT_EXPORT_METHOD(tagScreen:(NSString *)screenName)
{
  [Localytics tagScreen:screenName];
}

RCT_EXPORT_METHOD(setCustomerId:(NSString *)customerId)
{
    [Localytics setCustomerId:customerId];
}

RCT_EXPORT_METHOD(triggerInAppMessage:(NSString *)triggerName;)
{
    [Localytics triggerInAppMessage:triggerName];
}

@end
