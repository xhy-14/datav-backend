```json
data: [
        {
          value: 100,
          name: 'A'
        },
        {
          value: 200,
          name: 'B'
        },
        {
          value: 300,
          name: 'C'
        },
        {
          value: 400,
          name: 'D'
        },
        {
          value: 500,
          name: 'E'
        }
]
```

```json
option = {
  xAxis: {
    data: {{ @data }}
  },
  yAxis: {},
  series: [
    {
      data: {{ @data }},
      type: {{ @select }},
      stack: {{ @name }}
    },
    {
      data: {{ @data }},
      type: {{ @select }},
      stack: {{ @name }}
    }
  ]
};
```
