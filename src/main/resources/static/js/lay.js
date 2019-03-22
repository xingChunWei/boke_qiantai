var page = 1;
var lim = 6;
$(function () {
    initLayPage(page, lim);
});
layui.use(['element', 'laypage'], function () {
    var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
    var laypage = layui.laypage;

    //完整功能
    laypage.render({
        elem: 'demo7',
        count: [[${jsonResult.count}]]
        /* ,curr: location.hash.replace('#!fenye=', '')
         ,hash: 'fenye'*/
        , layout: ['count', 'prev', 'page', 'next', 'refresh', 'skip']
        , jump: function (obj, first) {
            debugger;
            page = obj.curr;
            //lim = obj.limit;
            if (!first) {
                initLayPage(page, lim)
            }

        }
    });

});


function initLayPage(page, lim) {
    $.ajax({
        type: 'GET',
        url: '/article/wzglList',
        async: true,
        data: {'page': page, 'limit': lim,'state':1},
        dataType: 'json',
        success: function (data) {
            $(".layui-timeline").empty();//清空

            for (var i = 0; i < data.data.length; i++) {
                $(".layui-timeline").append(' <li class="layui-timeline-item" >\n' +
                    '                <i class="layui-icon layui-timeline-axis"></i>\n' +
                    '                <div class="layui-timeline-content layui-text">\n' +
                    '                    <h2 class="layui-timeline-title"><a  href=/article/wzck?id=' + data.data[i].id +
                    '                                                        class="wz_bt">' + data.data[i].title + '</a></h2>\n' +
                    '                    <p style="margin-top: 5px">\n' + content +
                    '<a href=/article/wzck?id=' + data.data[i].id + ' style="padding-left: 20px">阅读全文</a>\n' +
                    '                    </p>\n' +
                    '                    <div style="width: 100%;height: 30px;margin-top: 10px">\n' +
                    '                        <span><i class="layui-icon">&#xe66f;</i>' + data.data[i].founder + '</span>\n' +
                    '                        <span><i class="layui-icon">&#xe665;</i>' + data.data[i].creationTime + '</span>\n' +
                    '\n' +
                    '                        <div class="bj" style="float: right;padding-right: 10px"><img src="/img/ll.png"\n' +
                    '                                                                                      alt="浏览">（' + data.data[i].readNumber + '）<img\n' +
                    '                                src="/img/pl.png" alt="评论">（521）<img src="/img/dz.png" alt="点赞">（' + data.data[i].likes + '）\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    '                </div>\n' +
                    '            </li>'
                )
            }

        }
    })

}