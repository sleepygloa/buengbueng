 $(document).ready(function () {
     "use strict";

     var chart = c3.generate({
         data: {
             columns: [
                 ['data1', 30, 200, 100, 400, 150, 250],
                 ['data2', 50, 20, 10, 40, 15, 25]
             ],
             onclick: function (d, element) {
                 console.log("onclick", d, element);
             },
             onmouseover: function (d) {
                 console.log("onmouseover", d);
             },
             onmouseout: function (d) {
                 console.log("onmouseout", d);
             },
         },
         size: {
             height: 375
         },
         title: {
             text: 'Stats 2'
         }
     });

     var chart1 = c3.generate({
         bindto: '#chart1',
         data: {
             columns: [
                 ['data1', 300, 350, 300, 0, 0, 0],
                 ['data2', 130, 100, 140, 200, 150, 50]
             ],
             type: 'area-spline'
         },
         size: {
             height: 375
         },
         title: {
             text: 'Stats 1'
         }
     });

     function generateData(n) {
         var column = ['sample'];
         for (var i = 0; i < n; i++) {
             column.push(Math.random() * 500);
         }
         return column;
     }
     var chart1 = c3.generate({
         bindto: '#chart2',
         data: {
             columns: [
                 generateData(100)
             ],
         },
         axis: {
             x: {
                 default: [30, 60]
             }
         },
         zoom: {
             enabled: true,
             onzoomstart: function (event) {
                 console.log("onzoomstart", event);
             },
             onzoomend: function (domain) {
                 console.log("onzoomend", domain);
             },
         },
         subchart: {
             show: true
         },
         size: {
             height: 375
         },
         title: {
             text: 'Stats 3'
         }
     });

     var chart_combination = c3.generate({
         bindto: '#chart_combination',
         data: {
             columns: [
                 ['data1', 30, 20, 50, 40, 60, 50],
                 ['data2', 200, 130, 90, 240, 130, 220],
                 ['data3', 300, 200, 160, 400, 250, 250],
                 ['data4', 200, 130, 90, 240, 130, 220],
                 ['data5', 130, 120, 150, 140, 160, 150],
                 ['data6', 90, 70, 20, 50, 60, 120],
             ],
             type: 'bar',
             types: {
                 data3: 'spline',
                 data4: 'line',
                 data6: 'area',
             },
             groups: [
                 ['data1', 'data2']
             ]
         }
     });


     var chart_gauge = c3.generate({
         bindto: '#chart_gauge',
         data: {
             columns: [
                 ['data', 91.4]
             ],
             type: 'gauge',
             onclick: function (d, i) {
                 console.log("onclick", d, i);
             },
             onmouseover: function (d, i) {
                 console.log("onmouseover", d, i);
             },
             onmouseout: function (d, i) {
                 console.log("onmouseout", d, i);
             }
         },
         gauge: {
             label: {
                 format: function (value, ratio) {
                     return value;
                 },
                 show: false // to turn off the min/max labels.
             },
             min: 0, // 0 is default, //can handle negative min e.g. vacuum / voltage / current flow / rate of change
             max: 100, // 100 is default
             units: ' %',
             width: 39 // for adjusting arc thickness
         },
         color: {
             pattern: ['#FF0000', '#F97600', '#F6C600', '#60B044'], // the three color levels for the percentage values.
             threshold: {
                 unit: 'value', // percentage is default
                 max: 200, // 100 is default
                 values: [30, 60, 90, 100]
             }
         },
         size: {
             height: 180
         }
     });

     setTimeout(function () {
         chart.load({
             columns: [
                 ['data', 10]
             ]
         });
     }, 1000);

     setTimeout(function () {
         chart.load({
             columns: [
                 ['data', 50]
             ]
         });
     }, 2000);

     setTimeout(function () {
         chart.load({
             columns: [
                 ['data', 70]
             ]
         });
     }, 3000);

     setTimeout(function () {
         chart.load({
             columns: [
                 ['data', 0]
             ]
         });
     }, 4000);

     setTimeout(function () {
         chart.load({
             columns: [
                 ['data', 100]
             ]
         });
     }, 5000);


 });