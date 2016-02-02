/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 */
'use strict';

var Localytics = require('react-native').NativeModules.Localytics;

import React, {
  AppRegistry,
  Component,
  StyleSheet,
  TouchableHighlight,
  Text,
  View
} from 'react-native';

class AwesomeProject extends Component {
  constructor(props) {
    super(props);
  }

  _onEventPressButton() {
    Localytics.tagEvent('test123');
  }

  _onCampaignPressButton() {
    Localytics.triggerInAppMessage('testCampaign');
  }



  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>
          Welcome to React Native!
        </Text>
        <TouchableHighlight onPress={this._onEventPressButton.bind(this)}>
          <Text style={styles.button}>LL Send test123 event</Text>
        </TouchableHighlight>
        <Text style={styles.instructions}>
          To get started, edit index.ios.js
        </Text>
        <TouchableHighlight onPress={this._onCampaignPressButton.bind(this)}>
          <Text style={styles.button}>LL trigger testCampaign</Text>
        </TouchableHighlight>
        <Text style={styles.instructions}>
          Press Cmd+R to reload,{'\n'}
          Cmd+D or shake for dev menu
        </Text>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
  button: {
    textAlign: 'center',
    color: '#FFFFFF',
    paddingBottom: 5,
    paddingLeft: 5,
    paddingRight: 5,
    paddingTop: 5,
    backgroundColor: '#FF0000',
  },
});

AppRegistry.registerComponent('AwesomeProject', () => AwesomeProject);
