
$.ajax({
    url: 'http://localhost:8081/teacher/grade/graph',
    type: 'GET',
    success:function (data) {
        console.log(data)
        $(function () {
            var chart = c3.generate({
                bindto: '#roated-chart1',
                data: {
                    columns: [
                        Object.values(data[0])
                    ],
                    types: {
                        "数据结构": 'bar'
                    }
                },
                axis: {
                    rotated: true,
                    x: {
                        type: 'categorized'
                    }
                }
            });
        });
        $(function () {
            var chart = c3.generate({
                bindto: '#roated-chart2',
                data: {
                    columns: [
                        Object.values(data[1])
                    ],
                    types: {
                        "操作系统": 'bar'
                    }
                },
                axis: {
                    rotated: true,
                    x: {
                        type: 'categorized'
                    }
                }
            });
        });
        $(function () {
            var chart = c3.generate({
                bindto: '#roated-chart3',
                data: {
                    columns: [
                        Object.values(data[2])
                    ],
                    types: {
                        "计算机组成原理": 'bar'
                    }
                },
                axis: {
                    rotated: true,
                    x: {
                        type: 'categorized'
                    }
                }
            });
        });
        $(function () {
            var chart = c3.generate({
                bindto: '#roated-chart4',
                data: {
                    columns: [
                        Object.values(data[3])
                    ],
                    types: {
                        "计算机网络": 'bar'
                    }
                },
                axis: {
                    rotated: true,
                    x: {
                        type: 'categorized'
                    }
                }
            });
        });
        $(function () {
            var chart = c3.generate({
                bindto: '#roated-chart5',
                data: {
                    columns: [
                        Object.values(data[4])
                    ],
                    types: {
                        "C语言程序设计": 'bar'
                    }
                },
                axis: {
                    rotated: true,
                    x: {
                        type: 'categorized'
                    }
                }
            });
        });
        $(function () {
            var chart = c3.generate({
                bindto: '#roated-chart6',
                data: {
                    columns: [
                        Object.values(data[5])
                    ],
                    types: {
                        "Java程序设计": 'bar'
                    }
                },
                axis: {
                    rotated: true,
                    x: {
                        type: 'categorized'
                    }
                }
            });
        });
    }
    }
)


