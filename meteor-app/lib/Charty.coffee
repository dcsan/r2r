@Charty = {}

Charty.updateChart = () ->
  lastCount = Goals.find().count()
  chart1.update()

Charty.drawChart = (elemName) ->
  console.log("show chart")
  chart = document.getElementById(elemName)
  chart.width = window.innerWidth - 20
  ctx = document.getElementById(elemName).getContext("2d")

  lastCount = Goals.find().count()

  chartData = {
      labels: ["Aug", "Sep", "Oct", "Nov", "Dec", "Jan", "Feb"],
      datasets: [
          {
              label: "data",
              fillColor: "rgba(220,220,220,0.5)",
              strokeColor: "rgba(220,220,220,0.8)",
              highlightFill: "rgba(220,220,220,0.75)",
              highlightStroke: "rgba(220,220,220,1)",
              data: [3, 5, 6, 4, 3, 4, lastCount]
          },
      ]
  }
  @chart1 = new Chart(ctx).Bar(chartData)


