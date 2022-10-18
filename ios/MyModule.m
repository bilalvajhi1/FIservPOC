//
//  MyModule.m
//  FiservPOC
//
//  Created by Gatlin Carrier on 8/31/22.
//

#import <Foundation/Foundation.h>
#import "React/RCTBridgeModule.h"


@interface RCT_EXTERN_MODULE(MyModule, NSObject)

RCT_EXTERN_METHOD(NavigateToZelle: (NSString *)appName baseUrl:(NSString *)baseUrl instId:(NSString *)instId product:(NSString *)product ssoKey:(NSString *)ssoKey parameters:(NSDictionary *)parameters pd:(NSDictionary *)pd callback:(RCTResponseSenderBlock)callback)

@end


