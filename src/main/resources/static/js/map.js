var myChart = echarts.init(document.getElementById('main'));

var geoCoordMap = {
    '上海': [121.4648, 31.2891],
    '东莞': [113.8953, 22.901],
    '东营': [118.7073, 37.5513]
};
// var BJData = [
//     {
//         value: 95,
//         value: 90,
//         value: 80
//     }
// ],

//var planePath = 'path://M1705.06,1318.313v-89.254l-319.9-221.799l0.073-208.063c0.521-84.662-26.629-121.796-63.961-121.491c-37.332-0.305-64.482,36.829-63.961,121.491l0.073,208.063l-319.9,221.799v89.254l330.343-157.288l12.238,241.308l-134.449,92.931l0.531,42.034l175.125-42.917l175.125,42.917l0.531-42.034l-134.449-92.931l12.238-241.308L1705.06,1318.313z';

// var convertData = function (data) {
//     var res = [];
//     for (var i = 0; i < data.length; i++) {
//         var dataItem = data[i];
//         var fromCoord = geoCoordMap[dataItem[0].name];
//         var toCoord = geoCoordMap[dataItem[1].name];
       
//         if (fromCoord && toCoord) {
//             res.push({
//                 fromName: dataItem[0].name,
//                 toName: dataItem[1].name,
//                 coords: [fromCoord, toCoord]
//             });
//         }
//     }
//     return res;
// };

var color = ['#a6c84c', '#ffa022', '#46bee9'];
var series = [];

// [['北京', BJData], ['上海', SHData], ['广州', GZData]].forEach(function (item, i) {
//     series.push({
//         name: item[0] + ' Top10',
//         type: 'lines',
//         coordinateSystem: 'bmap',
//         zlevel: 1,
//         effect: {
//             show: true,
//             period: 6,
//             trailLength: 0.7,
//             color: '#fff',
//             symbolSize: 3
//         },
//         lineStyle: {
//             normal: {
//                 color: color[i],
//                 width: 0,
//                 curveness: 0.2
//             }
//         },
//         data: convertData(item[1])
//     },
//         {
//             name: item[0] + ' Top10',
//             type: 'lines',
//             coordinateSystem: 'bmap',
//             zlevel: 2,
//             effect: {
//                 show: true,
//                 period: 6,
//                 trailLength: 0,
//                 symbol: planePath,
//                 symbolSize: 15
//             },
//             lineStyle: {
//                 normal: {
//                     color: color[i],
//                     width: 1,
//                     opacity: 0.4,
//                     curveness: 0.2
//                 }
//             },
//             data: convertData(item[1])
//         },
//         {
//             name: item[0] + ' Top10',
//             type: 'effectScatter',
//             coordinateSystem: 'bmap',
//             zlevel: 2,
//             rippleEffect: {
//                 brushType: 'stroke'
//             },
//             label: {
//                 normal: {
//                     show: true,
//                     position: 'right',
//                     formatter: '{b}'
//                 }
//             },
//             symbolSize: function (val) {
//                 return val[2] / 8;
//             },
//             itemStyle: {
//                 normal: {
//                     color: color[i]
//                 }
//             },
//             data: item[1].map(function (dataItem) {
//                 return {
//                     name: dataItem[1].name,
//                     value: geoCoordMap[dataItem[1].name].concat([dataItem[1].value])
//                 };
//             })
//         });
// });

option = {
    backgroundColor: '#404a59',
    title: {
        text: '摄像头位置模拟',
        //subtext: '数据纯属虚构',
        left: 'center',
        textStyle: {
            color: '#000000'
        }
    },
    tooltip: {
        trigger: 'item'
    },
    legend: {
        orient: 'vertical',
        top: 'bottom',
        left: 'right',
        data: ['北京 Top10', '上海 Top10', '广州 Top10'],
        textStyle: {
            color: '#000000'
        },
        selectedMode: 'single'
    },
    bmap: {
        center: [115.97, 29.71],
        zoom: 5,
        roam: true
    },
    series: geoCoordMap
};





myChart.setOption(option);