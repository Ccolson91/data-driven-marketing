//var chartData = decodeHtml(chartData);
//var chartJsonArray = JSON.parse(chartData);
//
//var arrayLength = chartJsonArray.length;
//var numericData = [];
//var labelData = [];
//
//for(let i=0; i < arrayLength; i++) {
//    numericData[i] = chartJsonArray[i].value;
//    labelData[i] = chartJsonArray[i].label;
//}
//
//      const data = {
//        labels: labelData,
//        datasets: [{
//          label: 'My First dataset',
//          backgroundColor: ["#3e95cd", "8e5ea2", "#3cba9f"],
//          data: numericData,
//        }]
//      };
//
//      const config = {
//        type: 'pie',
//        data: data,
//        options: {
//            title: {
//                display: true,
//                text: 'Customers By Team Member'
//            }
//        }
//    };
//
//    new Chart(document.getElementById('myPieChart'), config);

// following code turns our cryptic jsonString data and decodes it into readable JSON to work with

//    function decodeHtml(html){
//        var txt = document.createElement("textarea");
//        txt.innerHTML = html;
//        console.log("THIS IS THE OUTPUT!!!!!!!!!!!!!!!!" + txt.value);
//        return txt.value;
//    }