//
//  MyModule.swift
//  FiservPOC
//
//  Created by Gatlin Carrier on 8/31/22.
//

import Foundation
import ZelleSDK
import UIKit
//import React.RCTBridgeModule No such module error

@objc(MyModule)
class MyModule: NSObject
//, GenericTagDelegate // cannot find this in scope, possibly because of outdated SDK
{

  var callback: RCTResponseSenderBlock?
  @objc func NavigateToZelle(_ appName: String, baseUrl: String, instId: String, product: String, ssoKey:String, parameters: NSDictionary, pd: NSDictionary)
  {
    
 // Bridge.genericTag = self // Bridge has no member genericTag
 // self.callback = callback // assigning a property to itself
    
  NSLog("appname %@ baseUrl %@", parameters, pd);
    
  DispatchQueue.main.async {
    
  let storyboard = UIStoryboard(name: "Main", bundle: nil)
  let secondVC: ZelleViewController = storyboard.instantiateViewController(withIdentifier:
  "ZelleViewController") as! ZelleViewController
    
    secondVC.applicationName = appName
    secondVC.baseUrl = baseUrl
    secondVC.institutionId = instId
    secondVC.product = product
    secondVC.ssoKey = ssoKey
    secondVC.parameters = parameters
    
  UIApplication.shared.keyWindow?.rootViewController?.present(secondVC, animated: true, completion: nil) }
  }
//  func sessionTag(name: String) {
//    if(name != ""){
//      callback!([name]) }
//    }
}
