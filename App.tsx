/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * Generated with the TypeScript template
 * https://github.com/react-native-community/react-native-template-typescript
 *
 * @format
 */

import React from 'react';
import {NativeModules} from 'react-native';
import {Button} from 'react-native';

const App = () => {
  var c = {
    title: 'We would like to access your phone contacts',
    message:
      'We only sync phone numbers and email addresses from your contact list to help you add and pay a new recipient in Zelle ®',
  };
  //Prominent disclosure customized data for contact

  var d = {
    title: 'We would like to access your camera',
    message:
      'We only access your camera to help you add and pay a new recipient in Zelle ®',
  }; //Prominent disclosure customized data for camera

  var e = {
    title: 'We would like to access your photos',
    message:
      'We only access your photos to help you add and pay a new recipient in Zelle ®',
  }; //Prominent disclosure customized data for gallery
  var a = {pd_contact: c, pd_camera: d, pd_galley: e};
  var b = {
    param1: 'param1_value',
    param2: 'param2_value',
    param3: 'param3_value',
  }; //here you can send added key value pair data to the Zelle b.;

  const {MyModule} = NativeModules;
  const onPress = () => {
    MyModule.NavigateToZelle(
      'Demo Bank',
      'https://certtransfers.fta.cashedge.com/popnet/faces/loginServlet',
      '88151006',
      'zelle',
      'e78abf35705a6d9b51fbf3939aa82489',
      {},
      {},
      (data: any) => {
        console.log(data);
      },
    );
  };

  return (
    <Button
      title="Click to invoke your native module!"
      color="#841584"
      onPress={onPress}
    />
  );
};

export default App;
