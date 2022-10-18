#import <React/RCTBridgeDelegate.h>
#import <UIKit/UIKit.h>

@interface AppDelegate : UIResponder <UIApplicationDelegate, RCTBridgeDelegate>

@property (strong, nonatomic) UIWindow *window;

//- (void) setInitialViewController;
//- (void) goToRegisterView; // called from the RCTBridge module

@end
