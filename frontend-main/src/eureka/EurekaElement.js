import React, { Component } from "react";
import { Cookies } from "react-cookie";
import Eureka from 'eureka-js-client';

class EurekaElement extends Component {
  static client;

  constructor(props) {
    super(props);
    this.state = {
    }

    // this.initEureka();
  }

  static async initEureka() {

    // await fetch('/eureka/apps/FRONTEND-MAIN', {
    //   method: 'post',
    //   headers: new Headers({
    //     'Content-Type': 'application/json'
    //   }),
    //   body: JSON.stringify( {
    //     instance: {
    //       vipAddress: "test",
    //       leaseInfo: {
    //         evictionDurationInSecs: 90
    //       },
    //       securePort: {
    //         '$': 443,
    //         '@enabled': false
    //       },
    //       hostName: 'foo.local',
    //       secureVipAddress: null,
    //       app: 'FRONTEND-MAIN',
    //       homePageUrl: null,
    //       ipAddr: '1.1.1.1',
    //       dataCenterInfo: {
    //         '@class': 'com.netflix.appinfo.MyDataCenterInfo',
    //         name: 'MyOwn'
    //       },
    //       healthCheckUrl: null,
    //       port: {
    //         '$': 1000,
    //         '@enabled': true
    //       },
    //       statusPageUrl: null,
    //       metadata: {
    //         foo: 'bar'
    //       }
    //     }
    //   })
    // }).then(function(response) {  console.log(response); });

     this.client = await new Eureka({
       instance: {
         vipAddress: "test",
         leaseInfo: {
           evictionDurationInSecs: 90
         },
         securePort: {
           '$': 443,
           '@enabled': false
         },
         hostName: 'localhost',
         secureVipAddress: null,
         app: 'FRONTEND-MAIN',
         homePageUrl: null,
         ipAddr: '1.1.1.1',
         dataCenterInfo: {
           '@class': 'com.netflix.appinfo.MyDataCenterInfo',
           name: 'MyOwn'
         },
         healthCheckUrl: null,
         port: {
           '$': 1000,
           '@enabled': true
         },
         statusPageUrl: null,
         metadata: {
           foo: 'bar'
         }
       },

      // application instance information
      // instance: {
      //   app: 'frontend-main',
      //   hostName: 'localhost',
      //   ipAddr: '127.0.0.1',
      //   port: 3000,
      //   vipAddress: 'jq.test.something.com',
      //   // servicePath: '/eureka/apps',
      //   leaseInfo: {
      //     evictionDurationInSecs: 90
      //   },
      //   dataCenterInfo: {
      //     name: 'MyOwn',
      //   },
      // },
      eureka: {
        // eureka server host / port
        host: 'localhost',
        port: 3000,
        servicePath: '/eureka/apps/',
        fetchRegistry: true
      },
    });

    await this.client.start();
    // let ggg = await this.client.getInstancesByAppId('GUARDER');
    // console.log("ins", ggg);
  }

  // static getInstanceGuarder() {
  //   const instances = this.client.getInstancesByAppId('GUARDER');
  //   console.log("ins", instances);
  // }


}

export default EurekaElement;