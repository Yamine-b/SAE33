<script src="../../node_modules/chart.js"></script>


var ctx = document.getElementById('temperatureChart').getContext('2d');
var chart = new Chart(ctx, {
  type: 'line',
  data: {
    labels: <%= labels %>,
    datasets: [{
      label: 'Température',
      backgroundColor: 'rgb(255, 99, 132)',
      borderColor: 'rgb(255, 99, 132)',
      data: <%= temperatures %>
    }]
  }
});
