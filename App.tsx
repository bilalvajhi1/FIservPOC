/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * Generated with the TypeScript template
 * https://github.com/react-native-community/react-native-template-typescript
 *
 * @format
 */

import React, {useEffect} from 'react';
import {NativeModules} from 'react-native';
import {SafeAreaView} from 'react-native';

const App = () => {
  useEffect(() => {
    console.log('called');
    NativeModules.MyModule.NavigateToZelle(
      'Demo Bank',
      'https://certtransfers.fta.cashedge.com/popnet/faces/loginServlet',
      '88850000',
      'zelle',
      'e78abf35705a6d9b51fbf3939aa82489',
    );
  }, []);

  return <SafeAreaView />;
};

export default App;
