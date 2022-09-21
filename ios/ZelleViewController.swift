//
//  ZelleViewController.swift
//  FiservPOC
//
//  Created by Gatlin Carrier on 8/31/22.
//

import UIKit
import ZelleSDK


class ZelleViewController: UIViewController {
  @IBOutlet weak var viewContainer: UIView!
  
  var applicationName = ""
  var baseUrl = ""
  var institutionId = ""
  var product = ""
  var ssoKey = ""
  var parameters: NSDictionary?
  
  override func viewDidLoad() {
    super.viewDidLoad()
    print("coming inside of view controller" + applicationName)
    
    let zelle = Zelle(
                    applicationName : applicationName,
                    baseURL: baseUrl,
                    institutionId: institutionId,
                    product: product,
                    ssoKey: ssoKey,
                    parameters: parameters! as! [String: String])
    
  lazy var bridge: Bridge = {Bridge(config: zelle, viewController: self)}()
    
  let zelleFrame = CGRect(x:0, y:0, width:viewContainer.frame.width, height:viewContainer.frame.height) //desired location
    
//  let zelleView = bridge.view(frame: zelleFrame)
   let zelleView = bridge.popup(anchor: self.view)

    
  view.addSubview(zelleView) }
  
    

    
  

}
